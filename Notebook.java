import java.util.*;

public class Laptop {
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Laptop(String model, int ram, int hdd, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

// Геттеры и сеттеры для полей класса

public static void main(String[] args) {
    // Создание множества ноутбуков
    Set<Laptop> laptops = new HashSet<>();
    laptops.add(new Laptop("Lenovo", 8, 256, "Windows 10", "Black"));
    laptops.add(new Laptop("Dell", 16, 512, "Windows 10", "Silver"));
    laptops.add(new Laptop("HP", 8, 512, "Windows 10", "White"));
    laptops.add(new Laptop("Asus", 16, 1_000, "Windows 10", "Black"));




}