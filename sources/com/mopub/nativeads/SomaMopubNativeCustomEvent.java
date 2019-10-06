package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.smaato.soma.C12394h;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p244e.C12205a;
import com.smaato.soma.p258g.C12374c;
import com.smaato.soma.p258g.C12389r;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class SomaMopubNativeCustomEvent extends CustomEventNative {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36037a;

    /* renamed from: com.mopub.nativeads.SomaMopubNativeCustomEvent$a */
    static class C11568a extends StaticNativeAd implements C12374c {

        /* renamed from: s */
        private static transient /* synthetic */ boolean[] f36038s;

        /* renamed from: t */
        private final Context f36039t;

        /* renamed from: u */
        private final CustomEventNativeListener f36040u;

        /* renamed from: v */
        private final C12389r f36041v;

        /* renamed from: w */
        private ImpressionTracker f36042w;

        /* renamed from: x */
        private NativeClickHandler f36043x;

        /* renamed from: f */
        private static /* synthetic */ boolean[] m38386f() {
            boolean[] zArr = f36038s;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4738918583791139203L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd", 37);
            f36038s = probes;
            return probes;
        }

        /* renamed from: a */
        static /* synthetic */ Context m38381a(C11568a x0) {
            boolean[] f = m38386f();
            Context context = x0.f36039t;
            f[32] = true;
            return context;
        }

        /* renamed from: b */
        static /* synthetic */ CustomEventNativeListener m38382b(C11568a x0) {
            boolean[] f = m38386f();
            CustomEventNativeListener customEventNativeListener = x0.f36040u;
            f[33] = true;
            return customEventNativeListener;
        }

        /* renamed from: c */
        static /* synthetic */ ImpressionTracker m38383c(C11568a x0) {
            boolean[] f = m38386f();
            ImpressionTracker impressionTracker = x0.f36042w;
            f[34] = true;
            return impressionTracker;
        }

        /* renamed from: d */
        static /* synthetic */ C12389r m38384d(C11568a x0) {
            boolean[] f = m38386f();
            C12389r rVar = x0.f36041v;
            f[35] = true;
            return rVar;
        }

        /* renamed from: e */
        static /* synthetic */ NativeClickHandler m38385e(C11568a x0) {
            boolean[] f = m38386f();
            NativeClickHandler nativeClickHandler = x0.f36043x;
            f[36] = true;
            return nativeClickHandler;
        }

        C11568a(Context context, long publisherId, long adSpaceID, CustomEventNativeListener customEventNativeListener, ImpressionTracker impressionTracker, NativeClickHandler nativeClickHandler) {
            boolean[] f = m38386f();
            f[0] = true;
            this.f36039t = context.getApplicationContext();
            f[1] = true;
            this.f36041v = new C12389r(context.getApplicationContext());
            f[2] = true;
            C12394h c = this.f36041v.mo39871c();
            f[3] = true;
            c.mo39881a(adSpaceID);
            f[4] = true;
            C12394h c2 = this.f36041v.mo39871c();
            f[5] = true;
            c2.mo39886b(publisherId);
            this.f36040u = customEventNativeListener;
            this.f36042w = impressionTracker;
            this.f36043x = nativeClickHandler;
            f[6] = true;
        }

        public void onAdClicked() {
            boolean[] f = m38386f();
            C11592cb cbVar = new C11592cb(this);
            f[7] = true;
            cbVar.execute();
            f[8] = true;
        }

        public void onLoggingImpression() {
            boolean[] f = m38386f();
            C11595db dbVar = new C11595db(this);
            f[9] = true;
            dbVar.execute();
            f[10] = true;
        }

        public void onAdLoaded(C12205a nativeAd) {
            boolean[] f = m38386f();
            C11601fb fbVar = new C11601fb(this, nativeAd);
            f[11] = true;
            fbVar.execute();
            f[12] = true;
        }

        public void onError(C12408ia errorCode, String errorMessage) {
            boolean[] f = m38386f();
            C11604gb gbVar = new C11604gb(this, errorCode);
            f[13] = true;
            gbVar.execute();
            f[14] = true;
        }

        public void prepare(View view) {
            boolean[] f = m38386f();
            C11607hb hbVar = new C11607hb(this, view);
            f[15] = true;
            hbVar.execute();
            f[16] = true;
        }

        public void clear(View view) {
            boolean[] f = m38386f();
            C11610ib ibVar = new C11610ib(this, view);
            f[17] = true;
            ibVar.execute();
            f[18] = true;
        }

        public void destroy() {
            boolean[] f = m38386f();
            C11613jb jbVar = new C11613jb(this);
            f[19] = true;
            jbVar.execute();
            f[20] = true;
        }

        public void recordImpression(View view) {
            boolean[] f = m38386f();
            try {
                mo37750d();
                f[21] = true;
                this.f36041v.mo39860a(view);
                f[22] = true;
            } catch (Exception m) {
                f[23] = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Exception in Adapter Configuration. Please check inputs");
                f[24] = true;
                sb.append(m.getMessage());
                C12147e eVar = new C12147e("SomaMopubNativeCustomEvent", sb.toString(), 1, C12143a.DEBUG);
                f[25] = true;
                C12146d.m39965a(eVar);
                f[26] = true;
            }
            f[27] = true;
        }

        public void handleClick(View view) {
            boolean[] f = m38386f();
            C11616kb kbVar = new C11616kb(this, view);
            f[28] = true;
            kbVar.execute();
            f[29] = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo38091e() {
            boolean[] f = m38386f();
            C11620lb lbVar = new C11620lb(this);
            f[30] = true;
            lbVar.execute();
            f[31] = true;
        }
    }

    /* renamed from: b */
    private static /* synthetic */ boolean[] m38380b() {
        boolean[] zArr = f36037a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2880812311846913514L, "com/mopub/nativeads/SomaMopubNativeCustomEvent", 17);
        f36037a = probes;
        return probes;
    }

    public SomaMopubNativeCustomEvent() {
        m38380b()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> serverExtras) {
        Context context2 = context;
        CustomEventNativeListener customEventNativeListener2 = customEventNativeListener;
        Map<String, String> map2 = serverExtras;
        boolean[] b = m38380b();
        try {
            long parseLong = Long.parseLong((String) map2.get("publisherId"));
            b[1] = true;
            long publisherId = parseLong;
            long parseLong2 = Long.parseLong((String) map2.get("adSpaceId"));
            b[2] = true;
            long adSpaceId = parseLong2;
            try {
                if (m38379a(publisherId, adSpaceId)) {
                    b[3] = true;
                    ImpressionTracker impressionTracker = new ImpressionTracker(context2);
                    long j = adSpaceId;
                    ImpressionTracker impressionTracker2 = impressionTracker;
                    long j2 = publisherId;
                    C11568a aVar = new C11568a(context, publisherId, adSpaceId, customEventNativeListener, impressionTracker2, new NativeClickHandler(context2));
                    b[4] = true;
                    aVar.mo38091e();
                    b[5] = true;
                } else {
                    long j3 = publisherId;
                    customEventNativeListener2.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
                    b[6] = true;
                }
                b[7] = true;
            } catch (Exception e) {
                b[8] = true;
                C12146d.m39965a(new C12147e("SomaMopubNativeCustomEvent", "Exception in Adapter Configuration. Please check inputs", 1, C12143a.DEBUG));
                b[9] = true;
                customEventNativeListener2.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
                b[10] = true;
                b[11] = true;
            }
        } catch (Exception e2) {
            b[8] = true;
            C12146d.m39965a(new C12147e("SomaMopubNativeCustomEvent", "Exception in Adapter Configuration. Please check inputs", 1, C12143a.DEBUG));
            b[9] = true;
            customEventNativeListener2.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
            b[10] = true;
            b[11] = true;
        }
        b[11] = true;
    }

    /* renamed from: a */
    private boolean m38379a(long publisherId, long adSpaceId) {
        boolean z;
        boolean[] b = m38380b();
        if (publisherId <= -1) {
            b[12] = true;
        } else if (adSpaceId <= -1) {
            b[13] = true;
        } else {
            b[14] = true;
            z = true;
            b[16] = true;
            return z;
        }
        z = false;
        b[15] = true;
        b[16] = true;
        return z;
    }
}
