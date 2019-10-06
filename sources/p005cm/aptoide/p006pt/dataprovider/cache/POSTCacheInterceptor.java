package p005cm.aptoide.p006pt.dataprovider.cache;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.dataprovider.cache.POSTCacheInterceptor */
public class POSTCacheInterceptor implements Interceptor {
    private final String TAG = POSTCacheInterceptor.class.getSimpleName();
    private final Cache<Request, Response> cache;

    public POSTCacheInterceptor(Cache<Request, Response> cache2) {
        this.cache = cache2;
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!request.method().equalsIgnoreCase("POST")) {
            return chain.proceed(request);
        }
        Headers headers = request.headers();
        if (headers.size() > 0) {
            for (String bypassCacheHeaderValue : headers.values(WebService.BYPASS_HEADER_KEY)) {
                if (bypassCacheHeaderValue.equalsIgnoreCase("true")) {
                    return chain.proceed(request);
                }
            }
        }
        if (this.cache.contains(request)) {
            Response cachedResponse = (Response) this.cache.get(request);
            if (cachedResponse != null) {
                Logger.getInstance().mo2146v(this.TAG, String.format("cache hit '%s'", new Object[]{request.url()}));
                return cachedResponse;
            }
            Logger.getInstance().mo2146v(this.TAG, String.format("cache hit but with null result '%s'", new Object[]{request.url()}));
        }
        Logger.getInstance().mo2146v(this.TAG, String.format("cache miss '%s'", new Object[]{request.url()}));
        Response response = chain.proceed(request);
        if (response.isSuccessful()) {
            this.cache.put(request, response);
        }
        return response;
    }
}
