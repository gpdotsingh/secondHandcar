package com.cogizant.test.secondhandcar.service;

import com.cogizant.test.secondhandcar.dao.CarModel;
import com.cogizant.test.secondhandcar.entity.GarageDetails;
import com.cogizant.test.secondhandcar.repo.CarRepo;
import com.cogizant.test.secondhandcar.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    Util util;

    public Page<CarModel> getEmployees(int pageNo, int pageSize){
        return carRepo.findAll( PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.ASC, "dateAdded")));
    }

    public void saveInDB(GarageDetails[] garageDetails) {
        List<CarModel> carModels = util.getCarModelsFromObj(garageDetails);
        carRepo.saveAll(carModels);
    }
}
