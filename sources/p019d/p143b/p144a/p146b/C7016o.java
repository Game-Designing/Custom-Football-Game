package p019d.p143b.p144a.p146b;

import android.content.Context;
import android.view.View;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.o */
public abstract class C7016o extends View {

    /* renamed from: a */
    protected final C7267q f13080a;

    /* renamed from: b */
    protected final Context f13081b;

    C7016o(C7267q qVar, Context context) {
        super(context);
        this.f13081b = context;
        this.f13080a = qVar;
    }

    /* renamed from: a */
    public static C7016o m14497a(C7267q qVar, Context context, C7018p pVar) {
        return pVar.equals(C7018p.Invisible) ? new C7011la(qVar, context) : pVar.equals(C7018p.WhiteXOnTransparentGrey) ? new C7015na(qVar, context) : new C7031va(qVar, context);
    }

    /* renamed from: a */
    public abstract void mo22636a(int i);
}
