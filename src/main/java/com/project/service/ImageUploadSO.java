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
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class ImageUploadSO {
	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	public ResponseEntity<String> uploadFile(MultipartFile file) throws SdkClientException, IOException {
		String fileName, fileUrl;
		ObjectMetadata metadata;
		PutObjectRequest request;
		try {
			/* 업로드 파일 원본 이름 가져오기 */
			fileName = file.getOriginalFilename();

			/* 파일 메타데이터 설정 */
			metadata = new ObjectMetadata();
			metadata.setContentType(file.getContentType());
			metadata.setContentLength(file.getSize());

			/* 업로드 요청 생성 및 읽기 권한 부여 */
			request = new PutObjectRequest(bucketName, fileName, file.getInputStream(), metadata)
					.withCannedAcl(CannedAccessControlList.PublicRead);

			/* 파일 업로드 */
			amazonS3.putObject(request);

			/* 업로드 URL 반환 */
			fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + fileName;

			return ResponseEntity.ok(fileUrl);
		} catch (AmazonServiceException e) {
			/* 업로드 실패 시, 오류 메시지 반환 */
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("File upload failed: " + e.getMessage());
		}
	}
}