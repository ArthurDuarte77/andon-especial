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

import com.api.nodemcu.controllers.gerenciaveis.ContadorControllerGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.ContadorGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.ControleGeralModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.FontesModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.GeralCiclosModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.GeralMainModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.GeralNodemcuModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.GeralRealizadoHorariaModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.GeralRealizadoHorariaTabletModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.MainModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.NodemcuModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.RealizadoHorariaModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.RealizadoHorariaTabletModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.ControleGeralRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.FontesRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralCicloRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralMainRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralNodemcuRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralRealizadoHorariaRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralRealizadoHorariaTabletRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.MainRepostoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.NodemcuRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.OperationRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.RealizadoHorariaRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.RealizadoHorariaTabletRepositoryGerenciaveis;

import jakarta.transaction.Transactional;

@Service
public class NodemcuServiceGerenciaveis {
    private final NodemcuRepositoryGerenciaveis repository;
    private final OperationRepositoryGerenciaveis operationRepository;
    private final MainRepostoryGerenciaveis mainRepostory;
    private final ControleGeralRepositoryGerenciaveis controleGeralRepository;
    private final RealizadoHorariaRepositoryGerenciaveis realizadoHorariaRepository;
    private final RealizadoHorariaTabletRepositoryGerenciaveis realizadoHorariaTabletRepository;
    private final ContadorControllerGerenciaveis contadorController;
    private final FontesRepositoryGerenciaveis fontesRepository;
    private final GeralMainRepositoryGerenciaveis geralMainRepository;
    private final GeralNodemcuRepositoryGerenciaveis geralNodemcuRepository;
    private final GeralRealizadoHorariaRepositoryGerenciaveis geralRealizadoHorariaRepository;
    private final GeralRealizadoHorariaTabletRepositoryGerenciaveis geralRealizadoHorariaTabletRepository;
    private final GeralCicloRepositoryGerenciaveis geralCicloRepository;

    private final ScheduledExecutorService scheduler;

