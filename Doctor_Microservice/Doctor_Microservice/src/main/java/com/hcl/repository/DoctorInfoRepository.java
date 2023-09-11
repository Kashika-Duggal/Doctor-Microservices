package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.entity.DoctorInfo;

@Repository
@RequestMapping("/DoctorInfo")
public interface DoctorInfoRepository extends CrudRepository<DoctorInfo, String> {

}
