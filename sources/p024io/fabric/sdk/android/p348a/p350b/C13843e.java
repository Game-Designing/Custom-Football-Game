package p024io.fabric.sdk.android.p348a.p350b;

import android.content.Context;
import com.mopub.common.GpsHelper;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: io.fabric.sdk.android.a.b.e */
/* compiled from: AdvertisingInfoReflectionStrategy */
class C13843e implements C13848h {

    /* renamed from: a */
    private final Context f42022a;

    public C13843e(Context context) {
        this.f42022a = context.getApplicationContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo43229a(Context context) {
        boolean z = false;
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public C13840b mo43228a() {
        if (mo43229a(this.f42022a)) {
            return new C13840b(m44001b(), m44003d());
        }
        return null;
    }

    /* renamed from: b */
    private String m44001b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m44002c(), new Object[0]);
        } catch (Exception e) {
            C13920f.m44245e().mo43321a("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* renamed from: d */
    private boolean m44003d() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod(GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, new Class[0]).invoke(m44002c(), new Object[0])).booleanValue();
        } catch (Exception e) {
            C13920f.m44245e().mo43321a("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* renamed from: c */
    private Object m44002c() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f42022a});
        } catch (Exception e) {
            C13920f.m44245e().mo43321a("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }
}
