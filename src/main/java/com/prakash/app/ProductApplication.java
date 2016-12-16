package com.prakash.app;

import com.prakash.config.ProductConfiguration;
import com.prakash.resource.ProductResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ProductApplication extends Application<ProductConfiguration> {
	public static void main(String[] args) throws Exception {
        new ProductApplication().run(args);
    }
	
	@Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
        // nothing to do yet
    }

	@Override
	public void run(ProductConfiguration configuration, Environment environment) throws Exception {
		 final ProductResource resource = new ProductResource(
		            configuration.getMessage(),
		            configuration.getDefaultText1(),configuration.getDefaultText2());
		        environment.jersey().register(resource);
		
	}

}
