package com.feignclientsongify.songifyserver.dto.response;

import com.feignclientsongify.songifyserver.model.Song;

public record PartiallyUpdateResponseDto(Song updatedSong) {
}
