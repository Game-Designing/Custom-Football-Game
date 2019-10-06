package p019d.p135a.p136a.p139c.p140a;

import java.util.Collection;

/* renamed from: d.a.a.c.a.a */
/* compiled from: CreditCardPaymentDetails */
public class C6879a extends C6884d {
    public C6879a(Collection<C6881c> inputDetails) {
        super(inputDetails);
    }

    /* renamed from: a */
    public boolean mo22302a(String cardToken) {
        return super.mo22320a("additionalData.card.encrypted.json", cardToken);
    }

    /* renamed from: a */
    public boolean mo22304a(boolean storeDetails) {
        return super.mo22321a("storeDetails", storeDetails);
    }

    /* renamed from: a */
    public boolean mo22303a(short numberOfInstallments) {
        return super.mo22320a("installments", String.valueOf(numberOfInstallments));
    }
}
