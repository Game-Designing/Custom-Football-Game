package p019d.p135a.p136a.p138b;

import android.content.Context;
import java.util.List;
import p019d.p135a.p136a.p137a.C6848d;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.C6895h;
import p019d.p135a.p136a.p141d.C6899a;
import p320f.p321a.C13797m;
import p320f.p321a.p322a.p324b.C13187b;
import p320f.p321a.p344h.C13777b;

/* renamed from: d.a.a.b.e */
/* compiled from: ModuleAvailabilityUtil */
public final class C6860e {
    /* renamed from: a */
    public static C6899a m13942a(C6895h paymentModule) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            return new C6861f().mo22291a(paymentModule);
        } catch (ClassNotFoundException classNotFoundException) {
            throw classNotFoundException;
        } catch (IllegalAccessException illegalAccessException) {
            throw illegalAccessException;
        } catch (InstantiationException instantiationException) {
            throw instantiationException;
        }
    }

    /* renamed from: a */
    public static C13797m<List<C6889d>> m13943a(Context context, List<C6889d> unfilteredPaymentMethods) {
        return C13797m.fromIterable(unfilteredPaymentMethods).concatMap(new C6859d(context)).toList().mo43159c().subscribeOn(C13777b.m43848c()).observeOn(C13187b.m43117a());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m13945b(Context context, C6889d paymentMethod, C6848d callback) {
        if (paymentMethod.mo22334g() != null) {
            try {
                m13942a(C6895h.valueOf(paymentMethod.mo22335h())).mo22355a(context, paymentMethod, callback);
            } catch (Exception e) {
                callback.mo22281a(false);
            }
        } else {
            callback.mo22281a(true);
        }
    }
}
