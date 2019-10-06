package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.p035a.C0175f.C0177b;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.s */
/* compiled from: Snapshot */
public class C0192s {

    /* renamed from: a */
    private int f520a;

    /* renamed from: b */
    private int f521b;

    /* renamed from: c */
    private int f522c;

    /* renamed from: d */
    private int f523d;

    /* renamed from: e */
    private ArrayList<C0193a> f524e = new ArrayList<>();

    /* renamed from: android.support.constraint.a.a.s$a */
    /* compiled from: Snapshot */
    static class C0193a {

        /* renamed from: a */
        private C0175f f525a;

        /* renamed from: b */
        private C0175f f526b;

        /* renamed from: c */
        private int f527c;

        /* renamed from: d */
        private C0177b f528d;

        /* renamed from: e */
        private int f529e;

        public C0193a(C0175f anchor) {
            this.f525a = anchor;
            this.f526b = anchor.mo3846g();
            this.f527c = anchor.mo3841b();
            this.f528d = anchor.mo3845f();
            this.f529e = anchor.mo3836a();
        }

        /* renamed from: b */
        public void mo3979b(C0180h widget) {
            this.f525a = widget.mo3858a(this.f525a.mo3847h());
            C0175f fVar = this.f525a;
            if (fVar != null) {
                this.f526b = fVar.mo3846g();
                this.f527c = this.f525a.mo3841b();
                this.f528d = this.f525a.mo3845f();
                this.f529e = this.f525a.mo3836a();
                return;
            }
            this.f526b = null;
            this.f527c = 0;
            this.f528d = C0177b.STRONG;
            this.f529e = 0;
        }

        /* renamed from: a */
        public void mo3978a(C0180h widget) {
            widget.mo3858a(this.f525a.mo3847h()).mo3840a(this.f526b, this.f527c, this.f528d, this.f529e);
        }
    }

    public C0192s(C0180h widget) {
        this.f520a = widget.mo3925v();
        this.f521b = widget.mo3926w();
        this.f522c = widget.mo3920s();
        this.f523d = widget.mo3900i();
        ArrayList<ConstraintAnchor> anchors = widget.mo3874b();
        int anchorsSize = anchors.size();
        for (int i = 0; i < anchorsSize; i++) {
            this.f524e.add(new C0193a((C0175f) anchors.get(i)));
        }
    }

    /* renamed from: b */
    public void mo3977b(C0180h widget) {
        this.f520a = widget.mo3925v();
        this.f521b = widget.mo3926w();
        this.f522c = widget.mo3920s();
        this.f523d = widget.mo3900i();
        int connections = this.f524e.size();
        for (int i = 0; i < connections; i++) {
            ((C0193a) this.f524e.get(i)).mo3979b(widget);
        }
    }

    /* renamed from: a */
    public void mo3976a(C0180h widget) {
        widget.mo3919r(this.f520a);
        widget.mo3921s(this.f521b);
        widget.mo3913o(this.f522c);
        widget.mo3897g(this.f523d);
        int mConnectionsSize = this.f524e.size();
        for (int i = 0; i < mConnectionsSize; i++) {
            ((C0193a) this.f524e.get(i)).mo3978a(widget);
        }
    }
}
