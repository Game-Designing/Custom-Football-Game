package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.p035a.C0175f.C0178c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: android.support.constraint.a.a.j */
/* compiled from: ConstraintWidgetGroup */
public class C0183j {

    /* renamed from: a */
    public List<C0180h> f480a;

    /* renamed from: b */
    int f481b = -1;

    /* renamed from: c */
    int f482c = -1;

    /* renamed from: d */
    public boolean f483d = false;

    /* renamed from: e */
    public final int[] f484e = {this.f481b, this.f482c};

    /* renamed from: f */
    List<C0180h> f485f = new ArrayList();

    /* renamed from: g */
    List<C0180h> f486g = new ArrayList();

    /* renamed from: h */
    HashSet<C0180h> f487h = new HashSet<>();

    /* renamed from: i */
    HashSet<C0180h> f488i = new HashSet<>();

    /* renamed from: j */
    List<C0180h> f489j = new ArrayList();

    /* renamed from: k */
    List<C0180h> f490k = new ArrayList();

    C0183j(List<C0180h> widgets) {
        this.f480a = widgets;
    }

    C0183j(List<C0180h> widgets, boolean skipSolver) {
        this.f480a = widgets;
        this.f483d = skipSolver;
    }

    /* renamed from: a */
    public List<C0180h> mo3947a(int orientation) {
        if (orientation == 0) {
            return this.f485f;
        }
        if (orientation == 1) {
            return this.f486g;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Set<C0180h> mo3949b(int orientation) {
        if (orientation == 0) {
            return this.f487h;
        }
        if (orientation == 1) {
            return this.f488i;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3948a(C0180h widget, int orientation) {
        if (orientation == 0) {
            this.f487h.add(widget);
        } else if (orientation == 1) {
            this.f488i.add(widget);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C0180h> mo3946a() {
        if (!this.f489j.isEmpty()) {
            return this.f489j;
        }
        int size = this.f480a.size();
        for (int i = 0; i < size; i++) {
            C0180h widget = (C0180h) this.f480a.get(i);
            if (!widget.f425ja) {
                m1061a((ArrayList) this.f489j, widget);
            }
        }
        this.f490k.clear();
        this.f490k.addAll(this.f480a);
        this.f490k.removeAll(this.f489j);
        return this.f489j;
    }

    /* renamed from: a */
    private void m1061a(ArrayList<C0180h> widgetsToSolve, C0180h widget) {
        if (!widget.f429la) {
            widgetsToSolve.add(widget);
            widget.f429la = true;
            if (!widget.mo3928y()) {
                if (widget instanceof C0186m) {
                    C0186m helper = (C0186m) widget;
                    int widgetCount = helper.f502wa;
                    for (int i = 0; i < widgetCount; i++) {
                        m1061a(widgetsToSolve, helper.f501va[i]);
                    }
                }
                for (C0175f fVar : widget.f384D) {
                    C0175f targetAnchor = fVar.f354d;
                    if (targetAnchor != null) {
                        C0180h targetWidget = targetAnchor.f352b;
                        if (!(targetAnchor == null || targetWidget == widget.mo3904k())) {
                            m1061a(widgetsToSolve, targetWidget);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo3950b() {
        int size = this.f490k.size();
        for (int i = 0; i < size; i++) {
            m1060a((C0180h) this.f490k.get(i));
        }
    }

    /* renamed from: a */
    private void m1060a(C0180h widget) {
        C0175f targetAnchor;
        int end;
        C0175f targetAnchor2;
        int end2;
        int end3 = 0;
        if (widget.f425ja && !widget.mo3928y()) {
            boolean bottomSide = false;
            boolean rightSide = widget.f450x.f354d != null;
            if (rightSide) {
                targetAnchor = widget.f450x.f354d;
            } else {
                targetAnchor = widget.f448v.f354d;
            }
            if (targetAnchor != null) {
                C0180h hVar = targetAnchor.f352b;
                if (!hVar.f427ka) {
                    m1060a(hVar);
                }
                C0178c cVar = targetAnchor.f353c;
                if (cVar == C0178c.RIGHT) {
                    C0180h hVar2 = targetAnchor.f352b;
                    end3 = hVar2.f392L + hVar2.mo3920s();
                } else if (cVar == C0178c.LEFT) {
                    end3 = targetAnchor.f352b.f392L;
                }
            }
            if (rightSide) {
                end = end3 - widget.f450x.mo3841b();
            } else {
                end = end3 + widget.f448v.mo3841b() + widget.mo3920s();
            }
            widget.mo3860a(end - widget.mo3920s(), end);
            C0175f fVar = widget.f452z;
            if (fVar.f354d != null) {
                C0175f targetAnchor3 = fVar.f354d;
                C0180h hVar3 = targetAnchor3.f352b;
                if (!hVar3.f427ka) {
                    m1060a(hVar3);
                }
                C0180h hVar4 = targetAnchor3.f352b;
                int start = (hVar4.f393M + hVar4.f402V) - widget.f402V;
                widget.mo3893e(start, widget.f389I + start);
                widget.f427ka = true;
                return;
            }
            if (widget.f451y.f354d != null) {
                bottomSide = true;
            }
            if (bottomSide) {
                targetAnchor2 = widget.f451y.f354d;
            } else {
                targetAnchor2 = widget.f449w.f354d;
            }
            if (targetAnchor2 != null) {
                C0180h hVar5 = targetAnchor2.f352b;
                if (!hVar5.f427ka) {
                    m1060a(hVar5);
                }
                C0178c cVar2 = targetAnchor2.f353c;
                if (cVar2 == C0178c.BOTTOM) {
                    C0180h hVar6 = targetAnchor2.f352b;
                    end = hVar6.f393M + hVar6.mo3900i();
                } else if (cVar2 == C0178c.TOP) {
                    end = targetAnchor2.f352b.f393M;
                }
            }
            if (bottomSide) {
                end2 = end - widget.f451y.mo3841b();
            } else {
                end2 = end + widget.f449w.mo3841b() + widget.mo3900i();
            }
            widget.mo3893e(end2 - widget.mo3900i(), end2);
            widget.f427ka = true;
        }
    }
}
