package com.codenotfound.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.TripRegister;


@EnableScan
public interface TripRegisterRepository extends CrudRepository<TripRegister, String> {
	List<TripRegister> findByVechileNumber(String vechileNumber);
	List<TripRegister> findByVechileNumberAndStatusOfTrip(String vechileNumber,String status);
	List<TripRegister> findByVechileNumberAndStartPlaceAndEndPlace(String vechileNumber,String startPlaces,String endPlaces);
	List<TripRegister> findByVechileNumberAndStartPlace(String vechileNumber,String startPlaces);
	List<TripRegister> findByVechileNumberAndEndPlace(String vechileNumber,String endPlaces);
	List<TripRegister> findByStartPlaceAndEndPlace(String startPlaces,String endPlaces);
	List<TripRegister> findByStartPlace(String startPlaces);
	List<TripRegister> findByEndPlace(String endPlaces);

}
