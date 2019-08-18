package com.ahscuml.MultiThread.Lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author ahscuml
 * @date 2019/4/15
 * @time 9:49
 */
public class TwinsLock {
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        @Override
        public int tryAcquireShared(int reducCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current - reducCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        public boolean tryReleaseShared(int returnCount) {
            for (; ; ) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }
}
