package com.airbnb.lottie.p089c.p091b;

import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5697v;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p092c.C5762c;

/* renamed from: com.airbnb.lottie.c.b.r */
/* compiled from: ShapeTrimPath */
public class C5757r implements C5736b {

    /* renamed from: a */
    private final String f9953a;

    /* renamed from: b */
    private final C5758a f9954b;

    /* renamed from: c */
    private final C5721b f9955c;

    /* renamed from: d */
    private final C5721b f9956d;

    /* renamed from: e */
    private final C5721b f9957e;

    /* renamed from: com.airbnb.lottie.c.b.r$a */
    /* compiled from: ShapeTrimPath */
    public enum C5758a {
        Simultaneously,
        Individually;

        /* renamed from: a */
        public static C5758a m10300a(int id) {
            if (id == 1) {
                return Simultaneously;
            }
            if (id == 2) {
                return Individually;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown trim path type ");
            sb.append(id);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public C5757r(String name, C5758a type, C5721b start, C5721b end, C5721b offset) {
        this.f9953a = name;
        this.f9954b = type;
        this.f9955c = start;
        this.f9956d = end;
        this.f9957e = offset;
    }

    /* renamed from: b */
    public String mo18075b() {
        return this.f9953a;
    }

    /* renamed from: e */
    public C5758a mo18078e() {
        return this.f9954b;
    }

    /* renamed from: a */
    public C5721b mo18074a() {
        return this.f9956d;
    }

    /* renamed from: d */
    public C5721b mo18077d() {
        return this.f9955c;
    }

    /* renamed from: c */
    public C5721b mo18076c() {
        return this.f9957e;
    }

    /* renamed from: a */
    public C5678c mo17986a(C5851x drawable, C5762c layer) {
        return new C5697v(layer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trim Path: {start: ");
        sb.append(this.f9955c);
        sb.append(", end: ");
        sb.append(this.f9956d);
        sb.append(", offset: ");
        sb.append(this.f9957e);
        sb.append("}");
        return sb.toString();
    }
}
