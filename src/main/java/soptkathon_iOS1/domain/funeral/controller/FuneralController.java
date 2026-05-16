package soptkathon_iOS1.domain.funeral.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soptkathon_iOS1.domain.funeral.dto.FuneralResponse;
import soptkathon_iOS1.domain.funeral.service.FuneralService;
import soptkathon_iOS1.global.common.dto.BaseResponse;
import soptkathon_iOS1.global.common.entity.SuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FuneralController {
    private final FuneralService funeralService;

    @GetMapping("/{userId}/goals/{goalId}/funeral")
    public BaseResponse<FuneralResponse> getFuneral(
            @PathVariable Long userId,
            @PathVariable Long goalId
    ) {
        return BaseResponse.success(
                SuccessCode.GET_SUCCESS,
                funeralService.getFuneral(userId, goalId)
        );
    }
}
