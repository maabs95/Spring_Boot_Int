package com.util.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class AutomaticHttpLoggingFilter extends OncePerRequestFilter {

    private static final Logger httpLogger = LoggerFactory.getLogger("http-logger");
    private static final int MAX_CACHE_LIMIT_BYTES = 10 * 1024 * 1024;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request, MAX_CACHE_LIMIT_BYTES);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            logRequest(wrappedRequest);
            logResponse(wrappedResponse);
            wrappedResponse.copyBodyToResponse();
        }
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        String body = getContentAsString(request.getContentAsByteArray(), request.getCharacterEncoding());
        httpLogger.info("REQ | {} | {} | {}", request.getMethod(), request.getRequestURI(), body);
    }

    private void logResponse(ContentCachingResponseWrapper response) {
        String body = getContentAsString(response.getContentAsByteArray(), response.getCharacterEncoding());
        httpLogger.info("RES | {} | {}", response.getStatus(), body);
    }

    private String getContentAsString(byte[] buf, String encoding) {
        if (buf == null || buf.length == 0) return "";
        try {
            return new String(buf, 0, buf.length, encoding);
        } catch (UnsupportedEncodingException e) {
            return "[Unsupported Encoding]";
        }
    }
}
