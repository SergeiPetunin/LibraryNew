/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Reader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class ReaderManager {
    private final Scanner scanner;

    public ReaderManager() {
        scanner = new Scanner(System.in);
    }
    
    public Reader createReader(){
        Reader reader = new Reader();
        System.out.print("Имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Фамилия читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    } 
    public void printListReaders(List<Reader> readers){
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    , i+1
                    , readers.get(i).getFirstname()
                    , readers.get(i).getLastname()
                    , readers.get(i).getPhone()
            );
        }
    }

    public List<Reader> changeReader(List<Reader> readers) {
        System.out.println("Список читателей: ");
        this.printListReaders(readers);
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Имя: "+readers.get(numberReader - 1).getFirstname());
        System.out.print("Заменить? (y/n): ");
        String task = scanner.nextLine();
        if("y".equals(task)){
            System.out.print("Введите новое имя: ");
            readers.get(numberReader - 1).setFirstname(scanner.nextLine());
        }
        System.out.println("Фамилия: "+readers.get(numberReader - 1).getLastname());
        System.out.print("Заменить? (y/n): ");
        task = scanner.nextLine();
        if("y".equals(task)){
            System.out.print("Введите новую фамилию: ");
            readers.get(numberReader - 1).setLastname(scanner.nextLine());
        }
        System.out.println("Телефон: "+readers.get(numberReader - 1).getPhone());
        System.out.print("Заменить? (y/n): ");
        task = scanner.nextLine();
        if("y".equals(task)){
            System.out.print("Введите новый телефон: ");
            readers.get(numberReader - 1).setPhone(scanner.nextLine());
        }
        System.out.println("Измененный читатель: "+readers.get(numberReader - 1).toString());
        return readers;
    }
}
