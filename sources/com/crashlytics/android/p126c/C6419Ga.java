package com.crashlytics.android.p126c;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13832C;
import p024io.fabric.sdk.android.p348a.p350b.C13832C.C13835c;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: com.crashlytics.android.c.Ga */
/* compiled from: QueueFileLogStore */
class C6419Ga implements C6513qa {

    /* renamed from: a */
    private final File f11492a;

    /* renamed from: b */
    private final int f11493b;

    /* renamed from: c */
    private C13832C f11494c;

    /* renamed from: com.crashlytics.android.c.Ga$a */
    /* compiled from: QueueFileLogStore */
    public class C6420a {

        /* renamed from: a */
        public final byte[] f11495a;

        /* renamed from: b */
        public final int f11496b;

        public C6420a(byte[] bytes, int offset) {
            this.f11495a = bytes;
            this.f11496b = offset;
        }
    }

    public C6419Ga(File workingFile, int maxLogSize) {
        this.f11492a = workingFile;
        this.f11493b = maxLogSize;
    }

    /* renamed from: a */
    public void mo19448a(long timestamp, String msg) {
        m12438f();
        m12436b(timestamp, msg);
    }

    /* renamed from: b */
    public C6481d mo19449b() {
        C6420a logBytes = m12437e();
        if (logBytes == null) {
            return null;
        }
        return C6481d.m12661a(logBytes.f11495a, 0, logBytes.f11496b);
    }

    /* renamed from: c */
    public byte[] mo19450c() {
        C6420a logBytes = m12437e();
        if (logBytes == null) {
            return null;
        }
        return logBytes.f11495a;
    }

    /* renamed from: e */
    private C6420a m12437e() {
        if (!this.f11492a.exists()) {
            return null;
        }
        m12438f();
        C13832C c = this.f11494c;
        if (c == null) {
            return null;
        }
        int[] offsetHolder = {0};
        byte[] logBytes = new byte[c.mo43211d()];
        try {
            this.f11494c.mo43204a((C13835c) new C6417Fa(this, logBytes, offsetHolder));
        } catch (IOException e) {
            C13920f.m44245e().mo43325b("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return new C6420a(logBytes, offsetHolder[0]);
    }

    /* renamed from: a */
    public void mo19447a() {
        C13852l.m44036a((Closeable) this.f11494c, "There was a problem closing the Crashlytics log file.");
        this.f11494c = null;
    }

    /* renamed from: d */
    public void mo19451d() {
        mo19447a();
        this.f11492a.delete();
    }

    /* renamed from: f */
    private void m12438f() {
        if (this.f11494c == null) {
            try {
                this.f11494c = new C13832C(this.f11492a);
            } catch (IOException e) {
                C13929o e2 = C13920f.m44245e();
                StringBuilder sb = new StringBuilder();
                sb.append("Could not open log file: ");
                sb.append(this.f11492a);
                e2.mo43325b("CrashlyticsCore", sb.toString(), e);
            }
        }
    }

    /* renamed from: b */
    private void m12436b(long timestamp, String msg) {
        String str = " ";
        if (this.f11494c != null) {
            if (msg == null) {
                msg = "null";
            }
            try {
                int quarterMaxLogSize = this.f11493b / 4;
                if (msg.length() > quarterMaxLogSize) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("...");
                    sb.append(msg.substring(msg.length() - quarterMaxLogSize));
                    msg = sb.toString();
                }
                this.f11494c.mo43205a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(timestamp), msg.replaceAll("\r", str).replaceAll("\n", str)}).getBytes("UTF-8"));
                while (!this.f11494c.mo43208b() && this.f11494c.mo43211d() > this.f11493b) {
                    this.f11494c.mo43209c();
                }
            } catch (IOException e) {
                C13920f.m44245e().mo43325b("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
