package leetcode.editor.cn;

//给你一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例： 
//
// 
// 线程 A 将会调用 foo() 方法，而 
// 线程 B 将会调用 bar() 方法 
// 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："foobar"
//解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出："foobarfoobar"
//解释："foobar" 将被输出两次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 多线程 👍 142 👎 0

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFoobarAlternately {
    public static void main(String[] args) {
        Solution solution = new PrintFoobarAlternately().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Solution() {

        }
    }

    class FooBar {
        private int n;
        // 信号量
        private Semaphore foo_semaphore = new Semaphore(1);
        private Semaphore bar_semaphore = new Semaphore(0);

        // 阻塞队列
        private BlockingQueue<Integer> foo = new LinkedBlockingQueue<Integer>(1);
        private BlockingQueue<Integer> bar = new LinkedBlockingQueue<Integer>(1);

        // CyclicBarrier 控制先后
        CyclicBarrier cb = new CyclicBarrier(2);
        volatile boolean fin = true;

        // 自旋 + 让出CPU
        volatile boolean permitFoo = true;

        // 可重入锁 + Condition
        Lock lock = new ReentrantLock(true);
        private final Condition fooCondition = lock.newCondition();
        volatile boolean flag = true;

        // synchronized + 标志位 + 唤醒
        // 标志位，控制执行顺序，true执行printFoo，false执行printBar
        private volatile boolean type = true;
        // 锁标志
        private final Object fooObject = new Object();


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo_semaphore.acquire();
                printFoo.run();
                bar_semaphore.release();
            }

            for (int i = 0; i < n; i++) {
                foo.put(i);
                printFoo.run();
                bar.put(i);
            }

            for (int i = 0; i < n; i++) {
                while (!fin) {
                }
                printFoo.run();
                fin = false;
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                }
            }

            for (int i = 0; i < n; ) {
                if (permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                } else {
                    Thread.yield();
                }
            }

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (!flag) {
                        fooCondition.await();
                    }
                    printFoo.run();
                    flag = false;
                    fooCondition.signal();
                } finally {
                    lock.unlock();
                }
            }

            for (int i = 0; i < n; i++) {
                synchronized (fooObject) {
                    while (!type) {
                        fooObject.wait();
                    }
                    printFoo.run();
                    type = false;
                    fooObject.notifyAll();
                }
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar_semaphore.acquire();
                printBar.run();
                foo_semaphore.release();
            }

            for (int i = 0; i < n; i++) {
                bar.take();
                printBar.run();
                foo.take();
            }

            for (int i = 0; i < n; i++) {
                try {
                    cb.await();
                } catch (BrokenBarrierException e) {
                }
                printBar.run();
                fin = true;
            }

            for (int i = 0; i < n; ) {
                if (!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                } else {
                    Thread.yield();
                }
            }

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (flag) {
                        fooCondition.await();
                    }
                    printBar.run();
                    flag = true;
                    fooCondition.signal();
                } finally {
                    lock.unlock();
                }
            }

            for (int i = 0; i < n; i++) {
                synchronized (fooObject) {
                    while (type) {
                        fooObject.wait();
                    }
                    printBar.run();
                    type = true;
                    fooObject.notifyAll();
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}