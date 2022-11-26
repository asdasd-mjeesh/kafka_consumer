package com.javamaster.model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "message")
public class Message extends BaseEntity {
    @Column(name = "message")
    private String message;
    @OneToOne(cascade = CascadeType.ALL)
    private MessageInfo messageInfo;
}
