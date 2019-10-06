package com.flurry.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.flurry.sdk.Hd */
public class C7392Hd {

    /* renamed from: a */
    private static final String f14487a = C7392Hd.class.getCanonicalName();

    /* renamed from: b */
    private static final char[] f14488b = {'F', 'C', 'B', 'M'};

    /* renamed from: c */
    private static final String f14489c = new String(f14488b);

    /* renamed from: d */
    private static final int f14490d;

    /* renamed from: e */
    private static final int f14491e;

    /* renamed from: f */
    private static final int f14492f;

    /* renamed from: g */
    private static final int f14493g;

    /* renamed from: h */
    private short f14494h;

    /* renamed from: i */
    private boolean f14495i;

    /* renamed from: j */
    public ByteBuffer f14496j;

    static {
        char[] cArr = f14488b;
        f14490d = (cArr.length * 2) + 2 + 1 + 105984;
        int length = cArr.length * 2;
        f14491e = length;
        int i = length + 2;
        f14492f = i;
        f14493g = i + 1;
    }

    public C7392Hd() {
        this.f14496j = ByteBuffer.allocateDirect(f14490d);
        this.f14496j.asCharBuffer().put(f14488b);
    }

    public C7392Hd(File file) {
        int i;
        boolean z = true;
        C7513ec.m16639a(3, f14487a, String.format(Locale.getDefault(), "Loading crash breadcrumbs from %s", new Object[]{file.getAbsolutePath()}));
        this.f14496j = ByteBuffer.allocate(f14490d);
        if (file.length() != ((long) this.f14496j.capacity())) {
            C7513ec.m16639a(6, f14487a, String.format(Locale.getDefault(), "Crash breadcrumbs invalid file length %s != %s", new Object[]{Long.valueOf(file.length()), Integer.valueOf(this.f14496j.capacity())}));
            this.f14496j = null;
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            try {
                i = channel.read(this.f14496j);
            } catch (IOException e) {
                C7513ec.m16639a(6, f14487a, "Issue reading breadcrumbs from file.");
                i = 0;
            }
            C7354Ad.m16261a((Closeable) channel);
            C7354Ad.m16261a((Closeable) fileInputStream);
            if (i != this.f14496j.capacity()) {
                C7513ec.m16639a(6, f14487a, String.format(Locale.getDefault(), "YCrashBreadcrumbs unexpected read size %s != %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f14496j.capacity())}));
                this.f14496j = null;
                return;
            }
            this.f14496j.position(0);
            String obj = this.f14496j.asCharBuffer().limit(f14488b.length).toString();
            if (!obj.equals(f14489c)) {
                C7513ec.m16639a(6, f14487a, String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid magic string: '%s'", new Object[]{obj}));
                this.f14496j = null;
                return;
            }
            this.f14494h = this.f14496j.getShort(f14491e);
            short s = this.f14494h;
            if (s < 0 || s >= 207) {
                C7513ec.m16639a(6, f14487a, String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid index: '%s'", new Object[]{Short.valueOf(this.f14494h)}));
                this.f14496j = null;
                return;
            }
            if (this.f14496j.get(f14492f) != 1) {
                z = false;
            }
            this.f14495i = z;
        } catch (FileNotFoundException e2) {
            C7513ec.m16639a(6, f14487a, "Issue reading breadcrumbs file.");
            this.f14496j = null;
        }
    }

    /* renamed from: a */
    private C7386Gd m16366a(int i) {
        this.f14496j.position(f14493g + (i * 512));
        return new C7386Gd(this.f14496j.asCharBuffer().limit(this.f14496j.getInt()).toString(), this.f14496j.getLong());
    }

    /* renamed from: a */
    public final List<C7386Gd> mo23834a() {
        ArrayList arrayList = new ArrayList();
        if (this.f14496j == null) {
            return arrayList;
        }
        if (this.f14495i) {
            for (int i = this.f14494h; i < 207; i++) {
                arrayList.add(m16366a(i));
            }
        }
        for (int i2 = 0; i2 < this.f14494h; i2++) {
            arrayList.add(m16366a(i2));
        }
        return arrayList;
    }

    public synchronized String toString() {
        StringBuilder sb;
        short s = this.f14496j == null ? 0 : this.f14495i ? 207 : this.f14494h;
        sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Total number of breadcrumbs: ");
        sb2.append(s);
        sb2.append("\n");
        sb.append(sb2.toString());
        for (C7386Gd gd : mo23834a()) {
            sb.append(gd.toString());
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static int m16367b() {
        return 1;
    }
}
