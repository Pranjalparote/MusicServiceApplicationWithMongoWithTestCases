package com.stackroute.MusicService.MusicServiceTest;
import com.stackroute.MusicService.Exceptions.MusicAlreadyExistsException;
import com.stackroute.MusicService.domain.Music;
import com.stackroute.MusicService.repository.MusicRepository;
import com.stackroute.MusicService.service.MusicServiceDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class MusicServiceTest {

private Music music;

    //Create a mock for MusicRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into MusicServiceDatabase
    @InjectMocks
    private MusicServiceDatabase musicService;
    List<Music> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        music = new Music();
        music.setMusicId(101);
        music.setMusicName("Jenny");
        music.setComment("loud");
        list = new ArrayList<>();
        list.add(music);


    }

    @Test
    public void saveUserTestSuccess() throws MusicAlreadyExistsException {

        when(musicRepository.save((Music)any())).thenReturn(music);
        Music savedMusic = musicService.saveMusic(music);
        Assert.assertEquals(music,savedMusic);

        //verify here verifies that musicRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }

    @Test(expected = MusicAlreadyExistsException.class)
    public void saveUserTestFailure() throws MusicAlreadyExistsException {
        when(musicRepository.save((Music) any())).thenReturn(null);
        Music savedMusic = musicService.saveMusic(music);
        System.out.println("savedMusic" + savedMusic);
        Assert.assertEquals(music,savedMusic);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void showAllMusic(){

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> musiclist = musicService.showAllMusic();
        Assert.assertEquals(list,musiclist);
    }





}