package p005cm.aptoide.p006pt.billing.view.login;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.billing.view.login.PaymentLoginFragment_MembersInjector */
public final class PaymentLoginFragment_MembersInjector implements C13183b<PaymentLoginFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;
    private final Provider<PaymentLoginFlavorPresenter> presenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5138619303264325540L, "cm/aptoide/pt/billing/view/login/PaymentLoginFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((PaymentLoginFragment) obj);
        $jacocoInit[6] = true;
    }

    public PaymentLoginFragment_MembersInjector(Provider<PaymentLoginFlavorPresenter> presenterProvider2, Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.marketNameProvider = marketNameProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<PaymentLoginFragment> create(Provider<PaymentLoginFlavorPresenter> presenterProvider2, Provider<String> marketNameProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        PaymentLoginFragment_MembersInjector paymentLoginFragment_MembersInjector = new PaymentLoginFragment_MembersInjector(presenterProvider2, marketNameProvider2);
        $jacocoInit[1] = true;
        return paymentLoginFragment_MembersInjector;
    }

    public void injectMembers(PaymentLoginFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (PaymentLoginFlavorPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectPresenter(PaymentLoginFragment instance, PaymentLoginFlavorPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[4] = true;
    }

    public static void injectMarketName(PaymentLoginFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[5] = true;
    }
}
