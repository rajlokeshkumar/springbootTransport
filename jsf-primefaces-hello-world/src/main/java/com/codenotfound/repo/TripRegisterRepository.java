package com.codenotfound.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.TripRegister;


@EnableScan
public interface TripRegisterRepository extends CrudRepository<TripRegister, Integer> {

}
