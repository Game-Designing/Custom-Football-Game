package p005cm.aptoide.p006pt;

import javax.inject.Singleton;
import p005cm.aptoide.p006pt.install.InstallService;
import p005cm.aptoide.p006pt.install.InstalledIntentService;
import p005cm.aptoide.p006pt.notification.PullingContentService;
import p005cm.aptoide.p006pt.toolbox.ToolboxContentProvider;
import p005cm.aptoide.p006pt.view.ActivityComponent;
import p005cm.aptoide.p006pt.view.ActivityModule;

@Singleton
/* renamed from: cm.aptoide.pt.ApplicationComponent */
public interface ApplicationComponent {
    void inject(AptoideApplication aptoideApplication);

    void inject(NotificationApplicationView notificationApplicationView);

    void inject(InstallService installService);

    void inject(InstalledIntentService installedIntentService);

    void inject(PullingContentService pullingContentService);

    void inject(ToolboxContentProvider toolboxContentProvider);

    ActivityComponent plus(ActivityModule activityModule, FlavourActivityModule flavourActivityModule);
}
