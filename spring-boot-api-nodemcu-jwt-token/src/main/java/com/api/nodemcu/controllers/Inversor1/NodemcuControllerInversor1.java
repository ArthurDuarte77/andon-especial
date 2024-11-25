package com.api.nodemcu.controllers.Inversor1;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.inversor1.ContadorInversor1;
import com.api.nodemcu.model.inversor1.ControleGeralModelInversor1;
import com.api.nodemcu.model.inversor1.FontesModelInversor1;
import com.api.nodemcu.model.inversor1.GeralMainModelInversor1;
import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaTabletModelInversor1;
import com.api.nodemcu.model.inversor1.MainModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaTabletModelInversor1;
import com.api.nodemcu.repository.Inversor1.ControleGeralRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.FontesRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.GeralMainRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.GeralNodemcuRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.GeralRealizadoHorariaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.GeralRealizadoHorariaTabletRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.MainRepostoryInversor1;
import com.api.nodemcu.repository.Inversor1.NodemcuRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaTabletRepositoryInversor1;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/nodemcu_inversor1")
public class NodemcuControllerInversor1 {

    @Autowired
    private NodemcuRepositoryInversor1 repository;

    @Autowired
    private OperationRepositoryInversor1 operationRepository;

    @Autowired
    private MainRepostoryInversor1 mainRepostory;

    @Autowired
    ControleGeralRepositoryInversor1 controleGeralRepository;

    @Autowired
    private RealizadoHorariaRepositoryInversor1 realizadoHorariaRepository;

    @Autowired
    private RealizadoHorariaTabletRepositoryInversor1 realizadoHorariaTabletRepository;

    @Autowired
    private ContadorControllerInversor1 contadorController;

    @Autowired
    private FontesRepositoryInversor1 fontesRepository;

    @Autowired
    private GeralMainRepositoryInversor1 geralMainRepository;

    @Autowired
    private GeralNodemcuRepositoryInversor1 geralNodemcuRepository;

    @Autowired
    private GeralRealizadoHorariaRepositoryInversor1 geralRealizadoHorariaRepository;

    @Autowired
    private GeralRealizadoHorariaTabletRepositoryInversor1 geralRealizadoHorariaTabletRepository;

    boolean state = false;
    Integer anterior = 0;
    boolean isRefugo = false;
    private boolean zerouDados = false;


    private ScheduledExecutorService scheduler;

    public NodemcuControllerInversor1() {
        this.scheduler = Executors.newScheduledThreadPool(1);
        agendarTarefa();
    }

    private void agendarTarefa() {
        zerarDados();
        Runnable task = () -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (hour >= 20 & hour <= 21 && dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                zerarDados();
            }
        };

