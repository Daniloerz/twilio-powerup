package com.twiliopowerup.twiliopowerup.infraestructure.input;

import com.twiliopowerup.twiliopowerup.application.dto.request.MessageRequestDto;
import com.twiliopowerup.twiliopowerup.application.handler.ITwilioHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twilio")
@RequiredArgsConstructor
public class TwilioController {

    private final ITwilioHandler twilioHandler;

    @PostMapping("/send-message")
    public ResponseEntity<Boolean> sendMessage (@RequestBody MessageRequestDto messageRequestDto){
        return ResponseEntity.ok(twilioHandler.sendMessage(messageRequestDto));
    }

}
