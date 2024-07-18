package com.feignclientsongify.songifyserver.dto.response;

import com.feignclientsongify.songifyserver.model.Song;

import java.util.Map;

public record CreateSongResponseDto(Map<Integer, Song> songs) {
}
