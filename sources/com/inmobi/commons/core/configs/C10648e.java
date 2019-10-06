package com.inmobi.commons.core.configs;

import android.os.SystemClock;
import com.inmobi.commons.core.configs.ConfigNetworkResponse.ConfigResponse;
import com.inmobi.commons.core.network.C10678e;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.inmobi.commons.core.configs.e */
/* compiled from: ConfigNetworkClient */
class C10648e implements Runnable {

    /* renamed from: a */
    private static final String f32458a = C10648e.class.getName();

    /* renamed from: b */
    private C10650f f32459b;

    /* renamed from: c */
    private C10649a f32460c;

    /* renamed from: d */
    private final C10650f f32461d;

    /* renamed from: com.inmobi.commons.core.configs.e$a */
    /* compiled from: ConfigNetworkClient */
    public interface C10649a {
        /* renamed from: a */
        void mo34455a();

        /* renamed from: a */
        void mo34456a(ConfigResponse configResponse);
    }

    C10648e(C10649a aVar, C10650f fVar, C10650f fVar2) {
        this.f32460c = aVar;
        this.f32459b = fVar;
        this.f32461d = fVar2;
    }

    /* renamed from: a */
    private boolean m34943a(C10650f fVar, int i, Map<String, ConfigResponse> map) throws InterruptedException {
        if (i > fVar.f32463a) {
            for (Entry key : fVar.f32465c.entrySet()) {
                String str = (String) key.getKey();
                if (map.containsKey(str)) {
                    this.f32460c.mo34456a((ConfigResponse) map.get(str));
                }
            }
            return true;
        }
        Thread.sleep((long) (fVar.f32464b * 1000));
        return false;
    }

    /* renamed from: a */
    private void m34942a(C10650f fVar, Map<String, ConfigResponse> map) {
        for (Entry entry : map.entrySet()) {
            ConfigResponse configResponse = (ConfigResponse) entry.getValue();
            String str = (String) entry.getKey();
            if (!configResponse.mo34448a()) {
                this.f32460c.mo34456a(configResponse);
                fVar.f32465c.remove(str);
            }
        }
    }

    /* renamed from: a */
    private static ConfigNetworkResponse m34941a(C10650f fVar) {
        C10678e eVar = new C10678e(fVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return new ConfigNetworkResponse(fVar.f32465c, eVar.mo34514a(), SystemClock.elapsedRealtime() - elapsedRealtime);
    }

    public void run() {
        Map<String, ConfigResponse> map;
        int i = 0;
        int i2 = 0;
        do {
            try {
                if (i2 > this.f32459b.f32463a) {
                    break;
                }
                ConfigNetworkResponse a = m34941a(this.f32459b);
                map = a.f32432a;
                if (!(a.mo34447a() && this.f32461d != null)) {
                    m34942a(this.f32459b, map);
                    if (this.f32459b.f32465c.isEmpty()) {
                        break;
                    }
                    i2++;
                } else {
                    while (i <= this.f32461d.f32463a) {
                        ConfigNetworkResponse a2 = m34941a(this.f32461d);
                        Map<String, ConfigResponse> map2 = a2.f32432a;
                        if (a2.mo34447a()) {
                            break;
                        }
                        m34942a(this.f32461d, map2);
                        if (this.f32461d.f32465c.isEmpty()) {
                            break;
                        }
                        i++;
                        if (m34943a(this.f32461d, i, map2)) {
                            break;
                        }
                    }
                    this.f32460c.mo34455a();
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        } while (!m34943a(this.f32459b, i2, map));
        this.f32460c.mo34455a();
    }
}
