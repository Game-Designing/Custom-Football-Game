package com.crashlytics.android.p126c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.Ea */
/* compiled from: ProcMapEntryParser */
final class C6415Ea {

    /* renamed from: a */
    private static final Pattern f11485a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    /* renamed from: a */
    public static C6413Da m12433a(String mapEntry) {
        Matcher m = f11485a.matcher(mapEntry);
        if (!m.matches()) {
            return null;
        }
        try {
            long address = Long.valueOf(m.group(1), 16).longValue();
            C6413Da da = new C6413Da(address, Long.valueOf(m.group(2), 16).longValue() - address, m.group(3), m.group(4));
            return da;
        } catch (Exception e) {
            C13929o e2 = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not parse map entry: ");
            sb.append(mapEntry);
            e2.mo43326c("CrashlyticsCore", sb.toString());
            return null;
        }
    }
}
