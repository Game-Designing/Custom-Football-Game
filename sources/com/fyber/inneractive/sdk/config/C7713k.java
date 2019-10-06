package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.p162a.C7692c.C7694b;
import com.fyber.inneractive.sdk.config.p162a.C7700i;
import com.fyber.inneractive.sdk.util.C8033v;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.config.k */
public final class C7713k implements C7714l {

    /* renamed from: a */
    Boolean f15368a;

    /* renamed from: b */
    public Integer f15369b = Integer.valueOf(5000);

    /* renamed from: c */
    public Integer f15370c;

    /* renamed from: d */
    Boolean f15371d;

    /* renamed from: e */
    Orientation f15372e;

    /* renamed from: f */
    Integer f15373f;

    /* renamed from: g */
    public Integer f15374g;

    /* renamed from: h */
    Skip f15375h;

    /* renamed from: i */
    TapAction f15376i;

    /* renamed from: j */
    public UnitDisplayType f15377j;

    /* renamed from: k */
    public List<Integer> f15378k;

    public C7713k() {
        Boolean valueOf = Boolean.valueOf(true);
        this.f15368a = valueOf;
        Integer valueOf2 = Integer.valueOf(0);
        this.f15370c = valueOf2;
        this.f15371d = valueOf;
        this.f15373f = valueOf2;
        this.f15374g = Integer.valueOf(Opcodes.ACC_STRICT);
        this.f15375h = Skip.fromValue(valueOf2);
        this.f15378k = new ArrayList();
    }

    /* renamed from: a */
    public final Boolean mo24213a() {
        return this.f15368a;
    }

    /* renamed from: b */
    public final Integer mo24215b() {
        return this.f15369b;
    }

    /* renamed from: c */
    public final Boolean mo24216c() {
        return this.f15371d;
    }

    /* renamed from: d */
    public final Orientation mo24217d() {
        return this.f15372e;
    }

    /* renamed from: e */
    public final Integer mo24218e() {
        return this.f15373f;
    }

    /* renamed from: f */
    public final Skip mo24219f() {
        return this.f15375h;
    }

    /* renamed from: g */
    public final TapAction mo24220g() {
        return this.f15376i;
    }

    /* renamed from: h */
    public final UnitDisplayType mo24221h() {
        return this.f15377j;
    }

    /* renamed from: i */
    public final boolean mo24222i() {
        return C8033v.m18119a(this.f15377j);
    }

    /* renamed from: a */
    public final void mo24214a(List<Integer> list, C7694b... bVarArr) {
        int i = 0;
        while (true) {
            if (i > 0) {
                break;
            }
            C7700i a = bVarArr[0].mo24183a();
            if (a != null) {
                List<Integer> list2 = a.f15310k;
                if (list2 != null && list2.size() > 0) {
                    list = a.f15310k;
                    break;
                }
            }
            i++;
        }
        this.f15378k = list;
    }
}
