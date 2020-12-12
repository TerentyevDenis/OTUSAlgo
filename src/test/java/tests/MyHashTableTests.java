package tests;

import HashTables.MyHashTable;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyHashTableTests {

    @Test
    void myHashTableTestsGetPut(){
        MyHashTable table = new MyHashTable(2);
        table.put("1","tree");
        table.put("2","two");
        table.put("3","three");
        Assert.assertEquals(table.get("1"),"tree");
        Assert.assertEquals(table.get("3"),"three");
    }

    @Test
    void myHashTableTestsRemove(){
        MyHashTable table = new MyHashTable(2);
        table.put("1","tree");
        table.put("2","two");
        table.put("3","three");
        Assert.assertEquals(table.remove("2"),"two");
        Assert.assertEquals(table.get("2"),null);
        Assert.assertEquals(table.get("3"),"three");
    }
}
