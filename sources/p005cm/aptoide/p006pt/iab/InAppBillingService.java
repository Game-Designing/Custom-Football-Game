package p005cm.aptoide.p006pt.iab;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingBinder;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingSerializer;
import p005cm.aptoide.p006pt.billing.view.PaymentThrowableCodeMapper;
import p005cm.aptoide.p006pt.crashreports.CrashReport;

/* renamed from: cm.aptoide.pt.iab.InAppBillingService */
public class InAppBillingService extends Service {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(351325617949326632L, "cm/aptoide/pt/iab/InAppBillingService", 6);
        $jacocoData = probes;
        return probes;
    }

    public InAppBillingService() {
        $jacocoInit()[0] = true;
    }

    public IBinder onBind(Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        ExternalBillingSerializer inAppBillingSerializer = ((AptoideApplication) getApplicationContext()).getInAppBillingSerializer();
        $jacocoInit[2] = true;
        PaymentThrowableCodeMapper paymentThrowableCodeMapper = ((AptoideApplication) getApplicationContext()).getPaymentThrowableCodeMapper();
        $jacocoInit[3] = true;
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[4] = true;
        ExternalBillingBinder externalBillingBinder = new ExternalBillingBinder(this, inAppBillingSerializer, paymentThrowableCodeMapper, instance, 3, ((AptoideApplication) getApplicationContext()).getBillingAnalytics(), getPackageManager());
        $jacocoInit[5] = true;
        return externalBillingBinder;
    }
}
