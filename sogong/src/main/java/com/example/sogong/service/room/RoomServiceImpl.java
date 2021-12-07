package com.example.sogong.service.room;

import com.example.sogong.domain.room.Room;
import com.example.sogong.domain.room.RoomRepository;
import com.example.sogong.domain.room.UserAndRoom;
import com.example.sogong.domain.room.UserAndRoomRepository;
import com.example.sogong.domain.user.User;
import com.example.sogong.domain.user.UserRepository;
import com.example.sogong.dto.room.request.RoomOpen;
import com.example.sogong.dto.room.response.ParticipantListView;
import com.example.sogong.dto.room.response.RoomListView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final UserAndRoomRepository userAndRoomRepository;

    @Override
    @Transactional
    public ResponseEntity<String> open(RoomOpen roomOpen) {
        Room room = Room.builder()
                .name(roomOpen.getName())
                .roomCategory(roomOpen.getRoomCategory())
                .subject(roomOpen.getSubject())
                .code(roomOpen.getCode())
                .setLimit(roomOpen.getSetLimit())
                .userAndRoomList(new ArrayList<>())
                .build();

        roomRepository.save(room);
        User user = userRepository.findById(roomOpen.getUserid()).get();

        UserAndRoom userAndRoom = UserAndRoom.builder()
                .userRoomUserId(user)
                .userRoomroomId(room)
                .build();

        room.addUserAndRoomList(userAndRoom);
        roomRepository.save(room);
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<List<RoomListView>> list() {
        List<Room> rooms = roomRepository.findAll();

        List<RoomListView> roomListViews = new ArrayList<>();

        rooms.forEach(room -> roomListViews.add(
                new RoomListView(
                        room.getId(),
                        room.getName(),
                        room.getSubject(),
                        room.getUserAndRoomList().size(),
                        room.getSetLimit(),
                        room.getRoomCategory(),
                        room.getCode()
                        )
        ));
        return ResponseEntity.ok(roomListViews);
    }

    @Override
    public ResponseEntity<List<ParticipantListView>> participant(Long roomid) {
        List<ParticipantListView> participantListViews = new ArrayList<>();
        List<UserAndRoom> userAndRooms = userAndRoomRepository.findUserAndRoomsByUserRoomroomId(roomRepository.findById(roomid).get());
        userAndRooms.forEach(userAndRoom -> participantListViews.add(
                new ParticipantListView(
                        userAndRoom.getUserRoomUserId().getId(),
                        userRepository.findById(userAndRoom.getUserRoomUserId().getId()).get().getName(),
                        userRepository.findById(userAndRoom.getUserRoomUserId().getId()).get().getStudentId(),
                        userRepository.findById(userAndRoom.getUserRoomUserId().getId()).get().getMajor()
                )
        ));
        return ResponseEntity.ok(participantListViews);
    }

    @Override
    public ResponseEntity<List<RoomListView>> mylist(Long userid) {
        List<Room> rooms = roomRepository.findAll();

        List<RoomListView> roomListViews = new ArrayList<>();

        rooms.forEach(room -> {

            if(!userAndRoomRepository.findUserAndRoomsByUserRoomroomIdAndUserRoomUserId(
                    roomRepository.findById(room.getId()).get(),
                    userRepository.findById(userid).get()
                    ).isEmpty()
            ){
                roomListViews.add(
                        new RoomListView(
                                room.getId(),
                                room.getName(),
                                room.getSubject(),
                                room.getUserAndRoomList().size(),
                                room.getSetLimit(),
                                room.getRoomCategory(),
                                room.getCode()
                        ));
            }
            }
        );

        return ResponseEntity.ok(roomListViews);
    }

    @Override
    public ResponseEntity<List<RoomListView>> join(Long roomid, Long userid) {
        Room getroom = roomRepository.findById(roomid).get();
        User getuser = userRepository.findById(userid).get();

        UserAndRoom userAndRoom = UserAndRoom.builder().userRoomUserId(getuser).userRoomroomId(getroom).build();

        getroom.addUserAndRoomList(userAndRoom);
        roomRepository.save(getroom);
        List<Room> rooms = roomRepository.findAll();

        List<RoomListView> roomListViews = new ArrayList<>();

        rooms.forEach(room -> {

                    if(!userAndRoomRepository.findUserAndRoomsByUserRoomroomIdAndUserRoomUserId(
                            roomRepository.findById(room.getId()).get(),
                            userRepository.findById(userid).get()
                    ).isEmpty()
                    ){
                        roomListViews.add(
                                new RoomListView(
                                        room.getId(),
                                        room.getName(),
                                        room.getSubject(),
                                        room.getUserAndRoomList().size(),
                                        room.getSetLimit(),
                                        room.getRoomCategory(),
                                        room.getCode()
                                ));
                    }
                }
        );

        return ResponseEntity.ok(roomListViews);

    }
}
