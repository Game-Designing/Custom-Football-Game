package p005cm.aptoide.p006pt.editorial;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0227b;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.p000v4.widget.NestedScrollView;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.CardView;
import android.support.p001v7.widget.LinearLayoutManager;
import android.support.p001v7.widget.RecyclerView;
import android.support.p001v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.editorial.EditorialEvent.Type;
import p005cm.aptoide.p006pt.editorial.EditorialViewModel.Error;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.reactions.ReactionEvent;
import p005cm.aptoide.p006pt.reactions.ReactionMapper;
import p005cm.aptoide.p006pt.reactions.TopReactionsPreview;
import p005cm.aptoide.p006pt.reactions.data.ReactionType;
import p005cm.aptoide.p006pt.reactions.data.TopReaction;
import p005cm.aptoide.p006pt.reactions.p078ui.ReactionsPopup;
import p005cm.aptoide.p006pt.util.AppBarStateChangeListener;
import p005cm.aptoide.p006pt.util.AppBarStateChangeListener.State;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p005cm.aptoide.p006pt.view.ThemeUtils;
import p005cm.aptoide.p006pt.view.Translator;
import p005cm.aptoide.p006pt.view.fragment.NavigationTrackFragment;
import p019d.p022i.p296a.p298b.p301b.p302a.C13015d;
import p019d.p022i.p296a.p305c.C13034a;
import p019d.p022i.p296a.p305c.C13045l;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p028h.C14963c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.editorial.EditorialFragment */
public class EditorialFragment extends NavigationTrackFragment implements EditorialView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String CARD_ID = "cardId";
    public static final String FROM_HOME = "fromHome";
    private static final String TAG = EditorialFragment.class.getName();
    private Action action;
    private CardView actionItemCard;
    private EditorialItemsAdapter adapter;
    private AppBarLayout appBarLayout;
    private Button appCardButton;
    private ImageView appCardImage;
    private View appCardLayout;
    private TextView appCardTitle;
    private View appCardView;
    private ImageView appImage;
    private Drawable backArrow;
    private ImageView cancelDownload;
    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private RelativeLayout cardInfoLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private View downloadControlsLayout;
    private C14963c<EditorialDownloadEvent> downloadEventListener;
    private LinearLayout downloadInfoLayout;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressValue;
    private RecyclerView editorialItems;
    private View editorialItemsCard;
    private C0137ja errorMessageSubscription;
    private View genericErrorView;
    private View genericRetryButton;
    private TextView itemName;
    private C14963c<Boolean> movingCollapseSubject;
    private View noNetworkErrorView;
    private View noNetworkRetryButton;
    private DecimalFormat oneDecimalFormatter;
    private ImageView pauseDownload;
    private List<Integer> placeHolderPositions;
    @Inject
    EditorialPresenter presenter;
    private ProgressBar progressBar;
    private ImageButton reactButton;
    private C14963c<ReactionEvent> reactionEventListener;
    private C14963c<Void> ready;
    private ImageView resumeDownload;
    @Inject
    float screenHeight;
    @Inject
    float screenWidth;
    private NestedScrollView scrollView;
    private boolean shouldAnimate;
    private C14963c<Void> snackListener;
    @Inject
    String theme;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private TopReactionsPreview topReactionsPreview;
    private C14963c<EditorialEvent> uiEventsListener;
    private Window window;

    /* renamed from: cm.aptoide.pt.editorial.EditorialFragment$3 */
    static /* synthetic */ class C30703 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = new int[DownloadState.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error = new int[Error.values().length];
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State = new int[State.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2946282561239627214L, "cm/aptoide/pt/editorial/EditorialFragment$3", 37);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ERROR.ordinal()] = 1;
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
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.ACTIVE.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.INDETERMINATE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.PAUSE.ordinal()] = 5;
            $jacocoInit[9] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadState.COMPLETE.ordinal()] = 6;
            $jacocoInit[11] = true;
            try {
                $jacocoInit[13] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 1;
                $jacocoInit[14] = true;
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
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 2;
            $jacocoInit[16] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 3;
            $jacocoInit[18] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 4;
            $jacocoInit[20] = true;
            try {
                $jacocoInit[22] = true;
                $SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error[Error.NETWORK.ordinal()] = 1;
                $jacocoInit[23] = true;
            } catch (NoSuchFieldError e11) {
                try {
                    $jacocoInit[24] = true;
                } catch (NoSuchFieldError e12) {
                    $jacocoInit[26] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error[Error.GENERIC.ordinal()] = 2;
            $jacocoInit[25] = true;
            try {
                $jacocoInit[27] = true;
                $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.EXPANDED.ordinal()] = 1;
                $jacocoInit[28] = true;
            } catch (NoSuchFieldError e13) {
                try {
                    $jacocoInit[29] = true;
                } catch (NoSuchFieldError e14) {
                    try {
                        $jacocoInit[31] = true;
                    } catch (NoSuchFieldError e15) {
                        try {
                            $jacocoInit[33] = true;
                        } catch (NoSuchFieldError e16) {
                            $jacocoInit[35] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.IDLE.ordinal()] = 2;
            $jacocoInit[30] = true;
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.MOVING.ordinal()] = 3;
            $jacocoInit[32] = true;
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[State.COLLAPSED.ordinal()] = 4;
            $jacocoInit[34] = true;
            $jacocoInit[36] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8429198124606485436L, "cm/aptoide/pt/editorial/EditorialFragment", 407);
        $jacocoData = probes;
        return probes;
    }

    public EditorialFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ Toolbar access$000(EditorialFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Toolbar toolbar2 = x0.toolbar;
        $jacocoInit[400] = true;
        return toolbar2;
    }

    static /* synthetic */ TextView access$100(EditorialFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = x0.toolbarTitle;
        $jacocoInit[401] = true;
        return textView;
    }

    static /* synthetic */ void access$200(EditorialFragment x0, boolean x1) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.handleStatusBar(x1);
        $jacocoInit[402] = true;
    }

    static /* synthetic */ Drawable access$300(EditorialFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        Drawable drawable = x0.backArrow;
        $jacocoInit[403] = true;
        return drawable;
    }

    static /* synthetic */ boolean access$400(EditorialFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean isItemShown = x0.isItemShown();
        $jacocoInit[404] = true;
        return isItemShown;
    }

    static /* synthetic */ C14963c access$500(EditorialFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Boolean> cVar = x0.movingCollapseSubject;
        $jacocoInit[405] = true;
        return cVar;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[406] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        this.oneDecimalFormatter = new DecimalFormat("0.0");
        $jacocoInit[2] = true;
        this.window = getActivity().getWindow();
        $jacocoInit[3] = true;
        this.ready = C14963c.m46753p();
        $jacocoInit[4] = true;
        this.uiEventsListener = C14963c.m46753p();
        $jacocoInit[5] = true;
        this.downloadEventListener = C14963c.m46753p();
        $jacocoInit[6] = true;
        this.movingCollapseSubject = C14963c.m46753p();
        $jacocoInit[7] = true;
        this.reactionEventListener = C14963c.m46753p();
        $jacocoInit[8] = true;
        this.snackListener = C14963c.m46753p();
        $jacocoInit[9] = true;
        this.topReactionsPreview = new TopReactionsPreview();
        $jacocoInit[10] = true;
        setHasOptionsMenu(true);
        $jacocoInit[11] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[12] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        if (VERSION.SDK_INT < 21) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            this.window.setStatusBarColor(getResources().getColor(C1375R.color.black_87_alpha));
            $jacocoInit[15] = true;
        }
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[16] = true;
        this.toolbar.setTitle((CharSequence) "");
        $jacocoInit[17] = true;
        C0019n appCompatActivity = (C0019n) getActivity();
        $jacocoInit[18] = true;
        appCompatActivity.setSupportActionBar(this.toolbar);
        $jacocoInit[19] = true;
        C0760a actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar == null) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            actionBar.mo6153d(true);
            $jacocoInit[22] = true;
        }
        this.backArrow = this.toolbar.getNavigationIcon();
        $jacocoInit[23] = true;
        this.scrollView = (NestedScrollView) view.findViewById(C1375R.C1376id.nested_scroll_view);
        $jacocoInit[24] = true;
        this.appBarLayout = (AppBarLayout) view.findViewById(C1375R.C1376id.app_bar_layout);
        $jacocoInit[25] = true;
        this.appImage = (ImageView) view.findViewById(C1375R.C1376id.app_graphic);
        $jacocoInit[26] = true;
        this.itemName = (TextView) view.findViewById(C1375R.C1376id.action_item_name);
        $jacocoInit[27] = true;
        this.appCardLayout = view.findViewById(C1375R.C1376id.app_cardview_layout);
        $jacocoInit[28] = true;
        this.appCardView = view.findViewById(C1375R.C1376id.app_cardview);
        $jacocoInit[29] = true;
        this.appCardImage = (ImageView) this.appCardView.findViewById(C1375R.C1376id.app_icon_imageview);
        $jacocoInit[30] = true;
        this.appCardTitle = (TextView) this.appCardView.findViewById(C1375R.C1376id.app_title_textview);
        $jacocoInit[31] = true;
        this.appCardButton = (Button) this.appCardView.findViewById(C1375R.C1376id.appview_install_button);
        $jacocoInit[32] = true;
        this.actionItemCard = (CardView) view.findViewById(C1375R.C1376id.action_item_card);
        $jacocoInit[33] = true;
        this.editorialItemsCard = view.findViewById(C1375R.C1376id.card_info_layout);
        $jacocoInit[34] = true;
        this.editorialItems = (RecyclerView) view.findViewById(C1375R.C1376id.editorial_items);
        $jacocoInit[35] = true;
        this.genericErrorView = view.findViewById(C1375R.C1376id.generic_error);
        $jacocoInit[36] = true;
        this.noNetworkErrorView = view.findViewById(C1375R.C1376id.no_network_connection);
        $jacocoInit[37] = true;
        this.progressBar = (ProgressBar) view.findViewById(C1375R.C1376id.progress_bar);
        $jacocoInit[38] = true;
        this.genericRetryButton = this.genericErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[39] = true;
        this.noNetworkRetryButton = this.noNetworkErrorView.findViewById(C1375R.C1376id.retry);
        $jacocoInit[40] = true;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        $jacocoInit[41] = true;
        layoutManager.setOrientation(1);
        $jacocoInit[42] = true;
        this.adapter = new EditorialItemsAdapter(new ArrayList(), this.oneDecimalFormatter, this.uiEventsListener, this.downloadEventListener);
        $jacocoInit[43] = true;
        this.editorialItems.setLayoutManager(layoutManager);
        $jacocoInit[44] = true;
        this.editorialItems.setAdapter(this.adapter);
        $jacocoInit[45] = true;
        this.reactButton = (ImageButton) view.findViewById(C1375R.C1376id.add_reactions);
        $jacocoInit[46] = true;
        this.topReactionsPreview.initialReactionsSetup(view);
        $jacocoInit[47] = true;
        this.cardInfoLayout = (RelativeLayout) view.findViewById(C1375R.C1376id.card_info_install_layout);
        $jacocoInit[48] = true;
        this.downloadControlsLayout = view.findViewById(C1375R.C1376id.install_controls_layout);
        $jacocoInit[49] = true;
        this.downloadInfoLayout = (LinearLayout) view.findViewById(C1375R.C1376id.appview_transfer_info);
        $jacocoInit[50] = true;
        this.downloadProgressBar = (ProgressBar) view.findViewById(C1375R.C1376id.appview_download_progress_bar);
        $jacocoInit[51] = true;
        this.downloadProgressValue = (TextView) view.findViewById(C1375R.C1376id.appview_download_progress_number);
        $jacocoInit[52] = true;
        this.cancelDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_cancel_button);
        $jacocoInit[53] = true;
        this.resumeDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_resume_download);
        $jacocoInit[54] = true;
        this.pauseDownload = (ImageView) view.findViewById(C1375R.C1376id.appview_download_pause_download);
        $jacocoInit[55] = true;
        this.toolbarTitle = (TextView) view.findViewById(C1375R.C1376id.toolbar_title);
        $jacocoInit[56] = true;
        this.collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(C1375R.C1376id.collapsing_toolbar_layout);
        $jacocoInit[57] = true;
        this.collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(C1375R.color.transparent));
        CollapsingToolbarLayout collapsingToolbarLayout2 = this.collapsingToolbarLayout;
        $jacocoInit[58] = true;
        int color = getResources().getColor(C1375R.color.transparent);
        $jacocoInit[59] = true;
        collapsingToolbarLayout2.setCollapsedTitleTextColor(color);
        $jacocoInit[60] = true;
        this.appBarLayout.mo4186a((C0227b) new AppBarStateChangeListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ EditorialFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(6080449800460198295L, "cm/aptoide/pt/editorial/EditorialFragment$1", 20);
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
                EditorialFragment.access$000(this.this$0).setBackgroundDrawable(drawable);
                $jacocoInit[1] = true;
                EditorialFragment.access$100(this.this$0).setTextColor(toolbarColor);
                if (VERSION.SDK_INT < 21) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    EditorialFragment.access$200(this.this$0, isCollapsed);
                    $jacocoInit[4] = true;
                }
                if (EditorialFragment.access$300(this.this$0) == null) {
                    $jacocoInit[5] = true;
                } else {
                    $jacocoInit[6] = true;
                    EditorialFragment.access$300(this.this$0).setColorFilter(toolbarColor, Mode.SRC_IN);
                    $jacocoInit[7] = true;
                }
                $jacocoInit[8] = true;
            }

            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                boolean[] $jacocoInit = $jacocoInit();
                Resources resources = this.this$0.getResources();
                $jacocoInit[9] = true;
                int i = C30703.$SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[state.ordinal()];
                if (i == 1) {
                    EditorialFragment.access$500(this.this$0).onNext(Boolean.valueOf(EditorialFragment.access$400(this.this$0)));
                    $jacocoInit[10] = true;
                } else if (i != 4) {
                    EditorialFragment.access$500(this.this$0).onNext(Boolean.valueOf(EditorialFragment.access$400(this.this$0)));
                    $jacocoInit[11] = true;
                    Drawable drawable = resources.getDrawable(C1375R.drawable.editorial_up_bottom_black_gradient);
                    $jacocoInit[12] = true;
                    int color = resources.getColor(C1375R.color.white);
                    $jacocoInit[13] = true;
                    configureAppBarLayout(drawable, color, false);
                    $jacocoInit[14] = true;
                } else {
                    EditorialFragment.access$500(this.this$0).onNext(Boolean.valueOf(EditorialFragment.access$400(this.this$0)));
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
        $jacocoInit[61] = true;
        attachPresenter(this.presenter);
        $jacocoInit[62] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[63] = true;
        String simpleName = cls.getSimpleName();
        String name = StoreContext.home.name();
        $jacocoInit[64] = true;
        ScreenTagHistory build = Builder.build(simpleName, "", name);
        $jacocoInit[65] = true;
        return build;
    }

    public void onDestroy() {
        boolean[] $jacocoInit = $jacocoInit();
        this.uiEventsListener = null;
        this.snackListener = null;
        this.reactionEventListener = null;
        this.downloadEventListener = null;
        $jacocoInit[66] = true;
        super.onDestroy();
        $jacocoInit[67] = true;
        C0137ja jaVar = this.errorMessageSubscription;
        if (jaVar == null) {
            $jacocoInit[68] = true;
        } else if (jaVar.isUnsubscribed()) {
            $jacocoInit[69] = true;
        } else {
            $jacocoInit[70] = true;
            this.errorMessageSubscription.unsubscribe();
            $jacocoInit[71] = true;
        }
        this.ready = null;
        this.window = null;
        this.oneDecimalFormatter = null;
        this.movingCollapseSubject = null;
        $jacocoInit[72] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[73] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[74] = true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean[] $jacocoInit = $jacocoInit();
        if (item.getItemId() == 16908332) {
            $jacocoInit[75] = true;
            getActivity().onBackPressed();
            $jacocoInit[76] = true;
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(item);
        $jacocoInit[77] = true;
        return onOptionsItemSelected;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        ThemeUtils.setStatusBarThemeColor(getActivity(), this.theme);
        if (VERSION.SDK_INT < 16) {
            $jacocoInit[78] = true;
        } else {
            $jacocoInit[79] = true;
            View decorView = this.window.getDecorView();
            $jacocoInit[80] = true;
            decorView.setSystemUiVisibility(Opcodes.ACC_NATIVE);
            $jacocoInit[81] = true;
        }
        this.toolbar = null;
        this.appImage = null;
        this.itemName = null;
        this.actionItemCard = null;
        this.appCardView = null;
        this.appCardImage = null;
        this.appCardTitle = null;
        this.appCardButton = null;
        this.editorialItemsCard = null;
        this.editorialItems = null;
        this.genericErrorView = null;
        this.noNetworkErrorView = null;
        this.progressBar = null;
        this.genericRetryButton = null;
        this.noNetworkRetryButton = null;
        this.collapsingToolbarLayout = null;
        this.appBarLayout = null;
        this.adapter = null;
        this.backArrow = null;
        this.reactButton = null;
        this.cardInfoLayout = null;
        this.downloadControlsLayout = null;
        this.downloadInfoLayout = null;
        this.downloadProgressBar = null;
        this.downloadProgressValue = null;
        this.cancelDownload = null;
        this.resumeDownload = null;
        this.pauseDownload = null;
        this.scrollView = null;
        this.appCardLayout = null;
        $jacocoInit[82] = true;
        this.topReactionsPreview.onDestroy();
        $jacocoInit[83] = true;
        super.onDestroyView();
        $jacocoInit[84] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.editorial_layout, container, false);
        $jacocoInit[85] = true;
        return inflate;
    }

    public void showLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.actionItemCard.setVisibility(8);
        $jacocoInit[86] = true;
        this.editorialItemsCard.setVisibility(8);
        $jacocoInit[87] = true;
        this.appCardView.setVisibility(8);
        $jacocoInit[88] = true;
        this.itemName.setVisibility(8);
        $jacocoInit[89] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[90] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[91] = true;
        this.progressBar.setVisibility(0);
        $jacocoInit[92] = true;
    }

    public void hideLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        this.actionItemCard.setVisibility(8);
        $jacocoInit[93] = true;
        this.editorialItemsCard.setVisibility(8);
        $jacocoInit[94] = true;
        this.appCardView.setVisibility(8);
        $jacocoInit[95] = true;
        this.itemName.setVisibility(8);
        $jacocoInit[96] = true;
        this.genericErrorView.setVisibility(8);
        $jacocoInit[97] = true;
        this.noNetworkErrorView.setVisibility(8);
        $jacocoInit[98] = true;
        this.progressBar.setVisibility(8);
        $jacocoInit[99] = true;
    }

    public C0120S<Void> retryClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> b = C0120S.m649b(C13034a.m42490a(this.genericRetryButton), C13034a.m42490a(this.noNetworkRetryButton));
        $jacocoInit[100] = true;
        return b;
    }

    public C0120S<EditorialEvent> appCardClicked(EditorialViewModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.appCardView);
        C3187m mVar = new C3187m(model);
        $jacocoInit[101] = true;
        C0120S j = a.mo3669j(mVar);
        C14963c<EditorialEvent> cVar = this.uiEventsListener;
        C3207r rVar = C3207r.f6577a;
        $jacocoInit[102] = true;
        C0120S<EditorialEvent> d = j.mo3651d(cVar.mo3653d((C0132p<? super T, Boolean>) rVar));
        $jacocoInit[103] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ EditorialEvent m7670a(EditorialViewModel model, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.APPCARD;
        long bottomCardAppId = model.getBottomCardAppId();
        $jacocoInit[398] = true;
        EditorialEvent editorialEvent = new EditorialEvent(type, bottomCardAppId, model.getBottomCardPackageName());
        $jacocoInit[399] = true;
        return editorialEvent;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7677b(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.APPCARD;
        $jacocoInit[395] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[396] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[397] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7672a(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.ACTION;
        $jacocoInit[392] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[393] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[394] = true;
        return valueOf;
    }

    public C0120S<EditorialEvent> actionButtonClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<EditorialEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3199p.f6566a);
        $jacocoInit[104] = true;
        return d;
    }

    public void populateView(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        populateAppContent(editorialViewModel);
        $jacocoInit[105] = true;
        populateCardContent(editorialViewModel);
        $jacocoInit[106] = true;
        this.ready.onNext(null);
        $jacocoInit[107] = true;
    }

    public void showError(Error error) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C30703.$SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error[error.ordinal()];
        if (i == 1) {
            this.noNetworkErrorView.setVisibility(0);
            $jacocoInit[109] = true;
        } else if (i != 2) {
            $jacocoInit[108] = true;
        } else {
            this.genericErrorView.setVisibility(0);
            $jacocoInit[110] = true;
        }
        $jacocoInit[111] = true;
    }

    public void showDownloadModel(EditorialDownloadModel downloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.action = downloadModel.getAction();
        $jacocoInit[112] = true;
        EditorialItemsViewHolder placeHolderViewHolder = getViewHolderForAdapterPosition(downloadModel.getPosition());
        $jacocoInit[113] = true;
        if (downloadModel.isDownloading()) {
            $jacocoInit[114] = true;
            this.downloadInfoLayout.setVisibility(0);
            $jacocoInit[115] = true;
            this.cardInfoLayout.setVisibility(8);
            $jacocoInit[116] = true;
            setDownloadState(downloadModel.getProgress(), downloadModel.getDownloadState());
            if (placeHolderViewHolder == null) {
                $jacocoInit[117] = true;
            } else {
                $jacocoInit[118] = true;
                placeHolderViewHolder.setPlaceHolderDownloadingInfo(downloadModel);
                $jacocoInit[119] = true;
            }
        } else {
            this.downloadInfoLayout.setVisibility(8);
            $jacocoInit[120] = true;
            this.cardInfoLayout.setVisibility(0);
            $jacocoInit[121] = true;
            setButtonText(downloadModel);
            if (placeHolderViewHolder == null) {
                $jacocoInit[122] = true;
            } else {
                $jacocoInit[123] = true;
                String string = getResources().getString(C1375R.string.appview_button_update);
                $jacocoInit[124] = true;
                String string2 = getResources().getString(C1375R.string.appview_button_install);
                $jacocoInit[125] = true;
                String string3 = getResources().getString(C1375R.string.appview_button_open);
                $jacocoInit[126] = true;
                String string4 = getResources().getString(C1375R.string.appview_button_downgrade);
                $jacocoInit[127] = true;
                placeHolderViewHolder.setPlaceHolderDefaultStateInfo(downloadModel, string, string2, string3, string4);
                $jacocoInit[128] = true;
            }
            if (!downloadModel.hasError()) {
                $jacocoInit[129] = true;
            } else {
                $jacocoInit[130] = true;
                handleDownloadError(downloadModel.getDownloadState());
                $jacocoInit[131] = true;
            }
        }
        $jacocoInit[132] = true;
    }

    public C0120S<Boolean> showRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[133] = true;
        String string = getResources().getString(C1375R.string.root_access_dialog);
        $jacocoInit[134] = true;
        C0120S createGenericYesNoCancelMessage = GenericDialogs.createGenericYesNoCancelMessage(context, null, string);
        C3167h hVar = C3167h.f6531a;
        $jacocoInit[135] = true;
        C0120S<Boolean> j = createGenericYesNoCancelMessage.mo3669j(hVar);
        $jacocoInit[136] = true;
        return j;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7681c(EResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(response.equals(EResponse.YES));
        $jacocoInit[391] = true;
        return valueOf;
    }

    public void openApp(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        SystemU.openApp(packageName, getContext().getPackageManager(), getContext());
        $jacocoInit[137] = true;
    }

    public C0120S<EditorialDownloadEvent> installButtonClick(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.appCardButton);
        C3163g gVar = new C3163g(this, editorialViewModel);
        $jacocoInit[138] = true;
        C0120S j = a.mo3669j(gVar);
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        C3191n nVar = C3191n.f6557a;
        $jacocoInit[139] = true;
        C0120S<EditorialDownloadEvent> d = j.mo3651d(cVar.mo3653d((C0132p<? super T, Boolean>) nVar));
        $jacocoInit[140] = true;
        return d;
    }

    /* renamed from: c */
    public /* synthetic */ EditorialDownloadEvent mo13796c(EditorialViewModel editorialViewModel, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialDownloadEvent editorialDownloadEvent = new EditorialDownloadEvent(editorialViewModel, this.action);
        $jacocoInit[390] = true;
        return editorialDownloadEvent;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m7676b(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.BUTTON;
        $jacocoInit[387] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[388] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[389] = true;
        return valueOf;
    }

    public C0120S<EditorialDownloadEvent> pauseDownload(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.pauseDownload);
        C3155e eVar = new C3155e(editorialViewModel);
        $jacocoInit[141] = true;
        C0120S j = a.mo3669j(eVar);
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        C3171i iVar = C3171i.f6536a;
        $jacocoInit[142] = true;
        C0120S<EditorialDownloadEvent> d = j.mo3651d(cVar.mo3653d((C0132p<? super T, Boolean>) iVar));
        $jacocoInit[143] = true;
        return d;
    }

    /* renamed from: d */
    static /* synthetic */ EditorialDownloadEvent m7682d(EditorialViewModel editorialViewModel, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.PAUSE;
        $jacocoInit[384] = true;
        String bottomCardPackageName = editorialViewModel.getBottomCardPackageName();
        String bottomCardMd5 = editorialViewModel.getBottomCardMd5();
        $jacocoInit[385] = true;
        EditorialDownloadEvent editorialDownloadEvent = new EditorialDownloadEvent(type, bottomCardPackageName, bottomCardMd5, editorialViewModel.getBottomCardVersionCode(), editorialViewModel.getBottomCardAppId());
        $jacocoInit[386] = true;
        return editorialDownloadEvent;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7679c(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.PAUSE;
        $jacocoInit[381] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[382] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[383] = true;
        return valueOf;
    }

    public C0120S<EditorialDownloadEvent> resumeDownload(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.resumeDownload);
        C3220v vVar = new C3220v(editorialViewModel);
        $jacocoInit[144] = true;
        C0120S j = a.mo3669j(vVar);
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        C3229y yVar = C3229y.f6602a;
        $jacocoInit[145] = true;
        C0120S<EditorialDownloadEvent> d = j.mo3651d(cVar.mo3653d((C0132p<? super T, Boolean>) yVar));
        $jacocoInit[146] = true;
        return d;
    }

    /* renamed from: e */
    static /* synthetic */ EditorialDownloadEvent m7685e(EditorialViewModel editorialViewModel, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.RESUME;
        $jacocoInit[378] = true;
        String bottomCardPackageName = editorialViewModel.getBottomCardPackageName();
        String bottomCardMd5 = editorialViewModel.getBottomCardMd5();
        $jacocoInit[379] = true;
        EditorialDownloadEvent editorialDownloadEvent = new EditorialDownloadEvent(type, bottomCardPackageName, bottomCardMd5, editorialViewModel.getBottomCardVersionCode(), editorialViewModel.getBottomCardAppId());
        $jacocoInit[380] = true;
        return editorialDownloadEvent;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m7683d(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.RESUME;
        $jacocoInit[375] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[376] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[377] = true;
        return valueOf;
    }

    public C0120S<EditorialDownloadEvent> cancelDownload(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13034a.m42490a(this.cancelDownload);
        C3214t tVar = new C3214t(editorialViewModel);
        $jacocoInit[147] = true;
        C0120S j = a.mo3669j(tVar);
        C14963c<EditorialDownloadEvent> cVar = this.downloadEventListener;
        C3183l lVar = C3183l.f6549a;
        $jacocoInit[148] = true;
        C0120S<EditorialDownloadEvent> d = j.mo3651d(cVar.mo3653d((C0132p<? super T, Boolean>) lVar));
        $jacocoInit[149] = true;
        return d;
    }

    /* renamed from: b */
    static /* synthetic */ EditorialDownloadEvent m7675b(EditorialViewModel editorialViewModel, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.CANCEL;
        $jacocoInit[372] = true;
        String bottomCardPackageName = editorialViewModel.getBottomCardPackageName();
        String bottomCardMd5 = editorialViewModel.getBottomCardMd5();
        $jacocoInit[373] = true;
        EditorialDownloadEvent editorialDownloadEvent = new EditorialDownloadEvent(type, bottomCardPackageName, bottomCardMd5, editorialViewModel.getBottomCardVersionCode(), editorialViewModel.getBottomCardAppId());
        $jacocoInit[374] = true;
        return editorialDownloadEvent;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7671a(EditorialDownloadEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.CANCEL;
        $jacocoInit[369] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[370] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[371] = true;
        return valueOf;
    }

    public C0120S<Void> isViewReady() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.ready;
        $jacocoInit[150] = true;
        return cVar;
    }

    public C0120S<ScrollEvent> placeHolderVisibilityChange() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C13015d.m42476a(this.scrollView);
        C3159f fVar = new C3159f(this);
        $jacocoInit[151] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
        C3190mc mcVar = C3190mc.f6556a;
        $jacocoInit[152] = true;
        C0120S<ScrollEvent> c = f.mo3645c((C0132p<? super T, ? extends U>) mcVar);
        $jacocoInit[153] = true;
        return c;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo13795b(C13045l viewScrollChangeEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(viewScrollChangeEvent);
        C3175j jVar = new C3175j(this);
        $jacocoInit[363] = true;
        C0120S j = c.mo3669j(jVar);
        C3226x xVar = new C3226x(this, viewScrollChangeEvent);
        $jacocoInit[364] = true;
        C0120S j2 = j.mo3669j(xVar);
        $jacocoInit[365] = true;
        return j2;
    }

    /* renamed from: a */
    public /* synthetic */ Boolean mo13789a(C13045l scrollDown) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(isItemShown());
        $jacocoInit[368] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ ScrollEvent mo13788a(C13045l viewScrollChangeEvent, Boolean isItemShown) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[366] = true;
        ScrollEvent scrollEvent = new ScrollEvent(isScrollDown(viewScrollChangeEvent.mo41933b(), viewScrollChangeEvent.mo41934c()), isItemShown);
        $jacocoInit[367] = true;
        return scrollEvent;
    }

    public void removeBottomCardAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Integer> list = this.placeHolderPositions;
        if (list == null) {
            $jacocoInit[154] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[155] = true;
        } else {
            List<Integer> list2 = this.placeHolderPositions;
            $jacocoInit[156] = true;
            EditorialItemsViewHolder placeHolderViewHolder = getViewHolderForAdapterPosition(((Integer) list2.get(0)).intValue());
            if (placeHolderViewHolder == null) {
                $jacocoInit[157] = true;
            } else {
                $jacocoInit[158] = true;
                View view = placeHolderViewHolder.getPlaceHolder();
                if (view == null) {
                    $jacocoInit[159] = true;
                } else if (!this.shouldAnimate) {
                    $jacocoInit[160] = true;
                } else {
                    $jacocoInit[161] = true;
                    configureAppCardAnimation(this.appCardLayout, view, 0.0f, 300, true);
                    $jacocoInit[162] = true;
                }
            }
        }
        $jacocoInit[163] = true;
    }

    public void addBottomCardAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Integer> list = this.placeHolderPositions;
        if (list == null) {
            $jacocoInit[164] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[165] = true;
        } else {
            List<Integer> list2 = this.placeHolderPositions;
            $jacocoInit[166] = true;
            EditorialItemsViewHolder placeHolderViewHolder = getViewHolderForAdapterPosition(((Integer) list2.get(0)).intValue());
            if (placeHolderViewHolder == null) {
                $jacocoInit[167] = true;
            } else {
                $jacocoInit[168] = true;
                View view = placeHolderViewHolder.getPlaceHolder();
                if (view == null) {
                    $jacocoInit[169] = true;
                } else if (!this.shouldAnimate) {
                    $jacocoInit[170] = true;
                } else {
                    $jacocoInit[171] = true;
                    configureAppCardAnimation(view, this.appCardLayout, 0.1f, 300, false);
                    $jacocoInit[172] = true;
                }
            }
        }
        $jacocoInit[173] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m7680c(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.MEDIA;
        $jacocoInit[360] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[361] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[362] = true;
        return valueOf;
    }

    public C0120S<EditorialEvent> mediaContentClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<EditorialEvent> d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3211s.f6581a);
        $jacocoInit[174] = true;
        return d;
    }

    public void managePlaceHolderVisibity() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Integer> list = this.placeHolderPositions;
        if (list == null) {
            $jacocoInit[175] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[176] = true;
        } else {
            List<Integer> list2 = this.placeHolderPositions;
            $jacocoInit[177] = true;
            EditorialItemsViewHolder placeHolderViewHolder = getViewHolderForAdapterPosition(((Integer) list2.get(0)).intValue());
            $jacocoInit[178] = true;
            if (placeHolderViewHolder == null) {
                $jacocoInit[179] = true;
            } else if (!placeHolderViewHolder.isVisible(this.screenHeight, this.screenWidth)) {
                $jacocoInit[180] = true;
            } else {
                $jacocoInit[181] = true;
                removeBottomCardAnimation();
                $jacocoInit[182] = true;
            }
        }
        $jacocoInit[183] = true;
    }

    /* renamed from: d */
    static /* synthetic */ Boolean m7684d(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Type clickType = editorialEvent.getClickType();
        Type type = Type.MEDIA_LIST;
        $jacocoInit[357] = true;
        boolean equals = clickType.equals(type);
        $jacocoInit[358] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[359] = true;
        return valueOf;
    }

    public C0120S<EditorialEvent> mediaListDescriptionChanged() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = this.uiEventsListener.mo3653d((C0132p<? super T, Boolean>) C3195o.f6561a);
        C3206qc qcVar = C3206qc.f6576a;
        $jacocoInit[184] = true;
        C0120S<EditorialEvent> c = d.mo3645c((C0132p<? super T, ? extends U>) qcVar);
        $jacocoInit[185] = true;
        return c;
    }

    public void manageMediaListDescriptionAnimationVisibility(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        int contentPosition = editorialEvent.getPosition();
        RecyclerView recyclerView = this.editorialItems;
        $jacocoInit[186] = true;
        EditorialItemsViewHolder editorialItemsViewHolder = (EditorialItemsViewHolder) recyclerView.mo7544b(contentPosition);
        if (editorialItemsViewHolder == null) {
            $jacocoInit[187] = true;
        } else {
            $jacocoInit[188] = true;
            int firstVisiblePosition = editorialEvent.getFirstVisiblePosition();
            List media = editorialEvent.getMedia();
            $jacocoInit[189] = true;
            editorialItemsViewHolder.manageDescriptionAnimationVisibility(firstVisiblePosition, media);
            $jacocoInit[190] = true;
        }
        $jacocoInit[191] = true;
    }

    public void setMediaListDescriptionsVisible(EditorialEvent editorialEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        RecyclerView recyclerView = this.editorialItems;
        $jacocoInit[192] = true;
        int position = editorialEvent.getPosition();
        $jacocoInit[193] = true;
        EditorialItemsViewHolder editorialItemsViewHolder = (EditorialItemsViewHolder) recyclerView.mo7544b(position);
        if (editorialItemsViewHolder == null) {
            $jacocoInit[194] = true;
        } else {
            $jacocoInit[195] = true;
            editorialItemsViewHolder.setAllDescriptionsVisible();
            $jacocoInit[196] = true;
        }
        $jacocoInit[197] = true;
    }

    public C0120S<Boolean> handleMovingCollapse() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> b = this.movingCollapseSubject.mo3628b();
        $jacocoInit[198] = true;
        return b;
    }

    public C0120S<Boolean> showDowngradeMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Context context = getContext();
        $jacocoInit[199] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[200] = true;
        String string = resources.getString(C1375R.string.downgrade_warning_dialog);
        $jacocoInit[201] = true;
        C0120S createGenericContinueCancelMessage = GenericDialogs.createGenericContinueCancelMessage(context, null, string);
        C3179k kVar = C3179k.f6545a;
        $jacocoInit[202] = true;
        C0120S<Boolean> j = createGenericContinueCancelMessage.mo3669j(kVar);
        $jacocoInit[203] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7673a(EResponse eResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(eResponse.equals(EResponse.YES));
        $jacocoInit[356] = true;
        return valueOf;
    }

    public void showDowngradingMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1623a(getView(), (int) C1375R.string.downgrading_msg, -1);
        $jacocoInit[204] = true;
        a.mo4690h();
        $jacocoInit[205] = true;
    }

    public C0120S<Void> reactionsButtonClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.reactButton);
        $jacocoInit[206] = true;
        return a;
    }

    public C0120S<Void> reactionsButtonLongPressed() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> c = C13034a.m42492c(this.reactButton);
        $jacocoInit[207] = true;
        return c;
    }

    public void showTopReactions(String userReaction, List<TopReaction> reactions, int numberOfReactions) {
        boolean[] $jacocoInit = $jacocoInit();
        setUserReaction(userReaction);
        $jacocoInit[208] = true;
        this.topReactionsPreview.setReactions(reactions, numberOfReactions, getContext());
        $jacocoInit[209] = true;
    }

    public void showReactionsPopup(String cardId, String groupId) {
        boolean[] $jacocoInit = $jacocoInit();
        ReactionsPopup reactionsPopup = new ReactionsPopup(getContext(), this.reactButton);
        $jacocoInit[210] = true;
        reactionsPopup.show();
        $jacocoInit[211] = true;
        reactionsPopup.setOnReactionsItemClickListener(new C3203q(this, cardId, groupId, reactionsPopup));
        $jacocoInit[212] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13791a(String cardId, String groupId, ReactionsPopup reactionsPopup, ReactionType item) {
        boolean[] $jacocoInit = $jacocoInit();
        this.reactionEventListener.onNext(new ReactionEvent(cardId, ReactionMapper.mapUserReaction(item), groupId));
        $jacocoInit[353] = true;
        reactionsPopup.dismiss();
        $jacocoInit[354] = true;
        reactionsPopup.setOnReactionsItemClickListener(null);
        $jacocoInit[355] = true;
    }

    public C0120S<ReactionEvent> reactionClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<ReactionEvent> cVar = this.reactionEventListener;
        $jacocoInit[213] = true;
        return cVar;
    }

    public void setUserReaction(String reaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.topReactionsPreview.isReactionValid(reaction)) {
            $jacocoInit[214] = true;
            this.reactButton.setImageResource(ReactionMapper.mapReaction(reaction));
            $jacocoInit[215] = true;
        } else {
            this.reactButton.setImageResource(C1375R.drawable.ic_reaction_emoticon);
            $jacocoInit[216] = true;
        }
        $jacocoInit[217] = true;
    }

    public void showLoginDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.editorial_reactions_login_short), 0);
        C3223w wVar = new C3223w(this);
        $jacocoInit[218] = true;
        a.mo4552a((int) C1375R.string.login, (OnClickListener) wVar);
        $jacocoInit[219] = true;
        a.mo4690h();
        $jacocoInit[220] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo13790a(View snackView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.snackListener.onNext(null);
        $jacocoInit[352] = true;
    }

    public C0120S<Void> snackLoginClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C14963c<Void> cVar = this.snackListener;
        $jacocoInit[221] = true;
        return cVar;
    }

    public void showGenericErrorToast() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.error_occured), 0);
        $jacocoInit[222] = true;
        a.mo4690h();
        $jacocoInit[223] = true;
    }

    public void showNetworkErrorToast() {
        boolean[] $jacocoInit = $jacocoInit();
        Snackbar a = Snackbar.m1624a(getView(), (CharSequence) getString(C1375R.string.connection_error), 0);
        $jacocoInit[224] = true;
        a.mo4690h();
        $jacocoInit[225] = true;
    }

    private void populateAppContent(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        this.placeHolderPositions = editorialViewModel.getPlaceHolderPositions();
        $jacocoInit[226] = true;
        this.shouldAnimate = editorialViewModel.shouldHaveAnimation();
        $jacocoInit[227] = true;
        if (editorialViewModel.hasBackgroundImage()) {
            $jacocoInit[228] = true;
            ImageLoader with = ImageLoader.with(getContext());
            $jacocoInit[229] = true;
            with.load(editorialViewModel.getBackgroundImage(), this.appImage);
            $jacocoInit[230] = true;
        } else {
            this.appImage.setBackgroundColor(getResources().getColor(C1375R.color.grey_fog_normal));
            $jacocoInit[231] = true;
        }
        String caption = editorialViewModel.getCaption();
        $jacocoInit[232] = true;
        this.toolbar.setTitle((CharSequence) caption);
        $jacocoInit[233] = true;
        this.toolbarTitle.setText(editorialViewModel.getTitle());
        $jacocoInit[234] = true;
        this.appImage.setVisibility(0);
        $jacocoInit[235] = true;
        this.itemName.setText(Translator.translate(caption, getContext(), ""));
        CaptionBackgroundPainter captionBackgroundPainter2 = this.captionBackgroundPainter;
        CardView cardView = this.actionItemCard;
        $jacocoInit[236] = true;
        String captionColor = editorialViewModel.getCaptionColor();
        $jacocoInit[237] = true;
        captionBackgroundPainter2.addColorBackgroundToCaption(cardView, captionColor);
        $jacocoInit[238] = true;
        this.itemName.setVisibility(0);
        $jacocoInit[239] = true;
        this.actionItemCard.setVisibility(0);
        $jacocoInit[240] = true;
        setBottomAppCardInfo(editorialViewModel);
        $jacocoInit[241] = true;
    }

    private void setBottomAppCardInfo(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!editorialViewModel.shouldHaveAnimation()) {
            $jacocoInit[242] = true;
        } else {
            $jacocoInit[243] = true;
            this.appCardTitle.setText(editorialViewModel.getBottomCardAppName());
            $jacocoInit[244] = true;
            this.appCardTitle.setVisibility(0);
            $jacocoInit[245] = true;
            ImageLoader with = ImageLoader.with(getContext());
            $jacocoInit[246] = true;
            with.load(editorialViewModel.getBottomCardIcon(), this.appCardImage);
            $jacocoInit[247] = true;
            this.appCardView.setVisibility(0);
            $jacocoInit[248] = true;
        }
        $jacocoInit[249] = true;
    }

    private void populateCardContent(EditorialViewModel editorialViewModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!editorialViewModel.hasContent()) {
            $jacocoInit[250] = true;
        } else {
            $jacocoInit[251] = true;
            this.editorialItemsCard.setVisibility(0);
            $jacocoInit[252] = true;
            this.adapter.add(editorialViewModel.getContentList(), editorialViewModel.shouldHaveAnimation());
            $jacocoInit[253] = true;
        }
        $jacocoInit[254] = true;
    }

    private void setButtonText(DownloadModel model) {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = model.getAction();
        $jacocoInit[255] = true;
        int i = C30703.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action2.ordinal()];
        if (i == 1) {
            this.appCardButton.setText(getResources().getString(C1375R.string.appview_button_update));
            $jacocoInit[257] = true;
        } else if (i == 2) {
            this.appCardButton.setText(getResources().getString(C1375R.string.appview_button_install));
            $jacocoInit[258] = true;
        } else if (i == 3) {
            this.appCardButton.setText(getResources().getString(C1375R.string.appview_button_open));
            $jacocoInit[259] = true;
        } else if (i != 4) {
            $jacocoInit[256] = true;
        } else {
            this.appCardButton.setText(getResources().getString(C1375R.string.appview_button_downgrade));
            $jacocoInit[260] = true;
        }
        $jacocoInit[261] = true;
    }

    private void handleDownloadError(DownloadState downloadState) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C30703.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        if (i == 1) {
            showErrorDialog("", getContext().getString(C1375R.string.error_occured));
            $jacocoInit[262] = true;
        } else if (i == 2) {
            String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
            $jacocoInit[263] = true;
            String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
            $jacocoInit[264] = true;
            showErrorDialog(string, string2);
            $jacocoInit[265] = true;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Download State ");
            sb.append(downloadState);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            $jacocoInit[266] = true;
            throw illegalStateException;
        }
        $jacocoInit[267] = true;
    }

    private void showErrorDialog(String title, String message) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S createGenericOkMessage = GenericDialogs.createGenericOkMessage(getContext(), title, message);
        $jacocoInit[268] = true;
        C0120S b = createGenericOkMessage.mo3634b(C14522a.m46170a());
        C3217u uVar = C3217u.f6587a;
        C3151d dVar = C3151d.f6512a;
        $jacocoInit[269] = true;
        this.errorMessageSubscription = b.mo3626a((C0129b<? super T>) uVar, (C0129b<Throwable>) dVar);
        $jacocoInit[270] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m7674a(Throwable error) {
        boolean[] $jacocoInit = $jacocoInit();
        new OnErrorNotImplementedException(error);
        $jacocoInit[350] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m7678b(EResponse eResponse) {
        $jacocoInit()[351] = true;
    }

    private void setDownloadState(int progress, DownloadState downloadState) {
        boolean[] $jacocoInit = $jacocoInit();
        LayoutParams pauseShowing = new LayoutParams(-1, -1, 4.0f);
        $jacocoInit[271] = true;
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2.0f);
        $jacocoInit[272] = true;
        LayoutParams pauseHidden = layoutParams;
        String str = "%";
        switch (C30703.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()]) {
            case 1:
                showErrorDialog("", getContext().getString(C1375R.string.error_occured));
                $jacocoInit[298] = true;
                break;
            case 2:
                String string = getContext().getString(C1375R.string.out_of_space_dialog_title);
                $jacocoInit[299] = true;
                String string2 = getContext().getString(C1375R.string.out_of_space_dialog_message);
                $jacocoInit[300] = true;
                showErrorDialog(string, string2);
                $jacocoInit[301] = true;
                break;
            case 3:
                this.downloadProgressBar.setIndeterminate(false);
                $jacocoInit[274] = true;
                this.downloadProgressBar.setProgress(progress);
                $jacocoInit[275] = true;
                TextView textView = this.downloadProgressValue;
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(progress));
                sb.append(str);
                textView.setText(sb.toString());
                $jacocoInit[276] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[277] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[278] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[279] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[280] = true;
                break;
            case 4:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[281] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[282] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[283] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[284] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[285] = true;
                break;
            case 5:
                this.downloadProgressBar.setIndeterminate(false);
                $jacocoInit[286] = true;
                this.downloadProgressBar.setProgress(progress);
                $jacocoInit[287] = true;
                TextView textView2 = this.downloadProgressValue;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.valueOf(progress));
                sb2.append(str);
                textView2.setText(sb2.toString());
                $jacocoInit[288] = true;
                this.pauseDownload.setVisibility(8);
                $jacocoInit[289] = true;
                this.cancelDownload.setVisibility(0);
                $jacocoInit[290] = true;
                this.resumeDownload.setVisibility(0);
                $jacocoInit[291] = true;
                this.downloadControlsLayout.setLayoutParams(pauseHidden);
                $jacocoInit[292] = true;
                break;
            case 6:
                this.downloadProgressBar.setIndeterminate(true);
                $jacocoInit[293] = true;
                this.pauseDownload.setVisibility(0);
                $jacocoInit[294] = true;
                this.cancelDownload.setVisibility(8);
                $jacocoInit[295] = true;
                this.resumeDownload.setVisibility(8);
                $jacocoInit[296] = true;
                this.downloadControlsLayout.setLayoutParams(pauseShowing);
                $jacocoInit[297] = true;
                break;
            default:
                $jacocoInit[273] = true;
                break;
        }
        $jacocoInit[302] = true;
    }

    private void handleStatusBar(boolean collapseState) {
        boolean[] $jacocoInit = $jacocoInit();
        if (collapseState) {
            int i = VERSION.SDK_INT;
            if (i < 21) {
                $jacocoInit[303] = true;
            } else if (i >= 23) {
                $jacocoInit[304] = true;
            } else {
                $jacocoInit[305] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.grey_medium));
                $jacocoInit[306] = true;
            }
            if (VERSION.SDK_INT < 23) {
                $jacocoInit[307] = true;
            } else {
                $jacocoInit[308] = true;
                View decorView = this.window.getDecorView();
                $jacocoInit[309] = true;
                decorView.setSystemUiVisibility(Opcodes.ACC_ANNOTATION);
                $jacocoInit[310] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.white));
                $jacocoInit[311] = true;
            }
        } else {
            int i2 = VERSION.SDK_INT;
            if (i2 < 21) {
                $jacocoInit[312] = true;
            } else if (i2 >= 23) {
                $jacocoInit[313] = true;
            } else {
                $jacocoInit[314] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.black_87_alpha));
                $jacocoInit[315] = true;
                View decorView2 = this.window.getDecorView();
                $jacocoInit[316] = true;
                decorView2.setSystemUiVisibility(0);
                $jacocoInit[317] = true;
            }
            if (VERSION.SDK_INT < 23) {
                $jacocoInit[318] = true;
            } else {
                $jacocoInit[319] = true;
                View decorView3 = this.window.getDecorView();
                $jacocoInit[320] = true;
                decorView3.setSystemUiVisibility(0);
                $jacocoInit[321] = true;
                this.window.setStatusBarColor(getResources().getColor(C1375R.color.black_87_alpha));
                $jacocoInit[322] = true;
            }
        }
        $jacocoInit[323] = true;
    }

    private boolean isScrollDown(int oldY, int newY) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (newY > oldY) {
            $jacocoInit[324] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[325] = true;
        }
        $jacocoInit[326] = true;
        return z;
    }

    private boolean isItemShown() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Integer> list = this.placeHolderPositions;
        boolean z = false;
        if (list == null) {
            $jacocoInit[327] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[328] = true;
        } else {
            List<Integer> list2 = this.placeHolderPositions;
            $jacocoInit[329] = true;
            EditorialItemsViewHolder placeHolderViewHolder = getViewHolderForAdapterPosition(((Integer) list2.get(0)).intValue());
            $jacocoInit[330] = true;
            if (placeHolderViewHolder == null) {
                $jacocoInit[331] = true;
            } else if (!placeHolderViewHolder.isVisible(this.screenHeight, this.screenWidth)) {
                $jacocoInit[332] = true;
            } else {
                $jacocoInit[333] = true;
                z = true;
                $jacocoInit[335] = true;
                return z;
            }
            $jacocoInit[334] = true;
            $jacocoInit[335] = true;
            return z;
        }
        $jacocoInit[336] = true;
        return false;
    }

    private void configureAppCardAnimation(View layoutToHide, View layoutToShow, float hideScale, int duration, boolean isRemoveBottomCard) {
        boolean[] $jacocoInit = $jacocoInit();
        ViewPropertyAnimator animate = layoutToHide.animate();
        $jacocoInit[337] = true;
        ViewPropertyAnimator scaleY = animate.scaleY(hideScale);
        $jacocoInit[338] = true;
        ViewPropertyAnimator scaleX = scaleY.scaleX(hideScale);
        $jacocoInit[339] = true;
        ViewPropertyAnimator alpha = scaleX.alpha(0.0f);
        long j = (long) duration;
        $jacocoInit[340] = true;
        ViewPropertyAnimator duration2 = alpha.setDuration(j);
        final View view = layoutToShow;
        final int i = duration;
        final boolean z = isRemoveBottomCard;
        final View view2 = layoutToHide;
        C30682 r3 = new AnimatorListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ EditorialFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-659717678335694318L, "cm/aptoide/pt/editorial/EditorialFragment$2", 14);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onAnimationStart(Animator animator) {
                boolean[] $jacocoInit = $jacocoInit();
                ViewPropertyAnimator animate = view.animate();
                $jacocoInit[1] = true;
                ViewPropertyAnimator scaleX = animate.scaleX(1.0f);
                $jacocoInit[2] = true;
                ViewPropertyAnimator scaleY = scaleX.scaleY(1.0f);
                $jacocoInit[3] = true;
                ViewPropertyAnimator alpha = scaleY.alpha(1.0f);
                long j = (long) i;
                $jacocoInit[4] = true;
                ViewPropertyAnimator duration = alpha.setDuration(j);
                C30691 r3 = new AnimatorListener(this) {
                    private static transient /* synthetic */ boolean[] $jacocoData;
                    final /* synthetic */ C30682 this$1;

                    private static /* synthetic */ boolean[] $jacocoInit() {
                        boolean[] zArr = $jacocoData;
                        if (zArr != null) {
                            return zArr;
                        }
                        boolean[] probes = Offline.getProbes(3137668397693660164L, "cm/aptoide/pt/editorial/EditorialFragment$2$1", 5);
                        $jacocoData = probes;
                        return probes;
                    }

                    {
                        boolean[] $jacocoInit = $jacocoInit();
                        this.this$1 = this$1;
                        $jacocoInit[0] = true;
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean[] $jacocoInit = $jacocoInit();
                        view.setVisibility(0);
                        $jacocoInit[1] = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        $jacocoInit()[2] = true;
                    }

                    public void onAnimationCancel(Animator animator) {
                        $jacocoInit()[3] = true;
                    }

                    public void onAnimationRepeat(Animator animator) {
                        $jacocoInit()[4] = true;
                    }
                };
                $jacocoInit[5] = true;
                ViewPropertyAnimator listener = duration.setListener(r3);
                $jacocoInit[6] = true;
                listener.start();
                $jacocoInit[7] = true;
            }

            public void onAnimationEnd(Animator animator) {
                boolean[] $jacocoInit = $jacocoInit();
                if (z) {
                    $jacocoInit[8] = true;
                } else {
                    $jacocoInit[9] = true;
                    view2.setVisibility(4);
                    $jacocoInit[10] = true;
                }
                $jacocoInit[11] = true;
            }

            public void onAnimationCancel(Animator animator) {
                $jacocoInit()[12] = true;
            }

            public void onAnimationRepeat(Animator animator) {
                $jacocoInit()[13] = true;
            }
        };
        $jacocoInit[341] = true;
        ViewPropertyAnimator listener = duration2.setListener(r3);
        $jacocoInit[342] = true;
        listener.start();
        $jacocoInit[343] = true;
    }

    private EditorialItemsViewHolder getViewHolderForAdapterPosition(int placeHolderPosition) {
        boolean[] $jacocoInit = $jacocoInit();
        if (placeHolderPosition != -1) {
            RecyclerView recyclerView = this.editorialItems;
            $jacocoInit[344] = true;
            EditorialItemsViewHolder placeHolderViewHolder = (EditorialItemsViewHolder) recyclerView.mo7544b(placeHolderPosition);
            if (placeHolderViewHolder != null) {
                $jacocoInit[345] = true;
            } else {
                $jacocoInit[346] = true;
                Log.e(TAG, "Unable to find editorialViewHolder");
                $jacocoInit[347] = true;
            }
            $jacocoInit[348] = true;
            return placeHolderViewHolder;
        }
        $jacocoInit[349] = true;
        return null;
    }
}
