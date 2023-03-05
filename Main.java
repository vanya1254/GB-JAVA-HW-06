import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
 * методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
 * фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую
 * необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки из первоначального множества и вывести проходящие по
 * условиям.
 */

public class Main {
    private static Integer[] keys = new Integer[]{1, 2, 3, 4};
    public static void main(String[] args) {
        Set<Map<Integer, String>> notebooks = new HashSet<>();
        Notebook nt1 = new Notebook();
        nt1.createRndNotebook();

        Notebook nt2 = new Notebook();
        nt2.createRndNotebook();

        Notebook nt3 = new Notebook();
        nt3.createRndNotebook();

        Notebook nt4 = new Notebook();
        nt4.createRndNotebook();

        Notebook nt5 = new Notebook();
        nt5.createRndNotebook();

        notebooks.add(nt1.getNotebook());
        notebooks.add(nt2.getNotebook());
        notebooks.add(nt3.getNotebook());
        notebooks.add(nt4.getNotebook());
        notebooks.add(nt5.getNotebook());

        System.out.println(notebooks);

        checkParams(inputParameters(), notebooks);
    }

    private static void checkParams(Map<Integer, String> inputMap, Set<Map<Integer, String>> data) {
        int count = 1;
        for (Map<Integer,String> map : data) {
            if (param1(inputMap, map) && param2(inputMap, map) && param3(inputMap, map) && param4(inputMap, map)) {
                showNotebook(map, count++);
            }
        }
    }

    private static void showNotebook(Map<Integer, String> map, int count) {
        System.out.println();
        System.out.printf("Notebook %d\n", count);
        System.out.printf("\tRAM: %s\n", map.get(1));
        System.out.printf("\tHDD: %s\n", map.get(2));
        System.out.printf("\tColor: %s\n", map.get(3));
        System.out.printf("\tOC: %s\n", map.get(4));
    }

    private static boolean param4(Map<Integer, String> input, Map<Integer, String> map) {
        if (map.get(4).toLowerCase().equals(input.get(4).toLowerCase()) || input.get(4).toLowerCase().equals("null")) return true;
        return false;
    }
// если вводить null в Color или OC покажет только по другим характеристикам
    private static boolean param3(Map<Integer, String> input, Map<Integer, String> map) {
        if (map.get(3).toLowerCase().equals(input.get(3).toLowerCase()) || input.get(3).toLowerCase().equals("null")) return true;
        return false;
    }

    private static boolean param2(Map<Integer, String> input, Map<Integer, String> map) {
        if (Integer.parseInt(map.get(2)) >= Integer.parseInt(input.get(2))) return true;
        return false;
    }

    private static boolean param1(Map<Integer, String> input, Map<Integer, String> map) {
        if (Integer.parseInt(map.get(1)) >= Integer.parseInt(input.get(1))) return true;
        return false;
    }

    public static Map<Integer, String> inputParameters(){
        Map<Integer, String> inputMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("RAM:");
        inputMap.put(keys[0], sc.next());
        System.out.println("HDD:");
        inputMap.put(keys[1], sc.next());
        System.out.println("OC:");
        inputMap.put(keys[2], sc.next());
        System.out.println("Color:");
        inputMap.put(keys[3], sc.next());
        sc.close();
        return inputMap;
    }
}