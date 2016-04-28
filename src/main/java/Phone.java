

public class Phone {
  private int mAreaCode;
  private int mNumber;
  private String mType;
  public Phone(int areaCode, int number, String type) {
    mAreaCode = areaCode;
    mNumber = number;
    mType = type;
  }
  public String returnPhone(){
    return String.format("(%d)%d-%s", mAreaCode, mNumber, mType);
  }
}
