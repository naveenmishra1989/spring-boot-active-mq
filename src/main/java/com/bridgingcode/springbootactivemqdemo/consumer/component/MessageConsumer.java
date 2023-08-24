package com.bridgingcode.springbootactivemqdemo.consumer.component;

import com.bridgingcode.springbootactivemqdemo.model.SystemMessage;
import com.bridgingcode.springbootactivemqdemo.repo.SystemMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageConsumer {

    private final SystemMessageRepository systemMessageRepository;

    @JmsListener(destination = "naveen-queue")
    public void messageListener(SystemMessage systemMessage) {
        SystemMessage message = systemMessageRepository.save(systemMessage);
        log.info("Message received! {}", message);

    }
}
