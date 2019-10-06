package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.commons.core.p221d.C10656b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.inmobi.ads.d */
/* compiled from: AdDao */
public class C10528d {

    /* renamed from: a */
    private static final String f32104a = C10528d.class.getSimpleName();

    /* renamed from: b */
    private static C10528d f32105b;

    /* renamed from: c */
    private static final Object f32106c = new Object();

    /* renamed from: d */
    private static final String[] f32107d = {"id", "ad_content", "video_url", "video_track_duration", "click_url", "video_trackers", "companion_ads", "web_vast", "preload_webView", "asset_urls", "ad_type", "ad_size", "placement_id", "tp_key", "insertion_ts", "expiry_duration", "imp_id", "m10_context", "client_request_id", "bid", "bidInfo", "marked"};

    /* renamed from: a */
    public static C10528d m34485a() {
        C10528d dVar = f32105b;
        if (dVar == null) {
            synchronized (f32106c) {
                dVar = f32105b;
                if (dVar == null) {
                    dVar = new C10528d();
                    f32105b = dVar;
                }
            }
        }
        return dVar;
    }

    /* renamed from: a */
    private static String[] m34488a(long j, MonetizationContext monetizationContext, String str) {
        return new String[]{String.valueOf(j), monetizationContext.f31266a, str, BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID};
    }

    /* renamed from: e */
    private static String[] m34494e(long j, String str, MonetizationContext monetizationContext, String str2) {
        return new String[]{String.valueOf(j), str, monetizationContext.f31266a, str2, BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID};
    }

    private C10528d() {
        C10656b a = C10656b.m34962a();
        a.mo34472a("ad", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placement_id INTEGER NOT NULL, ad_content TEXT NOT NULL, ad_type TEXT NOT NULL, ad_size TEXT, asset_urls TEXT, video_url TEXT, video_track_duration TEXT, click_url TEXT, video_trackers TEXT, companion_ads TEXT, web_vast TEXT, preload_webView INTEGER DEFAULT 0, insertion_ts INTEGER NOT NULL, imp_id TEXT NOT NULL UNIQUE, m10_context TEXT NOT NULL, tp_key TEXT, expiry_duration INTEGER NOT NULL, client_request_id TEXT NOT NULL,bid INTEGER NOT NULL,bidInfo TEXT,marked INTEGER DEFAULT 0)");
        m34493d();
        a.mo34476b();
    }

    /* renamed from: a */
    static List<C10359a> m34487a(String str, long j) {
        long j2;
        ArrayList arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        int i = 0;
        C10656b bVar = a;
        List<ContentValues> a2 = bVar.mo34470a("ad", f32107d, "ad_type=?", new String[]{str}, null, null, null, null);
        if (a2.size() == 0) {
            a.mo34476b();
            return arrayList;
        }
        for (ContentValues a3 : a2) {
            C10359a a4 = C10360a.m33812a(a3);
            if (a4.mo33952c() == -1) {
                j2 = (a4.f31479e + TimeUnit.SECONDS.toMillis(j)) - System.currentTimeMillis();
            } else {
                j2 = a4.mo33952c() - System.currentTimeMillis();
            }
            if (j2 < 0) {
                i += m34484a(a4.f31481g);
                arrayList.add(a4);
            }
        }
        StringBuilder sb = new StringBuilder("Deleted ");
        sb.append(i);
        sb.append(" expired ads from cache of type: ");
        sb.append(str);
        a.mo34476b();
        return arrayList;
    }

    /* renamed from: b */
    static List<C10359a> m34489b() {
        ArrayList arrayList = new ArrayList();
        for (ContentValues a : C10656b.m34962a().mo34470a("ad", f32107d, null, null, null, null, null, null)) {
            arrayList.add(C10360a.m33812a(a));
        }
        return arrayList;
    }

