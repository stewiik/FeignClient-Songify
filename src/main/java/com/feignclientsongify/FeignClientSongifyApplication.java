package com.feignclientsongify;

import com.feignclientsongify.songifyserver.dto.request.CreateSongRequestDto;
import com.feignclientsongify.songifyserver.dto.response.*;
import com.feignclientsongify.songifyserver.dto.request.*;
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
            CreateSongResponseDto newSong = sampleSongifyClient.addSong(new CreateSongRequestDto("song5", "Shawn Mendes"));
            log.info("Song added: " + newSong);

            GetAllSongsResponseDto songs = sampleSongifyClient.fetchAllSongs();
            log.info(songs);

            GetSongResponseDto songById = sampleSongifyClient.getSongById(50, "aaa");
            log.info(songById);

            DeleteSongResponseDto deletedSong = sampleSongifyClient.deleteSong("3");
            log.info("Deleted song: " + deletedSong);

            UpdateSongResponseDto updatedSong = sampleSongifyClient.updateSong(1, new UpdateSongRequestDto("lala", "Madonna"));
            log.info("Updated song: " + updatedSong);

            PartiallyUpdateResponseDto partiallyUpdatedSong = sampleSongifyClient.partiallyUpdatedSong(1, new PartiallyUpdateSongRequestDto("sooong", "null"));
            log.info("Partially updated song: " + partiallyUpdatedSong);

        } catch (FeignException e) {
            log.error(e + "\n" + e.status());
        }
    }
}
