package com.bumptech.glide.p107h;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.bumptech.glide.h.d */
/* compiled from: ExceptionCatchingInputStream */
public class C6019d extends InputStream {

    /* renamed from: a */
    private static final Queue<C6019d> f10652a = C6026k.m11280a(0);

    /* renamed from: b */
    private InputStream f10653b;

    /* renamed from: c */
    private IOException f10654c;

    /* renamed from: a */
    public static C6019d m11245a(InputStream toWrap) {
        C6019d result;
        synchronized (f10652a) {
            result = (C6019d) f10652a.poll();
        }
        if (result == null) {
            result = new C6019d();
        }
        result.mo18803b(toWrap);
        return result;
    }

    C6019d() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18803b(InputStream toWrap) {
        this.f10653b = toWrap;
    }

    public int available() throws IOException {
        return this.f10653b.available();
    }

    public void close() throws IOException {
        this.f10653b.close();
    }

    public void mark(int readLimit) {
        this.f10653b.mark(readLimit);
    }

    public boolean markSupported() {
        return this.f10653b.markSupported();
    }

    public int read(byte[] buffer) {
        try {
            return this.f10653b.read(buffer);
        } catch (IOException e) {
            this.f10654c = e;
            return -1;
        }
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) {
        try {
            return this.f10653b.read(buffer, byteOffset, byteCount);
        } catch (IOException e) {
            this.f10654c = e;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f10653b.reset();
    }

    public long skip(long byteCount) {
        try {
            return this.f10653b.skip(byteCount);
        } catch (IOException e) {
            this.f10654c = e;
            return 0;
        }
    }

    public int read() {
        try {
            return this.f10653b.read();
        } catch (IOException e) {
            this.f10654c = e;
            return -1;
        }
    }

    /* renamed from: a */
    public IOException mo18800a() {
        return this.f10654c;
    }

    /* renamed from: b */
    public void mo18802b() {
        this.f10654c = null;
        this.f10653b = null;
        synchronized (f10652a) {
            f10652a.offer(this);
        }
    }
}
