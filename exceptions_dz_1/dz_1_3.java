package exceptions_dz_1;

public class dz_1_3 {
// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя. 
// Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,4,4,4};
        int[] arr2 = new int[]{1,1,1,2,2,2};
        try {
            System.out.println("массив, равный частному элементов двух входящих массивов: ");
            printArr(newArr(arr, arr2));
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
        System.out.println("конец работы");
    }

    static int[] newArr(int[] arr, int[] arr2){
        int[] res = new int[arr.length];
            if (arr.length != arr2.length){
                throw new RuntimeException("длины массивов не равны");
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr2[i] == 0){
                throw new RuntimeException("Элемент второго массива с индексом [" + i + "] равен 0. На '0' делит нельзя!");
                }
                res[i] = arr[i] / arr2[i];
            }
        return res;
    }
     
    static void printArr(int[] arr){  
            for (int i = 0; i < arr.length-1; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.print(arr[arr.length-1]);
            System.out.println();
        }
}