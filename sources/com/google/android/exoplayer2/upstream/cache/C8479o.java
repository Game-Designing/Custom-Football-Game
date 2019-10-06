package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.Cache.C8463a;
import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.upstream.cache.Cache.Listener;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.google.android.exoplayer2.upstream.cache.o */
/* compiled from: SimpleCache */
public final class C8479o implements Cache {

    /* renamed from: a */
    private static final HashSet<File> f18699a = new HashSet<>();

    /* renamed from: b */
    private static boolean f18700b;

    /* renamed from: c */
    private final File f18701c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C8467c f18702d;

    /* renamed from: e */
    private final C8472h f18703e;

    /* renamed from: f */
    private final HashMap<String, ArrayList<C8463a>> f18704f;

    /* renamed from: g */
    private long f18705g;

    /* renamed from: h */
    private boolean f18706h;

    public C8479o(File cacheDir, C8467c evictor) {
        this(cacheDir, evictor, null, false);
    }

    public C8479o(File cacheDir, C8467c evictor, byte[] secretKey, boolean encrypt) {
        this(cacheDir, evictor, new C8472h(cacheDir, secretKey, encrypt));
    }

    C8479o(File cacheDir, C8467c evictor, C8472h index) {
        if (m20291b(cacheDir)) {
            this.f18701c = cacheDir;
            this.f18702d = evictor;
            this.f18703e = index;
            this.f18704f = new HashMap<>();
            ConditionVariable conditionVariable = new ConditionVariable();
            new C8478n(this, "SimpleCache.initialize()", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Another SimpleCache instance uses the folder: ");
        sb.append(cacheDir);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public synchronized long mo25936a() {
        C8514e.m20490b(!this.f18706h);
        return this.f18705g;
    }

    /* renamed from: c */
    public synchronized C8480p m20308c(String key, long position) throws InterruptedException, CacheException {
        C8480p span;
        while (true) {
            span = mo25944b(key, position);
            if (span == null) {
                wait();
            }
        }
        return span;
    }

    /* renamed from: b */
    public synchronized C8480p m20305b(String key, long position) throws CacheException {
        C8514e.m20490b(!this.f18706h);
        C8480p cacheSpan = m20294d(key, position);
        if (cacheSpan.f18671d) {
            try {
                C8480p newCacheSpan = this.f18703e.mo25982b(key).mo25972b(cacheSpan);
                m20287a(cacheSpan, (C8469e) newCacheSpan);
                return newCacheSpan;
            } catch (CacheException e) {
                return cacheSpan;
            }
        } else {
            C8471g cachedContent = this.f18703e.mo25986d(key);
            if (cachedContent.mo25975d()) {
                return null;
            }
            cachedContent.mo25969a(true);
            return cacheSpan;
        }
    }

    /* renamed from: a */
    public synchronized File mo25938a(String key, long position, long maxLength) throws CacheException {
        C8471g cachedContent;
        C8514e.m20490b(!this.f18706h);
        cachedContent = this.f18703e.mo25982b(key);
        C8514e.m20486a(cachedContent);
        C8514e.m20490b(cachedContent.mo25975d());
        if (!this.f18701c.exists()) {
            this.f18701c.mkdirs();
            m20292c();
        }
        this.f18702d.mo25959a(this, key, position, maxLength);
        return C8480p.m20312a(this.f18701c, cachedContent.f18675a, position, System.currentTimeMillis());
    }

    /* renamed from: a */
    public synchronized void mo25940a(File file) throws CacheException {
        boolean z = true;
        C8514e.m20490b(!this.f18706h);
        C8480p span = C8480p.m20309a(file, this.f18703e);
        C8514e.m20490b(span != null);
        C8471g cachedContent = this.f18703e.mo25982b(span.f18668a);
        C8514e.m20486a(cachedContent);
        C8514e.m20490b(cachedContent.mo25975d());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long length = C8474j.m20257a(cachedContent.mo25965a());
            if (length != -1) {
                if (span.f18669b + span.f18670c > length) {
                    z = false;
                }
                C8514e.m20490b(z);
            }
            m20286a(span);
            this.f18703e.mo25987d();
            notifyAll();
        }
    }

    /* renamed from: a */
    public synchronized void mo25939a(C8469e holeSpan) {
        C8514e.m20490b(!this.f18706h);
        C8471g cachedContent = this.f18703e.mo25982b(holeSpan.f18668a);
        C8514e.m20486a(cachedContent);
        C8514e.m20490b(cachedContent.mo25975d());
        cachedContent.mo25969a(false);
        this.f18703e.mo25988e(cachedContent.f18676b);
        notifyAll();
    }

    /* renamed from: b */
    public synchronized void mo25945b(C8469e span) {
        C8514e.m20490b(!this.f18706h);
        m20295d(span);
    }

    /* renamed from: a */
    public synchronized void mo25941a(String key, long length) throws CacheException {
        C8475k mutations = new C8475k();
        C8474j.m20259a(mutations, length);
        mo25942a(key, mutations);
    }

    /* renamed from: b */
    public synchronized long mo25943b(String key) {
        return C8474j.m20257a(mo25937a(key));
    }

    /* renamed from: a */
    public synchronized void mo25942a(String key, C8475k mutations) throws CacheException {
        C8514e.m20490b(!this.f18706h);
        this.f18703e.mo25981a(key, mutations);
        this.f18703e.mo25987d();
    }

    /* renamed from: a */
    public synchronized C8473i mo25937a(String key) {
        C8514e.m20490b(!this.f18706h);
        return this.f18703e.mo25984c(key);
    }

    /* renamed from: d */
    private C8480p m20294d(String key, long position) throws CacheException {
        C8480p span;
        C8471g cachedContent = this.f18703e.mo25982b(key);
        if (cachedContent == null) {
            return C8480p.m20313b(key, position);
        }
        while (true) {
            span = cachedContent.mo25966a(position);
            if (!span.f18671d || span.f18672e.exists()) {
                return span;
            }
            m20292c();
        }
        return span;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20289b() {
        if (!this.f18701c.exists()) {
            this.f18701c.mkdirs();
            return;
        }
        this.f18703e.mo25983b();
        File[] files = this.f18701c.listFiles();
        if (files != null) {
            int length = files.length;
            for (int i = 0; i < length; i++) {
                File file = files[i];
                if (!file.getName().equals("cached_content_index.exi")) {
                    C8480p span = file.length() > 0 ? C8480p.m20309a(file, this.f18703e) : null;
                    if (span != null) {
                        m20286a(span);
                    } else {
                        file.delete();
                    }
                }
            }
            this.f18703e.mo25985c();
            try {
                this.f18703e.mo25987d();
            } catch (CacheException e) {
                C8526n.m20530a("SimpleCache", "Storing index file failed", e);
            }
        }
    }

    /* renamed from: a */
    private void m20286a(C8480p span) {
        this.f18703e.mo25986d(span.f18668a).mo25967a(span);
        this.f18705g += span.f18670c;
        m20290b(span);
    }

    /* renamed from: d */
    private void m20295d(C8469e span) {
        C8471g cachedContent = this.f18703e.mo25982b(span.f18668a);
        if (cachedContent != null && cachedContent.mo25970a(span)) {
            this.f18705g -= span.f18670c;
            this.f18703e.mo25988e(cachedContent.f18676b);
            m20293c(span);
        }
    }

    /* renamed from: c */
    private void m20292c() {
        ArrayList<CacheSpan> spansToBeRemoved = new ArrayList<>();
        for (C8471g cachedContent : this.f18703e.mo25980a()) {
            Iterator it = cachedContent.mo25973b().iterator();
            while (it.hasNext()) {
                C8469e span = (C8469e) it.next();
                if (!span.f18672e.exists()) {
                    spansToBeRemoved.add(span);
                }
            }
        }
        for (int i = 0; i < spansToBeRemoved.size(); i++) {
            m20295d((C8469e) spansToBeRemoved.get(i));
        }
    }

    /* renamed from: c */
    private void m20293c(C8469e span) {
        ArrayList<Listener> keyListeners = (ArrayList) this.f18704f.get(span.f18668a);
        if (keyListeners != null) {
            for (int i = keyListeners.size() - 1; i >= 0; i--) {
                ((C8463a) keyListeners.get(i)).mo25949b(this, span);
            }
        }
        this.f18702d.mo25949b(this, span);
    }

    /* renamed from: b */
    private void m20290b(C8480p span) {
        ArrayList<Listener> keyListeners = (ArrayList) this.f18704f.get(span.f18668a);
        if (keyListeners != null) {
            for (int i = keyListeners.size() - 1; i >= 0; i--) {
                ((C8463a) keyListeners.get(i)).mo25947a(this, span);
            }
        }
        this.f18702d.mo25947a(this, span);
    }

    /* renamed from: a */
    private void m20287a(C8480p oldSpan, C8469e newSpan) {
        ArrayList<Listener> keyListeners = (ArrayList) this.f18704f.get(oldSpan.f18668a);
        if (keyListeners != null) {
            for (int i = keyListeners.size() - 1; i >= 0; i--) {
                ((C8463a) keyListeners.get(i)).mo25948a(this, oldSpan, newSpan);
            }
        }
        this.f18702d.mo25948a(this, oldSpan, newSpan);
    }

    /* renamed from: b */
    private static synchronized boolean m20291b(File cacheDir) {
        synchronized (C8479o.class) {
            if (f18700b) {
                return true;
            }
            boolean add = f18699a.add(cacheDir.getAbsoluteFile());
            return add;
        }
    }
}
