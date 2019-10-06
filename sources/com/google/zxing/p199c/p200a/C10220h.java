package com.google.zxing.p199c.p200a;

import com.google.zxing.C10207b;
import java.nio.charset.Charset;

/* renamed from: com.google.zxing.c.a.h */
/* compiled from: EncoderContext */
final class C10220h {

    /* renamed from: a */
    private final String f30981a;

    /* renamed from: b */
    private C10224l f30982b;

    /* renamed from: c */
    private C10207b f30983c;

    /* renamed from: d */
    private C10207b f30984d;

    /* renamed from: e */
    private final StringBuilder f30985e;

    /* renamed from: f */
    int f30986f;

    /* renamed from: g */
    private int f30987g;

    /* renamed from: h */
    private C10223k f30988h;

    /* renamed from: i */
    private int f30989i;

    C10220h(String msg) {
        byte[] msgBinary = msg.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder sb = new StringBuilder(msgBinary.length);
        int i = 0;
        int c = msgBinary.length;
        while (i < c) {
            char c2 = (char) (msgBinary[i] & 255);
            char ch = c2;
            if (c2 != '?' || msg.charAt(i) == '?') {
                sb.append(ch);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f30981a = sb.toString();
        this.f30982b = C10224l.FORCE_NONE;
        this.f30985e = new StringBuilder(msg.length());
        this.f30987g = -1;
    }

    /* renamed from: a */
    public void mo33558a(C10224l shape) {
        this.f30982b = shape;
    }

    /* renamed from: a */
    public void mo33557a(C10207b minSize, C10207b maxSize) {
        this.f30983c = minSize;
        this.f30984d = maxSize;
    }

    /* renamed from: d */
    public String mo33564d() {
        return this.f30981a;
    }

    /* renamed from: a */
    public void mo33556a(int count) {
        this.f30989i = count;
    }

    /* renamed from: c */
    public char mo33562c() {
        return this.f30981a.charAt(this.f30986f);
    }

    /* renamed from: b */
    public StringBuilder mo33560b() {
        return this.f30985e;
    }

    /* renamed from: a */
    public void mo33559a(String codewords) {
        this.f30985e.append(codewords);
    }

    /* renamed from: a */
    public void mo33555a(char codeword) {
        this.f30985e.append(codeword);
    }

    /* renamed from: a */
    public int mo33554a() {
        return this.f30985e.length();
    }

    /* renamed from: e */
    public int mo33565e() {
        return this.f30987g;
    }

    /* renamed from: b */
    public void mo33561b(int encoding) {
        this.f30987g = encoding;
    }

    /* renamed from: i */
    public void mo33569i() {
        this.f30987g = -1;
    }

    /* renamed from: h */
    public boolean mo33568h() {
        return this.f30986f < m33290l();
    }

    /* renamed from: l */
    private int m33290l() {
        return this.f30981a.length() - this.f30989i;
    }

    /* renamed from: f */
    public int mo33566f() {
        return m33290l() - this.f30986f;
    }

    /* renamed from: g */
    public C10223k mo33567g() {
        return this.f30988h;
    }

    /* renamed from: k */
    public void mo33571k() {
        mo33563c(mo33554a());
    }

    /* renamed from: c */
    public void mo33563c(int len) {
        C10223k kVar = this.f30988h;
        if (kVar == null || len > kVar.mo33572a()) {
            this.f30988h = C10223k.m33327a(len, this.f30982b, this.f30983c, this.f30984d, true);
        }
    }

    /* renamed from: j */
    public void mo33570j() {
        this.f30988h = null;
    }
}
