package com.heron.shortener.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

public class Message {
    /**
     * The Status Schema.
     * <p>
     * An explanation about the purpose of this instance.
     *
     */
    @JsonProperty("status")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private String status;
    /**
     * The Message Schema.
     * <p>
     * An explanation about the purpose of this instance.
     *
     */
    @JsonProperty("message")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The Status Schema.
     * <p>
     * An explanation about the purpose of this instance.
     *
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * The Status Schema.
     * <p>
     * An explanation about the purpose of this instance.
     *
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Message withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * The Message Schema.
     * <p>
     * An explanation about the purpose of this instance.
     *
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The Message Schema.
     * <p>
     * An explanation about the purpose of this instance.
     *
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Message withMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Message withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("message", message).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(message).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Message) == false) {
            return false;
        }
        Message rhs = ((Message) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(message, rhs.message).append(status, rhs.status).isEquals();
    }
}
