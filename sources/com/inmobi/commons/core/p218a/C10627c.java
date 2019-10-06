package com.inmobi.commons.core.p218a;

import android.content.ContentValues;
import com.inmobi.commons.core.p219b.C10631b;
import com.inmobi.commons.core.p221d.C10656b;
import com.inmobi.commons.core.p221d.C10657c;
import com.inmobi.commons.p217a.C10619a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.commons.core.a.c */
/* compiled from: CrashDao */
public class C10627c extends C10631b {

    /* renamed from: a */
    private static final String f32382a = C10627c.class.getSimpleName();

    public C10627c() {
        C10656b a = C10656b.m34962a();
        a.mo34472a("crash", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventId TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
        a.mo34476b();
    }

    /* renamed from: a */
    public static void m34873a(C10628d dVar) {
        C10656b a = C10656b.m34962a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventId", dVar.f32385b);
        contentValues.put("componentType", dVar.f32387d);
        contentValues.put("eventType", dVar.f32386c);
        contentValues.put("payload", dVar.mo34435a());
        contentValues.put("ts", String.valueOf(dVar.f32388e));
        a.mo34473a("crash", contentValues);
        a.mo34476b();
    }

    /* renamed from: a */
    public static List<C10628d> m34871a(int i) {
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        List<ContentValues> a2 = bVar.mo34470a("crash", null, null, null, null, null, "ts ASC", String.valueOf(i));
        ArrayList arrayList = new ArrayList();
        a.mo34476b();
        for (ContentValues a3 : a2) {
            arrayList.add(C10628d.m34881a(a3));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo34431a(long j, String str) {
        List a = m34871a(1);
        if (a.size() <= 0 || TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ((C10628d) a.get(0)).f32388e) < j) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo34430a(long j, long j2, String str) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + j;
        List a = m34871a(1);
        if (a.size() <= 0 || seconds - TimeUnit.MILLISECONDS.toSeconds(((C10628d) a.get(0)).f32388e) < j2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final int mo34428a(String str) {
        C10656b a = C10656b.m34962a();
        int a2 = a.mo34468a("crash");
        a.mo34476b();
        return a2;
    }

    /* renamed from: b */
    public final int mo34432b(long j, String str) {
        C10656b a = C10656b.m34962a();
        int a2 = a.mo34469a("crash", "ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (j * 1000))});
        StringBuilder sb = new StringBuilder("Deleted ");
        sb.append(a2);
        sb.append(" expired events from crash DB");
        a.mo34476b();
        return a2;
    }

    /* renamed from: a */
    public final void mo34429a(List<Integer> list) {
        if (!list.isEmpty()) {
            C10656b a = C10656b.m34962a();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i = 0; i < list.size() - 1; i++) {
                stringBuffer.append(list.get(i));
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(list.get(list.size() - 1)));
            StringBuilder sb = new StringBuilder("id IN (");
            sb.append(stringBuffer);
            sb.append(")");
            a.mo34469a("crash", sb.toString(), null);
            a.mo34476b();
        }
    }

    /* renamed from: a */
    public static void m34872a() {
        C10656b a = C10656b.m34962a();
        List a2 = a.mo34470a("crash", null, null, null, null, null, "ts ASC", "1");
        if (!a2.isEmpty()) {
            String asString = ((ContentValues) a2.get(0)).getAsString("id");
            StringBuilder sb = new StringBuilder("id IN (");
            sb.append(asString);
            sb.append(")");
            a.mo34469a("crash", sb.toString(), null);
        }
        a.mo34476b();
    }

    /* renamed from: c */
    public final void mo34434c(long j, String str) {
        if (C10619a.m34838a()) {
            C10657c.m34974b("batch_processing_info").mo34478a("crash_last_batch_process", j);
        }
    }

    /* renamed from: b */
    public final long mo34433b(String str) {
        if (C10619a.m34838a()) {
            return C10657c.m34974b("batch_processing_info").mo34481b("crash_last_batch_process", -1);
        }
        return -1;
    }
}
