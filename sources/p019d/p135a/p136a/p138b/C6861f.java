package p019d.p135a.p136a.p138b;

import p019d.p135a.p136a.p139c.C6895h;
import p019d.p135a.p136a.p141d.C6899a;

/* renamed from: d.a.a.b.f */
/* compiled from: PaymentMethodServiceFactory */
public class C6861f {
    /* renamed from: a */
    public C6899a mo22291a(C6895h paymentModule) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (C6899a) Class.forName(paymentModule.mo22342e()).newInstance();
    }
}
