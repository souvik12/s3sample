package com.springbootdev.amazon.s3.example.aws.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3ClientService
{
    void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess,String bucketname);

    void deleteFileFromS3Bucket(String fileName);
    
    public List<String> AllFileFromS3Bucket();
    
    //public List<String> listFiles();
    
    public ByteArrayOutputStream downloadFile(String keyName,String bucketname);

	List<String> listFiles(String bucketname);
    
}
