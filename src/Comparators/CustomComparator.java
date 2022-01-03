package Comparators;

import java.util.Comparator;
import java.util.List;

abstract public class CustomComparator<T> implements Comparator<List<T>> {

    private int columnIndex;

    @Override
    public abstract int compare(List<T> o1, List<T> o2);

    public void setColumnIndex(int index){
        this.columnIndex = index;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
