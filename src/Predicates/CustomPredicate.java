package Predicates;

import java.util.List;
import java.util.function.Predicate;

abstract public class CustomPredicate implements Predicate<List<String>> {

    int columnIndex;

    @Override
    public abstract boolean test(List<String> strings);

    public void setColumnIndex(int index){
        this.columnIndex = index;
    }
}
