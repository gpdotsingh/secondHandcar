package com.cogizant.test.secondhandcar.util;

import com.cogizant.test.secondhandcar.dao.CarModel;
import com.cogizant.test.secondhandcar.entity.GarageDetails;
import com.cogizant.test.secondhandcar.entity.Vehicle;
import com.cogizant.test.secondhandcar.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Util {

    public HttpEntity<String> getStringHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return new HttpEntity<String>("parameters", headers);
    }

    public List<CarModel> getCarModelsFromObj(GarageDetails[] vehicles) {

        List<CarModel> carModels = new ArrayList();
        Arrays.stream(vehicles).forEach(vehicle -> {
            for (Vehicle v : vehicle.getCars().getVehicles()
            ) {
                CarModel carModel = new CarModel();
                carModel.setId(v.getId());
                carModel.setDateAdded(LocalDate.parse(v.getDateAdded()));
                carModel.setLatitude(vehicle.getLocation().getLat());
                carModel.setLongitude(vehicle.getLocation().getLong());
                carModel.setLicensed(v.getLicensed());
                carModel.setModel(v.getModel());
                carModel.setPrice(v.getPrice());
                carModel.setMake(v.getMake());
                carModel.setWareHouse(vehicle.getName());
                carModel.setWareHouseId(vehicle.getId());
                carModel.setYearModel(v.getYearModel());
                carModels.add(carModel);
            }
        });
        return carModels;
    }
}
