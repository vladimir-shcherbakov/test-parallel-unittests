package org.shch;

import org.junit.Assert;
import org.junit.Test;


public class App2Test {
    @Test
    public void getHelloWorld3() throws Exception {
        Const.doLongOp();
        Assert.assertEquals(App2.getHelloWorld3(), "Hello World 3");
    }

    @Test
    public void getHelloWorld4() throws Exception {
        Const.doLongOp();
        Assert.assertEquals(App2.getHelloWorld4(), "Hello World 4");
    }
}
