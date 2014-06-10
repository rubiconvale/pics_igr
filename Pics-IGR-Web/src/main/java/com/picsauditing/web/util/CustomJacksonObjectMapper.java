package com.picsauditing.web.util;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

/**
 * @Author RNatarajan on 6/8/2014.
 * Modification Log :
 */




@Component(value="customJacksonObjectMapper")
public class CustomJacksonObjectMapper extends ObjectMapper {


    private static final long serialVersionUID = 1L;

    public CustomJacksonObjectMapper() {
        super();
        this.configure(DeserializationFeature.UNWRAP_ROOT_VALUE,true);
        this.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }


}