        // Agende a tarefa para ser executada a cada hora
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }


    @GetMapping()
    public List<NodemcuModelInversor1> list() throws java.text.ParseException {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    public NodemcuModelInversor1 findByName(@PathVariable String name) {
        OperationModelInversor1 operation = operationRepository.findByName(name);
        NodemcuModelInversor1 nodemcu = repository.findByNameId(operation);
        return nodemcu;
    }
    @GetMapping("/timeExcess/{name}")
    public void AddTimeExcess(@PathVariable String name){
        OperationModelInversor1 operation = operationRepository.findByName(name);
        NodemcuModelInversor1 nodemcu = repository.findByNameId(operation);
        nodemcu.setState("piscar");
        nodemcu.setTime_excess(nodemcu.getTime_excess() + 1);
        repository.save((nodemcu));
    }

    @GetMapping("/zerar")
    public void zerar(){
        zerarDados();
    }

    @GetMapping("/ajuda/{name}")
    public void AddAjuda(@PathVariable String name){
        OperationModelInversor1 operation = operationRepository.findByName(name);
        NodemcuModelInversor1 nodemcu = repository.findByNameId(operation);
        nodemcu.setState("piscar_azul");
        nodemcu.setAjuda(nodemcu.getAjuda() + 1);
        repository.save((nodemcu));
    }

    @PostMapping()
    public NodemcuModelInversor1 post(@RequestBody NodemcuModelInversor1 device) {
        repository.save(device);
        return device;
    }
    @Transactional
    @PatchMapping("/{name}")
    public NodemcuModelInversor1 patch(@PathVariable String name, @RequestBody NodemcuModelInversor1 nodemcuUpdates)
            throws IOException, InterruptedException {
        OperationModelInversor1 operation = operationRepository.findByName(name);
        NodemcuModelInversor1 device = repository.findByNameId(operation);

        
        if (device == null) {
            repository.save(nodemcuUpdates);
            return nodemcuUpdates;
        }
        
        device.setThirdlastTC(device.getSecondtlastTC());
        device.setSecondtlastTC(device.getFirtlastTC());
        device.setFirtlastTC(device.getCurrentTC());

        Float tcimposto = mainRepostory.findById(1).get().getTCimposto();
        if(nodemcuUpdates.getNameId().getName().equals("100") || nodemcuUpdates.getNameId().getName().equals("110")|| nodemcuUpdates.getNameId().getName().equals("080")|| nodemcuUpdates.getNameId().getName().equals("090")){
            tcimposto = 180F;
        }

        if (device.getShortestTC() > nodemcuUpdates.getShortestTC() && nodemcuUpdates.getShortestTC() > 10) {
            device.setShortestTC(nodemcuUpdates.getShortestTC());
        } else if (tcimposto.intValue() < nodemcuUpdates.getCurrentTC()) {
            Integer excedido = device.getQtdetcexcedido();
            excedido++;
            device.setQtdetcexcedido(excedido);
        }
        
        Integer media = (device.getTcmedio() + nodemcuUpdates.getCurrentTC()) / 2;
        
        device.setTcmedio(media);
        device.setCount(nodemcuUpdates.getCount());
        device.setState(nodemcuUpdates.getState());
        device.setCurrentTC(nodemcuUpdates.getCurrentTC());
        if (!device.getMaintenance().equals(nodemcuUpdates.getMaintenance())) {
            isRefugo = true;
            device.setMaintenance(nodemcuUpdates.getMaintenance());
        } else {
            isRefugo = false;
            try {
                RealizadoHorariaTablet(name);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao salvar o dispositivo no banco de dados", e);
            }
        }
        
        try {
            NodemcuModelInversor1 savedDevice = repository.save(device);
            if (savedDevice != null) {
                if (Integer.parseInt(nodemcuUpdates.getNameId().getName()) == 160) {
                    RealizadoHoraria();
                }
            }
            return device;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o dispositivo no banco de dados", e);
        }
    }
    
    @Transactional
    @GetMapping("/atualizarState/{name}/{state}")
    public void atualizarCor(@PathVariable("name") String name, @PathVariable("state") String state) {
        OperationModelInversor1 operation = operationRepository.findByName(name);
        if(state.equals("azul")){
            state = "verde";
        }
        repository.updateStateByNameId(state, operation.getId());
    }

    public void RealizadoHoraria() {
        Date agora = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("HH");
        Integer horaFormatada = Integer.parseInt(formatador.format(agora));
        Optional<RealizadoHorariaModelInversor1> realizado = Optional.of(new RealizadoHorariaModelInversor1());
        Integer hour = 0;
        realizado = realizadoHorariaRepository.findById(1);
        OperationModelInversor1 operation = operationRepository.findByName("160");
        NodemcuModelInversor1 device = repository.findByNameId(operation);
        switch (horaFormatada) {
            case 7:
                hour = realizado.get().getHoras7();
                hour++;
                realizado.get().setHoras7(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 8:
                hour = realizado.get().getHoras8();
                hour++;
                realizado.get().setHoras8(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 9:
                hour = realizado.get().getHoras9();
                hour++;
                realizado.get().setHoras9(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 10:
                hour = realizado.get().getHoras10();
                hour++;
                realizado.get().setHoras10(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 11:
                hour = realizado.get().getHoras11();
                hour++;
                realizado.get().setHoras11(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 12:
                hour = realizado.get().getHoras12();
                hour++;
                realizado.get().setHoras12(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 13:
                hour = realizado.get().getHoras13();
                hour++;
                realizado.get().setHoras13(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 14:
                hour = realizado.get().getHoras14();
                hour++;
                realizado.get().setHoras14(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 15:
                hour = realizado.get().getHoras15();
                hour++;
                realizado.get().setHoras15(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 16:
                hour = realizado.get().getHoras16();
                hour++;
                realizado.get().setHoras16(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;

            case 17:
                hour = realizado.get().getHoras17();
                hour++;
                realizado.get().setHoras17(hour);
                realizadoHorariaRepository.save(realizado.get());
                break;
        }
        device.setCount(realizadoHorariaRepository.somarTudo());
        repository.save(device);
    }

    public void RealizadoHorariaTablet(String name) {
        
        Date agora = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("HH");
        Integer horaFormatada = Integer.parseInt(formatador.format(agora));
        RealizadoHorariaTabletModelInversor1 realizado = new RealizadoHorariaTabletModelInversor1();
        Integer hour = 0;
        OperationModelInversor1 operation = operationRepository.findByName(name);
        realizado = realizadoHorariaTabletRepository.findByNameId(operation);
        NodemcuModelInversor1 device = repository.findByNameId(operation);
        
        switch (horaFormatada) {
            case 7:
                hour = realizado.getHoras7();
                hour++;
                realizado.setHoras7(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 8:
                hour = realizado.getHoras8();
                hour++;
                realizado.setHoras8(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 9:
                hour = realizado.getHoras9();
                hour++;
                realizado.setHoras9(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 10:
                hour = realizado.getHoras10();
                hour++;
                realizado.setHoras10(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 11:
                hour = realizado.getHoras11();
                hour++;
                realizado.setHoras11(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 12:
                hour = realizado.getHoras12();
                hour++;
                realizado.setHoras12(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 13:
                hour = realizado.getHoras13();
                hour++;
                realizado.setHoras13(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 14:
                hour = realizado.getHoras14();
                hour++;
                realizado.setHoras14(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 15:
                hour = realizado.getHoras15();
                hour++;
                realizado.setHoras15(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 16:
                hour = realizado.getHoras16();
                hour++;
                realizado.setHoras16(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;

            case 17:
                hour = realizado.getHoras17();
                hour++;
                realizado.setHoras17(hour);
                realizadoHorariaTabletRepository.save(realizado);
                break;
        }
         device.setCount(realizadoHorariaTabletRepository.somarTudo(realizado.getId()));
         repository.save(device);
    }

    @Transactional
    @GetMapping("/atualizarTempo/{name}/{tempo}")
    public void iniciarTempo(@PathVariable("name") String name, @PathVariable("tempo") Integer tempo) {
        OperationModelInversor1 operation = operationRepository.findByName(name);
        repository.updateLocalTCByNameId(tempo, operation.getId());
    }


    public void zerarDados() {
        if (zerouDados) {
            try{
                FontesModelInversor1 fonteAtual = new FontesModelInversor1();
                List<FontesModelInversor1> fontes = fontesRepository.findAll();

                for(FontesModelInversor1 fonte: fontes){
                    if (fonte.getIs_current()){
                        fonteAtual = fonte;
                    }
                }
                OperationModelInversor1 operations = operationRepository.findByName("160");
                NodemcuModelInversor1 nodemcuResultadoGeral = repository.findByNameId(operations);
                Optional<MainModelInversor1> main = mainRepostory.findById(1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                String formattedDate = dateFormat.format(currentDate);
                List<ControleGeralModelInversor1> controleGeral = controleGeralRepository.findByDataBetween(formattedDate, formattedDate);
                controleGeral.get(0).setRealizado(nodemcuResultadoGeral.getCount());
                controleGeral.get(0).setModelo(fonteAtual.getModelo());
                controleGeralRepository.save(controleGeral.get(0));

                GeralMainModelInversor1 geralMain = new GeralMainModelInversor1();
                geralMain.setImposto((int) Math.floor(main.get().getImposto()));
                geralMain.setOp(main.get().getOp());
                geralMain.setShiftTime(main.get().getShiftTime());
                geralMain.setTCimposto(main.get().getTCimposto());
                geralMainRepository.save(geralMain);

                Optional<RealizadoHorariaModelInversor1> realizadoHoraria = realizadoHorariaRepository.findById(1);
                GeralRealizadoHorariaModelInversor1 geralRealizado = new GeralRealizadoHorariaModelInversor1();
                geralRealizado.setHoras7(realizadoHoraria.get().getHoras7());
                geralRealizado.setHoras8(realizadoHoraria.get().getHoras8());
                geralRealizado.setHoras9(realizadoHoraria.get().getHoras9());
                geralRealizado.setHoras10(realizadoHoraria.get().getHoras10());
                geralRealizado.setHoras11(realizadoHoraria.get().getHoras11());
                geralRealizado.setHoras12(realizadoHoraria.get().getHoras12());
                geralRealizado.setHoras13(realizadoHoraria.get().getHoras13());
                geralRealizado.setHoras14(realizadoHoraria.get().getHoras14());
                geralRealizado.setHoras15(realizadoHoraria.get().getHoras15());
                geralRealizado.setHoras16(realizadoHoraria.get().getHoras16());
                geralRealizado.setHoras17(realizadoHoraria.get().getHoras17());
                geralRealizadoHorariaRepository.save(geralRealizado);

                List<RealizadoHorariaTabletModelInversor1> realizadoHorariaTablet = realizadoHorariaTabletRepository.findAll();
                realizadoHorariaTablet.forEach(elemento -> {
                    GeralRealizadoHorariaTabletModelInversor1 geralRealizadoHorariaTablet = new GeralRealizadoHorariaTabletModelInversor1();
                    geralRealizadoHorariaTablet.setNameId(elemento.getNameId());
                    geralRealizadoHorariaTablet.setHoras7(elemento.getHoras7());
                    geralRealizadoHorariaTablet.setHoras8(elemento.getHoras8());
                    geralRealizadoHorariaTablet.setHoras9(elemento.getHoras9());
                    geralRealizadoHorariaTablet.setHoras10(elemento.getHoras10());
                    geralRealizadoHorariaTablet.setHoras11(elemento.getHoras11());
                    geralRealizadoHorariaTablet.setHoras12(elemento.getHoras12());
                    geralRealizadoHorariaTablet.setHoras13(elemento.getHoras13());
                    geralRealizadoHorariaTablet.setHoras14(elemento.getHoras14());
                    geralRealizadoHorariaTablet.setHoras15(elemento.getHoras15());
                    geralRealizadoHorariaTablet.setHoras16(elemento.getHoras16());
                    geralRealizadoHorariaTablet.setHoras17(elemento.getHoras17());
                    geralRealizadoHorariaTabletRepository.save(geralRealizadoHorariaTablet);
                });

                List<OperationModelInversor1> operation = operationRepository.findAll();
                operation.forEach(element -> {
                    NodemcuModelInversor1 nodemcuResultado = repository.findByNameId(element);
                    GeralNodemcuModelInversor1 nodemcu = new GeralNodemcuModelInversor1();
                    nodemcu.setAjuda(nodemcuResultado.getAjuda());
                    nodemcu.setAnalise(nodemcuResultado.getAnalise());
                    nodemcu.setCount(nodemcuResultado.getCount());
                    nodemcu.setCurrentTC(nodemcuResultado.getCurrentTC());
                    nodemcu.setFirtlastTC(nodemcuResultado.getFirtlastTC());
                    nodemcu.setMaintenance(nodemcuResultado.getMaintenance());
                    nodemcu.setNameId(nodemcuResultado.getNameId());
                    nodemcu.setQtdetcexcedido(nodemcuResultado.getQtdetcexcedido());
                    nodemcu.setSecondtlastTC(nodemcuResultado.getSecondtlastTC());
                    nodemcu.setShortestTC(nodemcuResultado.getShortestTC());
                    nodemcu.setState(nodemcuResultado.getState());
                    nodemcu.setTcmedio(nodemcuResultado.getTcmedio());
                    nodemcu.setThirdlastTC(nodemcuResultado.getThirdlastTC());
                    nodemcu.setTime_excess(nodemcuResultado.getTime_excess());
                    geralNodemcuRepository.save(nodemcu);
                });
                
                Optional<RealizadoHorariaModelInversor1> realizadoReset = realizadoHorariaRepository.findById(1);
                realizadoReset.ifPresent(reset -> {
                    reset.setHoras12(0);
                    reset.setHoras11(0);
                    reset.setHoras10(0);
                    reset.setHoras9(0);
                    reset.setHoras8(0);
                    reset.setHoras7(0);
                    reset.setHoras13(0);
                    reset.setHoras14(0);
                    reset.setHoras15(0);
                    reset.setHoras17(0);
                    reset.setHoras16(0);
                    realizadoHorariaRepository.save(reset);
                });
                List<NodemcuModelInversor1> nodemcuList = repository.findAll();
                for (NodemcuModelInversor1 nodemcu : nodemcuList) {
                    nodemcu.setCurrentTC(0);
                    nodemcu.setCount(0);
                    nodemcu.setFirtlastTC(0);
                    nodemcu.setSecondtlastTC(0);
                    nodemcu.setThirdlastTC(0);
                    nodemcu.setState("verde");
                    nodemcu.setMaintenance(0);
                    nodemcu.setQtdetcexcedido(0);
                    nodemcu.setTcmedio(0);
                    nodemcu.setShortestTC(9999);
                    nodemcu.setCount(0);
                    contadorController.atualizarTempo(nodemcu.getContador().getId(), false);
                    ContadorInversor1 contador = nodemcu.getContador();
                    contador.setContadorAtual(0);
                    contador.setIs_couting(false);
                    nodemcu.setTime_excess(0);
                    nodemcu.setAnalise(0);
                    nodemcu.setAjuda(0);
                    repository.save(nodemcu);
                }

                List<RealizadoHorariaTabletModelInversor1> realizadoList = realizadoHorariaTabletRepository.findAll();
                for (RealizadoHorariaTabletModelInversor1 realizado : realizadoList) {
                    realizado.setHoras7(0);
                    realizado.setHoras8(0);
                    realizado.setHoras9(0);
                    realizado.setHoras10(0);
                    realizado.setHoras11(0);
                    realizado.setHoras12(0);
                    realizado.setHoras13(0);
                    realizado.setHoras14(0);
                    realizado.setHoras15(0);
                    realizado.setHoras16(0);
                    realizado.setHoras17(0);
                    realizadoHorariaTabletRepository.save(realizado);
                }
                for (OperationModelInversor1 op : operation) {
                    op.setOcupado(false);
                    operationRepository.save(op);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            zerouDados = false;
        } else {
            zerouDados = true;
        }
        }
    }
