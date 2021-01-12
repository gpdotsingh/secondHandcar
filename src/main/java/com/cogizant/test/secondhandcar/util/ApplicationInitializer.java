package com.cogizant.test.secondhandcar.util;

import com.cogizant.test.secondhandcar.entity.GarageDetails;
import com.cogizant.test.secondhandcar.service.GarageService;
import com.cogizant.test.secondhandcar.service.InitializingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements InitializingBean
{
    @Autowired
    InitializingService initializingService;
    @Autowired
    Util util;
    @Autowired
    GarageService garageService;
    @Override
    public void afterPropertiesSet() throws Exception {
        GarageDetails[] garageDetails =initializingService.getGarageDetails();
        garageService.saveInDB(garageDetails);
    }
}