    @Autowired
    public NodemcuServiceGerenciaveis(NodemcuRepositoryGerenciaveis repository, OperationRepositoryGerenciaveis operationRepository,
            MainRepostoryGerenciaveis mainRepostory,
            ControleGeralRepositoryGerenciaveis controleGeralRepository, RealizadoHorariaRepositoryGerenciaveis realizadoHorariaRepository,
            RealizadoHorariaTabletRepositoryGerenciaveis realizadoHorariaTabletRepository, ContadorControllerGerenciaveis contadorController,
            FontesRepositoryGerenciaveis fontesRepository, GeralMainRepositoryGerenciaveis geralMainRepository,
            GeralNodemcuRepositoryGerenciaveis geralNodemcuRepository,
            GeralRealizadoHorariaRepositoryGerenciaveis geralRealizadoHorariaRepository,
            GeralRealizadoHorariaTabletRepositoryGerenciaveis geralRealizadoHorariaTabletRepository,
            GeralCicloRepositoryGerenciaveis geralCicloRepository) {
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

    public List<NodemcuModelGerenciaveis> listAll() {
        return repository.findAll();
    }

    public NodemcuModelGerenciaveis findByName(String name) {
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }

    public void addTimeExcess(String name) {
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        NodemcuModelGerenciaveis nodemcu = repository.findByNameId(operation);
        nodemcu.setState("piscar");
        nodemcu.setTime_excess(nodemcu.getTime_excess() + 1);
        repository.save((nodemcu));
    }

    public void addAjuda(String name) {
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        NodemcuModelGerenciaveis nodemcu = repository.findByNameId(operation);
        nodemcu.setState("piscar_azul");
        nodemcu.setAjuda(nodemcu.getAjuda() + 1);
        repository.save((nodemcu));
    }

    public NodemcuModelGerenciaveis save(NodemcuModelGerenciaveis device) {
        return repository.save(device);
    }

    @Transactional
    public NodemcuModelGerenciaveis update(String name, NodemcuModelGerenciaveis nodemcuUpdates)
            throws IOException, InterruptedException {
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        NodemcuModelGerenciaveis device = repository.findByNameId(operation);

        if (device == null) {
            return repository.save(nodemcuUpdates);
        }
        
        FontesModelGerenciaveis fonteAtual = fontesRepository.findAll().stream()
        .filter(FontesModelGerenciaveis::getIs_current)
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
        
        NodemcuModelGerenciaveis savedDevice = repository.save(device);
        if (savedDevice != null) {
            if (Integer.parseInt(nodemcuUpdates.getNameId().getName()) == 20) {
                countFontes(fonteAtual);  
                realizadoHoraria(fonteAtual);
            }
        }

        return device;
    }

    private void countFontes(FontesModelGerenciaveis fonteAtual) {
        if (fonteAtual != null) {
            fonteAtual.setRealizado(fonteAtual.getRealizado() + 1);
            fontesRepository.save(fonteAtual);
        }
    }

    private void saveGeralCiclo(NodemcuModelGerenciaveis nodemcuUpdates, OperationModelGerenciaveis operation, FontesModelGerenciaveis fonteAtual) {
        GeralCiclosModelGerenciaveis geralCiclo = new GeralCiclosModelGerenciaveis();
        geralCiclo.setCount(nodemcuUpdates.getCount());
        geralCiclo.setData(new Date());
        geralCiclo.setNameId(operation);
        geralCiclo.setTime(nodemcuUpdates.getCurrentTC());
        geralCicloRepository.save(geralCiclo);
    }

    private void updateTcHistory(NodemcuModelGerenciaveis device, NodemcuModelGerenciaveis nodemcuUpdates) {
        device.setThirdlastTC(device.getSecondtlastTC());
        device.setSecondtlastTC(device.getFirtlastTC());
        device.setFirtlastTC(nodemcuUpdates.getCurrentTC());
    }

    private void updateTcExceeded(NodemcuModelGerenciaveis device, NodemcuModelGerenciaveis nodemcuUpdates) {
        Float tcimposto = mainRepostory.findById(1).get().getTCimposto();
        if (device.getShortestTC() > nodemcuUpdates.getShortestTC() && nodemcuUpdates.getShortestTC() > 10) {
            device.setShortestTC(nodemcuUpdates.getShortestTC());
        } else if (tcimposto.intValue() < nodemcuUpdates.getCurrentTC()) {
            device.setQtdetcexcedido(device.getQtdetcexcedido() + 1);
        }
    }

    @Transactional
    public void updateState(String name, String state) {
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        if (state.equals("azul")) {
            state = "verde";
        }
        repository.updateStateByNameId(state, operation.getId());
    }

    private void realizadoHoraria(FontesModelGerenciaveis fonteAtual) {
        Date now = new Date();
        int currentHour = getHour(now);
        Optional<RealizadoHorariaModelGerenciaveis> realizado = realizadoHorariaRepository.findById(1);
        if (!realizado.isPresent()) {
            return;
        }
        int hour;
        switch (currentHour) {
            case 7:
                hour = realizado.get().getHoras7();
                realizado.get().setHoras7(hour + 1);
                break;
            case 8:
                hour = realizado.get().getHoras8();
                realizado.get().setHoras8(hour + 1);
                break;
            case 9:
                hour = realizado.get().getHoras9();
                realizado.get().setHoras9(hour + 1);
                break;
            case 10:
                hour = realizado.get().getHoras10();
                realizado.get().setHoras10(hour + 1);
                break;
            case 11:
                hour = realizado.get().getHoras11();
                realizado.get().setHoras11(hour + 1);
                break;
            case 12:
                hour = realizado.get().getHoras12();
                realizado.get().setHoras12(hour + 1);
                break;
            case 13:
                hour = realizado.get().getHoras13();
                realizado.get().setHoras13(hour + 1);
                break;
            case 14:
                hour = realizado.get().getHoras14();
                realizado.get().setHoras14(hour + 1);
                break;
            case 15:
                hour = realizado.get().getHoras15();
                realizado.get().setHoras15(hour + 1);
                break;
            case 16:
                hour = realizado.get().getHoras16();
                realizado.get().setHoras16(hour + 1);
                break;
            case 17:
                hour = realizado.get().getHoras17();
                realizado.get().setHoras17(hour + 1);
                break;
            default:
                return;

        }
        realizadoHorariaRepository.save(realizado.get());
        OperationModelGerenciaveis operation = operationRepository.findByName("060");
        NodemcuModelGerenciaveis device = repository.findByNameId(operation);
        device.setCount(realizadoHorariaRepository.somarTudo());
        repository.save(device);

    }

    private void realizadoHorariaTablet(String name, FontesModelGerenciaveis fonteAtual) {
        Date now = new Date();
        int currentHour = getHour(now);
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        RealizadoHorariaTabletModelGerenciaveis realizado = realizadoHorariaTabletRepository.findByNameId(operation);
        if (realizado == null) {
            return;
        }
        int hour;
        switch (currentHour) {
            case 7:
                hour = realizado.getHoras7();
                realizado.setHoras7(hour + 1);
                break;
            case 8:
                hour = realizado.getHoras8();
                realizado.setHoras8(hour + 1);
                break;
            case 9:
                hour = realizado.getHoras9();
                realizado.setHoras9(hour + 1);
                break;
            case 10:
                hour = realizado.getHoras10();
                realizado.setHoras10(hour + 1);
                break;
            case 11:
                hour = realizado.getHoras11();
                realizado.setHoras11(hour + 1);
                break;
            case 12:
                hour = realizado.getHoras12();
                realizado.setHoras12(hour + 1);
                break;
            case 13:
                hour = realizado.getHoras13();
                realizado.setHoras13(hour + 1);
                break;
            case 14:
                hour = realizado.getHoras14();
                realizado.setHoras14(hour + 1);
                break;
            case 15:
                hour = realizado.getHoras15();
                realizado.setHoras15(hour + 1);
                break;
            case 16:
                hour = realizado.getHoras16();
                realizado.setHoras16(hour + 1);
                break;
            case 17:
                hour = realizado.getHoras17();
                realizado.setHoras17(hour + 1);
                break;
            default:
                return;
        }
        realizadoHorariaTabletRepository.save(realizado);
        NodemcuModelGerenciaveis device = repository.findByNameId(operation);
        device.setCount(realizadoHorariaTabletRepository.somarTudo(realizado.getId()));
        repository.save(device);
    }

    private int getHour(Date date) {
        SimpleDateFormat formatador = new SimpleDateFormat("HH");
        return Integer.parseInt(formatador.format(date));
    }

    @Transactional
    public void updateLocalTC(String name, Integer tempo) {
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        repository.updateLocalTCByNameId(tempo, operation.getId());
    }


    public void zerarDados() {
        if (true) {
            try {

                FontesModelGerenciaveis fonteAtual = fontesRepository.findAll().stream()
                        .filter(FontesModelGerenciaveis::getIs_current)
                        .findFirst()
                        .orElse(null);

                OperationModelGerenciaveis operations = operationRepository.findByName("020");
                NodemcuModelGerenciaveis nodemcuResultadoGeral = repository.findByNameId(operations);
                Optional<MainModelGerenciaveis> main = mainRepostory.findById(1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                String formattedDate = dateFormat.format(currentDate);
                List<ControleGeralModelGerenciaveis> controleGeral = controleGeralRepository.findByDataBetween(formattedDate,
                        formattedDate);
                System.out.println(controleGeral);
                controleGeral.get(0).setRealizado(nodemcuResultadoGeral.getCount());
                controleGeral.get(0).setModelo(fonteAtual.getModelo());
                controleGeralRepository.save(controleGeral.get(0));
                GeralMainModelGerenciaveis geralMain = new GeralMainModelGerenciaveis();
                geralMain.setImposto((int) Math.floor(main.get().getImposto()));
                geralMain.setOp(main.get().getOp());
                geralMain.setShiftTime(main.get().getShiftTime());
                geralMain.setTCimposto(main.get().getTCimposto());
                geralMainRepository.save(geralMain);

                Optional<RealizadoHorariaModelGerenciaveis> realizadoHoraria = realizadoHorariaRepository.findById(1);
                if (realizadoHoraria.isPresent()) {
                    GeralRealizadoHorariaModelGerenciaveis geralRealizado = new GeralRealizadoHorariaModelGerenciaveis();
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

                List<RealizadoHorariaTabletModelGerenciaveis> realizadoHorariaTablet = realizadoHorariaTabletRepository.findAll();
                realizadoHorariaTablet.forEach(elemento -> {
                    GeralRealizadoHorariaTabletModelGerenciaveis geralRealizadoHorariaTablet = new GeralRealizadoHorariaTabletModelGerenciaveis();
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

                List<OperationModelGerenciaveis> operation = operationRepository.findAll();
                operation.forEach(element -> {
                    NodemcuModelGerenciaveis nodemcuResultado = repository.findByNameId(element);
                    GeralNodemcuModelGerenciaveis nodemcu = new GeralNodemcuModelGerenciaveis();
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
                Optional<RealizadoHorariaModelGerenciaveis> realizadoReset = realizadoHorariaRepository.findById(1);
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
                List<NodemcuModelGerenciaveis> nodemcuList = repository.findAll();
                for (NodemcuModelGerenciaveis nodemcu : nodemcuList) {
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
                    ContadorGerenciaveis contador = nodemcu.getContador();
                    contador.setContadorAtual(0);
                    contador.setIs_couting(false);
                    nodemcu.setTime_excess(0);
                    nodemcu.setAnalise(0);
                    nodemcu.setAjuda(0);
                    repository.save(nodemcu);
                }
                List<RealizadoHorariaTabletModelGerenciaveis> realizadoList = realizadoHorariaTabletRepository.findAll();
                for (RealizadoHorariaTabletModelGerenciaveis realizado : realizadoList) {
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
                for (OperationModelGerenciaveis op : operation) {
                    op.setOcupado(false);
                    operationRepository.save(op);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}