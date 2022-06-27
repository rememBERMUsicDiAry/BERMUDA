package com.example.bermuda.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long diaryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String mainText;
    private Boolean open;
    private Integer likeNum;

    @OneToMany(mappedBy = "diary")
    @JsonManagedReference
    private List<DiaryImage> diaryImageList = new ArrayList<>();
}
