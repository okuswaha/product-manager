package com.prakash;

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
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
		bootstrap.addBundle(new SwaggerBundle<ProductConfiguration>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ProductConfiguration configuration) {
				return configuration.swaggerBundleConfiguration;
			}
		});
    }

	@Override
	public void run(ProductConfiguration configuration, Environment environment) throws Exception {
		final ProductDAO productDAO = new ProductDAO(hibernateBundle.getSessionFactory());
		final CustomerDAO customerDAO = new CustomerDAO(hibernateBundle.getSessionFactory());
		final ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO(hibernateBundle.getSessionFactory());
		final OrderDAO orderDAO = new OrderDAO(hibernateBundle.getSessionFactory());
		final OrderDetailsDAO orderDetailsDAO= new OrderDetailsDAO(hibernateBundle.getSessionFactory());
		final ProductResource productResource = new ProductResource(productDAO);
		final CustomerResource customerResource = new CustomerResource(customerDAO);
		final OrderResource orderResource = new OrderResource(orderDAO);
		final OrderDetailsResource orderDetailsResource = new OrderDetailsResource(orderDetailsDAO);
		final ProductCategoryResource productCategoryResource = new ProductCategoryResource(productCategoryDAO);

		environment.jersey().register(productResource);
		environment.jersey().register(customerResource);
		environment.jersey().register(orderResource);
		environment.jersey().register(orderDetailsResource);
		environment.jersey().register(productCategoryResource);
		// Enable CORS headers
		final FilterRegistration.Dynamic cors =
				environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter("allowedOrigins", "*");
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	}


}
