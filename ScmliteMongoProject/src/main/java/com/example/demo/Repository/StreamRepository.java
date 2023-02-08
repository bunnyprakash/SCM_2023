package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Stream;

public interface StreamRepository extends CrudRepository <Stream, String>{

}
