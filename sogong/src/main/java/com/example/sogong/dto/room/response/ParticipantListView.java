package com.example.sogong.dto.room.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@ToString
@AllArgsConstructor
@Getter
public class ParticipantListView {

    private long id;

    private String name;

    private String studentId;

    private String major;

}
