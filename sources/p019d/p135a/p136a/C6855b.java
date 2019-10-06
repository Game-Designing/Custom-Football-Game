package p019d.p135a.p136a;

import android.content.Context;
import com.adyen.core.exceptions.UIModuleNotAvailableException;
import java.lang.reflect.InvocationTargetException;
import p019d.p135a.p136a.p137a.C6850f;
import p019d.p135a.p136a.p137a.C6851g;

/* renamed from: d.a.a.b */
/* compiled from: ListenerFactory */
final class C6855b {
    /* renamed from: b */
    static C6851g m13932b(Context context) throws UIModuleNotAvailableException {
        C6851g listener = (C6851g) m13931a(context, "com.adyen.ui.DefaultPaymentRequestListener");
        if (listener != null) {
            return listener;
        }
        throw new UIModuleNotAvailableException("UI module not available. Import adyen-ui or provide a PaymentRequestDetailsListener to PaymentRequest.");
    }

    /* renamed from: a */
    static C6850f m13930a(Context context) throws UIModuleNotAvailableException {
        C6850f detailsListener = (C6850f) m13931a(context, "com.adyen.ui.DefaultPaymentRequestDetailsListener");
        if (detailsListener != null) {
            return detailsListener;
        }
        throw new UIModuleNotAvailableException("UI module not available. Import adyen-ui or provide a PaymentRequestDetailsListener to PaymentRequest.");
    }

    /* renamed from: a */
    private static Object m13931a(Context context, String clazz) {
        try {
            return Class.forName(clazz).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
