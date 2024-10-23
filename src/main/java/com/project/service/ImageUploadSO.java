package com.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.project.model.FileItem;
import com.project.model.NoticeItem;
import com.project.model.dao.NoticeItemDAO;

@Service
public class ImageUploadSO {
	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	@Autowired
	private NoticeItemDAO dao;

	public ResponseEntity<String> uploadFile(MultipartFile file) throws SdkClientException, IOException {
		String fileName, fileUrl, timeStamp;
		ObjectMetadata metadata;
		PutObjectRequest request;
		try {
			/* 업로드 파일 원본 이름 가져오기 */
			fileName = file.getOriginalFilename();
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			fileName = timeStamp + "_" + fileName;

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

	@Transactional
	public boolean insertNewPost(String title, String content, MultipartFile[] files, int target, int memberId) {
		int noticeId = dao.insertNewPost(title, content, target, memberId);
		List<String> attms = new ArrayList<String>();
		String attm = null;
		if (noticeId > 0) {
			for (MultipartFile file : files) {
				try {
					attm = this.uploadFile(file).getBody();
					attms.add(attm);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return dao.batchInsert(noticeId, attms).length == files.length && noticeId > 0;
		}
		return false;
	}

	public ResponseEntity<InputStreamResource> getFile(String fileName) {
		S3Object s3object = amazonS3.getObject(bucketName, fileName);

		S3ObjectInputStream inputStream = s3object.getObjectContent();
		try {
			File tempFile = File.createTempFile("s3file-", null);
			FileOutputStream fos = new FileOutputStream(tempFile);
			byte[] read_buf = new byte[1024];
			int read_len;
			while ((read_len = inputStream.read(read_buf)) > 0) {
				fos.write(read_buf, 0, read_len);
			}
			fos.close();
			inputStream.close();

			String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()).replaceAll("\\+",
					"%20");

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFileName);

			InputStreamResource resource = new InputStreamResource(new java.io.FileInputStream(tempFile));
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
					.contentLength(tempFile.length()).body(resource);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public List<FileItem> getFiles(String fileString) {
		String[] files = fileString.split(",");
		List<FileItem> fileList = new ArrayList<FileItem>();
		FileItem fileItem;
		for (String file : files) {
			fileItem = new FileItem();
			fileItem.setFileName(this.getFileName(file));
			fileItem.setUrl(this.getFileURL(fileItem.getFileName()));
			fileList.add(fileItem);
		}
		return fileList;
	}

	public String getFileName(String url) {
		return url.substring(url.lastIndexOf('/') + 1);
	}

	public String getFileURL(String fileName) {
		return "/api/file/get?fileName=" + fileName;
	}
}