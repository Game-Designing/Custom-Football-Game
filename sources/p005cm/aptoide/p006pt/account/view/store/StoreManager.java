package p005cm.aptoide.p006pt.account.view.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.SocialLink;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException.ImageError;
import p005cm.aptoide.p006pt.account.view.exception.SocialLinkException;
import p005cm.aptoide.p006pt.account.view.exception.StoreCreationException;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV7Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Details;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Error;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.CheckUserCredentialsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SetStoreImageRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SimpleSetStoreRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SimpleSetStoreRequest.StoreLinks;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.account.view.store.StoreManager */
public class StoreManager implements p005cm.aptoide.accountmanager.StoreManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String ERROR_API_1 = "API-1";
    private static final String ERROR_CODE_2 = "WOP-2";
    private static final String ERROR_CODE_3 = "WOP-3";
    private static final String ERROR_STORE_9 = "STORE-9";
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody> bodyInterceptorV7;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final BodyInterceptor<HashMapNotNull<String, RequestBody>> multipartBodyInterceptor;
    private final ObjectMapper objectMapper;
    private final RequestBodyFactory requestBodyFactory;
    private final SharedPreferences sharedPreferences;
    private final StoreRepository storeRepository;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2141473579191850553L, "cm/aptoide/pt/account/view/store/StoreManager", 93);
        $jacocoData = probes;
        return probes;
    }

    public StoreManager(OkHttpClient httpClient2, Factory converterFactory2, BodyInterceptor<HashMapNotNull<String, RequestBody>> multipartBodyInterceptor2, BodyInterceptor<BaseBody> bodyInterceptorV32, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody> bodyInterceptorV72, SharedPreferences sharedPreferences2, TokenInvalidator tokenInvalidator2, RequestBodyFactory requestBodyFactory2, ObjectMapper objectMapper2, StoreRepository storeRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.multipartBodyInterceptor = multipartBodyInterceptor2;
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.sharedPreferences = sharedPreferences2;
        this.tokenInvalidator = tokenInvalidator2;
        this.requestBodyFactory = requestBodyFactory2;
        this.objectMapper = objectMapper2;
        this.storeRepository = storeRepository2;
        $jacocoInit[0] = true;
    }

    public C0117M createOrUpdate(String storeName, String storeDescription, String storeImagePath, boolean hasNewAvatar, String storeThemeName, boolean storeExists, List<SocialLink> storeLinksList, List<SocialChannelType> storeDeleteLinksList) {
        boolean[] $jacocoInit = $jacocoInit();
        C1519J j = new C1519J(this, storeExists, storeName, storeDescription, storeImagePath, hasNewAvatar, storeThemeName, storeLinksList, storeDeleteLinksList);
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) j);
        C1517H h = new C1517H(this);
        $jacocoInit[1] = true;
        C0117M b = a.mo3596b((C0132p<? super Throwable, ? extends C0117M>) h);
        $jacocoInit[2] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9855a(boolean storeExists, String storeName, String storeDescription, String storeImagePath, boolean hasNewAvatar, String storeThemeName, List storeLinksList, List storeDeleteLinksList) {
        List list = storeLinksList;
        boolean[] $jacocoInit = $jacocoInit();
        if (storeExists) {
            $jacocoInit[87] = true;
            List socialLinkToStoreLink = socialLinkToStoreLink(list);
            $jacocoInit[88] = true;
            C0117M updateStore = updateStore(storeName, storeDescription, storeImagePath, hasNewAvatar, storeThemeName, socialLinkToStoreLink, storeDeleteLinksList);
            $jacocoInit[89] = true;
            return updateStore;
        }
        $jacocoInit[90] = true;
        List socialLinkToStoreLink2 = socialLinkToStoreLink(list);
        $jacocoInit[91] = true;
        C0117M createStore = createStore(storeName, storeDescription, storeImagePath, hasNewAvatar, storeThemeName, socialLinkToStoreLink2, storeDeleteLinksList);
        $jacocoInit[92] = true;
        return createStore;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9854a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M onErrorCompletable = getOnErrorCompletable(err);
        $jacocoInit[86] = true;
        return onErrorCompletable;
    }

    public C0120S<Boolean> isSubscribed(long storeId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> isSubscribed = this.storeRepository.isSubscribed(storeId);
        $jacocoInit[3] = true;
        return isSubscribed;
    }

    private C0117M getOnErrorCompletable(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        if (err instanceof StoreCreationException) {
            $jacocoInit[4] = true;
        } else if (err instanceof InvalidImageException) {
            $jacocoInit[5] = true;
        } else if (err instanceof AptoideWsV7Exception) {
            $jacocoInit[7] = true;
            BaseV7Response baseResponse = ((AptoideWsV7Exception) err).getBaseResponse();
            $jacocoInit[8] = true;
            List errors = baseResponse.getErrors();
            $jacocoInit[9] = true;
            Error error = (Error) errors.get(0);
            $jacocoInit[10] = true;
            String code = error.getCode();
            $jacocoInit[11] = true;
            if (code.equals(ERROR_API_1)) {
                ImageError imageError = ImageError.API_ERROR;
                $jacocoInit[12] = true;
                InvalidImageException invalidImageException = new InvalidImageException(Collections.singletonList(imageError));
                $jacocoInit[13] = true;
                C0117M b = C0117M.m591b((Throwable) invalidImageException);
                $jacocoInit[14] = true;
                return b;
            }
            BaseV7Response baseResponse2 = ((AptoideWsV7Exception) err).getBaseResponse();
            $jacocoInit[15] = true;
            List errors2 = baseResponse2.getErrors();
            $jacocoInit[16] = true;
            Error error2 = (Error) errors2.get(0);
            $jacocoInit[17] = true;
            String code2 = error2.getCode();
            $jacocoInit[18] = true;
            if (code2.equals(ERROR_STORE_9)) {
                AptoideWsV7Exception aptoideWsV7Exception = (AptoideWsV7Exception) err;
                $jacocoInit[19] = true;
                BaseV7Response baseResponse3 = aptoideWsV7Exception.getBaseResponse();
                $jacocoInit[20] = true;
                List errors3 = baseResponse3.getErrors();
                $jacocoInit[21] = true;
                Error error3 = (Error) errors3.get(0);
                $jacocoInit[22] = true;
                Details details = error3.getDetails();
                $jacocoInit[23] = true;
                SocialLinkException socialLinkException = new SocialLinkException(details.getStoreLinks());
                $jacocoInit[24] = true;
                C0117M b2 = C0117M.m591b((Throwable) socialLinkException);
                $jacocoInit[25] = true;
                return b2;
            }
            ImageError imageError2 = ImageError.API_ERROR;
            $jacocoInit[26] = true;
            List singletonList = Collections.singletonList(imageError2);
            $jacocoInit[27] = true;
            InvalidImageException invalidImageException2 = new InvalidImageException(singletonList, err.getMessage());
            $jacocoInit[28] = true;
            C0117M b3 = C0117M.m591b((Throwable) invalidImageException2);
            $jacocoInit[29] = true;
            return b3;
        } else {
            C0117M b4 = C0117M.m591b(err);
            $jacocoInit[30] = true;
            return b4;
        }
        C0117M b5 = C0117M.m591b(err);
        $jacocoInit[6] = true;
        return b5;
    }

    private List<StoreLinks> socialLinkToStoreLink(List<SocialLink> socialLinksList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<StoreLinks> storeLinks = new ArrayList<>();
        $jacocoInit[31] = true;
        $jacocoInit[32] = true;
        for (SocialLink socialLink : socialLinksList) {
            $jacocoInit[33] = true;
            StoreLinks storeLinks2 = new StoreLinks(socialLink.getType(), socialLink.getUrl());
            $jacocoInit[34] = true;
            storeLinks.add(storeLinks2);
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
        return storeLinks;
    }

    private C0117M createStore(String storeName, String storeDescription, String storeImage, boolean hasNewAvatar, String storeThemeName, List<StoreLinks> storeLinksList, List<SocialChannelType> storeDeleteSocialLinksList) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(storeName)) {
            $jacocoInit[37] = true;
            C0117M b = C0117M.m591b((Throwable) new StoreValidationException(0));
            $jacocoInit[38] = true;
            return b;
        }
        CheckUserCredentialsRequest createStore = CheckUserCredentialsRequest.toCreateStore(this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, storeName);
        $jacocoInit[39] = true;
        C0120S observe = createStore.observe();
        $jacocoInit[40] = true;
        Single n = observe.mo3678n();
        C1520K k = C1520K.f4459a;
        $jacocoInit[41] = true;
        Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) k);
        C1518I i = new C1518I(this, storeDescription, storeImage, hasNewAvatar, storeThemeName, storeName, storeLinksList, storeDeleteSocialLinksList);
        $jacocoInit[42] = true;
        C0117M b2 = a.mo3693b((C0132p<? super T, ? extends C0117M>) i);
        $jacocoInit[43] = true;
        return b2;
    }

    /* renamed from: a */
    static /* synthetic */ Single m6315a(CheckUserCredentialsJson data) {
        boolean[] $jacocoInit = $jacocoInit();
        List<ErrorResponse> errors = data.getErrors();
        $jacocoInit[74] = true;
        if (errors == null) {
            $jacocoInit[75] = true;
        } else if (errors.isEmpty()) {
            $jacocoInit[76] = true;
        } else if (!((ErrorResponse) errors.get(0)).code.equals(ERROR_CODE_2)) {
            $jacocoInit[77] = true;
        } else {
            $jacocoInit[78] = true;
            Single a = Single.m735a((Throwable) new StoreCreationException());
            $jacocoInit[79] = true;
            return a;
        }
        if (errors == null) {
            $jacocoInit[80] = true;
        } else if (errors.size() <= 0) {
            $jacocoInit[81] = true;
        } else if (!((ErrorResponse) errors.get(0)).code.equals(ERROR_CODE_3)) {
            $jacocoInit[82] = true;
        } else {
            $jacocoInit[83] = true;
            Single a2 = Single.m735a((Throwable) new StoreCreationException(((ErrorResponse) errors.get(0)).code));
            $jacocoInit[84] = true;
            return a2;
        }
        Single a3 = Single.m734a(data);
        $jacocoInit[85] = true;
        return a3;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9853a(String storeDescription, String storeImage, boolean hasNewAvatar, String storeThemeName, String storeName, List storeLinksList, List storeDeleteSocialLinksList, CheckUserCredentialsJson data) {
        boolean[] $jacocoInit = $jacocoInit();
        if (needToUploadMoreStoreData(storeDescription, storeImage, hasNewAvatar, storeThemeName)) {
            $jacocoInit[71] = true;
            C0117M updateStore = updateStore(storeName, storeDescription, storeImage, hasNewAvatar, storeThemeName, storeLinksList, storeDeleteSocialLinksList);
            $jacocoInit[72] = true;
            return updateStore;
        }
        C0117M b = C0117M.m590b();
        $jacocoInit[73] = true;
        return b;
    }

    private boolean needToUploadMoreStoreData(String storeDescription, String storeImage, boolean hasNewAvatar, String storeThemeName) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(storeDescription)) {
            $jacocoInit[44] = true;
        } else {
            if (!hasNewAvatar) {
                $jacocoInit[45] = true;
            } else if (!TextUtils.isEmpty(storeImage)) {
                $jacocoInit[46] = true;
            } else {
                $jacocoInit[47] = true;
            }
            StoreTheme storeTheme = StoreTheme.DEFAULT;
            $jacocoInit[48] = true;
            String str = storeTheme.toString();
            $jacocoInit[49] = true;
            String lowerCase = str.toLowerCase();
            $jacocoInit[50] = true;
            if (!storeThemeName.equals(lowerCase)) {
                $jacocoInit[51] = true;
            } else {
                z = false;
                $jacocoInit[53] = true;
                $jacocoInit[54] = true;
                return z;
            }
        }
        $jacocoInit[52] = true;
        z = true;
        $jacocoInit[54] = true;
        return z;
    }

    private C0117M updateStore(String storeName, String storeDescription, String storeImage, boolean hasNewAvatar, String storeThemeName, List<StoreLinks> storeLinksList, List<SocialChannelType> socialDeleteLinksList) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(storeName)) {
            $jacocoInit[55] = true;
            C0117M b = C0117M.m591b((Throwable) new StoreValidationException(0));
            $jacocoInit[56] = true;
            return b;
        }
        if (!hasNewAvatar) {
            $jacocoInit[57] = true;
        } else if (!TextUtils.isEmpty(storeImage)) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[59] = true;
            C0117M b2 = C0117M.m591b((Throwable) new StoreValidationException(1));
            $jacocoInit[60] = true;
            return b2;
        }
        if (hasNewAvatar) {
            $jacocoInit[61] = true;
            C0117M updateStoreWithAvatar = updateStoreWithAvatar(storeName, storeDescription, storeThemeName, storeImage, storeLinksList, socialDeleteLinksList);
            $jacocoInit[62] = true;
            return updateStoreWithAvatar;
        }
        C0117M updateStoreWithoutAvatar = updateStoreWithoutAvatar(storeName, storeDescription, storeThemeName, storeLinksList, socialDeleteLinksList);
        $jacocoInit[63] = true;
        return updateStoreWithoutAvatar;
    }

    private C0117M updateStoreWithoutAvatar(String storeName, String storeDescription, String storeThemeName, List<StoreLinks> storeLinksList, List<SocialChannelType> storeDeleteSocialLinksList) {
        boolean[] $jacocoInit = $jacocoInit();
        SimpleSetStoreRequest of = SimpleSetStoreRequest.m7489of(storeName, storeThemeName, storeDescription, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, storeLinksList, storeDeleteSocialLinksList);
        $jacocoInit[64] = true;
        C0120S observe = of.observe();
        $jacocoInit[65] = true;
        C0117M l = observe.mo3673l();
        $jacocoInit[66] = true;
        return l;
    }

    private C0117M updateStoreWithAvatar(String storeName, String storeDescription, String storeThemeName, String storeImagePath, List<StoreLinks> storeLinksList, List<SocialChannelType> socialDeleteLinksList) {
        boolean[] $jacocoInit = $jacocoInit();
        SetStoreImageRequest of = SetStoreImageRequest.m7485of(storeName, storeThemeName, storeDescription, storeImagePath, this.multipartBodyInterceptor, this.httpClient, this.converterFactory, this.requestBodyFactory, this.objectMapper, this.sharedPreferences, this.tokenInvalidator, storeLinksList, socialDeleteLinksList);
        $jacocoInit[67] = true;
        C0120S observe = of.observe();
        $jacocoInit[68] = true;
        Single n = observe.mo3678n();
        $jacocoInit[69] = true;
        C0117M b = n.mo3692b();
        $jacocoInit[70] = true;
        return b;
    }
}
