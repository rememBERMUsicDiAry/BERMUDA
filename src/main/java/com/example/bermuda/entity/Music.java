package com.example.bermuda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicId;
    @NotEmpty
    private String original_file_name;
    @NotEmpty
    private String stored_file_path;

    private long file_size;

    //프로필 이미지로 사용할 때 사용하는 속성
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    public void updateMusic(String original_file_name, String stored_file_path, long file_size) {
        this.original_file_name = original_file_name;
        this.stored_file_path = stored_file_path;
        this.file_size = file_size;
    }
}