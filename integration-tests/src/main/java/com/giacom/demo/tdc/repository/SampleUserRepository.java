package com.giacom.demo.tdc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giacom.demo.tdc.domain.SampleUser;

@Repository
public interface SampleUserRepository extends CrudRepository<SampleUser, String> {

    List<SampleUser> findByNameContainingIgnoreCase(String name);

    List<SampleUser> findByLastNameContainingIgnoreCase(String lastName);

}
