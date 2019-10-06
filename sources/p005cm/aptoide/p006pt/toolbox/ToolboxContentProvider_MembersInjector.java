package p005cm.aptoide.p006pt.toolbox;

import android.content.SharedPreferences;
import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.toolbox.ToolboxContentProvider_MembersInjector */
public final class ToolboxContentProvider_MembersInjector implements C13183b<ToolboxContentProvider> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7591295834744540688L, "cm/aptoide/pt/toolbox/ToolboxContentProvider_MembersInjector", 9);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((ToolboxContentProvider) obj);
        $jacocoInit[8] = true;
    }

    public ToolboxContentProvider_MembersInjector(Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<AptoideAccountManager> accountManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authenticationPersistenceProvider = authenticationPersistenceProvider2;
        this.sharedPreferencesProvider = sharedPreferencesProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<ToolboxContentProvider> create(Provider<AuthenticationPersistence> authenticationPersistenceProvider2, Provider<SharedPreferences> sharedPreferencesProvider2, Provider<AptoideAccountManager> accountManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        ToolboxContentProvider_MembersInjector toolboxContentProvider_MembersInjector = new ToolboxContentProvider_MembersInjector(authenticationPersistenceProvider2, sharedPreferencesProvider2, accountManagerProvider2);
        $jacocoInit[1] = true;
        return toolboxContentProvider_MembersInjector;
    }

    public void injectMembers(ToolboxContentProvider instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectAuthenticationPersistence(instance, (AuthenticationPersistence) this.authenticationPersistenceProvider.get());
        $jacocoInit[2] = true;
        injectSharedPreferences(instance, (SharedPreferences) this.sharedPreferencesProvider.get());
        $jacocoInit[3] = true;
        injectAccountManager(instance, (AptoideAccountManager) this.accountManagerProvider.get());
        $jacocoInit[4] = true;
    }

    public static void injectAuthenticationPersistence(ToolboxContentProvider instance, AuthenticationPersistence authenticationPersistence) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.authenticationPersistence = authenticationPersistence;
        $jacocoInit[5] = true;
    }

    public static void injectSharedPreferences(ToolboxContentProvider instance, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.sharedPreferences = sharedPreferences;
        $jacocoInit[6] = true;
    }

    public static void injectAccountManager(ToolboxContentProvider instance, AptoideAccountManager accountManager) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.accountManager = accountManager;
        $jacocoInit[7] = true;
    }
}
