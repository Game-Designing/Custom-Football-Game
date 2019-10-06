package p005cm.aptoide.p006pt.bottomNavigation;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.LoginBottomSheetActivity;
import p005cm.aptoide.p006pt.home.AptoideBottomNavigator;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import p026rx.C0120S;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationActivity */
public abstract class BottomNavigationActivity extends LoginBottomSheetActivity implements AptoideBottomNavigator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    protected static final int LAYOUT = 2131427514;
    private final String ITEMS_LIST_KEY = "BN_ITEMS";
    private Animation animationdown;
    private Animation animationup;
    @Inject
    BottomNavigationMapper bottomNavigationMapper;
    @Inject
    BottomNavigationNavigator bottomNavigationNavigator;
    protected BottomNavigationView bottomNavigationView;
    private C14963c<Integer> navigationSubject;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8678884588847497615L, "cm/aptoide/pt/bottomNavigation/BottomNavigationActivity", 49);
        $jacocoData = probes;
        return probes;
    }

    public BottomNavigationActivity() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        ThemeUtils.setAptoideTheme(this, BuildConfig.APTOIDE_THEME);
        $jacocoInit[1] = true;
        setContentView((int) C1375R.layout.frame_layout);
        $jacocoInit[2] = true;
        this.navigationSubject = C14963c.m46753p();
        $jacocoInit[3] = true;
        this.bottomNavigationView = (BottomNavigationView) findViewById(C1375R.C1376id.bottom_navigation);
        $jacocoInit[4] = true;
        super.onCreate(savedInstanceState);
        $jacocoInit[5] = true;
        getActivityComponent().inject(this);
        if (savedInstanceState == null) {
            $jacocoInit[6] = true;
        } else {
            BottomNavigationNavigator bottomNavigationNavigator2 = this.bottomNavigationNavigator;
            $jacocoInit[7] = true;
            ArrayList integerArrayList = savedInstanceState.getIntegerArrayList("BN_ITEMS");
            $jacocoInit[8] = true;
            bottomNavigationNavigator2.setBottomNavigationItems(integerArrayList);
            $jacocoInit[9] = true;
        }
        BottomNavigationViewHelper.disableShiftMode(this.bottomNavigationView);
        $jacocoInit[10] = true;
        this.bottomNavigationView.setOnNavigationItemSelectedListener(new C2648a(this));
        $jacocoInit[11] = true;
        this.animationup = AnimationUtils.loadAnimation(this, C1375R.anim.slide_up);
        $jacocoInit[12] = true;
        this.animationdown = AnimationUtils.loadAnimation(this, C1375R.anim.slide_down);
        $jacocoInit[13] = true;
        toggleBottomNavigation();
        $jacocoInit[14] = true;
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo11524a(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        this.navigationSubject.onNext(Integer.valueOf(item.getItemId()));
        $jacocoInit[48] = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationMapper = null;
        this.bottomNavigationNavigator = null;
        this.navigationSubject = null;
        this.bottomNavigationView = null;
        this.animationdown = null;
        this.animationup = null;
        $jacocoInit[15] = true;
        super.onDestroy();
        $jacocoInit[16] = true;
    }

    public C0120S<Integer> navigationEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Integer> cVar = this.navigationSubject;
        $jacocoInit[17] = true;
        return cVar;
    }

    public void showFragment(Integer menuItemId) {
        boolean[] $jacocoInit = $jacocoInit();
        int bottomNavigationPosition = this.bottomNavigationMapper.mapToBottomNavigationPosition(menuItemId);
        $jacocoInit[18] = true;
        this.bottomNavigationNavigator.navigateToBottomNavigationItem(bottomNavigationPosition);
        $jacocoInit[19] = true;
    }

    public void toggleBottomNavigation() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getFragmentNavigator().getFragment() instanceof NotBottomNavigationView) {
            $jacocoInit[20] = true;
            if (this.bottomNavigationView.getVisibility() == 8) {
                $jacocoInit[21] = true;
            } else {
                $jacocoInit[22] = true;
                this.bottomNavigationView.startAnimation(this.animationdown);
                $jacocoInit[23] = true;
                this.bottomNavigationView.setVisibility(8);
                $jacocoInit[24] = true;
            }
        } else if (this.bottomNavigationView.getVisibility() == 0) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            this.bottomNavigationView.startAnimation(this.animationup);
            $jacocoInit[27] = true;
            this.bottomNavigationView.setVisibility(0);
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
    }

    public void hideBottomNavigation() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.bottomNavigationView.getVisibility() == 8) {
            $jacocoInit[30] = true;
        } else {
            $jacocoInit[31] = true;
            this.bottomNavigationView.setVisibility(8);
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
    }

    public void requestFocus(BottomNavigationItem bottomNavigationItem) {
        boolean[] $jacocoInit = $jacocoInit();
        BottomNavigationMapper bottomNavigationMapper2 = this.bottomNavigationMapper;
        $jacocoInit[34] = true;
        int bottomNavigationPosition = bottomNavigationMapper2.mapToBottomNavigationPosition(bottomNavigationItem);
        $jacocoInit[35] = true;
        Menu menu = this.bottomNavigationView.getMenu();
        $jacocoInit[36] = true;
        MenuItem item = menu.getItem(bottomNavigationPosition);
        $jacocoInit[37] = true;
        item.setChecked(true);
        $jacocoInit[38] = true;
    }

    public void onBackPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        if (getFragmentNavigator().peekLast() != null) {
            $jacocoInit[39] = true;
        } else if (!this.bottomNavigationNavigator.canNavigateBack()) {
            $jacocoInit[40] = true;
        } else {
            $jacocoInit[41] = true;
            this.bottomNavigationNavigator.navigateBack();
            $jacocoInit[42] = true;
            $jacocoInit[44] = true;
        }
        super.onBackPressed();
        $jacocoInit[43] = true;
        $jacocoInit[44] = true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onSaveInstanceState(outState);
        BottomNavigationNavigator bottomNavigationNavigator2 = this.bottomNavigationNavigator;
        $jacocoInit[45] = true;
        ArrayList bottomNavigationItems = bottomNavigationNavigator2.getBottomNavigationItems();
        $jacocoInit[46] = true;
        outState.putIntegerArrayList("BN_ITEMS", bottomNavigationItems);
        $jacocoInit[47] = true;
    }
}
