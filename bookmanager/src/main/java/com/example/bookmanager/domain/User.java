package com.example.bookmanager.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table
public class User {
    @Id //pk
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) // enum 을 사용할때에는 string으로 해줘야댐
    private Gender gender;

//    @Column(name = "crtdat",nullable = false) // 데베에 이름 지정
    @Column(insertable = false)
    private LocalDateTime createdAt;
//    @Column(insertable = false,updatable = false)// insert, update 적용 여부 지정 가능
    private LocalDateTime updatedAt;

    @Transient // 디비에 반영 안되는값을 만들때 사용하는 것
    private String testData;


}
