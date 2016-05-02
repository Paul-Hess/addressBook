import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Contact {
  private String first_name;
  private String last_name;
  ArrayList<Phone> phoneList;
  ArrayList<Email> emailList;
  ArrayList<Address> addressList;
  private int id;
  private static ArrayList<Contact> instances = new ArrayList<Contact>();


  @Override
  public boolean equals(Object otherContact) {
    if(!(otherContact instanceof Contact)) {
      return false;
    } else {
      Contact newContact = (Contact) otherContact;
      return this.getFirstName().equals(newContact.getFirstName())
      && this.getLastName().equals(newContact.getLastName())
      && this.getId() == newContact.getId();
    }
  }

  public Contact(String first_name, String last_name) {
    this.first_name = first_name;
    this.last_name = last_name;
    phoneList = new ArrayList<Phone>();
    emailList = new ArrayList<Email>();
    addressList = new ArrayList<Address>();
    instances.add(this);
  }

  public static List<Contact> all() {
    String sql = "SELECT id, first_name, last_name FROM contacts";
    try (Connection con = DB. sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Contact.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO contacts (first_name, last_name) VALUES (:first_name, :last_name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("first_name", this.first_name)
        .addParameter("last_name", this.last_name)
        .executeUpdate()
        .getKey();
    }
  }

  public String getFirstName() {
    return this.first_name;
  }

  public String getLastName() {
    return this.last_name;
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
    return id;
  }

  public static Contact find(int id) {
    try(Connection con = DB. sql2o.open()) {
      String sql = "SELECT * FROM contacts where id=:id";
      Contact contact = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Contact.class);
    return contact;
    }
  }

  public static ArrayList<Contact> getContacts() {
    return instances;
  }

}
