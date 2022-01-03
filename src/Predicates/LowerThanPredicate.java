package Predicates;

import java.util.List;

public class LowerThanPredicate<T> extends CustomPredicate{

    private T value;

    public LowerThanPredicate(T value){
        super();
        this.value = value;
    }


    @Override
    public boolean test(List<String> strings) {
        int r = strings.get(super.columnIndex).trim().compareTo(String.valueOf(value).trim());
        //System.out.println(strings.get(column) + " compare to " + value + ": " + strings.get(column).compareTo(value));
        if(r < 0){
            return true;
        }
        return false;
    }
}
