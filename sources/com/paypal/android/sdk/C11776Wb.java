package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.paypal.android.sdk.Wb */
public class C11776Wb {

    /* renamed from: a */
    private static final String f37052a = C11776Wb.class.getSimpleName();

    /* renamed from: b */
    private static final Map f37053b = new HashMap();

    /* renamed from: c */
    private static final Set f37054c = new HashSet();

    /* renamed from: d */
    private static /* synthetic */ boolean f37055d = (!C11776Wb.class.desiredAssertionStatus());

    /* renamed from: e */
    private Map f37056e = new LinkedHashMap();

    /* renamed from: f */
    private C11857oc f37057f;

    /* renamed from: g */
    private Class f37058g;

    static {
        f37053b.put("zh_CN", "zh-Hans");
        f37053b.put("zh_TW", "zh-Hant_TW");
        f37053b.put("zh_HK", "zh-Hant");
        String str = "en_GB";
        f37053b.put("en_UK", str);
        f37053b.put("en_IE", str);
        String str2 = "he";
        f37053b.put("iw_IL", str2);
        f37053b.put("no", "nb");
        f37054c.add(str2);
        f37054c.add("ar");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.paypal.android.sdk.oc>, for r4v0, types: [java.util.List, java.util.List<com.paypal.android.sdk.oc>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C11776Wb(java.lang.Class r3, java.util.List<com.paypal.android.sdk.C11857oc> r4) {
        /*
            r2 = this;
            r2.<init>()
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r2.f37056e = r0
            r2.f37058g = r3
            java.util.Iterator r3 = r4.iterator()
        L_0x0010:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r3.next()
            com.paypal.android.sdk.oc r4 = (com.paypal.android.sdk.C11857oc) r4
            java.lang.String r0 = r4.mo38522a()
            if (r0 == 0) goto L_0x004c
            java.util.Map r1 = r2.f37056e
            boolean r1 = r1.containsKey(r0)
            if (r1 != 0) goto L_0x0033
            java.util.Map r1 = r2.f37056e
            r1.put(r0, r4)
            r2.m38998b(r0)
            goto L_0x0010
        L_0x0033:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "Locale "
            r4.<init>(r1)
            r4.append(r0)
            java.lang.String r0 = " already added"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x004c:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = "Null localeName"
            r3.<init>(r4)
            throw r3
        L_0x0054:
            r3 = 0
            r2.mo38646a(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C11776Wb.<init>(java.lang.Class, java.util.List):void");
    }

    /* renamed from: b */
    private void m38998b(String str) {
        Enum[] enumArr;
        C11857oc ocVar = (C11857oc) this.f37056e.get(str);
        ArrayList arrayList = new ArrayList();
        new StringBuilder("Checking locale ").append(str);
        for (Enum enumR : (Enum[]) this.f37058g.getEnumConstants()) {
            StringBuilder sb = new StringBuilder("[");
            sb.append(str);
            sb.append(",");
            sb.append(enumR);
            sb.append("]");
            String sb2 = sb.toString();
            if (ocVar.mo38523a(enumR, null) == null) {
                StringBuilder sb3 = new StringBuilder("Missing ");
                sb3.append(sb2);
                arrayList.add(sb3.toString());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* renamed from: c */
    private C11857oc m38999c(String str) {
        String str2;
        C11857oc ocVar = null;
        if (str == null || str.length() < 2) {
            return null;
        }
        if (f37053b.containsKey(str)) {
            String str3 = (String) f37053b.get(str);
            C11857oc ocVar2 = (C11857oc) this.f37056e.get(str3);
            StringBuilder sb = new StringBuilder("Overriding locale specifier ");
            sb.append(str);
            sb.append(" with ");
            sb.append(str3);
            ocVar = ocVar2;
        }
        if (ocVar == null) {
            String str4 = "_";
            if (str.contains(str4)) {
                str2 = str;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str4);
                sb2.append(Locale.getDefault().getCountry());
                str2 = sb2.toString();
            }
            ocVar = (C11857oc) this.f37056e.get(str2);
        }
        if (ocVar == null) {
            ocVar = (C11857oc) this.f37056e.get(str);
        }
        if (ocVar != null) {
            return ocVar;
        }
        return (C11857oc) this.f37056e.get(str.substring(0, 2));
    }

    /* renamed from: a */
    public final String mo38643a() {
        return this.f37057f.mo38522a();
    }

    /* renamed from: a */
    public final String mo38644a(Enum enumR) {
        C11857oc ocVar = this.f37057f;
        String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.US);
        String a = ocVar.mo38523a(enumR, upperCase);
        if (a == null) {
            StringBuilder sb = new StringBuilder("Missing localized string for [");
            sb.append(this.f37057f.mo38522a());
            sb.append(",Key.");
            sb.append(enumR.toString());
            sb.append("]");
            a = ((C11857oc) this.f37056e.get("en")).mo38523a(enumR, upperCase);
        }
        if (a != null) {
            return a;
        }
        StringBuilder sb2 = new StringBuilder("Missing localized string for [en,Key.");
        sb2.append(enumR.toString());
        sb2.append("], so defaulting to keyname");
        return enumR.toString();
    }

    /* renamed from: a */
    public final String mo38645a(String str, Enum enumR) {
        String a = this.f37057f.mo38524a(str);
        if (a != null) {
            return a;
        }
        return String.format(mo38644a(enumR), new Object[]{str});
    }

    /* renamed from: a */
    public final void mo38646a(String str) {
        StringBuilder sb = new StringBuilder("setLanguage(");
        sb.append(str);
        sb.append(")");
        C11857oc ocVar = null;
        this.f37057f = null;
        if (str != null) {
            ocVar = m38999c(str);
        }
        if (ocVar == null) {
            String locale = Locale.getDefault().toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" not found.  Attempting to look for ");
            sb2.append(locale);
            ocVar = m38999c(locale);
        }
        if (ocVar == null) {
            ocVar = (C11857oc) this.f37056e.get("en");
        }
        if (f37055d || ocVar != null) {
            this.f37057f = ocVar;
            if (f37055d || this.f37057f != null) {
                new StringBuilder("setting locale to:").append(this.f37057f.mo38522a());
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
}
