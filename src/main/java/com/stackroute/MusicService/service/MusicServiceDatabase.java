package com.stackroute.MusicService.service;
import com.stackroute.MusicService.Exceptions.MusicAlreadyExistsException;
import com.stackroute.MusicService.Exceptions.MusicNotFoundException;
import com.stackroute.MusicService.domain.Music;
import com.stackroute.MusicService.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MusicServiceDatabase implements MusicService{
    @Autowired
    private MusicRepository musicRepository;
    private MusicServiceDatabase musicServiceDataBase;
    public MusicRepository getMusicRepository() {
        return musicRepository;
    }

    public void setMusicRepository(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }
    public MusicServiceDatabase(MusicRepository trackRepository) {
        this.musicRepository = trackRepository;
    }


    @Override
    public Music saveMusic(Music music ) throws MusicAlreadyExistsException {
        if (musicRepository.existsById(music.getMusicId()))
        {
            throw new MusicAlreadyExistsException("Music already exists");
        }
        Music musicOne = musicRepository.save(music);
        if (musicOne==null)
        {
            throw new MusicAlreadyExistsException("Music already exists");
        }
        return musicOne;
    }

    @Override
    public List<Music> showAllMusic() {
        List <Music> musicOne = (List<Music>) musicRepository.findAll();
        return musicOne;
    }



    @Override
    public Music updateComment(Music music) throws MusicNotFoundException {
        if (musicRepository.existsById(music.getMusicId()))
        {
            Music musicOne = musicRepository.findById(music.getMusicId()).get();
            musicOne.setComment(music.getComment());
            musicRepository.save(musicOne);
            return musicOne;
        }
        else
        {
            throw new MusicNotFoundException("Music not found exception");
            //return null;
        }
    }

    @Override
    public boolean deleteMusic(Music music) throws MusicNotFoundException{
        //boolean answer = false;
        if (musicRepository.existsById(music.getMusicId()))
        {
            musicRepository.deleteById(music.getMusicId());
            return true;
        }
        else
        {
            throw new MusicNotFoundException("Music not found exception");
        }

    }

   /* @Override
    public List<Music> getMusicByName(String musicName) throws MusicNotFoundException{

        List<Music> listOfMusic = null;
        listOfMusic = musicRepository.getMusicByName(musicName);
        if (listOfMusic.equals(null))
        {
            throw new MusicNotFoundException("Music not found exception");
        }
        return listOfMusic;
    }*/
}
