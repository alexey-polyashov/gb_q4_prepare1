package task1;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    void Person(){

    }

    public static Person build() {
        return new Person();
    }

    public Person firstName(String firstName){
        this.firstName = firstName;
        return this;
    }
    public Person lastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public Person middleName(String middleName){
        this.middleName = middleName;
        return this;
    }
    public Person phone(String phone){
        this.phone = phone;
        return this;
    }
    public Person address(String address){
        this.address = address;
        return this;
    }
    public Person gender(String gender){
        this.gender = gender;
        return this;
    }
}
