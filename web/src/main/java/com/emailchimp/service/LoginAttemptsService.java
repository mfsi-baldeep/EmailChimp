/**
 * ****************************************************************************
 *
 * Copyright (c) 2016, Mindfire Solutions and/or its affiliates. All rights
 * reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Mindfire and its suppliers,if any. The intellectual and technical concepts
 * contained herein are proprietary to Mindfire Solutions. and its suppliers and
 * may be covered by us and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from Mindfire Solutions
 */
package com.emailchimp.service;

import com.emailchimp.core.service.CommonService;
import com.emailchimp.model.LoginAttempts;

/**
 *
 * @author baldeep
 */
public interface LoginAttemptsService extends CommonService<LoginAttempts> {

    void updateFailAttempts(String username);

    void resetFailAttempts(String username);

    LoginAttempts getUserAttempts(String username);
}
