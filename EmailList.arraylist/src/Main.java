import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public final static String EMAIL_REGEX = ".+@.+\\..+";

    private static ArrayList<String> emails = new ArrayList<>();

    private static boolean isContinue = true;

    public static void main(String[] args) {
        do {
            System.out.println("Введите email: ");
            String email = new Scanner(System.in).nextLine();
            if(!validEmail(email)) {
                System.out.println("Email не валиден!");
                continue;
            }

            if(checkDublesEmail(email)) {
                System.out.println(email + " уже было добавлен ранее!");
                continue;
            }

            emails.add(email);
            System.out.println("Email " + email + " успешно добавлен!");
            doContinue();

            printEmails();

        } while(isContinue);

    }

    private static void printEmails() {
        System.out.println("Список Email:");
        for (String s : emails) {
            System.out.println(s);
        }
    }

    private static void doContinue() {
        System.out.println("Продолжить?(y/n)");
        String response = new Scanner(System.in).nextLine();
        if(response.equals("n")) {
            isContinue = false;
        }
    }

    private static boolean checkDublesEmail(String email) {
        return emails.contains(email);
    }

    private static boolean validEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
