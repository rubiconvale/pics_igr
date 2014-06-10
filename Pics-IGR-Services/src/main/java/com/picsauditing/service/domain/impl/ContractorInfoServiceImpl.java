package com.picsauditing.service.domain.impl;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.domaindao.IContractorInfoDao;
import com.picsauditing.data.model.entity.ContractorInfo;
import com.picsauditing.service.domain.AbstractBaseServiceImpl;
import com.picsauditing.service.domain.IContractorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@Service("contractorInfoService")
public class ContractorInfoServiceImpl extends AbstractBaseServiceImpl implements IContractorInfoService {
    @Autowired
    IContractorInfoDao contractorInfoDao;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public ContractorInfo process(ContractorInfo inputObject) {
        log.trace("entered ContractorInfoServiceImpl.process({})", inputObject);
       return contractorInfoDao.findContractorInfoByName(inputObject.getBillingContact());
    }
}
