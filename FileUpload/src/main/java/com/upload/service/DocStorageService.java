package com.upload.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upload.model.Doc;
import com.upload.repo.DocRepository;

@Service
public class DocStorageService {
   
	@Autowired
	private DocRepository docRepository;
	
	public Doc saveFile(MultipartFile file) {
		 String docname=file.getOriginalFilename();
		 
		 try {
			 Doc doc=new Doc(docname, file.getContentType(), file.getBytes());
			 
			 return docRepository.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Optional<Doc> getFile(int id) {
		return docRepository.findById(id);
	}
	
	public List<Doc> getFiles(){
		return docRepository.findAll();
	}
	
}
