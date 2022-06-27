package com.example.bermuda.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User implements UserDetails {
        //유저가 사용할 아이디
    @NotNull
    @Id
    @Column(unique = true)
    private String userId;
    //비밀번호
    //@NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPw;
    //이메일
    //@NotNull
    @Email
    @Column(unique = true)
    private String email;

    private String userName;
    private String nickName;

    private String introduction;

    //userAuth??
    //@NotNull
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>(); // 회원이 가지고 있는 권한 정보들

    //계정 추가 시각
    //@NotNull
    private String appendDate;

    //계정 수정 시각
    //@NotNull
    private String updateDate;

    //유저 프로필이 저장될 경로
    //@NotNull
    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private ProfileImage profileImage;

    private Integer followingNum;
    private Integer followerNum;

    private String provider;
    private String refreshToken;
    private Boolean emailAuth;

    private Boolean subscription;

    //내가 쓴 리뷰 리스트
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Diary> myDiaryList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Music> myMusicList = new ArrayList<>();

    public void updatePassword(String userPw){
        this.userPw = userPw;
    }

    //이건 유저 이름 리턴하는건데 getUsername 오버라이드 된 것 때문에 오류 생겨서 getter로 안되는 듯
    public String getUserName(){
        return this.userName;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void emailVerifiedSuccess() {
        this.emailAuth = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.userPw;
    }

    //이건 유일키 넘겨주는것
    @Override
    public String getUsername() {
        return this.userId;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
