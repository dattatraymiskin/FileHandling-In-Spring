package com.datta.services.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.datta.model.UploadedFile;
import com.datta.repository.FileUploadRepo;
import com.datta.services.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	
	private String uploadFolderPath= "E:/SpringFileDB/";
	
	@Autowired
	private FileUploadRepo fileUploadRepo;
	
	@Override
	public void uploadToLocal(MultipartFile file) {
	  
		try {
			byte[] data=file.getBytes();
			Path path=Paths.get(uploadFolderPath+file.getOriginalFilename());
			Files.write(path, data,StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UploadedFile uploadToDB(MultipartFile file) {
		
		UploadedFile uploadedFile =new UploadedFile();
		
		try {
			uploadedFile.setFileData(file.getBytes());
			uploadedFile.setFileType(file.getContentType());
			uploadedFile.setFileName(file.getOriginalFilename());
			return fileUploadRepo.save(uploadedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public UploadedFile downloadFile(String id) {
		UploadedFile uploadedFile= fileUploadRepo.getOne(id);
		return uploadedFile;
	}

}
