package autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainA {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutowireConfig.class);
        GameA gameA = context.getBean(GameA.class);
        gameA.play();
    }
}
