package com.leanderziehm.example_app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leanderziehm.example_app.model.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity,Integer>{

    // ArrayList<ExampleEntity> findAllExampleEntities();

    @Query("SELECT e FROM ExampleEntity e")
    ArrayList<ExampleEntity> findAllExampleEntities();

    ArrayList<ExampleEntity> findAllByName(String name);
    
} 