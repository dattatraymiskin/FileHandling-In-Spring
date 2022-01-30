package com.datta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datta.model.UploadedFile;

@Repository
public interface FileUploadRepo extends JpaRepository<UploadedFile,String>{

}
