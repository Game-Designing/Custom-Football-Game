package p019d.p273h.p276c;

import android.app.Activity;
import com.mopub.common.AdType;
import p019d.p273h.p276c.p282f.C12872g;
import p019d.p273h.p276c.p282f.C12874h;

/* renamed from: d.h.c.D */
/* compiled from: IronSource */
public abstract class C12741D {

    /* renamed from: d.h.c.D$a */
    /* compiled from: IronSource */
    public enum C12742a {
        REWARDED_VIDEO("rewardedVideo"),
        INTERSTITIAL(AdType.INTERSTITIAL),
        OFFERWALL("offerwall"),
        BANNER("banner");
        

        /* renamed from: f */
        private String f39080f;

        private C12742a(String value) {
            this.f39080f = value;
        }

        public String toString() {
            return this.f39080f;
        }
    }

    /* renamed from: a */
    public static void m41152a(Activity activity, String appKey) {
        m41153a(activity, appKey, null);
    }

    /* renamed from: a */
    public static void m41153a(Activity activity, String appKey, C12742a... adUnits) {
        C12747I.m41186g().mo41206a(activity, appKey, false, adUnits);
    }

    /* renamed from: b */
    public static void m41160b(Activity activity, String appKey, C12742a... adUnits) {
        C12747I.m41186g().mo41207a(activity, appKey, adUnits);
    }

    /* renamed from: b */
    public static void m41159b(Activity activity) {
        C12747I.m41186g().mo41218b(activity);
    }

    /* renamed from: a */
    public static void m41151a(Activity activity) {
        C12747I.m41186g().mo41205a(activity);
    }

    /* renamed from: d */
    public static void m41164d(String mediationType) {
        C12747I.m41186g().mo41231g(mediationType);
    }

    /* renamed from: f */
    public static void m41166f(String instanceId) {
        C12747I.m41186g().mo41235i(instanceId);
    }

    /* renamed from: b */
    public static void m41161b(String instanceId, String placementName) {
        C12747I.m41186g().mo41220b(instanceId, placementName);
    }

    /* renamed from: b */
    public static boolean m41162b(String instanceId) {
        return C12747I.m41186g().mo41226d(instanceId);
    }

    /* renamed from: a */
    public static void m41155a(C12874h listener) {
        C12747I.m41186g().mo41211a(listener);
    }

    /* renamed from: c */
    public static void m41163c(String instanceId) {
        C12747I.m41186g().mo41228e(instanceId);
    }

    /* renamed from: e */
    public static void m41165e(String instanceId) {
        C12747I.m41186g().mo41233h(instanceId);
    }

    /* renamed from: a */
    public static void m41156a(String instanceId, String placementName) {
        C12747I.m41186g().mo41213a(instanceId, placementName);
    }

    /* renamed from: a */
    public static boolean m41158a(String instanceId) {
        return C12747I.m41186g().mo41223c(instanceId);
    }

    /* renamed from: a */
    public static void m41154a(C12872g listener) {
        C12747I.m41186g().mo41210a(listener);
    }

    /* renamed from: a */
    public static void m41157a(boolean consent) {
        C12747I.m41186g().mo41215a(consent);
    }
}
