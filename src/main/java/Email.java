

public class Email {
  private String mType;
  private String mAddress;

  public Email(String address, String type) {
    mType = type;
    mAddress = address;
  }

  public String getEmail() {
    return String.format("%s %s", mAddress, mType);
  }
}
