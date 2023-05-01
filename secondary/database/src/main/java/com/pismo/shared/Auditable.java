package com.pismo.shared;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import java.time.Instant;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Auditable {
    @DateCreated
    Instant createdAt;
    @DateUpdated
    Instant modifiedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
