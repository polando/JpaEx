package com.milq.dataEx.controller;


import com.milq.dataEx.dto.PlantDto;
import com.milq.dataEx.entity.Plant;
import com.milq.dataEx.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    public PlantDto getPlantDto(String name){
        return convertPlantToPlantDto(plantService.getPlantByName(name));
    }

    private Plant convertPlantDtoToPlant(PlantDto plantDto){
        return new Plant();
    }

    private PlantDto convertPlantToPlantDto(Plant plant){
        PlantDto plantDto = new PlantDto();
        BeanUtils.copyProperties(plant,plantDto);
        return plantDto;
    }
}