    /* renamed from: d */
    private static void m34493d() {
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        for (ContentValues contentValues : bVar.mo34470a("ad", f32107d, "marked=?", new String[]{"1"}, null, null, null, null)) {
            contentValues.put("marked", BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
            a.mo34471a("ad", contentValues, "imp_id=?", new String[]{contentValues.getAsString("imp_id")});
        }
        a.mo34476b();
    }

    /* renamed from: a */
    static int m34482a(long j, String str, MonetizationContext monetizationContext, String str2) {
        int i;
        C10656b a = C10656b.m34962a();
        String str3 = "ad";
        if (str == null || str.trim().length() == 0) {
            i = a.mo34475b(str3, "placement_id=? AND m10_context=? AND tp_key=? AND marked=?", m34488a(j, monetizationContext, str2));
        } else {
            i = a.mo34475b(str3, "placement_id=? AND ad_size=? AND m10_context=? AND tp_key=? AND marked=?", m34494e(j, str, monetizationContext, str2));
        }
        a.mo34476b();
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final synchronized C10359a mo34255b(long j, String str, MonetizationContext monetizationContext, String str2) {
        C10359a f;
        f = m34495f(j, str, monetizationContext, str2);
        if (f != null) {
            C10656b.m34962a().mo34469a("ad", "id=?", new String[]{String.valueOf(f.f31475a)});
        }
        return f;
    }

    /* renamed from: f */
    private synchronized C10359a m34495f(long j, String str, MonetizationContext monetizationContext, String str2) {
        List list;
        C10359a a;
        C10656b a2 = C10656b.m34962a();
        if (str == null || str.trim().length() == 0) {
            list = a2.mo34470a("ad", f32107d, "placement_id=? AND m10_context=? AND tp_key=? AND marked=?", m34488a(j, monetizationContext, str2), null, null, "insertion_ts", "1");
        } else {
            list = a2.mo34470a("ad", f32107d, "placement_id=? AND ad_size=? AND m10_context=? AND tp_key=? AND marked=?", m34494e(j, str, monetizationContext, str2), null, null, "insertion_ts", "1");
        }
        if (list.size() == 0) {
            a = null;
        } else {
            a = C10360a.m33812a((ContentValues) list.get(0));
        }
        return a;
    }

    /* renamed from: c */
    public final synchronized List<C10359a> mo34257c(long j, String str, MonetizationContext monetizationContext, String str2) {
        return m34486a(j, str, monetizationContext, str2, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final synchronized List<C10359a> mo34253a(String str, String str2) {
        ArrayList arrayList;
        List<ContentValues> list;
        arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        if (str2 == null || str2.trim().length() == 0) {
            list = a.mo34470a("ad", f32107d, "video_url=?", new String[]{str}, null, null, "insertion_ts", null);
        } else {
            list = a.mo34470a("ad", f32107d, "video_url=? AND ad_size=?", new String[]{str, str2}, null, null, "insertion_ts", null);
        }
        for (ContentValues a2 : list) {
            arrayList.add(C10360a.m33812a(a2));
        }
        return arrayList;
    }

    /* renamed from: d */
    public final synchronized List<C10359a> mo34258d(long j, String str, MonetizationContext monetizationContext, String str2) {
        return m34486a(j, str, monetizationContext, str2, true);
    }

    /* renamed from: a */
    private static List<C10359a> m34486a(long j, String str, MonetizationContext monetizationContext, String str2, boolean z) {
        List<ContentValues> list;
        ArrayList arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        String str3 = "bid";
        String str4 = "insertion_ts";
        if (str == null || str.trim().length() == 0) {
            list = a.mo34470a("ad", f32107d, "placement_id=? AND m10_context=? AND tp_key=? AND marked=?", m34488a(j, monetizationContext, str2), null, null, z ? str3 : str4, null);
        } else {
            list = a.mo34470a("ad", f32107d, "placement_id=? AND ad_size=? AND m10_context=? AND tp_key=? AND marked=?", m34494e(j, str, monetizationContext, str2), null, null, z ? str3 : str4, null);
        }
        for (ContentValues a2 : list) {
            arrayList.add(C10360a.m33812a(a2));
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final synchronized List<C10359a> mo34256b(String str, String str2) {
        ArrayList arrayList;
        List<ContentValues> list;
        arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        if (str2 == null || str2.trim().length() == 0) {
            C10656b bVar = a;
            list = bVar.mo34470a("ad", f32107d, "video_url=?", new String[]{str}, null, null, "insertion_ts", null);
        } else {
            C10656b bVar2 = a;
            list = bVar2.mo34470a("ad", f32107d, "video_url=? AND ad_size=?", new String[]{str, str2}, null, null, "insertion_ts", null);
        }
        for (ContentValues contentValues : list) {
            a.mo34469a("ad", "id=?", new String[]{String.valueOf(contentValues.getAsInteger("id").intValue())});
            arrayList.add(C10360a.m33812a(contentValues));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static int m34483a(C10359a aVar) {
        return m34484a(aVar.f31481g);
    }

    /* renamed from: a */
    public static int m34484a(String str) {
        C10656b a = C10656b.m34962a();
        int a2 = a.mo34469a("ad", "imp_id = ?", new String[]{String.valueOf(str)});
        a.mo34476b();
        return a2;
    }

    /* renamed from: b */
    public static void m34490b(String str) {
        C10656b a = C10656b.m34962a();
        C10359a c = m34491c(str);
        if (c != null) {
            ContentValues a2 = c.mo33949a();
            a2.put("marked", "1");
            a.mo34474b("ad", a2, "imp_id=?", new String[]{str});
        }
    }

    /* renamed from: c */
    public static C10359a m34491c(String str) {
        List a = C10656b.m34962a().mo34470a("ad", f32107d, "imp_id=?", new String[]{str}, null, null, null, "1");
        if (a.size() == 0) {
            return null;
        }
        return C10360a.m33812a((ContentValues) a.get(0));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo34254a(java.util.List<com.inmobi.ads.C10359a> r17, long r18, int r20, java.lang.String r21, com.inmobi.ads.InMobiAdRequest.MonetizationContext r22, java.lang.String r23, java.lang.String r24) {
        /*
            r16 = this;
            r0 = r18
            r2 = r22
            r3 = r23
            monitor-enter(r16)
            boolean r4 = android.text.TextUtils.isEmpty(r24)     // Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x000f
            if (r20 == 0) goto L_0x0015
        L_0x000f:
            int r5 = r17.size()     // Catch:{ all -> 0x00d9 }
            if (r5 != 0) goto L_0x0017
        L_0x0015:
            monitor-exit(r16)
            return
        L_0x0017:
            com.inmobi.commons.core.d.b r5 = com.inmobi.commons.core.p221d.C10656b.m34962a()     // Catch:{ all -> 0x00d9 }
            java.util.Iterator r6 = r17.iterator()     // Catch:{ all -> 0x00d9 }
        L_0x001f:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x00d9 }
            if (r7 == 0) goto L_0x0040
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x00d9 }
            com.inmobi.ads.a r7 = (com.inmobi.ads.C10359a) r7     // Catch:{ all -> 0x00d9 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d9 }
            r7.f31479e = r8     // Catch:{ all -> 0x00d9 }
            android.content.ContentValues r7 = r7.mo33949a()     // Catch:{ all -> 0x00d9 }
            java.lang.String r8 = "tp_key"
            r7.put(r8, r3)     // Catch:{ all -> 0x00d9 }
            java.lang.String r8 = "ad"
            r5.mo34473a(r8, r7)     // Catch:{ all -> 0x00d9 }
            goto L_0x001f
        L_0x0040:
            if (r4 != 0) goto L_0x0045
            m34490b(r24)     // Catch:{ all -> 0x00d9 }
        L_0x0045:
            r4 = 0
            int r6 = m34482a(r0, r4, r2, r3)     // Catch:{ all -> 0x00d9 }
            int r6 = r6 - r20
            if (r6 <= 0) goto L_0x00d4
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x00d9 }
            r7.<init>()     // Catch:{ all -> 0x00d9 }
            java.lang.String r8 = "type"
            r9 = r21
            r7.put(r8, r9)     // Catch:{ all -> 0x00d9 }
            java.lang.String r8 = "count"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00d9 }
            r7.put(r8, r9)     // Catch:{ all -> 0x00d9 }
            com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ all -> 0x00d9 }
            java.lang.String r8 = "ads"
            java.lang.String r9 = "DbSpaceOverflow"
            com.inmobi.commons.core.p222e.C10659b.m34987a(r8, r9, r7)     // Catch:{ all -> 0x00d9 }
            java.lang.String r7 = "ad"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x00d9 }
            java.lang.String r9 = "id"
            r15 = 0
            r8[r15] = r9     // Catch:{ all -> 0x00d9 }
            java.lang.String r9 = "placement_id=? AND m10_context=? AND tp_key=? AND marked=?"
            java.lang.String[] r10 = m34488a(r0, r2, r3)     // Catch:{ all -> 0x00d9 }
            r11 = 0
            r12 = 0
            java.lang.String r13 = "insertion_ts ASC"
            java.lang.String r14 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00d9 }
            r6 = r5
            java.util.List r0 = r6.mo34470a(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00d9 }
            int r1 = r0.size()     // Catch:{ all -> 0x00d9 }
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x00d9 }
        L_0x0092:
            int r2 = r0.size()     // Catch:{ all -> 0x00d9 }
            if (r15 >= r2) goto L_0x00ad
            java.lang.Object r2 = r0.get(r15)     // Catch:{ all -> 0x00d9 }
            android.content.ContentValues r2 = (android.content.ContentValues) r2     // Catch:{ all -> 0x00d9 }
            java.lang.String r3 = "id"
            java.lang.Integer r2 = r2.getAsInteger(r3)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00d9 }
            r1[r15] = r2     // Catch:{ all -> 0x00d9 }
            int r15 = r15 + 1
            goto L_0x0092
        L_0x00ad:
            java.lang.String r0 = java.util.Arrays.toString(r1)     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "["
            java.lang.String r2 = "("
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "]"
            java.lang.String r2 = ")"
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "ad"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d9 }
            java.lang.String r3 = "id IN "
            r2.<init>(r3)     // Catch:{ all -> 0x00d9 }
            r2.append(r0)     // Catch:{ all -> 0x00d9 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00d9 }
            r5.mo34469a(r1, r0, r4)     // Catch:{ all -> 0x00d9 }
        L_0x00d4:
            r5.mo34476b()     // Catch:{ all -> 0x00d9 }
            monitor-exit(r16)
            return
        L_0x00d9:
            r0 = move-exception
            monitor-exit(r16)
            goto L_0x00dd
        L_0x00dc:
            throw r0
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10528d.mo34254a(java.util.List, long, int, java.lang.String, com.inmobi.ads.InMobiAdRequest$MonetizationContext, java.lang.String, java.lang.String):void");
    }

    /* renamed from: c */
    public static void m34492c() {
        C10656b a = C10656b.m34962a();
        a.mo34469a("ad", null, null);
        a.mo34476b();
    }
}
