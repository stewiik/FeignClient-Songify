package com.feignclientsongify.songifyserver.dto.response;

import com.feignclientsongify.songifyserver.model.Song;

public record GetSongResponseDto(Song song) {
}
