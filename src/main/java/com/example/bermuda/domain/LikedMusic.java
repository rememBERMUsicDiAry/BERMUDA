package com.example.bermuda.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LikedMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long likedMusicId;

    @ManyToOne
    @JoinColumn(name = "liked_user")
    private User likedUser;

    @ManyToOne
    @JoinColumn(name = "liked_Music")
    private Music likedMusic;
}
