package za.ac.cput.factory;

import za.ac.cput.domain.Chef;
import za.ac.cput.util.Helper;

/*
* ChefFactory.java
* Author: Dawood Kamalie  (220147760)
* Date: 7/4/2023
* */
public class ChefFactory {
    public static Chef createChef(String name, String surname, String phoneNumber, String email, String title, String culinaryExperience) {
        if (  Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(culinaryExperience)) {
            return null;
        }

        String empId = Helper.generateId();

        Chef chef = (Chef) new Chef.Builder().setTitle(title).setCulinaryExperience(culinaryExperience).setEmpId(empId).setName(name).setSurname(surname).setPhoneNumber(phoneNumber).setEmail(email).build();
        return chef;



    }
}
