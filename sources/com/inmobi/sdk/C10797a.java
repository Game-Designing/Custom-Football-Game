package com.inmobi.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import com.inmobi.commons.core.p221d.C10655a;
import com.inmobi.commons.core.p221d.C10657c;
import com.inmobi.commons.core.utilities.p225b.C10697g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.inmobi.sdk.a */
/* compiled from: FileManager */
final class C10797a {
    @SuppressLint({"SdCardPath"})
    /* renamed from: a */
    public static boolean m35369a(Context context) {
        String str;
        String str2;
        String str3;
        String str4 = "inmobiAppAnalyticsSession";
        String str5 = "IMAdTrackerStatusUpload";
        List asList = Arrays.asList(new String[]{"carbpreference", "IMAdMLtvpRuleCache", str4, "aeskeygenerate", "impref", str5, "IMAdMMediationCache", "inmobiAppAnalyticsAppId", str4, "inmobisdkaid", str5, "testAppPref"});
        int i = 0;
        while (true) {
            str = ".xml";
            str2 = "/shared_prefs/";
            str3 = "/data/data/";
            if (i >= asList.size()) {
                break;
            }
            StringBuilder sb = new StringBuilder(str3);
            sb.append(context.getPackageName());
            sb.append(str2);
            sb.append((String) asList.get(i));
            sb.append(str);
            File file = new File(sb.toString());
            if (file.exists()) {
                file.delete();
            }
            i++;
        }
        List asList2 = Arrays.asList(new String[]{C10657c.m34973a("carb_store"), C10657c.m34973a("config_store"), C10657c.m34973a("aes_key_store"), C10657c.m34973a("mraid_js_store"), C10697g.m35119a()});
        for (int i2 = 0; i2 < asList2.size(); i2++) {
            StringBuilder sb2 = new StringBuilder(str3);
            sb2.append(context.getPackageName());
            sb2.append(str2);
            sb2.append((String) asList2.get(i2));
            sb2.append(str);
            File file2 = new File(sb2.toString());
            if (file2.exists()) {
                file2.delete();
            }
        }
        List asList3 = Arrays.asList(new String[]{"inmobi.cache", "inmobi.cache.data", "inmobi.cache.data.events.number", "inmobi.cache.data.events.timestamp"});
        for (int i3 = 0; i3 < asList3.size(); i3++) {
            if (context.getCacheDir() != null) {
                File file3 = new File(context.getCacheDir(), (String) asList3.get(i3));
                if (file3.exists()) {
                    file3.delete();
                }
            }
        }
        List asList4 = Arrays.asList(new String[]{"eventlog", "imai_click_events"});
        for (int i4 = 0; i4 < asList4.size(); i4++) {
            String str6 = "data";
            if (context.getDir(str6, 0) != null) {
                File file4 = new File(context.getDir(str6, 0), (String) asList4.get(i4));
                if (file4.exists()) {
                    file4.delete();
                }
            }
        }
        return m35371b(context).size() != 0;
    }

    /* renamed from: a */
    private static boolean m35370a(Context context, String str) {
        File databasePath = context.getDatabasePath(str);
        return databasePath == null || !databasePath.exists() || context.deleteDatabase(str);
    }

    /* renamed from: b */
    public static List<String> m35371b(Context context) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.add("adcache.db");
        hashSet.add("appengage.db");
        hashSet.add("im.db");
        hashSet.add("ltvp.db");
        hashSet.add("analytics.db");
        hashSet.add("com.im.db");
        String[] databaseList = context.databaseList();
        if (databaseList != null && databaseList.length > 0) {
            for (String str : databaseList) {
                if (hashSet.contains(str) && !m35370a(context, str)) {
                    arrayList.add(str);
                } else if (str.matches("com\\.im_([0-9]+\\.){3}db") && !str.equals(C10655a.f32486a) && !m35370a(context, str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }
}
