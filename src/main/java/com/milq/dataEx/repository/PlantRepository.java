package com.milq.dataEx.repository;

import com.milq.dataEx.entity.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends CrudRepository<Plant,Long> {

    Boolean existsPlantByIdAndAndDeliveryCompleted(Long id,Boolean delivery);

    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    Boolean deliveryCompleted(Long plantId);

    @Query("select new java.lang.Boolean(p.delivery.completed) from Plant p where p.id = :plantId")
    Boolean deliveryCompletedBoolean(Long plantId);

    List<Plant> findPlantsByPriceLessThan(BigDecimal price);


}
