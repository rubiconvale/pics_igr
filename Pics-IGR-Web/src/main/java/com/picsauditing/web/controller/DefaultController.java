
package com.picsauditing.web.controller;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */
@Controller
public class DefaultController {

    final Logger log = LoggerFactory.getLogger(this.getClass());
/**  TODO
    @Autowired
    UserContextService userContextService;
*/
    @RequestMapping("login")
    public String loginView(Model model) {
        return "login";
    }

    @RequestMapping("index")
    public String indexView(Model model) {
        ObjectMapper mapper = new ObjectMapper();
        /**  TODO
        try {
           model.addAttribute("user", mapper.writeValueAsString(userContextService.getCurrentUser()));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
         */
        return "index";
    }


}
