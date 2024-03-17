package org.example;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// массивы с часами
        String[] firms = {"Rolex", "Casio", "Tissot"};
        String[][] watches = {
                {"Rolex", "Submariner"},
                {"Casio", "Sheen"},
                {"Tissot", "Lady"}
        };
        // Создать массив покупателей с помощью ArrayList(динамичный массив для добавления заказов)
        ArrayList<Shoppers> shoppers = new ArrayList<>();
        // Создать три заказа и добавление их в массив
        for (int i = 0; i < 3; i++) {
            Shoppers shopper = Orders(firms, watches);
            shoppers.add(shopper);
        }
        // Вывод информации о каждом заказчике и его заказе
        for (Shoppers shopper : shoppers) {
            System.out.println("Имя: " + shopper.getName());
            System.out.println("Email: " + shopper.getEmail());
            System.out.println("Номер телефона: " + shopper.getPhoneNumber());
            System.out.println("Позиция товара: " + shopper.getPosition());
            System.out.println("Количество: " + shopper.getQuantity());
            System.out.println();
        }
    }

    // Метод для создания заказа
    public static Shoppers Orders(String[] firms, String[][] watches) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите email: ");
        String email = scanner.nextLine();
        System.out.println("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        // Вывод списка всех имеющихся позиций в магазине - товар и фирма
        System.out.println("Список доступных позиций в магазине:");
        for (String[] watch : watches) {
            String firm = watch[0];
            String mark = watch[1];
            System.out.println(firm + " - " + mark);
        }
        System.out.println("Введите позицию товара (фирма и марка, разделенные пробелом): ");
        String position = scanner.nextLine();
        System.out.println("Введите количество: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        // Создание объекта покупателя и его возвращение
        Shoppers shopper = new Shoppers(name, email, phoneNumber, position, quantity);
        return shopper;
    }
}

class Shoppers {
    private String name;
    private String email;
    private String phoneNumber;
    private String position;
    private int quantity;
    public Shoppers(String name, String email, String phoneNumber, String position, int quantity) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPosition() {
        return position;
    }
    public int getQuantity() {
        return quantity;
    }
}