package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.exoplayer2.util.f */
/* compiled from: AtomicFile */
public final class C8515f {

    /* renamed from: a */
    private final File f18808a;

    /* renamed from: b */
    private final File f18809b;

    /* renamed from: com.google.android.exoplayer2.util.f$a */
    /* compiled from: AtomicFile */
    private static final class C8516a extends OutputStream {

        /* renamed from: a */
        private final FileOutputStream f18810a;

        /* renamed from: b */
        private boolean f18811b = false;

        public C8516a(File file) throws FileNotFoundException {
            this.f18810a = new FileOutputStream(file);
        }

        public void close() throws IOException {
            if (!this.f18811b) {
                this.f18811b = true;
                flush();
                try {
                    this.f18810a.getFD().sync();
                } catch (IOException e) {
                    C8526n.m20532b("AtomicFile", "Failed to sync file descriptor:", e);
                }
                this.f18810a.close();
            }
        }

        public void flush() throws IOException {
            this.f18810a.flush();
        }

        public void write(int b) throws IOException {
            this.f18810a.write(b);
        }

        public void write(byte[] b) throws IOException {
            this.f18810a.write(b);
        }

        public void write(byte[] b, int off, int len) throws IOException {
            this.f18810a.write(b, off, len);
        }
    }

    public C8515f(File baseName) {
        this.f18808a = baseName;
        StringBuilder sb = new StringBuilder();
        sb.append(baseName.getPath());
        sb.append(".bak");
        this.f18809b = new File(sb.toString());
    }

    /* renamed from: a */
    public void mo26068a() {
        this.f18808a.delete();
        this.f18809b.delete();
    }

    /* renamed from: c */
    public OutputStream mo26071c() throws IOException {
        if (this.f18808a.exists()) {
            if (this.f18809b.exists()) {
                this.f18808a.delete();
            } else if (!this.f18808a.renameTo(this.f18809b)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't rename file ");
                sb.append(this.f18808a);
                sb.append(" to backup file ");
                sb.append(this.f18809b);
                C8526n.m20534d("AtomicFile", sb.toString());
            }
        }
        try {
            return new C8516a(this.f18808a);
        } catch (FileNotFoundException e) {
            File parent = this.f18808a.getParentFile();
            if (parent == null || !parent.mkdirs()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Couldn't create directory ");
                sb2.append(this.f18808a);
                throw new IOException(sb2.toString(), e);
            }
            try {
                return new C8516a(this.f18808a);
            } catch (FileNotFoundException e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Couldn't create ");
                sb3.append(this.f18808a);
                throw new IOException(sb3.toString(), e2);
            }
        }
    }

    /* renamed from: a */
    public void mo26069a(OutputStream str) throws IOException {
        str.close();
        this.f18809b.delete();
    }

    /* renamed from: b */
    public InputStream mo26070b() throws FileNotFoundException {
        m20492d();
        return new FileInputStream(this.f18808a);
    }

    /* renamed from: d */
    private void m20492d() {
        if (this.f18809b.exists()) {
            this.f18808a.delete();
            this.f18809b.renameTo(this.f18808a);
        }
    }
}
