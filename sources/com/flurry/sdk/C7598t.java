package com.flurry.sdk;

import android.location.Location;
import java.util.Map;

/* renamed from: com.flurry.sdk.t */
public class C7598t extends C7543jc {

    /* renamed from: b */
    private static final String f15076b = C7598t.class.getSimpleName();

    /* renamed from: a */
    public final String mo24019a(String str, Map<String, String> map) {
        String a = mo23965a(str);
        while (a != null) {
            if (C7543jc.m16705a("timestamp_epoch_millis", a)) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                C7513ec.m16639a(3, f15076b, "Replacing param timestamp_epoch_millis with: ".concat(String.valueOf(valueOf)));
                str = str.replace(a, C7354Ad.m16266c(valueOf));
            } else if (C7543jc.m16705a("session_duration_millis", a)) {
                C7475Xa.m16549a();
                String l = Long.toString(C7475Xa.m16553e());
                C7513ec.m16639a(3, f15076b, "Replacing param session_duration_millis with: ".concat(String.valueOf(l)));
                str = str.replace(a, C7354Ad.m16266c(l));
            } else if (C7543jc.m16705a("fg_timespent_millis", a)) {
                C7475Xa.m16549a();
                String l2 = Long.toString(C7475Xa.m16553e());
                C7513ec.m16639a(3, f15076b, "Replacing param fg_timespent_millis with: ".concat(String.valueOf(l2)));
                str = str.replace(a, C7354Ad.m16266c(l2));
            } else {
                String str2 = "";
                if (C7543jc.m16705a("install_referrer", a)) {
                    String b = new C7454Sd().mo23897b();
                    if (b == null) {
                        b = str2;
                    }
                    C7513ec.m16639a(3, f15076b, "Replacing param install_referrer with: ".concat(String.valueOf(b)));
                    str = str.replace(a, C7354Ad.m16266c(b));
                } else if (C7543jc.m16705a("geo_latitude", a)) {
                    Location f = C7547kb.m16712a().mo23968f();
                    if (f != null) {
                        int c = C7547kb.m16717c();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(C7354Ad.m16256a(f.getLatitude(), c));
                        str2 = sb.toString();
                    }
                    C7513ec.m16639a(3, f15076b, "Replacing param geo_latitude with: ".concat(String.valueOf(str2)));
                    str = str.replace(a, C7354Ad.m16266c(str2));
                } else if (C7543jc.m16705a("geo_longitude", a)) {
                    Location f2 = C7547kb.m16712a().mo23968f();
                    if (f2 != null) {
                        int c2 = C7547kb.m16717c();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(C7354Ad.m16256a(f2.getLongitude(), c2));
                        str2 = sb2.toString();
                    }
                    C7513ec.m16639a(3, f15076b, "Replacing param geo_longitude with: ".concat(String.valueOf(str2)));
                    str = str.replace(a, C7354Ad.m16266c(str2));
                } else if (C7543jc.m16705a("publisher_user_id", a)) {
                    String str3 = (String) C7602td.m16825a().mo24023a("UserId");
                    C7513ec.m16639a(3, f15076b, "Replacing param publisher_user_id with: ".concat(String.valueOf(str3)));
                    str = str.replace(a, C7354Ad.m16266c(str3));
                } else {
                    String str4 = "event_name";
                    if (!C7543jc.m16705a(str4, a)) {
                        String str5 = "event_time_millis";
                        if (!C7543jc.m16705a(str5, a)) {
                            C7513ec.m16639a(3, f15076b, "Unknown param: ".concat(String.valueOf(a)));
                            str = str.replace(a, str2);
                        } else if (map.containsKey(str5)) {
                            String str6 = f15076b;
                            StringBuilder sb3 = new StringBuilder("Replacing param event_time_millis with: ");
                            sb3.append((String) map.get(str5));
                            C7513ec.m16639a(3, str6, sb3.toString());
                            str = str.replace(a, C7354Ad.m16266c((String) map.get(str5)));
                        } else {
                            C7513ec.m16639a(3, f15076b, "Replacing param event_time_millis with empty string");
                            str = str.replace(a, str2);
                        }
                    } else if (map.containsKey(str4)) {
                        String str7 = f15076b;
                        StringBuilder sb4 = new StringBuilder("Replacing param event_name with: ");
                        sb4.append((String) map.get(str4));
                        C7513ec.m16639a(3, str7, sb4.toString());
                        str = str.replace(a, C7354Ad.m16266c((String) map.get(str4)));
                    } else {
                        C7513ec.m16639a(3, f15076b, "Replacing param event_name with empty string");
                        str = str.replace(a, str2);
                    }
                }
            }
            a = mo23965a(str);
        }
        return str;
    }
}
