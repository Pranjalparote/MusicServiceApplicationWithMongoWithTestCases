package com.stackroute.MusicService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Music")
public class Music {
    @Id
    private int musicId;
    private String musicName;
    private String comment;
}
