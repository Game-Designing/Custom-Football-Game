package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@KeepForSdk
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {

    /* renamed from: a */
    static final ThreadLocal<Boolean> f19619a = new C8652Q();

    /* renamed from: b */
    private final Object f19620b;

    /* renamed from: c */
    private final CallbackHandler<R> f19621c;

    /* renamed from: d */
    private final WeakReference<GoogleApiClient> f19622d;

    /* renamed from: e */
    private final CountDownLatch f19623e;

    /* renamed from: f */
    private final ArrayList<StatusListener> f19624f;

    /* renamed from: g */
    private ResultCallback<? super R> f19625g;

    /* renamed from: h */
    private final AtomicReference<C8646L> f19626h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public R f19627i;

    /* renamed from: j */
    private Status f19628j;

    /* renamed from: k */
    private volatile boolean f19629k;

    /* renamed from: l */
    private boolean f19630l;

    /* renamed from: m */
    private boolean f19631m;
    @KeepName
    private C8634a mResultGuardian;

    /* renamed from: n */
    private ICancelToken f19632n;

    /* renamed from: o */
    private volatile zacm<R> f19633o;

    /* renamed from: p */
    private boolean f19634p;

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void mo27459a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.mo27408a(result);
                } catch (RuntimeException e) {
                    BasePendingResult.m21213b(result);
                    throw e;
                }
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).mo27453b(Status.f19600d);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$a */
    private final class C8634a {
        private C8634a() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            BasePendingResult.m21213b(BasePendingResult.this.f19627i);
            super.finalize();
        }

        /* synthetic */ C8634a(BasePendingResult basePendingResult, C8652Q q) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f19620b = new Object();
        this.f19623e = new CountDownLatch(1);
        this.f19624f = new ArrayList<>();
        this.f19626h = new AtomicReference<>();
        this.f19634p = false;
        this.f19621c = new CallbackHandler<>(Looper.getMainLooper());
        this.f19622d = new WeakReference<>(null);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public abstract R mo27233a(Status status);

    @KeepForSdk
    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.f19620b = new Object();
        this.f19623e = new CountDownLatch(1);
        this.f19624f = new ArrayList<>();
        this.f19626h = new AtomicReference<>();
        this.f19634p = false;
        this.f19621c = new CallbackHandler<>(googleApiClient != null ? googleApiClient.mo27388g() : Looper.getMainLooper());
        this.f19622d = new WeakReference<>(googleApiClient);
    }

    @KeepForSdk
    /* renamed from: c */
    public final boolean mo27455c() {
        return this.f19623e.getCount() == 0;
    }

    /* renamed from: a */
    public final R mo27400a(long j, TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.m21870c("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        Preconditions.m21868b(!this.f19629k, "Result has already been consumed.");
        if (this.f19633o != null) {
            z = false;
        }
        Preconditions.m21868b(z, "Cannot await if then() has been called.");
        try {
            if (!this.f19623e.await(j, timeUnit)) {
                mo27453b(Status.f19600d);
            }
        } catch (InterruptedException e) {
            mo27453b(Status.f19598b);
        }
        Preconditions.m21868b(mo27455c(), "Result is not ready.");
        return mo27449g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27402a(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f19620b
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000a
            r6 = 0
            r5.f19625g = r6     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x000a:
            boolean r1 = r5.f19629k     // Catch:{ all -> 0x003f }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.m21868b(r1, r4)     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.internal.zacm<R> r1 = r5.f19633o     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.m21868b(r2, r1)     // Catch:{ all -> 0x003f }
            boolean r1 = r5.mo27454b()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x002b:
            boolean r1 = r5.mo27455c()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r1 = r5.f19621c     // Catch:{ all -> 0x003f }
            com.google.android.gms.common.api.Result r2 = r5.mo27449g()     // Catch:{ all -> 0x003f }
            r1.mo27459a(r6, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x003b:
            r5.f19625g = r6     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.mo27402a(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* renamed from: a */
    public final void mo27401a(StatusListener statusListener) {
        Preconditions.m21864a(statusListener != null, (Object) "Callback cannot be null.");
        synchronized (this.f19620b) {
            if (mo27455c()) {
                statusListener.mo27403a(this.f19628j);
            } else {
                this.f19624f.add(statusListener);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27350a() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f19620b
            monitor-enter(r0)
            boolean r1 = r2.f19630l     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002a
            boolean r1 = r2.f19629k     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            com.google.android.gms.common.internal.ICancelToken r1 = r2.f19632n     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0017
            com.google.android.gms.common.internal.ICancelToken r1 = r2.f19632n     // Catch:{ RemoteException -> 0x0016 }
            r1.cancel()     // Catch:{ RemoteException -> 0x0016 }
            goto L_0x0017
        L_0x0016:
            r1 = move-exception
        L_0x0017:
            R r1 = r2.f19627i     // Catch:{ all -> 0x002c }
            m21213b(r1)     // Catch:{ all -> 0x002c }
            r1 = 1
            r2.f19630l = r1     // Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.f19601e     // Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.Result r1 = r2.mo27233a(r1)     // Catch:{ all -> 0x002c }
            r2.mo27447c(r1)     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return
        L_0x002c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.mo27350a():void");
    }

    /* renamed from: e */
    public final boolean mo27457e() {
        boolean b;
        synchronized (this.f19620b) {
            if (((GoogleApiClient) this.f19622d.get()) == null || !this.f19634p) {
                mo27350a();
            }
            b = mo27454b();
        }
        return b;
    }

    /* renamed from: b */
    public boolean mo27454b() {
        boolean z;
        synchronized (this.f19620b) {
            z = this.f19630l;
        }
        return z;
    }

    @KeepForSdk
    /* renamed from: a */
    public final void mo27451a(R r) {
        synchronized (this.f19620b) {
            if (this.f19631m || this.f19630l) {
                m21213b((Result) r);
                return;
            }
            boolean c = mo27455c();
            boolean z = true;
            Preconditions.m21868b(!mo27455c(), "Results have already been set");
            if (this.f19629k) {
                z = false;
            }
            Preconditions.m21868b(z, "Result has already been consumed");
            mo27447c(r);
        }
    }

    /* renamed from: b */
    public final void mo27453b(Status status) {
        synchronized (this.f19620b) {
            if (!mo27455c()) {
                mo27451a((R) mo27233a(status));
                this.f19631m = true;
            }
        }
    }

    /* renamed from: a */
    public final void mo27452a(C8646L l) {
        this.f19626h.set(l);
    }

    /* renamed from: d */
    public final Integer mo27456d() {
        return null;
    }

    /* renamed from: f */
    public final void mo27458f() {
        this.f19634p = this.f19634p || ((Boolean) f19619a.get()).booleanValue();
    }

    /* renamed from: g */
    private final R mo27449g() {
        R r;
        synchronized (this.f19620b) {
            Preconditions.m21868b(!this.f19629k, "Result has already been consumed.");
            Preconditions.m21868b(mo27455c(), "Result is not ready.");
            r = this.f19627i;
            this.f19627i = null;
            this.f19625g = null;
            this.f19629k = true;
        }
        C8646L l = (C8646L) this.f19626h.getAndSet(null);
        if (l != null) {
            l.mo27507a(this);
        }
        return r;
    }

    /* renamed from: c */
    private final void mo27447c(R r) {
        this.f19627i = r;
        this.f19632n = null;
        this.f19623e.countDown();
        this.f19628j = this.f19627i.getStatus();
        if (this.f19630l) {
            this.f19625g = null;
        } else if (this.f19625g != null) {
            this.f19621c.removeMessages(2);
            this.f19621c.mo27459a(this.f19625g, mo27449g());
        } else if (this.f19627i instanceof Releasable) {
            this.mResultGuardian = new C8634a(this, null);
        }
        ArrayList<StatusListener> arrayList = this.f19624f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((StatusListener) obj).mo27403a(this.f19628j);
        }
        this.f19624f.clear();
    }

    /* renamed from: b */
    public static void m21213b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).mo27353a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }
}
