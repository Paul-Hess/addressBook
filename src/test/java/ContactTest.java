import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {

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
  public void getLastName_instantiatesWithLastName_Bobbsalott() {
    Contact newContact = new Contact("Bobby", "Bobbsalott");
    assertEquals("Bobbsalott", newContact.getLastName());
  }

  @Test
  public void getPhoneList_initiateNewPhoneintoContacts_newPhone(){
    Contact newContact = new Contact("Billy", "Billboperson");
    Phone newPhone = new Phone(503, 233-4442, "Cell");
    Email newEmail = new Email("billyboop@booptrooponaloop.com", "personal");
    Address newAddress = new Address("123 street", "Street City", "Street", 12332);
    newContact.addContact(newPhone, newEmail, newAddress);
    assertEquals(newContact.getPhoneList().size(), 1);
  }

  @Test
  public void getEmailList_intiateNewEmailandPhoneintoContacts_newEmail(){
    Contact newContact = new Contact("Billy", "Boop");
    Phone newPhone = new Phone(503, 233-4442, "Cell");
    Email newEmail = new Email("billyboop@booptrooponaloop.com", "personal");
    Address newAddress = new Address("123 street", "Street City", "Street", 12332);
    newContact.addContact(newPhone, newEmail, newAddress);
    assertEquals(newContact.getEmailList().size(), 1);
  }

  @Test
  public void getAddressList_intiateNewEmailandPhoneintoContacts_newEmail(){
    Contact newContact = new Contact("Billy", "Boop");
    Phone newPhone = new Phone(503, 233-4442, "Cell");
    Email newEmail = new Email("billyboop@booptrooponaloop.com", "personal");
    Address newAddress = new Address("123 street", "Street City", "Street", 12332);
    newContact.addContact(newPhone, newEmail, newAddress);
    assertEquals(newContact.getAddressList().size(), 1);
  }
}
