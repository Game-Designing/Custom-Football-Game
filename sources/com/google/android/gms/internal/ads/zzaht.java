package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
public final class zzaht {

    /* renamed from: a */
    private final Context f24346a;

    /* renamed from: b */
    private final zzdh f24347b;

    /* renamed from: c */
    private final View f24348c;

    public zzaht(Context context, zzdh zzdh, View view) {
        this.f24346a = context;
        this.f24347b = zzdh;
        this.f24348c = view;
    }

    /* renamed from: a */
    private static Intent m25057a(Uri uri) {
        if (uri == null) {
            return null;
        }
        String str = "android.intent.action.VIEW";
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction(str);
        return intent;
    }

    @VisibleForTesting
    /* renamed from: a */
    private final ResolveInfo m25058a(Intent intent) {
        return m25059a(intent, new ArrayList<>());
    }

    @VisibleForTesting
    /* renamed from: a */
    private final ResolveInfo m25059a(Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = this.f24346a.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i++;
                }
            }
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        } catch (Throwable th) {
            zzk.zzlk().mo30168a(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
    }

    /* renamed from: a */
    private static Intent m25056a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c2  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent mo29739a(java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f24346a
            java.lang.String r1 = "activity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            java.lang.String r1 = "u"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            if (r2 == 0) goto L_0x001a
            return r3
        L_0x001a:
            android.content.Context r2 = r10.f24346a
            com.google.android.gms.internal.ads.zzdh r4 = r10.f24347b
            android.view.View r5 = r10.f24348c
            java.lang.String r1 = com.google.android.gms.internal.ads.zzahs.m25051a(r2, r4, r1, r5, r3)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r2 = "use_first_package"
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            java.lang.String r4 = "use_running_process"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            java.lang.String r5 = "use_custom_tabs"
            java.lang.Object r11 = r11.get(r5)
            java.lang.String r11 = (java.lang.String) r11
            boolean r11 = java.lang.Boolean.parseBoolean(r11)
            r5 = 0
            if (r11 != 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzacu.f23912Cd
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r11 = r6.mo29599a(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r11 = 0
            goto L_0x0066
        L_0x0065:
            r11 = 1
        L_0x0066:
            java.lang.String r6 = r1.getScheme()
            java.lang.String r7 = "http"
            boolean r6 = r7.equalsIgnoreCase(r6)
            java.lang.String r8 = "https"
            if (r6 == 0) goto L_0x0082
            android.net.Uri$Builder r3 = r1.buildUpon()
            android.net.Uri$Builder r3 = r3.scheme(r8)
            android.net.Uri r3 = r3.build()
            goto L_0x0098
        L_0x0082:
            java.lang.String r6 = r1.getScheme()
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0098
            android.net.Uri$Builder r3 = r1.buildUpon()
            android.net.Uri$Builder r3 = r3.scheme(r7)
            android.net.Uri r3 = r3.build()
        L_0x0098:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            android.content.Intent r1 = m25057a(r1)
            android.content.Intent r3 = m25057a(r3)
            if (r11 == 0) goto L_0x00b7
            com.google.android.gms.ads.internal.zzk.zzlg()
            android.content.Context r11 = r10.f24346a
            com.google.android.gms.internal.ads.zzaxi.m26122b(r11, r1)
            com.google.android.gms.ads.internal.zzk.zzlg()
            android.content.Context r11 = r10.f24346a
            com.google.android.gms.internal.ads.zzaxi.m26122b(r11, r3)
        L_0x00b7:
            android.content.pm.ResolveInfo r11 = r10.m25059a(r1, r6)
            if (r11 == 0) goto L_0x00c2
            android.content.Intent r11 = m25056a(r1, r11)
            return r11
        L_0x00c2:
            if (r3 == 0) goto L_0x00d7
            android.content.pm.ResolveInfo r11 = r10.m25058a(r3)
            if (r11 == 0) goto L_0x00d7
            android.content.Intent r11 = m25056a(r1, r11)
            android.content.pm.ResolveInfo r3 = r10.m25058a(r11)
            if (r3 == 0) goto L_0x00d7
            return r11
        L_0x00d7:
            int r11 = r6.size()
            if (r11 != 0) goto L_0x00de
            return r1
        L_0x00de:
            if (r4 == 0) goto L_0x011b
            if (r0 == 0) goto L_0x011b
            java.util.List r11 = r0.getRunningAppProcesses()
            if (r11 == 0) goto L_0x011b
            int r0 = r6.size()
            r3 = 0
        L_0x00ee:
            if (r3 >= r0) goto L_0x011b
            java.lang.Object r4 = r6.get(r3)
            int r3 = r3 + 1
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            java.util.Iterator r7 = r11.iterator()
        L_0x00fc:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x011a
            java.lang.Object r8 = r7.next()
            android.app.ActivityManager$RunningAppProcessInfo r8 = (android.app.ActivityManager.RunningAppProcessInfo) r8
            java.lang.String r8 = r8.processName
            android.content.pm.ActivityInfo r9 = r4.activityInfo
            java.lang.String r9 = r9.packageName
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0119
            android.content.Intent r11 = m25056a(r1, r4)
            return r11
        L_0x0119:
            goto L_0x00fc
        L_0x011a:
            goto L_0x00ee
        L_0x011b:
            if (r2 == 0) goto L_0x0128
            java.lang.Object r11 = r6.get(r5)
            android.content.pm.ResolveInfo r11 = (android.content.pm.ResolveInfo) r11
            android.content.Intent r11 = m25056a(r1, r11)
            return r11
        L_0x0128:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaht.mo29739a(java.util.Map):android.content.Intent");
    }
}
