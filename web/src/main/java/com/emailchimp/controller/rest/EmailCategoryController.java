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
package com.emailchimp.controller.rest;

import com.emailchimp.constants.EmailConstants;
import com.emailchimp.core.model.Account;
import com.emailchimp.core.model.EmailCategory;
import com.emailchimp.core.model.EmailCategoryBean;
import com.emailchimp.core.service.AccountService;
import com.emailchimp.core.service.EmailCategoryService;
import java.security.Principal;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author baldeep
 */
@RestController
@CrossOrigin(origins = "*")
public class EmailCategoryController {

    @Autowired
    EmailCategoryService emailCategoryService;
    @Autowired
    AccountService accountService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping(EmailConstants.URL_ADD_EMAIL_CATEGORY)
    public String addEmailCategory(EmailCategory emailCategory, Principal principal, Locale locale) {
        try {

            Account account = accountService.findByUniqueField("userEmail", principal.getName());
            emailCategory.setAccount(account);
            emailCategory.setAddedDate(Calendar.getInstance());

            emailCategoryService.save(emailCategory);

        } catch (Exception e) {
            e.printStackTrace();
            return messageSource.getMessage("email.category.failure", new Object[]{}, locale);
        }
        return messageSource.getMessage("email.category.success", new Object[]{}, locale);
    }

    @GetMapping(EmailConstants.URL_GET_EMAIL_CATEGORY)
    public List<EmailCategoryBean> getEmailCategory(Principal principal) {
        try {

            Account account = accountService.findByUniqueField("userEmail", principal.getName());
            
            return emailCategoryService.getEmailCategoryBean(account);
            
//            return emailCategoryService.findByField("account", account);
        } catch (Exception e) {
        }
        return null;
    }

    @PostMapping(EmailConstants.URL_DELETE_EMAIL_CATEGORY)
    public String deleteEmailCategory(Long id, Principal principal, Locale locale) {
        try {

            EmailCategory emailCategory = emailCategoryService.findByUniqueField("id", id);
            Account account = accountService.findByUniqueField("userEmail", principal.getName());

            if (emailCategory.getAccount().getId() == account.getId()) {

                emailCategoryService.delete(emailCategory);
                return messageSource.getMessage("email.category.delete.success", new Object[]{}, locale);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return messageSource.getMessage("email.category.delete.failure", new Object[]{}, locale);
        }
        return messageSource.getMessage("email.category.delete.failure", new Object[]{}, locale);
    }

    @PostMapping(EmailConstants.URL_UPDATE_EMAIL_CATEGORY)
    public String updateEmailCategory(EmailCategory emailCategory, Principal principal, Locale locale) {
        try {
            Account account = accountService.findByUniqueField("userEmail", principal.getName());

            emailCategory.setAccount(account);
            emailCategoryService.update(emailCategory);

        } catch (Exception e) {
            return messageSource.getMessage("email.category.update.failure", new Object[]{}, locale);
        }
        return messageSource.getMessage("email.category.update.success", new Object[]{}, locale);
    }
}
