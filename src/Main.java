import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void inputData(List<Integer> list){

        File file = new File("input.txt");
        Scanner scanner = null;
        int number, diff_B_and_D;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while(scanner.hasNextLine()) {
            number = scanner.nextInt();

            if (number < 1 || number > 100){
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

        if (list.size() < 4){
            System.out.println("Вы ввели меньше 4 чисел.");
            System.exit(0);
        }

        if (list.get(1) - list.get(3) > 0){
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(0) + list.get(2) * (list.get(3) - list.get(1)));
        }

    }
}