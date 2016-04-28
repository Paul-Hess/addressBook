import org.junit.*;
import static org.junit.Assert.*;


public class EmailTest {
  @Test
  public void emailTest_butWhoWasEmail_emailPhone() {
    Email newEmail = new Email("jimmeejobobjob@jimmyjob.job", "work");
    assertTrue(newEmail instanceof Email);
  }

  @Test
  public void emailGetTest_getThatAdrress_email() {
    Email newEmail = new Email("jimmeejobobjob@jimmyjob.job", "work");
    assertEquals("jimmeejobobjob@jimmyjob.job work", newEmail.getEmail());
  }
}
