package person;

import java.util.OptionalInt;

public class Person {
  protected final String name;
  protected final String surname;
  protected String address;
  protected OptionalInt age;
  private StringBuilder sb = new StringBuilder("");

  public Person(String name, String surname) {
    this.name = name;
    this.surname = surname;

    checkRequiredData();
  }

  public Person(String name, String surname, OptionalInt age, String address) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.address = address;

    checkRequiredData();
  }

  private IllegalArgumentException checkRequiredData() {
    String errorMessage = null;
    String defaultErrorPrefix = "Данные заполненны неверно, ";

    if (!hasName() || !hasSurname()) {
      if (!hasName() && !hasSurname()) {
        errorMessage = "отсутствует имя и фамилия";
      } else if (!hasName()) {
        errorMessage = "отсутствует имя";
      } else {
        errorMessage = "отсутствует фамилия";
      }
      throw new IllegalArgumentException(defaultErrorPrefix + errorMessage);
    } else if (!hasAge() && !hasAddress()) {
      if (hasAge() && !hasAddress()) {
        errorMessage = "возраст и адрес указаны неверно";
      } else if (hasAge()) {
        errorMessage = "возраст указан неверно";
      } else {
        errorMessage = "адрес указан неверно";
      }
      throw new IllegalArgumentException(defaultErrorPrefix + errorMessage);
    }
    return null;
  }

  private boolean hasName() {
    return name != null && !name.isEmpty();
  }

  private boolean hasSurname() {
    return surname != null && !surname.isEmpty();
  }

  public boolean hasAge() {
    return age.getAsInt() > 0;
  }

  public boolean hasAddress() {
    return address != null && !address.isEmpty();
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname != null && !surname.isEmpty() ? surname : "";
  }

  public OptionalInt getAge() {
    return age.isPresent() ? age : OptionalInt.empty();
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void happyBirthday() {

  }

  @Override
  public String toString() {
    return getName() + " " + getSurname();
  }

  public PersonBuilder newChildBuilder() {
    return new PersonBuilder()
      .setName(null)
      .setSurname(getSurname())
      .setAge(getAge().getAsInt())
      .setAddress(getAddress());
  }
}
