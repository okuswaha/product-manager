package com.prakash.config;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ProductConfiguration extends Configuration {
	@NotEmpty
	private String message;
	@NotEmpty
	private String defaultText1;
	@NotEmpty
	private String defaultText2;
	
	@JsonProperty
	public String getMessage() {
		return message;
	}
	
	@JsonProperty
	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonProperty
	public String getDefaultText1() {
		return defaultText1;
	}
	
	@JsonProperty
	public void setDefaultText1(String defaultText1) {
		this.defaultText1 = defaultText1;
	}
	
	@JsonProperty
	public String getDefaultText2() {
		return defaultText2;
	}
	
	@JsonProperty
	public void setDefaultText2(String defaultText2) {
		this.defaultText2 = defaultText2;
	}   
}