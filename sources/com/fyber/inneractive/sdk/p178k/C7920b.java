package com.fyber.inneractive.sdk.p178k;

import com.fyber.inneractive.sdk.util.C8046z;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.k.b */
public class C7920b extends C8046z {

    /* renamed from: a */
    boolean f16120a;

    /* renamed from: b */
    boolean f16121b;

    /* renamed from: c */
    boolean f16122c;

    /* renamed from: d */
    String f16123d;

    /* renamed from: e */
    String f16124e;

    /* renamed from: f */
    String f16125f;

    /* renamed from: g */
    String f16126g;

    /* renamed from: h */
    String f16127h;

    /* renamed from: i */
    String f16128i;

    /* renamed from: j */
    String f16129j;

    /* renamed from: k */
    String f16130k;

    /* renamed from: l */
    boolean f16131l = false;

    /* renamed from: m */
    private String f16132m;

    public C7920b(String str) {
        super(str);
    }

    /* renamed from: a */
    public final String mo24729a() {
        mo24730b();
        StringBuilder sb = new StringBuilder("final url = ");
        sb.append(this.f16406n);
        IAlog.m18021b(sb.toString());
        return this.f16406n.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x027d, code lost:
        if (r2 == false) goto L_0x0282;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02c8  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo24730b() {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = r0.f16127h
            java.lang.String r2 = "spotid"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16130k
            java.lang.String r2 = "uid"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16129j
            java.lang.String r2 = "med"
            r0.mo24876a(r2, r1)
            boolean r1 = r0.f16120a
            if (r1 == 0) goto L_0x001e
            r1 = 372(0x174, float:5.21E-43)
            goto L_0x0020
        L_0x001e:
            r1 = 116(0x74, float:1.63E-43)
        L_0x0020:
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r2 = "f"
            r0.mo24876a(r2, r1)
            boolean r1 = r0.f16120a
            java.lang.String r2 = "2,5"
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = "protocols"
            r0.mo24876a(r1, r2)
            java.lang.String r1 = "mimes"
            java.lang.String r3 = "video/mp4,video/webm,video/3gpp"
            r0.mo24876a(r1, r3)
        L_0x003b:
            boolean r1 = r0.f16122c
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0047
            boolean r1 = r0.f16121b
            if (r1 == 0) goto L_0x0047
            goto L_0x0056
        L_0x0047:
            boolean r1 = r0.f16122c
            if (r1 == 0) goto L_0x004e
            java.lang.String r2 = "5"
            goto L_0x0056
        L_0x004e:
            boolean r1 = r0.f16121b
            if (r1 == 0) goto L_0x0055
            java.lang.String r2 = "2"
            goto L_0x0056
        L_0x0055:
            r2 = r3
        L_0x0056:
            java.lang.String r1 = "api"
            r0.mo24876a(r1, r2)
            java.lang.String r1 = r0.f16125f
            java.lang.String r2 = "a"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16124e
            java.lang.String r2 = "g"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16126g
            java.lang.String r2 = "zip"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16123d
            java.lang.String r2 = "k"
            r0.mo24876a(r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "2.2.0"
            r1.<init>(r2)
            r2 = 45
            r1.append(r2)
            java.lang.String r4 = "Android-7.2.2"
            r1.append(r4)
            java.lang.String r4 = com.fyber.inneractive.sdk.external.InneractiveAdManager.getDevPlatform()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x009c
            r1.append(r2)
            java.lang.String r2 = com.fyber.inneractive.sdk.external.InneractiveAdManager.getDevPlatform()
            r1.append(r2)
        L_0x009c:
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "v"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.config.IAConfigManager.m16995i()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r4 = 0
            if (r2 == 0) goto L_0x00bc
            com.fyber.inneractive.sdk.config.a r1 = com.fyber.inneractive.sdk.config.C7687a.C7688a.f15267a
            com.fyber.inneractive.sdk.config.a$b r1 = r1.f15266b
            if (r1 == 0) goto L_0x00ba
            java.lang.String r1 = r1.f15268a
            goto L_0x00bc
        L_0x00ba:
            r1 = r4
        L_0x00bc:
            java.lang.String r2 = "aaid"
            r0.mo24876a(r2, r1)
            com.fyber.inneractive.sdk.config.a r1 = com.fyber.inneractive.sdk.config.C7687a.C7688a.f15267a
            com.fyber.inneractive.sdk.config.a$b r1 = r1.f15266b
            if (r1 == 0) goto L_0x00cc
            boolean r1 = r1.f15269b
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            java.lang.String r1 = java.lang.Boolean.toString(r1)
            java.lang.String r5 = "dnt"
            r0.mo24876a(r5, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.util.C8005i.m18055d()
            java.lang.String r5 = "dml"
            r0.mo24876a(r5, r1)
            int r1 = com.fyber.inneractive.sdk.util.C8006j.m18081t()
            int r5 = com.fyber.inneractive.sdk.util.C8006j.m18080s()
            if (r1 <= 0) goto L_0x0105
            if (r5 <= 0) goto L_0x0105
            int r1 = com.fyber.inneractive.sdk.util.C8006j.m18066a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r6 = "w"
            r0.mo24876a(r6, r1)
            int r1 = com.fyber.inneractive.sdk.util.C8006j.m18066a(r5)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r5 = "h"
            r0.mo24876a(r5, r1)
        L_0x0105:
            int r1 = com.fyber.inneractive.sdk.util.C8006j.m18078q()
            r5 = 1
            if (r1 != r5) goto L_0x0110
            java.lang.String r1 = "p"
            goto L_0x0118
        L_0x0110:
            r6 = 2
            if (r1 != r6) goto L_0x0116
            java.lang.String r1 = "l"
            goto L_0x0118
        L_0x0116:
            java.lang.String r1 = "u"
        L_0x0118:
            java.lang.String r6 = "o"
            r0.mo24876a(r6, r1)
            com.fyber.inneractive.sdk.util.q r1 = com.fyber.inneractive.sdk.util.C8020q.C8025a.f16363a
            android.content.Context r6 = r1.f16351a
            if (r6 != 0) goto L_0x012f
            java.lang.String r1 = "Location Manager: getBestLastKnownLocation called, but context is null!"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)
            r7 = r3
            goto L_0x0316
        L_0x012f:
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r7 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r6)
            java.lang.String r8 = "android.permission.ACCESS_COARSE_LOCATION"
            if (r7 == 0) goto L_0x0143
            java.lang.String r7 = "Location Manager: getBestLastKnownLocation: Found fine location permission"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)
            r7 = 1
            goto L_0x0150
        L_0x0143:
            boolean r7 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r8)
            if (r7 == 0) goto L_0x030f
            java.lang.String r7 = "Location Manager: getBestLastKnownLocation: Found coarse location permission"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)
            r7 = 0
        L_0x0150:
            android.content.Context r9 = r1.f16351a
            java.lang.String r10 = "location"
            java.lang.Object r9 = r9.getSystemService(r10)
            android.location.LocationManager r9 = (android.location.LocationManager) r9
            java.lang.String r11 = "Location Manager: last known network location time delta = "
            java.lang.String r12 = "gps"
            if (r7 == 0) goto L_0x019c
            boolean r7 = r9.isProviderEnabled(r12)
            if (r7 == 0) goto L_0x0197
            android.location.Location r7 = r9.getLastKnownLocation(r12)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Location Manager: last known GPS location: "
            r13.<init>(r14)
            r13.append(r7)
            java.lang.String r13 = r13.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r13)
            if (r7 == 0) goto L_0x019d
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            long r14 = java.lang.System.currentTimeMillis()
            long r16 = r7.getTime()
            long r14 = r14 - r16
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r13)
            goto L_0x019d
        L_0x0197:
            java.lang.String r7 = "Location Manager: getBestLastKnownLocation: Gps location permission available, but GPS provider is disabled!"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)
        L_0x019c:
            r7 = r4
        L_0x019d:
            java.lang.String r13 = "network"
            boolean r14 = r9.isProviderEnabled(r13)
            if (r14 == 0) goto L_0x01d6
            android.location.Location r4 = r9.getLastKnownLocation(r13)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r14 = "Location Manager: last known network location: "
            r9.<init>(r14)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r9)
            if (r4 == 0) goto L_0x01db
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            long r14 = java.lang.System.currentTimeMillis()
            long r16 = r4.getTime()
            long r14 = r14 - r16
            r9.append(r14)
            java.lang.String r9 = r9.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r9)
            goto L_0x01db
        L_0x01d6:
            java.lang.String r9 = "Location Manager: getBestLastKnownLocation: Network location permission available, but Network provider is disabled!"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r9)
        L_0x01db:
            android.location.Location r4 = com.fyber.inneractive.sdk.util.C8020q.m18104a(r7, r4)
            android.location.Location r7 = r1.f16352b
            android.location.Location r4 = com.fyber.inneractive.sdk.util.C8020q.m18104a(r4, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "Location Manager: getBestLastKnownLocation: returning - "
            r7.<init>(r9)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)
            android.content.Context r7 = r1.f16351a
            if (r7 == 0) goto L_0x0201
            com.fyber.inneractive.sdk.util.g$a r9 = r1.f16353c
            if (r9 == 0) goto L_0x0201
            com.fyber.inneractive.sdk.util.C8001g.m18045a(r7, r9)
        L_0x0201:
            if (r4 == 0) goto L_0x0280
            int r7 = com.fyber.inneractive.sdk.config.IAConfigManager.m17006t()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "Location Manager: isLastKnownLocationGoodEnough: maxTimeAccInMin = "
            r9.<init>(r11)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r9)
            int r7 = r7 * 60
            int r7 = r7 * 1000
            long r14 = (long) r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "Location Manager: isLastKnownLocationGoodEnough: max time accuracy in msec = "
            r7.<init>(r9)
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)
            long r16 = java.lang.System.currentTimeMillis()
            long r18 = r4.getTime()
            long r16 = r16 - r18
            r7 = r3
            long r2 = java.lang.Math.abs(r16)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r9 = "Location Manager: isLastKnownLocationGoodEnough: location: = "
            r11.<init>(r9)
            r11.append(r4)
            java.lang.String r9 = " tss = "
            r11.append(r9)
            r11.append(r2)
            java.lang.String r9 = " tssM = "
            r11.append(r9)
            r17 = 60000(0xea60, double:2.9644E-319)
            r9 = r6
            long r5 = r2 / r17
            r11.append(r5)
            java.lang.String r5 = r11.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r5)
            int r5 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r5 > 0) goto L_0x026a
            r2 = 1
            goto L_0x026b
        L_0x026a:
            r2 = 0
        L_0x026b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Location Manager: isLastKnownLocationGoodEnough: returns - "
            r3.<init>(r5)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)
            if (r2 != 0) goto L_0x030e
            goto L_0x0282
        L_0x0280:
            r7 = r3
            r9 = r6
        L_0x0282:
            android.content.Context r2 = r1.f16351a
            if (r2 != 0) goto L_0x028e
            java.lang.String r1 = "Location Manager: registerForLocationUpdates called, but context is null!"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)
            goto L_0x030e
        L_0x028e:
            java.lang.Object r2 = r2.getSystemService(r10)
            android.location.LocationManager r2 = (android.location.LocationManager) r2
            android.location.LocationListener r3 = r1.f16356f
            if (r3 != 0) goto L_0x02be
            boolean r3 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r8)
            if (r3 != 0) goto L_0x02a5
            boolean r3 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r9)
            if (r3 == 0) goto L_0x02c3
        L_0x02a5:
            boolean r3 = r2.isProviderEnabled(r13)
            if (r3 == 0) goto L_0x02c3
            java.lang.String r3 = "Location Manager: registerting for network location updates"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)
            com.fyber.inneractive.sdk.util.q$2 r3 = new com.fyber.inneractive.sdk.util.q$2
            r3.<init>()
            r1.f16356f = r3
            android.location.LocationListener r3 = r1.f16356f
            r1.mo24856a(r13, r3)
            r5 = 1
            goto L_0x02c4
        L_0x02be:
            java.lang.String r3 = "Location Manager: network location listener already registered"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)
        L_0x02c3:
            r5 = 0
        L_0x02c4:
            android.location.LocationListener r3 = r1.f16357g
            if (r3 != 0) goto L_0x02e7
            boolean r3 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r9)
            if (r3 == 0) goto L_0x02ec
            boolean r2 = r2.isProviderEnabled(r12)
            if (r2 == 0) goto L_0x02ec
            java.lang.String r2 = "Location Manager: registerting for gps location updates"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r2)
            com.fyber.inneractive.sdk.util.q$3 r2 = new com.fyber.inneractive.sdk.util.q$3
            r2.<init>()
            r1.f16357g = r2
            android.location.LocationListener r2 = r1.f16357g
            r1.mo24856a(r12, r2)
            r5 = 1
            goto L_0x02ec
        L_0x02e7:
            java.lang.String r2 = "Location Manager: gps location listener already registered"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r2)
        L_0x02ec:
            if (r5 == 0) goto L_0x030e
            long r2 = java.lang.System.currentTimeMillis()
            r1.f16358h = r2
            java.lang.Runnable r2 = r1.f16355e
            if (r2 != 0) goto L_0x0300
            com.fyber.inneractive.sdk.util.q$4 r2 = new com.fyber.inneractive.sdk.util.q$4
            r2.<init>()
            r1.f16355e = r2
        L_0x0300:
            android.os.Handler r2 = r1.f16354d
            java.lang.Runnable r1 = r1.f16355e
            int r3 = com.fyber.inneractive.sdk.config.IAConfigManager.m17007u()
            int r3 = r3 * 1000
            long r5 = (long) r3
            r2.postDelayed(r1, r5)
        L_0x030e:
            goto L_0x0316
        L_0x030f:
            r7 = r3
            java.lang.String r1 = "Location Manager: getBestLastKnownLocation: did not find any location permissions"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r1)
        L_0x0316:
            if (r4 == 0) goto L_0x03ae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            double r2 = r4.getLatitude()
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            double r2 = r4.getLongitude()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "lg"
            r0.mo24876a(r2, r1)
            float r1 = r4.getAccuracy()
            double r2 = (double) r1
            r5 = 0
            int r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x034e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "hacc"
            r0.mo24876a(r2, r1)
        L_0x034e:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            r8 = 0
            if (r1 >= r2) goto L_0x0376
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r4.getTime()
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0374
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0374
            long r1 = r1 - r3
            double r1 = (double) r1
            r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r3
            goto L_0x0375
        L_0x0374:
            r1 = r5
        L_0x0375:
            goto L_0x0393
        L_0x0376:
            long r1 = android.os.SystemClock.elapsedRealtimeNanos()
            long r3 = r4.getElapsedRealtimeNanos()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0392
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0392
            long r1 = r1 - r3
            double r1 = (double) r1
            r3 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r3
            goto L_0x0393
        L_0x0392:
            r1 = r5
        L_0x0393:
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x03ae
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r2 = 0
            r4[r2] = r1
            java.lang.String r1 = "%.2f"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            java.lang.String r2 = "tacc"
            r0.mo24876a(r2, r1)
        L_0x03ae:
            java.lang.String r1 = com.fyber.inneractive.sdk.util.C8005i.m18058g()
            java.lang.String r2 = "ciso"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.util.C8005i.m18051a()
            if (r1 != 0) goto L_0x03c0
            r3 = r7
            goto L_0x03c9
        L_0x03c0:
            int r2 = com.fyber.inneractive.sdk.util.C8005i.m18050a(r1)
            r3 = 0
            java.lang.String r3 = r1.substring(r3, r2)
        L_0x03c9:
            java.lang.String r2 = "mcc"
            r0.mo24876a(r2, r3)
            if (r1 != 0) goto L_0x03d3
            r3 = r7
            goto L_0x03db
        L_0x03d3:
            int r2 = com.fyber.inneractive.sdk.util.C8005i.m18050a(r1)
            java.lang.String r3 = r1.substring(r2)
        L_0x03db:
            java.lang.String r1 = "mnc"
            r0.mo24876a(r1, r3)
            com.fyber.inneractive.sdk.util.ac r1 = com.fyber.inneractive.sdk.util.C7989ac.m18034a()
            java.lang.String r1 = r1.f16311f
            java.lang.String r2 = "nt"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.util.C8005i.m18059h()
            java.lang.String r2 = "crn"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.config.IAConfigManager.m16955F()
            java.lang.String r2 = "lng"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.config.IAConfigManager.m16956G()
            java.lang.String r2 = "in_lng"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.util.C8005i.m18056e()
            java.lang.String r2 = "bid"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = com.fyber.inneractive.sdk.util.C8005i.m18057f()
            java.lang.String r2 = "appv"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16132m
            java.lang.String r2 = "nativeContent"
            r0.mo24876a(r2, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = java.lang.Long.toString(r1)
            java.lang.String r2 = "t"
            r0.mo24876a(r2, r1)
            r1 = 1
            java.lang.String r1 = java.lang.Boolean.toString(r1)
            java.lang.String r2 = "fromSDK"
            r0.mo24876a(r2, r1)
            java.lang.String r1 = r0.f16128i
            java.lang.String r2 = "po"
            r0.mo24876a(r2, r1)
            java.lang.Boolean r1 = com.fyber.inneractive.sdk.config.IAConfigManager.m16991e()
            if (r1 == 0) goto L_0x0453
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x044c
            java.lang.String r1 = "1"
            goto L_0x044e
        L_0x044c:
            java.lang.String r1 = "0"
        L_0x044e:
            java.lang.String r2 = "gdpr_privacy_consent"
            r0.mo24876a(r2, r1)
        L_0x0453:
            boolean r1 = m17865c()
            if (r1 == 0) goto L_0x0460
            java.lang.String r1 = "vv"
            java.lang.String r2 = "moat"
            r0.mo24876a(r1, r2)
        L_0x0460:
            boolean r1 = r0.f16131l
            if (r1 == 0) goto L_0x0467
            java.lang.String r1 = "1"
            goto L_0x0469
        L_0x0467:
            java.lang.String r1 = "0"
        L_0x0469:
            java.lang.String r2 = "secure"
            r0.mo24876a(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p178k.C7920b.mo24730b():void");
    }

    /* renamed from: c */
    private static boolean m17865c() {
        Class cls;
        try {
            cls = Class.forName("com.moat.analytics.mobile.ina.MoatAnalytics");
        } catch (Throwable th) {
            cls = null;
        }
        return cls != null;
    }
}
