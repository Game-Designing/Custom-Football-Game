package com.fyber.inneractive.sdk.p166g.p167a;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.fyber.inneractive.sdk.g.a.d */
public final class C7767d {

    /* renamed from: j */
    private static C7767d f15600j = new C7767d();

    /* renamed from: a */
    public AtomicBoolean f15601a = new AtomicBoolean(false);

    /* renamed from: b */
    public ServerSocket f15602b;

    /* renamed from: c */
    public int f15603c;

    /* renamed from: d */
    public Thread f15604d;

    /* renamed from: e */
    public boolean f15605e = false;

    /* renamed from: f */
    List<C7756a> f15606f = new CopyOnWriteArrayList();

    /* renamed from: g */
    Executor f15607g = Executors.newCachedThreadPool(new ThreadFactory() {

        /* renamed from: a */
        AtomicInteger f15610a = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("MediaCacheStreamer-HandlerThread-");
            sb.append(this.f15610a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    });

    /* renamed from: h */
    List<C7785i> f15608h = new CopyOnWriteArrayList();

    /* renamed from: i */
    public Runnable f15609i = new Runnable() {
        public final void run() {
            while (C7767d.this.f15601a.compareAndSet(true, true)) {
                try {
                    Socket accept = C7767d.this.f15602b.accept();
                    StringBuilder sb = new StringBuilder("MediaCacheStreamer Got a possible connection - ");
                    sb.append(accept);
                    IAlog.m18019a(sb.toString());
                    C7767d.m17262a(C7767d.this, accept);
                } catch (IOException e) {
                    IAlog.m18020a("MediaCacheStreamer Failed accepting connections", e);
                }
            }
        }
    };

    private C7767d() {
    }

    /* renamed from: a */
    public static C7767d m17260a() {
        return f15600j;
    }

    /* renamed from: a */
    public final C7756a mo24387a(String str) {
        for (C7756a aVar : this.f15606f) {
            String str2 = "?";
            if (aVar.f15558g.startsWith(str.contains(str2) ? str.substring(1).substring(0, str.indexOf(str2) - 1) : str.substring(1))) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m17262a(C7767d dVar, Socket socket) {
        C7785i iVar = new C7785i(dVar, socket);
        Executor executor = iVar.f15650a;
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }
        IAlog.m18019a(String.format("StreamingHandler[%s] requesting execution of a new runnable", new Object[]{iVar}));
        executor.execute(new Runnable() {
            public final void run() {
                IAlog.m18019a(String.format("StreamingHandler[%s] execution start", new Object[]{this}));
                try {
                    C7785i.m17284a(C7785i.this);
                } catch (Throwable th) {
                    C7789k.m17288a((Closeable) C7785i.this);
                    throw th;
                }
                C7789k.m17288a((Closeable) C7785i.this);
                IAlog.m18019a(String.format("StreamingHandler[%s] execution finish", new Object[]{this}));
            }
        });
        dVar.f15608h.add(iVar);
    }
}
