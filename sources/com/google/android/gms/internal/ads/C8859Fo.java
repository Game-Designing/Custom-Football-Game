package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob.zze;
import java.io.IOException;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;

/* renamed from: com.google.android.gms.internal.ads.Fo */
final class C8859Fo implements C9435fq {

    /* renamed from: a */
    private final zzdni f20872a;

    /* renamed from: a */
    public static C8859Fo m22501a(zzdni zzdni) {
        C8859Fo fo = zzdni.f27983c;
        if (fo != null) {
            return fo;
        }
        return new C8859Fo(zzdni);
    }

    private C8859Fo(zzdni zzdni) {
        zzdod.m29917a(zzdni, AgentOptions.OUTPUT);
        this.f20872a = zzdni;
    }

    /* renamed from: a */
    public final int mo28201a() {
        return zze.f28081l;
    }

    /* renamed from: c */
    public final void mo28220c(int i, int i2) throws IOException {
        this.f20872a.mo31552a(i, i2);
    }

    /* renamed from: f */
    public final void mo28229f(int i, long j) throws IOException {
        this.f20872a.mo31553a(i, j);
    }

    /* renamed from: g */
    public final void mo28231g(int i, long j) throws IOException {
        this.f20872a.mo31571c(i, j);
    }

    /* renamed from: a */
    public final void mo28204a(int i, float f) throws IOException {
        this.f20872a.mo31551a(i, f);
    }

    /* renamed from: a */
    public final void mo28203a(int i, double d) throws IOException {
        this.f20872a.mo31550a(i, d);
    }

    /* renamed from: e */
    public final void mo28225e(int i, int i2) throws IOException {
        this.f20872a.mo31575i(i, i2);
    }

    /* renamed from: h */
    public final void mo28233h(int i, long j) throws IOException {
        this.f20872a.mo31553a(i, j);
    }

    /* renamed from: b */
    public final void mo28215b(int i, int i2) throws IOException {
        this.f20872a.mo31575i(i, i2);
    }

    /* renamed from: d */
    public final void mo28223d(int i, long j) throws IOException {
        this.f20872a.mo31571c(i, j);
    }

    /* renamed from: a */
    public final void mo28205a(int i, int i2) throws IOException {
        this.f20872a.mo31552a(i, i2);
    }

    /* renamed from: a */
    public final void mo28213a(int i, boolean z) throws IOException {
        this.f20872a.mo31558a(i, z);
    }

    /* renamed from: a */
    public final void mo28209a(int i, String str) throws IOException {
        this.f20872a.mo31557a(i, str);
    }

    /* renamed from: a */
    public final void mo28206a(int i, zzdmr zzdmr) throws IOException {
        this.f20872a.mo31554a(i, zzdmr);
    }

    /* renamed from: d */
    public final void mo28222d(int i, int i2) throws IOException {
        this.f20872a.mo31576j(i, i2);
    }

    /* renamed from: f */
    public final void mo28228f(int i, int i2) throws IOException {
        this.f20872a.mo31577k(i, i2);
    }

    /* renamed from: e */
    public final void mo28226e(int i, long j) throws IOException {
        this.f20872a.mo31564b(i, j);
    }

    /* renamed from: b */
    public final void mo28216b(int i, Object obj, C9822xp xpVar) throws IOException {
        this.f20872a.mo31556a(i, (zzdpk) obj, xpVar);
    }

    /* renamed from: a */
    public final void mo28208a(int i, Object obj, C9822xp xpVar) throws IOException {
        zzdni zzdni = this.f20872a;
        zzdpk zzdpk = (zzdpk) obj;
        zzdni.mo31574h(i, 3);
        xpVar.mo29081a(zzdpk, (C9435fq) zzdni.f27983c);
        zzdni.mo31574h(i, 4);
    }

    /* renamed from: b */
    public final void mo28214b(int i) throws IOException {
        this.f20872a.mo31574h(i, 3);
    }

    /* renamed from: a */
    public final void mo28202a(int i) throws IOException {
        this.f20872a.mo31574h(i, 4);
    }

    /* renamed from: a */
    public final void mo28207a(int i, Object obj) throws IOException {
        if (obj instanceof zzdmr) {
            this.f20872a.mo31565b(i, (zzdmr) obj);
        } else {
            this.f20872a.mo31566b(i, (zzdpk) obj);
        }
    }

    /* renamed from: a */
    public final void mo28212a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29731f(((Integer) list.get(i4)).intValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31549a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31575i(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: c */
    public final void mo28221c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29742i(((Integer) list.get(i4)).intValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31573d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31552a(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo28219b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29725d(((Long) list.get(i4)).longValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31559a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31553a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: l */
    public final void mo28238l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29730e(((Long) list.get(i4)).longValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31559a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31553a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: k */
    public final void mo28237k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29738g(((Long) list.get(i4)).longValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31572c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31571c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: n */
    public final void mo28240n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29706b(((Float) list.get(i4)).floatValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31548a(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31551a(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    /* renamed from: m */
    public final void mo28239m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29705b(((Double) list.get(i4)).doubleValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31547a(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31550a(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    /* renamed from: g */
    public final void mo28232g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29745k(((Integer) list.get(i4)).intValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31549a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31575i(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: f */
    public final void mo28230f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29715b(((Boolean) list.get(i4)).booleanValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31561a(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31558a(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo28217b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzdot) {
            zzdot zzdot = (zzdot) list;
            while (i2 < list.size()) {
                Object g = zzdot.mo31627g(i2);
                if (g instanceof String) {
                    this.f20872a.mo31557a(i, (String) g);
                } else {
                    this.f20872a.mo31554a(i, (zzdmr) g);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31557a(i, (String) list.get(i2));
            i2++;
        }
    }

    /* renamed from: a */
    public final void mo28210a(int i, List<zzdmr> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f20872a.mo31554a(i, (zzdmr) list.get(i2));
        }
    }

    /* renamed from: i */
    public final void mo28235i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29735g(((Integer) list.get(i4)).intValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31563b(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31576j(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: j */
    public final void mo28236j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29744j(((Integer) list.get(i4)).intValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31573d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31552a(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: h */
    public final void mo28234h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29741h(((Long) list.get(i4)).longValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31572c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31571c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: e */
    public final void mo28227e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29739h(((Integer) list.get(i4)).intValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31570c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31577k(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: d */
    public final void mo28224d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f20872a.mo31574h(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzdni.m29734f(((Long) list.get(i4)).longValue());
            }
            this.f20872a.mo31563b(i3);
            while (i2 < list.size()) {
                this.f20872a.mo31567b(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f20872a.mo31564b(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo28218b(int i, List<?> list, C9822xp xpVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo28216b(i, list.get(i2), xpVar);
        }
    }

    /* renamed from: a */
    public final void mo28211a(int i, List<?> list, C9822xp xpVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo28208a(i, list.get(i2), xpVar);
        }
    }
}
