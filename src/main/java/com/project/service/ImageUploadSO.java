package com.project.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class ImageUploadSO {
	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.bucketName}")
	private String bucketName;

	public ResponseEntity<String> uploadFile(MultipartFile file) throws SdkClientException, IOException {
		String fileName, fileUrl;
		try {
			fileName = file.getOriginalFilename();
			amazonS3.putObject(bucketName, fileName, file.getInputStream(), new ObjectMetadata());
			fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
			return ResponseEntity.ok(fileUrl);
		} catch (AmazonServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("File upload failed: " + e.getMessage());
		}
	}
}