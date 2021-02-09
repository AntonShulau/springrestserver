package by.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "by.spring.rest")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSource(){

        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/my_db");
        comboPooledDataSource.setUser("postgres");
        comboPooledDataSource.setPassword("321000");
        return comboPooledDataSource;

    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("by.spring.rest.entity");
        Properties hiberProperties= new Properties();
        hiberProperties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        hiberProperties.setProperty("hibernate.show_sql","true");
        sessionFactory.setHibernateProperties(hiberProperties);
        return sessionFactory;

    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;

    }

}
