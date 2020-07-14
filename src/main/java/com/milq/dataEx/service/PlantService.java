package com.milq.dataEx.service;

import com.milq.dataEx.entity.Plant;
import com.milq.dataEx.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        return new Plant();
    }

    public Long savePlant(Plant plant){
        return plantRepository.save(plant).getId();
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price){
        return  plantRepository.findPlantsByPriceLessThan(price);
    }

    public Boolean delivered(Long id){
        return  plantRepository.deliveryCompleted(id);
    }
}
