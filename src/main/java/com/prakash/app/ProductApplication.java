package com.prakash.app;

import com.prakash.config.ProductConfiguration;
import com.prakash.dao.ProductDAO;
import com.prakash.entity.Product;
import com.prakash.resource.ProductResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ProductApplication extends Application<ProductConfiguration> {
	private final HibernateBundle<ProductConfiguration> hibernateBundle = new HibernateBundle<ProductConfiguration>(Product.class) {
		@Override
		public PooledDataSourceFactory getDataSourceFactory(ProductConfiguration productConfiguration) {
			return productConfiguration.getDataSourceFactory();
		}
	};
	public static void main(String[] args) throws Exception {
        new ProductApplication().run(args);
    }
	
	@Override
    public void initialize(Bootstrap<ProductConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<ProductConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(ProductConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});
		bootstrap.addBundle(hibernateBundle);
    }

	@Override
	public void run(ProductConfiguration configuration, Environment environment) throws Exception {
		final ProductDAO productDAO = new ProductDAO(hibernateBundle.getSessionFactory());
		 final ProductResource resource = new ProductResource(
		            configuration.getMessage(),
		            configuration.getDefaultText1(),configuration.getDefaultText2(),
				 productDAO);
		        environment.jersey().register(resource);
		
	}

}
