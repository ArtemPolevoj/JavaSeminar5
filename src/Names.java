import java.util.ArrayList;
import java.util.HashMap;

public class Names {
    private  ArrayList<String> listName = new ArrayList<>();

    private void sorted(){
        getListName();
        listName.sort((o1, o2) -> {
            o1 = String.valueOf(o1.charAt(o1.length() - 1));
            o2 = String.valueOf(o2.charAt(o2.length() - 1));
            return o2.compareTo(o1);
        });

    }
    public void getSortedName(){
        sorted();
        listName.forEach(System.out::println);
    }
private void getListName(){
    String names = """
            Иван Иванов
            Светлана Петрова
            Кристина Белова
            Анна Мусина
            Анна Крутова
            Иван Юрин
            Петр Лыков
            Павел Чернов
            Петр Чернышов
            Мария Федорова
            Марина Светлова
            Мария Савина
            Мария Рыкова
            Марина Лугова
            Анна Владимирова
            Иван Мечников
            Петр Петин
            Иван Ежов
            """;
    HashMap<String, Integer> mapName = new HashMap<>();
    int index;
    int count;
    String name;
    String[] arrayFullName = names.split("\n");
    for (String fullName : arrayFullName) {
        index = fullName.indexOf(" ");
        name = fullName.substring(0, index);
        if (mapName.containsKey(name)) {
            count = mapName.get(name) + 1;
            mapName.put(name, count);
        } else {
            count = 1;
            mapName.put(name, count);
        }
    }
    mapName.forEach((k, v) -> listName.add(k + " - " + v));
}

}
