package tests;

import HashTables.MyDirectHashTable;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyDirectHashTableTests {

    @Test
    void myHashTableTestsGetPut(){
        MyDirectHashTable table = new MyDirectHashTable(2);
        table.put("1","tree");
        table.put("2","two");
        table.put("3","three");
        Assert.assertEquals(table.get("1"),"tree");
        Assert.assertEquals(table.get("3"),"three");
    }

    @Test
    void myHashTableTestsRemove(){
        MyDirectHashTable table = new MyDirectHashTable(2);
        table.put("1","tree");
        table.put("2","two");
        table.put("3","three");
        Assert.assertEquals(table.remove("2"),"two");
        Assert.assertEquals(table.get("2"),null);
        table.put("2","newtwo");
        Assert.assertEquals(table.remove("2"),"newtwo");
        Assert.assertEquals(table.get("3"),"three");
    }
}
