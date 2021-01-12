package com.cogizant.test.secondhandcar.repo;

import com.cogizant.test.secondhandcar.dao.CarModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarRepo extends JpaRepository<CarModel,Integer> {
//    Page<CarModel> findAll(PageRequest pageRequest);
}
