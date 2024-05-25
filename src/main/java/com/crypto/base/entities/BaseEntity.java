package com.crypto.base.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
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



    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }


}
