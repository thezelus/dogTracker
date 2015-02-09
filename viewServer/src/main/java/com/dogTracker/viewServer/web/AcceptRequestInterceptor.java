package com.dogTracker.viewServer.web;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class AcceptRequestInterceptor implements ClientHttpRequestInterceptor {

    private final MediaType mediaType;

    public AcceptRequestInterceptor(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("Accept", mediaType.getType());
        return execution.execute(request,body);
    }
}
