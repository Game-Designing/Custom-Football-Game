package com.fyber.inneractive.sdk.p165f;

import android.os.Build.VERSION;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.p174i.C7907g;
import com.fyber.inneractive.sdk.util.C8005i;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.fyber.inneractive.sdk.f.h */
public final class C7739h extends C7735a {

    /* renamed from: com.fyber.inneractive.sdk.f.h$a */
    public static class C7740a {

        /* renamed from: a */
        InneractiveAdRequest f15494a;

        /* renamed from: b */
        C7737f f15495b;

        /* renamed from: c */
        C7738g f15496c;

        /* renamed from: d */
        C7907g f15497d;

        /* renamed from: e */
        JSONArray f15498e;

        /* renamed from: f */
        boolean f15499f;

        public C7740a(C7737f fVar, InneractiveAdRequest inneractiveAdRequest, C7907g gVar) {
            this(gVar);
            this.f15495b = fVar;
            this.f15494a = inneractiveAdRequest;
        }

        public C7740a(C7738g gVar, InneractiveAdRequest inneractiveAdRequest, C7907g gVar2) {
            this(gVar2);
            this.f15496c = gVar;
            this.f15494a = inneractiveAdRequest;
        }

        private C7740a(C7907g gVar) {
            this.f15499f = false;
            this.f15497d = gVar;
            this.f15498e = new JSONArray();
        }

        /* renamed from: a */
        public final C7740a mo24311a(C7741b bVar) {
            this.f15498e.put(bVar.f15500a);
            return this;
        }

        /* renamed from: a */
        public final C7740a mo24312a(String str) {
            try {
                this.f15498e.put(new JSONObject(str));
            } catch (Exception e) {
            }
            return this;
        }

