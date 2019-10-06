package p005cm.aptoide.p006pt.store.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.text.ParcelableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreViewModel;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannel;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowersFragment;
import p005cm.aptoide.p006pt.timeline.view.follow.TimeLineFollowingFragment;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.app.ListStoreAppsFragment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.spannable.SpannableFactory;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.view.GridStoreMetaWidget */
public class GridStoreMetaWidget extends MetaStoresBaseWidget<GridStoreMetaDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager accountManager;
    private TextView appsCountTv;
    private BadgeDialogFactory badgeDialogFactory;
    private ImageView badgeIcon;
    private View buttonsLayout;
    private TextView description;
    private View editStoreButton;
    private Button followStoreButton;
    private TextView followersCountTv;
    private TextView followingCountTv;
    private ImageView mainIcon;
    private TextView mainName;
    private ImageView secondaryIcon;
    private TextView secondaryName;
    private View separator;
    private LinearLayout socialChannelsLayout;
    private SpannableFactory spannableFactory;
    private StoreAccessor storeAccessor;
    private StoreCredentialsProviderImpl storeCredentialsProvider;
    private StoreUtilsProxy storeUtilsProxy;

    /* renamed from: cm.aptoide.pt.store.view.GridStoreMetaWidget$1 */
    static /* synthetic */ class C49521 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge */
        static final /* synthetic */ int[] f8603x2685ebd = new int[Badge.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(5458162854394133157L, "cm/aptoide/pt/store/view/GridStoreMetaWidget$1", 14);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f8603x2685ebd[Badge.NONE.ordinal()] = 1;
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
            f8603x2685ebd[Badge.TIN.ordinal()] = 2;
            $jacocoInit[3] = true;
            f8603x2685ebd[Badge.BRONZE.ordinal()] = 3;
            $jacocoInit[5] = true;
            f8603x2685ebd[Badge.SILVER.ordinal()] = 4;
            $jacocoInit[7] = true;
            f8603x2685ebd[Badge.GOLD.ordinal()] = 5;
            $jacocoInit[9] = true;
            f8603x2685ebd[Badge.PLATINUM.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta */
    public static class HomeMeta {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private final long appsCount;
        private final Badge badge;
        private final String description;
        private final long followersCount;
        private final long followingCount;
        private final boolean followingStore;
        private final String mainIcon;
        private final String mainName;
        private final boolean owner;
        private final String secondaryIcon;
        private final String secondaryName;
        private final boolean showApps;
        private final boolean showButton;
        private final List<SocialChannel> socialChannels;
        private final long storeId;
        private final StoreTheme storeTheme;
        private final int themeColor;

        /* renamed from: cm.aptoide.pt.store.view.GridStoreMetaWidget$HomeMeta$Badge */
        enum Badge {
            NONE,
            TIN,
            BRONZE,
            SILVER,
            GOLD,
            PLATINUM;

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
            boolean[] probes = Offline.getProbes(-7023924434863432573L, "cm/aptoide/pt/store/view/GridStoreMetaWidget$HomeMeta", 18);
            $jacocoData = probes;
            return probes;
        }

        public HomeMeta(String mainIcon2, String secondaryIcon2, String mainName2, String secondaryName2, boolean owner2, boolean showButton2, boolean followingStore2, List<SocialChannel> socialChannels2, long appsCount2, long followersCount2, long followingCount2, String description2, StoreTheme storeTheme2, int themeColor2, long storeId2, boolean showApps2, Badge badge2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.mainIcon = mainIcon2;
            this.secondaryIcon = secondaryIcon2;
            this.mainName = mainName2;
            this.secondaryName = secondaryName2;
            this.owner = owner2;
            this.showButton = showButton2;
            this.followingStore = followingStore2;
            this.socialChannels = socialChannels2;
            this.appsCount = appsCount2;
            this.followersCount = followersCount2;
            this.followingCount = followingCount2;
            this.description = description2;
            this.storeTheme = storeTheme2;
            this.themeColor = themeColor2;
            this.storeId = storeId2;
            this.showApps = showApps2;
            this.badge = badge2;
            $jacocoInit[0] = true;
        }

        public Badge getBadge() {
            boolean[] $jacocoInit = $jacocoInit();
            Badge badge2 = this.badge;
            $jacocoInit[1] = true;
            return badge2;
        }

        public boolean isFollowingStore() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.followingStore;
            $jacocoInit[2] = true;
            return z;
        }

        public boolean isShowButton() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.showButton;
            $jacocoInit[3] = true;
            return z;
        }

        public long getStoreId() {
            boolean[] $jacocoInit = $jacocoInit();
            long j = this.storeId;
            $jacocoInit[4] = true;
            return j;
        }

        public String getMainIcon() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.mainIcon;
            $jacocoInit[5] = true;
            return str;
        }

        public String getDescription() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.description;
            $jacocoInit[6] = true;
            return str;
        }

        public String getSecondaryIcon() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.secondaryIcon;
            $jacocoInit[7] = true;
            return str;
        }

        public String getMainName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.mainName;
            $jacocoInit[8] = true;
            return str;
        }

        public String getSecondaryName() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.secondaryName;
            $jacocoInit[9] = true;
            return str;
        }

        public boolean isOwner() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.owner;
            $jacocoInit[10] = true;
            return z;
        }

        public List<SocialChannel> getSocialChannels() {
            boolean[] $jacocoInit = $jacocoInit();
            List<SocialChannel> list = this.socialChannels;
            $jacocoInit[11] = true;
            return list;
        }

        public long getAppsCount() {
            boolean[] $jacocoInit = $jacocoInit();
            long j = this.appsCount;
            $jacocoInit[12] = true;
            return j;
        }

        public long getFollowersCount() {
            boolean[] $jacocoInit = $jacocoInit();
            long j = this.followersCount;
            $jacocoInit[13] = true;
            return j;
        }

        public long getFollowingCount() {
            boolean[] $jacocoInit = $jacocoInit();
            long j = this.followingCount;
            $jacocoInit[14] = true;
            return j;
        }

        public int getThemeColor() {
            boolean[] $jacocoInit = $jacocoInit();
            int i = this.themeColor;
            $jacocoInit[15] = true;
            return i;
        }

        public boolean isShowApps() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.showApps;
            $jacocoInit[16] = true;
            return z;
        }

        public StoreTheme getStoreTheme() {
            boolean[] $jacocoInit = $jacocoInit();
            StoreTheme storeTheme2 = this.storeTheme;
            $jacocoInit[17] = true;
            return storeTheme2;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4595043886485149821L, "cm/aptoide/pt/store/view/GridStoreMetaWidget", Opcodes.MULTIANEWARRAY);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((GridStoreMetaDisplayable) displayable, i);
        $jacocoInit[158] = true;
    }

    public GridStoreMetaWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.socialChannelsLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.social_channels);
        $jacocoInit[1] = true;
        this.mainIcon = (ImageView) itemView.findViewById(C1375R.C1376id.main_icon);
        $jacocoInit[2] = true;
        this.secondaryIcon = (ImageView) itemView.findViewById(C1375R.C1376id.secondary_icon);
        $jacocoInit[3] = true;
        this.mainName = (TextView) itemView.findViewById(C1375R.C1376id.main_name);
        $jacocoInit[4] = true;
        this.secondaryName = (TextView) itemView.findViewById(C1375R.C1376id.secondary_name);
        $jacocoInit[5] = true;
        this.description = (TextView) itemView.findViewById(C1375R.C1376id.description);
        $jacocoInit[6] = true;
        this.followStoreButton = (Button) itemView.findViewById(C1375R.C1376id.follow_store_button);
        $jacocoInit[7] = true;
        this.editStoreButton = itemView.findViewById(C1375R.C1376id.edit_store_button);
        $jacocoInit[8] = true;
        this.badgeIcon = (ImageView) itemView.findViewById(C1375R.C1376id.medal_icon);
        $jacocoInit[9] = true;
        this.appsCountTv = (TextView) itemView.findViewById(C1375R.C1376id.apps_text_view);
        $jacocoInit[10] = true;
        this.followingCountTv = (TextView) itemView.findViewById(C1375R.C1376id.following_text_view);
        $jacocoInit[11] = true;
        this.buttonsLayout = itemView.findViewById(C1375R.C1376id.action_button_layout);
        $jacocoInit[12] = true;
        this.followersCountTv = (TextView) itemView.findViewById(C1375R.C1376id.followers_text_view);
        $jacocoInit[13] = true;
        this.separator = itemView.findViewById(C1375R.C1376id.separator);
        $jacocoInit[14] = true;
    }

    public void bindView(GridStoreMetaDisplayable displayable, int position) {
        GridStoreMetaDisplayable gridStoreMetaDisplayable = displayable;
        boolean[] $jacocoInit = $jacocoInit();
        this.badgeDialogFactory = displayable.getBadgeDialogFactory();
        $jacocoInit[15] = true;
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        $jacocoInit[16] = true;
        BodyInterceptor<BaseBody> bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[17] = true;
        OkHttpClient httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[18] = true;
        $jacocoInit[19] = true;
        this.storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) getContext().getApplicationContext()).getDatabase(), Store.class);
        $jacocoInit[20] = true;
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl(this.storeAccessor);
        $jacocoInit[21] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[22] = true;
        $jacocoInit[23] = true;
        StoreAccessor storeAccessor2 = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class);
        $jacocoInit[24] = true;
        Factory defaultConverter = WebService.getDefaultConverter();
        $jacocoInit[25] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[26] = true;
        StoreUtilsProxy storeUtilsProxy2 = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentialsProviderImpl, storeAccessor2, httpClient, defaultConverter, tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        this.storeUtilsProxy = storeUtilsProxy2;
        $jacocoInit[27] = true;
        this.spannableFactory = new SpannableFactory();
        $jacocoInit[28] = true;
        this.storeCredentialsProvider = new StoreCredentialsProviderImpl(this.storeAccessor);
        $jacocoInit[29] = true;
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        $jacocoInit[30] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[31] = true;
        this.followersCountTv.setOnClickListener(new C4974V(this, gridStoreMetaDisplayable, resources, fragmentNavigator));
        $jacocoInit[32] = true;
        this.followingCountTv.setOnClickListener(new C4977Y(this, gridStoreMetaDisplayable, fragmentNavigator, resources));
        $jacocoInit[33] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S homeMeta = gridStoreMetaDisplayable.getHomeMeta(this.accountManager, getContext());
        $jacocoInit[34] = true;
        C0120S a = homeMeta.mo3616a(C14522a.m46170a());
        C4976X x = new C4976X(this, gridStoreMetaDisplayable);
        $jacocoInit[35] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) x);
        $jacocoInit[36] = true;
        C0137ja j = b.mo3670j();
        $jacocoInit[37] = true;
        cVar.mo3713a(j);
        $jacocoInit[38] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16534a(GridStoreMetaDisplayable displayable, Resources resources, FragmentNavigator fragmentNavigator, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        navigateToFollowersScreen(displayable, resources, fragmentNavigator);
        $jacocoInit[196] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16535a(GridStoreMetaDisplayable displayable, FragmentNavigator fragmentNavigator, Resources resources, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        navigateToFollowingScreen(displayable, fragmentNavigator, resources);
        $jacocoInit[195] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16536a(GridStoreMetaDisplayable displayable, HomeMeta homeMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[176] = true;
        ParcelableSpan[] parcelableSpanArr = {new StyleSpan(1), new ForegroundColorSpan(homeMeta.getThemeColor())};
        $jacocoInit[177] = true;
        ParcelableSpan[] textStyle = parcelableSpanArr;
        showMainIcon(homeMeta.getMainIcon());
        $jacocoInit[178] = true;
        showSecondaryIcon(homeMeta.getSecondaryIcon());
        $jacocoInit[179] = true;
        showMainName(homeMeta.getMainName());
        $jacocoInit[180] = true;
        showSecondaryName(homeMeta.getSecondaryName());
        $jacocoInit[181] = true;
        boolean isShowButton = homeMeta.isShowButton();
        boolean isOwner = homeMeta.isOwner();
        long storeId = homeMeta.getStoreId();
        $jacocoInit[182] = true;
        StoreTheme storeTheme = homeMeta.getStoreTheme();
        String mainName2 = homeMeta.getMainName();
        String description2 = homeMeta.getDescription();
        $jacocoInit[183] = true;
        String mainIcon2 = homeMeta.getMainIcon();
        boolean isFollowingStore = homeMeta.isFollowingStore();
        List socialChannels = homeMeta.getSocialChannels();
        $jacocoInit[184] = true;
        int requestCode = displayable.getRequestCode();
        $jacocoInit[185] = true;
        setupActionButton(isShowButton, isOwner, storeId, storeTheme, mainName2, description2, mainIcon2, isFollowingStore, socialChannels, requestCode);
        $jacocoInit[186] = true;
        showSocialChannels(homeMeta.getSocialChannels());
        $jacocoInit[187] = true;
        long appsCount = homeMeta.getAppsCount();
        boolean isShowApps = homeMeta.isShowApps();
        $jacocoInit[188] = true;
        long storeId2 = homeMeta.getStoreId();
        $jacocoInit[189] = true;
        showAppsCount(appsCount, textStyle, isShowApps, storeId2);
        $jacocoInit[190] = true;
        showFollowersCount(homeMeta.getFollowersCount(), textStyle);
        $jacocoInit[191] = true;
        showFollowingCount(homeMeta.getFollowingCount(), textStyle);
        $jacocoInit[192] = true;
        showDescription(homeMeta.getDescription());
        $jacocoInit[193] = true;
        showBadge(homeMeta.getBadge(), homeMeta.isOwner());
        $jacocoInit[194] = true;
    }

    private void showBadge(Badge badge, boolean storeOwner) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (C49521.f8603x2685ebd[badge.ordinal()]) {
            case 1:
                this.badgeIcon.setVisibility(8);
                $jacocoInit[40] = true;
                break;
            case 2:
                this.badgeIcon.setImageResource(C1375R.drawable.tin_medal_gradient);
                $jacocoInit[41] = true;
                this.badgeIcon.setVisibility(0);
                $jacocoInit[42] = true;
                break;
            case 3:
                this.badgeIcon.setImageResource(C1375R.drawable.bronze_medal_gradient);
                $jacocoInit[43] = true;
                this.badgeIcon.setVisibility(0);
                $jacocoInit[44] = true;
                break;
            case 4:
                this.badgeIcon.setImageResource(C1375R.drawable.silver_medal_gradient);
                $jacocoInit[45] = true;
                this.badgeIcon.setVisibility(0);
                $jacocoInit[46] = true;
                break;
            case 5:
                this.badgeIcon.setImageResource(C1375R.drawable.gold_medal_gradient);
                $jacocoInit[47] = true;
                this.badgeIcon.setVisibility(0);
                $jacocoInit[48] = true;
                break;
            case 6:
                this.badgeIcon.setImageResource(C1375R.drawable.platinum_medal_gradient);
                $jacocoInit[49] = true;
                this.badgeIcon.setVisibility(0);
                $jacocoInit[50] = true;
                break;
            default:
                $jacocoInit[39] = true;
                break;
        }
        this.badgeIcon.setOnClickListener(new C4983ba(this, badge, storeOwner));
        $jacocoInit[51] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16537a(Badge badge, boolean storeOwner, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        Dialog create = this.badgeDialogFactory.create(badge, storeOwner);
        $jacocoInit[174] = true;
        create.show();
        $jacocoInit[175] = true;
    }

    private void navigateToFollowingScreen(GridStoreMetaDisplayable displayable, FragmentNavigator fragmentNavigator, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[52] = true;
        Object[] objArr = {Long.valueOf(displayable.getFollowingsCount())};
        $jacocoInit[53] = true;
        String screenTitle = StringU.getFormattedString(C1375R.string.social_timeline_following_fragment_title, resources, objArr);
        $jacocoInit[54] = true;
        if (displayable.hasStore()) {
            $jacocoInit[55] = true;
            Long valueOf = Long.valueOf(displayable.getStoreId());
            $jacocoInit[56] = true;
            StoreTheme storeTheme = displayable.getStoreTheme();
            $jacocoInit[57] = true;
            String themeName = storeTheme.getThemeName();
            StoreContext storeContext = StoreContext.meta;
            $jacocoInit[58] = true;
            TimeLineFollowFragment newInstanceUsingStoreId = TimeLineFollowingFragment.newInstanceUsingStoreId(valueOf, themeName, screenTitle, storeContext);
            $jacocoInit[59] = true;
            fragmentNavigator.navigateTo(newInstanceUsingStoreId, true);
            $jacocoInit[60] = true;
        } else {
            $jacocoInit[61] = true;
            Long valueOf2 = Long.valueOf(displayable.getUserId());
            $jacocoInit[62] = true;
            StoreTheme storeTheme2 = displayable.getStoreTheme();
            $jacocoInit[63] = true;
            String themeName2 = storeTheme2.getThemeName();
            StoreContext storeContext2 = StoreContext.meta;
            $jacocoInit[64] = true;
            TimeLineFollowFragment newInstanceUsingUserId = TimeLineFollowingFragment.newInstanceUsingUserId(valueOf2, themeName2, screenTitle, storeContext2);
            $jacocoInit[65] = true;
            fragmentNavigator.navigateTo(newInstanceUsingUserId, true);
            $jacocoInit[66] = true;
        }
        $jacocoInit[67] = true;
    }

    private void navigateToFollowersScreen(GridStoreMetaDisplayable displayable, Resources resources, FragmentNavigator fragmentNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[68] = true;
        Object[] objArr = {Long.valueOf(displayable.getFollowersCount())};
        $jacocoInit[69] = true;
        String screenTitle = StringU.getFormattedString(C1375R.string.social_timeline_followers_fragment_title, resources, objArr);
        $jacocoInit[70] = true;
        if (displayable.hasStore()) {
            $jacocoInit[71] = true;
            Long valueOf = Long.valueOf(displayable.getStoreId());
            $jacocoInit[72] = true;
            StoreTheme storeTheme = displayable.getStoreTheme();
            $jacocoInit[73] = true;
            String themeName = storeTheme.getThemeName();
            StoreContext storeContext = StoreContext.meta;
            $jacocoInit[74] = true;
            TimeLineFollowFragment newInstanceUsingStore = TimeLineFollowersFragment.newInstanceUsingStore(valueOf, themeName, screenTitle, storeContext);
            $jacocoInit[75] = true;
            fragmentNavigator.navigateTo(newInstanceUsingStore, true);
            $jacocoInit[76] = true;
        } else {
            $jacocoInit[77] = true;
            Long valueOf2 = Long.valueOf(displayable.getUserId());
            $jacocoInit[78] = true;
            StoreTheme storeTheme2 = displayable.getStoreTheme();
            $jacocoInit[79] = true;
            String themeName2 = storeTheme2.getThemeName();
            StoreContext storeContext2 = StoreContext.meta;
            $jacocoInit[80] = true;
            TimeLineFollowFragment newInstanceUsingUser = TimeLineFollowersFragment.newInstanceUsingUser(valueOf2, themeName2, screenTitle, storeContext2);
            $jacocoInit[81] = true;
            fragmentNavigator.navigateTo(newInstanceUsingUser, true);
            $jacocoInit[82] = true;
        }
        $jacocoInit[83] = true;
    }

    private void showDescription(String descriptionText) {
        boolean[] $jacocoInit = $jacocoInit();
        if (descriptionText == null) {
            $jacocoInit[84] = true;
        } else if (descriptionText.isEmpty()) {
            $jacocoInit[85] = true;
        } else {
            $jacocoInit[86] = true;
            this.description.setText(descriptionText);
            $jacocoInit[87] = true;
            this.description.setVisibility(0);
            $jacocoInit[88] = true;
            $jacocoInit[90] = true;
        }
        this.description.setVisibility(8);
        $jacocoInit[89] = true;
        $jacocoInit[90] = true;
    }

    private void showFollowingCount(long followingCount, ParcelableSpan[] textStyle) {
        boolean[] $jacocoInit = $jacocoInit();
        String countText = StringU.withSuffix(followingCount);
        $jacocoInit[91] = true;
        String followingText = String.format(getContext().getString(C1375R.string.storehometab_short_following), new Object[]{countText});
        $jacocoInit[92] = true;
        this.followingCountTv.setText(this.spannableFactory.createMultiSpan(followingText, textStyle, countText));
        $jacocoInit[93] = true;
    }

    private void showFollowersCount(long followersCount, ParcelableSpan[] textStyle) {
        boolean[] $jacocoInit = $jacocoInit();
        String count = StringU.withSuffix(followersCount);
        $jacocoInit[94] = true;
        String followingText = String.format(getContext().getString(C1375R.string.storehometab_short_subscribers), new Object[]{count});
        $jacocoInit[95] = true;
        this.followersCountTv.setText(this.spannableFactory.createMultiSpan(followingText, textStyle, count));
        $jacocoInit[96] = true;
    }

    private void showAppsCount(long appsCount, ParcelableSpan[] textStyle, boolean showApps, long storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (showApps) {
            $jacocoInit[97] = true;
            this.appsCountTv.setVisibility(0);
            $jacocoInit[98] = true;
            String count = StringU.withSuffix(appsCount);
            $jacocoInit[99] = true;
            String followingText = String.format(getContext().getString(C1375R.string.storehometab_short_apps), new Object[]{count});
            $jacocoInit[100] = true;
            this.appsCountTv.setText(this.spannableFactory.createMultiSpan(followingText, textStyle, count));
            $jacocoInit[101] = true;
            this.appsCountTv.setOnClickListener(new C4975W(this, storeName));
            $jacocoInit[102] = true;
        } else {
            this.appsCountTv.setVisibility(8);
            $jacocoInit[103] = true;
        }
        $jacocoInit[104] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16531a(long storeName, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        navigateToAppsListScreen(storeName);
        $jacocoInit[173] = true;
    }

    private void navigateToAppsListScreen(long storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        getFragmentNavigator().navigateTo(ListStoreAppsFragment.newInstance(storeName), true);
        $jacocoInit[105] = true;
    }

    private void showSocialChannels(List<SocialChannel> socialChannels) {
        boolean[] $jacocoInit = $jacocoInit();
        if (socialChannels == null) {
            $jacocoInit[106] = true;
        } else if (socialChannels.isEmpty()) {
            $jacocoInit[107] = true;
        } else {
            $jacocoInit[108] = true;
            setupSocialLinks(socialChannels, this.socialChannelsLayout);
            $jacocoInit[109] = true;
            this.socialChannelsLayout.setVisibility(0);
            $jacocoInit[110] = true;
            this.separator.setVisibility(8);
            $jacocoInit[111] = true;
            $jacocoInit[114] = true;
        }
        this.socialChannelsLayout.setVisibility(8);
        $jacocoInit[112] = true;
        this.separator.setVisibility(0);
        $jacocoInit[113] = true;
        $jacocoInit[114] = true;
    }

    private void setupActionButton(boolean shouldShow, boolean owner, long storeId, StoreTheme storeTheme, String storeName, String storeDescription, String storeImagePath, boolean isFollowed, List<SocialChannel> socialChannels, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        if (shouldShow) {
            $jacocoInit[115] = true;
            this.buttonsLayout.setVisibility(0);
            if (owner) {
                $jacocoInit[116] = true;
                setupEditButton(storeId, storeTheme, storeName, storeDescription, storeImagePath, socialChannels, requestCode);
                $jacocoInit[117] = true;
                StoreTheme storeTheme2 = storeTheme;
                String str = storeName;
                boolean z = isFollowed;
            } else {
                setupFollowButton(storeName, isFollowed, storeTheme);
                $jacocoInit[118] = true;
            }
        } else {
            StoreTheme storeTheme3 = storeTheme;
            String str2 = storeName;
            boolean z2 = isFollowed;
            this.buttonsLayout.setVisibility(8);
            $jacocoInit[119] = true;
        }
        $jacocoInit[120] = true;
    }

    private void setupFollowButton(String storeName, boolean isFollowed, StoreTheme theme) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editStoreButton.setVisibility(8);
        $jacocoInit[121] = true;
        this.followStoreButton.setVisibility(0);
        $jacocoInit[122] = true;
        Button button = this.followStoreButton;
        Resources resources = getContext().getResources();
        $jacocoInit[123] = true;
        Drawable drawable = resources.getDrawable(theme.getRaisedButtonDrawable());
        $jacocoInit[124] = true;
        button.setBackgroundDrawable(drawable);
        if (isFollowed) {
            $jacocoInit[125] = true;
            setupUnfollowButton(storeName);
            $jacocoInit[126] = true;
        } else {
            setupFollowButton(storeName);
            $jacocoInit[127] = true;
        }
        $jacocoInit[128] = true;
    }

    private void setupUnfollowButton(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followStoreButton.setOnClickListener(new C4987da(this, storeName));
        $jacocoInit[129] = true;
        this.followStoreButton.setText(C1375R.string.unfollow);
        $jacocoInit[130] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16540b(String storeName, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeUtilsProxy.unSubscribeStore(storeName, this.storeCredentialsProvider);
        $jacocoInit[172] = true;
    }

    private void setupFollowButton(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.followStoreButton.setText(C1375R.string.follow);
        $jacocoInit[131] = true;
        this.followStoreButton.setOnClickListener(new C4985ca(this, storeName));
        $jacocoInit[132] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16538a(String storeName, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S subscribeStoreObservable = this.storeUtilsProxy.subscribeStoreObservable(storeName);
        $jacocoInit[160] = true;
        C0120S a = subscribeStoreObservable.mo3616a(C14522a.m46170a());
        C4972T t = new C4972T(this);
        $jacocoInit[161] = true;
        C0120S b = a.mo3635b((C0128a) t);
        C4973U u = new C4973U(this);
        C4980aa aaVar = new C4980aa(this);
        $jacocoInit[162] = true;
        b.mo3626a((C0129b<? super T>) u, (C0129b<Throwable>) aaVar);
        $jacocoInit[163] = true;
    }

    /* renamed from: h */
    public /* synthetic */ void mo16542h() {
        boolean[] $jacocoInit = $jacocoInit();
        this.followStoreButton.setText(C1375R.string.unfollow);
        $jacocoInit[170] = true;
        this.followStoreButton.setEnabled(false);
        $jacocoInit[171] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16533a(GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        if (getStoreMeta.isOk()) {
            $jacocoInit[165] = true;
            this.followStoreButton.setText(C1375R.string.unfollow);
            $jacocoInit[166] = true;
            this.followStoreButton.setEnabled(true);
            $jacocoInit[167] = true;
        } else {
            showFollowStoreError();
            $jacocoInit[168] = true;
        }
        $jacocoInit[169] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16539a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        showFollowStoreError();
        $jacocoInit[164] = true;
    }

    private void showFollowStoreError() {
        boolean[] $jacocoInit = $jacocoInit();
        this.followStoreButton.setText(C1375R.string.follow);
        $jacocoInit[133] = true;
        this.followStoreButton.setEnabled(true);
        $jacocoInit[134] = true;
        Snackbar a = Snackbar.m1623a(this.itemView, (int) C1375R.string.storetab_short_follow_error, 0);
        $jacocoInit[135] = true;
        a.mo4690h();
        $jacocoInit[136] = true;
    }

    private void setupEditButton(long storeId, StoreTheme storeThemeName, String storeName, String storeDescription, String storeImagePath, List<SocialChannel> socialChannels, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        this.editStoreButton.setVisibility(0);
        $jacocoInit[137] = true;
        this.followStoreButton.setVisibility(8);
        $jacocoInit[138] = true;
        View view = this.editStoreButton;
        C4978Z z = new C4978Z(this, storeId, storeThemeName, storeName, storeDescription, storeImagePath, socialChannels, requestCode);
        view.setOnClickListener(z);
        $jacocoInit[139] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16532a(long storeId, StoreTheme storeThemeName, String storeName, String storeDescription, String storeImagePath, List socialChannels, int requestCode, View v) {
        boolean[] $jacocoInit = $jacocoInit();
        navigateToEditStore(storeId, storeThemeName, storeName, storeDescription, storeImagePath, socialChannels, requestCode);
        $jacocoInit[159] = true;
    }

    private void navigateToEditStore(long storeId, StoreTheme storeTheme, String storeName, String storeDescription, String storeImagePath, List<SocialChannel> socialChannels, int requestCode) {
        boolean[] $jacocoInit = $jacocoInit();
        ManageStoreViewModel manageStoreViewModel = new ManageStoreViewModel(storeId, storeTheme, storeName, storeDescription, storeImagePath, socialChannels);
        $jacocoInit[140] = true;
        getFragmentNavigator().navigateForResult(ManageStoreFragment.newInstance(manageStoreViewModel, false), requestCode, true);
        $jacocoInit[141] = true;
    }

    private void showSecondaryName(String secondaryNameString) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = this.secondaryName;
        if (textView == null) {
            $jacocoInit[142] = true;
        } else {
            $jacocoInit[143] = true;
            textView.setText(secondaryNameString);
            $jacocoInit[144] = true;
        }
        $jacocoInit[145] = true;
    }

    private void showMainName(String mainNameString) {
        boolean[] $jacocoInit = $jacocoInit();
        if (mainNameString == null) {
            $jacocoInit[146] = true;
        } else {
            $jacocoInit[147] = true;
            this.mainName.setText(mainNameString);
            $jacocoInit[148] = true;
        }
        $jacocoInit[149] = true;
    }

    private void showMainIcon(String mainIconUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(getContext());
        ImageView imageView = this.mainIcon;
        $jacocoInit[150] = true;
        with.loadWithShadowCircleTransform(mainIconUrl, imageView);
        $jacocoInit[151] = true;
    }

    private void showSecondaryIcon(String secondaryIconUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (secondaryIconUrl != null) {
            $jacocoInit[152] = true;
            ImageLoader with = ImageLoader.with(getContext());
            ImageView imageView = this.secondaryIcon;
            $jacocoInit[153] = true;
            with.loadWithShadowCircleTransform(secondaryIconUrl, imageView);
            $jacocoInit[154] = true;
            this.secondaryIcon.setVisibility(0);
            $jacocoInit[155] = true;
        } else {
            this.secondaryIcon.setVisibility(8);
            $jacocoInit[156] = true;
        }
        $jacocoInit[157] = true;
    }
}
