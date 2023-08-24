package com.bridgingcode.springbootactivemqdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemMessage implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String source;
    private String message;


}
