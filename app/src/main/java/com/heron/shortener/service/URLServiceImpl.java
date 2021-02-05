package com.heron.shortener.service;

import com.heron.shortener.domain.URL;
import com.heron.shortener.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class URLServiceImpl implements URLService{
    @Autowired
    private URLRepository urlRepository;

    @Override
    public List<URL> listAll() {
        List<URL> urls = new ArrayList<>();
        urlRepository.findAll().forEach(urls::add);
        return urls;
    }

    @Override
    public URL getById(String id) {
        return urlRepository.findById(id).orElse(null);
    }

    @Override
    public URL saveOrUpdate(URL url) {
        urlRepository.save(url);
        return url;
    }

    @Override
    public void delete(String id) {
        urlRepository.deleteById(id);
    }
}
