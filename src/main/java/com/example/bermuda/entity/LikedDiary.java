package com.example.bermuda.entity;

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
public class LikedDiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long likedDiaryId;

    @ManyToOne
    @JoinColumn(name = "liked_user")
    private User likedUser;

    @ManyToOne
    @JoinColumn(name = "liked_diary")
    private Diary likedDiary;
}
