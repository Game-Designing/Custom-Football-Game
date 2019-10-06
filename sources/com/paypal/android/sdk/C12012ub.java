package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.paypal.android.sdk.ub */
public class C12012ub {

    /* renamed from: a */
    private static final String f37785a = C12012ub.class.getSimpleName();

    /* renamed from: b */
    private static final Map f37786b;

    /* renamed from: c */
    private static final Set f37787c;

    static {
        HashMap hashMap = new HashMap();
        f37786b = hashMap;
        hashMap.put("c14", "erpg");
        f37786b.put("c25", "page");
        f37786b.put("c26", "link");
        f37786b.put("c27", "pgln");
        f37786b.put("c29", "eccd");
        f37786b.put("c35", "lgin");
        String str = "vers";
        f37786b.put(str, str);
        f37786b.put("c50", "rsta");
        f37786b.put("gn", "pgrp");
        f37786b.put("v49", "mapv");
        f37786b.put("v51", "mcar");
        f37786b.put("v52", "mosv");
        f37786b.put("v53", "mdvs");
        String str2 = "clid";
        f37786b.put(str2, str2);
        String str3 = "apid";
        f37786b.put(str3, str3);
        String str4 = "calc";
        f37786b.put(str4, str4);
        String str5 = "e";
        f37786b.put(str5, str5);
        String str6 = "t";
        f37786b.put(str6, str6);
        String str7 = "g";
        f37786b.put(str7, str7);
        String str8 = "srce";
        f37786b.put(str8, str8);
        String str9 = "vid";
        f37786b.put(str9, str9);
        String str10 = "bchn";
        f37786b.put(str10, str10);
        String str11 = "adte";
        f37786b.put(str11, str11);
        String str12 = "sv";
        f37786b.put(str12, str12);
        String str13 = "dsid";
        f37786b.put(str13, str13);
        String str14 = "bzsr";
        f37786b.put(str14, str14);
        String str15 = "prid";
        f37786b.put(str15, str15);
        HashSet hashSet = new HashSet();
        f37787c = hashSet;
        hashSet.add("v25");
        f37787c.add("v31");
        f37787c.add("c37");
    }

    /* renamed from: a */
    public static C11774W m39749a(C11774W w) {
        StringBuilder sb;
        String str;
        Map map = w.f37048b;
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (!C11723Fa.m38818a((CharSequence) str2)) {
                if (f37787c.contains(str2)) {
                    sb = new StringBuilder("SC key ");
                    sb.append(str2);
                    str = " not used in FPTI, skipping";
                } else if (!f37786b.containsKey(str2)) {
                    sb = new StringBuilder("No mapping for SC key ");
                    sb.append(str2);
                    str = ", skipping";
                } else {
                    String str3 = (String) f37786b.get(str2);
                    if (str3 != null) {
                        hashMap.put(str3, map.get(str2));
                    }
                }
                sb.append(str);
            }
        }
        return new C11774W(w.f37047a, hashMap);
    }
}
