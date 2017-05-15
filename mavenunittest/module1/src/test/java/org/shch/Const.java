package org.shch;

/**
 * Created by vlashch on 5/11/2017.
 */
public class Const {
    public static final int TO_SEC = 1000;
    public static final int TO_MIN = 60*TO_SEC;
    public static final int TIME_TO_SLEEP = 10*1000;

    public static int ttsSec(int val) {
        return val * TO_SEC;
    }

    public static int ttsMin(int val) {
        return val * TO_MIN;
    }

    public static void doLongOp() {
        int ms = 100;
        for (int i=0; i<TIME_TO_SLEEP/ms; ++i) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
