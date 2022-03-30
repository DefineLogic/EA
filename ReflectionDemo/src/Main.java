import annotation.MyAnnotationFramework;
import entity.Student;
import reflection.MyReflectionFramework;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        MyReflectionFramework myReflectionFramework = new MyReflectionFramework();
        Student jack = null;
        try {
            jack = (Student) myReflectionFramework.createStudentV1(Student.class);
//            Student jack2 =  myReflectionFramework.createStudentV2(Student.class);
            Student jack3 =  myReflectionFramework.createStudentV3(Student.class,1);
//            System.out.println("Jack is "+jack);
//            System.out.println("Jack is "+jack2);
//            System.out.println("Jack is "+jack3);
//
//            myReflectionFramework.getFields(jack);
//            myReflectionFramework.setObjectFields(jack,"name","john");
//            System.out.println("Jack is "+jack);
//
//            myReflectionFramework.getMethods(jack);
//            myReflectionFramework.setObjectProperty(jack,"name","julie");
//            System.out.println(jack);
            System.out.println("Jack before annotation framework "+jack);
            MyAnnotationFramework myAnnotationFramework = new MyAnnotationFramework();
            myAnnotationFramework.initializeFields(jack);
            System.out.println("Jack after annotation framework "+jack);
            myAnnotationFramework.callInitMethod(jack);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
