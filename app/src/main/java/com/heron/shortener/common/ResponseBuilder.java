package com.heron.shortener.common;

import com.heron.shortener.model.Message;
import com.heron.shortener.model.Response;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public Response buildResponse(String status, String description) {
        Response response = new Response();
        Message message = new Message();
        response.setMessage(message);

        message.setStatus(status);
        message.setMessage(description);
        return response;
    }
}
