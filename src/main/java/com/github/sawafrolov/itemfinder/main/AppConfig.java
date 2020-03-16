package com.github.sawafrolov.itemfinder.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource result = new DriverManagerDataSource();
        result.setDriverClassName("com.mysql.jdbc.Driver");
        result.setUrl("jdbc:mysql://localhost:3306/storage?serverTimezone=UTC");
        result.setUsername("root");
        result.setPassword("qwerty");
        return result;
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties result = new Properties();
        result.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return result;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean result = new LocalSessionFactoryBean();
        result.setDataSource(dataSource());
        result.setPackagesToScan("com.github.sawafrolov.itemfinder.models.entities");
        result.setHibernateProperties(hibernateProperties());
        return result;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager result = new HibernateTransactionManager();
        result.setSessionFactory(sessionFactory().getObject());
        return result;
    }

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }
}