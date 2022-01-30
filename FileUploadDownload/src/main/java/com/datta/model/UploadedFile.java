package com.datta.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UploadedFile {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy ="uuid2")
	 private String fileId;
	 private String fileName;
	 private String fileType;
	 
	 @Lob
	 private byte[] fileData;
	public UploadedFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UploadedFile(String fileName, String fileType, byte[] fileData) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "UploadedFile [fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType + ", fileData="
				+ Arrays.toString(fileData) + "]";
	}
	 
	 
}
