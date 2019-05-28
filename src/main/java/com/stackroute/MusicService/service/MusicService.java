package com.stackroute.MusicService.service;

import com.stackroute.MusicService.exceptions.MusicAlreadyExistsException;
import com.stackroute.MusicService.exceptions.MusicNotFoundException;
import com.stackroute.MusicService.domain.Music;

import java.util.List;

public interface MusicService {
    Music saveMusic(Music music) throws MusicAlreadyExistsException;

    List<Music> showAllMusic();

    Music updateComment(Music music) throws MusicNotFoundException;

    boolean deleteMusic(Music music) throws MusicNotFoundException;

}
