package p005cm.aptoide.p006pt.view;

import android.content.Intent;
import android.os.Bundle;
import com.trello.rxlifecycle.p017b.p018a.C0093a;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ApplicationComponent;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.FlavourActivityModule;
import p005cm.aptoide.p006pt.notification.NotificationSyncScheduler;
import p005cm.aptoide.p006pt.presenter.View;

/* renamed from: cm.aptoide.pt.view.BaseActivity */
public abstract class BaseActivity extends C0093a {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ActivityComponent activityComponent;
    private boolean firstCreated;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4161390639504516615L, "cm/aptoide/pt/view/BaseActivity", 15);
        $jacocoData = probes;
        return probes;
    }

    public BaseActivity() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        this.firstCreated = z;
        $jacocoInit[3] = true;
        getActivityComponent().inject(this);
        $jacocoInit[4] = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.activityComponent = null;
        $jacocoInit[5] = true;
        super.onDestroy();
        $jacocoInit[6] = true;
    }

    public ActivityComponent getActivityComponent() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.activityComponent != null) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            AptoideApplication aptoideApplication = (AptoideApplication) getApplication();
            $jacocoInit[9] = true;
            ApplicationComponent applicationComponent = aptoideApplication.getApplicationComponent();
            $jacocoInit[10] = true;
            Intent intent = getIntent();
            $jacocoInit[11] = true;
            NotificationSyncScheduler notificationSyncScheduler = aptoideApplication.getNotificationSyncScheduler();
            View view = (View) this;
            boolean z = this.firstCreated;
            $jacocoInit[12] = true;
            this.activityComponent = applicationComponent.plus(aptoideApplication.getActivityModule(this, intent, notificationSyncScheduler, view, z, "cm.aptoide.pt.provider"), new FlavourActivityModule());
            $jacocoInit[13] = true;
        }
        ActivityComponent activityComponent2 = this.activityComponent;
        $jacocoInit[14] = true;
        return activityComponent2;
    }
}
