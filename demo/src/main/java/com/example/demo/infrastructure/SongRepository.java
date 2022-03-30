package com.example.demo.infrastructure;

import com.example.demo.domain.Albums;
import com.example.demo.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Song findByTitle(String title);
    List findByAlbums (Albums albums);
}
