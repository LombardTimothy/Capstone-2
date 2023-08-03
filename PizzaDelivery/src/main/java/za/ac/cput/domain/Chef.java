package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;


/*
 * Chef.java
 * Chef Entity
 * Author: Dawood Kamalie  (220147760)
 * Date: 7/4/2023
 * */
@Entity
public class Chef extends Employee {
    @Id
    private String chefId;
    private String nationality;
    private String culinaryExperience;
    private String empId = super.getEmpId();
    private  String chefName = super.getEmpName();
    private String chefSurname = super.getEmpSurname();



    protected Chef() {

    }

        public Chef(String empId, String empName, String empSurname, String chefId, String nationality, String culinaryExperience) {
        super(empId, empName, empSurname);
        this.chefId = chefId;
        this.nationality = nationality;
        this.culinaryExperience = culinaryExperience;
    }
    private Chef(Builder builder){
        this.empId = builder.empId;
        this.chefName = builder.chefName;
        this.chefSurname = builder.chefSurname;
        this.chefId = builder.chefId;
        this.nationality = builder.nationality;
        this.culinaryExperience = builder.culinaryExperience;
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCulinaryExperience() {
        return culinaryExperience;
    }

    public void setCulinaryExperience(String culinaryExperience) {
        this.culinaryExperience = culinaryExperience;
    }


    public static class Builder {

        private String chefId;
        private String nationality;
        private String culinaryExperience;
        private String empId;
        private  String chefName;
        private String chefSurname;

        public Builder(String empId, String chefName, String chefSurname, String chefId, String nationality, String culinaryExperience) {
            this.empId = empId;
            this.chefName = chefName;
            this.chefSurname = chefSurname;
            this.chefId = chefId;
            this.nationality = nationality;
            this.culinaryExperience = culinaryExperience;
        }

        public Builder() {

        }


        public String getChefId() {
            return chefId;
        }

        public Builder setChefId(String chefId) {
            this.chefId = chefId;
            return this;
        }

        public String getNationality() {
            return nationality;
        }

        public Builder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public String getCulinaryExperience() {
            return culinaryExperience;
        }

        public Builder setCulinaryExperience(String culinaryExperience) {
            this.culinaryExperience = culinaryExperience;
            return this;
        }

        public String getEmpId() {
            return empId;
        }

        public Builder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public String getChefName() {
            return chefName;
        }

        public Builder setChefName(String chefName) {
            this.chefName = chefName;
            return this;
        }

        public String getChefSurname() {
            return chefSurname;
        }

        public Builder setChefSurname(String chefSurname) {
            this.chefSurname = chefSurname;
            return this;
        }

        public Builder copy(Chef chef){
            this.empId = chef.empId;
            this.chefName = chef.chefName;
            this.chefSurname = chef.chefSurname;
            this.chefId = chef.chefId;
            this.nationality = chef.nationality;
            this.culinaryExperience = chef.culinaryExperience;
            return this;
        }
        public Chef build() {return new Chef(this);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Chef chef = (Chef) o;
            return empId.equals(chef.empId) && chefName.equals(chef.chefName) && chefSurname.equals(chef.chefSurname) && chefId.equals(chef.chefId) && nationality.equals(chef.nationality) && culinaryExperience.equals(chef.culinaryExperience);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empId, chefName, chefSurname, chefId, nationality, culinaryExperience);
        }

    }
}
