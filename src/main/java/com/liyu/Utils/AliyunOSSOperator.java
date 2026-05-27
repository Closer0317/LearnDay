package com.liyu.Utils;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.liyu.Pojo.AliyunOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class AliyunOSSOperator {

    @Autowired
    private AliyunOSSProperties ossProperties;

    public String upload(byte[] content, String originalFilename) throws Exception {
        String endpoint = ossProperties.getEndpoint();
        String bucketName = ossProperties.getBucketName();
        String region = ossProperties.getRegion();

        EnvironmentVariableCredentialsProvider provider = new EnvironmentVariableCredentialsProvider();
        String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
        String ext = originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : "";
        String objectKey = dir + "/" + UUID.randomUUID() + ext;

        // V1：直接构建 OSSClient，简单直接
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(provider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();


        try {
            ossClient.putObject(bucketName, objectKey, new ByteArrayInputStream(content));
        } finally {
            ossClient.shutdown();
        }

        String cleanEndpoint = endpoint.replaceFirst("^https?://", "");
        return "https://" + bucketName + "." + cleanEndpoint + "/" + objectKey;
    }
}