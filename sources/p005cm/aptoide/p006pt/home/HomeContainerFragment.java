package p005cm.aptoide.p006pt.home;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationActivity;
import p005cm.aptoide.p006pt.bottomNavigation.BottomNavigationItem;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.promotions.PromotionsHomeDialog;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.home.HomeContainerFragment */
public class HomeContainerFragment extends NavigationTrackFragment implements HomeContainerView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.HOME;
    private AppBarLayout appBarLayout;
    private CheckBox appsChip;
    private BottomNavigationActivity bottomNavigationActivity;
    private C14963c<ChipsEvents> chipCheckedEvent;
    private CheckBox gamesChip;
    private LoggedInTermsAndConditionsDialog gdprDialog;
    @Inject
    HomeContainerPresenter presenter;
    private PromotionsHomeDialog promotionsHomeDialog;
    private ImageView promotionsIcon;
    private TextView promotionsTicker;
    @Inject
    String theme;
    private ImageView userAvatar;

    /* renamed from: cm.aptoide.pt.home.HomeContainerFragment$ChipsEvents */
    public enum ChipsEvents {
        GAMES,
        APPS,
        HOME;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1209822028920637943L, "cm/aptoide/pt/home/HomeContainerFragment", 96);
        $jacocoData = probes;
        return probes;
    }

    public HomeContainerFragment() {
        $jacocoInit()[0] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[95] = true;
    }

    public void onAttach(Activity activity) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttach(activity);
        if (!(activity instanceof BottomNavigationActivity)) {
            $jacocoInit[1] = true;
        } else {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        $jacocoInit[4] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[5] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[6] = true;
        this.chipCheckedEvent = C14963c.m46753p();
        $jacocoInit[7] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[8] = true;
        this.userAvatar = (ImageView) view.findViewById(C1375R.C1376id.user_actionbar_icon);
        $jacocoInit[9] = true;
        this.promotionsIcon = (ImageView) view.findViewById(C1375R.C1376id.promotions_icon);
        $jacocoInit[10] = true;
        this.promotionsTicker = (TextView) view.findViewById(C1375R.C1376id.promotions_ticker);
        $jacocoInit[11] = true;
        this.promotionsHomeDialog = new PromotionsHomeDialog(getContext());
        $jacocoInit[12] = true;
        this.gdprDialog = new LoggedInTermsAndConditionsDialog(getContext());
        BottomNavigationActivity bottomNavigationActivity2 = this.bottomNavigationActivity;
        if (bottomNavigationActivity2 == null) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            bottomNavigationActivity2.requestFocus(BOTTOM_NAVIGATION_ITEM);
            $jacocoInit[15] = true;
        }
        this.gamesChip = (CheckBox) view.findViewById(C1375R.C1376id.games_chip);
        $jacocoInit[16] = true;
        this.appsChip = (CheckBox) view.findViewById(C1375R.C1376id.apps_chip);
        $jacocoInit[17] = true;
        this.appBarLayout = (AppBarLayout) view.findViewById(C1375R.C1376id.app_bar_layout);
        $jacocoInit[18] = true;
        this.gamesChip.setOnCheckedChangeListener(new C3398K(this));
        $jacocoInit[19] = true;
        this.appsChip.setOnCheckedChangeListener(new C3403L(this));
        $jacocoInit[20] = true;
        attachPresenter(this.presenter);
        $jacocoInit[21] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14338a(CompoundButton __, boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isChecked) {
            $jacocoInit[89] = true;
            this.gamesChip.setTextColor(getResources().getColor(C1375R.color.white));
            $jacocoInit[90] = true;
        } else {
            CheckBox checkBox = this.gamesChip;
            Resources resources = getResources();
            StoreTheme storeTheme = StoreTheme.get(this.theme);
            $jacocoInit[91] = true;
            int darkerColor = storeTheme.getDarkerColor();
            $jacocoInit[92] = true;
            checkBox.setTextColor(resources.getColor(darkerColor));
            $jacocoInit[93] = true;
        }
        $jacocoInit[94] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14342b(CompoundButton __, boolean isChecked) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isChecked) {
            $jacocoInit[83] = true;
            this.appsChip.setTextColor(getResources().getColor(C1375R.color.white));
            $jacocoInit[84] = true;
        } else {
            CheckBox checkBox = this.appsChip;
            Resources resources = getResources();
            StoreTheme storeTheme = StoreTheme.get(this.theme);
            $jacocoInit[85] = true;
            int darkerColor = storeTheme.getDarkerColor();
            $jacocoInit[86] = true;
            checkBox.setTextColor(resources.getColor(darkerColor));
            $jacocoInit[87] = true;
        }
        $jacocoInit[88] = true;
    }

    public void onResume() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onResume();
        ChipsEvents checked = ChipsEvents.HOME;
        $jacocoInit[22] = true;
        if (this.gamesChip.isChecked()) {
            checked = ChipsEvents.GAMES;
            $jacocoInit[23] = true;
        } else if (!this.appsChip.isChecked()) {
            $jacocoInit[24] = true;
        } else {
            checked = ChipsEvents.APPS;
            $jacocoInit[25] = true;
        }
        this.chipCheckedEvent.onNext(checked);
        $jacocoInit[26] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[27] = true;
        String simpleName = cls.getSimpleName();
        String name = StoreContext.home.name();
        $jacocoInit[28] = true;
        ScreenTagHistory build = Builder.build(simpleName, "", name);
        $jacocoInit[29] = true;
        return build;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_home_container, container, false);
        $jacocoInit[30] = true;
        return inflate;
    }

    public void onDetach() {
        boolean[] $jacocoInit = $jacocoInit();
        this.bottomNavigationActivity = null;
        $jacocoInit[31] = true;
        super.onDetach();
        $jacocoInit[32] = true;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        PromotionsHomeDialog promotionsHomeDialog2 = this.promotionsHomeDialog;
        if (promotionsHomeDialog2 == null) {
            $jacocoInit[33] = true;
        } else {
            $jacocoInit[34] = true;
            promotionsHomeDialog2.destroyDialog();
            this.promotionsHomeDialog = null;
            $jacocoInit[35] = true;
        }
        LoggedInTermsAndConditionsDialog loggedInTermsAndConditionsDialog = this.gdprDialog;
        if (loggedInTermsAndConditionsDialog == null) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            loggedInTermsAndConditionsDialog.destroyDialog();
            this.gdprDialog = null;
            $jacocoInit[38] = true;
        }
        this.promotionsIcon = null;
        this.promotionsTicker = null;
        this.userAvatar = null;
        this.gamesChip = null;
        this.appsChip = null;
        $jacocoInit[39] = true;
    }

    public void setUserImage(String userAvatarUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[40] = true;
        with.loadWithShadowCircleTransformWithPlaceholder(userAvatarUrl, imageView, C1375R.drawable.ic_account_circle);
        $jacocoInit[41] = true;
    }

    public void setDefaultUserImage() {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.userAvatar;
        $jacocoInit[42] = true;
        with.loadUsingCircleTransform((int) C1375R.drawable.ic_account_circle, imageView);
        $jacocoInit[43] = true;
    }

    public void showAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.userAvatar.setVisibility(0);
        $jacocoInit[44] = true;
    }

    public C0120S<Void> toolbarUserClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.userAvatar);
        $jacocoInit[45] = true;
        return a;
    }

    public C0120S<Void> toolbarPromotionsClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.promotionsIcon);
        $jacocoInit[46] = true;
        return a;
    }

    public void showPromotionsHomeIcon(HomePromotionsWrapper homePromotionsWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsIcon.setVisibility(0);
        $jacocoInit[47] = true;
        if (homePromotionsWrapper.getPromotions() <= 0) {
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            if (homePromotionsWrapper.getPromotions() >= 10) {
                $jacocoInit[50] = true;
            } else {
                $jacocoInit[51] = true;
                if (homePromotionsWrapper.getTotalUnclaimedAppcValue() <= 0.0f) {
                    $jacocoInit[52] = true;
                } else {
                    $jacocoInit[53] = true;
                    this.promotionsTicker.setText(Integer.toString(homePromotionsWrapper.getPromotions()));
                    $jacocoInit[54] = true;
                    this.promotionsTicker.setVisibility(0);
                    $jacocoInit[56] = true;
                }
            }
            this.promotionsTicker.setText("9+");
            $jacocoInit[55] = true;
            this.promotionsTicker.setVisibility(0);
            $jacocoInit[56] = true;
        }
        $jacocoInit[57] = true;
    }

    public void showPromotionsHomeDialog(HomePromotionsWrapper homePromotionsWrapper) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsHomeDialog.showDialog(homePromotionsWrapper);
        $jacocoInit[58] = true;
    }

    public void hidePromotionsIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsIcon.setVisibility(8);
        $jacocoInit[59] = true;
        this.promotionsTicker.setVisibility(8);
        $jacocoInit[60] = true;
    }

    public C0120S<String> promotionsHomeDialogClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<String> dialogClicked = this.promotionsHomeDialog.dialogClicked();
        $jacocoInit[61] = true;
        return dialogClicked;
    }

    public void dismissPromotionsDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsHomeDialog.dismissDialog();
        $jacocoInit[62] = true;
    }

    public void showTermsAndConditionsDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.gdprDialog.showDialog();
        $jacocoInit[63] = true;
    }

    public C0120S<String> gdprDialogClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<String> dialogClicked = this.gdprDialog.dialogClicked();
        $jacocoInit[64] = true;
        return dialogClicked;
    }

    public C0120S<Boolean> gamesChipClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.gamesChip);
        C3388I i = new C3388I(this);
        $jacocoInit[65] = true;
        C0120S j = a.mo3669j(i);
        C3393J j2 = new C3393J(this);
        $jacocoInit[66] = true;
        C0120S<Boolean> b = j.mo3636b((C0129b<? super T>) j2);
        $jacocoInit[67] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ Boolean mo14341b(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.gamesChip.isChecked());
        $jacocoInit[82] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14343b(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.appsChip.isChecked()) {
            $jacocoInit[79] = true;
        } else {
            this.appsChip.setChecked(false);
            $jacocoInit[80] = true;
        }
        $jacocoInit[81] = true;
    }

    public C0120S<Boolean> appsChipClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.appsChip);
        C3376G g = new C3376G(this);
        $jacocoInit[68] = true;
        C0120S j = a.mo3669j(g);
        C3381H h = new C3381H(this);
        $jacocoInit[69] = true;
        C0120S<Boolean> b = j.mo3636b((C0129b<? super T>) h);
        $jacocoInit[70] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo14337a(Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(this.appsChip.isChecked());
        $jacocoInit[78] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14339a(Boolean __) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.gamesChip.isChecked()) {
            $jacocoInit[75] = true;
        } else {
            this.gamesChip.setChecked(false);
            $jacocoInit[76] = true;
        }
        $jacocoInit[77] = true;
    }

    public C0120S<ChipsEvents> isChipChecked() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<ChipsEvents> cVar = this.chipCheckedEvent;
        $jacocoInit[71] = true;
        return cVar;
    }

    public void uncheckChips() {
        boolean[] $jacocoInit = $jacocoInit();
        this.gamesChip.setChecked(false);
        $jacocoInit[72] = true;
        this.appsChip.setChecked(false);
        $jacocoInit[73] = true;
    }

    public void expandChips() {
        boolean[] $jacocoInit = $jacocoInit();
        this.appBarLayout.mo4187a(true, true);
        $jacocoInit[74] = true;
    }
}
