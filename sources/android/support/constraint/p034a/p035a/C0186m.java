package android.support.constraint.p034a.p035a;

import java.util.Arrays;

/* renamed from: android.support.constraint.a.a.m */
/* compiled from: Helper */
public class C0186m extends C0180h {

    /* renamed from: va */
    protected C0180h[] f501va = new C0180h[4];

    /* renamed from: wa */
    protected int f502wa = 0;

    /* renamed from: b */
    public void mo3955b(C0180h widget) {
        int i = this.f502wa + 1;
        C0180h[] hVarArr = this.f501va;
        if (i > hVarArr.length) {
            this.f501va = (C0180h[]) Arrays.copyOf(hVarArr, hVarArr.length * 2);
        }
        C0180h[] hVarArr2 = this.f501va;
        int i2 = this.f502wa;
        hVarArr2[i2] = widget;
        this.f502wa = i2 + 1;
    }

    /* renamed from: J */
    public void mo3951J() {
        this.f502wa = 0;
    }
}
