package com.prakash.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ProductConfiguration extends Configuration {
	@NotEmpty
	private String message;
	@NotEmpty
	private String defaultText1;
	@NotEmpty
	private String defaultText2;

	@JsonProperty("swagger")
	public SwaggerBundleConfiguration swaggerBundleConfiguration;

	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();

	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
	
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

	public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
		return swaggerBundleConfiguration;
	}

	public void setSwaggerBundleConfiguration(SwaggerBundleConfiguration swaggerBundleConfiguration) {
		this.swaggerBundleConfiguration = swaggerBundleConfiguration;
	}

	public DataSourceFactory getDatabase() {
		return database;
	}

	public void setDatabase(DataSourceFactory database) {
		this.database = database;
	}
}