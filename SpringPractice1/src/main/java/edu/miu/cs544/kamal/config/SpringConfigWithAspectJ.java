//package edu.miu.cs544.kamal.config;
//
//import edu.miu.cs544.kamal.aspect.AspectJLogging;
//import edu.miu.cs544.kamal.aspect.AspectJLoggingToDB;
//import edu.miu.cs544.kamal.aspect.SpringAopLogging;
//import edu.miu.cs544.kamal.service.DatabaseConnection;
//import org.springframework.aop.framework.ProxyFactoryBean;
//import org.springframework.context.annotation.*;
//
//@Configuration
//@EnableAspectJAutoProxy
//@ComponentScan(basePackages = "edu.miu.cs544.kamal")
//public class SpringConfigWithAspectJ {
//
//    @Bean("databaseConnection")
//    public DatabaseConnection databaseConnectionDevelopment() {
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        databaseConnection.setDbUrl("development_db_Url");
//        return databaseConnection;
//    }
//
//    @Bean
//    public AspectJLogging logger() {
//        return new AspectJLogging();
//    }
//
//    @Bean
//    public AspectJLoggingToDB logger2() {
//        return new AspectJLoggingToDB();
//    }
//
//}
