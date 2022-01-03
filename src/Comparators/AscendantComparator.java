package Comparators;

import java.util.Comparator;
import java.util.List;

public class AscendantComparator extends CustomComparator {


    public AscendantComparator(){
        super();
    }

    @Override
    public int compare(List o1, List o2) {
        int r = String.valueOf(o1.get(super.getColumnIndex()))
                .compareTo(String.valueOf(o2.get(super.getColumnIndex())));
        if (r != 0) {
            return r;
        }
        return Integer.compare(o1.size(), o2.size());
    }

    /*@Override
    public int compare(List<T> o1, List<T> o2) {
        //System.out.println(o1.get(3));
        int c = o1.get(super.getColumnIndex()).compareTo(o2.get(super.getColumnIndex()));
        if (c != 0) {
            return c;
        }
        return Integer.compare(o1.size(), o2.size());
    }*/

}
