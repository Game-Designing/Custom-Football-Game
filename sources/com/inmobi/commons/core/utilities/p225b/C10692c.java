package com.inmobi.commons.core.utilities.p225b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.utilities.b.c */
/* compiled from: DisplayInfo */
public class C10692c {

    /* renamed from: a */
    private static final String f32626a = C10692c.class.getSimpleName();

    /* renamed from: a */
    public static int m35103a(int i) {
        return Math.round(((float) i) * m35104a().f32629c);
    }

    /* renamed from: a */
    public static C10693d m35104a() {
        Context b = C10619a.m34839b();
        if (b == null) {
            return new C10693d(0, 0, 2.0f);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        return new C10693d(Math.round(((float) displayMetrics.widthPixels) / f), Math.round(((float) displayMetrics.heightPixels) / f), f);
    }

    /* renamed from: b */
    public static int m35106b(int i) {
        return Math.round(((float) i) / m35104a().f32629c);
    }

    /* renamed from: b */
    public static int m35105b() {
        Context b = C10619a.m34839b();
        if (b == null) {
            return 1;
        }
        int rotation = ((WindowManager) b.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = b.getResources().getConfiguration().orientation;
        if (i != 1) {
            if (i != 2) {
                return 1;
            }
            if (rotation == 0 || rotation == 1) {
                return 3;
            }
            return 4;
        } else if (rotation == 1 || rotation == 2) {
            return 2;
        } else {
            return 1;
        }
    }

    /* renamed from: c */
    public static Map<String, String> m35107c() {
        String str;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("d-device-screen-density", String.valueOf(m35104a().f32629c));
            C10693d a = m35104a();
            StringBuilder sb = new StringBuilder();
            sb.append(a.f32627a);
            sb.append("X");
            sb.append(a.f32628b);
            hashMap.put("d-device-screen-size", sb.toString());
            String str2 = "d-density-dependent-screen-size";
            Context b = C10619a.m34839b();
            if (b == null) {
                str = "0x0";
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                str = sb2.toString();
            }
            hashMap.put(str2, str);
            hashMap.put("d-orientation", String.valueOf(m35105b()));
            hashMap.put("d-textsize", String.valueOf(new TextView(C10619a.m34839b()).getTextSize()));
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in getting display info; ").append(e.getMessage());
        }
        return hashMap;
    }
}
