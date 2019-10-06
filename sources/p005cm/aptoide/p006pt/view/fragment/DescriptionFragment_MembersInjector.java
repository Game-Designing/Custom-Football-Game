package p005cm.aptoide.p006pt.view.fragment;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.fragment.DescriptionFragment_MembersInjector */
public final class DescriptionFragment_MembersInjector implements C13183b<DescriptionFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-332221352903783949L, "cm/aptoide/pt/view/fragment/DescriptionFragment_MembersInjector", 5);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((DescriptionFragment) obj);
        $jacocoInit[4] = true;
    }

    public DescriptionFragment_MembersInjector(Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.themeProvider = themeProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<DescriptionFragment> create(Provider<String> themeProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        DescriptionFragment_MembersInjector descriptionFragment_MembersInjector = new DescriptionFragment_MembersInjector(themeProvider2);
        $jacocoInit[1] = true;
        return descriptionFragment_MembersInjector;
    }

    public void injectMembers(DescriptionFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[2] = true;
    }

    public static void injectTheme(DescriptionFragment instance, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.theme = theme;
        $jacocoInit[3] = true;
    }
}
