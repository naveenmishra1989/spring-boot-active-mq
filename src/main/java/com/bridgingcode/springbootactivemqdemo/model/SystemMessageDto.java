package com.bridgingcode.springbootactivemqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemMessageDto {
    private String source;
    private String message;

    public static SystemMessage getSystemMessage(SystemMessageDto systemMessageDto){
        return SystemMessage.builder().source(systemMessageDto.getSource())
                .message(systemMessageDto.getMessage()).build();
    }
}
