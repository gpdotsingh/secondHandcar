package com.cogizant.test.secondhandcar.service;

import com.cogizant.test.secondhandcar.entity.GarageDetails;
import com.cogizant.test.secondhandcar.util.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class InitializingService {
    @Autowired
    AppConfig appConfig;
    @Autowired
    private RestTemplate restTemplate;

    public GarageDetails[] getGarageDetails() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return  restTemplate.exchange(appConfig.getUrl(), HttpMethod.GET,entity, GarageDetails[].class).getBody();
    }

//    private GarageDetails[] defaultGarage() {
//        GarageDetails[] garageDetails = getGarageDetails();
//        return garageDetails;
//    }
}

