package p005cm.aptoide.p006pt.updates.view.excluded;

import android.content.Context;
import android.os.Bundle;
import android.support.p001v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.trello.rxlifecycle.p263a.C12543b;
import java.util.LinkedList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.utils.design.ShowMessage;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.fragment.AptoideBaseFragment;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.updates.view.excluded.ExcludedUpdatesFragment */
public class ExcludedUpdatesFragment extends AptoideBaseFragment<BaseAdapter> implements NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = ExcludedUpdatesFragment.class.getSimpleName();
    private TextView emptyData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1341310156520952575L, "cm/aptoide/pt/updates/view/excluded/ExcludedUpdatesFragment", 89);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[88] = true;
    }

    public ExcludedUpdatesFragment() {
        $jacocoInit()[0] = true;
    }

    public static ExcludedUpdatesFragment newInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        ExcludedUpdatesFragment excludedUpdatesFragment = new ExcludedUpdatesFragment();
        $jacocoInit[1] = true;
        return excludedUpdatesFragment;
    }

    public int getContentViewId() {
        $jacocoInit()[2] = true;
        return C1375R.layout.fragment_with_toolbar_no_theme;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[3] = true;
        this.emptyData = (TextView) view.findViewById(C1375R.C1376id.empty_data);
        $jacocoInit[4] = true;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        super.load(create, refresh, savedInstanceState);
        $jacocoInit[5] = true;
        Logger instance = Logger.getInstance();
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("refresh excluded updates? ");
        if (create) {
            $jacocoInit[6] = true;
            str = "yes";
        } else {
            $jacocoInit[7] = true;
            str = "no";
        }
        sb.append(str);
        String sb2 = sb.toString();
        $jacocoInit[8] = true;
        instance.mo2136d(str2, sb2);
        $jacocoInit[9] = true;
        fetchExcludedUpdates();
        $jacocoInit[10] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[11] = true;
        setHasOptionsMenu(true);
        $jacocoInit[12] = true;
    }

    private void fetchExcludedUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[13] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[14] = true;
        $jacocoInit[15] = true;
        UpdateAccessor updateAccessor = (UpdateAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Update.class);
        $jacocoInit[16] = true;
        C0120S all = updateAccessor.getAll(true);
        $jacocoInit[17] = true;
        C0120S a = all.mo3616a(C14522a.m46170a());
        C12543b bVar = C12543b.DESTROY_VIEW;
        $jacocoInit[18] = true;
        C0120S a2 = a.mo3614a((C0121c<? super T, ? extends R>) bindUntilEvent(bVar));
        C5156f fVar = new C5156f(this);
        C5152b bVar2 = new C5152b(this);
        $jacocoInit[19] = true;
        a2.mo3626a((C0129b<? super T>) fVar, (C0129b<Throwable>) bVar2);
        $jacocoInit[20] = true;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.database.realm.Update>, for r7v0, types: [java.util.List, java.util.List<cm.aptoide.pt.database.realm.Update>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void mo16806a(java.util.List<p005cm.aptoide.p006pt.database.realm.Update> r7) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            r1 = 1
            if (r7 != 0) goto L_0x000c
            r2 = 75
            r0[r2] = r1
            goto L_0x0016
        L_0x000c:
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L_0x003b
            r2 = 76
            r0[r2] = r1
        L_0x0016:
            android.widget.TextView r2 = r6.emptyData
            r3 = 2131690202(0x7f0f02da, float:1.900944E38)
            r2.setText(r3)
            r2 = 77
            r0[r2] = r1
            android.widget.TextView r2 = r6.emptyData
            r3 = 0
            r2.setVisibility(r3)
            r2 = 78
            r0[r2] = r1
            r6.clearDisplayables()
            r2 = 79
            r0[r2] = r1
            r6.finishLoading()
            r2 = 80
            r0[r2] = r1
            goto L_0x007f
        L_0x003b:
            android.widget.TextView r2 = r6.emptyData
            r3 = 8
            r2.setVisibility(r3)
            r2 = 81
            r0[r2] = r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 82
            r0[r3] = r1
            java.util.Iterator r3 = r7.iterator()
            r4 = 83
            r0[r4] = r1
        L_0x0057:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0074
            java.lang.Object r4 = r3.next()
            cm.aptoide.pt.database.realm.Update r4 = (p005cm.aptoide.p006pt.database.realm.Update) r4
            r5 = 84
            r0[r5] = r1
            cm.aptoide.pt.updates.view.excluded.ExcludedUpdateDisplayable r5 = new cm.aptoide.pt.updates.view.excluded.ExcludedUpdateDisplayable
            r5.<init>(r4)
            r2.add(r5)
            r4 = 85
            r0[r4] = r1
            goto L_0x0057
        L_0x0074:
            cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment r3 = r6.clearDisplayables()
            r3.addDisplayables(r2, r1)
            r3 = 86
            r0[r3] = r1
        L_0x007f:
            r2 = 87
            r0[r2] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.updates.view.excluded.ExcludedUpdatesFragment.mo16806a(java.util.List):void");
    }

    /* renamed from: a */
    public /* synthetic */ void mo16805a(Throwable t) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[69] = true;
        instance.log(t);
        $jacocoInit[70] = true;
        this.emptyData.setText(C1375R.string.no_excluded_updates_msg);
        $jacocoInit[71] = true;
        this.emptyData.setVisibility(0);
        $jacocoInit[72] = true;
        clearDisplayables();
        $jacocoInit[73] = true;
        finishLoading();
        $jacocoInit[74] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[21] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((int) C1375R.string.excluded_updates);
        $jacocoInit[22] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[23] = true;
        inflater.inflate(C1375R.C1377menu.menu_excluded_updates_fragment, menu);
        $jacocoInit[24] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            $jacocoInit[25] = true;
            getActivity().onBackPressed();
            $jacocoInit[26] = true;
            return true;
        } else if (itemId == C1375R.C1376id.menu_restore_updates) {
            $jacocoInit[27] = true;
            LinkedList<Update> excludedUpdatesToRestore = new LinkedList<>();
            $jacocoInit[28] = true;
            BaseAdapter adapter = getAdapter();
            $jacocoInit[29] = true;
            int i = 0;
            $jacocoInit[30] = true;
            while (i < adapter.getItemCount()) {
                $jacocoInit[31] = true;
                ExcludedUpdateDisplayable displayable = (ExcludedUpdateDisplayable) adapter.getDisplayable(i);
                $jacocoInit[32] = true;
                if (!displayable.isSelected()) {
                    $jacocoInit[33] = true;
                } else {
                    $jacocoInit[34] = true;
                    excludedUpdatesToRestore.add(displayable.getPojo());
                    $jacocoInit[35] = true;
                }
                i++;
                $jacocoInit[36] = true;
            }
            if (excludedUpdatesToRestore.size() == 0) {
                $jacocoInit[37] = true;
                ShowMessage.asSnack((View) this.emptyData, (int) C1375R.string.no_excluded_updates_selected);
                $jacocoInit[38] = true;
                return true;
            }
            $jacocoInit[39] = true;
            Context applicationContext = getContext().getApplicationContext();
            $jacocoInit[40] = true;
            $jacocoInit[41] = true;
            UpdateAccessor updateAccessor = (UpdateAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Update.class);
            $jacocoInit[42] = true;
            C0120S a = C0120S.m629a((Iterable<? extends T>) excludedUpdatesToRestore);
            C5153c cVar = C5153c.f8893a;
            $jacocoInit[43] = true;
            C0120S b = a.mo3636b((C0129b<? super T>) cVar);
            $jacocoInit[44] = true;
            C0120S m = b.mo3675m();
            C5154d dVar = new C5154d(updateAccessor);
            C5155e eVar = C5155e.f8895a;
            $jacocoInit[45] = true;
            m.mo3626a((C0129b<? super T>) dVar, (C0129b<Throwable>) eVar);
            $jacocoInit[46] = true;
            return true;
        } else if (itemId == C1375R.C1376id.menu_select_all) {
            $jacocoInit[47] = true;
            BaseAdapter adapter2 = getAdapter();
            $jacocoInit[48] = true;
            int i2 = 0;
            $jacocoInit[49] = true;
            while (i2 < adapter2.getItemCount()) {
                $jacocoInit[50] = true;
                ((ExcludedUpdateDisplayable) adapter2.getDisplayable(i2)).setSelected(true);
                $jacocoInit[51] = true;
                adapter2.notifyDataSetChanged();
                i2++;
                $jacocoInit[52] = true;
            }
            $jacocoInit[53] = true;
            return true;
        } else if (itemId == C1375R.C1376id.menu_select_none) {
            $jacocoInit[54] = true;
            BaseAdapter adapter3 = getAdapter();
            $jacocoInit[55] = true;
            int i3 = 0;
            $jacocoInit[56] = true;
            while (i3 < adapter3.getItemCount()) {
                $jacocoInit[57] = true;
                ((ExcludedUpdateDisplayable) adapter3.getDisplayable(i3)).setSelected(false);
                $jacocoInit[58] = true;
                adapter3.notifyDataSetChanged();
                i3++;
                $jacocoInit[59] = true;
            }
            $jacocoInit[60] = true;
            return true;
        } else {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
            $jacocoInit[61] = true;
            return onOptionsItemSelected;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m9438a(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        update.setExcluded(false);
        $jacocoInit[68] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9437a(UpdateAccessor updateAccessor, List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        updateAccessor.insertAll(updates);
        $jacocoInit[67] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9439b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[65] = true;
        instance.log(err);
        $jacocoInit[66] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[62] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[63] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[64] = true;
        return build;
    }
}
