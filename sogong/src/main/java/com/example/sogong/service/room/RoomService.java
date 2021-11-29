package com.example.sogong.service.room;

import com.example.sogong.dto.room.request.RoomOpen;
import com.example.sogong.dto.room.response.ParticipantListView;
import com.example.sogong.dto.room.response.RoomListView;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
public interface RoomService {
    ResponseEntity<String> open(RoomOpen roomOpen);

    ResponseEntity<List<RoomListView>> list();

    ResponseEntity<List<ParticipantListView>> participant(Long roomid);

    ResponseEntity<List<RoomListView>> mylist(Long userid);

    ResponseEntity<List<RoomListView>> join(Long roomid, Long userid);
}
