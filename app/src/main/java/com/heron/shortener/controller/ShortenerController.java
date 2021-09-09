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

import static com.heron.shortener.common.IConstants.CACHE_URL;
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
    }

    @PostMapping(value = "postShort")
    public ResponseEntity<Response> generateShotURL(@RequestBody String url) {
        //TODO
    }
}
