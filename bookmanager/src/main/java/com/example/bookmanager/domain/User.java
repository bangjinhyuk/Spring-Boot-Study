package com.example.bookmanager.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@EntityListeners(value =  UserEntityListener.class)
public class User extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) // enum 을 사용할때에는 string으로 해줘야댐
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
//    @Column(name = "crtdat",nullable = false) // 데베에 이름 지정
//    @Column(insertable = false)

//    @CreatedDate
//    private LocalDateTime createdAt;
////    @Column(insertable = false,updatable = false)// insert, update 적용 여부 지정 가능
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//
//    @Transient // 디비에 반영 안되는값을 만들때 사용하는 것
//    private String testData;

//    @PrePersist //insert 전
//    @PreUpdate  //merge 전
//    @PreRemove  //delete 전
//    @PostPersist
//    @PostUpdate
//    @PostRemove
//    @PostLoad   //select 이후

//    @PrePersist
//    public void PrePersist(){
//        System.out.println(">>> PrePersist");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//    @PreUpdate
//    public void PreUpdate(){
//        System.out.println(">>> PreUpdate");
//        this.updatedAt = LocalDateTime.now();
//    }
    @PreRemove
    public void PreRemove(){
        System.out.println(">>> PreRemove");
    }
    @PostPersist
    public void PostPersist(){
        System.out.println(">>> PostPersist");
    }
    @PostUpdate
    public void PostUpdate(){
        System.out.println(">>> PostUpdate");
    }
    @PostRemove
    public void PostRemove(){
        System.out.println(">>> PostRemove");
    }
    @PostLoad
    public void PostLoad(){
        System.out.println(">>> PostLoad");
    }

}
