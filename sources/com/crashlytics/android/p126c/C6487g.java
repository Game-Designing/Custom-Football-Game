package com.crashlytics.android.p126c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* renamed from: com.crashlytics.android.c.g */
/* compiled from: ClsFileOutputStream */
class C6487g extends FileOutputStream {

    /* renamed from: a */
    public static final FilenameFilter f11648a = new C6485f();

    /* renamed from: b */
    private final String f11649b;

    /* renamed from: c */
    private File f11650c;

    /* renamed from: d */
    private File f11651d;

    /* renamed from: e */
    private boolean f11652e = false;

    public C6487g(File dir, String fileRoot) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append(fileRoot);
        String str = ".cls_temp";
        sb.append(str);
        super(new File(dir, sb.toString()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dir);
        sb2.append(File.separator);
        sb2.append(fileRoot);
        this.f11649b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f11649b);
        sb3.append(str);
        this.f11650c = new File(sb3.toString());
    }

    public synchronized void close() throws IOException {
        if (!this.f11652e) {
            this.f11652e = true;
            super.flush();
            super.close();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11649b);
            sb.append(".cls");
            File complete = new File(sb.toString());
            if (this.f11650c.renameTo(complete)) {
                this.f11650c = null;
                this.f11651d = complete;
                return;
            }
            String reason = "";
            if (complete.exists()) {
                reason = " (target already exists)";
            } else if (!this.f11650c.exists()) {
                reason = " (source does not exist)";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not rename temp file: ");
            sb2.append(this.f11650c);
            sb2.append(" -> ");
            sb2.append(complete);
            sb2.append(reason);
            throw new IOException(sb2.toString());
        }
    }

    /* renamed from: a */
    public void mo19545a() throws IOException {
        if (!this.f11652e) {
            this.f11652e = true;
            super.flush();
            super.close();
        }
    }
}
