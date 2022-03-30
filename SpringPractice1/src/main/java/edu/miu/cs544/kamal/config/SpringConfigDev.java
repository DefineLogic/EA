//package edu.miu.cs544.kamal.config;
//
//import edu.miu.cs544.kamal.service.DatabaseConnection;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//@Profile({"development","default"})
//public class SpringConfigDev implements SpringConfigInterface{
//
//    @Bean
//    public DatabaseConnection databaseConnection() {
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        databaseConnection.setDbUrl("development_db_Url");
//        return databaseConnection;
//    }
//
//}
