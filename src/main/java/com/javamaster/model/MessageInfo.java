package com.javamaster.model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "message_info")
public class MessageInfo extends BaseEntity {
    @Column(name = "sending_date")
    private LocalDateTime dateOfSending;

    @ManyToOne
    @JoinColumn(name = "user_sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "user_recipient_id")
    private User recipient;
}
