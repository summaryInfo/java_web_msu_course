package org.jbes.storage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.hibernate.SessionFactory;
import org.jbes.storage.entity.*;
import org.jbes.storage.dao.*;
import java.io.*;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.jbes.storage"})
public class WebConfig implements WebMvcConfigurer {
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("/res/");
    }

    @Bean
    @Scope("singleton")
    public static SessionFactory sessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

            Properties prop = new Properties();
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:54320/storage");
            prop.setProperty("hibernate.connection.username", "testuser");
            prop.setProperty("hibernate.connection.password", "test");
            prop.setProperty("hibernate.types.print.banner", "false");
            prop.setProperty("hibernate.connection.CharSet", "utf8");
            prop.setProperty("hibernate.connection.characterEncoding", "utf8");
            prop.setProperty("hibernate.connection.useUnicode", "true");
            try (InputStream st = new FileInputStream("WEB-INF/hibernate.properties")) {
                prop.load(st);
            } catch (IOException io) {}

            configuration.setProperties(prop);

            configuration.addAnnotatedClass(Consumer.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(ProductCategory.class);
            configuration.addAnnotatedClass(ProductInstance.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(Provider.class);
            configuration.addAnnotatedClass(Supply.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Unable to create session factory: " + e);
        }
        return sessionFactory;
    }

    @Bean
    @Scope("singleton")
    public static ProductCategoryDAO productCategoryDAO() {
        return new ProductCategoryDAO(sessionFactory());
    }

    @Bean
    @Scope("singleton")
    public static ProductDAO productDAO() {
        return new ProductDAO(sessionFactory());
    }

    @Bean
    @Scope("singleton")
    public static ProductInstanceDAO productInstanceDAO() {
        return new ProductInstanceDAO(sessionFactory());
    }


    @Bean
    @Scope("singleton")
    public static OrderDAO orderDAO() {
        return new OrderDAO(sessionFactory());
    }

    @Bean
    @Scope("singleton")
    public static SupplyDAO supplyDAO() {
        return new SupplyDAO(sessionFactory());
    }

    @Bean
    @Scope("singleton")
    public static ProviderDAO providerDAO() {
        return new ProviderDAO(sessionFactory());
    }

    @Bean
    @Scope("singleton")
    public static ConsumerDAO consumerDAO() {
        return new ConsumerDAO(sessionFactory());
    }

}
