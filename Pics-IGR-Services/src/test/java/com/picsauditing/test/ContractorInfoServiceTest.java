package com.picsauditing.test;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.BaseServiceHarness;
import com.picsauditing.data.model.entity.ContractorInfo;
import com.picsauditing.service.domain.IContractorInfoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
public class ContractorInfoServiceTest extends BaseServiceHarness{
    @Autowired
    @Qualifier("contractorInfoService")
    IContractorInfoService contractorInfoService;
    ContractorInfo cInfo;
    @Before
    public void setUp() throws Exception {
        cInfo= new ContractorInfo();
        cInfo.setBillingContact("Ancon Marine");
    }
    @Test
    public void testProcess(){
        log.trace("entered ContractorInfoServiceTest.testProcess({})",cInfo);
        log.debug("Contractor Information : {}",contractorInfoService.process(cInfo));

    }
    @After
    public void tearDown() throws Exception {

    }
}
