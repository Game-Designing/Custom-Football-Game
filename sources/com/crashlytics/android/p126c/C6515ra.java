package com.crashlytics.android.p126c;

import com.crashlytics.android.p126c.C6424Ia.C6425a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.ra */
/* compiled from: InvalidSessionReport */
class C6515ra implements C6424Ia {

    /* renamed from: a */
    private final File[] f11698a;

    /* renamed from: b */
    private final Map<String, String> f11699b = new HashMap(C6427Ja.f11519a);

    /* renamed from: c */
    private final String f11700c;

    public C6515ra(String identifier, File[] files) {
        this.f11698a = files;
        this.f11700c = identifier;
    }

    public String getFileName() {
        return this.f11698a[0].getName();
    }

    /* renamed from: b */
    public String mo19433b() {
        return this.f11700c;
    }

    public File getFile() {
        return this.f11698a[0];
    }

    public File[] getFiles() {
        return this.f11698a;
    }

    /* renamed from: a */
    public Map<String, String> mo19432a() {
        return Collections.unmodifiableMap(this.f11699b);
    }

    public void remove() {
        File[] fileArr;
        for (File file : this.f11698a) {
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Removing invalid report file at ");
            sb.append(file.getPath());
            e.mo43326c("CrashlyticsCore", sb.toString());
            file.delete();
        }
    }

    public C6425a getType() {
        return C6425a.JAVA;
    }
}
