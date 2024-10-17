package com.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.SdkClientException;
import com.project.service.*;

@Controller
public class ImageUploadController {
	@Autowired
	ImageUploadSO uploadSO;

	@RequestMapping("/upload/testPage")
	public String test() {
		return "main/test";
	}

	@RequestMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam(name = "file", required = true) MultipartFile file)
			throws SdkClientException, IOException {
		return uploadSO.uploadFile(file);
	}
}