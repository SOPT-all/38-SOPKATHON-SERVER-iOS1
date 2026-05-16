package soptkathon_iOS1.domain.friend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import soptkathon_iOS1.domain.friend.dto.FriendResponse;
import soptkathon_iOS1.domain.friend.service.FriendService;
import soptkathon_iOS1.global.common.dto.BaseResponse;
import soptkathon_iOS1.global.common.entity.SuccessCode;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/api/v1/{userId}/friends")
    public ResponseEntity<BaseResponse<List<FriendResponse>>> getFriends(@PathVariable Long userId) {
        List<FriendResponse> friends = friendService.getFriends(userId);
        return ResponseEntity.ok(BaseResponse.success(SuccessCode.GET_SUCCESS, friends));
    }
}
