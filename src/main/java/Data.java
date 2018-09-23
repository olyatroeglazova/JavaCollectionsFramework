import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private String name;
    private List<Group> groups;
    private DataIterator iterator;

    public Data(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }
    public Data(String name, Group... groups) {
        this.name = name;
        this.groups = Arrays.asList(groups);
    }
    public Data(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setGroups(Group... groups) {
        this.groups = Arrays.asList(groups);
    }

    public DataIterator iterator() {
        if (this.iterator == null) {
            this.iterator = new DataIterator(this);
        }
        return this.iterator;
    }
}