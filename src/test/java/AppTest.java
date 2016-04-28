import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Contact List");
  }

  @Test
  public void addNewContactTest() {
    goTo("http://localhost:4567/");
    fill("#first-name").with("bob");
    fill("#last-name").with("bobbyson");
    fill("#email").with("thisisanemail@email.emailmail");
    fill("#email-type").with("personal");
    fill("#phone-prefix").with(503);
    fill("#number").with(444-4444);
    fill("#phone-type").with("fax");
    fill("#street").with("23 45th avenue lane");
    fill("#city").with("wunder");
    fill("#state").with("land");
    fill("#zip").with(66666);
    submit("#contact-btn");
    assertThat(pageSource()).contains("bob bobbyson");
  }



}
