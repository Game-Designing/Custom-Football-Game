package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
public final class zzadt extends zzaeb {

    /* renamed from: b */
    private static final int f24245b = Color.rgb(12, Opcodes.FRETURN, 206);

    /* renamed from: c */
    private static final int f24246c;

    /* renamed from: d */
    private static final int f24247d;

    /* renamed from: e */
    private static final int f24248e = f24245b;

    /* renamed from: f */
    private final String f24249f;

    /* renamed from: g */
    private final List<zzadw> f24250g = new ArrayList();

    /* renamed from: h */
    private final List<zzaei> f24251h = new ArrayList();

    /* renamed from: i */
    private final int f24252i;

    /* renamed from: j */
    private final int f24253j;

    /* renamed from: k */
    private final int f24254k;

    /* renamed from: l */
    private final int f24255l;

    /* renamed from: m */
    private final int f24256m;

    /* renamed from: n */
    private final boolean f24257n;

    public zzadt(String str, List<zzadw> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.f24249f = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadw zzadw = (zzadw) list.get(i3);
                this.f24250g.add(zzadw);
                this.f24251h.add(zzadw);
            }
        }
        this.f24252i = num != null ? num.intValue() : f24247d;
        this.f24253j = num2 != null ? num2.intValue() : f24248e;
        this.f24254k = num3 != null ? num3.intValue() : 12;
        this.f24255l = i;
        this.f24256m = i2;
        this.f24257n = z;
    }

    public final String getText() {
        return this.f24249f;
    }

    /* renamed from: za */
    public final List<zzaei> mo29636za() {
        return this.f24251h;
    }

    /* renamed from: lb */
    public final List<zzadw> mo29633lb() {
        return this.f24250g;
    }

    /* renamed from: ib */
    public final int mo29630ib() {
        return this.f24252i;
    }

    /* renamed from: jb */
    public final int mo29631jb() {
        return this.f24253j;
    }

    /* renamed from: kb */
    public final int mo29632kb() {
        return this.f24254k;
    }

    /* renamed from: mb */
    public final int mo29634mb() {
        return this.f24255l;
    }

    /* renamed from: nb */
    public final int mo29635nb() {
        return this.f24256m;
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        f24246c = rgb;
        f24247d = rgb;
    }
}
