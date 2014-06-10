package com.picsauditing;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */



@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(name="ps", value={"classpath*:db.properties"})
@ContextConfiguration(locations= {"classpath*:test-pics-dao.xml","classpath*:pics-ehcache.xml"})
@TransactionConfiguration(defaultRollback=true, transactionManager="svcTxnManager")
@Transactional
public class BaseDaoHarness {

    protected final Logger log= LoggerFactory.getLogger(this.getClass());

    public void test(){
        log.debug("CLASS PATH :"+System.getProperty("java.class.path"));
    }
}

