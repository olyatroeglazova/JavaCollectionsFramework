
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ListDemoTest {
    ListDemo list = new ListDemo();
    List<Human> humans = new ArrayList<>();
    @Test
    public void stringsNumberStartWith() {
        Assert.assertEquals(1, list.stringsNumberStartWith(Arrays.asList("one", "two", "three", "four"), 'o'));
    }

    @Test
    public void searchForNamesakes() throws Exception {
        humans.add(new Human("Troeglazova", "Olga", "Alexeevna", 19));
        humans.add(new Human("Troeglazova", "Maria", "Ivanovna", 21));
        humans.add(new Human("Troeglazova", "Anna", "Alexandrovna", 28));
        humans.add(new Human("Ivanov", "Ivan", "Ivanovich", 10));
        List<Human> namesakes = list.searchForNamesakes(humans,
                new Human("Troeglazova", "Tatyana", "Anatolievna", 30));
        Assert.assertEquals(3, namesakes.size());
        Assert.assertTrue(namesakes.get(0).getSurname().equals("Troeglazova"));
    }

    @Test
    public void listWithoutHuman() throws Exception {
        humans.add(new Human("Troeglazova", "Olga", "Alexeevna", 19));
        humans.add(new Human("Troeglazova", "Maria", "Ivanovna", 21));
        humans.add(new Human("Troeglazova", "Anna", "Alexandrovna", 28));
        humans.add(new Human("Ivanov", "Ivan", "Ivanovich", 10));
        List<Human> listWithoutIvanov = list.listWithoutHuman(humans,
                new Human("Ivanov", "Ivan", "Ivanovich", 10));
        Assert.assertEquals(list.searchForNamesakes(listWithoutIvanov,
                new Human("Ivanov", "Ivan", "Ivanovich", 10)).size(), 0);

    }

    @Test
    public void notIntersect() throws Exception {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> set3 = new HashSet<>();
        set3.add(6);
        set3.add(7);
        set3.add(8);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(9);
        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(set1);
        sets.add(set2);
        sets.add(set3);
        List<Set<Integer>> result = new ArrayList<>();
        result.add(set3);
        Assert.assertEquals(list.notIntersect(sets, set), result);
    }

    @Test
    public void notIntersect2() throws Exception {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> set3 = new HashSet<>();
        set3.add(6);
        set3.add(7);
        set3.add(8);
        Set<Integer> set = new HashSet<>();
        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(set1);
        sets.add(set2);
        sets.add(set3);
        List<Set<Integer>> result = new ArrayList<>();
        result.add(set1);
        result.add(set2);
        result.add(set3);
        Assert.assertEquals(list.notIntersect(sets, set), result);
    }

    @Test
    public void getHumansWithIdsFromSet() throws Exception {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(0,new Human("Troeglazova", "Olga", "Alexeevna", 19));
        humanMap.put(1,new Human("Troeglazova", "Maria", "Ivanovna", 21));
        humanMap.put(2,new Human("Troeglazova", "Anna", "Alexandrovna", 28));
        humanMap.put(3,new Human("Ivanov", "Ivan", "Ivanovich", 10));
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(2);
        set.add(333);
        List<Human> result = new ArrayList<>();
        result.add(new Human("Troeglazova", "Olga", "Alexeevna", 19));
        result.add(new Human("Troeglazova", "Anna", "Alexandrovna", 28));
        Assert.assertEquals(list.getHumansWithIdsFromSet(humanMap, set), result);
    }

    @Test
    public void getHumansOlderThanSeventeen() throws Exception {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(0,new Human("Troeglazova", "Olga", "Alexeevna", 19));
        humanMap.put(100,new Human("Troeglazova", "Maria", "Ivanovna", 21));
        humanMap.put(2,new Human("Troeglazova", "Anna", "Alexandrovna", 28));
        humanMap.put(3,new Human("Ivanov", "Ivan", "Ivanovich", 10));

        Set<Integer> result = new HashSet<>();
        result.add(0);
        result.add(100);
        result.add(2);
        Assert.assertEquals(list.getHumansOlderThanSeventeen(humanMap),result );
    }

}