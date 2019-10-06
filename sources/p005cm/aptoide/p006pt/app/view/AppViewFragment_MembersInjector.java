package p005cm.aptoide.p006pt.app.view;

import java.text.DecimalFormat;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.MoPubConsentDialogView;
import p005cm.aptoide.p006pt.view.dialog.DialogUtils;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.app.view.AppViewFragment_MembersInjector */
public final class AppViewFragment_MembersInjector implements C13183b<AppViewFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<MoPubConsentDialogView> consentDialogViewProvider;
    private final Provider<DialogUtils> dialogUtilsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<DecimalFormat> oneDecimalFormatProvider;
    private final Provider<AppViewPresenter> presenterProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8910354653406832361L, "cm/aptoide/pt/app/view/AppViewFragment_MembersInjector", 15);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((AppViewFragment) obj);
        $jacocoInit[14] = true;
    }

    public AppViewFragment_MembersInjector(Provider<AppViewPresenter> presenterProvider2, Provider<DialogUtils> dialogUtilsProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2, Provider<DecimalFormat> oneDecimalFormatProvider2, Provider<MoPubConsentDialogView> consentDialogViewProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.dialogUtilsProvider = dialogUtilsProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.themeProvider = themeProvider2;
        this.oneDecimalFormatProvider = oneDecimalFormatProvider2;
        this.consentDialogViewProvider = consentDialogViewProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<AppViewFragment> create(Provider<AppViewPresenter> presenterProvider2, Provider<DialogUtils> dialogUtilsProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2, Provider<DecimalFormat> oneDecimalFormatProvider2, Provider<MoPubConsentDialogView> consentDialogViewProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewFragment_MembersInjector appViewFragment_MembersInjector = new AppViewFragment_MembersInjector(presenterProvider2, dialogUtilsProvider2, marketNameProvider2, themeProvider2, oneDecimalFormatProvider2, consentDialogViewProvider2);
        $jacocoInit[1] = true;
        return appViewFragment_MembersInjector;
    }

    public void injectMembers(AppViewFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (AppViewPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectDialogUtils(instance, (DialogUtils) this.dialogUtilsProvider.get());
        $jacocoInit[3] = true;
        injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[4] = true;
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[5] = true;
        injectOneDecimalFormat(instance, (DecimalFormat) this.oneDecimalFormatProvider.get());
        $jacocoInit[6] = true;
        injectConsentDialogView(instance, (MoPubConsentDialogView) this.consentDialogViewProvider.get());
        $jacocoInit[7] = true;
    }

    public static void injectPresenter(AppViewFragment instance, AppViewPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[8] = true;
    }

    public static void injectDialogUtils(AppViewFragment instance, DialogUtils dialogUtils) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.dialogUtils = dialogUtils;
        $jacocoInit[9] = true;
    }

    public static void injectMarketName(AppViewFragment instance, String marketName) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.marketName = marketName;
        $jacocoInit[10] = true;
    }

    public static void injectTheme(AppViewFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[11] = true;
    }

    public static void injectOneDecimalFormat(AppViewFragment instance, DecimalFormat oneDecimalFormat) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.oneDecimalFormat = oneDecimalFormat;
        $jacocoInit[12] = true;
    }

    public static void injectConsentDialogView(AppViewFragment instance, MoPubConsentDialogView consentDialogView) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.consentDialogView = consentDialogView;
        $jacocoInit[13] = true;
    }
}
