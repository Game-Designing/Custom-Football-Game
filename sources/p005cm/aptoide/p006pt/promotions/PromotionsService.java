package p005cm.aptoide.p006pt.promotions;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info.Status;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.DataList;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile.Signature;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.ClaimPromotionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPackagePromotionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPackagePromotionsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPackagePromotionsResponse.PromotionAppModel;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionAppsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.promotions.GetPromotionsResponse.PromotionModel;
import p005cm.aptoide.p006pt.promotions.ClaimStatusWrapper.Error;
import p026rx.C0120S;
import p026rx.Single;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.promotions.PromotionsService */
public class PromotionsService {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ALREADY_CLAIMED = "PROMOTION-3";
    private static final String WRONG_ADDRESS = "PROMOTION-2";
    private static final String WRONG_CAPTCHA = "PROMOTION-1";
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final Factory converterFactory;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;
    private String walletAddress;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5977515983416665086L, "cm/aptoide/pt/promotions/PromotionsService", Opcodes.ISHR);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsService(BodyInterceptor<BaseBody> bodyInterceptorPoolV72, OkHttpClient okHttpClient2, TokenInvalidator tokenInvalidator2, Factory converterFactory2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorPoolV7 = bodyInterceptorPoolV72;
        this.okHttpClient = okHttpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.converterFactory = converterFactory2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<ClaimStatusWrapper> claimPromotion(String walletAddress2, String packageName, String captcha, String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        ClaimPromotionRequest of = ClaimPromotionRequest.m7573of(walletAddress2, packageName, captcha, promotionId, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[1] = true;
        C0120S observe = of.observe(true);
        C4602xc xcVar = new C4602xc(this);
        $jacocoInit[2] = true;
        C0120S j = observe.mo3669j(xcVar);
        C4423Ac ac = new C4423Ac(this);
        $jacocoInit[3] = true;
        C0120S l = j.mo3674l(ac);
        $jacocoInit[4] = true;
        Single<ClaimStatusWrapper> n = l.mo3678n();
        $jacocoInit[5] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ ClaimStatusWrapper mo15787a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof AptoideWsV7Exception) {
            $jacocoInit[119] = true;
            ClaimStatusWrapper mapClaim = mapClaim(((AptoideWsV7Exception) throwable).getBaseResponse());
            $jacocoInit[120] = true;
            return mapClaim;
        }
        RuntimeException runtimeException = new RuntimeException(throwable);
        $jacocoInit[121] = true;
        throw runtimeException;
    }

    /* access modifiers changed from: private */
    public ClaimStatusWrapper mapClaim(BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        Info info = response.getInfo();
        $jacocoInit[6] = true;
        Status status = info.getStatus();
        $jacocoInit[7] = true;
        ClaimStatusWrapper.Status mapStatus = mapStatus(status);
        $jacocoInit[8] = true;
        ClaimStatusWrapper claimStatusWrapper = new ClaimStatusWrapper(mapStatus, mapError(response.getErrors()));
        $jacocoInit[9] = true;
        return claimStatusWrapper;
    }

    private ClaimStatusWrapper.Status mapStatus(Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        if (status.equals(Status.OK)) {
            ClaimStatusWrapper.Status status2 = ClaimStatusWrapper.Status.OK;
            $jacocoInit[10] = true;
            return status2;
        }
        ClaimStatusWrapper.Status status3 = ClaimStatusWrapper.Status.FAIL;
        $jacocoInit[11] = true;
        return status3;
    }

    public void saveWalletAddress(String walletAddress2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.walletAddress = walletAddress2;
        $jacocoInit[12] = true;
    }

    public String getWalletAddress() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.walletAddress;
        $jacocoInit[13] = true;
        return str;
    }

    private List<Error> mapError(List<BaseV7Response.Error> errors) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Error> result = new ArrayList<>();
        if (errors == null) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            $jacocoInit[16] = true;
            for (BaseV7Response.Error error : errors) {
                $jacocoInit[18] = true;
                String code = error.getCode();
                $jacocoInit[19] = true;
                if (code.equals(WRONG_CAPTCHA)) {
                    $jacocoInit[20] = true;
                    result.add(Error.WRONG_CAPTCHA);
                    $jacocoInit[21] = true;
                } else {
                    String code2 = error.getCode();
                    $jacocoInit[22] = true;
                    if (code2.equals(WRONG_ADDRESS)) {
                        $jacocoInit[23] = true;
                        result.add(Error.WRONG_ADDRESS);
                        $jacocoInit[24] = true;
                    } else {
                        String code3 = error.getCode();
                        $jacocoInit[25] = true;
                        if (code3.equals(ALREADY_CLAIMED)) {
                            $jacocoInit[26] = true;
                            result.add(Error.PROMOTION_CLAIMED);
                            $jacocoInit[27] = true;
                        } else {
                            result.add(Error.GENERIC);
                            $jacocoInit[28] = true;
                        }
                    }
                }
                $jacocoInit[29] = true;
            }
            $jacocoInit[17] = true;
        }
        $jacocoInit[30] = true;
        return result;
    }

    public Single<List<PromotionMeta>> getPromotions(String type) {
        boolean[] $jacocoInit = $jacocoInit();
        GetPromotionsRequest of = GetPromotionsRequest.m7576of(type, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[31] = true;
        C0120S observe = of.observe();
        C4427Bc bc = new C4427Bc(this);
        $jacocoInit[32] = true;
        C0120S j = observe.mo3669j(bc);
        $jacocoInit[33] = true;
        Single<List<PromotionMeta>> n = j.mo3678n();
        $jacocoInit[34] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ List mo15788a(GetPromotionsResponse promotionsResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        List map = map(promotionsResponse);
        $jacocoInit[118] = true;
        return map;
    }

    private List<PromotionMeta> map(GetPromotionsResponse promotions) {
        boolean[] $jacocoInit = $jacocoInit();
        List<PromotionMeta> promotionList = new ArrayList<>();
        $jacocoInit[35] = true;
        if (promotions.getDataList() == null) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            DataList dataList = promotions.getDataList();
            $jacocoInit[38] = true;
            if (dataList.getList() == null) {
                $jacocoInit[39] = true;
            } else {
                DataList dataList2 = promotions.getDataList();
                $jacocoInit[41] = true;
                List<PromotionModel> list = dataList2.getList();
                $jacocoInit[42] = true;
                $jacocoInit[43] = true;
                for (PromotionModel promotionModel : list) {
                    $jacocoInit[44] = true;
                    String title = promotionModel.getTitle();
                    String promotionId = promotionModel.getPromotionId();
                    $jacocoInit[45] = true;
                    PromotionMeta promotionMeta = new PromotionMeta(title, promotionId, promotionModel.getType(), promotionModel.getBackground());
                    $jacocoInit[46] = true;
                    promotionList.add(promotionMeta);
                    $jacocoInit[47] = true;
                }
                $jacocoInit[48] = true;
                return promotionList;
            }
        }
        $jacocoInit[40] = true;
        return promotionList;
    }

    public Single<List<PromotionApp>> getPromotionApps(String promotionId) {
        boolean[] $jacocoInit = $jacocoInit();
        GetPromotionAppsRequest of = GetPromotionAppsRequest.m7575of(promotionId, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[49] = true;
        C0120S observe = of.observe(false, false);
        C4610zc zcVar = new C4610zc(this);
        $jacocoInit[50] = true;
        C0120S j = observe.mo3669j(zcVar);
        $jacocoInit[51] = true;
        Single<List<PromotionApp>> n = j.mo3678n();
        $jacocoInit[52] = true;
        return n;
    }

    public Single<List<Promotion>> getPromotionsForPackage(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        GetPackagePromotionsRequest of = GetPackagePromotionsRequest.m7574of(packageName, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[53] = true;
        C0120S observe = of.observe(false, false);
        C4606yc ycVar = new C4606yc(this);
        $jacocoInit[54] = true;
        C0120S j = observe.mo3669j(ycVar);
        $jacocoInit[55] = true;
        Single<List<Promotion>> n = j.mo3678n();
        $jacocoInit[56] = true;
        return n;
    }

    /* access modifiers changed from: private */
    public List<Promotion> mapToPromotion(GetPackagePromotionsResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<Promotion> promotions = new ArrayList<>();
        if (response == null) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            if (response.getDataList() == null) {
                $jacocoInit[59] = true;
            } else {
                $jacocoInit[60] = true;
                DataList dataList = response.getDataList();
                $jacocoInit[61] = true;
                if (dataList.getList() == null) {
                    $jacocoInit[62] = true;
                } else {
                    $jacocoInit[63] = true;
                    DataList dataList2 = response.getDataList();
                    $jacocoInit[64] = true;
                    List<PromotionAppModel> dataList3 = dataList2.getList();
                    $jacocoInit[65] = true;
                    $jacocoInit[66] = true;
                    for (PromotionAppModel model : dataList3) {
                        $jacocoInit[68] = true;
                        boolean isClaimed = model.isClaimed();
                        float appc = model.getAppc();
                        String packageName = model.getPackageName();
                        $jacocoInit[69] = true;
                        Promotion promotion = new Promotion(isClaimed, appc, packageName, model.getPromotionId(), Collections.emptyList());
                        $jacocoInit[70] = true;
                        promotions.add(promotion);
                        $jacocoInit[71] = true;
                    }
                    $jacocoInit[67] = true;
                }
            }
        }
        $jacocoInit[72] = true;
        return promotions;
    }

    /* access modifiers changed from: private */
    public List<PromotionApp> mapPromotionsResponse(GetPromotionAppsResponse response) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<PromotionApp> result = new ArrayList<>();
        if (response == null) {
            $jacocoInit[73] = true;
        } else {
            $jacocoInit[74] = true;
            if (response.getDataList() == null) {
                $jacocoInit[75] = true;
            } else {
                $jacocoInit[76] = true;
                DataList dataList = response.getDataList();
                $jacocoInit[77] = true;
                if (dataList.getList() == null) {
                    $jacocoInit[78] = true;
                } else {
                    $jacocoInit[79] = true;
                    DataList dataList2 = response.getDataList();
                    $jacocoInit[80] = true;
                    List<GetPromotionAppsResponse.PromotionAppModel> list = dataList2.getList();
                    $jacocoInit[81] = true;
                    $jacocoInit[82] = true;
                    for (GetPromotionAppsResponse.PromotionAppModel app : list) {
                        $jacocoInit[84] = true;
                        App app2 = app.getApp();
                        $jacocoInit[85] = true;
                        String name = app2.getName();
                        App app3 = app.getApp();
                        $jacocoInit[86] = true;
                        String packageName = app3.getPackageName();
                        App app4 = app.getApp();
                        $jacocoInit[87] = true;
                        long id = app4.getId();
                        App app5 = app.getApp();
                        $jacocoInit[88] = true;
                        GetAppMetaFile file = app5.getFile();
                        $jacocoInit[89] = true;
                        String path = file.getPath();
                        App app6 = app.getApp();
                        $jacocoInit[90] = true;
                        GetAppMetaFile file2 = app6.getFile();
                        $jacocoInit[91] = true;
                        String pathAlt = file2.getPathAlt();
                        App app7 = app.getApp();
                        $jacocoInit[92] = true;
                        String icon = app7.getIcon();
                        String promotionDescription = app.getPromotionDescription();
                        App app8 = app.getApp();
                        $jacocoInit[93] = true;
                        long size = app8.getSize();
                        App app9 = app.getApp();
                        $jacocoInit[94] = true;
                        Stats stats = app9.getStats();
                        $jacocoInit[95] = true;
                        Rating rating = stats.getRating();
                        $jacocoInit[96] = true;
                        float avg = rating.getAvg();
                        App app10 = app.getApp();
                        $jacocoInit[97] = true;
                        Stats stats2 = app10.getStats();
                        $jacocoInit[98] = true;
                        int downloads = stats2.getDownloads();
                        App app11 = app.getApp();
                        $jacocoInit[99] = true;
                        GetAppMetaFile file3 = app11.getFile();
                        $jacocoInit[100] = true;
                        String md5sum = file3.getMd5sum();
                        App app12 = app.getApp();
                        $jacocoInit[101] = true;
                        GetAppMetaFile file4 = app12.getFile();
                        $jacocoInit[102] = true;
                        int vercode = file4.getVercode();
                        boolean isClaimed = app.isClaimed();
                        App app13 = app.getApp();
                        $jacocoInit[103] = true;
                        GetAppMetaFile file5 = app13.getFile();
                        $jacocoInit[104] = true;
                        String vername = file5.getVername();
                        App app14 = app.getApp();
                        $jacocoInit[105] = true;
                        Obb obb = app14.getObb();
                        float appc = app.getAppc();
                        App app15 = app.getApp();
                        $jacocoInit[106] = true;
                        GetAppMetaFile file6 = app15.getFile();
                        $jacocoInit[107] = true;
                        Signature signature = file6.getSignature();
                        $jacocoInit[108] = true;
                        String sha1 = signature.getSha1();
                        App app16 = app.getApp();
                        $jacocoInit[109] = true;
                        if (app16.hasAdvertising()) {
                            $jacocoInit[110] = true;
                        } else {
                            App app17 = app.getApp();
                            $jacocoInit[111] = true;
                            if (app17.hasBilling()) {
                                $jacocoInit[112] = true;
                            } else {
                                $jacocoInit[114] = true;
                                z = false;
                                PromotionApp promotionApp = new PromotionApp(name, packageName, id, path, pathAlt, icon, promotionDescription, size, avg, downloads, md5sum, vercode, isClaimed, vername, obb, appc, sha1, z);
                                $jacocoInit[115] = true;
                                result.add(promotionApp);
                                $jacocoInit[116] = true;
                            }
                        }
                        $jacocoInit[113] = true;
                        z = true;
                        PromotionApp promotionApp2 = new PromotionApp(name, packageName, id, path, pathAlt, icon, promotionDescription, size, avg, downloads, md5sum, vercode, isClaimed, vername, obb, appc, sha1, z);
                        $jacocoInit[115] = true;
                        result.add(promotionApp2);
                        $jacocoInit[116] = true;
                    }
                    $jacocoInit[83] = true;
                }
            }
        }
        $jacocoInit[117] = true;
        return result;
    }
}
