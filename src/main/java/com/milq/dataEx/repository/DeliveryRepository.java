package com.milq.dataEx.repository;


import com.milq.dataEx.entity.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    void presist(Delivery delivery){
        entityManager.persist(delivery);
    }

    Delivery merge(Delivery delivery){
        return  entityManager.merge(delivery);
    }

    Delivery find(Long id){
        return entityManager.find(Delivery.class,id);
    }

    void delete(Long deliveriId){
        Delivery delivery = entityManager.find(Delivery.class,deliveriId);
        entityManager.remove(delivery);
    }


}
