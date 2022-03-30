package edu.miu.cs544.programmingtest2;

import edu.miu.cs544.programmingtest2.service.EmailSystem;
import edu.miu.cs544.programmingtest2.service.StudentCRUD;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        GenericXmlApplicationContext springContext = new GenericXmlApplicationContext();
//        springContext.load("config.xml");
//        springContext.refresh();

        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext();
        springContext.scan("edu.miu.cs544.programmingtest2.config");
        springContext.refresh();

        EmailSystem emailSystem = springContext.getBean(EmailSystem.class);
        emailSystem.connectToMailServer();
        emailSystem.sendEmail();
        StudentCRUD studentCRUD = springContext.getBean(StudentCRUD.class);
        studentCRUD.create();
        studentCRUD.read();
        studentCRUD.update();
        studentCRUD.delete();

    }
}
