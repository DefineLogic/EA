//package edu.miu.cs544.kamal.config;
//
//import edu.miu.cs544.kamal.aspect.SpringAopLogging;
//import edu.miu.cs544.kamal.service.DatabaseConnection;
//import org.springframework.aop.framework.ProxyFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import javax.xml.crypto.Data;
//import java.lang.reflect.Proxy;
//
//@Configuration
//public class SpringConfig {
//
//    @Bean("databaseConnection")
//    @Profile({"development","default"})
//    public DatabaseConnection databaseConnectionDevelopment() {
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        databaseConnection.setDbUrl("development_db_Url");
//        return databaseConnection;
//    }
//
//    @Bean("databaseConnectionProxy")
//    @Profile({"development","default"})
//    public ProxyFactoryBean databaseConnectionProxyDevelopment() {
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        String[] interceptorNames = {"springAopLogging"};
//        proxyFactoryBean.setTarget(databaseConnectionDevelopment());
//        proxyFactoryBean.setInterceptorNames(interceptorNames);
//        return proxyFactoryBean;
//    }
//
//
//    @Bean
//    @Profile({"development","default"})
//    public SpringAopLogging springAopLogging() {
//        SpringAopLogging springAopLogging = new SpringAopLogging();
//        return new SpringAopLogging();
//    }
////
////    @Bean("databaseConnection")
////    @Profile({"production"})
////    public DatabaseConnection databaseConnectionProduction() {
////        DatabaseConnection databaseConnection = new DatabaseConnection();
////        databaseConnection.setDbUrl("development_prod_Url");
////        return databaseConnection;
////    }
//
//}
