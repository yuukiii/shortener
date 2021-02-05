package com.heron.shortener.service;

import com.heron.shortener.domain.URL;

import java.util.List;

public interface URLService {
    List<URL> listAll();

    URL getById(String id);

    URL saveOrUpdate(URL url);

    void delete(String id);

}
