package com.example.bermuda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class DiaryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    @NotEmpty
    private String original_file_name;
    @NotEmpty
    private String stored_file_path;

    private long file_size;

    //프로필 이미지로 사용할 때 사용하는 속성
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    public void updateDiaryImage(String original_file_name, String stored_file_path, long file_size){
        this.original_file_name = original_file_name;
        this.stored_file_path = stored_file_path;
        this.file_size = file_size;
    }
}
