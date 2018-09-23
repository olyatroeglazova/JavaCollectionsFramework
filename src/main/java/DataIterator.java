import java.util.Iterator;

public class DataIterator implements Iterator {
    private int index;
    private Data data;
    private int currentGroupIndex;

    public DataIterator(Data data){
        this.index = -1;
        this.currentGroupIndex = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        try {
            data.getGroups().get(currentGroupIndex).getData().get(index + 1);
        } catch (IndexOutOfBoundsException e) {
            try {
                while (data.getGroups().get(currentGroupIndex + 1).length() == 0) {
                    ++currentGroupIndex;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object next() {
        try {
            return data.getGroups().get(currentGroupIndex).getData().get(++index);
        } catch (IndexOutOfBoundsException e) {
            index = 0;
            while (data.getGroups().get(currentGroupIndex + 1).length() == 0) {
                ++currentGroupIndex;
            }
            return data.getGroups().get(++currentGroupIndex).getData().get(0);
        }
    }

}