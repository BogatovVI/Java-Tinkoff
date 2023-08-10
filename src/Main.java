import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void inputData(List<Integer> list) {

        File file = new File("input.txt");
        Scanner scanner = null;
        int number;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while (scanner.hasNextLine()) {
            number = scanner.nextInt();

            if (number < 1 || number > 100) {
                System.out.println("Некорректные данные.");
                break;
            }

            list.add(number);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Main.inputData(list);

        if (list.get(0) < 2) {
            System.out.println("Неправильный ввод данных.");
            System.exit(0);
        }

        for (int i = 2; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i + 1)) {
                System.out.println("Неправильный ввод.");
                System.exit(0);
            }
        }

        if (list.get(list.size() - 1) > list.size() - 3) {
            System.out.println("Неправильный ввод.");
            System.exit(0);
        }

        if (list.get(list.size() - 1) < list.get(1)) {
            System.out.println(list.get(list.size() - 2) - 1);
        } else {
            System.out.println(list.get(list.size() - 2) - 2 + list.get(list.get(list.size() - 1) + 1));
        }

    }
}