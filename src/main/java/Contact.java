import java.util.ArrayList;

public class Contact {
  private String mfirstName;
  private String mlastName;
  ArrayList<Phone> phoneList;
  ArrayList<Email> emailList;
  ArrayList<Address> addressList;
  private static ArrayList<Contact> instances = new ArrayList<Contact>();
  private int mId;
  public Contact(String firstname, String lastname) {
    mfirstName = firstname;
    mlastName = lastname;
    phoneList = new ArrayList<Phone>();
    emailList = new ArrayList<Email>();
    addressList = new ArrayList<Address>();
    instances.add(this);
    mId = instances.size();
  }

  public String getFirstName() {
    return mfirstName;
  }

  public String getLastName() {
    return mlastName;
  }

  public void addContact(Phone phone, Email email, Address address) {
    phoneList.add(phone);
    emailList.add(email);
    addressList.add(address);
  }

  public ArrayList<Phone> getPhoneList(){
    return phoneList;
  }

  public ArrayList<Email> getEmailList() {
    return emailList;
  }

  public ArrayList<Address> getAddressList() {
    return addressList;
  }

  public int getId() {
    return mId;
  }
  
  public static Contact find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static ArrayList<Contact> getContacts() {
    return instances;
  }

}
