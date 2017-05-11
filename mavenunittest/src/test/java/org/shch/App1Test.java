package org.shch;

import org.junit.Assert;
import org.junit.Test;


public class App1Test {
    @Test
    public void getHelloWorld1() throws Exception {
        Const.doLongOp();
        Assert.assertEquals(App1.getHelloWorld1(), "Hello World 1");
    }

    @Test
    public void getHelloWorld2() throws Exception {
        Const.doLongOp();
        Assert.assertEquals(App1.getHelloWorld2(), "Hello World 2");
    }


}
