package com.crypto.base.entities;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract  class BaseEntity implements Serializable,Cloneable {

    LocalDateTime createDate;
    LocalDateTime updateDate;
    Long createdBy;
    Long updatedBy;

   @PrePersist
   private void prePersist() {
      this.createDate= LocalDateTime.now();
   }

   @PreUpdate
   private void preUpdate() {
      this.updateDate = LocalDateTime.now();
   }

}
