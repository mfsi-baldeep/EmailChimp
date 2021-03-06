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
package com.emailchimp.core.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author baldeep
 */
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = false, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column(unique = true, nullable = false)
    private String userMobile;

    @Column(unique = false, nullable = false)
    private String userRole;

    @Column(unique = false, nullable = false)
    private String userPassword;

    @Column(unique = false, nullable = false)
    private int userEnabled = 1;

     @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Calendar createdDate;

    @Column(unique = false)
    private String forgotPasswordCode;

     @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true, updatable = true)
    private Calendar forgotPasswordExpiryDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = true)
    private Calendar lastPasswordUpdatedDate;

    @Column(unique = false, nullable = false)
    private String verificationCode;

    @Column(unique = false, nullable = false)
    private boolean isVerified = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Calendar verificationDate;

    @Column(unique = false, nullable = false)
    private boolean isActive = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Calendar activationDate;

    @Column(unique = false, nullable = true)
    private String activationStatus;

    @Column(unique = false, nullable = true)
    private boolean accountNonExpired = true;
    
    @Column(unique = false, nullable = true)
    private boolean accountNonLocked = true;
    
    @Column(unique = false, nullable = true)
    private boolean credentialsNonExpired = true;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public long getId() {
        return id;
    }

    public void setId(long userId) {
        this.id = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(int userEnabled) {
        this.userEnabled = userEnabled;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public String getForgotPasswordCode() {
        return forgotPasswordCode;
    }

    public void setForgotPasswordCode(String forgotPasswordCode) {
        this.forgotPasswordCode = forgotPasswordCode;
    }

    public Calendar getForgotPasswordExpiryDate() {
        return forgotPasswordExpiryDate;
    }

    public void setForgotPasswordExpiryDate(Calendar forgotPasswordExpiryDate) {
        this.forgotPasswordExpiryDate = forgotPasswordExpiryDate;
    }

    public Calendar getLastPasswordUpdatedDate() {
        return lastPasswordUpdatedDate;
    }

    public void setLastPasswordUpdatedDate(Calendar lastPasswordUpdatedDate) {
        this.lastPasswordUpdatedDate = lastPasswordUpdatedDate;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Calendar getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Calendar verificationDate) {
        this.verificationDate = verificationDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Calendar getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Calendar activationDate) {
        this.activationDate = activationDate;
    }

    public String getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(String activationStatus) {
        this.activationStatus = activationStatus;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobile=" + userMobile + ", userRole=" + userRole + ", userPassword=" + userPassword + ", userEnabled=" + userEnabled + ", createdDate=" + createdDate + ", forgotPasswordCode=" + forgotPasswordCode + ", forgotPasswordExpiryDate=" + forgotPasswordExpiryDate + ", lastPasswordUpdatedDate=" + lastPasswordUpdatedDate + ", verificationCode=" + verificationCode + ", isVerified=" + isVerified + ", verificationDate=" + verificationDate + ", isActive=" + isActive + ", activationDate=" + activationDate + ", activationStatus=" + activationStatus + ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired + '}';
    }
    
}
