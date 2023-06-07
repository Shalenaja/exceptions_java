import java.util.Scanner;

// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class dz_2_1 {
 
    public static void main(String[] args) {
        String val = askUser();
        getAnswer(val);
    }

    static void getAnswer(String code) {      
        try {float val = Float.parseFloat(code);
            System.out.println(val);            
        } catch (NumberFormatException e) {
            System.out.println("Введено не число. Попробуйте снова!"); 
            getAnswer(askUser());
        }
    }

    public static String askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        return scanner.next();
    }
}
