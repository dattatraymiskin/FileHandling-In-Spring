package com.datta.response;

import org.springframework.stereotype.Component;

@Component
public class FileUploadResponse {

	  private String fileId;
	  private String fileType;
	  private String message;
	  private boolean uploadStatus;
	  private String downloadUrl;
	  
	  
	  
	  
	public FileUploadResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(boolean uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	  
	  
}
