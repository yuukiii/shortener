package com.heron.shortener.repository;

import com.heron.shortener.domain.URL;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
@Component
public interface URLRepository extends CrudRepository<URL, String>{
}
