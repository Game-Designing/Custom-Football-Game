package com.smaato.soma.p239c.p244e;

import com.facebook.ads.NativeAd;
import com.smaato.soma.internal.nativead.assets.ImageAssetModel;
import com.smaato.soma.p239c.p244e.p245a.C12207b;
import com.smaato.soma.p239c.p244e.p245a.C12208c;
import com.smaato.soma.p239c.p244e.p245a.C12209d;
import com.smaato.soma.p239c.p252i.C12281g;
import com.smaato.soma.p256e.C12331a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.smaato.soma.c.e.a */
/* compiled from: BannerNativeAd */
public class C12205a {

    /* renamed from: a */
    private String f38251a;

    /* renamed from: b */
    private List<C12209d> f38252b = new ArrayList();

    /* renamed from: c */
    private Map<Integer, List<C12208c>> f38253c = new HashMap();

    /* renamed from: d */
    private Map<Integer, C12207b> f38254d = new HashMap();

    /* renamed from: e */
    private String f38255e;

    /* renamed from: f */
    private Vector<String> f38256f;

    /* renamed from: g */
    private List<C12210b> f38257g;

    /* renamed from: h */
    private NativeAd f38258h;

    /* renamed from: i */
    private C12331a f38259i;

    /* renamed from: b */
    public void mo39523b(String version) {
        this.f38251a = version;
    }

    /* renamed from: g */
    public String mo39528g() {
        if (C12281g.m40430a(this.f38252b)) {
            return null;
        }
        return ((C12209d) this.f38252b.get(0)).mo39539a();
    }

    /* renamed from: a */
    public void mo39516a(C12209d titleAsset) {
        this.f38252b.add(titleAsset);
    }

    /* renamed from: b */
    public List<C12208c> mo39522b(int type) {
        return (List) this.f38253c.get(Integer.valueOf(type));
    }

    /* renamed from: l */
    public List<C12208c> mo39533l() {
        return (List) this.f38253c.get(Integer.valueOf(C12208c.f38264c));
    }

    /* renamed from: a */
    public void mo39515a(C12208c model) {
        if (this.f38253c.containsKey(Integer.valueOf(model.mo39537a()))) {
            ((List) this.f38253c.get(Integer.valueOf(model.mo39537a()))).add(model);
            return;
        }
        List<ImageAssetModel> models = new ArrayList<>();
        models.add(model);
        this.f38253c.put(Integer.valueOf(model.mo39537a()), models);
    }

    /* renamed from: e */
    public String mo39526e() {
        List<ImageAssetModel> models = mo39522b(C12208c.f38263b);
        if (C12281g.m40430a(models)) {
            return null;
        }
        return ((C12208c) models.get(0)).mo39538b();
    }

    /* renamed from: f */
    public String mo39527f() {
        List<ImageAssetModel> models = mo39522b(C12208c.f38264c);
        if (C12281g.m40430a(models)) {
            return null;
        }
        return ((C12208c) models.get(0)).mo39538b();
    }

    /* renamed from: a */
    public void mo39514a(C12207b model) {
        this.f38254d.put(Integer.valueOf(model.mo39535a()), model);
    }

    /* renamed from: a */
    public C12207b mo39512a(int type) {
        return (C12207b) this.f38254d.get(Integer.valueOf(type));
    }

    /* renamed from: h */
    public String mo39529h() {
        C12207b descriptionModel = mo39512a(2);
        if (descriptionModel == null) {
            return null;
        }
        return descriptionModel.mo39536b();
    }

    /* renamed from: b */
    public String mo39521b() {
        C12207b clickToActionModel = mo39512a(12);
        if (clickToActionModel == null) {
            return null;
        }
        return clickToActionModel.mo39536b();
    }

    /* renamed from: m */
    public float mo39534m() {
        C12207b descriptionModel = mo39512a(3);
        if (descriptionModel == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(descriptionModel.mo39536b());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    /* renamed from: c */
    public String mo39524c() {
        return this.f38255e;
    }

    /* renamed from: a */
    public void mo39518a(String clickToActionUrl) {
        this.f38255e = clickToActionUrl;
    }

    /* renamed from: d */
    public Vector<String> mo39525d() {
        if (this.f38256f == null) {
            this.f38256f = new Vector<>();
        }
        return this.f38256f;
    }

    /* renamed from: a */
    public void mo39520a(Vector<String> clickTrackingUrls) {
        this.f38256f = clickTrackingUrls;
    }

    /* renamed from: i */
    public List<C12210b> mo39530i() {
        if (this.f38257g == null) {
            this.f38257g = new ArrayList();
        }
        return this.f38257g;
    }

    /* renamed from: a */
    public void mo39519a(List<C12210b> eventTrackers) {
        this.f38257g = eventTrackers;
    }

    /* renamed from: k */
    public Vector<String> mo39532k() {
        Vector<String> impressionTrackers = new Vector<>();
        Iterator it = mo39530i().iterator();
        while (it.hasNext()) {
            C12210b tracker = (C12210b) it.next();
            if (tracker.mo39542c()) {
                impressionTrackers.add(tracker.mo39541b());
            }
        }
        return impressionTrackers;
    }

    /* renamed from: j */
    public NativeAd mo39531j() {
        return this.f38258h;
    }

    /* renamed from: a */
    public C12331a mo39513a() {
        return this.f38259i;
    }

    /* renamed from: a */
    public void mo39517a(C12331a CSMAdFormat) {
        this.f38259i = CSMAdFormat;
    }
}
