package com.prakash.app;

import com.prakash.config.ProductConfiguration;

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
	public void run(ProductConfiguration arg0, Environment arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
