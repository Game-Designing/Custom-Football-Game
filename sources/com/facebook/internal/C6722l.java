package com.facebook.internal;

import android.content.Intent;
import com.facebook.C6666i;
import com.facebook.C6787r;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.internal.l */
/* compiled from: CallbackManagerImpl */
public final class C6722l implements C6666i {

    /* renamed from: a */
    private static final String f12280a = C6722l.class.getSimpleName();

    /* renamed from: b */
    private static Map<Integer, C6723a> f12281b = new HashMap();

    /* renamed from: c */
    private Map<Integer, C6723a> f12282c = new HashMap();

    /* renamed from: com.facebook.internal.l$a */
    /* compiled from: CallbackManagerImpl */
    public interface C6723a {
        /* renamed from: a */
        boolean mo19965a(int i, Intent intent);
    }

    /* renamed from: com.facebook.internal.l$b */
    /* compiled from: CallbackManagerImpl */
    public enum C6724b {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        

        /* renamed from: k */
        private final int f12293k;

        private C6724b(int offset) {
            this.f12293k = offset;
        }

        /* renamed from: e */
        public int mo19966e() {
            return C6787r.m13819i() + this.f12293k;
        }
    }

    /* renamed from: b */
    public static synchronized void m13545b(int requestCode, C6723a callback) {
        synchronized (C6722l.class) {
            C6697T.m13461a((Object) callback, "callback");
            if (!f12281b.containsKey(Integer.valueOf(requestCode))) {
                f12281b.put(Integer.valueOf(requestCode), callback);
            }
        }
    }

    /* renamed from: a */
    private static synchronized C6723a m13543a(Integer requestCode) {
        C6723a aVar;
        synchronized (C6722l.class) {
            aVar = (C6723a) f12281b.get(requestCode);
        }
        return aVar;
    }

    /* renamed from: a */
    private static boolean m13544a(int requestCode, int resultCode, Intent data) {
        C6723a callback = m13543a(Integer.valueOf(requestCode));
        if (callback != null) {
            return callback.mo19965a(resultCode, data);
        }
        return false;
    }

    /* renamed from: a */
    public void mo19964a(int requestCode, C6723a callback) {
        C6697T.m13461a((Object) callback, "callback");
        this.f12282c.put(Integer.valueOf(requestCode), callback);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        C6723a callback = (C6723a) this.f12282c.get(Integer.valueOf(requestCode));
        if (callback != null) {
            return callback.mo19965a(resultCode, data);
        }
        return m13544a(requestCode, resultCode, data);
    }
}
