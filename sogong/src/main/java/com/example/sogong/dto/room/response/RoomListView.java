package com.example.sogong.dto.room.response;

import com.example.sogong.domain.room.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@Getter
@ToString
@AllArgsConstructor
public class RoomListView {

    private String name;

    private String subject;

    private int currentParticipants;

    private int setLimit;

    private RoomCategory roomCategory;

    private String code;
}
