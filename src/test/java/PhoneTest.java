import org.junit.*;
import static org.junit.Assert.*;

public class PhoneTest {

  @Test
  public void phone_isThisReallyPhone_phoneYes() {
    Phone newPhone = new Phone(360, 867-5309, "home");
    assertTrue(newPhone instanceof Phone);
  }
}
