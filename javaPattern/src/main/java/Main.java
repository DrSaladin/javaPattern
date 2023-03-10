import person.Person;
import person.PersonBuilder;

public class Main {

  public static void main(String[] args) {
    Person mom = new PersonBuilder()
      .setName("Анна")
      .setSurname("Вольф")
      .setAge(31)
      .setAddress("Сидней")
      .build();
    Person son = mom.newChildBuilder()
      .setName("Антошка")
      .build();
    System.out.printf("У %s есть сын, %s \n", mom.toString(), son.toString());


    try {
      // Не хватает обяхательных полей
      new PersonBuilder().build();
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }

    try {
      // Возраст недопустимый
      new PersonBuilder().setAge(-100).build();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }
}
