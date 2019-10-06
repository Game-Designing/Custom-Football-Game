package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.C8507E;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class Loader implements C8499s {

    /* renamed from: a */
    public static final C8455b f18607a = m20155a(false, -9223372036854775807L);

    /* renamed from: b */
    public static final C8455b f18608b = m20155a(true, -9223372036854775807L);

    /* renamed from: c */
    public static final C8455b f18609c = new C8455b(2, -9223372036854775807L);

    /* renamed from: d */
    public static final C8455b f18610d = new C8455b(3, -9223372036854775807L);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ExecutorService f18611e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C8456c<? extends C8457d> f18612f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IOException f18613g;

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable cause) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected ");
            sb.append(cause.getClass().getSimpleName());
            sb.append(": ");
            sb.append(cause.getMessage());
            super(sb.toString(), cause);
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.Loader$a */
    public interface C8454a<T extends C8457d> {
        /* renamed from: a */
        C8455b mo25703a(T t, long j, long j2, IOException iOException, int i);

        /* renamed from: a */
        void mo25707a(T t, long j, long j2);

        /* renamed from: a */
        void mo25708a(T t, long j, long j2, boolean z);
    }

    /* renamed from: com.google.android.exoplayer2.upstream.Loader$b */
    public static final class C8455b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final int f18614a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final long f18615b;

        private C8455b(int type, long retryDelayMillis) {
            this.f18614a = type;
            this.f18615b = retryDelayMillis;
        }

        /* renamed from: a */
        public boolean mo25927a() {
            int i = this.f18614a;
            return i == 0 || i == 1;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.exoplayer2.upstream.Loader$c */
    private final class C8456c<T extends C8457d> extends Handler implements Runnable {

        /* renamed from: a */
        public final int f18616a;

        /* renamed from: b */
        private final T f18617b;

        /* renamed from: c */
        private final long f18618c;

        /* renamed from: d */
        private C8454a<T> f18619d;

        /* renamed from: e */
        private IOException f18620e;

        /* renamed from: f */
        private int f18621f;

        /* renamed from: g */
        private volatile Thread f18622g;

        /* renamed from: h */
        private volatile boolean f18623h;

        /* renamed from: i */
        private volatile boolean f18624i;

        public C8456c(Looper looper, T loadable, C8454a<T> callback, int defaultMinRetryCount, long startTimeMs) {
            super(looper);
            this.f18617b = loadable;
            this.f18619d = callback;
            this.f18616a = defaultMinRetryCount;
            this.f18618c = startTimeMs;
        }

        /* renamed from: a */
        public void mo25928a(int minRetryCount) throws IOException {
            IOException iOException = this.f18620e;
            if (iOException != null && this.f18621f > minRetryCount) {
                throw iOException;
            }
        }

        /* renamed from: a */
        public void mo25929a(long delayMillis) {
            C8514e.m20490b(Loader.this.f18612f == null);
            Loader.this.f18612f = this;
            if (delayMillis > 0) {
                sendEmptyMessageDelayed(0, delayMillis);
            } else {
                m20171a();
            }
        }

        /* renamed from: a */
        public void mo25930a(boolean released) {
            this.f18624i = released;
            this.f18620e = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!released) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f18623h = true;
                this.f18617b.mo25715b();
                if (this.f18622g != null) {
                    this.f18622g.interrupt();
                }
            }
            if (released) {
                m20172b();
                long nowMs = SystemClock.elapsedRealtime();
                this.f18619d.mo25708a(this.f18617b, nowMs, nowMs - this.f18618c, true);
                this.f18619d = null;
            }
        }

        public void run() {
            String str = "LoadTask";
            try {
                this.f18622g = Thread.currentThread();
                if (!this.f18623h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("load:");
                    sb.append(this.f18617b.getClass().getSimpleName());
                    C8507E.m20417a(sb.toString());
                    this.f18617b.mo25714a();
                    C8507E.m20416a();
                }
                if (!this.f18624i) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.f18624i) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (InterruptedException e2) {
                C8514e.m20490b(this.f18623h);
                if (!this.f18624i) {
                    sendEmptyMessage(2);
                }
            } catch (Exception e3) {
                C8526n.m20530a(str, "Unexpected exception loading stream", e3);
                if (!this.f18624i) {
                    obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                C8526n.m20530a(str, "OutOfMemory error loading stream", e4);
                if (!this.f18624i) {
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (Error e5) {
                C8526n.m20530a(str, "Unexpected error loading stream", e5);
                if (!this.f18624i) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (Throwable th) {
                C8507E.m20416a();
                throw th;
            }
        }

        public void handleMessage(Message msg) {
            long j;
            Message message = msg;
            if (!this.f18624i) {
                int i = message.what;
                if (i == 0) {
                    m20171a();
                } else if (i != 4) {
                    m20172b();
                    long nowMs = SystemClock.elapsedRealtime();
                    long durationMs = nowMs - this.f18618c;
                    if (this.f18623h) {
                        this.f18619d.mo25708a(this.f18617b, nowMs, durationMs, false);
                        return;
                    }
                    int i2 = message.what;
                    if (i2 == 1) {
                        this.f18619d.mo25708a(this.f18617b, nowMs, durationMs, false);
                    } else if (i2 == 2) {
                        try {
                            this.f18619d.mo25707a(this.f18617b, nowMs, durationMs);
                        } catch (RuntimeException e) {
                            C8526n.m20530a("LoadTask", "Unexpected exception handling load completed", e);
                            Loader.this.f18613g = new UnexpectedLoaderException(e);
                        }
                    } else if (i2 == 3) {
                        this.f18620e = (IOException) message.obj;
                        this.f18621f++;
                        C8455b action = this.f18619d.mo25703a(this.f18617b, nowMs, durationMs, this.f18620e, this.f18621f);
                        if (action.f18614a == 3) {
                            Loader.this.f18613g = this.f18620e;
                        } else if (action.f18614a != 2) {
                            if (action.f18614a == 1) {
                                this.f18621f = 1;
                            }
                            if (action.f18615b != -9223372036854775807L) {
                                j = action.f18615b;
                            } else {
                                j = m20173c();
                            }
                            mo25929a(j);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        /* renamed from: a */
        private void m20171a() {
            this.f18620e = null;
            Loader.this.f18611e.execute(Loader.this.f18612f);
        }

        /* renamed from: b */
        private void m20172b() {
            Loader.this.f18612f = null;
        }

        /* renamed from: c */
        private long m20173c() {
            return (long) Math.min((this.f18621f - 1) * 1000, 5000);
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.Loader$d */
    public interface C8457d {
        /* renamed from: a */
        void mo25714a() throws IOException, InterruptedException;

        /* renamed from: b */
        void mo25715b();
    }

    /* renamed from: com.google.android.exoplayer2.upstream.Loader$e */
    public interface C8458e {
        /* renamed from: f */
        void mo25710f();
    }

    /* renamed from: com.google.android.exoplayer2.upstream.Loader$f */
    private static final class C8459f implements Runnable {

        /* renamed from: a */
        private final C8458e f18626a;

        public C8459f(C8458e callback) {
            this.f18626a = callback;
        }

        public void run() {
            this.f18626a.mo25710f();
        }
    }

    public Loader(String threadName) {
        this.f18611e = C8509F.m20475d(threadName);
    }

    /* renamed from: a */
    public static C8455b m20155a(boolean resetErrorCount, long retryDelayMillis) {
        return new C8455b(resetErrorCount, retryDelayMillis);
    }

    /* renamed from: a */
    public <T extends C8457d> long mo25922a(T loadable, C8454a<T> callback, int defaultMinRetryCount) {
        Looper looper = Looper.myLooper();
        C8514e.m20490b(looper != null);
        this.f18613g = null;
        long startTimeMs = SystemClock.elapsedRealtime();
        C8456c cVar = new C8456c(looper, loadable, callback, defaultMinRetryCount, startTimeMs);
        cVar.mo25929a(0);
        return startTimeMs;
    }

    /* renamed from: b */
    public boolean mo25926b() {
        return this.f18612f != null;
    }

    /* renamed from: a */
    public void mo25923a() {
        this.f18612f.mo25930a(false);
    }

    /* renamed from: a */
    public void mo25925a(C8458e callback) {
        C8456c<? extends C8457d> cVar = this.f18612f;
        if (cVar != null) {
            cVar.mo25930a(true);
        }
        if (callback != null) {
            this.f18611e.execute(new C8459f(callback));
        }
        this.f18611e.shutdown();
    }

    /* renamed from: a */
    public void mo25924a(int minRetryCount) throws IOException {
        IOException iOException = this.f18613g;
        if (iOException == null) {
            C8456c<? extends C8457d> cVar = this.f18612f;
            if (cVar != null) {
                cVar.mo25928a(minRetryCount == Integer.MIN_VALUE ? cVar.f18616a : minRetryCount);
                return;
            }
            return;
        }
        throw iOException;
    }
}
