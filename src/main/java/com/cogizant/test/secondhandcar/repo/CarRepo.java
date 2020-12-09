package com.cogizant.test.secondhandcar.repo;

import com.cogizant.test.secondhandcar.dao.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<CarModel,Integer> {
}
