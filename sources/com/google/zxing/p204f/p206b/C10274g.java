package com.google.zxing.p204f.p206b;

import com.google.zxing.p204f.p205a.C10263a;
import com.google.zxing.p204f.p205a.C10264b;
import com.google.zxing.p204f.p205a.C10265c;

/* renamed from: com.google.zxing.f.b.g */
/* compiled from: QRCode */
public final class C10274g {

    /* renamed from: a */
    private C10264b f31133a;

    /* renamed from: b */
    private C10263a f31134b;

    /* renamed from: c */
    private C10265c f31135c;

    /* renamed from: d */
    private int f31136d = -1;

    /* renamed from: e */
    private C10269b f31137e;

    /* renamed from: a */
    public C10269b mo33639a() {
        return this.f31137e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        StringBuilder result = sb;
        sb.append("<<\n");
        result.append(" mode: ");
        result.append(this.f31133a);
        result.append("\n ecLevel: ");
        result.append(this.f31134b);
        result.append("\n version: ");
        result.append(this.f31135c);
        result.append("\n maskPattern: ");
        result.append(this.f31136d);
        if (this.f31137e == null) {
            result.append("\n matrix: null\n");
        } else {
            result.append("\n matrix:\n");
            result.append(this.f31137e);
        }
        result.append(">>\n");
        return result.toString();
    }

    /* renamed from: a */
    public void mo33641a(C10264b value) {
        this.f31133a = value;
    }

    /* renamed from: a */
    public void mo33640a(C10263a value) {
        this.f31134b = value;
    }

    /* renamed from: a */
    public void mo33642a(C10265c version) {
        this.f31135c = version;
    }

    /* renamed from: b */
    public void mo33644b(int value) {
        this.f31136d = value;
    }

    /* renamed from: a */
    public void mo33643a(C10269b value) {
        this.f31137e = value;
    }

    /* renamed from: a */
    public static boolean m33511a(int maskPattern) {
        return maskPattern >= 0 && maskPattern < 8;
    }
}
