package com.milq.dataEx.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.milq.dataEx.views.PlantPublicFields;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {

    @Id
    @GeneratedValue
    private Long id;


    @JsonView(PlantPublicFields.class)
    @Nationalized
    private String name;

    @JsonView(PlantPublicFields.class)
    @Column(precision = 12,scale = 4)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryId")
    private Delivery delivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
