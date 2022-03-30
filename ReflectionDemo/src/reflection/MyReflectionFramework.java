package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflectionFramework {

    public Object createStudentV1(Class T) throws InstantiationException, IllegalAccessException {
        return T.newInstance();
    }

    public <T> T createStudentV2(Class T) throws InstantiationException, IllegalAccessException {
        return (T) T.newInstance();
    }

    public <T> T createStudentV3(Class T, Object id) throws InstantiationException, IllegalAccessException,
            InvocationTargetException {
        T returnObject = null;
        String className = T.getName();
        Constructor<T> foundConstructor = null;
        Object[] parameters = getParamsFromDB(id);
        for (Constructor<T> constructor : T.getDeclaredConstructors()) {
            if (constructor.getParameterCount() == parameters.length) {
                foundConstructor = constructor;
                break;
            }
        }
        if (foundConstructor != null) {
            returnObject = foundConstructor.newInstance(parameters);
        }
        return returnObject;
    }

    private Object[] getParamsFromDB(Object id) {
        return new Object[]{5, "Jack", 3.3f};
    }

    public void getFields(Object object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            System.out.print(field.getName() + " ");
            System.out.println(field.getModifiers());
        }
    }

    public void setObjectFields(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    public void getMethods(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            System.out.print(method.getName() + " ");
            System.out.println(method.getModifiers());
        }
    }

    public void setObjectProperty(Object object, String attributeName, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set"+attributeName.substring(0,1).toUpperCase() + attributeName.substring(1);
        Method method = object.getClass().getMethod(methodName,value.getClass());
        method.invoke(object,value);

    }
}
