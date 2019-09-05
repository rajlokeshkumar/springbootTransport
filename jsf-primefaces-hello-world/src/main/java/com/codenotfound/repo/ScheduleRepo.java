package com.codenotfound.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.ScheduleModelDomain;
@EnableScan
public interface ScheduleRepo extends CrudRepository<ScheduleModelDomain, String> {

}
