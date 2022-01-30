package com.upload.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upload.model.Doc;


public interface DocRepository extends JpaRepository<Doc, Integer>{

	
}
