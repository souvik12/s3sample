package com.springbootdev.amazon.s3.example.aws.controller;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
//import com.springbootdev.amazon.s3.example.Jsonread.Jsonreadapp;
import com.springbootdev.amazon.s3.example.aws.service.AmazonS3ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/files")
public class FileHandlerController {

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;
    
    @PostMapping("/Uploadfile/BucketName/{bucketname}")
    public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file,@PathVariable String bucketname)
    {
        this.amazonS3ClientService.uploadFileToS3Bucket(file, true,bucketname);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");

        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteFile(@RequestParam("file_name") String fileName)
    {
        this.amazonS3ClientService.deleteFileFromS3Bucket(fileName);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + fileName + "] removing request submitted successfully.");

        return response;
    }
    
    @GetMapping("/AllBuckets")
    public List s3list() {	
    	//final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
    	//final AmazonS3 s3 = amazonS3ClientService.standard().withRegion(Regions.DEFAULT_REGION).build();
    	
		return this.amazonS3ClientService.AllFileFromS3Bucket();
      
     }
    @GetMapping("/Bucketsfile/{bucketname}")
	public List listAllFiles(@PathVariable String bucketname){
		return this.amazonS3ClientService.listFiles(bucketname);
	}
       
    @GetMapping("/api/bucket/{bucketname}/{keyname}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable String keyname,@PathVariable String bucketname) {
		ByteArrayOutputStream downloadInputStream = amazonS3ClientService.downloadFile(keyname, bucketname);
	
		return ResponseEntity.ok()
					.contentType(contentType(keyname))
					.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + keyname + "\"")
					.body(downloadInputStream.toByteArray());	
	}
	
	private MediaType contentType(String keyname) {
		String[] arr = keyname.split("\\.");
		String type = arr[arr.length-1];
		switch(type) {
			case "txt": return MediaType.TEXT_PLAIN;
			case "png": return MediaType.IMAGE_PNG;
			case "jpg": return MediaType.IMAGE_JPEG;
			default: return MediaType.APPLICATION_OCTET_STREAM;
		}
	}
    }
    
