package com.vungle.warren.network;

import com.google.gson.C10191u;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface VungleApi {
    @POST("{ads}")
    @Headers({"Content-Type: application/json", "Vungle-Version: 5.2.0"})
    Call<C10191u> ads(@Header("User-Agent") String str, @Path(encoded = true, value = "ads") String str2, @Body C10191u uVar);

    @POST("config")
    @Headers({"Content-Type: application/json", "Vungle-Version: 5.2.0"})
    Call<C10191u> config(@Header("User-Agent") String str, @Body C10191u uVar);

    @GET
    Call<ResponseBody> pingTPAT(@Header("User-Agent") String str, @Url String str2);

    @POST("{report_ad}")
    @Headers({"Content-Type: application/json", "Vungle-Version: 5.2.0"})
    Call<C10191u> reportAd(@Header("User-Agent") String str, @Path(encoded = true, value = "report_ad") String str2, @Body C10191u uVar);

    @GET("{new}")
    @Headers({"Content-Type: application/json", "Vungle-Version: 5.2.0"})
    Call<C10191u> reportNew(@Header("User-Agent") String str, @Path(encoded = true, value = "new") String str2, @QueryMap Map<String, String> map);

    @POST("{ri}")
    @Headers({"Content-Type: application/json", "Vungle-Version: 5.2.0"})
    /* renamed from: ri */
    Call<C10191u> mo41012ri(@Header("User-Agent") String str, @Path(encoded = true, value = "ri") String str2, @Body C10191u uVar);

    @POST("{will_play_ad}")
    @Headers({"Content-Type: application/json", "Vungle-Version: 5.2.0"})
    Call<C10191u> willPlayAd(@Header("User-Agent") String str, @Path(encoded = true, value = "will_play_ad") String str2, @Body C10191u uVar);
}
