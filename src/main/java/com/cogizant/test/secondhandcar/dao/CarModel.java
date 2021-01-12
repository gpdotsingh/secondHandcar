package com.cogizant.test.secondhandcar.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String make;
    private String model;
    private Integer yearModel;
    private Double price;
    private boolean licensed;
    @Column(name = "date_added", columnDefinition = "DATE")
    private LocalDate dateAdded;
    private String latitude;
    private String longitude;
    private int wareHouseId;
    private String wareHouse ;

}
