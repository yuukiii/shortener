package com.heron.shortener.repository;

import com.heron.shortener.domain.URL;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface URLRepository extends CrudRepository<URL, String>{
}
