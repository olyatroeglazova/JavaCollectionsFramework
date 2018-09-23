import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Group {
    private int id;
    private List<Integer> data;

    public Group(int id) {
        this.id = id;
        this.data = new ArrayList<>();
    }

    public Group(int id, Integer... data) {
        this.id = id;
        this.data = Arrays.asList(data);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public void setData(Integer... data) {
        this.data = Arrays.asList(data);
    }

    public int length() {
        return this.data.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Group)) {
            return false;
        }
        Group group = (Group) o;
        return getId() == group.getId() &&
                Objects.equals(getData(), group.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData());
    }
}