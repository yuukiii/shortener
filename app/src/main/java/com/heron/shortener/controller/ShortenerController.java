package com.heron.shortener.controller;

import com.heron.shortener.common.ResponseBuilder;
import com.heron.shortener.model.Response;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static com.heron.shortener.common.IConstants.PROCESS_URL;

@RestController
@CrossOrigin
@RequestMapping("shortener")
public class ShortenerController {
    private static final Logger log = LoggerFactory.getLogger(ShortenerController.class);
    static final String STATUS_SUCCESS = "SUCCESS";
    static final String STATUS_FAILURE = "FAILURE";

    @Autowired
    ProducerTemplate producerTempalte;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping(value = "getShort")
    public ResponseEntity<Response> getShotURL(String id) {
        //TODO: get from cache
        return ResponseEntity.status(HttpStatus.OK).body(responseBuilder.buildResponse(STATUS_SUCCESS, "get short url here"));
    }

    @PostMapping(value = "postShort")
    public ResponseEntity<Response> generateShotURL(@RequestBody String url) {
        log.info("RAW URL TO BE SHORTENDED: " + url);

        String dcodedUrl = "";
        try {
            dcodedUrl = decode(url);
            log.info("DECODED URL: " + url);
            String shortUrl = (String) producerTempalte.requestBody(PROCESS_URL, url);
            return ResponseEntity.status(HttpStatus.OK).body(responseBuilder.buildResponse(STATUS_SUCCESS, shortUrl));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBuilder.buildResponse(STATUS_FAILURE, e.getLocalizedMessage()));

        }


    }

    private String decode(String value) throws UnsupportedEncodingException {
        return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
    }

}
