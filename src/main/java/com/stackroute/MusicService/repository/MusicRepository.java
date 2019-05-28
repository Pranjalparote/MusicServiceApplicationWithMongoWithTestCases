package com.stackroute.MusicService.repository;

import com.stackroute.MusicService.domain.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {
}

