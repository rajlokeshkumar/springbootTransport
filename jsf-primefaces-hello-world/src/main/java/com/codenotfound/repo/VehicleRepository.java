package com.codenotfound.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.Vehicle;
@EnableScan
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}
