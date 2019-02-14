package SortingUsage;
import java.util.Comparator;

public class ComparatorField1 implements Comparator<Record>{

    @Override
    public int compare(Record r1, Record r2){
        int result = (String.CASE_INSENSITIVE_ORDER).compare(r1.getField1(), r2.getField1());
        if (result != 0)
            return result;
        result = (r1.getField2() - r2.getField2());
        if (result != 0)
            return result;
        result = (int) (r1.getField3() - r2.getField3());
        if (result != 0)
            return result;
        return (r1.getIdField() - r2.getIdField());
    }

}