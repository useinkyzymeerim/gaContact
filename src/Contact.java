public class Contact {
    private String firstName;
    private String lastName;
    private String numberPhone;
    private String email;

    public Contact(String firstName, String lastName, String numberPhone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Firstname: " + firstName +
                "\nLastName: " + lastName +
                "\nNumberPhone: " + numberPhone +
                "\nEmail: " + email;
    }
}
