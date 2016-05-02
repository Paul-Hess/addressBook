import org.sql2o.*;
import java.util.List;

public class Address {
private String street;
private String city;
private String state;
private int zip;

  public Address(String street, String city, String state, int zip){
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public int getZip() {
    return zip;
  }

  public static List<Address> all() {
    String sql = "SELECT street, city, state, zip FROM address";
    try(Connection con  = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Address.class);
    }
  }


}
