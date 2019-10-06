package com.inmobi.commons.core.utilities.p225b;

import com.inmobi.commons.core.utilities.uid.C10709c;
import com.inmobi.commons.p217a.C10620b;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.utilities.b.f */
/* compiled from: IdentityInfo */
public class C10696f {

    /* renamed from: a */
    private static final String f32634a = C10696f.class.getSimpleName();

    /* renamed from: a */
    public static Map<String, String> m35118a() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("mk-version", C10620b.m34851a());
            C10709c.m35160a();
            Boolean g = C10709c.m35166g();
            if (g != null) {
                hashMap.put("u-id-adt", String.valueOf(g.booleanValue() ? 1 : 0));
            }
            hashMap.put("ts", String.valueOf(Calendar.getInstance().getTimeInMillis()));
            Calendar instance = Calendar.getInstance();
            hashMap.put("tz", String.valueOf(instance.get(15) + instance.get(16)));
            C10698h a = C10698h.m35136a();
            HashMap hashMap2 = new HashMap();
            if (a.f32654d && a.f32651a != null) {
                hashMap2.put("u-s-id", a.f32651a);
            }
            hashMap.putAll(hashMap2);
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in getting UID info; ").append(e.getMessage());
        }
        return hashMap;
    }
}
