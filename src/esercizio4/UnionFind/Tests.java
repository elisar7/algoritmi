package UnionFind;

import org.junit.Before;
import org.junit.Test;

import java.lang.*;

import static org.junit.Assert.assertTrue;

public class Tests {
    Integer n1;
    Integer n2;
    Integer n3;
    UnionFind<Integer> uf;

    @Before
    public void create() {
        n1 = 2;
        n2 = 3;
        n3 = 4;
        uf = new UnionFind();
    }

    @Test
    public void testMakeSet() {
        uf.makeSet(n1);
        assertTrue(uf.getNode().get(n1).getParent() == n1);
    }

    @Test
    public void testFindSet() {
        uf.makeSet(n1);
        assertTrue(uf.findSet(n1) == n1);
    }

    @Test
    public void Union() {
        uf.makeSet(n1);
        uf.makeSet(n2);
        uf.union(n1, n2);
        assertTrue(uf.findSet(n1) == uf.findSet(n2));
    }

}
