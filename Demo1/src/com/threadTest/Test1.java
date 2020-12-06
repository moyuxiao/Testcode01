package com.threadTest;

/**
 * Date: 2018/8/12
 * @author xuzhiyi
 */
public class Test1 {

    private static boolean flag = true;

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (flag) {
                i++;
            }
            System.out.printf("**********test1 跳出成功, i=%d **********\n", i);
        });
        thread.start();
        Thread.sleep(100);
        flag = false;
        System.out.printf("**********test1 main thread 结束, i=%d **********\n", i);
    }
}
