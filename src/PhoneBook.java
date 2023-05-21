import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private final HashMap<String, String> phoneBook = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    private int getNumber(String str) {
        System.out.println(str);
        int number;
        try {
            Scanner scan = new Scanner(System.in);
            number = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Введено не верное значение.");
            return getNumber(str);
        }
        return number;
    }

    private void setPhoneBook() {
        System.out.println("Введите фамилию:");
        String familyName = scanner.nextLine();
        int phoneNumber = getNumber("Введите номер:");
        if (phoneBook.containsKey(familyName)) {
            String newStr = phoneBook.get(familyName) + ", "
                    + phoneNumber;
            phoneBook.put(familyName, newStr);
        } else {
            phoneBook.put(familyName, String.valueOf(phoneNumber));
        }
    }

    private void getPhoneBook() {
        if (phoneBook.isEmpty()) {
            System.out.println("Книга пуста.");
        } else {
            phoneBook.forEach((family, number) ->
                    System.out.println(family + ": " + number + "."));
        }
    }

    private void exit() {
        System.out.println("Выход.");
        scanner.close();
        System.exit(1);
    }

    public void getBook() {
        String mainText = "Введите \"1\" для добавления номера," +
                " \"2\" для вывода всего, " +
                "\"3\" для выхода";
        int numberCheck = 0;
        while (numberCheck != 3) {
            numberCheck = getNumber(mainText);
            switch (numberCheck) {
                case 1 -> setPhoneBook();
                case 2 -> getPhoneBook();
                case 3 -> exit();
                default -> System.out.println("Нет такого значения.");
            }
        }
    }
}
