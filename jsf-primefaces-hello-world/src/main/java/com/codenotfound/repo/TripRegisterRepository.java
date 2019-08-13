package com.codenotfound.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.TripRegister;


@EnableScan
public interface TripRegisterRepository extends CrudRepository<TripRegister, Integer> {
 /*List<TripRegister> findByVechileNumber(String vechileNumber);*/
}
