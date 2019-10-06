package p019d.p143b.p144a.p146b;

import android.content.Context;
import com.applovin.adview.C5861g;
import com.applovin.adview.C5864j;
import java.lang.ref.WeakReference;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.b.c */
public class C6992c implements C5864j {

    /* renamed from: a */
    private static final Object f12990a = new Object();

    /* renamed from: b */
    private static WeakReference<C7007ja> f12991b = new WeakReference<>(null);

    /* renamed from: c */
    private static WeakReference<Context> f12992c = new WeakReference<>(null);

    /* renamed from: a */
    public C5861g mo18326a(C7267q qVar, Context context) {
        C7007ja jaVar;
        if (qVar == null) {
            qVar = C7267q.m15794a(context);
        }
        synchronized (f12990a) {
            jaVar = (C7007ja) f12991b.get();
            if (jaVar != null && jaVar.mo22626i()) {
                if (f12992c.get() == context) {
                    qVar.mo23049b().mo22913a("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
                }
            }
            jaVar = new C7007ja(qVar, context);
            f12991b = new WeakReference<>(jaVar);
            f12992c = new WeakReference<>(context);
        }
        return jaVar;
    }
}
