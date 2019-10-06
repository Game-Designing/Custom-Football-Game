package p005cm.aptoide.p006pt.billing.payment;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.PaymentServiceSelector;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.payment.SharedPreferencesPaymentServiceSelector */
public class SharedPreferencesPaymentServiceSelector implements PaymentServiceSelector {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String SELECTED_SERVICE_TYPE = "SELECTED_SERVICE_TYPE";
    private final String defaultServiceType;
    private final Preferences preferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1048317126800196883L, "cm/aptoide/pt/billing/payment/SharedPreferencesPaymentServiceSelector", 17);
        $jacocoData = probes;
        return probes;
    }

    public SharedPreferencesPaymentServiceSelector(String defaultServiceType2, Preferences preferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.defaultServiceType = defaultServiceType2;
        this.preferences = preferences2;
        $jacocoInit[0] = true;
    }

    public C0120S<PaymentService> getSelectedService(List<PaymentService> services) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<PaymentService> i = getSelectedServiceName().mo3668i(new C2350p(this, services));
        $jacocoInit[1] = true;
        return i;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11210a(List services, String serviceName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S service = getService(services, serviceName);
        String str = this.defaultServiceType;
        $jacocoInit[11] = true;
        C0120S service2 = getService(services, str);
        $jacocoInit[12] = true;
        C0120S f = service.mo3659f(service2);
        $jacocoInit[13] = true;
        C0120S f2 = f.mo3659f(C0120S.m652c(services.get(0)));
        $jacocoInit[14] = true;
        C0120S d = f2.mo3647d();
        $jacocoInit[15] = true;
        Single n = d.mo3678n();
        $jacocoInit[16] = true;
        return n;
    }

    public C0117M selectService(PaymentService service) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = this.preferences.save(SELECTED_SERVICE_TYPE, service.getType());
        $jacocoInit[2] = true;
        return save;
    }

    private C0120S<String> getSelectedServiceName() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<String> string = this.preferences.getString(SELECTED_SERVICE_TYPE, null);
        $jacocoInit[3] = true;
        return string;
    }

    private C0120S<PaymentService> getService(List<PaymentService> services, String serviceName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) services);
        C2351q qVar = new C2351q(serviceName);
        $jacocoInit[4] = true;
        C0120S<PaymentService> d = a.mo3653d((C0132p<? super T, Boolean>) qVar);
        $jacocoInit[5] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m7021a(String serviceName, PaymentService service) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (serviceName == null) {
            $jacocoInit[6] = true;
        } else if (!serviceName.equals(service.getType())) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[10] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[9] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[10] = true;
        return valueOf2;
    }
}
