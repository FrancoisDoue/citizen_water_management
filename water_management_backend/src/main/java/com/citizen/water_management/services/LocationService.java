package com.citizen.water_management.services;

import com.citizen.water_management.dto.waterSupply.WaterSupplyDtoGetForHistoryOfConsumption;
import com.citizen.water_management.entity.ConsumptionDetail;
import com.citizen.water_management.entity.WaterSupply;
import com.citizen.water_management.entity.account.Account;
import com.citizen.water_management.entity.location.Home;
import com.citizen.water_management.repository.ConsumptionDetailRepository;
import com.citizen.water_management.repository.HomeRepository;
import com.citizen.water_management.repository.LocationRepository;
import com.citizen.water_management.repository.WaterSupplyRepository;
import com.citizen.water_management.repository.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final ConsumptionDetailRepository consumptionDetailRepository;
    private final WaterSupplyRepository waterSupplyRepository;
    private final AccountRepository accountRepository;
    private final HomeRepository homeRepository;


    public LocationService(LocationRepository locationRepository,
                           ConsumptionDetailRepository consumptionDetailRepository,
                           WaterSupplyRepository waterSupplyRepository,
                           AccountRepository accountRepository,
                           HomeRepository homeRepository) {
        this.locationRepository = locationRepository;
        this.consumptionDetailRepository = consumptionDetailRepository;
        this.waterSupplyRepository = waterSupplyRepository;
        this.accountRepository = accountRepository;
        this.homeRepository = homeRepository;
    }

    //Fonction pour avoir la liste des arrivées d'eau liées à un user
    private List<WaterSupply> getWaterSupplyByIdUser(int idUser) {
        Optional <Account> account = accountRepository.findById(idUser);
        if (account.isEmpty()) throw new IllegalArgumentException("There is no account with id " + idUser);

        Optional <Home> home = homeRepository.findFirstByAccounts(List.of(account.get()));
        if (home.isEmpty()) throw new IllegalArgumentException("User with id " + idUser + " have no home");

        return home.get().getWaterSupply();
    }

    public List<WaterSupplyDtoGetForHistoryOfConsumption> getHistoryOfConsumptions(int idUser){
        List<WaterSupply> waterSupplies = getWaterSupplyByIdUser(idUser);
        return waterSupplies.stream().map(WaterSupplyDtoGetForHistoryOfConsumption::new).toList();
    }

    public List<WaterSupplyDtoGetForHistoryOfConsumption> getLastConsumptions(int idUser){

        List<WaterSupply> waterSupplies = getWaterSupplyByIdUser(idUser);


        for (WaterSupply waterSupply : waterSupplies){
            waterSupply.getConsumptionDetailList().clear();
            waterSupply.getConsumptionDetailList().add(
                    consumptionDetailRepository.findFirstByWaterSupplyOrderByEndDateDesc(waterSupply));
        }

        return waterSupplies.stream().map(WaterSupplyDtoGetForHistoryOfConsumption::new).toList();
    }
}
