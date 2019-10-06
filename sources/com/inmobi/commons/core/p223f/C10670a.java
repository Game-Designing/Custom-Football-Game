package com.inmobi.commons.core.p223f;

import android.content.ContentValues;
import com.inmobi.commons.core.p219b.C10631b;
import com.inmobi.commons.core.p221d.C10656b;
import com.inmobi.commons.core.p221d.C10657c;
import com.inmobi.commons.p217a.C10619a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.inmobi.commons.core.f.a */
/* compiled from: TRCDao */
public class C10670a extends C10631b {

    /* renamed from: a */
    private static final String f32540a = C10670a.class.getSimpleName();

    public C10670a() {
        C10656b a = C10656b.m34962a();
        a.mo34472a("trc", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventId TEXT NOT NULL, adMarkup TEXT NOT NULL, eventName TEXT NOT NULL, imPlid INTEGER NOT NULL, impressionId TEXT NOT NULL, eventType TEXT NOT NULL, dNettypeRaw TEXT NOT NULL, ts TEXT NOT NULL, adtype TEXT NOT NULL, timestamp TEXT NOT NULL)");
        a.mo34476b();
    }

    /* renamed from: a */
    public static void m35020a(C10671b bVar) {
        C10656b a = C10656b.m34962a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventId", bVar.f32542b);
        contentValues.put("adMarkup", bVar.f32543c);
        contentValues.put("eventName", bVar.f32544d);
        contentValues.put("imPlid", Long.valueOf(bVar.f32545e));
        contentValues.put("impressionId", bVar.f32546f);
        contentValues.put("eventType", bVar.f32547g);
        contentValues.put("dNettypeRaw", bVar.f32548h);
        contentValues.put("ts", String.valueOf(bVar.f32549i));
        contentValues.put("adtype", bVar.f32550j);
        contentValues.put("timestamp", String.valueOf(bVar.f32551k));
        a.mo34473a("trc", contentValues);
        a.mo34476b();
    }

    /* renamed from: a */
    public static List<C10671b> m35019a(int i, String str) {
        C10656b a = C10656b.m34962a();
        String str2 = "trc";
        String str3 = "adtype=?";
        C10656b bVar = a;
        List<ContentValues> a2 = bVar.mo34470a(str2, null, str3, new String[]{str}, null, null, "ts ASC", String.valueOf(i));
        a.mo34476b();
        ArrayList arrayList = new ArrayList();
        for (ContentValues a3 : a2) {
            arrayList.add(C10671b.m35032a(a3));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo34431a(long j, String str) {
        List a = m35019a(1, str);
        if (a.size() <= 0 || TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ((C10671b) a.get(0)).f32549i) < j) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo34430a(long j, long j2, String str) {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + j;
        List a = m35019a(1, str);
        if (a.size() <= 0 || seconds - TimeUnit.MILLISECONDS.toSeconds(((C10671b) a.get(0)).f32549i) <= j2) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m35021c(String str) {
        C10656b a = C10656b.m34962a();
        int b = a.mo34475b("trc", "adtype=?", new String[]{str});
        a.mo34476b();
        return b > 0;
    }

    /* renamed from: d */
    public static void m35022d(String str) {
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        List a2 = bVar.mo34470a("trc", null, "adtype=?", new String[]{str}, null, null, "timestamp ASC", "1");
        if (!a2.isEmpty()) {
            String asString = ((ContentValues) a2.get(0)).getAsString("id");
            StringBuilder sb = new StringBuilder("id IN (");
            sb.append(asString);
            sb.append(")");
            a.mo34469a("trc", sb.toString(), null);
        }
        a.mo34476b();
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
            a.mo34469a("trc", sb.toString(), null);
            a.mo34476b();
        }
    }

    /* renamed from: a */
    public final int mo34428a(String str) {
        C10656b a = C10656b.m34962a();
        int b = a.mo34475b("trc", "adtype=?", new String[]{str});
        a.mo34476b();
        return b;
    }

    /* renamed from: b */
    public final int mo34432b(long j, String str) {
        C10656b a = C10656b.m34962a();
        int a2 = a.mo34469a("trc", "ts<? and adtype=?", new String[]{String.valueOf(System.currentTimeMillis() - (j * 1000)), str});
        StringBuilder sb = new StringBuilder("Deleted ");
        sb.append(a2);
        sb.append(" expired events from trc DB");
        a.mo34476b();
        return a2;
    }

    /* renamed from: b */
    public final String mo34438b(int i) {
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        List a2 = bVar.mo34470a("trc", null, "id=?", new String[]{String.valueOf(i)}, null, null, "timestamp ASC", "1");
        a.mo34476b();
        if (!a2.isEmpty()) {
            return C10671b.m35032a((ContentValues) a2.get(0)).f32550j;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m35023e(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            r2 = 1
            if (r0 == r1) goto L_0x0029
            r1 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r0 == r1) goto L_0x001f
            r1 = 104431(0x197ef, float:1.46339E-40)
            if (r0 == r1) goto L_0x0015
        L_0x0014:
            goto L_0x0033
        L_0x0015:
            java.lang.String r0 = "int"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0014
            r3 = 1
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "native"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0014
            r3 = 2
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "banner"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0014
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = -1
        L_0x0034:
            if (r3 == 0) goto L_0x003f
            if (r3 == r2) goto L_0x003b
            java.lang.String r3 = "trc_last_native_batch_process"
            goto L_0x0042
        L_0x003b:
            java.lang.String r3 = "trc_last_int_batch_process"
            goto L_0x0042
        L_0x003f:
            java.lang.String r3 = "trc_last_banner_batch_process"
        L_0x0042:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.commons.core.p223f.C10670a.m35023e(java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public final void mo34434c(long j, String str) {
        String e = m35023e(str);
        if (C10619a.m34838a()) {
            C10657c.m34974b("batch_processing_info").mo34478a(e, j);
        }
    }

    /* renamed from: b */
    public final long mo34433b(String str) {
        String e = m35023e(str);
        if (C10619a.m34838a()) {
            return C10657c.m34974b("batch_processing_info").mo34481b(e, -1);
        }
        return -1;
    }
}
