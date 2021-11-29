package com.example.sogong.controller;

import com.example.sogong.dto.room.request.RoomOpen;
import com.example.sogong.dto.room.response.ParticipantListView;
import com.example.sogong.dto.room.response.RoomListView;
import com.example.sogong.service.room.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by bangjinhyuk on 2021/11/28.
 */
@RequestMapping("/room")
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"방 Controller"}) //제목
public class RoomController {

    private final RoomService roomService;

    /**
     * 방 생성
     */
    @PostMapping("/open")
    @ApiOperation(value = "방 생성" , notes = "성공시 success 리턴")
    public ResponseEntity<String> open(@Valid @RequestBody RoomOpen roomOpen){
        log.info("roomOpen: {}",roomOpen);
        return roomService.open(roomOpen);
    }

    /**
     * 방 목록 가져오기
     */
    @GetMapping("/list")
    @ApiOperation(value = "방 목록 가져오기", notes = "모든 방 리스트 리턴")
    public ResponseEntity<List<RoomListView>> list(){
        return roomService.list();
    }

    /**
     * 참여중인 방 목록 가져오기
     */
    @GetMapping("/mylist")
    @ApiOperation(value = "참여중인 방 목록 가져오기" , notes = "참여중인 방 리스트 리턴")
    public ResponseEntity<List<RoomListView>> mylist(@RequestParam Long userid){
        return roomService.mylist(userid);
    }

    /**
     * 방 참가 인원 목록 가져오기
     */
    @GetMapping("/participant")
    @ApiOperation(value = "방 참가 인원 목록 가져오기" , notes = "방 참가자 리스트 리턴")
    public ResponseEntity<List<ParticipantListView>> participant(@RequestParam Long roomid){
        return roomService.participant(roomid);
    }

    /**
     * 방 참가 신청
     */
    @GetMapping("/join")
    @ApiOperation(value = "방 참가 신청", notes = "모든 방 리스트 리턴")
    public ResponseEntity<List<RoomListView>> join(@RequestParam Long roomid, @RequestParam Long userid){
        return roomService.join(roomid, userid);
    }

}
