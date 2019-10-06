package com.crashlytics.android.p126c;

import com.crashlytics.android.p126c.C6424Ia.C6425a;
import java.io.File;
import java.util.Map;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.Aa */
/* compiled from: NativeSessionReport */
class C6407Aa implements C6424Ia {

    /* renamed from: a */
    private final File f11469a;

    public C6407Aa(File reportDirectory) {
        this.f11469a = reportDirectory;
    }

    public void remove() {
        File[] files = getFiles();
        int length = files.length;
        int i = 0;
        while (true) {
            String str = "CrashlyticsCore";
            if (i < length) {
                File file = files[i];
                C13929o e = C13920f.m44245e();
                StringBuilder sb = new StringBuilder();
                sb.append("Removing native report file at ");
                sb.append(file.getPath());
                e.mo43326c(str, sb.toString());
                file.delete();
                i++;
            } else {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Removing native report directory at ");
                sb2.append(this.f11469a);
                e2.mo43326c(str, sb2.toString());
                this.f11469a.delete();
                return;
            }
        }
    }

    public String getFileName() {
        return null;
    }

    /* renamed from: b */
    public String mo19433b() {
        return this.f11469a.getName();
    }

    public File getFile() {
        return null;
    }

    public File[] getFiles() {
        return this.f11469a.listFiles();
    }

    /* renamed from: a */
    public Map<String, String> mo19432a() {
        return null;
    }

    public C6425a getType() {
        return C6425a.NATIVE;
    }
}
