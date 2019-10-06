package com.inmobi.p207a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10678e;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.p222e.C10669f;
import com.inmobi.commons.core.utilities.p225b.C10698h;
import com.inmobi.p207a.C10301p.C10303b;
import com.inmobi.p207a.p209b.C10282b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.inmobi.a.h */
/* compiled from: IceCollector */
class C10289h {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f31175b = C10289h.class.getSimpleName();

    /* renamed from: a */
    C10290a f31176a;

    /* renamed from: com.inmobi.a.h$a */
    /* compiled from: IceCollector */
    static class C10290a extends Handler {

        /* renamed from: a */
        private List<C10295l> f31177a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f31178b;

        C10290a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            boolean z = true;
            if (i == 1) {
                C10289h.f31175b;
                sendEmptyMessage(3);
            } else if (i == 2) {
                C10289h.f31175b;
                removeMessages(3);
                sendEmptyMessage(4);
            } else if (i != 3) {
                if (i == 4) {
                    C10294k kVar = new C10294k();
                    kVar.f31186a = C10296m.m33551a().mo33655d();
                    kVar.f31188c = this.f31177a;
                    C10299n.m33566a();
                    kVar.f31187b = C10299n.m33567b();
                    C10303b bVar = C10300o.m33571a().f31217a.f31222a;
                    C10293j jVar = new C10293j(bVar.f31237e, bVar.f31238f, bVar.f31239g, C10300o.m33571a().mo33669d(), kVar);
                    new Thread(new Runnable() {
                        public final void run() {
                            int i = 0;
                            while (i <= C10291i.this.f31180b.f31183a) {
                                C10291i.f31179a;
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C10677d a = new C10678e(C10291i.this.f31180b).mo34514a();
                                try {
                                    C10299n.m33566a().mo33663a(C10291i.this.f31180b.mo34509g());
                                    C10299n.m33566a().mo33664b(a.mo34513c());
                                    C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
                                } catch (Exception e) {
                                    C10291i.f31179a;
                                    new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
                                }
                                String str = ")";
                                String str2 = "Error in submitting telemetry event : (";
                                String str3 = "signals";
                                if (a.mo34510a()) {
                                    C10291i.f31179a;
                                    i++;
                                    if (i > C10291i.this.f31180b.f31183a) {
                                        try {
                                            C10659b.m34983a().mo34485a(new C10669f(str3, "RetryCountExceeded"));
                                            return;
                                        } catch (Exception e2) {
                                            C10291i.f31179a;
                                            StringBuilder sb = new StringBuilder(str2);
                                            sb.append(e2.getMessage());
                                            sb.append(str);
                                            return;
                                        }
                                    } else {
                                        try {
                                            Thread.sleep((long) (C10291i.this.f31180b.f31184b * 1000));
                                        } catch (InterruptedException e3) {
                                            C10291i.f31179a;
                                        }
                                    }
                                } else {
                                    C10291i.f31179a;
                                    try {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("url", C10291i.this.f31180b.f32579q);
                                        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - 0));
                                        hashMap.put("payloadSize", Long.valueOf(C10291i.this.f31180b.mo34509g() + a.mo34513c()));
                                        C10659b.m34983a();
                                        C10659b.m34987a(str3, "NICElatency", hashMap);
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("sessionId", C10698h.m35136a().f32651a);
                                        C10299n a2 = C10299n.m33566a();
                                        hashMap2.put("totalWifiSentBytes", Long.valueOf(a2.f31208a));
                                        hashMap2.put("totalWifiReceivedBytes", Long.valueOf(a2.f31209b));
                                        hashMap2.put("totalCarrierSentBytes", Long.valueOf(a2.f31210c));
                                        hashMap2.put("totalCarrierReceivedBytes", Long.valueOf(a2.f31211d));
                                        hashMap2.put("totalNetworkTime", Long.valueOf(a2.f31212e));
                                        C10659b.m34983a();
                                        C10659b.m34987a(str3, "SDKNetworkStats", hashMap2);
                                        return;
                                    } catch (Exception e4) {
                                        C10291i.f31179a;
                                        StringBuilder sb2 = new StringBuilder(str2);
                                        sb2.append(e4.getMessage());
                                        sb2.append(str);
                                        return;
                                    }
                                }
                            }
                        }
                    }).start();
                    this.f31177a = new ArrayList();
                }
            } else {
                C10289h.f31175b;
                if (this.f31178b) {
                    sendEmptyMessage(2);
                    return;
                }
                C10295l lVar = new C10295l();
                lVar.f31191a = C10282b.m33530a();
                lVar.f31193c = C10296m.m33551a().mo33656e();
                if (this.f31177a != null) {
                    if (lVar.f31191a == null && lVar.f31192b == null) {
                        z = false;
                    }
                    if (z) {
                        this.f31177a.add(lVar);
                        if (this.f31177a.size() > C10300o.m33571a().f31217a.f31222a.f31236d) {
                            try {
                                C10659b.m34983a().mo34485a(new C10669f("signals", "SampleSizeExceeded"));
                            } catch (Exception e) {
                                C10289h.f31175b;
                                StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                                sb.append(e.getMessage());
                                sb.append(")");
                            }
                            while (this.f31177a.size() > C10300o.m33571a().f31217a.f31222a.f31236d) {
                                this.f31177a.remove(0);
                            }
                        }
                    }
                }
                sendEmptyMessageDelayed(3, (long) (C10300o.m33571a().f31217a.f31222a.f31234b * 1000));
            }
        }
    }

    C10289h() {
        HandlerThread handlerThread = new HandlerThread("DataCollectionHandler");
        handlerThread.start();
        this.f31176a = new C10290a(handlerThread.getLooper());
    }

    /* renamed from: a */
    public final synchronized void mo33650a() {
        this.f31176a.f31178b = false;
        if (!this.f31176a.hasMessages(3)) {
            this.f31176a.removeMessages(2);
            this.f31176a.sendEmptyMessage(1);
        }
    }
}
