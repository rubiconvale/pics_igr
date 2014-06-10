package com.picsauditing.test;

import com.picsauditing.BaseDaoHarness;
import com.picsauditing.data.domaindao.IContractorInfoDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ContractorInfoDaoImplTest extends BaseDaoHarness {

    @Autowired
    IContractorInfoDao contractorInfoDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    @Transactional
    public void testFindContractorInfoByName() throws Exception {
        contractorInfoDao.findContractorInfoByName("Ancon Marine");
    }

    @Test
    public void testFindAllContractorInfo() throws Exception {

    }
}