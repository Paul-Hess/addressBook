import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String first = request.queryParams("first-name");
      String last = request.queryParams("last-name");

      String email = request.queryParams("email");
      String emailType = request.queryParams("email-type");

      String street = request.queryParams("street");
      String city = request.queryParams("city");
      String state = request.queryParams("state");
      int zip = Integer.parseInt(request.queryParams("zip"));

      int areaCode = Integer.parseInt(request.queryParams("phone-prefix"));
      int phoneNumber = Integer.parseInt(request.queryParams("number"));
      String phoneType = request.queryParams("phone-type");

      Contact newContact = new Contact(first, last);
      Phone newPhone = new Phone(areaCode, phoneNumber, phoneType);
      Email newEmail = new Email(email, emailType);
      Address newAddress = new Address(street, city, state, zip);
      newContact.addContact(newPhone, newEmail, newAddress);

      model.put("allContacts", Contact.getContacts());
      model.put("template", "templates/contacts.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("template", "templates/contact-detail.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
