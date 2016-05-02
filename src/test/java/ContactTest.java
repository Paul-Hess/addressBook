import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

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
  public void contact_checkInstantiatesContact_true() {
    Contact newContact = new Contact("Bob", "Boberson");
    assertTrue(newContact instanceof Contact);
  }

  @Test
  public void getFirstName_instantiatesWithFirstName_Bobby() {
    Contact newContact = new Contact("Bobby", "Bobbsalott");
    assertEquals("Bobby", newContact.getFirstName());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Contact.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfPropertiesAreTheSame() {
    Contact testContactOne = new Contact("Bob", "Jones");
    Contact testContactTwo = new Contact("Bob", "Jones");
    assertTrue(testContactOne.equals(testContactTwo));
  }

  @Test
  public void save_returnsTrueIfNamesAreTheSame() {
    Contact testContactOne = new Contact("Phil", "Hartman");
    testContactOne.save();
    assertTrue(Contact.all().get(0).equals(testContactOne));
  }

  @Test
  public void save_assignsIdToObject() {
    Contact testContactOne = new Contact("Timmy", "Turner");
    testContactOne.save();
    Contact savedContactOne = Contact.all().get(0);
    assertEquals(testContactOne.getId(), savedContactOne.getId());
  }

  @Test
  public void find_findsContactInDatabase_true() {
    Contact testContact = new Contact("Toni", "Tone");
    testContact.save();
    Contact savedContact = Contact.find(testContact.getId());
    assertTrue(testContact.equals(savedContact));
  }
  // @Test
  // public void getLastName_instantiatesWithLastName_Bobbsalott() {
  //   Contact newContact = new Contact("Bobby", "Bobbsalott");
  //   assertEquals("Bobbsalott", newContact.getLastName());
  // }
  //
  // @Test
  // public void getPhoneList_initiateNewPhoneintoContacts_newPhone(){
  //   Contact newContact = new Contact("Billy", "Billboperson");
  //   Phone newPhone = new Phone(503, 233-4442, "Cell");
  //   Email newEmail = new Email("billyboop@booptrooponaloop.com", "personal");
  //   Address newAddress = new Address("123 street", "Street City", "Street", 12332);
  //   newContact.addContact(newPhone, newEmail, newAddress);
  //   assertEquals(newContact.getPhoneList().size(), 1);
  // }
  //
  // @Test
  // public void getEmailList_intiateNewEmailandPhoneintoContacts_newEmail(){
  //   Contact newContact = new Contact("Billy", "Boop");
  //   Phone newPhone = new Phone(503, 233-4442, "Cell");
  //   Email newEmail = new Email("billyboop@booptrooponaloop.com", "personal");
  //   Address newAddress = new Address("123 street", "Street City", "Street", 12332);
  //   newContact.addContact(newPhone, newEmail, newAddress);
  //   assertEquals(newContact.getEmailList().size(), 1);
  // }
  //
  // @Test
  // public void getAddressList_intiateNewEmailandPhoneintoContacts_newEmail(){
  //   Contact newContact = new Contact("Billy", "Boop");
  //   Phone newPhone = new Phone(503, 233-4442, "Cell");
  //   Email newEmail = new Email("billyboop@booptrooponaloop.com", "personal");
  //   Address newAddress = new Address("123 street", "Street City", "Street", 12332);
  //   newContact.addContact(newPhone, newEmail, newAddress);
  //   assertEquals(newContact.getAddressList().size(), 1);
  // }
}
