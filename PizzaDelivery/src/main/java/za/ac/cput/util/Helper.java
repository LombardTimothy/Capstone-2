package za.ac.cput.util;
import java.util.UUID;

/*
    Helper.java
    Date: 7/04/2023
    Author: Shared
*/
public class Helper {

    public static boolean isNullOrEmpty(String help){
        if(help == null || help.isEmpty()){
            return true;
        }
        return false;
    }

    public static String generateId(){// to randomly assign an ID
        return UUID.randomUUID().toString();
    }

    public static Integer generateId2(){// to randomly assign an ID
        return UUID.randomUUID().hashCode();
    }
}