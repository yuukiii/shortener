package com.heron.shortener.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.heron.shortener.common.IConstants.PROCESS_URL;

@Component
public class UrlRoute extends RouteBuilder {
    Logger log = LoggerFactory.getLogger(UrlRoute.class);
    private void init() {
        log.info("URL ROUTE");
    }


    @Override
    public void configure() {
        init();

        from(PROCESS_URL)
                .marshal() //
                .json(JsonLibrary.Jackson) //
                .log(LoggingLevel.INFO, "****** URL IN THE ROUTE", simple("${body} ").getText())//
                .bean("restShortenerServiceImpl", "shortenURL");
    }
}
