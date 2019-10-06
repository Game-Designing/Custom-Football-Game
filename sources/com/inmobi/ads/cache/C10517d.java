package com.inmobi.ads.cache;

import android.content.ContentValues;
import com.inmobi.commons.core.p221d.C10656b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.inmobi.ads.cache.d */
/* compiled from: AssetDao */
public class C10517d {

    /* renamed from: a */
    public static final String[] f32077a = {"id", "pending_attempts", "url", "disk_uri", "ts", "created_ts", "ttl", "soft_ttl"};

    /* renamed from: b */
    private static final String f32078b = C10517d.class.getSimpleName();

    /* renamed from: c */
    private static C10517d f32079c;

    /* renamed from: d */
    private static final Object f32080d = new Object();

    /* renamed from: a */
    public static C10517d m34431a() {
        C10517d dVar = f32079c;
        if (dVar == null) {
            synchronized (f32080d) {
                dVar = f32079c;
                if (dVar == null) {
                    dVar = new C10517d();
                    f32079c = dVar;
                }
            }
        }
        return dVar;
    }

    private C10517d() {
        C10656b a = C10656b.m34962a();
        a.mo34472a("asset", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pending_attempts INTEGER NOT NULL, url TEXT NOT NULL, disk_uri TEXT, ts TEXT NOT NULL, created_ts TEXT NOT NULL, ttl TEXT NOT NULL, soft_ttl TEXT NOT NULL)");
        a.mo34476b();
    }

    /* renamed from: a */
    public final synchronized void mo34243a(C10513a aVar) {
        if (m34432b(aVar) <= 0) {
            ContentValues d = m34437d(aVar);
            C10656b a = C10656b.m34962a();
            a.mo34473a("asset", d);
            a.mo34476b();
        }
    }

    /* renamed from: b */
    public static List<C10513a> m34434b() {
        ArrayList arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        if (a.mo34468a("asset") == 0) {
            return arrayList;
        }
        C10656b bVar = a;
        List<ContentValues> a2 = bVar.mo34470a("asset", f32077a, "disk_uri IS NOT NULL", null, null, null, "created_ts DESC ", null);
        a.mo34476b();
        for (ContentValues a3 : a2) {
            arrayList.add(m34429a(a3));
        }
        return arrayList;
    }

    /* renamed from: c */
    public static String m34435c() {
        List<C10513a> b = m34434b();
        if (b.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (C10513a aVar : b) {
            try {
                jSONArray.put(URLEncoder.encode(aVar.f32048d, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: a */
    static C10513a m34430a(String str) {
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        List a2 = bVar.mo34470a("asset", f32077a, "url=? ", new String[]{str}, null, null, "created_ts DESC ", "1");
        a.mo34476b();
        if (a2.isEmpty()) {
            return null;
        }
        return m34429a((ContentValues) a2.get(0));
    }

    /* renamed from: d */
    public static List<String> m34438d() {
        ArrayList arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        if (a.mo34468a("asset") == 0) {
            return arrayList;
        }
        String str = "url";
        C10656b bVar = a;
        List<ContentValues> a2 = bVar.mo34470a("asset", new String[]{str}, null, null, null, null, "created_ts DESC ", null);
        a.mo34476b();
        for (ContentValues asString : a2) {
            arrayList.add(asString.getAsString(str));
        }
        return arrayList;
    }

    /* renamed from: e */
    static List<C10513a> m34439e() {
        ArrayList<C10513a> arrayList = new ArrayList<>();
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        for (ContentValues a2 : bVar.mo34470a("asset", f32077a, null, null, null, null, "ts ASC ", null)) {
            arrayList.add(m34429a(a2));
        }
        a.mo34476b();
        ArrayList arrayList2 = new ArrayList();
        for (C10513a aVar : arrayList) {
            if (!aVar.mo34234a()) {
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    /* renamed from: b */
    public static C10513a m34433b(String str) {
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        List a2 = bVar.mo34470a("asset", f32077a, "url=? ", new String[]{str}, null, null, "created_ts DESC ", "1");
        a.mo34476b();
        if (a2.isEmpty()) {
            return null;
        }
        return m34429a((ContentValues) a2.get(0));
    }

    /* renamed from: b */
    public static int m34432b(C10513a aVar) {
        C10656b a = C10656b.m34962a();
        String str = "asset";
        int b = a.mo34474b(str, m34437d(aVar), "url = ?", new String[]{String.valueOf(aVar.f32048d)});
        a.mo34476b();
        return b;
    }

    /* renamed from: c */
    public static void m34436c(C10513a aVar) {
        C10656b a = C10656b.m34962a();
        a.mo34469a("asset", "id = ?", new String[]{String.valueOf(aVar.f32046b)});
        a.mo34476b();
    }

    /* renamed from: a */
    public static C10513a m34429a(ContentValues contentValues) {
        C10513a aVar = new C10513a(contentValues.getAsInteger("id").intValue(), contentValues.getAsString("url"), contentValues.getAsString("disk_uri"), contentValues.getAsInteger("pending_attempts").intValue(), Long.valueOf(contentValues.getAsString("ts")).longValue(), Long.valueOf(contentValues.getAsString("created_ts")).longValue(), Long.valueOf(contentValues.getAsString("ttl")).longValue(), Long.valueOf(contentValues.getAsString("soft_ttl")).longValue());
        return aVar;
    }

    /* renamed from: d */
    private static ContentValues m34437d(C10513a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(aVar.f32046b));
        contentValues.put("url", aVar.f32048d);
        contentValues.put("disk_uri", aVar.f32049e);
        contentValues.put("pending_attempts", Integer.valueOf(aVar.f32047c));
        contentValues.put("ts", Long.toString(aVar.f32050f));
        contentValues.put("created_ts", Long.toString(aVar.f32051g));
        contentValues.put("ttl", Long.toString(aVar.f32052h));
        contentValues.put("soft_ttl", Long.toString(aVar.f32053i));
        return contentValues;
    }
}
