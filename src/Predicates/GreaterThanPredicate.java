package Predicates;

import java.util.List;
import java.util.function.Predicate;

public class GreaterThanPredicate<T> extends CustomPredicate {

    private T value;

    public GreaterThanPredicate(T value){
        super();
        this.value = value;
    }

    @Override
    public boolean test(List<java.lang.String> strings) {
        int r = strings.get(super.columnIndex).trim().compareTo(String.valueOf(value).trim());
        if(r > 0){
            return true;
        }
        return false;
    }
}
/*    @Override
    public boolean test(List<java.lang.String> strings) {
        int r = strings.get(column).trim().compareTo(value.trim());
        if(r > 0){
            return true;
        }
        return false;
    }*/