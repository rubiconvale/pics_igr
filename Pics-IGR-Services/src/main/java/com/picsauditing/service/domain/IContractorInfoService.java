package com.picsauditing.service.domain;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.model.entity.ContractorInfo;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */

public interface IContractorInfoService {

    public abstract ContractorInfo process(ContractorInfo inputObject);
}
