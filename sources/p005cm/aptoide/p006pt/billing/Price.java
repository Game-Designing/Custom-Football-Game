package p005cm.aptoide.p006pt.billing;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.billing.Price */
public class Price {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final double amount;
    private final String currency;
    private final String currencySymbol;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6500994340999663055L, "cm/aptoide/pt/billing/Price", 4);
        $jacocoData = probes;
        return probes;
    }

    public Price(double amount2, String currency2, String currencySymbol2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.amount = amount2;
        this.currency = currency2;
        this.currencySymbol = currencySymbol2;
        $jacocoInit[0] = true;
    }

    public String getCurrencySymbol() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.currencySymbol;
        $jacocoInit[1] = true;
        return str;
    }

    public double getAmount() {
        boolean[] $jacocoInit = $jacocoInit();
        double d = this.amount;
        $jacocoInit[2] = true;
        return d;
    }

    public String getCurrency() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.currency;
        $jacocoInit[3] = true;
        return str;
    }
}
