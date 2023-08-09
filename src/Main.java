import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void inputData(List<Integer> list){

        File file = new File("input.txt");
        Scanner scanner = null;
        int number;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while(scanner.hasNextLine()) {
            number = scanner.nextInt();

            if (number < 1 || number > 2 * Math.pow(10, 9)){
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

        if (list.size() > 1){
            System.out.println("Ввели больше одного числа.");
            System.exit(0);
        }

        if (list.get(0) % 2 == 0){
            System.out.println(list.get(0) / 2);
        } else {
            System.out.println(1 + (list.get(0) - 1) / 2);
        }

    }
}