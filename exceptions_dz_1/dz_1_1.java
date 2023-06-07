package exceptions_dz_1;

import java.io.File;

public class dz_1_1 { 
// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[]{2, 3, 5, 0, 9};
        try {  
            System.out.println(getFileSize(new File("new.file")));    
            System.out.println(findIndex(arr, 7));        
        } catch (RuntimeException exception){
        System.out.println(exception.getMessage());
        } 
        try {           
            printArr(newArr(arr, n)); 
        } catch (RuntimeException exception){
        System.out.println(exception.getMessage());
        } 
        
        System.out.println("Конец!");     
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            throw new RuntimeException("Файл не найден");
        }
        return file.length();
    }


    static int findIndex(int[] arr, int index){
        int res = 0;
        int res_index = -1;  
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                res = arr[i];
                res_index = i;               
            }
        }
        if (res_index > -1) {
            return res;
        }
        else  {
            throw new RuntimeException("Нет элемента с таким значением индекса");
        }
    }

    static int[] newArr(int[] arr, int m){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){           
            if (arr[i] == 0){
                throw new RuntimeException("Элемент массива с индексом [" + i + "] равен 0. Массив содержит 0-значения!");
            }                     
            res[i] = m / arr[i];
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