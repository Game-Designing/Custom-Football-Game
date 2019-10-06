package p019d.p135a.p136a.p139c.p140a;

import java.util.Collection;

/* renamed from: d.a.a.c.a.e */
/* compiled from: SepaDirectDebitPaymentDetails */
public class C6885e extends C6884d {
    public C6885e(Collection<C6881c> inputDetails) {
        super(inputDetails);
    }

    /* renamed from: a */
    public boolean mo22322a(String iban) {
        return super.mo22320a("sepa.ibanNumber", iban);
    }

    /* renamed from: b */
    public boolean mo22323b(String owner) {
        return super.mo22320a("sepa.ownerName", owner);
    }
}
