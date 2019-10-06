package p005cm.aptoide.p006pt.promotions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0227b;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.C1053eb;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.RecyclerView.C0975f;
import android.support.p001v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.util.AppBarStateChangeListener;
import p005cm.aptoide.p006pt.util.AppBarStateChangeListener.State;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.promotions.PromotionsFragment */
public class PromotionsFragment extends NavigationTrackFragment implements PromotionsView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String WALLET_PACKAGE_NAME = "com.appcoins.wallet";
    private AppBarLayout appBarLayout;
    private Drawable backArrow;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private DecimalFormat decimalFormat;
    private C0137ja errorMessageSubscription;
    private View genericErrorView;
    private View genericErrorViewRetry;
    private ProgressBar loading;
    private Button promotionAction;
    private C14963c<PromotionAppClick> promotionAppClick;
    private TextView promotionFirstMessage;
    private C14963c<Void> promotionOverDialogClick;
    private TextView promotionTitle;
    private PromotionsAdapter promotionsAdapter;
    private RecyclerView promotionsList;
    @Inject
    PromotionsPresenter promotionsPresenter;
    private View promotionsView;
    @Inject
    String theme;
    private Toolbar toolbar;
    private ImageView toolbarImage;
    private ImageView toolbarImagePlaceholder;
    private TextView toolbarTitle;
    private View walletActiveView;
    private View walletInactiveView;
    private Window window;

    /* renamed from: cm.aptoide.pt.promotions.PromotionsFragment$2 */
    static /* synthetic */ class C44752 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = new int[DownloadState.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State = new int[State.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-6832578560101412814L, "cm/aptoide/pt/promotions/PromotionsFragment$2", 32);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 4;
            $jacocoInit[7] = true;
            try {
                $jacocoInit[9] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ACTIVE.ordinal()] = 1;
                $jacocoInit[10] = true;
            } catch (NoSuchFieldError e5) {
                try {
                    $jacocoInit[11] = true;
                } catch (NoSuchFieldError e6) {
                    try {
                        $jacocoInit[13] = true;
                    } catch (NoSuchFieldError e7) {
                        try {
                            $jacocoInit[15] = true;
                        } catch (NoSuchFieldError e8) {
                            try {
                                $jacocoInit[17] = true;
                            } catch (NoSuchFieldError e9) {
                                try {
                                    $jacocoInit[19] = true;
                                } catch (NoSuchFieldError e10) {
                                    $jacocoInit[21] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.INDETERMINATE.ordinal()] = 2;
            $jacocoInit[12] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.PAUSE.ordinal()] = 3;
            $jacocoInit[14] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.COMPLETE.ordinal()] = 4;
            $jacocoInit[16] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ERROR.ordinal()] = 5;
            $jacocoInit[18] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 6;
            $jacocoInit[20] = true;
            try {
                $jacocoInit[22] = true;
                $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.EXPANDED.ordinal()] = 1;
                $jacocoInit[23] = true;
            } catch (NoSuchFieldError e11) {
                try {
                    $jacocoInit[24] = true;
                } catch (NoSuchFieldError e12) {
                    try {
                        $jacocoInit[26] = true;
                    } catch (NoSuchFieldError e13) {
                        try {
                            $jacocoInit[28] = true;
                        } catch (NoSuchFieldError e14) {
                            $jacocoInit[30] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.IDLE.ordinal()] = 2;
            $jacocoInit[25] = true;
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.MOVING.ordinal()] = 3;
            $jacocoInit[27] = true;
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.COLLAPSED.ordinal()] = 4;
            $jacocoInit[29] = true;
            $jacocoInit[31] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9024457184202352176L, "cm/aptoide/pt/promotions/PromotionsFragment", 376);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ Toolbar access$000(PromotionsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Toolbar toolbar2 = x0.toolbar;
        $jacocoInit[372] = true;
        return toolbar2;
    }

    static /* synthetic */ TextView access$100(PromotionsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = x0.toolbarTitle;
        $jacocoInit[373] = true;
        return textView;
    }

    static /* synthetic */ void access$200(PromotionsFragment x0, boolean x1) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.handleStatusBar(x1);
        $jacocoInit[374] = true;
    }

    static /* synthetic */ Drawable access$300(PromotionsFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Drawable drawable = x0.backArrow;
        $jacocoInit[375] = true;
        return drawable;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[2] = true;
        this.window = getActivity().getWindow();
        $jacocoInit[3] = true;
        this.promotionOverDialogClick = C14963c.m46753p();
        $jacocoInit[4] = true;
        setHasOptionsMenu(true);
        $jacocoInit[5] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[6] = true;
        this.decimalFormat = new DecimalFormat("0.0");
        $jacocoInit[7] = true;
        this.promotionsList = (RecyclerView) view.findViewById(C1375R.C1376id.fragment_promotions_promotions_list);
        $jacocoInit[8] = true;
        this.promotionAppClick = C14963c.m46753p();
        $jacocoInit[9] = true;
        this.promotionsAdapter = new PromotionsAdapter(new ArrayList(), new PromotionsViewHolderFactory(this.promotionAppClick, this.decimalFormat));
        $jacocoInit[10] = true;
        this.toolbarImage = (ImageView) view.findViewById(C1375R.C1376id.app_graphic);
        $jacocoInit[11] = true;
        this.toolbarImagePlaceholder = (ImageView) view.findViewById(C1375R.C1376id.app_graphic_placeholder);
        $jacocoInit[12] = true;
        this.promotionTitle = (TextView) view.findViewById(C1375R.C1376id.promotions_title);
        $jacocoInit[13] = true;
        this.promotionFirstMessage = (TextView) view.findViewById(C1375R.C1376id.promotions_message_1);
        $jacocoInit[14] = true;
        this.walletActiveView = view.findViewById(C1375R.C1376id.promotion_wallet_active);
        $jacocoInit[15] = true;
        this.walletInactiveView = view.findViewById(C1375R.C1376id.promotion_wallet_inactive);
        $jacocoInit[16] = true;
        this.promotionAction = (Button) this.walletInactiveView.findViewById(C1375R.C1376id.promotion_app_action_button);
        $jacocoInit[17] = true;
        this.loading = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[18] = true;
        this.promotionsView = view.findViewById(C1375R.C1376id.promotions_view);
        $jacocoInit[19] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[20] = true;
        this.genericErrorViewRetry = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        if (VERSION.SDK_INT < 21) {
            $jacocoInit[21] = true;
        } else {
            $jacocoInit[22] = true;
            this.window.setStatusBarColor(getResources().getColor(C1375R.color.black_87_alpha));
            $jacocoInit[23] = true;
        }
        this.toolbarTitle = (TextView) view.findViewById(C1375R.C1376id.toolbar_title);
        $jacocoInit[24] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[25] = true;
        this.toolbar.setTitle((CharSequence) "");
        $jacocoInit[26] = true;
        C0019n appCompatActivity = (C0019n) getActivity();
        $jacocoInit[27] = true;
        appCompatActivity.setSupportActionBar(this.toolbar);
        $jacocoInit[28] = true;
        C0760a actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar == null) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            actionBar.mo6153d(true);
            $jacocoInit[31] = true;
        }
        this.backArrow = this.toolbar.getNavigationIcon();
        $jacocoInit[32] = true;
        this.appBarLayout = (AppBarLayout) view.findViewById(C1375R.C1376id.app_bar_layout);
        $jacocoInit[33] = true;
        this.collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(C1375R.C1376id.collapsing_toolbar_layout);
        $jacocoInit[34] = true;
        this.collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(C1375R.color.transparent));
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.collapsingToolbarLayout;
        $jacocoInit[35] = true;
        int color = getResources().getColor(C1375R.color.transparent);
        $jacocoInit[36] = true;
        collapsingToolbarLayout2.setCollapsedTitleTextColor(color);
        $jacocoInit[37] = true;
        this.appBarLayout.mo4186a((C0227b) new AppBarStateChangeListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ PromotionsFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-4573526183488200129L, "cm/aptoide/pt/promotions/PromotionsFragment$1", 20);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            private void configureAppBarLayout(Drawable drawable, int toolbarColor, boolean isCollapsed) {
                boolean[] $jacocoInit = $jacocoInit();
                PromotionsFragment.access$000(this.this$0).setBackgroundDrawable(drawable);
                $jacocoInit[1] = true;
                PromotionsFragment.access$100(this.this$0).setTextColor(toolbarColor);
                if (VERSION.SDK_INT < 21) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    PromotionsFragment.access$200(this.this$0, isCollapsed);
                    $jacocoInit[4] = true;
                }
                if (PromotionsFragment.access$300(this.this$0) == null) {
                    $jacocoInit[5] = true;
                } else {
                    $jacocoInit[6] = true;
                    PromotionsFragment.access$300(this.this$0).setColorFilter(toolbarColor, Mode.SRC_IN);
                    $jacocoInit[7] = true;
                }
                $jacocoInit[8] = true;
            }

            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                boolean[] $jacocoInit = $jacocoInit();
                Resources resources = this.this$0.getResources();
                $jacocoInit[9] = true;
                int i = C44752.$SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[state.ordinal()];
                if (i == 1) {
                    $jacocoInit[10] = true;
                } else if (i != 4) {
                    PromotionsFragment.access$100(this.this$0).setVisibility(8);
                    $jacocoInit[11] = true;
                    Drawable drawable = resources.getDrawable(C1375R.drawable.editorial_up_bottom_black_gradient);
                    $jacocoInit[12] = true;
                    int color = resources.getColor(C1375R.color.white);
                    $jacocoInit[13] = true;
                    configureAppBarLayout(drawable, color, false);
                    $jacocoInit[14] = true;
                } else {
                    PromotionsFragment.access$100(this.this$0).setVisibility(0);
                    $jacocoInit[15] = true;
                    Drawable drawable2 = resources.getDrawable(C1375R.drawable.transparent);
                    $jacocoInit[16] = true;
                    int color2 = resources.getColor(C1375R.color.black);
                    $jacocoInit[17] = true;
                    configureAppBarLayout(drawable2, color2, true);
                    $jacocoInit[18] = true;
                }
                $jacocoInit[19] = true;
            }
        });
        $jacocoInit[38] = true;
        setupRecyclerView();
        $jacocoInit[39] = true;
        attachPresenter(this.promotionsPresenter);
        $jacocoInit[40] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[41] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[42] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[43] = true;
        return build;
    }

    private void handleStatusBar(boolean collapseState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (collapseState) {
            int i = VERSION.SDK_INT;
            if (i < 21) {
                $jacocoInit[44] = true;
            } else if (i >= 23) {
                $jacocoInit[45] = true;
            } else {
                $jacocoInit[46] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.grey_medium));
                $jacocoInit[47] = true;
            }
            if (VERSION.SDK_INT < 23) {
                $jacocoInit[48] = true;
            } else {
                $jacocoInit[49] = true;
                View decorView = this.window.getDecorView();
                $jacocoInit[50] = true;
                decorView.setSystemUiVisibility(Opcodes.ACC_ANNOTATION);
                $jacocoInit[51] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.white));
                $jacocoInit[52] = true;
            }
        } else {
            int i2 = VERSION.SDK_INT;
            if (i2 < 21) {
                $jacocoInit[53] = true;
            } else if (i2 >= 23) {
                $jacocoInit[54] = true;
            } else {
                $jacocoInit[55] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.black_87_alpha));
                $jacocoInit[56] = true;
                View decorView2 = this.window.getDecorView();
                $jacocoInit[57] = true;
                decorView2.setSystemUiVisibility(0);
                $jacocoInit[58] = true;
            }
            if (VERSION.SDK_INT < 23) {
                $jacocoInit[59] = true;
            } else {
                $jacocoInit[60] = true;
                View decorView3 = this.window.getDecorView();
                $jacocoInit[61] = true;
                decorView3.setSystemUiVisibility(0);
                $jacocoInit[62] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.black_87_alpha));
                $jacocoInit[63] = true;
            }
        }
        $jacocoInit[64] = true;
    }

    private void setupRecyclerView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsList.setAdapter(this.promotionsAdapter);
        RecyclerView recyclerView = this.promotionsList;
        $jacocoInit[65] = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        $jacocoInit[66] = true;
        recyclerView.setLayoutManager(linearLayoutManager);
        $jacocoInit[67] = true;
        C0975f animator = this.promotionsList.getItemAnimator();
        if (!(animator instanceof C1053eb)) {
            $jacocoInit[68] = true;
        } else {
            $jacocoInit[69] = true;
            ((C1053eb) animator).mo8413a(false);
            $jacocoInit[70] = true;
        }
        $jacocoInit[71] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_promotions, container, false);
        $jacocoInit[72] = true;
        return inflate;
    }

    public void showPromotionApp(PromotionViewApp promotionViewApp, boolean isWalletInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = promotionViewApp.getPackageName();
        $jacocoInit[73] = true;
        if (packageName.equals(WALLET_PACKAGE_NAME)) {
            $jacocoInit[74] = true;
            showWallet(promotionViewApp, isWalletInstalled);
            $jacocoInit[75] = true;
        } else {
            DownloadModel downloadModel = promotionViewApp.getDownloadModel();
            $jacocoInit[76] = true;
            if (!downloadModel.hasError()) {
                $jacocoInit[77] = true;
            } else {
                $jacocoInit[78] = true;
                DownloadModel downloadModel2 = promotionViewApp.getDownloadModel();
                $jacocoInit[79] = true;
                DownloadState downloadState = downloadModel2.getDownloadState();
                $jacocoInit[80] = true;
                handleDownloadError(downloadState);
                $jacocoInit[81] = true;
            }
            this.promotionsAdapter.setPromotionApp(promotionViewApp);
            $jacocoInit[82] = true;
        }
        this.loading.setVisibility(8);
        $jacocoInit[83] = true;
        this.toolbarImagePlaceholder.setVisibility(8);
        $jacocoInit[84] = true;
        this.toolbarImage.setVisibility(0);
        $jacocoInit[85] = true;
        this.promotionsView.setVisibility(0);
        $jacocoInit[86] = true;
    }

    public C0120S<PromotionViewApp> installButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C4592va.f8222a);
        C4604ya yaVar = C4604ya.f8236a;
        $jacocoInit[87] = true;
        C0120S<PromotionViewApp> j = d.mo3669j(yaVar);
        $jacocoInit[88] = true;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m8860e(PromotionAppClick promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.UPDATE) {
            $jacocoInit[362] = true;
        } else {
            $jacocoInit[363] = true;
            if (promotionAppClick2.getClickType() == ClickType.INSTALL_APP) {
                $jacocoInit[364] = true;
            } else {
                $jacocoInit[365] = true;
                if (promotionAppClick2.getClickType() == ClickType.DOWNLOAD) {
                    $jacocoInit[366] = true;
                } else {
                    $jacocoInit[367] = true;
                    if (promotionAppClick2.getClickType() == ClickType.DOWNGRADE) {
                        $jacocoInit[368] = true;
                    } else {
                        z = false;
                        $jacocoInit[370] = true;
                        Boolean valueOf = Boolean.valueOf(z);
                        $jacocoInit[371] = true;
                        return valueOf;
                    }
                }
            }
        }
        $jacocoInit[369] = true;
        z = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[371] = true;
        return valueOf2;
    }

    /* renamed from: f */
    static /* synthetic */ PromotionViewApp m8861f(PromotionAppClick promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp app = promotionAppClick2.getApp();
        $jacocoInit[361] = true;
        return app;
    }

    public C0120S<Boolean> showRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[89] = true;
        String string = getResources().getString(C1375R.string.root_access_dialog);
        $jacocoInit[90] = true;
        C0120S createGenericYesNoCancelMessage = GenericDialogs.createGenericYesNoCancelMessage(context, null, string);
        C4584ta taVar = C4584ta.f8213a;
        $jacocoInit[91] = true;
        C0120S<Boolean> j = createGenericYesNoCancelMessage.mo3669j(taVar);
        $jacocoInit[92] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8857b(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[360] = true;
        return valueOf;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m8862g(PromotionAppClick promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.PAUSE_DOWNLOAD) {
            $jacocoInit[357] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[358] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[359] = true;
        return valueOf;
    }

    public C0120S<PromotionViewApp> pauseDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C4440Fa.f8042a);
        C4437Ea ea = C4437Ea.f8039a;
        $jacocoInit[93] = true;
        C0120S<PromotionViewApp> j = d.mo3669j(ea);
        $jacocoInit[94] = true;
        return j;
    }

    /* renamed from: h */
    static /* synthetic */ PromotionViewApp m8863h(PromotionAppClick promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp app = promotionAppClick2.getApp();
        $jacocoInit[356] = true;
        return app;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8853a(PromotionAppClick promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.CANCEL_DOWNLOAD) {
            $jacocoInit[353] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[354] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[355] = true;
        return valueOf;
    }

    public C0120S<PromotionViewApp> cancelDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C4600xa.f8231a);
        C4429Ca ca = C4429Ca.f8027a;
        $jacocoInit[95] = true;
        C0120S<PromotionViewApp> j = d.mo3669j(ca);
        $jacocoInit[96] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ PromotionViewApp m8856b(PromotionAppClick promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp app = promotionAppClick2.getApp();
        $jacocoInit[352] = true;
        return app;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m8864i(PromotionAppClick promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.RESUME_DOWNLOAD) {
            $jacocoInit[349] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[350] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[351] = true;
        return valueOf;
    }

    public C0120S<PromotionViewApp> resumeDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C4576ra.f8205a);
        C4564oa oaVar = C4564oa.f8190a;
        $jacocoInit[97] = true;
        C0120S<PromotionViewApp> j = d.mo3669j(oaVar);
        $jacocoInit[98] = true;
        return j;
    }

    /* renamed from: j */
    static /* synthetic */ PromotionViewApp m8865j(PromotionAppClick promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp app = promotionAppClick2.getApp();
        $jacocoInit[348] = true;
        return app;
    }

    public void showAppCoinsAmount(int totalAppcValue) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.promotionFirstMessage;
        $jacocoInit[99] = true;
        String string = getString(C1375R.string.holidayspromotion_message_1, String.valueOf(totalAppcValue));
        $jacocoInit[100] = true;
        textView.setText(string);
        $jacocoInit[101] = true;
    }

    public void lockPromotionApps(boolean walletInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionsAdapter.isWalletInstalled(walletInstalled);
        $jacocoInit[102] = true;
    }

    public C0120S<PromotionViewApp> claimAppClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.promotionAppClick.mo3653d((C0132p<? super T, Boolean>) C4580sa.f8209a);
        C4552la laVar = C4552la.f8177a;
        $jacocoInit[103] = true;
        C0120S<PromotionViewApp> j = d.mo3669j(laVar);
        $jacocoInit[104] = true;
        return j;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m8859d(PromotionAppClick promotionAppClick2) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (promotionAppClick2.getClickType() == ClickType.CLAIM) {
            $jacocoInit[345] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[346] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[347] = true;
        return valueOf;
    }

    /* renamed from: c */
    static /* synthetic */ PromotionViewApp m8858c(PromotionAppClick promotionAppClick2) {
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp app = promotionAppClick2.getApp();
        $jacocoInit[344] = true;
        return app;
    }

    public void updateClaimStatus(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (packageName.equals(WALLET_PACKAGE_NAME)) {
            $jacocoInit[105] = true;
            this.promotionAction.setEnabled(false);
            $jacocoInit[106] = true;
            Button button = this.promotionAction;
            Resources resources = getContext().getResources();
            $jacocoInit[107] = true;
            int color = resources.getColor(C1375R.color.grey_fog_light);
            $jacocoInit[108] = true;
            button.setBackgroundColor(color);
            $jacocoInit[109] = true;
            this.promotionsAdapter.isWalletInstalled(true);
            $jacocoInit[110] = true;
            this.promotionAction.setText(getContext().getString(C1375R.string.holidayspromotion_button_claimed));
            $jacocoInit[111] = true;
        } else {
            this.promotionsAdapter.updateClaimStatus(packageName);
            $jacocoInit[112] = true;
        }
        $jacocoInit[113] = true;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbarImagePlaceholder.setVisibility(0);
        $jacocoInit[114] = true;
        this.toolbarImage.setVisibility(8);
        $jacocoInit[115] = true;
        this.promotionsView.setVisibility(8);
        $jacocoInit[116] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[117] = true;
        this.loading.setVisibility(0);
        $jacocoInit[118] = true;
    }

    public void showErrorView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbarImage.setVisibility(8);
        $jacocoInit[119] = true;
        this.loading.setVisibility(8);
        $jacocoInit[120] = true;
        this.promotionsView.setVisibility(8);
        $jacocoInit[121] = true;
        this.genericErrorView.setVisibility(0);
        $jacocoInit[122] = true;
    }

    public C0120S<Void> retryClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.genericErrorViewRetry);
        $jacocoInit[123] = true;
        return a;
    }

    public void showPromotionOverDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading.setVisibility(8);
        $jacocoInit[124] = true;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        $jacocoInit[125] = true;
        View dialogLayout = inflater.inflate(C1375R.layout.promotions_promotion_over_dialog, null);
        $jacocoInit[126] = true;
        AlertDialog.Builder view = new AlertDialog.Builder(getContext()).setView(dialogLayout);
        $jacocoInit[127] = true;
        AlertDialog dialog = view.create();
        $jacocoInit[128] = true;
        dialog.setCancelable(false);
        $jacocoInit[129] = true;
        View findViewById = dialogLayout.findViewById(C1375R.C1376id.dismiss_button);
        C4568pa paVar = new C4568pa(this, dialog);
        $jacocoInit[130] = true;
        findViewById.setOnClickListener(paVar);
        $jacocoInit[131] = true;
        dialog.show();
        $jacocoInit[132] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15674a(AlertDialog dialog, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionOverDialogClick.onNext(null);
        $jacocoInit[342] = true;
        dialog.dismiss();
        $jacocoInit[343] = true;
    }

    public C0120S<Void> promotionOverDialogClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.promotionOverDialogClick;
        $jacocoInit[133] = true;
        return cVar;
    }

    public void showPromotionTitle(String title) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionTitle.setText(title);
        $jacocoInit[134] = true;
        this.toolbarTitle.setText(title);
        $jacocoInit[135] = true;
    }

    public void showPromotionFeatureGraphic(String background) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.toolbarImage;
        $jacocoInit[136] = true;
        with.load(background, imageView);
        $jacocoInit[137] = true;
    }

    private void showWallet(PromotionViewApp promotionViewApp, boolean isWalletInstalled) {
        boolean z;
        PromotionViewApp promotionViewApp2 = promotionViewApp;
        boolean z2 = isWalletInstalled;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = promotionViewApp.getDownloadModel();
        boolean z3 = true;
        $jacocoInit[138] = true;
        if (downloadModel.isDownloading()) {
            $jacocoInit[139] = true;
            this.walletActiveView.setVisibility(0);
            $jacocoInit[140] = true;
            this.walletInactiveView.setVisibility(8);
            $jacocoInit[141] = true;
            ImageView appIcon = (ImageView) this.walletActiveView.findViewById(C1375R.C1376id.app_icon);
            $jacocoInit[142] = true;
            TextView appName = (TextView) this.walletActiveView.findViewById(C1375R.C1376id.app_name);
            $jacocoInit[143] = true;
            TextView appDescription = (TextView) this.walletActiveView.findViewById(C1375R.C1376id.app_description);
            $jacocoInit[144] = true;
            TextView numberOfDownloads = (TextView) this.walletActiveView.findViewById(C1375R.C1376id.number_of_downloads);
            $jacocoInit[145] = true;
            TextView appSize = (TextView) this.walletActiveView.findViewById(C1375R.C1376id.app_size);
            $jacocoInit[146] = true;
            TextView rating = (TextView) this.walletActiveView.findViewById(C1375R.C1376id.rating);
            View view = this.walletActiveView;
            $jacocoInit[147] = true;
            ProgressBar downloadProgressBar = (ProgressBar) view.findViewById(C1375R.C1376id.promotions_download_progress_bar);
            View view2 = this.walletActiveView;
            $jacocoInit[148] = true;
            TextView downloadProgressValue = (TextView) view2.findViewById(C1375R.C1376id.promotions_download_progress_number);
            View view3 = this.walletActiveView;
            $jacocoInit[149] = true;
            ImageView pauseDownload = (ImageView) view3.findViewById(C1375R.C1376id.promotions_download_pause_download);
            View view4 = this.walletActiveView;
            $jacocoInit[150] = true;
            ImageView cancelDownload = (ImageView) view4.findViewById(C1375R.C1376id.promotions_download_cancel_button);
            View view5 = this.walletActiveView;
            $jacocoInit[151] = true;
            ImageView resumeDownload = (ImageView) view5.findViewById(C1375R.C1376id.promotions_download_resume_download);
            View view6 = this.walletActiveView;
            TextView numberOfDownloads2 = numberOfDownloads;
            $jacocoInit[152] = true;
            LinearLayout downloadControlsLayout = (LinearLayout) view6.findViewById(C1375R.C1376id.install_controls_layout);
            $jacocoInit[153] = true;
            ImageLoader with = ImageLoader.with(getContext());
            $jacocoInit[154] = true;
            with.load(promotionViewApp.getAppIcon(), appIcon);
            $jacocoInit[155] = true;
            appName.setText(promotionViewApp.getName());
            $jacocoInit[156] = true;
            appDescription.setText(promotionViewApp.getDescription());
            $jacocoInit[157] = true;
            ImageView imageView = appIcon;
            appSize.setText(StringU.formatBytes(promotionViewApp.getSize(), false));
            $jacocoInit[158] = true;
            DownloadModel downloadModel2 = promotionViewApp.getDownloadModel();
            $jacocoInit[159] = true;
            DownloadState downloadState = downloadModel2.getDownloadState();
            $jacocoInit[160] = true;
            TextView textView = appSize;
            LayoutParams layoutParams = new LayoutParams(-1, -1, 4.0f);
            $jacocoInit[161] = true;
            LayoutParams pauseShowing = layoutParams;
            TextView textView2 = appDescription;
            LayoutParams layoutParams2 = new LayoutParams(-1, -1, 2.0f);
            $jacocoInit[162] = true;
            LayoutParams pauseHidden = layoutParams2;
            String str = "%";
            switch (C44752.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()]) {
                case 1:
                    TextView textView3 = appName;
                    z = true;
                    downloadProgressBar.setIndeterminate(false);
                    $jacocoInit[164] = true;
                    DownloadModel downloadModel3 = promotionViewApp.getDownloadModel();
                    $jacocoInit[165] = true;
                    int progress = downloadModel3.getProgress();
                    $jacocoInit[166] = true;
                    downloadProgressBar.setProgress(progress);
                    $jacocoInit[167] = true;
                    StringBuilder sb = new StringBuilder();
                    DownloadModel downloadModel4 = promotionViewApp.getDownloadModel();
                    $jacocoInit[168] = true;
                    int progress2 = downloadModel4.getProgress();
                    $jacocoInit[169] = true;
                    sb.append(String.valueOf(progress2));
                    sb.append(str);
                    downloadProgressValue.setText(sb.toString());
                    $jacocoInit[170] = true;
                    pauseDownload.setVisibility(0);
                    $jacocoInit[171] = true;
                    pauseDownload.setOnClickListener(new C4421Aa(this, promotionViewApp2));
                    $jacocoInit[172] = true;
                    cancelDownload.setVisibility(8);
                    $jacocoInit[173] = true;
                    resumeDownload.setVisibility(8);
                    $jacocoInit[174] = true;
                    downloadControlsLayout.setLayoutParams(pauseShowing);
                    $jacocoInit[175] = true;
                    break;
                case 2:
                    TextView textView4 = appName;
                    z = true;
                    downloadProgressBar.setIndeterminate(true);
                    $jacocoInit[176] = true;
                    pauseDownload.setVisibility(0);
                    $jacocoInit[177] = true;
                    pauseDownload.setOnClickListener(new C4588ua(this, promotionViewApp2));
                    $jacocoInit[178] = true;
                    cancelDownload.setVisibility(8);
                    $jacocoInit[179] = true;
                    resumeDownload.setVisibility(8);
                    $jacocoInit[180] = true;
                    downloadControlsLayout.setLayoutParams(pauseShowing);
                    $jacocoInit[181] = true;
                    break;
                case 3:
                    TextView textView5 = appName;
                    z = true;
                    downloadProgressBar.setIndeterminate(false);
                    $jacocoInit[182] = true;
                    DownloadModel downloadModel5 = promotionViewApp.getDownloadModel();
                    $jacocoInit[183] = true;
                    int progress3 = downloadModel5.getProgress();
                    $jacocoInit[184] = true;
                    downloadProgressBar.setProgress(progress3);
                    $jacocoInit[185] = true;
                    StringBuilder sb2 = new StringBuilder();
                    DownloadModel downloadModel6 = promotionViewApp.getDownloadModel();
                    $jacocoInit[186] = true;
                    int progress4 = downloadModel6.getProgress();
                    $jacocoInit[187] = true;
                    sb2.append(String.valueOf(progress4));
                    sb2.append(str);
                    downloadProgressValue.setText(sb2.toString());
                    $jacocoInit[188] = true;
                    pauseDownload.setVisibility(8);
                    $jacocoInit[189] = true;
                    cancelDownload.setVisibility(0);
                    $jacocoInit[190] = true;
                    cancelDownload.setOnClickListener(new C4572qa(this, promotionViewApp2));
                    $jacocoInit[191] = true;
                    resumeDownload.setVisibility(0);
                    $jacocoInit[192] = true;
                    resumeDownload.setOnClickListener(new C4425Ba(this, promotionViewApp2));
                    $jacocoInit[193] = true;
                    downloadControlsLayout.setLayoutParams(pauseHidden);
                    $jacocoInit[194] = true;
                    break;
                case 4:
                    TextView textView6 = appName;
                    z = true;
                    downloadProgressBar.setIndeterminate(true);
                    $jacocoInit[195] = true;
                    pauseDownload.setVisibility(0);
                    $jacocoInit[196] = true;
                    pauseDownload.setOnClickListener(new C4443Ga(this, promotionViewApp2));
                    $jacocoInit[197] = true;
                    cancelDownload.setVisibility(8);
                    $jacocoInit[198] = true;
                    resumeDownload.setVisibility(8);
                    $jacocoInit[199] = true;
                    downloadControlsLayout.setLayoutParams(pauseShowing);
                    $jacocoInit[200] = true;
                    break;
                case 5:
                    TextView textView7 = appName;
                    z = true;
                    showErrorDialog("", getContext().getString(C1375R.string.error_occured));
                    $jacocoInit[201] = true;
                    break;
                case 6:
                    String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
                    TextView textView8 = appName;
                    $jacocoInit[202] = true;
                    String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
                    DownloadState downloadState2 = downloadState;
                    z = true;
                    $jacocoInit[203] = true;
                    showErrorDialog(string, string2);
                    $jacocoInit[204] = true;
                    break;
                default:
                    DownloadState downloadState3 = downloadState;
                    TextView textView9 = appName;
                    z = true;
                    $jacocoInit[163] = true;
                    break;
            }
            if (promotionViewApp.getRating() == 0.0f) {
                $jacocoInit[205] = z;
                rating.setText(C1375R.string.appcardview_title_no_stars);
                $jacocoInit[206] = z;
                LayoutParams layoutParams3 = pauseShowing;
                z3 = true;
            } else {
                LayoutParams layoutParams4 = pauseShowing;
                rating.setText(this.decimalFormat.format((double) promotionViewApp.getRating()));
                z3 = true;
                $jacocoInit[207] = true;
            }
            numberOfDownloads2.setText(String.valueOf(promotionViewApp.getNumberOfDownloads()));
            $jacocoInit[208] = z3;
            boolean z4 = isWalletInstalled;
        } else {
            DownloadModel downloadModel7 = promotionViewApp.getDownloadModel();
            $jacocoInit[209] = true;
            if (!downloadModel7.hasError()) {
                $jacocoInit[210] = true;
            } else {
                $jacocoInit[211] = true;
                DownloadModel downloadModel8 = promotionViewApp.getDownloadModel();
                $jacocoInit[212] = true;
                DownloadState downloadState4 = downloadModel8.getDownloadState();
                $jacocoInit[213] = true;
                handleDownloadError(downloadState4);
                $jacocoInit[214] = true;
            }
            this.walletActiveView.setVisibility(8);
            $jacocoInit[215] = true;
            this.walletInactiveView.setVisibility(0);
            $jacocoInit[216] = true;
            ImageView appIcon2 = (ImageView) this.walletInactiveView.findViewById(C1375R.C1376id.app_icon);
            $jacocoInit[217] = true;
            TextView appName2 = (TextView) this.walletInactiveView.findViewById(C1375R.C1376id.app_name);
            $jacocoInit[218] = true;
            TextView appDescription2 = (TextView) this.walletInactiveView.findViewById(C1375R.C1376id.app_description);
            $jacocoInit[219] = true;
            TextView numberOfDownloads3 = (TextView) this.walletInactiveView.findViewById(C1375R.C1376id.number_of_downloads);
            $jacocoInit[220] = true;
            TextView appSize2 = (TextView) this.walletInactiveView.findViewById(C1375R.C1376id.app_size);
            $jacocoInit[221] = true;
            TextView rating2 = (TextView) this.walletInactiveView.findViewById(C1375R.C1376id.rating);
            $jacocoInit[222] = true;
            ImageLoader with2 = ImageLoader.with(getContext());
            $jacocoInit[223] = true;
            with2.load(promotionViewApp.getAppIcon(), appIcon2);
            $jacocoInit[224] = true;
            appName2.setText(promotionViewApp.getName());
            $jacocoInit[225] = true;
            appDescription2.setText(promotionViewApp.getDescription());
            $jacocoInit[226] = true;
            appSize2.setText(StringU.formatBytes(promotionViewApp.getSize(), false));
            $jacocoInit[227] = true;
            if (promotionViewApp.getRating() == 0.0f) {
                $jacocoInit[228] = true;
                rating2.setText(C1375R.string.appcardview_title_no_stars);
                $jacocoInit[229] = true;
            } else {
                rating2.setText(this.decimalFormat.format((double) promotionViewApp.getRating()));
                $jacocoInit[230] = true;
            }
            numberOfDownloads3.setText(String.valueOf(promotionViewApp.getNumberOfDownloads()));
            $jacocoInit[231] = true;
            Button button = this.promotionAction;
            Context context = getContext();
            int buttonMessage = getButtonMessage(getState(promotionViewApp));
            $jacocoInit[232] = true;
            Object[] objArr = {Float.valueOf(promotionViewApp.getAppcValue())};
            $jacocoInit[233] = true;
            button.setText(context.getString(buttonMessage, objArr));
            $jacocoInit[234] = true;
            if (getState(promotionViewApp) == 5) {
                $jacocoInit[235] = true;
                if (!isWalletInstalled()) {
                    $jacocoInit[236] = true;
                    this.promotionAction.setEnabled(true);
                    $jacocoInit[237] = true;
                    TypedValue resultValue = new TypedValue();
                    $jacocoInit[238] = true;
                    Theme theme2 = getContext().getTheme();
                    $jacocoInit[239] = true;
                    theme2.resolveAttribute(C1375R.attr.installButtonBackground, resultValue, true);
                    $jacocoInit[240] = true;
                    this.promotionAction.setTextColor(-1);
                    int i = resultValue.resourceId;
                    if (i != 0) {
                        $jacocoInit[241] = true;
                        this.promotionAction.setBackgroundResource(i);
                        $jacocoInit[242] = true;
                    } else {
                        Button button2 = this.promotionAction;
                        Resources resources = getContext().getResources();
                        $jacocoInit[243] = true;
                        Drawable drawable = resources.getDrawable(C1375R.drawable.card_border_rounded_orange);
                        $jacocoInit[244] = true;
                        button2.setBackgroundDrawable(drawable);
                        $jacocoInit[245] = true;
                    }
                    this.promotionAction.setText(getContext().getString(C1375R.string.appview_button_install));
                    $jacocoInit[246] = true;
                    this.promotionAction.setOnClickListener(new C4608za(this, promotionViewApp2));
                    $jacocoInit[247] = true;
                } else {
                    this.promotionAction.setEnabled(false);
                    $jacocoInit[248] = true;
                    Button button3 = this.promotionAction;
                    Resources resources2 = getContext().getResources();
                    $jacocoInit[249] = true;
                    Drawable drawable2 = resources2.getDrawable(C1375R.drawable.card_border_fog_grey_normal);
                    $jacocoInit[250] = true;
                    button3.setBackgroundDrawable(drawable2);
                    $jacocoInit[251] = true;
                    Button button4 = this.promotionAction;
                    Resources resources3 = getContext().getResources();
                    $jacocoInit[252] = true;
                    int color = resources3.getColor(C1375R.color.grey_fog_light);
                    $jacocoInit[253] = true;
                    button4.setTextColor(color);
                    $jacocoInit[254] = true;
                }
                this.promotionsAdapter.isWalletInstalled(isWalletInstalled);
                $jacocoInit[255] = true;
            } else {
                boolean z5 = isWalletInstalled;
                if (getState(promotionViewApp) == 4) {
                    $jacocoInit[256] = true;
                    this.promotionAction.setEnabled(true);
                    $jacocoInit[257] = true;
                    Button button5 = this.promotionAction;
                    Resources resources4 = getContext().getResources();
                    $jacocoInit[258] = true;
                    Drawable drawable3 = resources4.getDrawable(C1375R.drawable.card_border_rounded_green);
                    $jacocoInit[259] = true;
                    button5.setBackgroundDrawable(drawable3);
                    $jacocoInit[260] = true;
                    this.promotionAction.setTextColor(-1);
                    $jacocoInit[261] = true;
                    this.promotionAction.setOnClickListener(new C4596wa(this, promotionViewApp2));
                    $jacocoInit[262] = true;
                    this.promotionsAdapter.isWalletInstalled(z5);
                    $jacocoInit[263] = true;
                } else {
                    this.promotionAction.setEnabled(true);
                    $jacocoInit[264] = true;
                    TypedValue resultValue2 = new TypedValue();
                    $jacocoInit[265] = true;
                    Theme theme3 = getContext().getTheme();
                    $jacocoInit[266] = true;
                    theme3.resolveAttribute(C1375R.attr.installButtonBackground, resultValue2, true);
                    $jacocoInit[267] = true;
                    this.promotionAction.setTextColor(-1);
                    int i2 = resultValue2.resourceId;
                    if (i2 != 0) {
                        $jacocoInit[268] = true;
                        this.promotionAction.setBackgroundResource(i2);
                        $jacocoInit[269] = true;
                    } else {
                        Button button6 = this.promotionAction;
                        Resources resources5 = getContext().getResources();
                        $jacocoInit[270] = true;
                        Drawable drawable4 = resources5.getDrawable(C1375R.drawable.card_border_rounded_orange);
                        $jacocoInit[271] = true;
                        button6.setBackgroundDrawable(drawable4);
                        $jacocoInit[272] = true;
                    }
                    if (!promotionViewApp.isClaimed()) {
                        $jacocoInit[273] = true;
                    } else {
                        $jacocoInit[274] = true;
                        this.promotionAction.setText(getContext().getString(C1375R.string.appview_button_install));
                        $jacocoInit[275] = true;
                    }
                    this.promotionAction.setOnClickListener(new C4433Da(this, promotionViewApp2));
                    $jacocoInit[276] = true;
                }
            }
        }
        $jacocoInit[277] = z3;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15675a(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[341] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15676b(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[340] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15677c(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.CANCEL_DOWNLOAD));
        $jacocoInit[339] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo15680d(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.RESUME_DOWNLOAD));
        $jacocoInit[338] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo15681e(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.PAUSE_DOWNLOAD));
        $jacocoInit[337] = true;
    }

    /* renamed from: f */
    public /* synthetic */ void mo15682f(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(promotionViewApp, ClickType.INSTALL_APP));
        $jacocoInit[336] = true;
    }

    /* renamed from: g */
    public /* synthetic */ void mo15683g(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<PromotionAppClick> cVar = this.promotionAppClick;
        $jacocoInit[333] = true;
        PromotionAppClick promotionAppClick2 = new PromotionAppClick(promotionViewApp, getClickType(getState(promotionViewApp)));
        $jacocoInit[334] = true;
        cVar.onNext(promotionAppClick2);
        $jacocoInit[335] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo15684h(PromotionViewApp promotionViewApp, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<PromotionAppClick> cVar = this.promotionAppClick;
        $jacocoInit[330] = true;
        PromotionAppClick promotionAppClick2 = new PromotionAppClick(promotionViewApp, getClickType(getState(promotionViewApp)));
        $jacocoInit[331] = true;
        cVar.onNext(promotionAppClick2);
        $jacocoInit[332] = true;
    }

    private boolean isWalletInstalled() {
        boolean[] $jacocoInit = $jacocoInit();
        PackageManager packageManager = getContext().getPackageManager();
        $jacocoInit[278] = true;
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        $jacocoInit[279] = true;
        $jacocoInit[280] = true;
        for (ApplicationInfo applicationInfo : installedApplications) {
            $jacocoInit[281] = true;
            if (applicationInfo.packageName.equals(WALLET_PACKAGE_NAME)) {
                $jacocoInit[282] = true;
                return true;
            }
            $jacocoInit[283] = true;
        }
        $jacocoInit[284] = true;
        return false;
    }

    private void handleDownloadError(DownloadState downloadState) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C44752.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        if (i == 5) {
            showErrorDialog("", getContext().getString(C1375R.string.error_occured));
            $jacocoInit[285] = true;
        } else if (i == 6) {
            String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
            $jacocoInit[286] = true;
            String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
            $jacocoInit[287] = true;
            showErrorDialog(string, string2);
            $jacocoInit[288] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Download State ");
            sb.append(downloadState);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[289] = true;
            throw illegalStateException;
        }
        $jacocoInit[290] = true;
    }

    private void showErrorDialog(String title, String message) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createGenericOkMessage = GenericDialogs.createGenericOkMessage(getContext(), title, message);
        $jacocoInit[291] = true;
        C0120S b = createGenericOkMessage.mo3634b(C14522a.m46170a());
        C4560na naVar = C4560na.f8186a;
        C4556ma maVar = C4556ma.f8182a;
        $jacocoInit[292] = true;
        this.errorMessageSubscription = b.mo3626a((C0129b<? super T>) naVar, (C0129b<Throwable>) maVar);
        $jacocoInit[293] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8854a(EResponse eResponse) {
        $jacocoInit()[329] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m8855a(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(error);
        $jacocoInit[328] = true;
        throw onErrorNotImplementedException;
    }

    private int getButtonMessage(int appState) {
        int message;
        boolean[] $jacocoInit = $jacocoInit();
        if (appState != 0) {
            if (!(appState == 1 || appState == 3)) {
                if (appState == 4) {
                    message = C1375R.string.holidayspromotion_button_claim;
                    $jacocoInit[296] = true;
                } else if (appState == 5) {
                    message = C1375R.string.holidayspromotion_button_claimed;
                    $jacocoInit[297] = true;
                } else if (appState != 6) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong view type of promotion app");
                    $jacocoInit[298] = true;
                    throw illegalArgumentException;
                }
            }
            message = C1375R.string.holidayspromotion_button_install;
            $jacocoInit[295] = true;
        } else {
            message = C1375R.string.holidayspromotion_button_update;
            $jacocoInit[294] = true;
        }
        $jacocoInit[299] = true;
        return message;
    }

    private int getState(PromotionViewApp app) {
        int state;
        boolean[] $jacocoInit = $jacocoInit();
        DownloadModel downloadModel = app.getDownloadModel();
        $jacocoInit[300] = true;
        if (downloadModel.isDownloading()) {
            $jacocoInit[301] = true;
            return 2;
        }
        int i = C44752.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[downloadModel.getAction().ordinal()];
        if (i == 1) {
            state = 6;
            $jacocoInit[302] = true;
        } else if (i == 2) {
            state = 3;
            $jacocoInit[303] = true;
        } else if (i != 3) {
            if (i == 4) {
                state = 0;
                $jacocoInit[306] = true;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid type of download action");
                $jacocoInit[307] = true;
                throw illegalArgumentException;
            }
        } else if (app.isClaimed()) {
            $jacocoInit[304] = true;
            return 5;
        } else {
            state = 4;
            $jacocoInit[305] = true;
        }
        $jacocoInit[308] = true;
        return state;
    }

    private ClickType getClickType(int appState) {
        ClickType clickType;
        boolean[] $jacocoInit = $jacocoInit();
        if (appState == 0) {
            clickType = ClickType.UPDATE;
            $jacocoInit[310] = true;
        } else if (appState == 1) {
            clickType = ClickType.DOWNLOAD;
            $jacocoInit[311] = true;
        } else if (appState == 3) {
            clickType = ClickType.INSTALL_APP;
            $jacocoInit[312] = true;
        } else if (appState == 4) {
            clickType = ClickType.CLAIM;
            $jacocoInit[313] = true;
        } else if (appState == 6) {
            clickType = ClickType.DOWNGRADE;
            $jacocoInit[309] = true;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong view type of promotion app");
            $jacocoInit[314] = true;
            throw illegalArgumentException;
        }
        $jacocoInit[315] = true;
        return clickType;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroyView();
        $jacocoInit[316] = true;
        ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
        if (VERSION.SDK_INT < 16) {
            $jacocoInit[317] = true;
        } else {
            $jacocoInit[318] = true;
            View decorView = this.window.getDecorView();
            $jacocoInit[319] = true;
            decorView.setSystemUiVisibility(Opcodes.ACC_NATIVE);
            $jacocoInit[320] = true;
        }
        this.toolbarTitle = null;
        this.toolbar = null;
        this.promotionsList = null;
        this.promotionsAdapter = null;
        this.collapsingToolbarLayout = null;
        this.appBarLayout = null;
        this.backArrow = null;
        this.walletActiveView = null;
        this.walletInactiveView = null;
        $jacocoInit[321] = true;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onDestroy();
        this.window = null;
        this.promotionAppClick = null;
        this.promotionOverDialogClick = null;
        $jacocoInit[322] = true;
        C0137ja jaVar = this.errorMessageSubscription;
        if (jaVar == null) {
            $jacocoInit[323] = true;
        } else if (jaVar.isUnsubscribed()) {
            $jacocoInit[324] = true;
        } else {
            $jacocoInit[325] = true;
            this.errorMessageSubscription.unsubscribe();
            $jacocoInit[326] = true;
        }
        $jacocoInit[327] = true;
    }
}
