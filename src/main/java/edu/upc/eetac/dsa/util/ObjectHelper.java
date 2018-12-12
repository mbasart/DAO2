package edu.upc.eetac.dsa.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {

    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) {
            sFields[i++] = f.getName();
            System.out.println("Valor getFields: " + f.getName());
        }
        return sFields;

    }


    public static void setter(Object object, String property, Object value) throws InvocationTargetException, IllegalAccessException {
        // Method // invoke
        Object ret = null;
        Class theClass = object.getClass();

        Method[] methodList = theClass.getMethods();

        for(Method method : methodList){
            if(!method.getName().startsWith("set")){
                ret = null;
            } else if(method.getParameterTypes().length != 1){
                ret = null;
            } else if(method.getName().toUpperCase().startsWith(property,3)){
                method.invoke(object, value);
            }

        }

    }

    public static Object getter(Object object, String property) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Entra a la funcio getter.");
        // Method // invoke
        Object ret = null;
        Class theClass = object.getClass();
        //object."get"+property();  // object.getName();  property = "name"
        //Method sMethod = "getName";  //"get"+property.substring(0,1).toUpperCase()+property.substring(1);
        //Method method = theClass.getMethod(property, null)  ;


        Method[] methodList = theClass.getMethods();

        for(Method method:methodList){
            if(!method.getName().startsWith("get")){
                ret = null;
                System.out.println("Retorna null perque no startWith get.");
            } else if (method.getParameterTypes().length != 0){
                //getParametTypes ha de ser null
                ret = null;
                System.out.println("Retorna null perque ParameterTypes no es 0.");
            } else if(method.getName().toUpperCase().startsWith(property,3)){
                ret = method.invoke(object);
            }
        }

        return ret;
    }
}
