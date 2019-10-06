package com.airbnb.lottie.p085a.p087b;

import android.graphics.Path;
import com.airbnb.lottie.p089c.p091b.C5741g;
import com.airbnb.lottie.p089c.p091b.C5749l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.g */
/* compiled from: MaskKeyframeAnimation */
public class C5705g {

    /* renamed from: a */
    private final List<C5698a<C5749l, Path>> f9785a;

    /* renamed from: b */
    private final List<C5698a<Integer, Integer>> f9786b;

    /* renamed from: c */
    private final List<C5741g> f9787c;

    public C5705g(List<C5741g> masks) {
        this.f9787c = masks;
        this.f9785a = new ArrayList(masks.size());
        this.f9786b = new ArrayList(masks.size());
        for (int i = 0; i < masks.size(); i++) {
            this.f9785a.add(((C5741g) masks.get(i)).mo18024b().mo17984a());
            this.f9786b.add(((C5741g) masks.get(i)).mo18025c().mo17984a());
        }
    }

    /* renamed from: b */
    public List<C5741g> mo17959b() {
        return this.f9787c;
    }

    /* renamed from: a */
    public List<C5698a<C5749l, Path>> mo17958a() {
        return this.f9785a;
    }

    /* renamed from: c */
    public List<C5698a<Integer, Integer>> mo17960c() {
        return this.f9786b;
    }
}
