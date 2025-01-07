package com.api.nodemcu.Services;

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
import org.springframework.stereotype.Service;

import com.api.nodemcu.controllers.controle.ContadorControllerControle;
import com.api.nodemcu.model.controle.ContadorControle;
import com.api.nodemcu.model.controle.ControleGeralModelControle;
import com.api.nodemcu.model.controle.FontesModelControle;
import com.api.nodemcu.model.controle.GeralCiclosModelControle;
import com.api.nodemcu.model.controle.GeralMainModelControle;
import com.api.nodemcu.model.controle.GeralNodemcuModelControle;
import com.api.nodemcu.model.controle.GeralRealizadoHorariaModelControle;
import com.api.nodemcu.model.controle.GeralRealizadoHorariaTabletModelControle;
import com.api.nodemcu.model.controle.MainModelControle;
import com.api.nodemcu.model.controle.NodemcuModelControle;
import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.RealizadoHorariaModelControle;
import com.api.nodemcu.model.controle.RealizadoHorariaTabletModelControle;
import com.api.nodemcu.repository.controle.ControleGeralRepositoryControle;
import com.api.nodemcu.repository.controle.FontesRepositoryControle;
import com.api.nodemcu.repository.controle.GeralCicloRepositoryControle;
import com.api.nodemcu.repository.controle.GeralMainRepositoryControle;
import com.api.nodemcu.repository.controle.GeralNodemcuRepositoryControle;
import com.api.nodemcu.repository.controle.GeralRealizadoHorariaRepositoryControle;
import com.api.nodemcu.repository.controle.GeralRealizadoHorariaTabletRepositoryControle;
import com.api.nodemcu.repository.controle.MainRepostoryControle;
import com.api.nodemcu.repository.controle.NodemcuRepositoryControle;
import com.api.nodemcu.repository.controle.OperationRepositoryControle;
import com.api.nodemcu.repository.controle.RealizadoHorariaRepositoryControle;
import com.api.nodemcu.repository.controle.RealizadoHorariaTabletRepositoryControle;

import jakarta.transaction.Transactional;

@Service
public class NodemcuServiceControle {
    private final NodemcuRepositoryControle repository;
    private final OperationRepositoryControle operationRepository;
    private final MainRepostoryControle mainRepostory;
    private final ControleGeralRepositoryControle controleGeralRepository;
    private final RealizadoHorariaRepositoryControle realizadoHorariaRepository;
    private final RealizadoHorariaTabletRepositoryControle realizadoHorariaTabletRepository;
    private final ContadorControllerControle contadorController;
    private final FontesRepositoryControle fontesRepository;
    private final GeralMainRepositoryControle geralMainRepository;
    private final GeralNodemcuRepositoryControle geralNodemcuRepository;
    private final GeralRealizadoHorariaRepositoryControle geralRealizadoHorariaRepository;
    private final GeralRealizadoHorariaTabletRepositoryControle geralRealizadoHorariaTabletRepository;
    private final GeralCicloRepositoryControle geralCicloRepository;

    private final ScheduledExecutorService scheduler;

    @Autowired
    public NodemcuServiceControle(NodemcuRepositoryControle repository, OperationRepositoryControle operationRepository,
            MainRepostoryControle mainRepostory,
            ControleGeralRepositoryControle controleGeralRepository, RealizadoHorariaRepositoryControle realizadoHorariaRepository,
            RealizadoHorariaTabletRepositoryControle realizadoHorariaTabletRepository, ContadorControllerControle contadorController,
            FontesRepositoryControle fontesRepository, GeralMainRepositoryControle geralMainRepository,
            GeralNodemcuRepositoryControle geralNodemcuRepository,
            GeralRealizadoHorariaRepositoryControle geralRealizadoHorariaRepository,
            GeralRealizadoHorariaTabletRepositoryControle geralRealizadoHorariaTabletRepository,
            GeralCicloRepositoryControle geralCicloRepository) {
        this.repository = repository;
        this.operationRepository = operationRepository;
        this.mainRepostory = mainRepostory;
        this.controleGeralRepository = controleGeralRepository;
        this.realizadoHorariaRepository = realizadoHorariaRepository;
        this.realizadoHorariaTabletRepository = realizadoHorariaTabletRepository;
        this.contadorController = contadorController;
        this.fontesRepository = fontesRepository;
        this.geralMainRepository = geralMainRepository;
        this.geralNodemcuRepository = geralNodemcuRepository;
        this.geralRealizadoHorariaRepository = geralRealizadoHorariaRepository;
        this.geralRealizadoHorariaTabletRepository = geralRealizadoHorariaTabletRepository;
        this.geralCicloRepository = geralCicloRepository;

        this.scheduler = Executors.newScheduledThreadPool(1);
        agendarTarefa();
    }

