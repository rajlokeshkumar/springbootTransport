package com.codenotfound.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.DriverInfo;
@EnableScan
public interface DriverInfoRepo extends CrudRepository<DriverInfo, String>{

}
