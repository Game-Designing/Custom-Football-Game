package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.Sd */
public class C7454Sd {

    /* renamed from: a */
    private static final String f14657a = C7454Sd.class.getSimpleName();

    /* renamed from: b */
    private final C7459Td f14658b;

    /* renamed from: c */
    private final File f14659c;

    /* renamed from: d */
    boolean f14660d;

    /* renamed from: e */
    private String f14661e;

    public C7454Sd() {
        this(C7379Fb.m16300a().f14432d);
    }

    public C7454Sd(Context context) {
        this.f14658b = new C7459Td();
        this.f14659c = context.getFileStreamPath(".flurryinstallreceiver.");
        String str = f14657a;
        StringBuilder sb = new StringBuilder("Referrer file name if it exists:  ");
        sb.append(this.f14659c);
        C7513ec.m16639a(3, str, sb.toString());
    }

    /* renamed from: a */
    public final synchronized Map<String, List<String>> mo23896a() {
        m16495c();
        return C7459Td.m16499a(this.f14661e);
    }

    /* renamed from: c */
    private void m16495c() {
        if (!this.f14660d) {
            this.f14660d = true;
            String str = f14657a;
            StringBuilder sb = new StringBuilder("Loading referrer info from file: ");
            sb.append(this.f14659c.getAbsolutePath());
            C7513ec.m16639a(4, str, sb.toString());
            String c = C7635zd.m16875c(this.f14659c);
            C7513ec.m16641a(f14657a, "Referrer file contents: ".concat(String.valueOf(c)));
            m16494a(c);
        }
    }

    /* renamed from: a */
    private void m16494a(String str) {
        if (str != null) {
            this.f14661e = str;
        }
    }

    /* renamed from: b */
    public final synchronized String mo23897b() {
        m16495c();
        return this.f14661e;
    }
}
