package MaxHeap;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap {

    /*
     * Determina se l'array in ingresso è uno heap oppure no, usando una strategia ricorsiva.
     */
    public static <T> Boolean isHeapRec (ArrayList<T> A, Comparator<T> cmp){
        return isHeapRec (A, cmp, 0, A.size());
    }

    private  static <T> Boolean isHeapRec (ArrayList<T> A, Comparator<T> cmp, int i, int j){
        if (i > (j-2)/2)
            return true;
        return cmp.compare(A.get(i), A.get(i * 2 + 1)) >= 0 && cmp.compare(A.get(i), A.get(i * 2)) >= 0 &&
                isHeapRec(A, cmp, i * 2 + 1, j) && isHeapRec(A, cmp, i * 2 + 2, j);
    }

    /*
     * Determina se l'array in ingresso è uno heap oppure no, usando una strategia iterativa.
     */
    public static <T> Boolean isHeapIt (ArrayList<T> A, Comparator<T> cmp){
        boolean flag = true;
        for (int i = 0; i < (A.size() / 2) && flag; i++){
            if (cmp.compare(A.get(i), A.get(i*2 + 1)) < 0 && cmp.compare(A.get(i), A.get(i*2)) < 0)
                flag = false;
        }
        return flag;
    }

}
