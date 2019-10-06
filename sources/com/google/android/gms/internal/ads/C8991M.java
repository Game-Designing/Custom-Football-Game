package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.M */
final class C8991M implements zzaho<zzbgz> {
    C8991M() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        WindowManager windowManager = (WindowManager) zzbgz.getContext().getSystemService("window");
        zzk.zzlg();
        View view = (View) zzbgz;
        DisplayMetrics a = zzaxi.m26100a(windowManager);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbgz.mo28729a("locationReady", (Map<String, ?>) hashMap);
        zzbad.m26359d("GET LOCATION COMPILED");
    }
}
