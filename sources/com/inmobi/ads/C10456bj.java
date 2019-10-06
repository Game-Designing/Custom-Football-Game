package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.commons.core.p221d.C10656b;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.inmobi.ads.bj */
/* compiled from: PlacementDao */
public class C10456bj {

    /* renamed from: a */
    public static final String[] f31807a = {"id", "placement_id", "tp_key", "last_accessed_ts", "ad_type", "m10_context"};

    /* renamed from: b */
    private static final String f31808b = C10456bj.class.getSimpleName();

    /* renamed from: c */
    private static C10456bj f31809c;

    /* renamed from: d */
    private static final Object f31810d = new Object();

    /* renamed from: a */
    public static C10456bj m34231a() {
        C10456bj bjVar = f31809c;
        if (bjVar == null) {
            synchronized (f31810d) {
                bjVar = f31809c;
                if (bjVar == null) {
                    bjVar = new C10456bj();
                    f31809c = bjVar;
                }
            }
        }
        return bjVar;
    }

    private C10456bj() {
        C10656b a = C10656b.m34962a();
        a.mo34472a(VungleActivity.PLACEMENT_EXTRA, "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placement_id INTEGER NOT NULL,tp_key TEXT,last_accessed_ts INTEGER NOT NULL,ad_type TEXT NOT NULL,m10_context TEXT NOT NULL,UNIQUE(placement_id,m10_context,tp_key))");
        a.mo34476b();
    }

    /* renamed from: a */
    public static int m34230a(long j, String str) {
        C10656b a = C10656b.m34962a();
        int a2 = a.mo34469a(VungleActivity.PLACEMENT_EXTRA, "ad_type=? AND last_accessed_ts<?", new String[]{str, String.valueOf(System.currentTimeMillis() - (j * 1000))});
        StringBuilder sb = new StringBuilder("Deleted ");
        sb.append(a2);
        sb.append(" expired pids from cache");
        a.mo34476b();
        return a2;
    }

    /* renamed from: a */
    public final synchronized int mo34168a(List<C10455bi> list, int i) {
        if (list.size() == 0) {
            return 0;
        }
        C10656b a = C10656b.m34962a();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C10455bi biVar = (C10455bi) list.get(i2);
            String[] strArr = {String.valueOf(biVar.f31801a), biVar.f31806f.toString(), biVar.f31802b};
            String str = VungleActivity.PLACEMENT_EXTRA;
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", Long.valueOf(biVar.f31801a));
            contentValues.put("last_accessed_ts", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("tp_key", biVar.f31802b);
            contentValues.put("ad_type", biVar.f31805e);
            contentValues.put("m10_context", biVar.f31806f.toString());
            a.mo34471a(str, contentValues, "placement_id = ? AND m10_context = ? AND tp_key=?", strArr);
        }
        int a2 = a.mo34468a(VungleActivity.PLACEMENT_EXTRA) - i;
        if (a2 > 0) {
            C10656b bVar = a;
            List a3 = bVar.mo34470a(VungleActivity.PLACEMENT_EXTRA, new String[]{"id"}, null, null, null, null, "last_accessed_ts ASC", String.valueOf(a2));
            String[] strArr2 = new String[a3.size()];
            for (int i3 = 0; i3 < a3.size(); i3++) {
                strArr2[i3] = String.valueOf(((ContentValues) a3.get(i3)).getAsInteger("id"));
            }
            String replace = Arrays.toString(strArr2).replace("[", "(").replace("]", ")");
            String str2 = VungleActivity.PLACEMENT_EXTRA;
            StringBuilder sb = new StringBuilder("id IN ");
            sb.append(replace);
            a.mo34469a(str2, sb.toString(), null);
        }
        a.mo34476b();
        return a2;
    }

    /* renamed from: a */
    public static List<C10455bi> m34232a(String str) {
        ArrayList arrayList = new ArrayList();
        C10656b a = C10656b.m34962a();
        C10656b bVar = a;
        List<ContentValues> a2 = bVar.mo34470a(VungleActivity.PLACEMENT_EXTRA, f31807a, "ad_type=? ", new String[]{str}, null, null, null, null);
        a.mo34476b();
        for (ContentValues biVar : a2) {
            arrayList.add(new C10455bi(biVar));
        }
        return arrayList;
    }
}
