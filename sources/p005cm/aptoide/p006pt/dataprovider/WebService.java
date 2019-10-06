package p005cm.aptoide.p006pt.dataprovider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.Callable;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p387a.p389b.C14522a;
import p026rx.schedulers.Schedulers;
import retrofit2.CallAdapter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/* renamed from: cm.aptoide.pt.dataprovider.WebService */
public abstract class WebService<T, U> {
    public static final String BYPASS_HEADER_KEY = "X-Bypass-Cache";
    public static final String BYPASS_HEADER_VALUE = "true";
    private static Factory defaultConverterFactory;
    private final String baseHost;
    private final Class<T> clazz;
    protected final Factory converterFactory;
    private final OkHttpClient httpClient;
    protected Retrofit retrofit;

    /* access modifiers changed from: protected */
    public abstract C0120S<U> loadDataFromNetwork(T t, boolean z);

    protected WebService(Class<T> clazz2, OkHttpClient httpClient2, Factory converterFactory2, String baseHost2) {
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.clazz = clazz2;
        this.baseHost = baseHost2;
    }

    public static Factory getDefaultConverter() {
        if (defaultConverterFactory == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US));
            defaultConverterFactory = JacksonConverterFactory.create(objectMapper);
        }
        return defaultConverterFactory;
    }

    /* access modifiers changed from: protected */
    public OkHttpClient getHttpClient() {
        return this.httpClient;
    }

    public C0120S<U> observe() {
        return observe(false);
    }

    public C0120S<U> observe(boolean bypassCache) {
        return createServiceObservable().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2840c<Object,Object>(this, bypassCache)).mo3634b(Schedulers.m776io());
    }

    private C0120S<T> createServiceObservable() {
        return C0120S.m633a((Callable<? extends T>) new C2837a<Object>(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: prepareAndLoad */
    public C0120S<U> mo1143a(T t, boolean bypassCache) {
        onLoadDataFromNetwork();
        return loadDataFromNetwork(t, bypassCache);
    }

    /* access modifiers changed from: private */
    /* renamed from: createService */
    public T mo1142a() {
        return getRetrofit(this.httpClient, this.converterFactory, RxJavaCallAdapterFactory.create(), this.baseHost).create(this.clazz);
    }

    private void onLoadDataFromNetwork() {
    }

    private Retrofit getRetrofit(OkHttpClient httpClient2, Factory converterFactory2, CallAdapter.Factory factory, String baseHost2) {
        if (this.retrofit == null) {
            this.retrofit = new Builder().baseUrl(baseHost2).client(httpClient2).addCallAdapterFactory(factory).addConverterFactory(converterFactory2).build();
        }
        return this.retrofit;
    }

    @Deprecated
    public void execute(SuccessRequestListener<U> successRequestListener, boolean bypassCache) {
        execute(successRequestListener, defaultErrorRequestListener(), bypassCache);
    }

    @Deprecated
    public void execute(SuccessRequestListener<U> successRequestListener, ErrorRequestListener errorRequestListener, boolean bypassCache) {
        observe(bypassCache).mo3616a(C14522a.m46170a()).mo3626a((C0129b<? super T>) successRequestListener, (C0129b<Throwable>) new C2839b<Throwable>(errorRequestListener));
    }

    private ErrorRequestListener defaultErrorRequestListener() {
        return C2841d.f6079a;
    }

    /* renamed from: a */
    static /* synthetic */ void m256a(Throwable e) {
        Logger.getInstance().mo2140e(ErrorRequestListener.class.getName(), "Erro por implementar");
        e.printStackTrace();
    }

    @Deprecated
    public void execute(SuccessRequestListener<U> successRequestListener, ErrorRequestListener errorRequestListener) {
        execute(successRequestListener, errorRequestListener, false);
    }

    /* access modifiers changed from: protected */
    public boolean isNoNetworkException(Throwable throwable) {
        return throwable instanceof UnknownHostException;
    }
}
