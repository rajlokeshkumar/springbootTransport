package com.codenotfound.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.BookingInfo;
@EnableScan
public interface BookingInfoRepo extends CrudRepository<BookingInfo, String>{

}
