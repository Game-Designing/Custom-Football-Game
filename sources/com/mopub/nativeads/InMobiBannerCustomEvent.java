package com.mopub.nativeads;

import com.inmobi.ads.InMobiBanner;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class InMobiBannerCustomEvent extends CustomEventBanner {

    /* renamed from: b */
    private static final String f35691b = InMobiBannerCustomEvent.class.getSimpleName();

    /* renamed from: c */
    private static boolean f35692c = false;

    /* renamed from: d */
    private static transient /* synthetic */ boolean[] f35693d;

    /* renamed from: e */
    private final C11535a f35694e = new C11535a(this, 320, 50);

    /* renamed from: f */
    private final C11535a f35695f;

    /* renamed from: g */
    private final C11535a f35696g;

    /* renamed from: h */
    private CustomEventBannerListener f35697h;

    /* renamed from: i */
    private String f35698i;

    /* renamed from: j */
    private long f35699j;

    /* renamed from: k */
    private int f35700k;

    /* renamed from: l */
    private int f35701l;

    /* renamed from: m */
    private InMobiBanner f35702m;

    /* renamed from: com.mopub.nativeads.InMobiBannerCustomEvent$a */
    private class C11535a {

        /* renamed from: a */
        private static transient /* synthetic */ boolean[] f35703a;

        /* renamed from: b */
        private int f35704b;

        /* renamed from: c */
        private int f35705c;

        /* renamed from: d */
        final /* synthetic */ InMobiBannerCustomEvent f35706d;

        /* renamed from: a */
        private static /* synthetic */ boolean[] m38159a() {
            boolean[] zArr = f35703a;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7198457464951894697L, "com/mopub/nativeads/InMobiBannerCustomEvent$AdSize", 3);
            f35703a = probes;
            return probes;
        }

        public C11535a(InMobiBannerCustomEvent inMobiBannerCustomEvent, int var1, int var2) {
            boolean[] a = m38159a();
            this.f35706d = inMobiBannerCustomEvent;
            this.f35704b = var1;
            this.f35705c = var2;
            a[0] = true;
        }

        public int getHeight() {
            boolean[] a = m38159a();
            int i = this.f35705c;
            a[1] = true;
            return i;
        }

        public int getWidth() {
            boolean[] a = m38159a();
            int i = this.f35704b;
            a[2] = true;
            return i;
        }
    }

    /* renamed from: d */
    private static /* synthetic */ boolean[] m38158d() {
        boolean[] zArr = f35693d;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1247840755633586204L, "com/mopub/nativeads/InMobiBannerCustomEvent", 63);
        f35693d = probes;
        return probes;
    }

    public InMobiBannerCustomEvent() {
        boolean[] d = m38158d();
        d[0] = true;
        d[1] = true;
        this.f35695f = new C11535a(this, 300, 250);
        d[2] = true;
        this.f35696g = new C11535a(this, 728, 90);
        this.f35698i = "";
        this.f35699j = -1;
        this.f35700k = 0;
        this.f35701l = 0;
        d[3] = true;
    }

    /* renamed from: a */
    static /* synthetic */ CustomEventBannerListener m38155a(InMobiBannerCustomEvent x0) {
        boolean[] d = m38158d();
        CustomEventBannerListener customEventBannerListener = x0.f35697h;
        d[61] = true;
        return customEventBannerListener;
    }

    /* renamed from: c */
    static /* synthetic */ String m38157c() {
        boolean[] d = m38158d();
        String str = f35691b;
        d[60] = true;
        return str;
    }

    static {
        boolean[] d = m38158d();
        d[62] = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadBanner(android.content.Context r18, com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener r19, java.util.Map<java.lang.String, java.lang.Object> r20, java.util.Map<java.lang.String, java.lang.String> r21) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            boolean[] r3 = m38158d()
            r4 = r19
            r1.f35697h = r4
            r5 = 1
            r0 = 4
            r3[r0] = r5
            com.inmobi.sdk.InMobiSdk$LogLevel r0 = com.inmobi.sdk.InMobiSdk.LogLevel.DEBUG
            com.inmobi.sdk.InMobiSdk.setLogLevel(r0)
            r0 = 5
            r3[r0] = r5     // Catch:{ JSONException -> 0x007e }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
            r6 = r21
            r0.<init>(r6)     // Catch:{ JSONException -> 0x007a }
            r7 = 6
            r3[r7] = r5     // Catch:{ JSONException -> 0x007a }
            java.lang.String r7 = "accountid"
            java.lang.String r7 = r0.getString(r7)     // Catch:{ JSONException -> 0x007a }
            r1.f35698i = r7     // Catch:{ JSONException -> 0x007a }
            r7 = 7
            r3[r7] = r5     // Catch:{ JSONException -> 0x007a }
            java.lang.String r7 = "placementid"
            long r7 = r0.getLong(r7)     // Catch:{ JSONException -> 0x007a }
            r1.f35699j = r7     // Catch:{ JSONException -> 0x007a }
            r7 = 8
            r3[r7] = r5     // Catch:{ JSONException -> 0x007a }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007a }
            r8 = r20
            r7.<init>(r8)     // Catch:{ JSONException -> 0x0078 }
            r9 = 9
            r3[r9] = r5     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r9 = "com_mopub_ad_width"
            int r9 = r7.getInt(r9)     // Catch:{ JSONException -> 0x0078 }
            r1.f35700k = r9     // Catch:{ JSONException -> 0x0078 }
            r9 = 10
            r3[r9] = r5     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r9 = "com_mopub_ad_height"
            int r9 = r7.getInt(r9)     // Catch:{ JSONException -> 0x0078 }
            r1.f35701l = r9     // Catch:{ JSONException -> 0x0078 }
            r9 = 11
            r3[r9] = r5     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r9 = f35691b     // Catch:{ JSONException -> 0x0078 }
            long r10 = r1.f35699j     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ JSONException -> 0x0078 }
            android.util.Log.d(r9, r10)     // Catch:{ JSONException -> 0x0078 }
            r9 = 12
            r3[r9] = r5     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r9 = f35691b     // Catch:{ JSONException -> 0x0078 }
            java.lang.String r10 = r1.f35698i     // Catch:{ JSONException -> 0x0078 }
            android.util.Log.d(r9, r10)     // Catch:{ JSONException -> 0x0078 }
            r0 = 13
            r3[r0] = r5
            goto L_0x008e
        L_0x0078:
            r0 = move-exception
            goto L_0x0083
        L_0x007a:
            r0 = move-exception
            r8 = r20
            goto L_0x0083
        L_0x007e:
            r0 = move-exception
            r8 = r20
            r6 = r21
        L_0x0083:
            r7 = 14
            r3[r7] = r5
            r0.printStackTrace()
            r7 = 15
            r3[r7] = r5
        L_0x008e:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r7 = 16
            r3[r7] = r5
            r7 = r0
            boolean r0 = com.mopub.nativeads.InMobiGDPR.isConsentUpdated()
            if (r0 != 0) goto L_0x00a3
            r0 = 17
            r3[r0] = r5
            goto L_0x00df
        L_0x00a3:
            r0 = 18
            r3[r0] = r5     // Catch:{ JSONException -> 0x00c2 }
            java.lang.String r0 = "gdpr_consent_available"
            boolean r9 = com.mopub.nativeads.InMobiGDPR.m38160a()     // Catch:{ JSONException -> 0x00c2 }
            r7.put(r0, r9)     // Catch:{ JSONException -> 0x00c2 }
            r0 = 19
            r3[r0] = r5     // Catch:{ JSONException -> 0x00c2 }
            java.lang.String r0 = "gdpr"
            java.lang.String r9 = com.mopub.nativeads.InMobiGDPR.m38161b()     // Catch:{ JSONException -> 0x00c2 }
            r7.put(r0, r9)     // Catch:{ JSONException -> 0x00c2 }
            r0 = 20
            r3[r0] = r5
            goto L_0x00df
        L_0x00c2:
            r0 = move-exception
            r9 = 21
            r3[r9] = r5
            java.lang.String r9 = f35691b
            java.lang.String r10 = "Unable to set GDPR consent object"
            android.util.Log.d(r9, r10)
            r9 = 22
            r3[r9] = r5
            java.lang.String r9 = f35691b
            java.lang.String r10 = r0.getMessage()
            android.util.Log.e(r9, r10)
            r9 = 23
            r3[r9] = r5
        L_0x00df:
            boolean r0 = f35692c
            r9 = 0
            if (r0 == 0) goto L_0x00e9
            r0 = 24
            r3[r0] = r5
            goto L_0x00f8
        L_0x00e9:
            r0 = 25
            r3[r0] = r5     // Catch:{ Exception -> 0x01cd }
            java.lang.String r0 = r1.f35698i     // Catch:{ Exception -> 0x01cd }
            com.inmobi.sdk.InMobiSdk.init(r2, r0, r7)     // Catch:{ Exception -> 0x01cd }
            f35692c = r5     // Catch:{ Exception -> 0x01cd }
            r0 = 26
            r3[r0] = r5
        L_0x00f8:
            com.inmobi.ads.InMobiBanner r0 = new com.inmobi.ads.InMobiBanner
            long r10 = r1.f35699j
            r0.<init>(r2, r10)
            r1.f35702m = r0
            r0 = 30
            r3[r0] = r5
            com.inmobi.ads.InMobiBanner r0 = r1.f35702m
            com.mopub.nativeads.m r10 = new com.mopub.nativeads.m
            r10.<init>(r1)
            r0.setListener(r10)
            r0 = 31
            r3[r0] = r5
            com.inmobi.ads.InMobiBanner r0 = r1.f35702m
            r0.setEnableAutoRefresh(r9)
            r0 = 32
            r3[r0] = r5
            com.inmobi.ads.InMobiBanner r0 = r1.f35702m
            com.inmobi.ads.InMobiBanner$AnimationType r9 = com.inmobi.ads.InMobiBanner.AnimationType.ANIMATION_OFF
            r0.setAnimationType(r9)
            r0 = 33
            r3[r0] = r5
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            r9 = 34
            r3[r9] = r5
            java.lang.String r9 = "window"
            java.lang.Object r9 = r2.getSystemService(r9)
            android.view.WindowManager r9 = (android.view.WindowManager) r9
            r10 = 35
            r3[r10] = r5
            android.view.Display r10 = r9.getDefaultDisplay()
            r11 = 36
            r3[r11] = r5
            r10.getMetrics(r0)
            r11 = 37
            r3[r11] = r5
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r12 = 38
            r3[r12] = r5
            java.lang.String r12 = "tp"
            java.lang.String r13 = "c_mopub"
            r11.put(r12, r13)
            r12 = 39
            r3[r12] = r5
            java.lang.String r12 = "tp-ver"
            java.lang.String r13 = "5.7.1"
            r11.put(r12, r13)
            r12 = 40
            r3[r12] = r5
            com.inmobi.ads.InMobiBanner r12 = r1.f35702m
            r12.setExtras(r11)
            r12 = 41
            r3[r12] = r5
            int r12 = r1.f35700k
            int r13 = r1.f35701l
            com.mopub.nativeads.InMobiBannerCustomEvent$a r12 = r1.m38156a(r12, r13)
            if (r12 != 0) goto L_0x018d
            r13 = 42
            r3[r13] = r5
            com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener r13 = r1.f35697h
            com.mopub.mobileads.MoPubErrorCode r14 = com.mopub.mobileads.MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR
            r13.onBannerFailed(r14)
            r13 = 43
            r3[r13] = r5
            return
        L_0x018d:
            com.inmobi.ads.InMobiBanner r13 = r1.f35702m
            android.widget.LinearLayout$LayoutParams r14 = new android.widget.LinearLayout$LayoutParams
            r15 = 44
            r3[r15] = r5
            int r15 = r12.getWidth()
            float r15 = (float) r15
            float r5 = r0.density
            float r15 = r15 * r5
            int r5 = java.lang.Math.round(r15)
            r15 = 45
            r16 = 1
            r3[r15] = r16
            int r15 = r12.getHeight()
            float r15 = (float) r15
            float r2 = r0.density
            float r15 = r15 * r2
            int r2 = java.lang.Math.round(r15)
            r14.<init>(r5, r2)
            r2 = 46
            r3[r2] = r16
            r13.setLayoutParams(r14)
            r2 = 47
            r3[r2] = r16
            com.inmobi.ads.InMobiBanner r2 = r1.f35702m
            r2.load()
            r2 = 48
            r3[r2] = r16
            return
        L_0x01cd:
            r0 = move-exception
            r2 = 27
            r5 = 1
            r3[r2] = r5
            r0.printStackTrace()
            f35692c = r9
            r2 = 28
            r3[r2] = r5
            com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener r2 = r1.f35697h
            com.mopub.mobileads.MoPubErrorCode r9 = com.mopub.mobileads.MoPubErrorCode.INTERNAL_ERROR
            r2.onBannerFailed(r9)
            r2 = 29
            r3[r2] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.nativeads.InMobiBannerCustomEvent.loadBanner(android.content.Context, com.mopub.mobileads.CustomEventBanner$CustomEventBannerListener, java.util.Map, java.util.Map):void");
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        m38158d()[49] = true;
    }

    /* renamed from: a */
    private C11535a m38156a(int width, int height) {
        boolean[] d = m38158d();
        if (width > 320) {
            d[50] = true;
        } else if (height > 50) {
            d[51] = true;
        } else {
            C11535a aVar = this.f35694e;
            d[52] = true;
            return aVar;
        }
        if (width > 300) {
            d[53] = true;
        } else if (height > 250) {
            d[54] = true;
        } else {
            C11535a aVar2 = this.f35695f;
            d[55] = true;
            return aVar2;
        }
        if (width > 728) {
            d[56] = true;
        } else if (height > 90) {
            d[57] = true;
        } else {
            C11535a aVar3 = this.f35696g;
            d[58] = true;
            return aVar3;
        }
        d[59] = true;
        return null;
    }
}
