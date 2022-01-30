package com.datta.services;

import org.springframework.web.multipart.MultipartFile;

import com.datta.model.UploadedFile;

public interface FileUploadService {
  
	public void uploadToLocal(MultipartFile file);
	
	public UploadedFile uploadToDB(MultipartFile file);
	
	//public UploadedFile downloadFile(int id);

	public UploadedFile downloadFile(String id);
}
