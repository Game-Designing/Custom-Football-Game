package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzdsu implements zzbe, Closeable, Iterator<zzbd> {

    /* renamed from: a */
    private static final zzbd f28272a = new C9697rq("eof ");

    /* renamed from: b */
    private static zzdtc f28273b = zzdtc.m30099a(zzdsu.class);

    /* renamed from: c */
    protected zzba f28274c;

    /* renamed from: d */
    protected zzdsw f28275d;

    /* renamed from: e */
    private zzbd f28276e = null;

    /* renamed from: f */
    long f28277f = 0;

    /* renamed from: g */
    long f28278g = 0;

    /* renamed from: h */
    long f28279h = 0;

    /* renamed from: i */
    private List<zzbd> f28280i = new ArrayList();

    /* renamed from: a */
    public final List<zzbd> mo31687a() {
        if (this.f28275d == null || this.f28276e == f28272a) {
            return this.f28280i;
        }
        return new zzdta(this.f28280i, this);
    }

    /* renamed from: a */
    public void mo31684a(zzdsw zzdsw, long j, zzba zzba) throws IOException {
        this.f28275d = zzdsw;
        long position = zzdsw.position();
        this.f28278g = position;
        this.f28277f = position;
        zzdsw.mo29175g(zzdsw.position() + j);
        this.f28279h = zzdsw.position();
        this.f28274c = zzba;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        zzbd zzbd = this.f28276e;
        if (zzbd == f28272a) {
            return false;
        }
        if (zzbd != null) {
            return true;
        }
        try {
            this.f28276e = (zzbd) next();
            return true;
        } catch (NoSuchElementException e) {
            this.f28276e = f28272a;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final zzbd next() {
        zzbd a;
        zzbd zzbd = this.f28276e;
        if (zzbd == null || zzbd == f28272a) {
            zzdsw zzdsw = this.f28275d;
            if (zzdsw == null || this.f28277f >= this.f28279h) {
                this.f28276e = f28272a;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzdsw) {
                    this.f28275d.mo29175g(this.f28277f);
                    a = this.f28274c.mo30261a(this.f28275d, this);
                    this.f28277f = this.f28275d.position();
                }
                return a;
            } catch (EOFException e) {
                throw new NoSuchElementException();
            } catch (IOException e2) {
                throw new NoSuchElementException();
            }
        } else {
            this.f28276e = null;
            return zzbd;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.f28280i.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzbd) this.f28280i.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void close() throws IOException {
        this.f28275d.close();
    }
}
