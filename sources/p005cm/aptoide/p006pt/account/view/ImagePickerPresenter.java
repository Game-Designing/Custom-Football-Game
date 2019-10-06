package p005cm.aptoide.p006pt.account.view;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.permission.AccountPermissionProvider;
import p005cm.aptoide.p006pt.permission.PermissionProvider.Permission;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.account.view.ImagePickerPresenter */
public class ImagePickerPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int CAMERA_PICK = 6;
    private static final int GALLERY_PICK = 5;
    private final AccountPermissionProvider accountPermissionProvider;
    private final ContentResolver contentResolver;
    private final CrashReport crashReport;
    private final ImageLoader imageLoader;
    private final ImageValidator imageValidator;
    private final ImagePickerNavigator navigator;
    private final PhotoFileGenerator photoFileGenerator;
    private final C0126V uiScheduler;
    private final UriToPathResolver uriToPathResolver;
    private final ImagePickerView view;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4360592466869313148L, "cm/aptoide/pt/account/view/ImagePickerPresenter", Opcodes.IAND);
        $jacocoData = probes;
        return probes;
    }

    public ImagePickerPresenter(ImagePickerView view2, CrashReport crashReport2, AccountPermissionProvider accountPermissionProvider2, PhotoFileGenerator photoFileGenerator2, ImageValidator imageValidator2, C0126V viewScheduler, UriToPathResolver uriToPathResolver2, ImagePickerNavigator navigator2, ContentResolver contentResolver2, ImageLoader imageLoader2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.crashReport = crashReport2;
        this.accountPermissionProvider = accountPermissionProvider2;
        this.photoFileGenerator = photoFileGenerator2;
        this.imageValidator = imageValidator2;
        this.uiScheduler = viewScheduler;
        this.uriToPathResolver = uriToPathResolver2;
        this.navigator = navigator2;
        this.contentResolver = contentResolver2;
        this.imageLoader = imageLoader2;
        $jacocoInit[0] = true;
    }

    public void handlePickImageClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1504n nVar = C1504n.f4427a;
        $jacocoInit[1] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) nVar);
        C1506p pVar = new C1506p(this);
        $jacocoInit[2] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) pVar);
        ImagePickerView imagePickerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[3] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) imagePickerView.bindUntilEvent(lifecycleEvent2));
        C1500j jVar = C1500j.f4423a;
        C1632w wVar = new C1632w(this);
        $jacocoInit[4] = true;
        a.mo3626a((C0129b<? super T>) jVar, (C0129b<Throwable>) wVar);
        $jacocoInit[5] = true;
    }

    /* renamed from: i */
    static /* synthetic */ Boolean m6243i(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[123] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[124] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[125] = true;
        return valueOf;
    }

    /* renamed from: j */
    public /* synthetic */ C0120S mo9691j(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S selectStoreImageClick = this.view.selectStoreImageClick();
        $jacocoInit[119] = true;
        C0120S g = selectStoreImageClick.mo3662g();
        C1459F f = new C1459F(this);
        $jacocoInit[120] = true;
        C0120S b = g.mo3636b((C0129b<? super T>) f);
        $jacocoInit[121] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9670b(Void __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.showImagePickerDialog();
        $jacocoInit[122] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6236a(Void __) {
        $jacocoInit()[118] = true;
    }

    /* renamed from: e */
    public /* synthetic */ void mo9681e(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[117] = true;
    }

    private C0117M loadValidImageOrThrowForCamera(String createdUri) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M validateOrGetException = this.imageValidator.validateOrGetException(createdUri);
        C0126V v = this.uiScheduler;
        $jacocoInit[6] = true;
        C0117M a = validateOrGetException.mo3581a(v);
        C1453A a2 = new C1453A(this, createdUri);
        $jacocoInit[7] = true;
        C0117M a3 = a.mo3582a((C0128a) a2);
        $jacocoInit[8] = true;
        return a3;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9674c(String createdUri) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.loadImage(createdUri);
        $jacocoInit[116] = true;
    }

    private Single<String> getFileNameFromCameraWithUri(String createdUri) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigateToCameraWithImageUri = this.navigator.navigateToCameraWithImageUri(6, Uri.parse(createdUri));
        $jacocoInit[9] = true;
        C0120S d = navigateToCameraWithImageUri.mo3647d();
        C1461H h = new C1461H(this, createdUri);
        $jacocoInit[10] = true;
        C0120S i = d.mo3668i(h);
        $jacocoInit[11] = true;
        Single<String> n = i.mo3678n();
        $jacocoInit[12] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo9666a(String createdUri, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        Single saveCameraPictureInPublicPhotos = saveCameraPictureInPublicPhotos(createdUri);
        $jacocoInit[115] = true;
        return saveCameraPictureInPublicPhotos;
    }

    private Single<String> saveCameraPictureInPublicPhotos(String createdUri) {
        boolean[] $jacocoInit = $jacocoInit();
        Bitmap image = this.imageLoader.loadBitmap(createdUri);
        if (image != null) {
            ContentResolver contentResolver2 = this.contentResolver;
            String str = File.pathSeparator;
            $jacocoInit[13] = true;
            String substring = createdUri.substring(createdUri.lastIndexOf(str));
            $jacocoInit[14] = true;
            String path = Media.insertImage(contentResolver2, image, substring, null);
            $jacocoInit[15] = true;
            image.recycle();
            $jacocoInit[16] = true;
            Single a = Single.m734a(this.uriToPathResolver.getCameraStoragePath(Uri.parse(path)));
            $jacocoInit[17] = true;
            Single<String> b = a.mo3694b(Schedulers.m776io());
            $jacocoInit[18] = true;
            return b;
        }
        Single a2 = Single.m734a(this.uriToPathResolver.getCameraStoragePath(Uri.parse(createdUri)));
        $jacocoInit[19] = true;
        Single<String> b2 = a2.mo3694b(Schedulers.m776io());
        $jacocoInit[20] = true;
        return b2;
    }

    private void handleCameraSelection() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1509s sVar = C1509s.f4432a;
        $jacocoInit[21] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) sVar);
        C1508r rVar = new C1508r(this);
        $jacocoInit[22] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        ImagePickerView imagePickerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[23] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) imagePickerView.bindUntilEvent(lifecycleEvent2));
        C1474Q q = C1474Q.f4395a;
        C1476T t = new C1476T(this);
        $jacocoInit[24] = true;
        a.mo3626a((C0129b<? super T>) q, (C0129b<Throwable>) t);
        $jacocoInit[25] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m6239c(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[112] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[113] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[114] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0120S mo9676d(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dialogCameraSelected = this.view.dialogCameraSelected();
        C1507q qVar = new C1507q(this);
        $jacocoInit[109] = true;
        C0120S b = dialogCameraSelected.mo3636b((C0129b<? super T>) qVar);
        $jacocoInit[110] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9677d(DialogInterface __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountPermissionProvider.requestCameraPermission(6);
        $jacocoInit[111] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6234a(DialogInterface __) {
        $jacocoInit()[108] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9669b(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[107] = true;
    }

    private void handleGalleryImageResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1473P p = C1473P.f4394a;
        $jacocoInit[26] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) p);
        C1455B b = new C1455B(this);
        $jacocoInit[27] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) b);
        ImagePickerView imagePickerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[28] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) imagePickerView.bindUntilEvent(lifecycleEvent2));
        C1456C c = C1456C.f4378a;
        C1635z zVar = new C1635z(this);
        $jacocoInit[29] = true;
        a.mo3626a((C0129b<? super T>) c, (C0129b<Throwable>) zVar);
        $jacocoInit[30] = true;
    }

    /* renamed from: e */
    static /* synthetic */ Boolean m6241e(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[104] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[105] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[106] = true;
        return valueOf;
    }

    /* renamed from: f */
    public /* synthetic */ C0120S mo9684f(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S permissionResultCamera = this.accountPermissionProvider.permissionResultCamera(5);
        C1477U u = C1477U.f4398a;
        $jacocoInit[87] = true;
        C0120S d = permissionResultCamera.mo3653d((C0132p<? super T, Boolean>) u);
        C1460G g = new C1460G(this);
        $jacocoInit[88] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) g);
        C1554u uVar = new C1554u(this);
        $jacocoInit[89] = true;
        C0120S f = b.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) uVar);
        C1472O o = new C1472O(this);
        $jacocoInit[90] = true;
        C0120S g2 = f.mo3663g((C0132p<? super T, ? extends C0117M>) o);
        C1464J j = new C1464J(this);
        $jacocoInit[91] = true;
        C0120S a = g2.mo3621a((C0129b<? super Throwable>) j);
        $jacocoInit[92] = true;
        C0120S g3 = a.mo3662g();
        $jacocoInit[93] = true;
        return g3;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6233a(List permissions) {
        boolean[] $jacocoInit = $jacocoInit();
        Permission permission = (Permission) permissions.get(0);
        $jacocoInit[101] = true;
        boolean isGranted = permission.isGranted();
        $jacocoInit[102] = true;
        Boolean valueOf = Boolean.valueOf(isGranted);
        $jacocoInit[103] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ void mo9671b(List __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissLoadImageDialog();
        $jacocoInit[100] = true;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo9672c(List __2) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S navigateToGalleryForImageUri = this.navigator.navigateToGalleryForImageUri(5);
        $jacocoInit[99] = true;
        return navigateToGalleryForImageUri;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo9680e(String selectedImageUri) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M loadValidImageOrThrowForGallery = loadValidImageOrThrowForGallery(selectedImageUri);
        $jacocoInit[98] = true;
        return loadValidImageOrThrowForGallery;
    }

    /* renamed from: f */
    public /* synthetic */ void mo9686f(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        if (!(err instanceof InvalidImageException)) {
            $jacocoInit[94] = true;
        } else {
            $jacocoInit[95] = true;
            this.view.showIconPropertiesError((InvalidImageException) err);
            $jacocoInit[96] = true;
        }
        $jacocoInit[97] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6238b(String __) {
        $jacocoInit()[86] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9675c(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[85] = true;
    }

    private C0117M loadValidImageOrThrowForGallery(String selectedImageUri) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M validateOrGetException = this.imageValidator.validateOrGetException(selectedImageUri);
        C0126V v = this.uiScheduler;
        $jacocoInit[31] = true;
        C0117M a = validateOrGetException.mo3581a(v);
        C1458E e = new C1458E(this, selectedImageUri);
        $jacocoInit[32] = true;
        C0117M a2 = a.mo3582a((C0128a) e);
        $jacocoInit[33] = true;
        return a2;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9678d(String selectedImageUri) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.loadImage(selectedImageUri);
        $jacocoInit[84] = true;
    }

    private void handleGallerySelection() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1457D d = C1457D.f4379a;
        $jacocoInit[34] = true;
        C0120S d2 = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) d);
        C1553t tVar = new C1553t(this);
        $jacocoInit[35] = true;
        C0120S f = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) tVar);
        ImagePickerView imagePickerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[36] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) imagePickerView.bindUntilEvent(lifecycleEvent2));
        C1462I i = C1462I.f4386a;
        C1503m mVar = new C1503m(this);
        $jacocoInit[37] = true;
        a.mo3626a((C0129b<? super T>) i, (C0129b<Throwable>) mVar);
        $jacocoInit[38] = true;
    }

    /* renamed from: g */
    static /* synthetic */ Boolean m6242g(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[81] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[82] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[83] = true;
        return valueOf;
    }

    /* renamed from: h */
    public /* synthetic */ C0120S mo9689h(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S dialogGallerySelected = this.view.dialogGallerySelected();
        C1470M m = new C1470M(this);
        $jacocoInit[78] = true;
        C0120S b = dialogGallerySelected.mo3636b((C0129b<? super T>) m);
        $jacocoInit[79] = true;
        return b;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9673c(DialogInterface __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountPermissionProvider.requestGalleryPermission(5);
        $jacocoInit[80] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m6237b(DialogInterface __) {
        $jacocoInit()[77] = true;
    }

    /* renamed from: d */
    public /* synthetic */ void mo9679d(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[76] = true;
    }

    private void handleCameraImageResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C1466L l = C1466L.f4390a;
        $jacocoInit[39] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) l);
        C1633x xVar = new C1633x(this);
        $jacocoInit[40] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) xVar);
        ImagePickerView imagePickerView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[41] = true;
        C0120S a = f.mo3614a((C0121c<? super T, ? extends R>) imagePickerView.bindUntilEvent(lifecycleEvent2));
        C1475S s = C1475S.f4396a;
        C1471N n = new C1471N(this);
        $jacocoInit[42] = true;
        a.mo3626a((C0129b<? super T>) s, (C0129b<Throwable>) n);
        $jacocoInit[43] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6232a(LifecycleEvent event) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (event == LifecycleEvent.CREATE) {
            $jacocoInit[73] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[74] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[75] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo9668b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S permissionResultCamera = this.accountPermissionProvider.permissionResultCamera(6);
        C1465K k = C1465K.f4389a;
        $jacocoInit[51] = true;
        C0120S d = permissionResultCamera.mo3653d((C0132p<? super T, Boolean>) k);
        C1631v vVar = new C1631v(this);
        $jacocoInit[52] = true;
        C0120S b = d.mo3636b((C0129b<? super T>) vVar);
        C1505o oVar = new C1505o(this);
        $jacocoInit[53] = true;
        C0120S i = b.mo3668i(oVar);
        C1502l lVar = new C1502l(this);
        $jacocoInit[54] = true;
        C0120S g = i.mo3663g((C0132p<? super T, ? extends C0117M>) lVar);
        C1634y yVar = new C1634y(this);
        $jacocoInit[55] = true;
        C0120S a = g.mo3621a((C0129b<? super Throwable>) yVar);
        $jacocoInit[56] = true;
        C0120S g2 = a.mo3662g();
        $jacocoInit[57] = true;
        return g2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<cm.aptoide.pt.permission.PermissionProvider$Permission>, for r5v0, types: [java.util.List, java.util.List<cm.aptoide.pt.permission.PermissionProvider$Permission>] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Boolean m6240d(java.util.List<p005cm.aptoide.p006pt.permission.PermissionProvider.Permission> r5) {
        /*
            boolean[] r0 = $jacocoInit()
            java.util.Iterator r1 = r5.iterator()
            r2 = 1
            r3 = 67
            r0[r3] = r2
        L_0x000d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r1.next()
            cm.aptoide.pt.permission.PermissionProvider$Permission r3 = (p005cm.aptoide.p006pt.permission.PermissionProvider.Permission) r3
            r4 = 68
            r0[r4] = r2
            boolean r4 = r3.isGranted()
            if (r4 != 0) goto L_0x0031
            r1 = 69
            r0[r1] = r2
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r4 = 70
            r0[r4] = r2
            return r1
        L_0x0031:
            r3 = 71
            r0[r3] = r2
            goto L_0x000d
        L_0x0036:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r3 = 72
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.ImagePickerPresenter.m6240d(java.util.List):java.lang.Boolean");
    }

    /* renamed from: e */
    public /* synthetic */ void mo9682e(List __2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view.dismissLoadImageDialog();
        $jacocoInit[66] = true;
    }

    /* renamed from: f */
    public /* synthetic */ Single mo9685f(List __2) {
        boolean[] $jacocoInit = $jacocoInit();
        Single generateNewImageFileUriAsString = this.photoFileGenerator.generateNewImageFileUriAsString();
        $jacocoInit[65] = true;
        return generateNewImageFileUriAsString;
    }

    /* renamed from: g */
    public /* synthetic */ C0117M mo9687g(String createdUri) {
        boolean[] $jacocoInit = $jacocoInit();
        Single a = getFileNameFromCameraWithUri(createdUri).mo3686a(this.uiScheduler);
        C1501k kVar = new C1501k(this);
        $jacocoInit[62] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) kVar);
        $jacocoInit[63] = true;
        return b;
    }

    /* renamed from: f */
    public /* synthetic */ C0117M mo9683f(String fullFilePath) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M loadValidImageOrThrowForCamera = loadValidImageOrThrowForCamera(fullFilePath);
        $jacocoInit[64] = true;
        return loadValidImageOrThrowForCamera;
    }

    /* renamed from: g */
    public /* synthetic */ void mo9688g(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        if (err instanceof InvalidImageException) {
            $jacocoInit[58] = true;
            this.view.showIconPropertiesError((InvalidImageException) err);
            $jacocoInit[59] = true;
        } else {
            this.crashReport.log(err);
            $jacocoInit[60] = true;
        }
        $jacocoInit[61] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6235a(String __) {
        $jacocoInit()[50] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo9667a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[49] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        handlePickImageClick();
        $jacocoInit[44] = true;
        handleCameraSelection();
        $jacocoInit[45] = true;
        handleCameraImageResult();
        $jacocoInit[46] = true;
        handleGallerySelection();
        $jacocoInit[47] = true;
        handleGalleryImageResult();
        $jacocoInit[48] = true;
    }
}
