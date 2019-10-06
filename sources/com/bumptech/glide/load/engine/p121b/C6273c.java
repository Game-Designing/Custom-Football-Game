package com.bumptech.glide.load.engine.p121b;

import com.bumptech.glide.p107h.C6024i;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.engine.b.c */
/* compiled from: DiskCacheWriteLocker */
final class C6273c {

    /* renamed from: a */
    private final Map<String, C6274a> f11096a = new HashMap();

    /* renamed from: b */
    private final C6275b f11097b = new C6275b();

    /* renamed from: com.bumptech.glide.load.engine.b.c$a */
    /* compiled from: DiskCacheWriteLocker */
    private static class C6274a {

        /* renamed from: a */
        final Lock f11098a = new ReentrantLock();

        /* renamed from: b */
        int f11099b;

        C6274a() {
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.b.c$b */
    /* compiled from: DiskCacheWriteLocker */
    private static class C6275b {

        /* renamed from: a */
        private final Queue<C6274a> f11100a = new ArrayDeque();

        C6275b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C6274a mo19182a() {
            C6274a result;
            synchronized (this.f11100a) {
                result = (C6274a) this.f11100a.poll();
            }
            if (result == null) {
                return new C6274a();
            }
            return result;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo19183a(C6274a writeLock) {
            synchronized (this.f11100a) {
                if (this.f11100a.size() < 10) {
                    this.f11100a.offer(writeLock);
                }
            }
        }
    }

    C6273c() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19180a(String safeKey) {
        C6274a writeLock;
        synchronized (this) {
            writeLock = (C6274a) this.f11096a.get(safeKey);
            if (writeLock == null) {
                writeLock = this.f11097b.mo19182a();
                this.f11096a.put(safeKey, writeLock);
            }
            writeLock.f11099b++;
        }
        writeLock.f11098a.lock();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo19181b(String safeKey) {
        C6274a writeLock;
        synchronized (this) {
            Object obj = this.f11096a.get(safeKey);
            C6024i.m11264a(obj);
            writeLock = (C6274a) obj;
            if (writeLock.f11099b >= 1) {
                writeLock.f11099b--;
                if (writeLock.f11099b == 0) {
                    C6274a removed = (C6274a) this.f11096a.remove(safeKey);
                    if (removed.equals(writeLock)) {
                        this.f11097b.mo19183a(removed);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Removed the wrong lock, expected to remove: ");
                        sb.append(writeLock);
                        sb.append(", but actually removed: ");
                        sb.append(removed);
                        sb.append(", safeKey: ");
                        sb.append(safeKey);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot release a lock that is not held, safeKey: ");
                sb2.append(safeKey);
                sb2.append(", interestedThreads: ");
                sb2.append(writeLock.f11099b);
                throw new IllegalStateException(sb2.toString());
            }
        }
        writeLock.f11098a.unlock();
    }
}
