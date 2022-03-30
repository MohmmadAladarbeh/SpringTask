package com.example.demo.infrastructure;

import com.example.demo.domain.Albums;
import org.springframework.data.repository.CrudRepository;

public interface AlbumsRepository  extends CrudRepository <Albums, Long> {

}
