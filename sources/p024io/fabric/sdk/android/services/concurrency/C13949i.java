package p024io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p024io.fabric.sdk.android.services.concurrency.C13948h;
import p024io.fabric.sdk.android.services.concurrency.C13956p;
import p024io.fabric.sdk.android.services.concurrency.C13960s;

/* renamed from: io.fabric.sdk.android.services.concurrency.i */
/* compiled from: DependencyPriorityBlockingQueue */
public class C13949i<E extends C13948h & C13960s & C13956p> extends PriorityBlockingQueue<E> {

    /* renamed from: a */
    final Queue<E> f42297a = new LinkedList();

    /* renamed from: b */
    private final ReentrantLock f42298b = new ReentrantLock();

    public E take() throws InterruptedException {
        return mo43384a(0, null, null);
    }

    public E peek() {
        try {
            return mo43384a(1, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return mo43384a(3, Long.valueOf(timeout), unit);
    }

    public E poll() {
        try {
            return mo43384a(2, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    public int size() {
        try {
            this.f42298b.lock();
            return this.f42297a.size() + super.size();
        } finally {
            this.f42298b.unlock();
        }
    }

    public <T> T[] toArray(T[] a) {
        try {
            this.f42298b.lock();
            return mo43388a((T[]) super.toArray(a), (T[]) this.f42297a.toArray(a));
        } finally {
            this.f42298b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f42298b.lock();
            return mo43388a((T[]) super.toArray(), (T[]) this.f42297a.toArray());
        } finally {
            this.f42298b.unlock();
        }
    }

    public int drainTo(Collection<? super E> c) {
        try {
            this.f42298b.lock();
            int numberOfItems = super.drainTo(c) + this.f42297a.size();
            while (!this.f42297a.isEmpty()) {
                c.add(this.f42297a.poll());
            }
            return numberOfItems;
        } finally {
            this.f42298b.unlock();
        }
    }

    public int drainTo(Collection<? super E> c, int maxElements) {
        try {
            this.f42298b.lock();
            int numberOfItems = super.drainTo(c, maxElements);
            while (!this.f42297a.isEmpty() && numberOfItems <= maxElements) {
                c.add(this.f42297a.poll());
                numberOfItems++;
            }
            return numberOfItems;
        } finally {
            this.f42298b.unlock();
        }
    }

    public boolean contains(Object o) {
        try {
            this.f42298b.lock();
            return super.contains(o) || this.f42297a.contains(o);
        } finally {
            this.f42298b.unlock();
        }
    }

    public void clear() {
        try {
            this.f42298b.lock();
            this.f42297a.clear();
            super.clear();
        } finally {
            this.f42298b.unlock();
        }
    }

    public boolean remove(Object o) {
        try {
            this.f42298b.lock();
            return super.remove(o) || this.f42297a.remove(o);
        } finally {
            this.f42298b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f42298b.lock();
            return super.removeAll(collection) | this.f42297a.removeAll(collection);
        } finally {
            this.f42298b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public E mo43389b(int operation, Long time, TimeUnit unit) throws InterruptedException {
        E value;
        if (operation == 0) {
            value = (C13948h) super.take();
        } else if (operation == 1) {
            value = (C13948h) super.peek();
        } else if (operation == 2) {
            value = (C13948h) super.poll();
        } else if (operation != 3) {
            return null;
        } else {
            value = (C13948h) super.poll(time.longValue(), unit);
        }
        return value;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo43386a(int operation, E result) {
        try {
            this.f42298b.lock();
            if (operation == 1) {
                super.remove(result);
            }
            return this.f42297a.offer(result);
        } finally {
            this.f42298b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public E mo43384a(int operation, Long time, TimeUnit unit) throws InterruptedException {
        C13948h hVar;
        while (true) {
            C13948h b = mo43389b(operation, time, unit);
            hVar = b;
            if (b == null || mo43387a(hVar)) {
                return hVar;
            }
            mo43386a(operation, (E) hVar);
        }
        return hVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo43387a(E result) {
        return result.mo43382b();
    }

    /* renamed from: a */
    public void mo43385a() {
        try {
            this.f42298b.lock();
            Iterator<E> iterator = this.f42297a.iterator();
            while (iterator.hasNext()) {
                E blockedItem = (C13948h) iterator.next();
                if (mo43387a(blockedItem)) {
                    super.offer(blockedItem);
                    iterator.remove();
                }
            }
        } finally {
            this.f42298b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> T[] mo43388a(T[] arr1, T[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        T[] C = (Object[]) Array.newInstance(arr1.getClass().getComponentType(), arr1Len + arr2Len);
        System.arraycopy(arr1, 0, C, 0, arr1Len);
        System.arraycopy(arr2, 0, C, arr1Len, arr2Len);
        return C;
    }
}
