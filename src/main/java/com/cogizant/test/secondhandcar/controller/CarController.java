package com.cogizant.test.secondhandcar.controller;

import com.cogizant.test.secondhandcar.dao.CarModel;
import com.cogizant.test.secondhandcar.entity.Example;
import com.cogizant.test.secondhandcar.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepo carRepo;

    @GetMapping("getCarList")
    public List<CarModel>  getCarList()
    {
        return carRepo.findAll();
    }
}
