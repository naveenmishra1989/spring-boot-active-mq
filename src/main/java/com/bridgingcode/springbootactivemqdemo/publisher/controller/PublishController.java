package com.bridgingcode.springbootactivemqdemo.publisher.controller;

import com.bridgingcode.springbootactivemqdemo.model.SystemMessage;
import com.bridgingcode.springbootactivemqdemo.model.SystemMessageDto;
import com.bridgingcode.springbootactivemqdemo.repo.SystemMessageRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublishController {

    private final JmsTemplate jmsTemplate;

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessageDto systemMessageDto) {
        try {

            jmsTemplate.convertAndSend("naveen-queue", SystemMessageDto.getSystemMessage(systemMessageDto));

            return new ResponseEntity<>("Sent.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
