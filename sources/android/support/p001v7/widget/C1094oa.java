package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0991p;
import android.support.p001v7.widget.RecyclerView.C0997t;
import android.view.View;

/* renamed from: android.support.v7.widget.oa */
/* compiled from: LayoutState */
class C1094oa {

    /* renamed from: a */
    boolean f3651a = true;

    /* renamed from: b */
    int f3652b;

    /* renamed from: c */
    int f3653c;

    /* renamed from: d */
    int f3654d;

    /* renamed from: e */
    int f3655e;

    /* renamed from: f */
    int f3656f = 0;

    /* renamed from: g */
    int f3657g = 0;

    /* renamed from: h */
    boolean f3658h;

    /* renamed from: i */
    boolean f3659i;

    C1094oa() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8561a(C0997t state) {
        int i = this.f3653c;
        return i >= 0 && i < state.mo7945a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo8560a(C0991p recycler) {
        View view = recycler.mo7912d(this.f3653c);
        this.f3653c += this.f3654d;
        return view;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LayoutState{mAvailable=");
        sb.append(this.f3652b);
        sb.append(", mCurrentPosition=");
        sb.append(this.f3653c);
        sb.append(", mItemDirection=");
        sb.append(this.f3654d);
        sb.append(", mLayoutDirection=");
        sb.append(this.f3655e);
        sb.append(", mStartLine=");
        sb.append(this.f3656f);
        sb.append(", mEndLine=");
        sb.append(this.f3657g);
        sb.append('}');
        return sb.toString();
    }
}
