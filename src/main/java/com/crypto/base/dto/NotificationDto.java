package com.crypto.base.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.crypto.base.entities.Notification}
 */
@Value
public class NotificationDto implements Serializable {
    LocalDateTime createDate;
    LocalDateTime updateDate;
    Long createdBy;
    Long updatedBy;
    Long id;
    String text;
    String title;
}