        /* renamed from: a */
        public final C7740a mo24313a(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                C7741b bVar = new C7741b();
                for (int i = 0; i < objArr.length - 1; i += 2) {
                    bVar.mo24315a(objArr[i].toString(), objArr[i + 1]);
                }
                mo24311a(bVar);
            }
            return this;
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.String] */
        /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.Integer] */
        /* JADX WARNING: type inference failed for: r3v22, types: [java.lang.String] */
        /* JADX WARNING: type inference failed for: r3v23 */
        /* JADX WARNING: type inference failed for: r5v7 */
        /* JADX WARNING: type inference failed for: r3v25 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo24314a() {
            /*
                r8 = this;
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r0 = r8.f15494a
                r1 = 0
                if (r0 != 0) goto L_0x0007
                r0 = r1
                goto L_0x000b
            L_0x0007:
                com.fyber.inneractive.sdk.config.j r0 = r0.getSelectedUnitConfig()
            L_0x000b:
                r2 = 0
                if (r0 == 0) goto L_0x0021
                com.fyber.inneractive.sdk.config.f r0 = r0.mo24207c()
                com.fyber.inneractive.sdk.config.enums.Track r3 = com.fyber.inneractive.sdk.config.enums.Track.ERRORS
                java.util.Set<com.fyber.inneractive.sdk.config.enums.Track> r0 = r0.f15356a
                if (r0 != 0) goto L_0x001a
                r0 = 0
                goto L_0x001e
            L_0x001a:
                boolean r0 = r0.contains(r3)
            L_0x001e:
                if (r0 != 0) goto L_0x0021
                return
            L_0x0021:
                com.fyber.inneractive.sdk.f.h r0 = new com.fyber.inneractive.sdk.f.h
                java.lang.String r3 = com.fyber.inneractive.sdk.config.IAConfigManager.m16994h()
                com.fyber.inneractive.sdk.i.g r4 = r8.f15497d
                java.lang.String r5 = ""
                if (r4 != 0) goto L_0x002f
                r4 = r5
                goto L_0x0031
            L_0x002f:
                java.lang.String r4 = r4.f16032a
            L_0x0031:
                com.fyber.inneractive.sdk.i.g r6 = r8.f15497d
                if (r6 != 0) goto L_0x0037
                r6 = r5
                goto L_0x0039
            L_0x0037:
                java.lang.String r6 = r6.f16035d
            L_0x0039:
                r0.<init>(r3, r4, r6, r2)
                com.fyber.inneractive.sdk.i.g r3 = r8.f15497d
                if (r3 != 0) goto L_0x0042
                r3 = r5
                goto L_0x0044
            L_0x0042:
                java.lang.String r3 = r3.f16033b
            L_0x0044:
                java.lang.String r4 = "contentid"
                r0.mo24310a(r4, r3)
                com.fyber.inneractive.sdk.f.f r3 = r8.f15495b
                java.lang.String r4 = "IA_CI_LOG"
                if (r3 == 0) goto L_0x00a1
                int r3 = r3.f15484C
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r6 = "err"
                r0.mo24310a(r6, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r6 = "Event dispatcher - dispatching error: "
                r3.<init>(r6)
                com.fyber.inneractive.sdk.f.f r6 = r8.f15495b
                r3.append(r6)
                java.lang.String r3 = r3.toString()
                com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)
                com.fyber.inneractive.sdk.f.f r3 = r8.f15495b
                int r3 = r3.f15484C
                com.fyber.inneractive.sdk.a.a r6 = com.fyber.inneractive.sdk.p159a.C7639a.C7640a.f15157a
                boolean r6 = r6.f15150a
                if (r6 == 0) goto L_0x009e
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "DISPATCHED_SDK_ERROR "
                r6.<init>(r7)
                r6.append(r3)
                java.lang.String r6 = r6.toString()
                android.util.Log.v(r4, r6)
                com.fyber.inneractive.sdk.a.a r4 = com.fyber.inneractive.sdk.p159a.C7639a.C7640a.f15157a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r7)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r4.mo24033b(r3)
            L_0x009e:
                java.lang.String r3 = "sdk_error_"
                goto L_0x00f6
            L_0x00a1:
                com.fyber.inneractive.sdk.f.g r3 = r8.f15496c
                if (r3 == 0) goto L_0x020a
                int r3 = r3.f15493h
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.String r6 = "event"
                r0.mo24310a(r6, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r6 = "Event dispatcher - dispatching event: "
                r3.<init>(r6)
                com.fyber.inneractive.sdk.f.g r6 = r8.f15496c
                r3.append(r6)
                java.lang.String r3 = r3.toString()
                com.fyber.inneractive.sdk.util.IAlog.m18021b(r3)
                com.fyber.inneractive.sdk.f.g r3 = r8.f15496c
                int r3 = r3.f15493h
                com.fyber.inneractive.sdk.a.a r6 = com.fyber.inneractive.sdk.p159a.C7639a.C7640a.f15157a
                boolean r6 = r6.f15150a
                if (r6 == 0) goto L_0x00f4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "DISPATCHED_SDK_EVENT "
                r6.<init>(r7)
                r6.append(r3)
                java.lang.String r6 = r6.toString()
                android.util.Log.v(r4, r6)
                com.fyber.inneractive.sdk.a.a r4 = com.fyber.inneractive.sdk.p159a.C7639a.C7640a.f15157a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r7)
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r4.mo24033b(r3)
            L_0x00f4:
                java.lang.String r3 = "sdk_event_"
            L_0x00f6:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r6 = r8.f15494a
                if (r6 == 0) goto L_0x0118
                com.fyber.inneractive.sdk.external.InneractiveMediationName r6 = r6.getMediationName()
                if (r6 == 0) goto L_0x0118
                com.fyber.inneractive.sdk.external.InneractiveAdRequest r6 = r8.f15494a
                com.fyber.inneractive.sdk.external.InneractiveMediationName r6 = r6.getMediationName()
                java.lang.String r6 = r6.getKey()
                r4.append(r6)
                java.lang.String r6 = "_"
                r4.append(r6)
            L_0x0118:
                com.fyber.inneractive.sdk.i.g r6 = r8.f15497d
                if (r6 != 0) goto L_0x011d
                goto L_0x011f
            L_0x011d:
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r6.f16046o
            L_0x011f:
                if (r1 == 0) goto L_0x0127
                java.lang.String r1 = r1.toString()
                goto L_0x0129
            L_0x0127:
                java.lang.String r1 = "unknown"
            L_0x0129:
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                boolean r4 = android.text.TextUtils.isEmpty(r1)
                if (r4 != 0) goto L_0x013c
                java.lang.String r4 = "placement_type"
                r0.mo24310a(r4, r1)
            L_0x013c:
                com.fyber.inneractive.sdk.i.g r1 = r8.f15497d
                if (r1 != 0) goto L_0x0141
                goto L_0x0147
            L_0x0141:
                int r1 = r1.f16038g
                java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            L_0x0147:
                java.lang.String r1 = "ad_type"
                r0.mo24310a(r1, r5)
                boolean r1 = r8.f15499f
                r4 = 1
                if (r1 != r4) goto L_0x0184
                com.fyber.inneractive.sdk.i.g r1 = r8.f15497d
                if (r1 == 0) goto L_0x0184
                java.lang.String r1 = r1.f16039h
                int r4 = r1.length()
                r5 = 51200(0xc800, float:7.1746E-41)
                if (r4 <= r5) goto L_0x017f
                r5 = 51199(0xc7ff, float:7.1745E-41)
                java.lang.String r1 = r1.substring(r2, r5)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r5 = "Sdk event dispatcher: message size "
                r2.<init>(r5)
                r2.append(r4)
                java.lang.String r4 = " is too long! trimming message to 51200 Characters"
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                com.fyber.inneractive.sdk.util.IAlog.m18021b(r2)
            L_0x017f:
                java.lang.String r2 = "ad"
                r0.mo24310a(r2, r1)
            L_0x0184:
                com.fyber.inneractive.sdk.util.C8005i.m18053b()
                com.fyber.inneractive.sdk.util.ac r1 = com.fyber.inneractive.sdk.util.C7989ac.m18034a()
                java.lang.String r1 = r1.f16311f
                java.lang.String r2 = "n"
                r0.mo24310a(r2, r1)
                java.lang.String r1 = "UTC"
                java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
                java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
                long r4 = r1.getTimeInMillis()
                java.lang.Long r2 = java.lang.Long.valueOf(r4)
                java.lang.String r4 = "date_created"
                r0.mo24310a(r4, r2)
                java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
                java.util.Locale r4 = java.util.Locale.US
                java.lang.String r5 = "yyyy-MM-dd"
                r2.<init>(r5, r4)
                java.util.Date r4 = r1.getTime()
                java.lang.String r2 = r2.format(r4)
                java.lang.String r4 = "day"
                r0.mo24310a(r4, r2)
                r2 = 11
                int r1 = r1.get(r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r2 = "hour"
                r0.mo24310a(r2, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                com.fyber.inneractive.sdk.f.f r2 = r8.f15495b
                if (r2 == 0) goto L_0x01e1
                int r2 = r2.f15484C
                java.lang.String r2 = java.lang.String.valueOf(r2)
                goto L_0x01e9
            L_0x01e1:
                com.fyber.inneractive.sdk.f.g r2 = r8.f15496c
                int r2 = r2.f15493h
                java.lang.String r2 = java.lang.String.valueOf(r2)
            L_0x01e9:
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "table"
                r0.mo24310a(r2, r1)
                org.json.JSONArray r1 = r8.f15498e
                if (r1 == 0) goto L_0x0206
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0206
                org.json.JSONArray r1 = r8.f15498e
                java.lang.String r2 = "extra"
                r0.mo24310a(r2, r1)
            L_0x0206:
                r0.mo24309a()
                return
            L_0x020a:
                java.lang.String r0 = "Sdk event dispatcher - error id or event id must be provided"
                com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p165f.C7739h.C7740a.mo24314a():void");
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.f.h$b */
    public static class C7741b {

        /* renamed from: a */
        JSONObject f15500a = new JSONObject();

        /* renamed from: a */
        public final C7741b mo24315a(String str, Object obj) {
            try {
                this.f15500a.put(str, obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Got exception adding param to json object: ");
                sb.append(str);
                sb.append(", ");
                sb.append(obj);
                IAlog.m18023d(sb.toString());
            }
            return this;
        }
    }

    /* synthetic */ C7739h(String str, String str2, String str3, byte b) {
        this(str, str2, str3);
    }

    private C7739h(String str, String str2, String str3) {
        super(IAConfigManager.m17010x());
        mo24310a("osn", "Android");
        mo24310a("osv", VERSION.RELEASE);
        mo24310a("model", C8005i.m18055d());
        mo24310a("sdkv", "7.2.2");
        mo24310a("pkgn", C8005i.m18056e());
        mo24310a("pkgv", C8005i.m18057f());
        mo24310a("appid", str);
        mo24310a("session", str2);
        mo24310a("adnt", str3);
    }
}
