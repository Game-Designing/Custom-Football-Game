package p005cm.aptoide.p006pt.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.p001v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.Translator;

/* renamed from: cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment */
public abstract class GridRecyclerSwipeWithToolbarFragment extends GridRecyclerSwipeFragment {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String TITLE_KEY = "TITLE_KEY";
    @Inject
    String marketName;
    private String title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4667813035815090128L, "cm/aptoide/pt/view/fragment/GridRecyclerSwipeWithToolbarFragment", 17);
        $jacocoData = probes;
        return probes;
    }

    public GridRecyclerSwipeWithToolbarFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[2] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[4] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((CharSequence) Translator.translate(this.title, getContext().getApplicationContext(), this.marketName));
        $jacocoInit[5] = true;
        toolbar.setLogo((int) C1375R.drawable.logo_toolbar);
        $jacocoInit[6] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        super.loadExtras(args);
        $jacocoInit[7] = true;
        this.title = args.getString(TITLE_KEY);
        $jacocoInit[8] = true;
    }

    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        $jacocoInit[9] = true;
        outState.putString(TITLE_KEY, this.title);
        $jacocoInit[10] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[11] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[12] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[13] = true;
            getActivity().onBackPressed();
            $jacocoInit[14] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[15] = true;
        return onOptionsItemSelected;
    }

    public int getContentViewId() {
        $jacocoInit()[16] = true;
        return C1375R.layout.recycler_swipe_fragment_with_toolbar;
    }
}
