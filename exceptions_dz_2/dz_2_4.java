// 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

//import javax.lang.model.util.ElementScanner14;

public class dz_2_4 {
 
    public static void main(String[] args) {
        String val = askUser();
        try {          
            if (val.isEmpty()) throw new NullPointerException ("Пустая строка. Пустые строки вводить нельзя!");       
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    public static String askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение");
        return scanner.nextLine();
    }
}

