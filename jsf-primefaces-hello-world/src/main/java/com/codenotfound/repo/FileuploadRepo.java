package com.codenotfound.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.codenotfound.entity.Fileupload;
@EnableScan
public interface FileuploadRepo  extends CrudRepository<Fileupload, String>{

}
