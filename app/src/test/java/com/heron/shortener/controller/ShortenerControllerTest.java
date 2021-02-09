package com.heron.shortener.controller;

import static org.assertj.core.api.Assertions.assertThat;
import com.heron.shortener.ShortenerApplication;
import com.heron.shortener.domain.URL;
import com.heron.shortener.repository.URLRepository;
import com.heron.testing.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ShortenerApplication.class)
@AutoConfigureMockMvc
public class ShortenerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private URLRepository repository;

    @Test
    public void whenValidInput_thenCreateUrl() throws IOException, Exception {
        mvc.perform(post("/url/shortener/postShort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson("https://www.w3schools.com/jsref/jsref_sort.asp")));

        List<URL> found = (List<URL>) repository.findAll();
        assertThat(found).extracting(URL::getUrl).asList().hasSizeGreaterThan(0);
    }
}
