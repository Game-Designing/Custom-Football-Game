package p005cm.aptoide.p006pt.notification.view;

import android.os.Bundle;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.notification.AptoideNotification;
import p005cm.aptoide.p006pt.notification.NotificationCenter;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.fragment.BaseToolbarFragment;
import p026rx.C0120S;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.notification.view.InboxFragment */
public class InboxFragment extends BaseToolbarFragment implements InboxView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private InboxAdapter adapter;
    private LinearLayout emptyState;
    private RecyclerView list;
    private C14963c<AptoideNotification> notificationSubject;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4287912974673181449L, "cm/aptoide/pt/notification/view/InboxFragment", 30);
        $jacocoData = probes;
        return probes;
    }

    public InboxFragment() {
        $jacocoInit()[0] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[1] = true;
            getActivity().onBackPressed();
            $jacocoInit[2] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[3] = true;
        return onOptionsItemSelected;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[4] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[5] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[6] = true;
        return build;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[7] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[8] = true;
        this.notificationSubject = C14963c.m46753p();
        $jacocoInit[9] = true;
        this.adapter = new InboxAdapter(Collections.emptyList(), this.notificationSubject);
        $jacocoInit[10] = true;
        setHasOptionsMenu(true);
        $jacocoInit[11] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[12] = true;
        this.list = (RecyclerView) view.findViewById(C1375R.C1376id.fragment_inbox_list);
        $jacocoInit[13] = true;
        this.list.setAdapter(this.adapter);
        $jacocoInit[14] = true;
        this.list.setLayoutManager(new LinearLayoutManager(getContext()));
        $jacocoInit[15] = true;
        this.emptyState = (LinearLayout) view.findViewById(C1375R.C1376id.empty_state);
        $jacocoInit[16] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[17] = true;
        NotificationCenter notificationCenter = ((AptoideApplication) getContext().getApplicationContext()).getNotificationCenter();
        $jacocoInit[18] = true;
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[19] = true;
        NavigationTracker navigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        $jacocoInit[20] = true;
        InboxPresenter inboxPresenter = new InboxPresenter(this, notificationCenter, instance, navigationTracker, application.getNotificationAnalytics(), C14522a.m46170a());
        $jacocoInit[21] = true;
        attachPresenter(inboxPresenter);
        $jacocoInit[22] = true;
    }

    public void showNotifications(List<AptoideNotification> notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adapter.updateNotifications(notifications);
        $jacocoInit[23] = true;
    }

    public C0120S<AptoideNotification> notificationSelection() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<AptoideNotification> cVar = this.notificationSubject;
        $jacocoInit[24] = true;
        return cVar;
    }

    public void showEmptyState() {
        boolean[] $jacocoInit = $jacocoInit();
        this.emptyState.setVisibility(0);
        $jacocoInit[25] = true;
    }

    public int getContentViewId() {
        $jacocoInit()[26] = true;
        return C1375R.layout.fragment_inbox;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[27] = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupToolbarDetails(toolbar);
        $jacocoInit[28] = true;
        toolbar.setTitle((CharSequence) getString(C1375R.string.myaccount_header_title));
        $jacocoInit[29] = true;
    }
}
