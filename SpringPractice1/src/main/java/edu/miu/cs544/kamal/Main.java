package edu.miu.cs544.kamal;

//import edu.miu.cs544.kamal.config.SpringConfigWithAspectJ;
//import edu.miu.cs544.kamal.config.SpringConfigWithAspectJ;
import edu.miu.cs544.kamal.service.DatabaseConnection;
import edu.miu.cs544.kamal.service.EmailService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("App Start");

//        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext();
//        springContext.scan("edu.miu.cs544.kamal.config");
//        springContext.refresh();

        GenericXmlApplicationContext springContext = new GenericXmlApplicationContext();
        springContext.load("springConfigUsingAspectJ.xml");
        springContext.refresh();
//        DatabaseConnection databaseConnection = springContext.getBean(DatabaseConnection.class);
        //DatabaseConnection databaseConnection = (DatabaseConnection) springContext.getBean("databaseConnection");
//        databaseConnection.connect();

//        GenericXmlApplicationContext springContext = new GenericXmlApplicationContext();
//        springContext.load("springConfigUsingAspectJ.xml");
//        springContext.refresh();

//        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfigWithAspectJ.class);
//        EmailService emailService = springContext.getBean(EmailService.class);
//        emailService.sendEmail();



        DatabaseConnection databaseConnection = springContext.getBean(DatabaseConnection.class);
        databaseConnection.connect();

        System.out.println("App End");
    }
}
