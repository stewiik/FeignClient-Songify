package com.feignclientsongify;

import com.feignclientsongify.songifyserver.dto.request.CreateSongRequestDto;
import com.feignclientsongify.songifyserver.dto.response.GetSongResponseDto;
import com.feignclientsongify.songifyserver.dto.request.UpdateSongRequestDto;
import com.feignclientsongify.songifyserver.proxy.SampleSongifyProxy;
import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class FeignClientSongifyApplication {

    @Autowired
    private SampleSongifyProxy sampleSongifyClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignClientSongifyApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {
            sampleSongifyClient.addSong(new CreateSongRequestDto("song5", "Shawn Mendes"));
            log.info(sampleSongifyClient.fetchAllSongs());

            GetSongResponseDto songById = sampleSongifyClient.getSongById(50, "aaa");
            log.info(songById);

            sampleSongifyClient.deleteSong("3");
            log.info(sampleSongifyClient.fetchAllSongs());

            sampleSongifyClient.updateSong(1, new UpdateSongRequestDto("lala", "Madonna"));
            log.info(sampleSongifyClient.fetchAllSongs());

        } catch (FeignException e) {
            log.error(e.getMessage() + "\n" + e.status());
        }
    }
}
