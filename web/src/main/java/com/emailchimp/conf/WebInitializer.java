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
package com.emailchimp.conf;

/**
 *
 * @author baldeep
 */
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new CorsFilter() };
    }
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        registration.setMultipartConfig(getMultipartConfigElement());
    }
    
    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }
 
    private static final String LOCATION = "/home/anshul/tmpFiles/"; // Temporary location where files will be stored
 
    private static final long MAX_FILE_SIZE = 15242880; // 15MB : Max file size.
                                                        // Beyond that size spring will throw exception.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
     
    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
}
