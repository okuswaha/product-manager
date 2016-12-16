package com.prakash.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Representation {
	@Length(max = 3)
    private String content;

    public Representation() {
        // Jackson deserialization
    }

    @JsonProperty
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Representation(String content) {
        this.content = content;
    }

}
