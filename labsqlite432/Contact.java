package buusk.bc.labsqlite432;

/**
 * Created by worldmac on 2/16/2018.
 */

public class Contact {
    public Contact(int id, String name, String phone_number) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
    }

    public Contact(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public Contact(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    String phone_number;

    public String getName() {
        return name;
    }

    public byte[] getPhoneNumber() {
        return phoneNumber;
    }
}
