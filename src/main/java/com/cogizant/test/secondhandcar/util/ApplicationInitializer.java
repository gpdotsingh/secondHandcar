package com.cogizant.test.secondhandcar.util;

import com.cogizant.test.secondhandcar.entity.GarageDetails;
import com.cogizant.test.secondhandcar.repo.CarRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Component
public class ApplicationInitializer implements InitializingBean
{
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    AppConfig appConfig;
    @Autowired
    CarRepo carRepo;
    @Autowired
    Util util;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print("Initializing bean"+appConfig.getUrl());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        GarageDetails[] garageDetails =restTemplate.exchange(appConfig.getUrl(), HttpMethod.GET,entity, GarageDetails[].class).getBody();
        util.saveInDB(garageDetails);
    }
}
