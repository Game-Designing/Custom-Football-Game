package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0196c;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.t */
/* compiled from: WidgetContainer */
public class C0194t extends C0180h {

    /* renamed from: va */
    protected ArrayList<C0180h> f530va = new ArrayList<>();

    /* renamed from: D */
    public void mo3854D() {
        this.f530va.clear();
        super.mo3854D();
    }

    /* renamed from: b */
    public void mo3981b(C0180h widget) {
        this.f530va.add(widget);
        if (widget.mo3904k() != null) {
            ((C0194t) widget.mo3904k()).mo3982c(widget);
        }
        widget.mo3866a((C0180h) this);
    }

    /* renamed from: c */
    public void mo3982c(C0180h widget) {
        this.f530va.remove(widget);
        widget.mo3866a((C0180h) null);
    }

    /* renamed from: J */
    public C0182i mo3951J() {
        C0180h parent = mo3904k();
        C0182i container = null;
        if (this instanceof C0182i) {
            container = (C0182i) this;
        }
        while (parent != null) {
            C0180h item = parent;
            parent = item.mo3904k();
            if (item instanceof C0182i) {
                container = (C0182i) item;
            }
        }
        return container;
    }

    /* renamed from: b */
    public void mo3876b(int x, int y) {
        super.mo3876b(x, y);
        int count = this.f530va.size();
        for (int i = 0; i < count; i++) {
            ((C0180h) this.f530va.get(i)).mo3876b(mo3912o(), mo3914p());
        }
    }

    /* renamed from: H */
    public void mo3856H() {
        super.mo3856H();
        ArrayList<C0180h> arrayList = this.f530va;
        if (arrayList != null) {
            int count = arrayList.size();
            for (int i = 0; i < count; i++) {
                C0180h widget = (C0180h) this.f530va.get(i);
                widget.mo3876b(mo3896g(), mo3898h());
                if (!(widget instanceof C0182i)) {
                    widget.mo3856H();
                }
            }
        }
    }

    /* renamed from: K */
    public void mo3930K() {
        mo3856H();
        ArrayList<C0180h> arrayList = this.f530va;
        if (arrayList != null) {
            int count = arrayList.size();
            for (int i = 0; i < count; i++) {
                C0180h widget = (C0180h) this.f530va.get(i);
                if (widget instanceof C0194t) {
                    ((C0194t) widget).mo3930K();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3868a(C0196c cache) {
        super.mo3868a(cache);
        int count = this.f530va.size();
        for (int i = 0; i < count; i++) {
            ((C0180h) this.f530va.get(i)).mo3868a(cache);
        }
    }

    /* renamed from: L */
    public void mo3980L() {
        this.f530va.clear();
    }
}
