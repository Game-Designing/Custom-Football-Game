package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.smaato.soma.C12042D;
import com.smaato.soma.C12150c;
import com.smaato.soma.C12307d;
import com.smaato.soma.C12367f;
import com.smaato.soma.C12394h;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class SomaMopubAdapter extends CustomEventBanner {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f36031b;

    /* renamed from: c */
    private C12042D f36032c;

    /* renamed from: c */
    private static /* synthetic */ boolean[] m38370c() {
        boolean[] zArr = f36031b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8202392667895676026L, "com/mopub/nativeads/SomaMopubAdapter", 31);
        f36031b = probes;
        return probes;
    }

    public SomaMopubAdapter() {
        m38370c()[0] = true;
    }

    /* renamed from: a */
    static /* synthetic */ C12042D m38366a(SomaMopubAdapter x0) {
        boolean[] c = m38370c();
        C12042D d = x0.f36032c;
        c[30] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ void m38367a(SomaMopubAdapter x0, String x1, C12143a x2) {
        boolean[] c = m38370c();
        x0.m38368a(x1, x2);
        c[29] = true;
    }

    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        boolean[] c = m38370c();
        try {
            if (this.f36032c != null) {
                c[1] = true;
            } else {
                c[2] = true;
                this.f36032c = new C12042D(context);
                c[3] = true;
                this.f36032c.mo39816a((C12367f) new C11544Ma(this, customEventBannerListener));
                c[4] = true;
                this.f36032c.setBannerStateListener(new C11562Pa(this, customEventBannerListener));
                c[5] = true;
            }
            m38369a(serverExtras, this.f36032c.getAdSettings());
            c[6] = true;
            int adHeight = ((Integer) localExtras.get(DataKeys.AD_HEIGHT)).intValue();
            c[7] = true;
            int adWidth = ((Integer) localExtras.get(DataKeys.AD_WIDTH)).intValue();
            c[8] = true;
            C12150c adDimension = C12307d.m40491a(adHeight, adWidth);
            if (adDimension == null) {
                c[9] = true;
            } else {
                c[10] = true;
                C12394h adSettings = this.f36032c.getAdSettings();
                c[11] = true;
                adSettings.mo39882a(adDimension);
                c[12] = true;
            }
            this.f36032c.mo39256a();
            c[13] = true;
        } catch (RuntimeException e) {
            c[14] = true;
            e.printStackTrace();
            c[15] = true;
            m38368a("Failed to load banner", C12143a.ERROR);
            c[16] = true;
        } catch (Exception e2) {
            c[17] = true;
            e2.printStackTrace();
            c[18] = true;
        }
        c[19] = true;
    }

    public void onInvalidate() {
        boolean[] c = m38370c();
        C12042D d = this.f36032c;
        if (d == null) {
            c[20] = true;
        } else {
            c[21] = true;
            d.mo39225d();
            this.f36032c = null;
            c[22] = true;
        }
        c[23] = true;
    }

    /* renamed from: a */
    private void m38368a(String str, C12143a debugCategory) {
        boolean[] c = m38370c();
        C12146d.m39965a(new C12147e("SomaMopubAdapter", str, 1, debugCategory));
        c[24] = true;
    }

    /* renamed from: a */
    private void m38369a(Map<String, String> serverExtras, C12394h adSettings) {
        boolean[] c = m38370c();
        long publisherId = Long.parseLong((String) serverExtras.get("publisherId"));
        c[25] = true;
        long adSpaceId = Long.parseLong((String) serverExtras.get("adSpaceId"));
        c[26] = true;
        adSettings.mo39886b(publisherId);
        c[27] = true;
        adSettings.mo39881a(adSpaceId);
        c[28] = true;
    }
}
