package com.picsauditing.web.controller;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.model.entity.ContractorInfo;
import com.picsauditing.service.domain.IContractorInfoService;
import com.picsauditing.web.model.ContractorInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@Controller(value = "contractorInfo")
@RequestMapping("/contractorInfo")
@SessionAttributes("contractorInfoBean")
public class ContractorInfoController {
    @Autowired
    IContractorInfoService contractorInfoService;

    // Invoked initially to create the "form" attribute
    // Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

    @ModelAttribute("contractorInfoBean")
    public ContractorInfoModel createFormBean() {
        return new ContractorInfoModel();
    }

    @RequestMapping(method=RequestMethod.GET)
    public String form(Model model) {
        ContractorInfo cInfo= new ContractorInfo();
        cInfo.setBillingContact("Ancon Marine"); //TODO hard coded
        cInfo=contractorInfoService.process(cInfo);

        model.addAttribute("billingContact",cInfo.getBillingContact());
        model.addAttribute("billingPhone",cInfo.getBillingPhone());
        model.addAttribute("description",cInfo.getDescription());
        return "/ContractorInfo";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String processSubmit(@Valid ContractorInfoModel infoModel, BindingResult result,
                                @ModelAttribute("ajaxRequest") boolean ajaxRequest,
                                Model model, RedirectAttributes redirectAttrs) {
    return null;
    }

}

