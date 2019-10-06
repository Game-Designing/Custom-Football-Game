package com.fyber.inneractive.sdk.p166g.p167a;

import android.content.Context;
import android.os.Environment;
import com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7765c;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.fyber.inneractive.sdk.g.a.l */
public final class C7790l implements C7765c {

    /* renamed from: g */
    private static final C7790l f15669g = new C7790l();

    /* renamed from: a */
    public Context f15670a;

    /* renamed from: b */
    public C7759c f15671b;

    /* renamed from: c */
    public Thread f15672c;

    /* renamed from: d */
    public List<String> f15673d = new CopyOnWriteArrayList();

    /* renamed from: e */
    public Runnable f15674e = new Runnable() {
        public final void run() {
            File a = C7790l.m17293a(C7790l.this);
            if (a != null) {
                try {
                    IAlog.m18021b(String.format("VideoCache opening the cache in directory - %s", new Object[]{a}));
                    C7790l.this.f15671b = C7759c.m17224a(a);
                    C7790l.this.f15671b.mo24371d();
                    C7790l.this.f15671b = C7759c.m17224a(a);
                    IAlog.m18021b(String.format("VideoCache opened the cache in directory - %s current size is %d", new Object[]{a, Long.valueOf(C7790l.this.f15671b.mo24364a())}));
                    C7790l.this.f15671b.f15568c = C7790l.this;
                    C7790l.this.f15675f = true;
                    C7790l.this.f15672c = null;
                } catch (Throwable th) {
                    IAlog.m18020a("Failed to open cache directory", th);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f15675f = false;

    /* renamed from: a */
    public static C7790l m17292a() {
        return f15669g;
    }

    private C7790l() {
    }

    /* renamed from: a */
    private static boolean m17295a(File file) {
        return file != null && file.getFreeSpace() > 31457280;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r0 != false) goto L_0x0032;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo24413b() {
        /*
            r4 = this;
            boolean r0 = r4.f15675f
            if (r0 == 0) goto L_0x0033
            com.fyber.inneractive.sdk.g.a.d r0 = com.fyber.inneractive.sdk.p166g.p167a.C7767d.m17260a()
            boolean r0 = r0.f15605e
            if (r0 == 0) goto L_0x0033
            boolean r0 = com.fyber.inneractive.sdk.util.C8016n.m18093a()
            r1 = 1
            if (r0 != 0) goto L_0x0032
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r0 < r2) goto L_0x002f
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x002a
            java.lang.String r2 = "127.0.0.1"
            boolean r0 = r0.isCleartextTrafficPermitted(r2)
            goto L_0x0030
        L_0x002a:
            boolean r0 = r0.isCleartextTrafficPermitted()
            goto L_0x0030
        L_0x002f:
            r0 = 1
        L_0x0030:
            if (r0 == 0) goto L_0x0033
        L_0x0032:
            return r1
        L_0x0033:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7790l.mo24413b():boolean");
    }

    /* renamed from: a */
    public static String m17294a(C7756a aVar) {
        C7767d a = C7767d.m17260a();
        if (!a.f15605e || !aVar.f15552a.exists()) {
            return null;
        }
        a.f15606f.add(aVar);
        String name = aVar.mo24359a().getName();
        if (name.contains(".")) {
            name = name.split("[.]{1}")[0];
        }
        return String.format("http://%s:%d/%s?_t=%d", new Object[]{"127.0.0.1", Integer.valueOf(a.f15603c), name, Long.valueOf(System.currentTimeMillis())});
    }

    /* renamed from: b */
    public final void mo24412b(String str) {
        C7756a aVar;
        C7767d a = C7767d.m17260a();
        Iterator it = a.f15606f.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = (C7756a) it.next();
            if (aVar.f15558g.equalsIgnoreCase(str)) {
                break;
            }
        }
        if (aVar != null) {
            a.f15606f.remove(aVar);
        }
        this.f15673d.remove(str);
    }

    /* renamed from: a */
    public final boolean mo24385a(String str) {
        for (String equalsIgnoreCase : this.f15673d) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return false;
            }
        }
        for (C7756a a : C7767d.m17260a().f15606f) {
            if (a.mo24359a().getName().contains(str)) {
                IAlog.m18019a(String.format("MediaCacheStreamer found %s which is in use, rejecting eviction", new Object[]{str}));
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ File m17293a(C7790l lVar) {
        boolean z;
        String str = "fyb.vamp.vid.cache";
        if (C8006j.m18075n() != null && C8006j.m18073b("android.permission.WRITE_EXTERNAL_STORAGE")) {
            String str2 = "mounted";
            boolean z2 = true;
            if (str2.equals(Environment.getExternalStorageState())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String externalStorageState = Environment.getExternalStorageState();
                if (!str2.equals(externalStorageState) && !"mounted_ro".equals(externalStorageState)) {
                    z2 = false;
                }
                if (z2 && m17295a(lVar.f15670a.getExternalCacheDir())) {
                    return new File(lVar.f15670a.getExternalCacheDir(), str);
                }
            }
        }
        if (m17295a(lVar.f15670a.getCacheDir())) {
            return new File(lVar.f15670a.getCacheDir(), str);
        }
        return null;
    }
}