    private void agendarTarefa() {
        Runnable task = () -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (hour >= 20 & hour <= 21 && dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                zerarDados();
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }

    public List<NodemcuModelControle> listAll() {
        return repository.findAll();
    }

    public NodemcuModelControle findByName(String name) {
        OperationModelControle operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }

    public void addTimeExcess(String name) {
        OperationModelControle operation = operationRepository.findByName(name);
        NodemcuModelControle nodemcu = repository.findByNameId(operation);
        nodemcu.setState("piscar");
        nodemcu.setTime_excess(nodemcu.getTime_excess() + 1);
        repository.save((nodemcu));
    }

    public void addAjuda(String name) {
        OperationModelControle operation = operationRepository.findByName(name);
        NodemcuModelControle nodemcu = repository.findByNameId(operation);
        nodemcu.setState("piscar_azul");
        nodemcu.setAjuda(nodemcu.getAjuda() + 1);
        repository.save((nodemcu));
    }

    public NodemcuModelControle save(NodemcuModelControle device) {
        return repository.save(device);
    }

    @Transactional
    public NodemcuModelControle update(String name, NodemcuModelControle nodemcuUpdates)
            throws IOException, InterruptedException {
        OperationModelControle operation = operationRepository.findByName(name);
        NodemcuModelControle device = repository.findByNameId(operation);

        if (device == null) {
            return repository.save(nodemcuUpdates);
        }
        
        FontesModelControle fonteAtual = fontesRepository.findAll().stream()
        .filter(FontesModelControle::getIs_current)
        .findFirst()
        .orElse(null);
        saveGeralCiclo(nodemcuUpdates, operation, fonteAtual);

        updateTcHistory(device, nodemcuUpdates);

        updateTcExceeded(device, nodemcuUpdates);

        
        device.setTcmedio((device.getTcmedio() + nodemcuUpdates.getCurrentTC()) / 2);
        device.setCount(nodemcuUpdates.getCount());
        device.setState(nodemcuUpdates.getState());
        device.setCurrentTC(nodemcuUpdates.getCurrentTC());

        
        if (!device.getMaintenance().equals(nodemcuUpdates.getMaintenance())) {
            device.setMaintenance(nodemcuUpdates.getMaintenance());
        } else {
            try {
                realizadoHorariaTablet(name, fonteAtual);
            } catch (Exception e) {
                throw new RuntimeException("Error saving device to database", e);
            }
        }
        
        NodemcuModelControle savedDevice = repository.save(device);
        if (savedDevice != null) {
            if (Integer.parseInt(nodemcuUpdates.getNameId().getName()) == 20) {
                countFontes(fonteAtual);  
                realizadoHoraria(fonteAtual);
            }
        }

        return device;
    }

    private void countFontes(FontesModelControle fonteAtual) {
        if (fonteAtual != null) {
            int countAdd = 1;
            if(fonteAtual.getModelo().equals("k600") || fonteAtual.getModelo().equals("k1200")){
                countAdd = 10;
            }else{
                countAdd = 1;
            }
            fonteAtual.setRealizado(fonteAtual.getRealizado() + countAdd);
            fontesRepository.save(fonteAtual);
        }
    }

    private void saveGeralCiclo(NodemcuModelControle nodemcuUpdates, OperationModelControle operation, FontesModelControle fonteAtual) {
        GeralCiclosModelControle geralCiclo = new GeralCiclosModelControle();
        int countAdd = 0;
        if(fonteAtual.getModelo().equals("k600") || fonteAtual.getModelo().equals("k1200") && operation.getName().equals("020")){
            countAdd = 9;
        }else{
            countAdd = 0;
        }
        geralCiclo.setCount(nodemcuUpdates.getCount() + countAdd);
        geralCiclo.setData(new Date());
        geralCiclo.setNameId(operation);
        geralCiclo.setTime(nodemcuUpdates.getCurrentTC());
        geralCicloRepository.save(geralCiclo);
    }

    private void updateTcHistory(NodemcuModelControle device, NodemcuModelControle nodemcuUpdates) {
        device.setThirdlastTC(device.getSecondtlastTC());
        device.setSecondtlastTC(device.getFirtlastTC());
        device.setFirtlastTC(nodemcuUpdates.getCurrentTC());
    }

    private void updateTcExceeded(NodemcuModelControle device, NodemcuModelControle nodemcuUpdates) {
        Float tcimposto = mainRepostory.findById(1).get().getTCimposto();
        if (device.getShortestTC() > nodemcuUpdates.getShortestTC() && nodemcuUpdates.getShortestTC() > 10) {
            device.setShortestTC(nodemcuUpdates.getShortestTC());
        } else if (tcimposto.intValue() < nodemcuUpdates.getCurrentTC()) {
            device.setQtdetcexcedido(device.getQtdetcexcedido() + 1);
        }
    }

    @Transactional
    public void updateState(String name, String state) {
        OperationModelControle operation = operationRepository.findByName(name);
        if (state.equals("azul")) {
            state = "verde";
        }
        repository.updateStateByNameId(state, operation.getId());
    }

    private void realizadoHoraria(FontesModelControle fonteAtual) {
        Date now = new Date();
        int currentHour = getHour(now);
        Optional<RealizadoHorariaModelControle> realizado = realizadoHorariaRepository.findById(1);
        if (!realizado.isPresent()) {
            return;
        }
        int countAdd = 1;
        if(fonteAtual.getModelo().equals("k600") || fonteAtual.getModelo().equals("k1200")){
            countAdd = 10;
        }else{
            countAdd = 1;
        }
        int hour;
        switch (currentHour) {
            case 7:
                hour = realizado.get().getHoras7();
                realizado.get().setHoras7(hour + countAdd);
                break;
            case 8:
                hour = realizado.get().getHoras8();
                realizado.get().setHoras8(hour + countAdd);
                break;
            case 9:
                hour = realizado.get().getHoras9();
                realizado.get().setHoras9(hour + countAdd);
                break;
            case 10:
                hour = realizado.get().getHoras10();
                realizado.get().setHoras10(hour + countAdd);
                break;
            case 11:
                hour = realizado.get().getHoras11();
                realizado.get().setHoras11(hour + countAdd);
                break;
            case 12:
                hour = realizado.get().getHoras12();
                realizado.get().setHoras12(hour + countAdd);
                break;
            case 13:
                hour = realizado.get().getHoras13();
                realizado.get().setHoras13(hour + countAdd);
                break;
            case 14:
                hour = realizado.get().getHoras14();
                realizado.get().setHoras14(hour + countAdd);
                break;
            case 15:
                hour = realizado.get().getHoras15();
                realizado.get().setHoras15(hour + countAdd);
                break;
            case 16:
                hour = realizado.get().getHoras16();
                realizado.get().setHoras16(hour + countAdd);
                break;
            case 17:
                hour = realizado.get().getHoras17();
                realizado.get().setHoras17(hour + countAdd);
                break;
            default:
                return;

        }
        realizadoHorariaRepository.save(realizado.get());
        OperationModelControle operation = operationRepository.findByName("020");
        NodemcuModelControle device = repository.findByNameId(operation);
        device.setCount(realizadoHorariaRepository.somarTudo());
        repository.save(device);

    }

    private void realizadoHorariaTablet(String name, FontesModelControle fonteAtual) {
        Date now = new Date();
        int currentHour = getHour(now);
        OperationModelControle operation = operationRepository.findByName(name);
        RealizadoHorariaTabletModelControle realizado = realizadoHorariaTabletRepository.findByNameId(operation);
        if (realizado == null) {
            return;
        }
        int countAdd = 1;
        if((fonteAtual.getModelo().equals("k600") || fonteAtual.getModelo().equals("k1200")) && name.equals("020")){
            countAdd = 10;
        }else{
            countAdd = 1;
        }
        int hour;
        switch (currentHour) {
            case 7:
                hour = realizado.getHoras7();
                realizado.setHoras7(hour + countAdd);
                break;
            case 8:
                hour = realizado.getHoras8();
                realizado.setHoras8(hour + countAdd);
                break;
            case 9:
                hour = realizado.getHoras9();
                realizado.setHoras9(hour + countAdd);
                break;
            case 10:
                hour = realizado.getHoras10();
                realizado.setHoras10(hour + countAdd);
                break;
            case 11:
                hour = realizado.getHoras11();
                realizado.setHoras11(hour + countAdd);
                break;
            case 12:
                hour = realizado.getHoras12();
                realizado.setHoras12(hour + countAdd);
                break;
            case 13:
                hour = realizado.getHoras13();
                realizado.setHoras13(hour + countAdd);
                break;
            case 14:
                hour = realizado.getHoras14();
                realizado.setHoras14(hour + countAdd);
                break;
            case 15:
                hour = realizado.getHoras15();
                realizado.setHoras15(hour + countAdd);
                break;
            case 16:
                hour = realizado.getHoras16();
                realizado.setHoras16(hour + countAdd);
                break;
            case 17:
                hour = realizado.getHoras17();
                realizado.setHoras17(hour + countAdd);
                break;
            default:
                return;
        }
        realizadoHorariaTabletRepository.save(realizado);
        NodemcuModelControle device = repository.findByNameId(operation);
        device.setCount(realizadoHorariaTabletRepository.somarTudo(realizado.getId()));
        repository.save(device);
    }

    private int getHour(Date date) {
        SimpleDateFormat formatador = new SimpleDateFormat("HH");
        return Integer.parseInt(formatador.format(date));
    }

    @Transactional
    public void updateLocalTC(String name, Integer tempo) {
        OperationModelControle operation = operationRepository.findByName(name);
        repository.updateLocalTCByNameId(tempo, operation.getId());
    }


    public void zerarDados() {
        if (true) {
            try {

                FontesModelControle fonteAtual = fontesRepository.findAll().stream()
                        .filter(FontesModelControle::getIs_current)
                        .findFirst()
                        .orElse(null);

                OperationModelControle operations = operationRepository.findByName("020");
                NodemcuModelControle nodemcuResultadoGeral = repository.findByNameId(operations);
                Optional<MainModelControle> main = mainRepostory.findById(1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                String formattedDate = dateFormat.format(currentDate);
                List<ControleGeralModelControle> controleGeral = controleGeralRepository.findByDataBetween(formattedDate,
                        formattedDate);
                controleGeral.get(0).setRealizado(nodemcuResultadoGeral.getCount());
                controleGeral.get(0).setModelo(fonteAtual.getModelo());
                controleGeralRepository.save(controleGeral.get(0));
                GeralMainModelControle geralMain = new GeralMainModelControle();
                geralMain.setImposto((int) Math.floor(main.get().getImposto()));
                geralMain.setOp(main.get().getOp());
                geralMain.setShiftTime(main.get().getShiftTime());
                geralMain.setTCimposto(main.get().getTCimposto());
                geralMainRepository.save(geralMain);

                Optional<RealizadoHorariaModelControle> realizadoHoraria = realizadoHorariaRepository.findById(1);
                if (realizadoHoraria.isPresent()) {
                    GeralRealizadoHorariaModelControle geralRealizado = new GeralRealizadoHorariaModelControle();
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
                }

                List<RealizadoHorariaTabletModelControle> realizadoHorariaTablet = realizadoHorariaTabletRepository.findAll();
                realizadoHorariaTablet.forEach(elemento -> {
                    GeralRealizadoHorariaTabletModelControle geralRealizadoHorariaTablet = new GeralRealizadoHorariaTabletModelControle();
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

                List<OperationModelControle> operation = operationRepository.findAll();
                operation.forEach(element -> {
                    NodemcuModelControle nodemcuResultado = repository.findByNameId(element);
                    GeralNodemcuModelControle nodemcu = new GeralNodemcuModelControle();
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
                Optional<RealizadoHorariaModelControle> realizadoReset = realizadoHorariaRepository.findById(1);
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
                List<NodemcuModelControle> nodemcuList = repository.findAll();
                for (NodemcuModelControle nodemcu : nodemcuList) {
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
                    ContadorControle contador = nodemcu.getContador();
                    contador.setContadorAtual(0);
                    contador.setIs_couting(false);
                    nodemcu.setTime_excess(0);
                    nodemcu.setAnalise(0);
                    nodemcu.setAjuda(0);
                    repository.save(nodemcu);
                }
                List<RealizadoHorariaTabletModelControle> realizadoList = realizadoHorariaTabletRepository.findAll();
                for (RealizadoHorariaTabletModelControle realizado : realizadoList) {
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
                for (OperationModelControle op : operation) {
                    op.setOcupado(false);
                    operationRepository.save(op);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}