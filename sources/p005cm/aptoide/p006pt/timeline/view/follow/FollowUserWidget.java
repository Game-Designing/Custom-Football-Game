package p005cm.aptoide.p006pt.timeline.view.follow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.Snackbar;
import android.support.p000v4.app.C0014p;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowUserDisplayable;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.timeline.view.follow.FollowUserWidget */
public class FollowUserWidget extends Widget<FollowUserDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager accountManager;
    private Button follow;
    private LinearLayout followLayout;
    private LinearLayout followNumbers;
    private TextView followedTv;
    private TextView followersNumber;
    private TextView followingNumber;
    private TextView followingTv;
    private ImageView mainIcon;
    private ImageView secondaryIcon;
    private View separatorView;
    private TextView storeNameTv;
    private TextView userNameTv;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1028706010528891895L, "cm/aptoide/pt/timeline/view/follow/FollowUserWidget", Opcodes.LOR);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((FollowUserDisplayable) displayable, i);
        $jacocoInit[100] = true;
    }

    public FollowUserWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.userNameTv = (TextView) itemView.findViewById(C1375R.C1376id.user_name);
        $jacocoInit[1] = true;
        this.storeNameTv = (TextView) itemView.findViewById(C1375R.C1376id.store_name);
        $jacocoInit[2] = true;
        this.followingNumber = (TextView) itemView.findViewById(C1375R.C1376id.following_number);
        $jacocoInit[3] = true;
        this.followersNumber = (TextView) itemView.findViewById(C1375R.C1376id.followers_number);
        $jacocoInit[4] = true;
        this.followingTv = (TextView) itemView.findViewById(C1375R.C1376id.following_tv);
        $jacocoInit[5] = true;
        this.followedTv = (TextView) itemView.findViewById(C1375R.C1376id.followers_tv);
        $jacocoInit[6] = true;
        this.mainIcon = (ImageView) itemView.findViewById(C1375R.C1376id.main_icon);
        $jacocoInit[7] = true;
        this.secondaryIcon = (ImageView) itemView.findViewById(C1375R.C1376id.secondary_icon);
        $jacocoInit[8] = true;
        this.follow = (Button) itemView.findViewById(C1375R.C1376id.follow_btn);
        $jacocoInit[9] = true;
        this.followNumbers = (LinearLayout) itemView.findViewById(C1375R.C1376id.followers_following_numbers);
        $jacocoInit[10] = true;
        this.followLayout = (LinearLayout) itemView.findViewById(C1375R.C1376id.follow_store_layout);
        $jacocoInit[11] = true;
        this.separatorView = itemView.findViewById(C1375R.C1376id.separator_vertical);
        $jacocoInit[12] = true;
    }

    public void bindView(FollowUserDisplayable displayable, int position) {
        int i;
        int i2;
        FollowUserDisplayable followUserDisplayable = displayable;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[13] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[14] = true;
        this.accountManager = application.getAccountManager();
        $jacocoInit[15] = true;
        BodyInterceptor<BaseBody> bodyInterceptor = application.getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[16] = true;
        OkHttpClient httpClient = application.getDefaultClient();
        $jacocoInit[17] = true;
        if (!displayable.isLike()) {
            $jacocoInit[18] = true;
            this.followLayout.setVisibility(8);
            $jacocoInit[19] = true;
            this.followNumbers.setVisibility(0);
            $jacocoInit[20] = true;
            this.separatorView.setVisibility(0);
            $jacocoInit[21] = true;
            this.followingNumber.setText(displayable.getFollowing());
            $jacocoInit[22] = true;
            this.followersNumber.setText(displayable.getFollowers());
            $jacocoInit[23] = true;
        } else {
            this.followNumbers.setVisibility(8);
            $jacocoInit[24] = true;
            this.separatorView.setVisibility(4);
            $jacocoInit[25] = true;
            if (!displayable.hasStore()) {
                $jacocoInit[26] = true;
            } else {
                $jacocoInit[27] = true;
                this.followLayout.setVisibility(0);
                $jacocoInit[28] = true;
                setFollowColor(displayable);
                $jacocoInit[29] = true;
            }
            String storeName = displayable.getStoreName();
            AptoideAccountManager aptoideAccountManager = this.accountManager;
            $jacocoInit[30] = true;
            Context applicationContext = getContext().getApplicationContext();
            $jacocoInit[31] = true;
            $jacocoInit[32] = true;
            StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
            $jacocoInit[33] = true;
            Context applicationContext2 = getContext().getApplicationContext();
            $jacocoInit[34] = true;
            $jacocoInit[35] = true;
            StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class);
            $jacocoInit[36] = true;
            Factory defaultConverter = WebService.getDefaultConverter();
            TokenInvalidator tokenInvalidator = application.getTokenInvalidator();
            $jacocoInit[37] = true;
            String storeName2 = storeName;
            StoreUtilsProxy storeUtilsProxy = new StoreUtilsProxy(aptoideAccountManager, bodyInterceptor, storeCredentialsProviderImpl, storeAccessor, httpClient, defaultConverter, tokenInvalidator, application.getDefaultSharedPreferences());
            $jacocoInit[38] = true;
            StoreRepository storeRepository = RepositoryFactory.getStoreRepository(getContext().getApplicationContext());
            $jacocoInit[39] = true;
            C0136c cVar = this.compositeSubscription;
            C0120S a = C13034a.m42490a(this.follow);
            String storeName3 = storeName2;
            C5119f fVar = new C5119f(storeRepository, storeName3);
            $jacocoInit[40] = true;
            C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) fVar);
            $jacocoInit[41] = true;
            C0120S a2 = f.mo3616a(C14522a.m46170a());
            C5121h hVar = new C5121h(this, storeName3, storeUtilsProxy);
            C5117d dVar = C5117d.f8842a;
            $jacocoInit[42] = true;
            C0137ja a3 = a2.mo3626a((C0129b<? super T>) hVar, (C0129b<Throwable>) dVar);
            $jacocoInit[43] = true;
            cVar.mo3713a(a3);
            $jacocoInit[44] = true;
            C0136c cVar2 = this.compositeSubscription;
            C0120S isSubscribed = storeRepository.isSubscribed(displayable.getStoreName());
            $jacocoInit[45] = true;
            C0120S a4 = isSubscribed.mo3616a(C14522a.m46170a());
            C5115b bVar = new C5115b(this);
            C5118e eVar = C5118e.f8843a;
            $jacocoInit[46] = true;
            C0137ja a5 = a4.mo3626a((C0129b<? super T>) bVar, (C0129b<Throwable>) eVar);
            $jacocoInit[47] = true;
            cVar2.mo3713a(a5);
            $jacocoInit[48] = true;
        }
        C0014p context = getContext();
        $jacocoInit[49] = true;
        if (displayable.hasStoreAndUser()) {
            $jacocoInit[50] = true;
            ImageLoader with = ImageLoader.with(context);
            $jacocoInit[51] = true;
            with.loadUsingCircleTransform(displayable.getStoreAvatar(), this.mainIcon);
            $jacocoInit[52] = true;
            ImageLoader with2 = ImageLoader.with(context);
            $jacocoInit[53] = true;
            with2.loadUsingCircleTransform(displayable.getUserAvatar(), this.secondaryIcon);
            $jacocoInit[54] = true;
            i2 = 0;
            this.mainIcon.setVisibility(0);
            $jacocoInit[55] = true;
            this.secondaryIcon.setVisibility(0);
            $jacocoInit[56] = true;
            i = 8;
        } else {
            i2 = 0;
            if (displayable.hasUser()) {
                $jacocoInit[57] = true;
                ImageLoader with3 = ImageLoader.with(context);
                $jacocoInit[58] = true;
                with3.loadUsingCircleTransform(displayable.getUserAvatar(), this.mainIcon);
                $jacocoInit[59] = true;
                i = 8;
                this.secondaryIcon.setVisibility(8);
                $jacocoInit[60] = true;
            } else {
                i = 8;
                if (displayable.hasStore()) {
                    $jacocoInit[61] = true;
                    ImageLoader with4 = ImageLoader.with(context);
                    $jacocoInit[62] = true;
                    with4.loadUsingCircleTransform(displayable.getStoreAvatar(), this.mainIcon);
                    $jacocoInit[63] = true;
                    this.secondaryIcon.setVisibility(8);
                    $jacocoInit[64] = true;
                } else {
                    this.mainIcon.setVisibility(8);
                    $jacocoInit[65] = true;
                    this.secondaryIcon.setVisibility(8);
                    $jacocoInit[66] = true;
                }
            }
        }
        if (displayable.hasUser()) {
            $jacocoInit[67] = true;
            this.userNameTv.setText(displayable.getUserName());
            $jacocoInit[68] = true;
            this.userNameTv.setVisibility(i2);
            $jacocoInit[69] = true;
        } else {
            this.userNameTv.setVisibility(i);
            $jacocoInit[70] = true;
        }
        if (displayable.hasStore()) {
            $jacocoInit[71] = true;
            int storeColor = followUserDisplayable.getStoreColor(getContext().getApplicationContext());
            $jacocoInit[72] = true;
            String storeName4 = displayable.storeName();
            $jacocoInit[73] = true;
            setupStoreNameTv(storeColor, storeName4);
            $jacocoInit[74] = true;
        } else {
            this.storeNameTv.setVisibility(i);
            $jacocoInit[75] = true;
        }
        this.followedTv.setTextColor(followUserDisplayable.getStoreColor(getContext().getApplicationContext()));
        $jacocoInit[76] = true;
        this.followingTv.setTextColor(followUserDisplayable.getStoreColor(getContext().getApplicationContext()));
        $jacocoInit[77] = true;
        C0136c cVar3 = this.compositeSubscription;
        C0120S a6 = C13034a.m42490a(this.itemView);
        C5120g gVar = new C5120g(this, followUserDisplayable);
        C5116c cVar4 = C5116c.f8841a;
        $jacocoInit[78] = true;
        C0137ja a7 = a6.mo3626a((C0129b<? super T>) gVar, (C0129b<Throwable>) cVar4);
        $jacocoInit[79] = true;
        cVar3.mo3713a(a7);
        $jacocoInit[80] = true;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9423a(StoreRepository storeRepository, String storeName, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isSubscribed = storeRepository.isSubscribed(storeName);
        $jacocoInit[127] = true;
        C0120S d = isSubscribed.mo3647d();
        $jacocoInit[128] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16772a(String storeName, StoreUtilsProxy storeUtilsProxy, Boolean isSubscribed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isSubscribed.booleanValue()) {
            $jacocoInit[112] = true;
            this.follow.setVisibility(0);
            $jacocoInit[113] = true;
            this.follow.setText(C1375R.string.follow);
            View view = this.itemView;
            $jacocoInit[114] = true;
            Resources resources = getContext().getResources();
            Object[] objArr = {storeName};
            $jacocoInit[115] = true;
            String formattedString = StringU.getFormattedString(C1375R.string.unfollowing_store_message, resources, objArr);
            $jacocoInit[116] = true;
            Snackbar a = Snackbar.m1624a(view, (CharSequence) formattedString, -1);
            $jacocoInit[117] = true;
            a.mo4690h();
            $jacocoInit[118] = true;
            storeUtilsProxy.unSubscribeStore(storeName);
            $jacocoInit[119] = true;
        } else {
            this.follow.setVisibility(4);
            View view2 = this.itemView;
            $jacocoInit[120] = true;
            Resources resources2 = getContext().getResources();
            Object[] objArr2 = {storeName};
            $jacocoInit[121] = true;
            String formattedString2 = StringU.getFormattedString(C1375R.string.store_followed, resources2, objArr2);
            $jacocoInit[122] = true;
            Snackbar a2 = Snackbar.m1624a(view2, (CharSequence) formattedString2, -1);
            $jacocoInit[123] = true;
            a2.mo4690h();
            $jacocoInit[124] = true;
            storeUtilsProxy.subscribeStore(storeName);
            $jacocoInit[125] = true;
        }
        $jacocoInit[126] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9424a(Throwable e) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[110] = true;
        instance.log(e);
        $jacocoInit[111] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16771a(Boolean isSubscribed) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isSubscribed.booleanValue()) {
            $jacocoInit[105] = true;
            this.follow.setVisibility(4);
            $jacocoInit[106] = true;
        } else {
            this.follow.setVisibility(0);
            $jacocoInit[107] = true;
            this.follow.setText(C1375R.string.follow);
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9425b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        throwable.printStackTrace();
        $jacocoInit[104] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16770a(FollowUserDisplayable displayable, Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        displayable.viewClicked(getFragmentNavigator());
        $jacocoInit[103] = true;
    }

    /* renamed from: c */
    static /* synthetic */ void m9426c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[101] = true;
        instance.log(err);
        $jacocoInit[102] = true;
    }

    private void setFollowColor(FollowUserDisplayable displayable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 16) {
            Button button = this.follow;
            $jacocoInit[81] = true;
            Drawable buttonBackgroundStoreThemeColor = displayable.getButtonBackgroundStoreThemeColor(getContext().getApplicationContext());
            $jacocoInit[82] = true;
            button.setBackground(buttonBackgroundStoreThemeColor);
            $jacocoInit[83] = true;
        } else {
            Button button2 = this.follow;
            $jacocoInit[84] = true;
            Drawable buttonBackgroundStoreThemeColor2 = displayable.getButtonBackgroundStoreThemeColor(getContext().getApplicationContext());
            $jacocoInit[85] = true;
            button2.setBackgroundDrawable(buttonBackgroundStoreThemeColor2);
            $jacocoInit[86] = true;
        }
        this.follow.setTextColor(displayable.getStoreColor(getContext().getApplicationContext()));
        $jacocoInit[87] = true;
    }

    private void setupStoreNameTv(int storeColor, String storeName) {
        Drawable drawable;
        boolean[] $jacocoInit = $jacocoInit();
        this.storeNameTv.setText(storeName);
        $jacocoInit[88] = true;
        this.storeNameTv.setTextColor(storeColor);
        $jacocoInit[89] = true;
        this.storeNameTv.setVisibility(0);
        if (VERSION.SDK_INT >= 21) {
            $jacocoInit[90] = true;
            Resources resources = getContext().getResources();
            $jacocoInit[91] = true;
            drawable = resources.getDrawable(C1375R.drawable.ic_store, null);
            $jacocoInit[92] = true;
        } else {
            Resources resources2 = getContext().getResources();
            $jacocoInit[93] = true;
            drawable = resources2.getDrawable(C1375R.drawable.ic_store);
            $jacocoInit[94] = true;
        }
        drawable.setBounds(0, 0, 30, 30);
        $jacocoInit[95] = true;
        drawable.mutate();
        $jacocoInit[96] = true;
        drawable.setColorFilter(storeColor, Mode.SRC_IN);
        $jacocoInit[97] = true;
        this.storeNameTv.setCompoundDrawablePadding(5);
        $jacocoInit[98] = true;
        this.storeNameTv.setCompoundDrawables(drawable, null, null, null);
        $jacocoInit[99] = true;
    }
}
