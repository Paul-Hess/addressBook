import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;


public class AddressTest {

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
  public void addressTest_instantiatesAddressCorrectly() {
    Address testAddress = new Address("222 two street", "portland", "OR", 97027);
    assertTrue(testAddress instanceof Address);
  }

  @Test
  public void getStreet_addressInstantiatesWithStreet_String() {
    Address testAddress = new Address("234 fifth street", "portland", "OR", 97024);
    assertEquals("234 fifth street", testAddress.getStreet());
  }

  @Test
  public void getCity_addressInstantiatesWithCity_String() {
    Address testAddress = new Address("234 fifth street", "portland", "OR", 97024);
    assertEquals("portland", testAddress.getCity());
  }

  @Test
  public void getState_addressInstantiatesWithSTate_String() {
    Address testAddress = new Address("234 fifth street", "portland", "OR", 97024);
    assertEquals("OR", testAddress.getState());
  }

  @Test
  public void getZip_addressInstantiatesWithZip_int() {
    Address testAddress = new Address("234 fifth street", "portland", "OR", 97204);
    assertEquals(97204, testAddress.getZip());
  }

  @Test
  public void save_emptyAtFirst_true() {
    assertEquals(Address.all().size(), 0);
  }
}
