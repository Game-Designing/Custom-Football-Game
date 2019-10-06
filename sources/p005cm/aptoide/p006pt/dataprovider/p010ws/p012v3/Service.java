package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.OAuth;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TermsAndConditionsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.GenericResponseV2;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p026rx.C0120S;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.Service */
public interface Service {
    @FormUrlEncoded
    @POST("addApkFlag")
    C0120S<GenericResponseV2> addApkFlag(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("changeUserBirthdate")
    C0120S<BaseV3Response> changeUserBirthdate(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("changeUserNewsletterSubscription")
    C0120S<BaseV3Response> changeUserNewsletterSubscription(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("checkUserCredentials")
    C0120S<CheckUserCredentialsJson> checkUserCredentials(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("payProduct")
    C0120S<TransactionResponse> createTransaction(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("createUser")
    C0120S<BaseV3Response> createUser(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @POST("createUser")
    @Multipart
    C0120S<BaseV3Response> createUserWithFile(@Part MultipartBody.Part part, @PartMap HashMapNotNull<String, RequestBody> hashMapNotNull, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("getApkInfo")
    C0120S<PaidApp> getApkInfo(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("getPushNotifications")
    C0120S<GetPushNotificationsResponse> getPushNotifications(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("getUserInfo")
    C0120S<TermsAndConditionsResponse> getTermsAndConditionsStatus(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("checkProductPayment")
    C0120S<TransactionResponse> getTransaction(@FieldMap BaseBody baseBody);

    @FormUrlEncoded
    @POST("getUserInfo")
    C0120S<CheckUserCredentialsJson> getUserInfo(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("oauth2Authentication")
    C0120S<OAuth> oauth2Authentication(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);

    @FormUrlEncoded
    @POST("acceptUserAgreement")
    C0120S<BaseV3Response> updateTermsAndConditions(@FieldMap BaseBody baseBody, @Header("X-Bypass-Cache") boolean z);
}
