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
package com.emailchimp.handler;

import com.emailchimp.constants.ExceptionConstants;
import com.emailchimp.exception.EmailChimpException;
import com.emailchimp.model.ResponseModel;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.web.authentication.rememberme.CookieTheftException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author baldeep
 */
@ControllerAdvice
public class ExceptionAdviceHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle(Exception ex) {
		return new ModelAndView(ExceptionConstants.URL_ERROR_PAGE, ExceptionConstants.ERROR_MESSAGE, ex.getMessage());
	}

	// @ExceptionHandler()
	// public @ResponseBody
	// ResponseModel emailChimpException(HttpServletRequest request,
	// EmailChimpException ex) {
	// ResponseModel response = new ResponseModel();
	// response.setUrl(request.getRequestURL().toString());
	// response.setMessage(ex.getMessage());
	// response.setStatus(ex.getStatusCode());
	// return response;
	// }

	@ExceptionHandler({ HttpMessageNotReadableException.class, EmailChimpException.class, CookieTheftException.class })
	@ResponseBody
	public ResponseModel httpMessageNotReadableException(HttpServletRequest request, Exception ex) {
		ResponseModel response = new ResponseModel();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		response.setStatus(ExceptionConstants.RES_CODE_FAILURE);
		
		if(ex instanceof EmailChimpException){
			EmailChimpException emException = (EmailChimpException)ex;
			response.setStatus(emException.getStatusCode());
			
		}
		
		return response;
	}

	// /**
	// *
	// * To be verified
	// * @param request
	// * @param ex
	// * @return
	// */
	// @ExceptionHandler(org.springframework.security.web.authentication.rememberme.CookieTheftException.class)
	// public @ResponseBody
	// ExceptionJSONInfo handleCookieTheftException(HttpServletRequest request,
	// Exception ex) {
	// ExceptionJSONInfo response = new ExceptionJSONInfo();
	// response.setUrl(request.getRequestURL().toString());
	// response.setMessage(ex.getMessage());
	// return response;
	// }
}
