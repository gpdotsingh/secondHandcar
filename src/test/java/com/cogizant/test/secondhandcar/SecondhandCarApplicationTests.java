package com.cogizant.test.secondhandcar;

import com.cogizant.test.secondhandcar.entity.Cars;
import com.cogizant.test.secondhandcar.entity.GarageDetails;
import com.cogizant.test.secondhandcar.entity.Location;
import com.cogizant.test.secondhandcar.entity.Vehicle;
import com.cogizant.test.secondhandcar.repo.CarRepo;
import com.cogizant.test.secondhandcar.service.InitializingService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
class SecondhandCarApplicationTests {

	private Vehicle vehicle;
	private Vehicle vehicle2;

	private Cars cars1;
	private Cars cars2;
	private Location location1;
	private Location location2;
	private GarageDetails garageDetails1;
	private GarageDetails garageDetails2;

	@Autowired
	private RestTemplate restTemplate;

	private MockMvc mockMvc;
	private GarageDetails[] garageDetails=new GarageDetails[2];
	@Mock
	CarRepo carRepo;
	@Mock
	InitializingService initializingService;
	@Autowired
	WebApplicationContext context;
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		GarageDetails garageDetails1 = new GarageDetails();
		GarageDetails garageDetails2 = new GarageDetails();
		location1 = new Location();
		location2 = new Location();

		vehicle = new Vehicle();
		vehicle2 = new Vehicle();
		setDummyVehicle();

		List<Vehicle> vehicles1= new ArrayList<>();
		List<Vehicle> vehicles2= new ArrayList<>();
		vehicles1.add(vehicle);
		vehicles2.add(vehicle2);

		Cars cars1 = new Cars();
		Cars cars2 = new Cars();
		initializeCar(vehicles1, vehicles2, cars1, cars2);

		initializeLocation(location1, location2);

		garageDetails1.setId(1);
		garageDetails1.setCars(cars1);
		garageDetails1.setLocation(location1);
		garageDetails1.setName("Warehouse A");

		garageDetails2.setId(2);
		garageDetails2.setCars(cars2);
		garageDetails2.setLocation(location2);
		garageDetails2.setName("Warehouse B");

		garageDetails[0]=garageDetails1;
		garageDetails[1]=garageDetails2;
	}



	@Test
	void contextLoads() throws Exception {
		when(initializingService.getGarageDetails()).thenReturn(this.garageDetails);
		//when(carRepo.findAll(PageRequest.of(1,1, Sort.by(Sort.Direction.ASC, "dateAdded")))).thenReturn(null);
		//MvcResult carModels= mockMvc.perform(get("/getCarList").param("pageNo", String.valueOf(1)).param("pageNo", String.valueOf(1))).andDo(print()).andExpect(status().isOk()).andReturn();
//		String jsonData=carModels.getResponse().getContentAsString();

	}


	private void setDummyVehicle() {
		vehicle.setDateAdded("2018-03-28");
		vehicle.setId(1);
		vehicle.setLicensed(true);
		vehicle.setMake("Acura");
		vehicle.setModel("NSX");
		vehicle.setPrice(23175.76);
		vehicle.setYearModel(2001);

		vehicle2.setDateAdded("2018-03-28");
		vehicle2.setId(2);
		vehicle2.setLicensed(false);
		vehicle2.setMake("Toyota");
		vehicle2.setModel("Tacoma");
		vehicle2.setPrice(11597.18);
		vehicle2.setYearModel(1997);
	}
	private void initializeLocation(Location location1, Location location2) {
		location1.setLat("47.13111");
		location1.setLong("-61.54801");
		location2.setLat("15.95386");
		location2.setLong("7.06246");
	}

	private void initializeCar(List<Vehicle> vehicles1, List<Vehicle> vehicles2, Cars cars1, Cars cars2) {
		cars1.setLocation("West wing");
		cars1.setVehicles(vehicles1);
		cars2.setLocation("East wing");
		cars2.setVehicles(vehicles2);
	}
}
