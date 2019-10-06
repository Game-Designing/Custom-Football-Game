package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.p035a.C0180h.C0181a;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.d */
/* compiled from: ChainHead */
public class C0173d {

    /* renamed from: a */
    protected C0180h f333a;

    /* renamed from: b */
    protected C0180h f334b;

    /* renamed from: c */
    protected C0180h f335c;

    /* renamed from: d */
    protected C0180h f336d;

    /* renamed from: e */
    protected C0180h f337e;

    /* renamed from: f */
    protected C0180h f338f;

    /* renamed from: g */
    protected C0180h f339g;

    /* renamed from: h */
    protected ArrayList<C0180h> f340h;

    /* renamed from: i */
    protected int f341i;

    /* renamed from: j */
    protected int f342j;

    /* renamed from: k */
    protected float f343k = 0.0f;

    /* renamed from: l */
    private int f344l;

    /* renamed from: m */
    private boolean f345m = false;

    /* renamed from: n */
    protected boolean f346n;

    /* renamed from: o */
    protected boolean f347o;

    /* renamed from: p */
    protected boolean f348p;

    /* renamed from: q */
    private boolean f349q;

    public C0173d(C0180h first, int orientation, boolean isRtl) {
        this.f333a = first;
        this.f344l = orientation;
        this.f345m = isRtl;
    }

    /* renamed from: a */
    private static boolean m935a(C0180h widget, int orientation) {
        if (widget.mo3918r() != 8 && widget.f386F[orientation] == C0181a.MATCH_CONSTRAINT) {
            int[] iArr = widget.f420h;
            if (iArr[orientation] == 0 || iArr[orientation] == 3) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m936b() {
        boolean z;
        C0180h next;
        int offset = this.f344l * 2;
        C0180h lastVisited = this.f333a;
        C0180h widget = this.f333a;
        C0180h hVar = this.f333a;
        boolean done = false;
        while (true) {
            z = true;
            if (done) {
                break;
            }
            this.f341i++;
            C0180h[] hVarArr = widget.f443sa;
            int i = this.f344l;
            hVarArr[i] = null;
            widget.f441ra[i] = null;
            if (widget.mo3918r() != 8) {
                if (this.f334b == null) {
                    this.f334b = widget;
                }
                this.f336d = widget;
                C0181a[] aVarArr = widget.f386F;
                int i2 = this.f344l;
                if (aVarArr[i2] == C0181a.MATCH_CONSTRAINT) {
                    int[] iArr = widget.f420h;
                    if (iArr[i2] == 0 || iArr[i2] == 3 || iArr[i2] == 2) {
                        this.f342j++;
                        float[] fArr = widget.f439qa;
                        int i3 = this.f344l;
                        float weight = fArr[i3];
                        if (weight > 0.0f) {
                            this.f343k += fArr[i3];
                        }
                        if (m935a(widget, this.f344l)) {
                            if (weight < 0.0f) {
                                this.f346n = true;
                            } else {
                                this.f347o = true;
                            }
                            if (this.f340h == null) {
                                this.f340h = new ArrayList<>();
                            }
                            this.f340h.add(widget);
                        }
                        if (this.f338f == null) {
                            this.f338f = widget;
                        }
                        C0180h hVar2 = this.f339g;
                        if (hVar2 != null) {
                            hVar2.f441ra[this.f344l] = widget;
                        }
                        this.f339g = widget;
                    }
                }
            }
            if (lastVisited != widget) {
                lastVisited.f443sa[this.f344l] = widget;
            }
            lastVisited = widget;
            C0175f nextAnchor = widget.f384D[offset + 1].f354d;
            if (nextAnchor != null) {
                next = nextAnchor.f352b;
                C0175f[] fVarArr = next.f384D;
                if (fVarArr[offset].f354d == null || fVarArr[offset].f354d.f352b != widget) {
                    next = null;
                }
            } else {
                next = null;
            }
            if (next != null) {
                widget = next;
            } else {
                done = true;
            }
        }
        this.f335c = widget;
        if (this.f344l != 0 || !this.f345m) {
            this.f337e = this.f333a;
        } else {
            this.f337e = this.f335c;
        }
        if (!this.f347o || !this.f346n) {
            z = false;
        }
        this.f348p = z;
    }

    /* renamed from: a */
    public void mo3835a() {
        if (!this.f349q) {
            m936b();
        }
        this.f349q = true;
    }
}
