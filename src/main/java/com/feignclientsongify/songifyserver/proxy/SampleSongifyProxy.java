package com.feignclientsongify.songifyserver.proxy;

import com.feignclientsongify.songifyserver.dto.request.CreateSongRequestDto;
import com.feignclientsongify.songifyserver.dto.request.PartiallyUpdateSongRequestDto;
import com.feignclientsongify.songifyserver.dto.request.UpdateSongRequestDto;
import com.feignclientsongify.songifyserver.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify-client")
public interface SampleSongifyProxy {

    @PostMapping("/songs")
    CreateSongResponseDto addSong(@RequestBody CreateSongRequestDto request);

    @GetMapping("/songs")
    GetAllSongsResponseDto fetchAllSongs();

    @GetMapping("/songs/{id}")
    GetSongResponseDto getSongById(@PathVariable Integer id, @RequestHeader(required = false) String requestId);

    @DeleteMapping("/songs/{id}")
    DeleteSongResponseDto deleteSong(@PathVariable String id);

    @PutMapping("/songs/{id}")
    UpdateSongResponseDto updateSong(@PathVariable Integer id, @RequestBody UpdateSongRequestDto request);

    @PatchMapping("/songs/{id}")
    PartiallyUpdateResponseDto partiallyUpdatedSong(@PathVariable Integer id, @RequestBody PartiallyUpdateSongRequestDto request);

}
