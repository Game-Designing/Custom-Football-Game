package p005cm.aptoide.p006pt.account.view.store;

import android.net.Uri;
import java.util.List;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.AccountAnalytics;
import p005cm.aptoide.p006pt.account.AccountAnalytics.CreateStoreAction;
import p005cm.aptoide.p006pt.account.view.UriToPathResolver;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException.ImageError;
import p005cm.aptoide.p006pt.account.view.exception.SocialLinkException;
import p005cm.aptoide.p006pt.account.view.exception.StoreCreationException;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.StoreLinks;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Type;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStorePresenter */
public class ManageStorePresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AccountAnalytics accountAnalytics;
    private final AptoideAccountManager accountManager;
    private final String applicationPackageName;
    private final CrashReport crashReport;
    private final ManageStoreErrorMapper errorMapper;
    private final boolean goBackToHome;
    private final ManageStoreNavigator navigator;
    private final int requestCode;
    private final UriToPathResolver uriToPathResolver;
    private final ManageStoreView view;

    /* renamed from: cm.aptoide.pt.account.view.store.ManageStorePresenter$1 */
    static /* synthetic */ class C15251 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$BaseV7Response$Type */
        static final /* synthetic */ int[] f4464xf2be586a = new int[Type.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(7163774672234230278L, "cm/aptoide/pt/account/view/store/ManageStorePresenter$1", 18);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f4464xf2be586a[Type.FACEBOOK_1.ordinal()] = 1;
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
                                    try {
                                        $jacocoInit[12] = true;
                                    } catch (NoSuchFieldError e7) {
                                        try {
                                            $jacocoInit[14] = true;
                                        } catch (NoSuchFieldError e8) {
                                            $jacocoInit[16] = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            f4464xf2be586a[Type.FACEBOOK_2.ordinal()] = 2;
            $jacocoInit[3] = true;
            f4464xf2be586a[Type.TWITTER_1.ordinal()] = 3;
            $jacocoInit[5] = true;
            f4464xf2be586a[Type.TWITTER_2.ordinal()] = 4;
            $jacocoInit[7] = true;
            f4464xf2be586a[Type.TWITCH_1.ordinal()] = 5;
            $jacocoInit[9] = true;
            f4464xf2be586a[Type.TWITCH_2.ordinal()] = 6;
            $jacocoInit[11] = true;
            f4464xf2be586a[Type.YOUTUBE_1.ordinal()] = 7;
            $jacocoInit[13] = true;
            f4464xf2be586a[Type.YOUTUBE_2.ordinal()] = 8;
            $jacocoInit[15] = true;
            $jacocoInit[17] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1435434574924814945L, "cm/aptoide/pt/account/view/store/ManageStorePresenter", Opcodes.ISHL);
        $jacocoData = probes;
        return probes;
    }

    public ManageStorePresenter(ManageStoreView view2, CrashReport crashReport2, UriToPathResolver uriToPathResolver2, String applicationPackageName2, ManageStoreNavigator navigator2, boolean goBackToHome2, ManageStoreErrorMapper errorMapper2, AptoideAccountManager accountManager2, int requestCode2, AccountAnalytics accountAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.crashReport = crashReport2;
        this.uriToPathResolver = uriToPathResolver2;
        this.applicationPackageName = applicationPackageName2;
        this.navigator = navigator2;
        this.goBackToHome = goBackToHome2;
        this.errorMapper = errorMapper2;
        this.accountManager = accountManager2;
        this.requestCode = requestCode2;
        this.accountAnalytics = accountAnalytics2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handleSaveData();
        $jacocoInit[1] = true;
        handleCancel();
        $jacocoInit[2] = true;
    }

    private void handleCancel() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1510A a = C1510A.f4433a;
        $jacocoInit[3] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) a);
        C1549w wVar = new C1549w(this);
        $jacocoInit[4] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wVar);
        ManageStoreView manageStoreView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[5] = true;
        C0120S a2 = f.mo3614a((C0121c<? super T, ? extends R>) manageStoreView.bindUntilEvent(lifecycleEvent2));
        C1516G g = C1516G.f4440a;
        C1513D d2 = new C1513D(this);
        $jacocoInit[6] = true;
        a2.mo3626a((C0129b<? super T>) g, (C0129b<Throwable>) d2);
        $jacocoInit[7] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6297a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[117] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[118] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[119] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9820b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S cancelClick = this.view.cancelClick();
        C1551y yVar = new C1551y(this);
        $jacocoInit[111] = true;
        C0120S b = cancelClick.mo3636b((C0129b<? super T>) yVar);
        $jacocoInit[112] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9824c(ManageStoreViewModel storeModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.goBackToHome) {
            $jacocoInit[113] = true;
        } else {
            $jacocoInit[114] = true;
            this.accountAnalytics.createStore(storeModel.hasPicture(), CreateStoreAction.SKIP);
            $jacocoInit[115] = true;
        }
        navigate(false);
        $jacocoInit[116] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6298a(ManageStoreViewModel __) {
        $jacocoInit()[110] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9818a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[109] = true;
    }

    private void handleSaveData() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1542p pVar = C1542p.f4480a;
        $jacocoInit[8] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) pVar);
        C1552z zVar = new C1552z(this);
        $jacocoInit[9] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) zVar);
        ManageStoreView manageStoreView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[10] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) manageStoreView.bindUntilEvent(lifecycleEvent2));
        $jacocoInit[11] = true;
        a.mo3670j();
        $jacocoInit[12] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6299c(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[106] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[107] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[108] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo9827d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S saveDataClick = this.view.saveDataClick();
        C1543q qVar = new C1543q(this);
        $jacocoInit[100] = true;
        C0120S g = saveDataClick.mo3663g((C0132p<? super T, ? extends C0117M>) qVar);
        C1514E e = new C1514E(this);
        $jacocoInit[101] = true;
        C0120S a = g.mo3621a((C0129b<? super Throwable>) e);
        $jacocoInit[102] = true;
        C0120S g2 = a.mo3662g();
        $jacocoInit[103] = true;
        return g2;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo9826d(ManageStoreViewModel storeModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M handleSaveClick = handleSaveClick(storeModel);
        $jacocoInit[105] = true;
        return handleSaveClick;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9829d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[104] = true;
    }

    private C0117M handleSaveClick(ManageStoreViewModel storeModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1511B(this));
        $jacocoInit[13] = true;
        C0117M a = c.mo3581a(Schedulers.m776io());
        $jacocoInit[14] = true;
        C0117M a2 = a.mo3580a(saveData(storeModel));
        $jacocoInit[15] = true;
        C0117M a3 = a2.mo3581a(C14522a.m46170a());
        C1515F f = new C1515F(this, storeModel);
        $jacocoInit[16] = true;
        C0117M a4 = a3.mo3582a((C0128a) f);
        C1547u uVar = new C1547u(this);
        $jacocoInit[17] = true;
        C0117M a5 = a4.mo3582a((C0128a) uVar);
        C1548v vVar = new C1548v(this);
        $jacocoInit[18] = true;
        C0117M a6 = a5.mo3582a((C0128a) vVar);
        C1512C c2 = new C1512C(this);
        $jacocoInit[19] = true;
        C0117M a7 = a6.mo3582a((C0128a) c2);
        C1544r rVar = new C1544r(this);
        $jacocoInit[20] = true;
        C0117M b = a7.mo3596b((C0132p<? super Throwable, ? extends C0117M>) rVar);
        $jacocoInit[21] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9828d() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showWaitProgressBar();
        $jacocoInit[99] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9822b(ManageStoreViewModel storeModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.goBackToHome) {
            $jacocoInit[95] = true;
        } else {
            $jacocoInit[96] = true;
            this.accountAnalytics.createStore(storeModel.hasPicture(), CreateStoreAction.CREATE);
            $jacocoInit[97] = true;
        }
        $jacocoInit[98] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9817a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissWaitProgressBar();
        $jacocoInit[94] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9821b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showSuccessMessage();
        $jacocoInit[93] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9823c() {
        boolean[] $jacocoInit = $jacocoInit();
        navigate(true);
        $jacocoInit[92] = true;
    }

    /* renamed from: b */
    public /* synthetic */ C0117M mo9819b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C1546t(this, err));
        $jacocoInit[89] = true;
        return c;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9825c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissWaitProgressBar();
        $jacocoInit[90] = true;
        handleStoreCreationErrors(err);
        $jacocoInit[91] = true;
    }

    private C0117M saveData(ManageStoreViewModel storeModel) {
        boolean[] $jacocoInit = $jacocoInit();
        Single b = Single.m742b((Callable<? extends T>) new C1550x<Object>(this, storeModel));
        C1545s sVar = new C1545s(this, storeModel);
        $jacocoInit[22] = true;
        C0117M b2 = b.mo3693b((C0132p<? super T, ? extends C0117M>) sVar);
        $jacocoInit[23] = true;
        return b2;
    }

    /* renamed from: e */
    public /* synthetic */ String mo9830e(ManageStoreViewModel storeModel) throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        if (storeModel.hasNewAvatar()) {
            $jacocoInit[86] = true;
            String mediaStoragePath = this.uriToPathResolver.getMediaStoragePath(Uri.parse(storeModel.getPictureUri()));
            $jacocoInit[87] = true;
            return mediaStoragePath;
        }
        $jacocoInit[88] = true;
        return "";
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9816a(ManageStoreViewModel storeModel, String mediaStoragePath) {
        boolean[] $jacocoInit = $jacocoInit();
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        String storeName = storeModel.getStoreName();
        $jacocoInit[80] = true;
        String storeDescription = storeModel.getStoreDescription();
        boolean hasNewAvatar = storeModel.hasNewAvatar();
        $jacocoInit[81] = true;
        StoreTheme storeTheme = storeModel.getStoreTheme();
        $jacocoInit[82] = true;
        String themeName = storeTheme.getThemeName();
        boolean storeExists = storeModel.storeExists();
        List socialLinks = storeModel.getSocialLinks();
        $jacocoInit[83] = true;
        List socialDeleteLinks = storeModel.getSocialDeleteLinks();
        $jacocoInit[84] = true;
        C0117M createOrUpdate = aptoideAccountManager.createOrUpdate(storeName, storeDescription, mediaStoragePath, hasNewAvatar, themeName, storeExists, socialLinks, socialDeleteLinks);
        $jacocoInit[85] = true;
        return createOrUpdate;
    }

    private void navigate(boolean success) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.goBackToHome) {
            $jacocoInit[24] = true;
            this.navigator.goToHome();
            $jacocoInit[25] = true;
            return;
        }
        this.navigator.popViewWithResult(this.requestCode, success);
        $jacocoInit[26] = true;
    }

    private void handleStoreCreationErrors(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        if (err instanceof InvalidImageException) {
            InvalidImageException exception = (InvalidImageException) err;
            $jacocoInit[27] = true;
            List imageErrors = exception.getImageErrors();
            ImageError imageError = ImageError.API_ERROR;
            $jacocoInit[28] = true;
            if (imageErrors.contains(imageError)) {
                $jacocoInit[29] = true;
                this.view.showError(this.errorMapper.getImageError());
                $jacocoInit[30] = true;
                return;
            }
            this.view.showError(this.errorMapper.getNetworkError(exception.getErrorCode(), this.applicationPackageName));
            $jacocoInit[31] = true;
        } else if (err instanceof StoreCreationException) {
            StoreCreationException exception2 = (StoreCreationException) err;
            $jacocoInit[32] = true;
            if (exception2.hasErrorCode()) {
                ManageStoreView manageStoreView = this.view;
                ManageStoreErrorMapper manageStoreErrorMapper = this.errorMapper;
                $jacocoInit[33] = true;
                String networkError = manageStoreErrorMapper.getNetworkError(exception2.getErrorCode(), this.applicationPackageName);
                $jacocoInit[34] = true;
                manageStoreView.showError(networkError);
                $jacocoInit[35] = true;
                return;
            }
            this.view.showError(this.errorMapper.getInvalidStoreError());
            $jacocoInit[36] = true;
        } else {
            if (!(err instanceof StoreValidationException)) {
                $jacocoInit[37] = true;
            } else {
                StoreValidationException ex = (StoreValidationException) err;
                $jacocoInit[38] = true;
                if (ex.getErrorCode() == 0) {
                    $jacocoInit[39] = true;
                    this.view.showError(this.errorMapper.getInvalidStoreError());
                    $jacocoInit[40] = true;
                    return;
                } else if (ex.getErrorCode() != 1) {
                    $jacocoInit[41] = true;
                } else {
                    $jacocoInit[42] = true;
                    this.view.showError(this.errorMapper.getImageError());
                    $jacocoInit[43] = true;
                    return;
                }
            }
            if (err instanceof SocialLinkException) {
                $jacocoInit[44] = true;
                $jacocoInit[45] = true;
                for (StoreLinks storeLink : ((SocialLinkException) err).getStoreLinks()) {
                    $jacocoInit[46] = true;
                    ManageStoreErrorMapper manageStoreErrorMapper2 = this.errorMapper;
                    Type type = storeLink.getType();
                    $jacocoInit[47] = true;
                    String str = type.toString();
                    $jacocoInit[48] = true;
                    String error = manageStoreErrorMapper2.getError(getErrorMessage(str));
                    $jacocoInit[49] = true;
                    switch (C15251.f4464xf2be586a[storeLink.getType().ordinal()]) {
                        case 1:
                        case 2:
                            this.view.showFacebookError(error);
                            $jacocoInit[51] = true;
                            break;
                        case 3:
                        case 4:
                            this.view.showTwitterError(error);
                            $jacocoInit[52] = true;
                            break;
                        case 5:
                        case 6:
                            this.view.showTwitchError(error);
                            $jacocoInit[53] = true;
                            break;
                        case 7:
                        case 8:
                            this.view.showYoutubeError(error);
                            $jacocoInit[54] = true;
                            break;
                        default:
                            $jacocoInit[50] = true;
                            break;
                    }
                    $jacocoInit[55] = true;
                }
                $jacocoInit[56] = true;
                return;
            }
            this.crashReport.log(err);
            $jacocoInit[57] = true;
            this.view.showError(this.errorMapper.getGenericError());
            $jacocoInit[58] = true;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper.SocialErrorType getErrorMessage(java.lang.String r5) {
        /*
            r4 = this;
            boolean[] r0 = $jacocoInit()
            int r1 = r5.hashCode()
            r2 = 1
            switch(r1) {
                case -1854806331: goto L_0x009c;
                case -1854806330: goto L_0x0089;
                case -1648821947: goto L_0x0076;
                case -1648821946: goto L_0x0063;
                case -1092809227: goto L_0x0050;
                case -1092809226: goto L_0x003c;
                case 1485831416: goto L_0x0027;
                case 1485831417: goto L_0x0012;
                default: goto L_0x000c;
            }
        L_0x000c:
            r1 = 59
            r0[r1] = r2
            goto L_0x00af
        L_0x0012:
            java.lang.String r1 = "FACEBOOK_2"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0020
            r1 = 72
            r0[r1] = r2
            goto L_0x00af
        L_0x0020:
            r1 = 6
            r3 = 73
            r0[r3] = r2
            goto L_0x00b0
        L_0x0027:
            java.lang.String r1 = "FACEBOOK_1"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0035
            r1 = 62
            r0[r1] = r2
            goto L_0x00af
        L_0x0035:
            r1 = 63
            r0[r1] = r2
            r1 = 1
            goto L_0x00b0
        L_0x003c:
            java.lang.String r1 = "YOUTUBE_2"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x004a
            r1 = 70
            r0[r1] = r2
            goto L_0x00af
        L_0x004a:
            r1 = 5
            r3 = 71
            r0[r3] = r2
            goto L_0x00b0
        L_0x0050:
            java.lang.String r1 = "YOUTUBE_1"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x005d
            r1 = 66
            r0[r1] = r2
            goto L_0x00af
        L_0x005d:
            r1 = 3
            r3 = 67
            r0[r3] = r2
            goto L_0x00b0
        L_0x0063:
            java.lang.String r1 = "TWITTER_2"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0070
            r1 = 74
            r0[r1] = r2
            goto L_0x00af
        L_0x0070:
            r1 = 7
            r3 = 75
            r0[r3] = r2
            goto L_0x00b0
        L_0x0076:
            java.lang.String r1 = "TWITTER_1"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0083
            r1 = 64
            r0[r1] = r2
            goto L_0x00af
        L_0x0083:
            r1 = 2
            r3 = 65
            r0[r3] = r2
            goto L_0x00b0
        L_0x0089:
            java.lang.String r1 = "TWITCH_2"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0096
            r1 = 68
            r0[r1] = r2
            goto L_0x00af
        L_0x0096:
            r1 = 4
            r3 = 69
            r0[r3] = r2
            goto L_0x00b0
        L_0x009c:
            java.lang.String r1 = "TWITCH_1"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x00a9
            r1 = 60
            r0[r1] = r2
            goto L_0x00af
        L_0x00a9:
            r1 = 0
            r3 = 61
            r0[r3] = r2
            goto L_0x00b0
        L_0x00af:
            r1 = -1
        L_0x00b0:
            switch(r1) {
                case 0: goto L_0x00c8;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00c8;
                case 3: goto L_0x00c8;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00ba;
                case 7: goto L_0x00ba;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$SocialErrorType r1 = p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper.SocialErrorType.GENERIC_ERROR
            r3 = 79
            r0[r3] = r2
            return r1
        L_0x00ba:
            cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$SocialErrorType r1 = p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper.SocialErrorType.PAGE_DOES_NOT_EXIST
            r3 = 78
            r0[r3] = r2
            return r1
        L_0x00c1:
            cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$SocialErrorType r1 = p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper.SocialErrorType.LINK_CHANNEL_ERROR
            r3 = 77
            r0[r3] = r2
            return r1
        L_0x00c8:
            cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$SocialErrorType r1 = p005cm.aptoide.p006pt.account.view.store.ManageStoreErrorMapper.SocialErrorType.INVALID_URL_TEXT
            r3 = 76
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.store.ManageStorePresenter.getErrorMessage(java.lang.String):cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$SocialErrorType");
    }
}
