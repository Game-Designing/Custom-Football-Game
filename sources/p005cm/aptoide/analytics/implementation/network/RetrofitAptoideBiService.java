package p005cm.aptoide.analytics.implementation.network;

import java.text.DateFormat;
import java.util.Date;
import p005cm.aptoide.analytics.implementation.AptoideBiEventService;
import p005cm.aptoide.analytics.implementation.data.Event;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* renamed from: cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService */
public class RetrofitAptoideBiService implements AptoideBiEventService {
    private final AnalyticsBodyInterceptor analyticsBodyInterceptor;
    private DateFormat dateFormat;
    private final ServiceV7 serviceV7;

    /* renamed from: cm.aptoide.analytics.implementation.network.RetrofitAptoideBiService$ServiceV7 */
    public interface ServiceV7 {
        @POST("user/addEvent/name={name}/action={action}/context={context}")
        C0120S<Response<Void>> sendEvent(@Path("name") String str, @Path("action") String str2, @Path("context") String str3, @Body AnalyticsEventRequestBody analyticsEventRequestBody);
    }

    public RetrofitAptoideBiService(DateFormat dateFormat2, ServiceV7 serviceV72, AnalyticsBodyInterceptor analyticsBodyInterceptor2) {
        this.dateFormat = dateFormat2;
        this.serviceV7 = serviceV72;
        this.analyticsBodyInterceptor = analyticsBodyInterceptor2;
    }

    public C0117M send(Event event) {
        return this.analyticsBodyInterceptor.intercept(new AnalyticsEventRequestBody(event.getData(), this.dateFormat.format(new Date(event.getTimeStamp())))).mo3693b((C0132p<? super T, ? extends C0117M>) new C1357b<Object,Object>(this, event));
    }

    /* renamed from: a */
    public /* synthetic */ Object mo9416a(Event event, Object analyticsBody) {
        return this.serviceV7.sendEvent(event.getEventName(), event.getAction().name(), event.getContext(), (AnalyticsEventRequestBody) analyticsBody).mo3671k(C1356a.f4252a).mo3673l();
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6143a(Throwable throwable) {
        if (throwable instanceof IllegalStateException) {
            return C0120S.m631a(throwable);
        }
        return C0120S.m651c();
    }
}
