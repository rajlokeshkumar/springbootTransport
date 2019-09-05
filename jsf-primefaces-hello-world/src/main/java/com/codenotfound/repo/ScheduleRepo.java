package com.codenotfound.repo;

import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.ScheduleModelDomain;

public interface ScheduleRepo extends CrudRepository<ScheduleModelDomain, String> {

}
