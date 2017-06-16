import org.junit.Test;

import static org.junit.Assert.*;

public class TestHashMapOpenAddressing {

    @Test
    public void testSizeWhenOneElementAdded(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(0,0);
        assertEquals (1,hashMap.size());
    }

    @Test
    public void testSizeWhenFourElementsAdded(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(0,0);
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(3,3);
        assertEquals (4,hashMap.size());
    }

    @Test
    public void testSizeWhenDuplicatedKeysAdded(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(0,0);
        hashMap.put(1,1);
        hashMap.put(1,2);
        hashMap.put(3,3);
        hashMap.put(3,7);
        assertEquals (3,hashMap.size());
    }

    @Test
    public void testContains(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(5,5);
        assertTrue (hashMap.contains(5));
    }

    @Test
    public void testNotContains(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(5,5);
        assertFalse (hashMap.contains(1));
    }

    @Test
    public void testGetExistedElement(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(5,5);
        hashMap.put(6,2);
        hashMap.put(4,9);
        hashMap.put(6,4);
        assertEquals (4, hashMap.get(6));
    }

    @Test
    public void testGetAbsentElement(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing();
        hashMap.put(4,1);
        hashMap.put(6,2);
        hashMap.put(4,9);
        hashMap.put(6,4);
        assertEquals (Long.MIN_VALUE, hashMap.get(2));
    }

    @Test
    public void testToString(){
        final HashMapOpenAddressing hashMap = new HashMapOpenAddressing(5);
        hashMap.put(1,1);
        hashMap.put(6,2);
        hashMap.put(3,9);
        hashMap.put(9,4);
        hashMap.put(13,8);
        assertEquals ("[[13,8][1,1][6,2][3,9][9,4]]", hashMap.toString());
    }
}
