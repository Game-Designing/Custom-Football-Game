package p005cm.aptoide.p006pt.view.wizard;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.wizard.WizardPageTwoFragment_MembersInjector */
public final class WizardPageTwoFragment_MembersInjector implements C13183b<WizardPageTwoFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1427919052615550814L, "cm/aptoide/pt/view/wizard/WizardPageTwoFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((WizardPageTwoFragment) obj);
        $jacocoInit[4] = true;
    }

    public WizardPageTwoFragment_MembersInjector(Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<WizardPageTwoFragment> create(Provider<MarketResourceFormatter> marketResourceFormatterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        WizardPageTwoFragment_MembersInjector wizardPageTwoFragment_MembersInjector = new WizardPageTwoFragment_MembersInjector(marketResourceFormatterProvider2);
        $jacocoInit[1] = true;
        return wizardPageTwoFragment_MembersInjector;
    }

    public void injectMembers(WizardPageTwoFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMarketResourceFormatter(instance, (MarketResourceFormatter) this.marketResourceFormatterProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectMarketResourceFormatter(WizardPageTwoFragment instance, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketResourceFormatter = marketResourceFormatter;
        $jacocoInit[3] = true;
    }
}
