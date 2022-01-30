package com.datta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datta.model.UploadedFile;
import com.datta.response.FileUploadResponse;
import com.datta.services.FileUploadService;

@RestController
@RequestMapping("/api")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("/upload/local")
	public void uploadLocal(@RequestParam("file") MultipartFile multipartFile) {
		 fileUploadService.uploadToLocal(multipartFile);
	}
	
	@PostMapping("/upload/db")
	public FileUploadResponse uploadDB(@RequestParam("file") MultipartFile multipartFile) {
		UploadedFile uploadedFile=fileUploadService.uploadToDB(multipartFile);		
		FileUploadResponse response=new FileUploadResponse();
		if(uploadedFile!=null) {
			String downloadUrl=ServletUriComponentsBuilder.fromCurrentContextPath()
					           .path("/api/download/")
					           .path(uploadedFile.getFileId())
					           .toUriString();
			response.setDownloadUrl(downloadUrl);
			response.setFileId(uploadedFile.getFileId());
			response.setFileType(uploadedFile.getFileType());
			response.setUploadStatus(true);
			response.setMessage("Upload File Successfully!!");
			
			return response;
		}
		response.setMessage("Oops! Somethinf went wrong plz re-upload");
		return response;
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String id) {
	   UploadedFile downloadFile = fileUploadService.downloadFile(id);
	   return ResponseEntity.ok()
			   .contentType(MediaType.parseMediaType(downloadFile.getFileType()))
			   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+downloadFile.getFileName())
			   .body(new ByteArrayResource(downloadFile.getFileData()));
	}
}
