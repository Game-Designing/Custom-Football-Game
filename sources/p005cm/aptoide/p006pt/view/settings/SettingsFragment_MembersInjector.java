package p005cm.aptoide.p006pt.view.settings;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.util.MarketResourceFormatter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.settings.SettingsFragment_MembersInjector */
public final class SettingsFragment_MembersInjector implements C13183b<SettingsFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> marketNameProvider;
    private final Provider<MarketResourceFormatter> marketResourceFormatterProvider;
    private final Provider<SupportEmailProvider> supportEmailProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4466078750167228136L, "cm/aptoide/pt/view/settings/SettingsFragment_MembersInjector", 11);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((SettingsFragment) obj);
        $jacocoInit[10] = true;
    }

    public SettingsFragment_MembersInjector(Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2, Provider<String> themeProvider2, Provider<SupportEmailProvider> supportEmailProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.marketNameProvider = marketNameProvider2;
        this.marketResourceFormatterProvider = marketResourceFormatterProvider2;
        this.themeProvider = themeProvider2;
        this.supportEmailProvider = supportEmailProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<SettingsFragment> create(Provider<String> marketNameProvider2, Provider<MarketResourceFormatter> marketResourceFormatterProvider2, Provider<String> themeProvider2, Provider<SupportEmailProvider> supportEmailProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        SettingsFragment_MembersInjector settingsFragment_MembersInjector = new SettingsFragment_MembersInjector(marketNameProvider2, marketResourceFormatterProvider2, themeProvider2, supportEmailProvider2);
        $jacocoInit[1] = true;
        return settingsFragment_MembersInjector;
    }

    public void injectMembers(SettingsFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[2] = true;
        injectMarketResourceFormatter(instance, (MarketResourceFormatter) this.marketResourceFormatterProvider.get());
        $jacocoInit[3] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[4] = true;
        injectSupportEmailProvider(instance, (SupportEmailProvider) this.supportEmailProvider.get());
        $jacocoInit[5] = true;
    }

    public static void injectMarketName(SettingsFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[6] = true;
    }

    public static void injectMarketResourceFormatter(SettingsFragment instance, MarketResourceFormatter marketResourceFormatter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketResourceFormatter = marketResourceFormatter;
        $jacocoInit[7] = true;
    }

    public static void injectTheme(SettingsFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[8] = true;
    }

    public static void injectSupportEmailProvider(SettingsFragment instance, SupportEmailProvider supportEmailProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.supportEmailProvider = supportEmailProvider2;
        $jacocoInit[9] = true;
    }
}
