package com.datta.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class MultipartFIleUplaodException {

	@ExceptionHandler(MaxUploadSizeExceededException.class) 
	public String handleFileException(MaxUploadSizeExceededException exception,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return "File Size Limit Exceeded PLz make sure the file size less than 5MB";
	}
}
