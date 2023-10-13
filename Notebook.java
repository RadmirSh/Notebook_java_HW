import java.util.*;

public class Notebook {
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Notebook(String model, int ram, int hdd, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    // Геттеры и сеттеры для полей класса

    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Notebook> laptops = new HashSet<>();
        laptops.add(new Notebook("Lenovo", 8, 256, "Windows 10", "Black"));
        laptops.add(new Notebook("Dell", 16, 512, "Windows 10", "Silver"));
        laptops.add(new Notebook("HP", 8, 512, "Windows 10", "White"));
        laptops.add(new Notebook("Asus", 16, 1_000, "Windows 10", "Black"));

        // Запрос критериев фильтрации у пользователя
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.print("Введите номер критерия: ");
        int criterion = scanner.nextInt();
        scanner.nextLine();

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ: ");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                int minHdd = scanner.nextInt();
                filters.put("hdd", minHdd);
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                String os = scanner.nextLine();
                filters.put("os", os);
                break;
            case 4:
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный номер критерия");
                break;
        }

        // Фильтрация ноутбуков и вывод результата
        Set<Notebook> filteredLaptops = filterLaptops(laptops, filters);
        System.out.println("Результаты фильтрации:");
        for (Notebook laptop : filteredLaptops) {
            System.out.println(laptop.model);
        }
    }

    public static Set<Notebook> filterLaptops(Set<Notebook> laptops, Map<String, Object> filters) {
        Set<Notebook> filteredLaptops = new HashSet<>();
        for (Notebook laptop : laptops) {
            boolean meetsCriteria = true;

            // Проверка всех критериев фильтрации
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (key.equals("ram") && laptop.ram < (int) value) {
                    meetsCriteria = false;
                    break;
                } else if (key.equals("hdd") && laptop.hdd < (int) value) {
                    meetsCriteria = false;
                    break;
                } else if (key.equals("os") && !laptop.os.equals(value)) {
                    meetsCriteria = false;
                    break;
                } else if (key.equals("color") && !laptop.color.equals(value)) {
                    meetsCriteria = false;
                    break;
                }
            }

            if (meetsCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}
