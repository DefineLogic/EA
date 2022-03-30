package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationFramework {
    public void initializeFields(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            FieldInitAnnotation annotation = field.getAnnotation(FieldInitAnnotation.class);
            if (annotation != null) {
                String value = annotation.value();
                field.setAccessible(true);
                field.set(object, value);
            }
        }
    }

    public void callInitMethod(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInitAnnotation.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }
}
