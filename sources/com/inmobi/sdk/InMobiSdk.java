package com.inmobi.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.inmobi.ads.C10438b;
import com.inmobi.ads.cache.AssetStore;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.ads.p212c.C10500b;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p221d.C10657c;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.C10681a;
import com.inmobi.commons.core.utilities.C10681a.C10685b;
import com.inmobi.commons.core.utilities.C10701e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.core.utilities.p225b.C10697g;
import com.inmobi.commons.core.utilities.uid.C10709c;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.commons.p217a.C10620b;
import com.inmobi.p207a.C10300o;
import com.inmobi.p216b.C10614a;
import com.inmobi.rendering.p226a.C10738c;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

public final class InMobiSdk {
    private static final ExecutorService COMPONENT_SERVICE = Executors.newSingleThreadExecutor();
    public static final String IM_GDPR_CONSENT_AVAILABLE = "gdpr_consent_available";
    /* access modifiers changed from: private */
    public static final String TAG = InMobiSdk.class.getSimpleName();

    /* renamed from: com.inmobi.sdk.InMobiSdk$7 */
    static /* synthetic */ class C107967 {

        /* renamed from: a */
        static final /* synthetic */ int[] f32978a = new int[LogLevel.values().length];

        static {
            try {
                f32978a[LogLevel.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f32978a[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f32978a[LogLevel.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum AgeGroup {
        BELOW_18("below18"),
        BETWEEN_18_AND_24("between18and24"),
        BETWEEN_25_AND_29("between25and29"),
        BETWEEN_30_AND_34("between30and34"),
        BETWEEN_35_AND_44("between35and44"),
        BETWEEN_45_AND_54("between45and54"),
        BETWEEN_55_AND_65("between55and65"),
        ABOVE_65("above65");
        

        /* renamed from: a */
        private String f32979a;

        private AgeGroup(String str) {
            this.f32979a = str;
        }

        public final String toString() {
            return this.f32979a;
        }
    }

    public enum Education {
        HIGH_SCHOOL_OR_LESS("highschoolorless"),
        COLLEGE_OR_GRADUATE("collegeorgraduate"),
        POST_GRADUATE_OR_ABOVE("postgraduateorabove");
        

        /* renamed from: a */
        private String f32980a;

        private Education(String str) {
            this.f32980a = str;
        }

        public final String toString() {
            return this.f32980a;
        }
    }

    public enum Gender {
        FEMALE(InneractiveMediationDefs.GENDER_FEMALE),
        MALE(InneractiveMediationDefs.GENDER_MALE);
        

        /* renamed from: a */
        private String f32981a;

        private Gender(String str) {
            this.f32981a = str;
        }

        public final String toString() {
            return this.f32981a;
        }
    }

    public enum LogLevel {
        NONE,
        ERROR,
        DEBUG
    }

    public static void init(Context context, String str) {
        init(context, str, null);
    }

    public static void init(Context context, String str, JSONObject jSONObject) {
        String str2 = "root";
        String str3 = ")";
        String str4 = "Error in submitting telemetry event : (";
        String str5 = "ads";
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            C10694e.m35111a(jSONObject);
            if (VERSION.SDK_INT < 14) {
                Logger.m35065a(InternalLogLevel.ERROR, TAG, "The minimum supported Android API level is 14, SDK could not be initialized.");
            } else if (context == null) {
                Logger.m35065a(InternalLogLevel.ERROR, TAG, "Context supplied as null, SDK could not be initialized.");
            } else {
                if (str != null) {
                    if (str.trim().length() != 0) {
                        Intent intent = new Intent();
                        intent.setClassName(context.getPackageName(), "com.inmobi.rendering.InMobiAdActivity");
                        if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                            Logger.m35065a(InternalLogLevel.ERROR, TAG, "The activity com.inmobi.rendering.InMobiAdActivity not present in AndroidManifest. SDK could not be initialized.");
                            return;
                        }
                        if (C10701e.m35150a(context, str5, "android.permission.INTERNET")) {
                            if (C10701e.m35150a(context, str5, "android.permission.ACCESS_NETWORK_STATE")) {
                                if (!C10701e.m35150a(context, str5, "android.permission.ACCESS_COARSE_LOCATION") && !C10701e.m35150a(context, str5, "android.permission.ACCESS_FINE_LOCATION")) {
                                    Logger.m35065a(InternalLogLevel.ERROR, TAG, "Please grant the location permissions (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION, or both) for better ad targeting.");
                                }
                                str = str.trim();
                                if (!(str.length() == 32 || str.length() == 36)) {
                                    Logger.m35065a(InternalLogLevel.DEBUG, TAG, "Invalid account id passed to init. Please provide a valid account id.");
                                }
                                String str6 = "InitRequested";
                                if (C10619a.m34838a()) {
                                    try {
                                        C10659b.m34983a();
                                        C10659b.m34987a(str2, str6, null);
                                        return;
                                    } catch (Exception e) {
                                        StringBuilder sb = new StringBuilder(str4);
                                        sb.append(e.getMessage());
                                        sb.append(str3);
                                        return;
                                    }
                                } else {
                                    String str7 = "sdk_version_store";
                                    if (hasSdkVersionChanged(context)) {
                                        C10620b.m34853a(context, C10797a.m35369a(context));
                                        C10657c.m34972a(context, str7).mo34479a("sdk_version", "7.2.7");
                                        resetMediaCache(context.getApplicationContext());
                                    }
                                    C10619a.m34835a(context, str);
                                    C10641b.m34915a().mo34453b();
                                    C10659b.m34983a().mo34487b();
                                    if (C10657c.m34972a(context, str7).mo34482b("db_deletion_failed", false)) {
                                        List<String> b = C10797a.m35371b(context);
                                        for (String sendDbDeletionTelemetryEvent : b) {
                                            sendDbDeletionTelemetryEvent(sendDbDeletionTelemetryEvent);
                                        }
                                        if (b.isEmpty()) {
                                            C10620b.m34853a(context, false);
                                        }
                                    }
                                    C10697g.m35123b();
                                    initComponents();
                                    C10641b.m34915a();
                                    C10641b.m34923d();
                                    COMPONENT_SERVICE.execute(new Runnable() {
                                        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0100, code lost:
                                            return;
                                         */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final void run() {
                                            /*
                                                r19 = this;
                                                com.inmobi.ads.C10438b.m34172c()     // Catch:{ Exception -> 0x0104 }
                                                com.inmobi.ads.cache.AssetStore r0 = com.inmobi.ads.cache.AssetStore.m34369a()     // Catch:{ Exception -> 0x0104 }
                                                r0.mo34225b()     // Catch:{ Exception -> 0x0104 }
                                                com.inmobi.ads.cache.AssetStore r0 = com.inmobi.ads.cache.AssetStore.m34369a()     // Catch:{ Exception -> 0x0104 }
                                                java.lang.Object r1 = com.inmobi.ads.cache.AssetStore.f32011e     // Catch:{ Exception -> 0x0104 }
                                                monitor-enter(r1)     // Catch:{ Exception -> 0x0104 }
                                                com.inmobi.ads.cache.d r2 = r0.f32015a     // Catch:{ all -> 0x0101 }
                                                java.util.List r2 = com.inmobi.ads.cache.C10517d.m34434b()     // Catch:{ all -> 0x0101 }
                                                boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0101 }
                                                if (r3 == 0) goto L_0x001f
                                                monitor-exit(r1)     // Catch:{ all -> 0x0101 }
                                                return
                                            L_0x001f:
                                                java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x0101 }
                                            L_0x0023:
                                                boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0101 }
                                                r5 = 1
                                                r6 = 0
                                                if (r4 == 0) goto L_0x0044
                                                java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0101 }
                                                com.inmobi.ads.cache.a r4 = (com.inmobi.ads.cache.C10513a) r4     // Catch:{ all -> 0x0101 }
                                                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0101 }
                                                long r9 = r4.f32052h     // Catch:{ all -> 0x0101 }
                                                int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                                                if (r11 <= 0) goto L_0x003d
                                                goto L_0x003e
                                            L_0x003d:
                                                r5 = 0
                                            L_0x003e:
                                                if (r5 == 0) goto L_0x0043
                                                com.inmobi.ads.cache.AssetStore.m34375a(r4)     // Catch:{ all -> 0x0101 }
                                            L_0x0043:
                                                goto L_0x0023
                                            L_0x0044:
                                                java.util.List r3 = com.inmobi.ads.cache.C10517d.m34434b()     // Catch:{ all -> 0x0101 }
                                                r7 = 0
                                                java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0101 }
                                            L_0x004e:
                                                boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0101 }
                                                if (r4 == 0) goto L_0x0067
                                                java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0101 }
                                                com.inmobi.ads.cache.a r4 = (com.inmobi.ads.cache.C10513a) r4     // Catch:{ all -> 0x0101 }
                                                java.io.File r9 = new java.io.File     // Catch:{ all -> 0x0101 }
                                                java.lang.String r4 = r4.f32049e     // Catch:{ all -> 0x0101 }
                                                r9.<init>(r4)     // Catch:{ all -> 0x0101 }
                                                long r9 = r9.length()     // Catch:{ all -> 0x0101 }
                                                long r7 = r7 + r9
                                                goto L_0x004e
                                            L_0x0067:
                                                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
                                                java.lang.String r4 = "MAX CACHESIZE "
                                                r3.<init>(r4)     // Catch:{ all -> 0x0101 }
                                                com.inmobi.ads.c$b r4 = r0.f32016b     // Catch:{ all -> 0x0101 }
                                                long r9 = r4.f31919d     // Catch:{ all -> 0x0101 }
                                                r3.append(r9)     // Catch:{ all -> 0x0101 }
                                                com.inmobi.ads.c$b r3 = r0.f32016b     // Catch:{ all -> 0x0101 }
                                                long r3 = r3.f31919d     // Catch:{ all -> 0x0101 }
                                                int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                                                if (r9 <= 0) goto L_0x00ac
                                                com.inmobi.commons.core.d.b r10 = com.inmobi.commons.core.p221d.C10656b.m34962a()     // Catch:{ all -> 0x0101 }
                                                java.lang.String r11 = "asset"
                                                java.lang.String[] r12 = com.inmobi.ads.cache.C10517d.f32077a     // Catch:{ all -> 0x0101 }
                                                r13 = 0
                                                r14 = 0
                                                r15 = 0
                                                r16 = 0
                                                java.lang.String r17 = "ts ASC "
                                                r18 = 0
                                                java.util.List r3 = r10.mo34470a(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0101 }
                                                int r4 = r3.size()     // Catch:{ all -> 0x0101 }
                                                if (r4 != 0) goto L_0x009b
                                                r3 = 0
                                                goto L_0x00a5
                                            L_0x009b:
                                                java.lang.Object r3 = r3.get(r6)     // Catch:{ all -> 0x0101 }
                                                android.content.ContentValues r3 = (android.content.ContentValues) r3     // Catch:{ all -> 0x0101 }
                                                com.inmobi.ads.cache.a r3 = com.inmobi.ads.cache.C10517d.m34429a(r3)     // Catch:{ all -> 0x0101 }
                                            L_0x00a5:
                                                if (r3 == 0) goto L_0x00ac
                                                com.inmobi.ads.cache.AssetStore.m34375a(r3)     // Catch:{ all -> 0x0101 }
                                                goto L_0x0044
                                            L_0x00ac:
                                                android.content.Context r0 = com.inmobi.commons.p217a.C10619a.m34839b()     // Catch:{ all -> 0x0101 }
                                                java.io.File r0 = com.inmobi.commons.p217a.C10619a.m34831a(r0)     // Catch:{ all -> 0x0101 }
                                                boolean r3 = r0.exists()     // Catch:{ all -> 0x0101 }
                                                if (r3 == 0) goto L_0x00ff
                                                java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0101 }
                                                if (r0 == 0) goto L_0x00ff
                                                int r3 = r0.length     // Catch:{ all -> 0x0101 }
                                                r4 = 0
                                            L_0x00c3:
                                                if (r4 >= r3) goto L_0x00ff
                                                r7 = r0[r4]     // Catch:{ all -> 0x0101 }
                                                java.util.Iterator r8 = r2.iterator()     // Catch:{ all -> 0x0101 }
                                            L_0x00cc:
                                                boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0101 }
                                                if (r9 == 0) goto L_0x00e8
                                                java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0101 }
                                                com.inmobi.ads.cache.a r9 = (com.inmobi.ads.cache.C10513a) r9     // Catch:{ all -> 0x0101 }
                                                java.lang.String r10 = r7.getAbsolutePath()     // Catch:{ all -> 0x0101 }
                                                java.lang.String r9 = r9.f32049e     // Catch:{ all -> 0x0101 }
                                                boolean r9 = r10.equals(r9)     // Catch:{ all -> 0x0101 }
                                                if (r9 == 0) goto L_0x00e7
                                                r8 = 1
                                                goto L_0x00e9
                                            L_0x00e7:
                                                goto L_0x00cc
                                            L_0x00e8:
                                                r8 = 0
                                            L_0x00e9:
                                                if (r8 != 0) goto L_0x00fc
                                                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
                                                java.lang.String r9 = "found Orphan file "
                                                r8.<init>(r9)     // Catch:{ all -> 0x0101 }
                                                java.lang.String r9 = r7.getAbsolutePath()     // Catch:{ all -> 0x0101 }
                                                r8.append(r9)     // Catch:{ all -> 0x0101 }
                                                r7.delete()     // Catch:{ all -> 0x0101 }
                                            L_0x00fc:
                                                int r4 = r4 + 1
                                                goto L_0x00c3
                                            L_0x00ff:
                                                monitor-exit(r1)     // Catch:{ all -> 0x0101 }
                                                return
                                            L_0x0101:
                                                r0 = move-exception
                                                monitor-exit(r1)     // Catch:{ all -> 0x0101 }
                                                throw r0     // Catch:{ Exception -> 0x0104 }
                                            L_0x0104:
                                                r0 = move-exception
                                                com.inmobi.sdk.InMobiSdk.TAG
                                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                                java.lang.String r2 = "Error in starting Asset Cache : ("
                                                r1.<init>(r2)
                                                java.lang.String r0 = r0.getMessage()
                                                r1.append(r0)
                                                java.lang.String r0 = ")"
                                                r1.append(r0)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.sdk.InMobiSdk.C107901.run():void");
                                        }
                                    });
                                    if (context instanceof Activity) {
                                        C10681a a = C10681a.m35067a();
                                        if (a != null) {
                                            a.mo34515a((C10685b) new C10685b() {
                                                /* renamed from: a */
                                                public final void mo34519a(boolean z) {
                                                    C10619a.m34841b(z);
                                                    if (z) {
                                                        try {
                                                            InMobiSdk.initComponents();
                                                        } catch (Exception e) {
                                                            InMobiSdk.TAG;
                                                            new StringBuilder("Encountered unexpected error in the onFocusChanged handler: ").append(e.getMessage());
                                                            Logger.m35065a(InternalLogLevel.DEBUG, InMobiSdk.TAG, "SDK encountered an unexpected error; some components may not work as advertised");
                                                        }
                                                    } else {
                                                        InMobiSdk.deInitComponents();
                                                    }
                                                }
                                            });
                                        }
                                    }
                                    try {
                                        C10659b.m34983a();
                                        C10659b.m34987a(str2, str6, null);
                                    } catch (Exception e2) {
                                        StringBuilder sb2 = new StringBuilder(str4);
                                        sb2.append(e2.getMessage());
                                        sb2.append(str3);
                                    }
                                    InternalLogLevel internalLogLevel = InternalLogLevel.DEBUG;
                                    String str8 = TAG;
                                    StringBuilder sb3 = new StringBuilder("InMobi SDK initialized with account id: ");
                                    sb3.append(str);
                                    Logger.m35065a(internalLogLevel, str8, sb3.toString());
                                    try {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("initTime", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                                        C10659b.m34983a();
                                        C10659b.m34987a(str2, "SdkInitialized", hashMap);
                                    } catch (Exception e3) {
                                        StringBuilder sb4 = new StringBuilder(str4);
                                        sb4.append(e3.getMessage());
                                        sb4.append(str3);
                                    }
                                    printGrantedPermissions();
                                    return;
                                }
                            }
                        }
                        Logger.m35065a(InternalLogLevel.ERROR, TAG, "Please grant the mandatory permissions : INTERNET and ACCESS_NETWORK_STATE, SDK could not be initialized.");
                        return;
                    }
                }
                Logger.m35065a(InternalLogLevel.ERROR, TAG, "Account id cannot be null or empty. Please provide a valid account id.");
            }
        } catch (Exception e4) {
            C10619a.m34844c();
            Logger.m35065a(InternalLogLevel.ERROR, TAG, "SDK could not be initialized; an unexpected error was encountered");
            new StringBuilder("Encountered unexpected error while initializing the SDK: ").append(e4.getMessage());
        }
    }

    public static void updateGDPRConsent(JSONObject jSONObject) {
        C10694e.m35111a(jSONObject);
    }

    public static void setApplicationMuted(boolean z) {
        C10619a.m34837a(z);
    }

    private static void sendDbDeletionTelemetryEvent(String str) {
        if (C10619a.m34838a()) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("filename", str);
                String str2 = Repo.COLUMN_DESCRIPTION;
                StringBuilder sb = new StringBuilder("DB Deleted : ");
                sb.append(str);
                hashMap.put(str2, sb.toString());
                C10659b.m34983a();
                C10659b.m34987a("ads", "PersistentDataCleanFail", hashMap);
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                sb2.append(e.getMessage());
                sb2.append(")");
            }
        }
    }

    private static boolean hasSdkVersionChanged(Context context) {
        return C10620b.m34852a(context) == null || !C10620b.m34852a(context).equals("7.2.7");
    }

    private static void printGrantedPermissions() {
        COMPONENT_SERVICE.execute(new Runnable() {
            public final void run() {
                String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.VIBRATE", "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR", "com.google.android.gms.permission.ACTIVITY_RECOGNITION"};
                StringBuilder sb = new StringBuilder("Permissions granted to SDK are :\nandroid.permission.INTERNET\nandroid.permission.ACCESS_NETWORK_STATE");
                for (int i = 0; i < 8; i++) {
                    String str = strArr[i];
                    if (C10701e.m35150a(C10619a.m34839b(), "ads", str)) {
                        sb.append("\n");
                        sb.append(str);
                    }
                }
                Logger.m35065a(InternalLogLevel.DEBUG, InMobiSdk.TAG, sb.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public static void initComponents() {
        try {
            COMPONENT_SERVICE.execute(new Runnable() {
                public final void run() {
                    try {
                        C10709c a = C10709c.m35160a();
                        try {
                            C10709c.m35162c();
                            a.mo34529b();
                        } catch (Exception e) {
                            new StringBuilder("SDK encountered an unexpected error while initializing the UID helper component; ").append(e.getMessage());
                        }
                        C10709c.m35160a().mo34529b();
                        C10641b.m34915a().mo34453b();
                        C10738c.m35282a().mo34654b();
                        C10621a a2 = C10621a.m34854a();
                        C10621a.f32352b.set(false);
                        C10641b.m34915a().mo34452a((C10639a) a2.f32357c, (C10644c) a2);
                        a2.f32358d = a2.f32357c.f32366a;
                        a2.f32356a.execute(new Runnable() {
                            public final void run() {
                                C10621a.this.f32356a.execute(new Runnable() {
                                    public final void run() {
                                        if (C10621a.this.f32359h.mo34428a(BuildConfig.APTOIDE_THEME) > 0) {
                                            C10621a.m34856a(C10621a.this);
                                        }
                                    }
                                });
                            }
                        });
                        C10659b.m34983a().mo34487b();
                        C10614a a3 = C10614a.m34820a();
                        C10614a.f32330b.set(false);
                        C10694e.m35113c();
                        C10641b.m34915a().mo34452a((C10639a) a3.f32335c, (C10644c) a3);
                        a3.f32337e = a3.f32335c.f31890b;
                        a3.f32334a.execute(new Runnable() {
                            public final void run() {
                                C10614a.m34822a(C10614a.this);
                            }
                        });
                        C10438b.m34168a();
                        C10300o.m33571a().mo33667b();
                        C10500b.m34347d().mo34210a();
                        C10491a.m34323a("native").mo34210a();
                        AssetStore.m34369a().mo34225b();
                    } catch (Exception e2) {
                        InMobiSdk.TAG;
                        new StringBuilder("Encountered unexpected error in starting SDK components: ").append(e2.getMessage());
                        Logger.m35065a(InternalLogLevel.DEBUG, InMobiSdk.TAG, "SDK encountered unexpected error while starting internal components");
                    }
                }
            });
        } catch (Exception e) {
            new StringBuilder("Encountered unexpected error in starting SDK components: ").append(e.getMessage());
            Logger.m35065a(InternalLogLevel.DEBUG, TAG, "SDK encountered unexpected error while starting internal components");
        }
    }

    /* access modifiers changed from: private */
    public static void deInitComponents() {
        try {
            COMPONENT_SERVICE.execute(new Runnable() {
                public final void run() {
                    try {
                        C10641b.m34915a().mo34454c();
                        C10659b a = C10659b.m34983a();
                        C10659b.f32497b.set(true);
                        a.f32502a.execute(new Runnable() {
                            public final void run() {
                                if (C10659b.this.f32506j != null) {
                                    C10659b.this.f32506j.mo34439a();
                                    C10659b.this.f32506j = null;
                                }
                            }
                        });
                        C10614a a2 = C10614a.m34820a();
                        C10614a.f32330b.set(true);
                        a2.f32334a.execute(new Runnable() {
                            public final void run() {
                                if (C10614a.this.f32338i != null) {
                                    C10614a.this.f32338i.mo34439a();
                                    C10614a.this.f32338i = null;
                                }
                            }
                        });
                        C10300o.m33571a().mo33668c();
                        C10500b.m34347d().mo34212b();
                        C10491a.m34323a("native").mo34212b();
                        AssetStore a3 = AssetStore.m34369a();
                        a3.f32018d.set(true);
                        a3.mo34226c();
                    } catch (Exception e) {
                        InMobiSdk.TAG;
                        new StringBuilder("Encountered unexpected error in stopping SDK components; ").append(e.getMessage());
                        Logger.m35065a(InternalLogLevel.ERROR, InMobiSdk.TAG, "SDK encountered unexpected error while stopping internal components");
                    }
                }
            });
        } catch (Exception e) {
            new StringBuilder("Encountered unexpected error in stopping SDK components; ").append(e.getMessage());
            Logger.m35065a(InternalLogLevel.ERROR, TAG, "SDK encountered unexpected error while stopping internal components");
        }
    }

    private static void resetMediaCache(final Context context) {
        final File a = C10619a.m34831a(context);
        COMPONENT_SERVICE.execute(new Runnable() {
            public final void run() {
                C10619a.m34836a(a);
                C10619a.m34840b(context);
            }
        });
        if (!a.mkdir()) {
            a.isDirectory();
        }
    }

    public static void setLogLevel(LogLevel logLevel) {
        int i = C107967.f32978a[logLevel.ordinal()];
        if (i == 1) {
            Logger.m35064a(InternalLogLevel.NONE);
        } else if (i != 2) {
            if (i == 3) {
                Logger.m35064a(InternalLogLevel.DEBUG);
            }
        } else {
            Logger.m35064a(InternalLogLevel.ERROR);
        }
    }

    public static void setAge(int i) {
        C10697g.m35120a(i);
    }

    public static void setAgeGroup(AgeGroup ageGroup) {
        C10697g.m35122a(ageGroup.toString().toLowerCase(Locale.ENGLISH));
    }

    public static void setAreaCode(String str) {
        C10697g.m35125b(str);
    }

    public static void setPostalCode(String str) {
        C10697g.m35127c(str);
    }

    public static void setLocationWithCityStateCountry(String str, String str2, String str3) {
        C10697g.m35129d(str);
        C10697g.m35130e(str2);
        C10697g.m35131f(str3);
    }

    public static void setYearOfBirth(int i) {
        C10697g.m35124b(i);
    }

    public static void setGender(Gender gender) {
        C10697g.m35132g(gender.toString().toLowerCase(Locale.ENGLISH));
    }

    public static void setEducation(Education education) {
        C10697g.m35133h(education.toString().toLowerCase(Locale.ENGLISH));
    }

    public static void setLanguage(String str) {
        C10697g.m35134i(str);
    }

    public static void setInterests(String str) {
        C10697g.m35135j(str);
    }

    public static void setLocation(Location location) {
        C10697g.m35121a(location);
    }

    public static String getVersion() {
        return "7.2.7";
    }
}
