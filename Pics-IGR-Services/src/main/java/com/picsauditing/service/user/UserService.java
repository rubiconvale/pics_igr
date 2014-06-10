package com.picsauditing.service.user;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

import com.picsauditing.data.security.model.User;
import com.picsauditing.data.security.model.UserInformation;

import java.util.List;
/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */

public interface UserService {

    /**
     *
     * @param userId
     * @return
     */
    public User findUserById(Long userId);

    /**
     *
     * @param userName
     * @return
     */
    public User findUserByUsername(String userName);

    /**
     *
     * @param userId
     * @return
     */
    public UserInformation findUserInformationById(Long userId);

    /**
     *
     * @param userName
     * @return
     */
    public UserInformation findUserInformationByUsername(String userName);

    /**
     *
     * @return
     */
    public List<UserInformation> findAllUsers();

    /**
     *
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<UserInformation> findAllUsers(Integer firstResult, Integer maxResults);

    /**
     *
     * @param objectId
     * @return
     */
    public List<UserInformation> findAllUsers(Long objectId);

    /**
     *
     * @param objectId
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<UserInformation> findAllUsers(Long objectId, Integer firstResult, Integer maxResults);


    /**
     *
     * @param lastInitial
     * @return
     */
    public List<UserInformation> findAllUsers(String lastInitial);

    /**
     *
     * @param lastInitial
     * @param objectId
     * @return
     */
    public List<UserInformation> findAllUsers(String lastInitial, Long objectId);

    /**
     *
     * @param lastInitial
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<UserInformation> findAllUsers(String lastInitial, Integer firstResult, Integer maxResults);

    /**
     *
     * @param lastInitial
     * @param objectId
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<UserInformation> findAllUsers(String lastInitial, Long objectId, Integer firstResult, Integer maxResults);


    /**
     *
     * @return
     */
    public Long getUserCount();

    /**
     *
     * @param objectId
     * @return
     */
    public Long getUserCount(Long objectId);


    /**
     *
     * @param lastInitial
     * @return
     */
    public Long getUserCount(String lastInitial);

    /**
     *
     * @param lastInitial
     * @param objectId
     * @return
     */
    public Long getUserCount(String lastInitial, Long objectId);


}
