package com.cogizant.test.secondhandcar.controller;

import com.cogizant.test.secondhandcar.dao.CarModel;
import com.cogizant.test.secondhandcar.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
public class CarController {

    @Autowired
    private CarRepo carRepo;
    @GetMapping("getCarList")
    public Page<CarModel> getCarList(@RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize)
    {
        return carRepo.findAll( PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.ASC, "dateAdded")));
    }
}
