package exceptions_dz_1;

public class dz_1_2 {
// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить? 
// public static int sum2d(String[][] arr){ int sum = 0; for (int i = 0; i < arr.length; i++) 
// { for (int j = 0; j < 5; j++) { int val = Integer.parseInt(arr[i][j]); sum += val; } } return sum; }

    public static int sum2d(String[][] arr) { 
        int sum = 0; 
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < 5; j++) { 
                int val = Integer.parseInt(arr[i][j]); 
                sum += val; 
            } 
        } return sum; 
    } 
}
// В данном коде возможны следующие типы исключений:
// 1. IndexOutOfBoundsException - возникнет, если в массиве кол-во элементов меньше, чем 5 (ограничение, 
//    установленное в коде). Выход за предел индексов.
// 2. NumberFormatExeption - возникнет, если в строке будет не число
// 3. NullPointerException - возникнет, если строкой окажется null