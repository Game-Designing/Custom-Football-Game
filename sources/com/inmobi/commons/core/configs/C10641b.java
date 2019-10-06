package com.inmobi.commons.core.configs;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.C10648e.C10649a;
import com.inmobi.commons.core.configs.C10652h.C10654b;
import com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse;
import com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse.ConfigResponseStatus;
import com.inmobi.commons.core.p221d.C10657c;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.core.utilities.uid.C10711d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* renamed from: com.inmobi.commons.core.configs.b */
/* compiled from: ConfigComponent */
public class C10641b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f32443a = C10641b.class.getSimpleName();

    /* renamed from: b */
    private static Map<C10639a, ArrayList<WeakReference<C10644c>>> f32444b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static C10652h f32445c;

    /* renamed from: d */
    private static C10645d f32446d;

    /* renamed from: e */
    private HandlerThread f32447e;

    /* renamed from: f */
    private C10643b f32448f;

    /* renamed from: g */
    private boolean f32449g;

    /* renamed from: com.inmobi.commons.core.configs.b$a */
    /* compiled from: ConfigComponent */
    private static class C10642a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C10641b f32450a = new C10641b(0);
    }

    /* renamed from: com.inmobi.commons.core.configs.b$b */
    /* compiled from: ConfigComponent */
    static final class C10643b extends Handler implements C10649a {

        /* renamed from: a */
        private List<C10639a> f32451a = new ArrayList();

        /* renamed from: b */
        private Map<String, Map<String, C10639a>> f32452b = new HashMap();

        /* renamed from: c */
        private Map<String, C10639a> f32453c = new HashMap();

        /* renamed from: d */
        private ExecutorService f32454d;

        C10643b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i;
            C10650f fVar;
            Message message2 = message;
            int i2 = message2.what;
            if (i2 == 1) {
                C10639a aVar = (C10639a) message2.obj;
                C10641b.f32443a;
                StringBuilder sb = new StringBuilder("Fetch requested for config:");
                sb.append(aVar.mo33671a());
                sb.append(". IsAlreadyScheduled:");
                sb.append(m34932a(aVar.mo33671a()));
                if (!m34932a(aVar.mo33671a())) {
                    this.f32451a.add(aVar);
                    if (!hasMessages(2)) {
                        sendEmptyMessage(2);
                    }
                } else {
                    C10641b.f32443a;
                    new StringBuilder("Config fetching already in progress:").append(aVar.mo33671a());
                }
            } else if (i2 == 2) {
                sendEmptyMessageDelayed(3, (long) (C10641b.f32445c.f32473c * 1000));
            } else if (i2 == 3) {
                m34931a(this.f32451a);
                this.f32451a.clear();
                ExecutorService executorService = this.f32454d;
                if (executorService == null || executorService.isShutdown()) {
                    this.f32454d = Executors.newFixedThreadPool(1);
                    sendEmptyMessage(4);
                }
            } else if (i2 != 4) {
                if (i2 == 5) {
                    ExecutorService executorService2 = this.f32454d;
                    if (executorService2 != null && !executorService2.isShutdown()) {
                        this.f32453c = null;
                        this.f32452b.clear();
                        removeMessages(3);
                        this.f32454d.shutdownNow();
                    }
                }
            } else if (!this.f32452b.isEmpty()) {
                Entry entry = (Entry) this.f32452b.entrySet().iterator().next();
                this.f32453c = (Map) entry.getValue();
                this.f32452b.remove(entry.getKey());
                String str = (String) entry.getKey();
                Map<String, C10639a> map = this.f32453c;
                int i3 = C10641b.f32445c.f32472b;
                int i4 = C10641b.f32445c.f32471a;
                C10711d dVar = new C10711d(C10641b.f32445c.f32441p.f32442a);
                int d = C10694e.m35114d();
                String str2 = "root";
                if (d != 0 || !map.containsKey(str2)) {
                    i = d;
                } else {
                    map = C10641b.m34917a((Map) map);
                    i = 1;
                }
                C10650f fVar2 = new C10650f(map, dVar, str, i4, i3, i);
                if (map.containsKey(str2)) {
                    fVar = new C10650f(C10641b.m34917a((Map) map), dVar, C10641b.f32445c.mo34465e(), i4, i3, true, i);
                } else {
                    fVar = null;
                }
                this.f32454d.execute(new C10648e(this, fVar2, fVar));
            } else {
                C10641b.f32443a;
                sendEmptyMessage(5);
            }
        }

        /* renamed from: a */
        private boolean m34932a(String str) {
            boolean z;
            if (this.f32452b.get(C10641b.f32445c.mo34464b(str)) == null || !((Map) this.f32452b.get(C10641b.f32445c.mo34464b(str))).containsKey(str)) {
                z = false;
            } else {
                z = true;
            }
            Map<String, C10639a> map = this.f32453c;
            if (map == null || !map.containsKey(str)) {
                return z;
            }
            return true;
        }

        /* renamed from: a */
        private void m34931a(List<C10639a> list) {
            for (int i = 0; i < list.size(); i++) {
                C10639a aVar = (C10639a) list.get(i);
                HashMap hashMap = (HashMap) this.f32452b.get(C10641b.f32445c.mo34464b(aVar.mo33671a()));
                if (hashMap == null) {
                    hashMap = new HashMap();
                    this.f32452b.put(C10641b.f32445c.mo34464b(aVar.mo33671a()), hashMap);
                }
                hashMap.put(aVar.mo33671a(), aVar);
            }
        }

        /* renamed from: a */
        public final void mo34456a(ConfigResponse configResponse) {
            String str = "Config cached successfully:";
            C10646c cVar = new C10646c();
            if (configResponse.mo34448a()) {
                C10641b.f32443a;
                StringBuilder sb = new StringBuilder("Config fetching failed:");
                sb.append(configResponse.f32438b.mo33671a());
                sb.append(", Error code:");
                sb.append(configResponse.f32439c.f32456a);
            } else if (configResponse.f32437a == ConfigResponseStatus.NOT_MODIFIED) {
                C10641b.f32443a;
                new StringBuilder("Config not modified status from server:").append(configResponse.f32438b.mo33671a());
                cVar.mo34459a(configResponse.f32438b.mo33671a(), System.currentTimeMillis());
            } else {
                C10639a aVar = configResponse.f32438b;
                try {
                    C10657c cVar2 = cVar.f32455a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aVar.mo33671a());
                    sb2.append("_config");
                    cVar2.mo34479a(sb2.toString(), aVar.mo33673b().toString());
                    cVar.mo34459a(aVar.mo33671a(), System.currentTimeMillis());
                } catch (JSONException e) {
                }
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("configName", configResponse.f32438b.mo33671a());
                    hashMap.put("latency", "2147483647");
                    C10659b.m34983a();
                    C10659b.m34987a("root", "ConfigFetched", hashMap);
                } catch (Exception e2) {
                    C10641b.f32443a;
                    StringBuilder sb3 = new StringBuilder("Error in submitting telemetry event : (");
                    sb3.append(e2.getMessage());
                    sb3.append(")");
                }
                try {
                    C10641b.f32443a;
                    new StringBuilder(str).append(configResponse.f32438b.mo33671a());
                    C10641b.f32443a;
                    new StringBuilder(str).append(configResponse.f32438b.mo33673b().toString());
                    C10641b.m34921b(configResponse.f32438b);
                } catch (JSONException e3) {
                }
            }
        }

        /* renamed from: a */
        public final void mo34455a() {
            sendEmptyMessage(4);
        }
    }

    /* renamed from: com.inmobi.commons.core.configs.b$c */
    /* compiled from: ConfigComponent */
    public interface C10644c {
        /* renamed from: a */
        void mo33666a(C10639a aVar);
    }

    /* renamed from: com.inmobi.commons.core.configs.b$d */
    /* compiled from: ConfigComponent */
    static class C10645d implements C10644c {
        C10645d() {
        }

        /* renamed from: a */
        public final void mo33666a(C10639a aVar) {
            C10641b.f32445c = (C10652h) aVar;
        }
    }

    /* synthetic */ C10641b(byte b) {
        this();
    }

    /* renamed from: a */
    public static C10641b m34915a() {
        return C10642a.f32450a;
    }

    private C10641b() {
        this.f32449g = false;
        f32444b = new HashMap();
        this.f32447e = new HandlerThread("ConfigBootstrapHandler");
        this.f32447e.start();
        this.f32448f = new C10643b(this.f32447e.getLooper());
        f32445c = new C10652h();
    }

    /* renamed from: b */
    public final synchronized void mo34453b() {
        if (!this.f32449g) {
            this.f32449g = true;
            C10659b.m34983a().mo34486a("root", f32445c.f32476f);
            if (f32446d == null) {
                f32446d = new C10645d();
                mo34452a((C10639a) f32445c, (C10644c) f32446d);
            }
            for (Entry key : f32444b.entrySet()) {
                C10639a aVar = (C10639a) key.getKey();
                m34922c(aVar);
                m34921b(aVar);
            }
        }
    }

    /* renamed from: c */
    public final synchronized void mo34454c() {
        if (this.f32449g) {
            this.f32449g = false;
            this.f32448f.sendEmptyMessage(5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m34921b(C10639a aVar) {
        ArrayList arrayList = (ArrayList) f32444b.get(aVar);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (!(arrayList.get(i) == null || ((WeakReference) arrayList.get(i)).get() == null)) {
                    ((C10644c) ((WeakReference) arrayList.get(i)).get()).mo33666a(aVar);
                }
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo34452a(C10639a aVar, C10644c cVar) {
        if (!this.f32449g) {
            new StringBuilder("Config component not yet started, config can't be fetched. Requested type:").append(aVar.mo33671a());
            return;
        }
        ArrayList arrayList = (ArrayList) f32444b.get(aVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(cVar == null ? null : new WeakReference(cVar));
        f32444b.put(aVar, arrayList);
        m34922c(aVar);
    }

    /* renamed from: d */
    public static void m34923d() {
        C10654b bVar = f32445c.f32475e;
        String str = bVar.f32484a;
        String str2 = bVar.f32485b;
        if (str.trim().length() != 0) {
            if (m34920a("7.2.7", str.trim())) {
                InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                String str3 = f32443a;
                StringBuilder sb = new StringBuilder("A newer version (version ");
                sb.append(str);
                sb.append(") of the InMobi SDK is available! You are currently on an older version (Version 7.2.7). Please download the latest InMobi SDK from ");
                sb.append(str2);
                Logger.m35065a(internalLogLevel, str3, sb.toString());
            }
        }
    }

    /* renamed from: c */
    private synchronized void m34922c(C10639a aVar) {
        C10646c cVar = new C10646c();
        if (!cVar.mo34460a("root")) {
            new StringBuilder("RootConfig not available. Fetching root and returning defaults for config type:").append(aVar.mo33671a());
            m34924d(new C10652h());
            return;
        }
        cVar.mo34458a((C10639a) f32445c);
        if (m34919a(cVar.mo34461b("root"), f32445c.mo34463a("root"))) {
            m34924d(new C10652h());
        }
        if (!cVar.mo34460a(aVar.mo33671a())) {
            new StringBuilder("Requested config not present. Returning default and fetching. Config type:").append(aVar.mo33671a());
            m34924d(aVar.mo33675d());
            return;
        }
        cVar.mo34458a(aVar);
        if (m34919a(cVar.mo34461b(aVar.mo33671a()), f32445c.mo34463a(aVar.mo33671a()))) {
            new StringBuilder("Requested config expired. Returning currently cached and fetching. Config type:").append(aVar.mo33671a());
            m34924d(aVar.mo33675d());
            return;
        }
        new StringBuilder("Serving config from cache. Config:").append(aVar.mo33671a());
    }

    /* renamed from: a */
    private static boolean m34919a(long j, long j2) {
        return System.currentTimeMillis() - j > j2 * 1000;
    }

    /* renamed from: d */
    private void m34924d(C10639a aVar) {
        Message obtainMessage = this.f32448f.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = aVar;
        this.f32448f.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private static boolean m34920a(String str, String str2) {
        String str3 = "\\.";
        String[] split = str.split(str3);
        String[] split2 = str2.split(str3);
        try {
            for (String valueOf : split) {
                if (Integer.valueOf(valueOf).intValue() < 0) {
                    return false;
                }
            }
            for (String valueOf2 : split2) {
                if (Integer.valueOf(valueOf2).intValue() < 0) {
                    return false;
                }
            }
            int length = split.length < split2.length ? split.length : split2.length;
            int i = 0;
            while (i < length) {
                if (split[i].equals(split2[i])) {
                    i++;
                } else if (Integer.valueOf(split[i]).intValue() < Integer.valueOf(split2[i]).intValue()) {
                    return true;
                } else {
                    return false;
                }
            }
            if (split.length < split2.length) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ Map m34917a(Map map) {
        HashMap hashMap = new HashMap(1);
        String str = "root";
        hashMap.put(str, map.get(str));
        return hashMap;
    }
}
