package com.revolut.common.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Health {
    private UUID id;

    private String content;

    public Health() {
        // Jackson deserialization
    }

    public Health(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public UUID getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
