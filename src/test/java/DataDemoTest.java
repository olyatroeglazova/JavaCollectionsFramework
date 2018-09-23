import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataDemoTest {
    @Test
    public void iterateAll() {
        Data data = new Data("data", new ArrayList<>());
        data.setGroups(new Group(0,0,1,2,3), new Group(1,4,5), new Group(2, 6));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<7; i++){
            list.add(i);
        }
        Assert.assertEquals(list, DataDemo.getAll(data));
    }

    @Test
    public void iterateWithEmptyGroups() {
        Data data = new Data("data", new ArrayList<>());
        data.setGroups(new Group(0), new Group(1,0,1,2,3), new Group(2), new Group(3, 4,5));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<6; i++){
            list.add(i);
        }
        Assert.assertEquals(list, DataDemo.getAll(data));
    }

    @Test
    public void iterateAllInEmpty() {
        Data data = new Data("name");
        Assert.assertEquals(new ArrayList<>(), DataDemo.getAll(data));
    }

}