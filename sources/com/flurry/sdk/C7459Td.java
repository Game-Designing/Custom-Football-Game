package com.flurry.sdk;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.Td */
public class C7459Td {

    /* renamed from: a */
    private static final String f14668a = C7459Td.class.getSimpleName();

    /* renamed from: a */
    public static Map<String, List<String>> m16499a(String str) {
        String str2;
        C7513ec.m16639a(3, f14668a, "Parsing referrer map");
        if (str == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("&");
        int length = split.length;
        int i = 0;
        while (true) {
            str2 = "=";
            if (i >= length) {
                break;
            }
            String str3 = split[i];
            String[] split2 = str3.split(str2);
            if (split2.length != 2) {
                String str4 = f14668a;
                StringBuilder sb = new StringBuilder("Invalid referrer Element: ");
                sb.append(str3);
                sb.append(" in referrer tag ");
                sb.append(str);
                C7513ec.m16639a(5, str4, sb.toString());
            } else {
                String decode = URLDecoder.decode(split2[0]);
                String decode2 = URLDecoder.decode(split2[1]);
                if (hashMap.get(decode) == null) {
                    hashMap.put(decode, new ArrayList());
                }
                ((List) hashMap.get(decode)).add(decode2);
            }
            i++;
        }
        for (Entry entry : hashMap.entrySet()) {
            String str5 = f14668a;
            StringBuilder sb2 = new StringBuilder("entry: ");
            sb2.append((String) entry.getKey());
            sb2.append(str2);
            sb2.append(entry.getValue());
            C7513ec.m16639a(3, str5, sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            sb3.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            sb3.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            sb3.append("Campaign Name is missing.\n");
        }
        if (sb3.length() > 0) {
            String str6 = f14668a;
            StringBuilder sb4 = new StringBuilder("Detected missing referrer keys : ");
            sb4.append(sb3.toString());
            C7513ec.m16639a(5, str6, sb4.toString());
        }
        return hashMap;
    }
}
