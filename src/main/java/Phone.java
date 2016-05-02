import java.util.List;
import org.sql2o.*;

public class Phone {
  private int area_code;
  private int number;
  private String type;
  public Phone(int area_code, int number, String type) {
    this.area_code = area_code;
    this.number = number;
    this.type = type;
  }
  public String returnPhone(){
    return String.format("(%d)%d-%s", area_code, number, type);
  }

  public int getAreaCode() {
    return area_code;
  }

  public int getNumber() {
    return number;
  }

  public String getType() {
    return type;
  }

  public static List<Phone> all() {
    String sql = "SELECT area_code, number, type FROM Phone";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Phone.class);
    }
  }

  // @Override
  // public boolean equals(Object otherPhone) {
  //   if (!(otherPhone instanceof Phone)) {
  //     return false;
  //   } else {
  //     Phone newPhone = (Phone) otherPhone;
  //     return this.getEmail
  //   }
  // }
}
