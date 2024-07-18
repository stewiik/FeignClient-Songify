package com.feignclientsongify.songifyserver.dto.response;

import com.feignclientsongify.songifyserver.model.Song;

import java.util.Map;

public record GetAllSongsResponseDto(Map<Integer, Song> songs) {
}
