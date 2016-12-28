package com.prakash.app;

import com.prakash.config.ProductConfiguration;
import com.prakash.dao.*;
import com.prakash.entity.*;
import com.prakash.resource.*;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ProductApplication extends Application<ProductConfiguration> {
	private final HibernateBundle<ProductConfiguration> hibernateBundle = new HibernateBundle<ProductConfiguration>(Product.class, ProductCategory.class, Customer.class, Order.class, OrderDetails.class) {
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
		final CustomerDAO customerDAO = new CustomerDAO(hibernateBundle.getSessionFactory());
		final ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO(hibernateBundle.getSessionFactory());
		final OrderDAO orderDAO = new OrderDAO(hibernateBundle.getSessionFactory());
		final OrderDetailsDAO orderDetailsDAO= new OrderDetailsDAO(hibernateBundle.getSessionFactory());
		final ProductResource productResource = new ProductResource(configuration.getMessage(), configuration.getDefaultText1(),configuration.getDefaultText2(),
				 productDAO);
		final CustomerResource customerResource = new CustomerResource(customerDAO);
		final OrderResource orderResource = new OrderResource(orderDAO);
		final OrderDetailsResource orderDetailsResource = new OrderDetailsResource(orderDetailsDAO);
		final ProductCategoryResource productCategoryResource = new ProductCategoryResource(productCategoryDAO);

		environment.jersey().register(productResource);
		environment.jersey().register(customerResource);
		environment.jersey().register(orderResource);
		environment.jersey().register(orderDetailsResource);
		environment.jersey().register(productCategoryResource);
		
	}

}
