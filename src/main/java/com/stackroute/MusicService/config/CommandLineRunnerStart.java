package com.stackroute.MusicService.config;

import com.stackroute.MusicService.domain.Music;
import com.stackroute.MusicService.repository.MusicRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerStart implements CommandLineRunner {
    public static final Logger logs = LoggerFactory.getLogger(CommandLineRunnerStart.class);
    private MusicRepository musicRepository;

    @Autowired
    public CommandLineRunnerStart(MusicRepository musicRepository){
        this.musicRepository=musicRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        logs.info("Inserting data on start");

        Music musicOne = new Music(5,"dilbar","Singer : basu");
        musicRepository.save(musicOne);
        Music musicTwo = new Music(6,"chek de","Singer : tony kakkar");
        musicRepository.save(musicTwo);
        logs.info("data successfully inserted");
    }
}
