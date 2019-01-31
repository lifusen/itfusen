package com.itfusen.service.comm.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qing on 11/27/17.
 */
public class NoRedirectAuthFilter extends FormAuthenticationFilter {

    private static final String message = "Access denied.";

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(this.isLoginRequest(request, response)) {
            if(this.isLoginSubmission(request, response)) {
                return this.executeLogin(request, response);
            } else {
                return true;
            }
        } else {

            HttpServletResponse httpResponse ;
            try { httpResponse = WebUtils.toHttp(response); }
            catch (ClassCastException ex) {
                // Not a HTTP Servlet operation
                return super.onAccessDenied(request, response) ;
            }
            if ( message == null )
                httpResponse.sendError(403) ;
            else
                httpResponse.sendError(403, message) ;
//            this.saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }
}
