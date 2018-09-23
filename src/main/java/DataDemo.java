import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDemo {
    public static List<Integer> getAll(Data data) {
        List<Integer> list = new ArrayList<>();
        final Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
