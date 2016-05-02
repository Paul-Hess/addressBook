import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/address_book_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
    String deleteContactsQuery = "DELETE FROM contacts *;";
    String deleteAddressQuery = "DELETE FROM address *;";
    String deleteEmailQuery = "DELETE FROM email *;";
    String deletePhoneQuery = "DELETE FROM phones *;";
    con.createQuery(deleteContactsQuery).executeUpdate();
    con.createQuery(deleteAddressQuery).executeUpdate();
    con.createQuery(deletePhoneQuery).executeUpdate();
    con.createQuery(deleteEmailQuery).executeUpdate();
  }
}

  @Test
  public void phone_isThisReallyPhone_phoneYes() {
    Phone newPhone = new Phone(360, 867-5309, "home");
    assertTrue(newPhone instanceof Phone);
  }
}
