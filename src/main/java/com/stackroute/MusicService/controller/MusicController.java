package com.stackroute.MusicService.controller;

import com.stackroute.MusicService.exceptions.MusicAlreadyExistsException;
import com.stackroute.MusicService.exceptions.MusicNotFoundException;
import com.stackroute.MusicService.domain.Music;
import com.stackroute.MusicService.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MusicController {
    @Autowired
    private MusicService musicService;

    public MusicService getMusicService() {
        return musicService;
    }

    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }


    @RequestMapping(value = "music", method = RequestMethod.POST)
    public ResponseEntity<Music> saveTrack(@RequestBody Music music) throws MusicAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            Music musicOne = musicService.saveMusic(music);
            responseEntity = new ResponseEntity<Music>(music, HttpStatus.CREATED);
        } catch (MusicAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;


    }


    @RequestMapping(value = "music", method = RequestMethod.GET)
    public ResponseEntity<List<Music>> showAllMusic() {
        List<Music> musicOne = musicService.showAllMusic();
        return new ResponseEntity<List<Music>>(musicOne, HttpStatus.OK);
    }


    @RequestMapping(value = "music", method = RequestMethod.PUT)
    public ResponseEntity<Music> updateMusic(@RequestBody Music music) {
        ResponseEntity responseEntity;
        try {
            Music musicOne = musicService.updateComment(music);
            return new ResponseEntity<Music>(musicOne, HttpStatus.OK);
        } catch (MusicNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;

    }


    @RequestMapping(value = "music", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletemusic(@RequestBody Music music) {
        ResponseEntity responseEntity;
        try {
            boolean answer = musicService.deleteMusic(music);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (MusicNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;

    }

}
