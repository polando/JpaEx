package com.milq.dataEx.service;

import com.milq.dataEx.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName(String name){
        return new Plant();
    }
}
