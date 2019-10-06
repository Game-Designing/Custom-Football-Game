package com.fyber.inneractive.sdk.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.List;

/* renamed from: com.fyber.inneractive.sdk.util.u */
public final class C8031u extends C8006j {

    /* renamed from: com.fyber.inneractive.sdk.util.u$a */
    public enum C8032a {
        ;
        

        /* renamed from: a */
        public static final int f16372a = 0;

        /* renamed from: b */
        public static final int f16373b = 0;

        /* renamed from: c */
        public static final int f16374c = 0;

        static {
            f16372a = 1;
            f16373b = 2;
            f16374c = 3;
            f16375d = new int[]{f16372a, f16373b, f16374c};
        }
    }

    /* renamed from: a */
    public static int m18114a(Context context, String str) {
        int i = C8032a.f16372a;
        Uri d = m18118d(str);
        if (d != null) {
            List a = C8006j.m18068a(context, d);
            if (a != null && a.size() > 0) {
                Intent a2 = C8006j.m18067a(context, a, d, "com.android.vending");
                if (a2 != null) {
                    try {
                        context.startActivity(a2);
                        IAlog.m18021b("IAJavaUtil: openUrl: opening click url with google play");
                        return C8032a.f16374c;
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (str.startsWith("tel:") || str.startsWith("voicemail:") || str.startsWith("sms:") || str.startsWith("mailto:") || str.startsWith("geo:") || str.startsWith("google.streetview:")) {
                    Intent intent = new Intent("android.intent.action.VIEW", d);
                    intent.addFlags(268435456);
                    StringBuilder sb = new StringBuilder("Could not handle intent with URI: ");
                    sb.append(str);
                    sb.append(". Is this intent supported on your phone?");
                    try {
                        context.startActivity(intent);
                        return C8032a.f16374c;
                    } catch (Exception e3) {
                    }
                }
            } else if (!m18117c(str)) {
                StringBuilder sb2 = new StringBuilder("IAJavaUtil: Request to open unsupported url: '");
                sb2.append(str);
                sb2.append("' url will not open!");
                IAlog.m18021b(sb2.toString());
                return C8032a.f16372a;
            }
            i = m18116b(context, str);
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m18115a(String str) {
        Uri d = m18118d(str);
        if (d == null) {
            return false;
        }
        List a = C8006j.m18068a(C8006j.m18075n(), d);
        if (a == null || a.size() <= 0) {
            return m18117c(str);
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m18117c(String str) {
        return str.startsWith("http%3A%2F%2F") || str.startsWith("https%3A%2F%2F");
    }

    /* renamed from: d */
    private static Uri m18118d(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("IAJavaUtil: getValidUri: Invalid url ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        if ((r6 instanceof android.app.Activity) == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        r3.setFlags(268435456);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        r6.startActivity(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        r6 = new java.lang.StringBuilder(r0);
        r6.append(r7);
        com.fyber.inneractive.sdk.util.IAlog.m18021b(r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return com.fyber.inneractive.sdk.util.C8031u.C8032a.f16374c;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0004] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m18116b(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "IAJavaUtil - could not open a broswe for url: "
            int r1 = com.fyber.inneractive.sdk.util.C8031u.C8032a.f16372a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            java.lang.String r3 = "IAJavaUtil - valid url found: '"
            r2.<init>(r3)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            r2.append(r7)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            java.lang.String r3 = "' opening browser"
            r2.append(r3)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            java.lang.String r2 = r2.toString()     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r2)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r3 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
            java.lang.Class<com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity> r4 = com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.class
            r3.<init>(r6, r4)     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
            java.lang.String r4 = "extra_url"
            r3.putExtra(r4, r7)     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
            boolean r4 = r6 instanceof android.app.Activity     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
            if (r4 != 0) goto L_0x0030
            r3.setFlags(r2)     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
        L_0x0030:
            r6.startActivity(r3)     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
            int r1 = com.fyber.inneractive.sdk.util.C8031u.C8032a.f16373b     // Catch:{ ActivityNotFoundException -> 0x0037, Exception -> 0x0052 }
            goto L_0x0074
        L_0x0037:
            r3 = move-exception
            android.content.Intent r3 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            java.lang.String r4 = "android.intent.action.VIEW"
            android.net.Uri r5 = android.net.Uri.parse(r7)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            r3.<init>(r4, r5)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            boolean r4 = r6 instanceof android.app.Activity     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            if (r4 != 0) goto L_0x004b
            r3.setFlags(r2)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
        L_0x004b:
            r6.startActivity(r3)     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
            int r1 = com.fyber.inneractive.sdk.util.C8031u.C8032a.f16374c     // Catch:{ ActivityNotFoundException -> 0x0063, Exception -> 0x0052 }
        L_0x0051:
            goto L_0x0074
        L_0x0052:
            r6 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)
            goto L_0x0074
        L_0x0063:
            r6 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r6)
            goto L_0x0051
        L_0x0074:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8031u.m18116b(android.content.Context, java.lang.String):int");
    }
}
