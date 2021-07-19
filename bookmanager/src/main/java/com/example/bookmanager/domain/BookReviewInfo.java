package com.example.bookmanager.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by bangjinhyuk on 2021/07/19.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Book book;

//    private Long bookId;

    private float averageReviewScore;

    private int reviewCount;

}
