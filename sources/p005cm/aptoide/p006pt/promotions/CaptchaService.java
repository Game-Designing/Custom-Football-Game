package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* renamed from: cm.aptoide.pt.promotions.CaptchaService */
public class CaptchaService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String captchaUrl;
    private IdsRepository idsRepository;
    private ServiceInterface service;

    /* renamed from: cm.aptoide.pt.promotions.CaptchaService$ResponseBody */
    public static class ResponseBody {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private String captchaUrl;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-5595811435710944092L, "cm/aptoide/pt/promotions/CaptchaService$ResponseBody", 3);
            $jacocoData = probes;
            return probes;
        }

        public ResponseBody() {
            $jacocoInit()[0] = true;
        }

        public String getCaptchaUrl() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.captchaUrl;
            $jacocoInit[1] = true;
            return str;
        }

        public void setCaptchaUrl(String captchaUrl2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.captchaUrl = captchaUrl2;
            $jacocoInit[2] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.promotions.CaptchaService$ServiceInterface */
    public interface ServiceInterface {
        @GET("captcha/create/{user_id}")
        C0120S<Response<ResponseBody>> getCaptcha(@Path("user_id") String str);
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4445122824394184738L, "cm/aptoide/pt/promotions/CaptchaService", 13);
        $jacocoData = probes;
        return probes;
    }

    public CaptchaService(ServiceInterface service2, IdsRepository idsRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.service = service2;
        this.idsRepository = idsRepository2;
        $jacocoInit[0] = true;
    }

    public Single<String> getCaptcha() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S captcha = this.service.getCaptcha(this.idsRepository.getUniqueIdentifier());
        $jacocoInit[1] = true;
        C0120S b = captcha.mo3634b(Schedulers.m776io());
        C4511b bVar = C4511b.f8128a;
        $jacocoInit[2] = true;
        C0120S j = b.mo3669j(bVar);
        $jacocoInit[3] = true;
        Single<String> n = j.mo3678n();
        $jacocoInit[4] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ String m8792a(Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!response.isSuccessful()) {
            $jacocoInit[7] = true;
        } else if (response.body() == null) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            ResponseBody responseBody = (ResponseBody) response.body();
            $jacocoInit[10] = true;
            String captchaUrl2 = responseBody.getCaptchaUrl();
            $jacocoInit[11] = true;
            return captchaUrl2;
        }
        $jacocoInit[12] = true;
        return "";
    }

    public String getCaptchaUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.captchaUrl;
        $jacocoInit[5] = true;
        return str;
    }

    public void saveCaptchaUrl(String captchaUrl2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.captchaUrl = captchaUrl2;
        $jacocoInit[6] = true;
    }
}
