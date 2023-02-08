package com.sas.kms.config;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

//    @Bean
//    public AWSKMS AWSKMSBean(){
//         return AWSKMSClientBuilder.standard().withCredentials(new ProfileCredentialsProvider("")).build();
//    }
}
