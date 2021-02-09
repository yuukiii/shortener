package com.heron.shortener.service;

public interface ShortenerService {
    String shortenURL(String longURL);

    void cacheURL(String longURL);

    String expandURL(String shortURL);
}
