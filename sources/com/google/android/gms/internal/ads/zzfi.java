package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzfi {

    /* renamed from: a */
    private static final String f28397a = zzfi.class.getSimpleName();

    /* renamed from: b */
    private final zzdy f28398b;

    /* renamed from: c */
    private final String f28399c;

    /* renamed from: d */
    private final String f28400d;

    /* renamed from: e */
    private final int f28401e = 2;

    /* renamed from: f */
    private volatile Method f28402f = null;

    /* renamed from: g */
    private final Class<?>[] f28403g;

    /* renamed from: h */
    private CountDownLatch f28404h = new CountDownLatch(1);

    public zzfi(zzdy zzdy, String str, String str2, Class<?>... clsArr) {
        this.f28398b = zzdy;
        this.f28399c = str;
        this.f28400d = str2;
        this.f28403g = clsArr;
        this.f28398b.mo31716d().submit(new C8882Gq(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m30210b() {
        try {
            Class loadClass = this.f28398b.mo31717e().loadClass(m30208a(this.f28398b.mo31719g(), this.f28399c));
            if (loadClass != null) {
                this.f28402f = loadClass.getMethod(m30208a(this.f28398b.mo31719g(), this.f28400d), this.f28403g);
                if (this.f28402f == null) {
                    this.f28404h.countDown();
                } else {
                    this.f28404h.countDown();
                }
            }
        } catch (zzdk e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.f28404h.countDown();
        }
    }

    /* renamed from: a */
    private final String m30208a(byte[] bArr, String str) throws zzdk, UnsupportedEncodingException {
        return new String(this.f28398b.mo31718f().mo31521a(bArr, str), "UTF-8");
    }

    /* renamed from: a */
    public final Method mo31747a() {
        if (this.f28402f != null) {
            return this.f28402f;
        }
        try {
            if (!this.f28404h.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.f28402f;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
