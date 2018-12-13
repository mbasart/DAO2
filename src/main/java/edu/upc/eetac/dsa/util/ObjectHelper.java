package edu.upc.eetac.dsa.util;

import edu.upc.eetac.dsa.model.Employee;

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

    // getter(instance, "name");
    public static Object getter(Object object, String property) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Entra a la funcio getter.");
        // Method // invoke
        Object ret = null;
        Class theClass = object.getClass();
        //object."get"+property();  // object.getName();  property = "name"
        //Method sMethod = "getName";  //"get"+property.substring(0,1).toUpperCase()+property.substring(1);
        //Method method = theClass.getMethod(property, null)  ;


        Method[] methodList = theClass.getMethods();
        String sMethod = "get"+ property.substring(0,1).toUpperCase()+property.substring(1);
        System.out.println("metode> "+sMethod);


        Method getter = theClass.getMethod(sMethod,null);
        ret = getter.invoke(object);

        return ret;
    }



    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String ret = (String)getter(new Employee("Meritxell", "ccccccc",333333333), "name");

        System.out.println(ret);
    }

}
