package com.stackroute.MusicService.repositoryTest;
import com.stackroute.MusicService.domain.Music;
import com.stackroute.MusicService.repository.MusicRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@DataMongoTest
public class MusicRepositoryTest {

@Autowired
    private MusicRepository musicRepository;
    private Music music;

    @Before
    public void setUp()
    {
        music = new Music();
        music.setMusicId(10);
        music.setMusicName("mahi we");
        music.setMusicId(101);
        music.setMusicName("kal ho n ho");

    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSaveMusic(){
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getMusicId()).get();
        Assert.assertEquals(101,fetchMusic.getMusicId());

    }

    @Test
    public void testSaveMusicFailure(){
        Music testMusic = new Music(34,"Harry","jony");
        musicRepository.save(music);
        Music fetchMusic= musicRepository.findById(music.getMusicId()).get();
        Assert.assertNotSame(testMusic,music);
    }

    @Test
    public void testshowAllMusic() {
        Music m = new Music(10, "mahi we", "Jenny");
        Music m1 = new Music(11, "bahara", "Jenny");
        musicRepository.save(m);
        musicRepository.save(m1);
        List<Music> list;
        list = new ArrayList();
        list = (List<Music>) musicRepository.findAll();
        Assert.assertEquals("mahi we", list.get(0).getMusicName());


    }


}