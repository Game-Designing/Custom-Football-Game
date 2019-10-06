package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;
import java.io.IOException;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;

/* renamed from: com.google.android.gms.internal.measurement.U */
final class C9934U implements C9986lb {

    /* renamed from: a */
    private final zztv f30038a;

    /* renamed from: a */
    public static C9934U m31887a(zztv zztv) {
        C9934U u = zztv.f30257c;
        if (u != null) {
            return u;
        }
        return new C9934U(zztv);
    }

    private C9934U(zztv zztv) {
        zzuq.m32542a(zztv, AgentOptions.OUTPUT);
        this.f30038a = zztv;
    }

    /* renamed from: b */
    public final int mo32632b() {
        return zze.f30339l;
    }

    /* renamed from: f */
    public final void mo32649f(int i, int i2) throws IOException {
        this.f30038a.mo32878e(i, i2);
    }

    /* renamed from: e */
    public final void mo32647e(int i, long j) throws IOException {
        this.f30038a.mo32858a(i, j);
    }

    /* renamed from: d */
    public final void mo32644d(int i, long j) throws IOException {
        this.f30038a.mo32874c(i, j);
    }

    /* renamed from: a */
    public final void mo32621a(int i, float f) throws IOException {
        this.f30038a.mo32856a(i, f);
    }

    /* renamed from: a */
    public final void mo32620a(int i, double d) throws IOException {
        this.f30038a.mo32855a(i, d);
    }

    /* renamed from: a */
    public final void mo32622a(int i, int i2) throws IOException {
        this.f30038a.mo32868b(i, i2);
    }

    /* renamed from: c */
    public final void mo32641c(int i, long j) throws IOException {
        this.f30038a.mo32858a(i, j);
    }

    /* renamed from: b */
    public final void mo32634b(int i, int i2) throws IOException {
        this.f30038a.mo32868b(i, i2);
    }

    /* renamed from: b */
    public final void mo32635b(int i, long j) throws IOException {
        this.f30038a.mo32874c(i, j);
    }

    /* renamed from: d */
    public final void mo32643d(int i, int i2) throws IOException {
        this.f30038a.mo32878e(i, i2);
    }

    /* renamed from: a */
    public final void mo32631a(int i, boolean z) throws IOException {
        this.f30038a.mo32863a(i, z);
    }

    /* renamed from: a */
    public final void mo32627a(int i, String str) throws IOException {
        this.f30038a.mo32862a(i, str);
    }

    /* renamed from: a */
    public final void mo32624a(int i, zzte zzte) throws IOException {
        this.f30038a.mo32859a(i, zzte);
    }

    /* renamed from: e */
    public final void mo32646e(int i, int i2) throws IOException {
        this.f30038a.mo32873c(i, i2);
    }

    /* renamed from: c */
    public final void mo32640c(int i, int i2) throws IOException {
        this.f30038a.mo32877d(i, i2);
    }

    /* renamed from: a */
    public final void mo32623a(int i, long j) throws IOException {
        this.f30038a.mo32869b(i, j);
    }

    /* renamed from: a */
    public final void mo32626a(int i, Object obj, C9906Fa fa) throws IOException {
        this.f30038a.mo32861a(i, (zzvv) obj, fa);
    }

    /* renamed from: b */
    public final void mo32636b(int i, Object obj, C9906Fa fa) throws IOException {
        zztv zztv = this.f30038a;
        zzvv zzvv = (zzvv) obj;
        zztv.mo32857a(i, 3);
        fa.mo32553a(zzvv, (C9986lb) zztv.f30257c);
        zztv.mo32857a(i, 4);
    }

    /* renamed from: b */
    public final void mo32633b(int i) throws IOException {
        this.f30038a.mo32857a(i, 3);
    }

    /* renamed from: a */
    public final void mo32619a(int i) throws IOException {
        this.f30038a.mo32857a(i, 4);
    }

    /* renamed from: a */
    public final void mo32625a(int i, Object obj) throws IOException {
        if (obj instanceof zzte) {
            this.f30038a.mo32870b(i, (zzte) obj);
        } else {
            this.f30038a.mo32860a(i, (zzvv) obj);
        }
    }

    /* renamed from: a */
    public final void mo32630a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32432f(((Integer) list.get(i4)).intValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32854a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32868b(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: c */
    public final void mo32642c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32444i(((Integer) list.get(i4)).intValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32876d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32878e(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo32639b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32428d(((Long) list.get(i4)).longValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32864a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32858a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: l */
    public final void mo32656l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32431e(((Long) list.get(i4)).longValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32864a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32858a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: k */
    public final void mo32655k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32439g(((Long) list.get(i4)).longValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32875c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32874c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: n */
    public final void mo32658n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32411b(((Float) list.get(i4)).floatValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32853a(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32856a(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    /* renamed from: m */
    public final void mo32657m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32410b(((Double) list.get(i4)).doubleValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32852a(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32855a(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    /* renamed from: g */
    public final void mo32651g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32449k(((Integer) list.get(i4)).intValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32854a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32868b(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: f */
    public final void mo32650f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32420b(((Boolean) list.get(i4)).booleanValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32866a(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32863a(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo32637b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzve) {
            zzve zzve = (zzve) list;
            while (i2 < list.size()) {
                Object f = zzve.mo32917f(i2);
                if (f instanceof String) {
                    this.f30038a.mo32862a(i, (String) f);
                } else {
                    this.f30038a.mo32859a(i, (zzte) f);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32862a(i, (String) list.get(i2));
            i2++;
        }
    }

    /* renamed from: a */
    public final void mo32628a(int i, List<zzte> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f30038a.mo32859a(i, (zzte) list.get(i2));
        }
    }

    /* renamed from: i */
    public final void mo32653i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32436g(((Integer) list.get(i4)).intValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32867b(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32873c(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: j */
    public final void mo32654j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32447j(((Integer) list.get(i4)).intValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32876d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32878e(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: h */
    public final void mo32652h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32443h(((Long) list.get(i4)).longValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32875c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32874c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: e */
    public final void mo32648e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32440h(((Integer) list.get(i4)).intValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32872c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32877d(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: d */
    public final void mo32645d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f30038a.mo32857a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.m32435f(((Long) list.get(i4)).longValue());
            }
            this.f30038a.mo32867b(i3);
            while (i2 < list.size()) {
                this.f30038a.mo32871b(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f30038a.mo32869b(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo32638b(int i, List<?> list, C9906Fa fa) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo32626a(i, list.get(i2), fa);
        }
    }

    /* renamed from: a */
    public final void mo32629a(int i, List<?> list, C9906Fa fa) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo32636b(i, list.get(i2), fa);
        }
    }
}
