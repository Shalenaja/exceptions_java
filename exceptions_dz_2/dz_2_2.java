import java.util.Scanner;

// 2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

public class dz_2_2 {
    public static void main (String[] args) {
       
    double [] intArray = new double[]{1, 2, 3, 5, 6, 5, 6, 4, 9};
     
        try {
            int d = 0;                                             // ошибка арифметическая (деление на ноль)
            double catchedRes1 = intArray[8] / d;                  // ошибка не перехвачена                                                      
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {                    
            System.out.println("Catching exception: " + e);         
        }
     

// Исправленный код:
        try {
            int d = askUser();                                // значение задает пользователь 
            if (d == 0) throw new ArithmeticException("На 0 делить нельзя!");  // добавлен оператор для генерации исключения                            
            double catchedRes1 = intArray[8] / d;               
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {                    
            System.out.println("Catching exception: " + e);       
        }
    
    }
        public static int askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        return scanner.nextInt();
        }
}