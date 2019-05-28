package com.stackroute.MusicService.config;

import com.stackroute.MusicService.domain.Music;
import com.stackroute.MusicService.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

@Component
public class ApplicationListenerStart implements ApplicationListener<ContextRefreshedEvent>{

    private static final Logger logs = Logger.getLogger(ApplicationListenerStart.class);
        private MusicRepository musicRepository;

        @Autowired
        public ApplicationListenerStart(MusicRepository musicRepository){
            this.musicRepository=musicRepository;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
            logs.info("Inserting data on start");

            Music musicOne = new Music(11,"Faded","Singer : alen walker");
            musicRepository.save(musicOne);
            Music musicTwo = new Music(12,"coca cola tu","Singer : neha kakkar");
            musicRepository.save(musicTwo);

            logs.info("data successfully inserted");
        }
    }

