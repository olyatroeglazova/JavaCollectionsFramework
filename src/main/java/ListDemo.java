import java.util.*;

public class ListDemo {

    //Количество строк входного списка, у которых первый символ совпадает с заданным
    public static int stringsNumberStartWith(List<String> list, char c){
        int result = 0;
        for (String string: list) {
            if (!string.isEmpty() && string.charAt(0) == c) {
                result++;
            }
        }
        return result;
    }

    //Список однофамильцев заданного человека среди людей из входного списка
    public List<Human> searchForNamesakes(List<Human> list, Human human) {
        List<Human> result = new ArrayList<>();
        final String findSurname = human.getSurname();
        for (Human h: list) {
            if (findSurname.equals(h.getSurname())) {
                result.add(h);
            }
        }
        return result;
    }

    //Копия входного списка, не содержащая выделенного человека
    public List<Human> listWithoutHuman(List<Human> list, Human human) {
        List<Human> result = new ArrayList<>();
        for (Human h: list) {
            if (!human.equals(h)) {
                result.add(new Human(h));
            }
        }
        return result;
    }

    //Список всех множеств входного списка, которые не пересекаются с заданным множеством
    public List<Set<Integer>> notIntersect(List<Set<Integer>> list, Set<Integer> set) {
        List<Set<Integer>> result = new ArrayList<>();
        for (Set<Integer> i: list) {
            Set<Integer> intersection = new HashSet<>(set);
            intersection.retainAll(i);
            if (intersection.size() == 0) {
                result.add(i);
            }
        }
        return result;
    }

    //Множество людей, идентификаторы которых содержатся во входном множестве
    public List<Human> getHumansWithIdsFromSet(Map<Integer, Human> map, Set<Integer> set) {
        List<Human> result = new ArrayList<>();
        for (int value: set) {
            Human h = map.get(value);
            if (h != null) {
                result.add(h);
            }
        }
        return result;
    }

    //Cписок идентификаторов людей, чей возраст не менее 18 лет
    public List<Integer> getHumansOlderThanSeventeen(Map<Integer, Human> map, Set<Integer> set) {
        List<Integer> result = new ArrayList<>();
        for (int value: set) {
            Human h = map.get(value);
            if (h != null && h.getAge() >= 18) {
                result.add(value);
            }
        }
        return result;
    }


};
