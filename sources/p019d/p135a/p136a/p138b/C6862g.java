package p019d.p135a.p136a.p138b;

import android.util.Log;
import p019d.p135a.p136a.p137a.C6852h;
import p019d.p135a.p136a.p137a.C6852h.C6853a;

/* renamed from: d.a.a.b.g */
/* compiled from: PaymentProcessorStateMachine */
public class C6862g implements C6852h, C6853a {

    /* renamed from: a */
    private static final String f12569a = C6862g.class.getSimpleName();

    /* renamed from: b */
    private C6852h f12570b = C6874s.IDLE;

    /* renamed from: c */
    private C6853a f12571c;

    public C6862g(C6853a stateChangeListener) {
        Log.d(f12569a, "PaymentProcessorStateMachine() constructed");
        this.f12571c = stateChangeListener;
    }

    /* renamed from: b */
    public void mo22285b(C6852h state) {
        this.f12570b = state;
        this.f12571c.mo22285b(this.f12570b);
    }

    /* renamed from: a */
    public void mo22284a(C6852h state) {
        this.f12571c.mo22284a(this.f12570b);
    }

    /* renamed from: a */
    public C6852h mo22283a(C6875t paymentTrigger) {
        C6852h newState = this.f12570b.mo22283a(paymentTrigger);
        C6852h hVar = this.f12570b;
        if (hVar != newState) {
            this.f12570b = newState;
            mo22285b(newState);
        } else {
            mo22284a(hVar);
        }
        return newState;
    }
}
