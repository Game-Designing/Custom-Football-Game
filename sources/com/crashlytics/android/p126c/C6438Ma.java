package com.crashlytics.android.p126c;

import com.crashlytics.android.p126c.C6424Ia.C6425a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.Ma */
/* compiled from: SessionReport */
class C6438Ma implements C6424Ia {

    /* renamed from: a */
    private final File f11538a;

    /* renamed from: b */
    private final File[] f11539b;

    /* renamed from: c */
    private final Map<String, String> f11540c;

    public C6438Ma(File file) {
        this(file, Collections.emptyMap());
    }

    public C6438Ma(File file, Map<String, String> customHeaders) {
        this.f11538a = file;
        this.f11539b = new File[]{file};
        this.f11540c = new HashMap(customHeaders);
        if (this.f11538a.length() == 0) {
            this.f11540c.putAll(C6427Ja.f11519a);
        }
    }

    public File getFile() {
        return this.f11538a;
    }

    public File[] getFiles() {
        return this.f11539b;
    }

    public String getFileName() {
        return getFile().getName();
    }

    /* renamed from: b */
    public String mo19433b() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    /* renamed from: a */
    public Map<String, String> mo19432a() {
        return Collections.unmodifiableMap(this.f11540c);
    }

    public void remove() {
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Removing report at ");
        sb.append(this.f11538a.getPath());
        e.mo43326c("CrashlyticsCore", sb.toString());
        this.f11538a.delete();
    }

    public C6425a getType() {
        return C6425a.JAVA;
    }
}
