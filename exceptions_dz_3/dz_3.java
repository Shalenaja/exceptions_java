import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
// вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
// пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку 
// должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.

public class dz_3 {
    public static void main (String[] args)  throws Exception{
        String options = askUser();      
        String[] array = options.split(" ");
        String surname = array[0];
        try {
            String text = textToWrite(array);
            if (text == null || text.isEmpty()) {
                throw new NullPointerException("Запись не возможна. Данные не прошли проверку!");
            }
            saveFile(text, surname); 
        } catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }
            
    }

    public static String textToWrite(String[] array)  throws Exception {
        String fileText = null;          
        try {

            int size1 = 6-array.length;
            int size2 = array.length-6;
            if (array.length > 6){
                throw new RuntimeException("Введено параметров на" +size1+ " больше");
            }
            if (array.length < 6){
                throw new RuntimeException("Введено параметров на" +size2+ " меньше");
            }
            String surname = array[0];
            String name = array[1];
            String patronymic = array[2];                 
            DateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
            java.util.Date date = new SimpleDateFormat("dd.mm.yyyy").parse(array[3]);
            int phone = Integer.parseInt(array[4]);              
            String gender = array[5];
            if (!gender.equals("m") && !gender.equals("f")) {    
                throw new RuntimeException("Неверно введен пол");
                }
            fileText = String.join("><", "<"+surname, name, patronymic, formatter.format(date), Integer.toString(phone), gender+">");
            
            } catch (ParseException e) {
                System.out.println(e.getMessage() + "Неверный формат даты рождения");
            }
            catch (NumberFormatException en) {
                System.out.println(en.getMessage() + "Неверный формат телефона");
            }
            catch (RuntimeException er) {
                System.out.println(er.getMessage());
            }
      
        return fileText;     
        }
            
    public static String askUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите через пробел фамилию, имя, отчество, дату рождения(формат dd.mm.yyyy),"
            +"номер телефона (число без разделителей) и пол(символ 'f' 'm')");
            return scanner.nextLine();
        }
    }
    
    public static void saveFile(String text, String surname) throws IOException{
        File file = new File("D:\\" +surname+ ".txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {  
             fileWriter.append(text).append(" ");        
             fileWriter.close();
             System.out.println("success");
        } catch (IOException e){
             throw new FileSystemException(e.getMessage());
         }
    }
}
