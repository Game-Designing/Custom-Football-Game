package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import com.airbnb.lottie.p089c.C5759c;
import com.airbnb.lottie.p089c.C5775d;
import com.airbnb.lottie.p089c.p092c.C5766g;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1259h;
import p002b.p003c.p053g.p061f.C1274r;

/* renamed from: com.airbnb.lottie.g */
/* compiled from: LottieComposition */
public class C5830g {

    /* renamed from: a */
    private final C5669H f10111a = new C5669H();

    /* renamed from: b */
    private final HashSet<String> f10112b = new HashSet<>();

    /* renamed from: c */
    private Map<String, List<C5766g>> f10113c;

    /* renamed from: d */
    private Map<String, C5853y> f10114d;

    /* renamed from: e */
    private Map<String, C5759c> f10115e;

    /* renamed from: f */
    private C1274r<C5775d> f10116f;

    /* renamed from: g */
    private C1259h<C5766g> f10117g;

    /* renamed from: h */
    private List<C5766g> f10118h;

    /* renamed from: i */
    private Rect f10119i;

    /* renamed from: j */
    private float f10120j;

    /* renamed from: k */
    private float f10121k;

    /* renamed from: l */
    private float f10122l;

    /* renamed from: a */
    public void mo18188a(Rect bounds, float startFrame, float endFrame, float frameRate, List<C5766g> layers, C1259h<C5766g> layerMap, Map<String, List<C5766g>> precomps, Map<String, C5853y> images, C1274r<C5775d> characters, Map<String, C5759c> fonts) {
        this.f10119i = bounds;
        this.f10120j = startFrame;
        this.f10121k = endFrame;
        this.f10122l = frameRate;
        this.f10118h = layers;
        this.f10117g = layerMap;
        this.f10113c = precomps;
        this.f10114d = images;
        this.f10116f = characters;
        this.f10115e = fonts;
    }

    /* renamed from: a */
    public void mo18189a(String warning) {
        Log.w("LOTTIE", warning);
        this.f10112b.add(warning);
    }

    /* renamed from: a */
    public void mo18190a(boolean enabled) {
        this.f10111a.mo17879a(enabled);
    }

    /* renamed from: j */
    public C5669H mo18200j() {
        return this.f10111a;
    }

    /* renamed from: a */
    public C5766g mo18187a(long id) {
        return (C5766g) this.f10117g.mo9058b(id);
    }

    /* renamed from: a */
    public Rect mo18186a() {
        return this.f10119i;
    }

    /* renamed from: c */
    public float mo18193c() {
        return (float) ((long) ((mo18194d() / this.f10122l) * 1000.0f));
    }

    /* renamed from: k */
    public float mo18201k() {
        return this.f10120j;
    }

    /* renamed from: e */
    public float mo18195e() {
        return this.f10121k;
    }

    /* renamed from: g */
    public float mo18197g() {
        return this.f10122l;
    }

    /* renamed from: i */
    public List<C5766g> mo18199i() {
        return this.f10118h;
    }

    /* renamed from: b */
    public List<C5766g> mo18192b(String id) {
        return (List) this.f10113c.get(id);
    }

    /* renamed from: b */
    public C1274r<C5775d> mo18191b() {
        return this.f10116f;
    }

    /* renamed from: f */
    public Map<String, C5759c> mo18196f() {
        return this.f10115e;
    }

    /* renamed from: h */
    public Map<String, C5853y> mo18198h() {
        return this.f10114d;
    }

    /* renamed from: d */
    public float mo18194d() {
        return this.f10121k - this.f10120j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (C5766g layer : this.f10118h) {
            sb.append(layer.mo18093a("\t"));
        }
        return sb.toString();
    }
}
