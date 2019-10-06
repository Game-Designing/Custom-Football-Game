package p005cm.aptoide.p006pt.billing.view;

import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.exception.BillingException;
import p005cm.aptoide.p006pt.billing.exception.ProductNotFoundException;
import p005cm.aptoide.p006pt.billing.exception.PurchaseNotFoundException;

/* renamed from: cm.aptoide.pt.billing.view.PaymentThrowableCodeMapper */
public class PaymentThrowableCodeMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3552056240998127395L, "cm/aptoide/pt/billing/view/PaymentThrowableCodeMapper", 23);
        $jacocoData = probes;
        return probes;
    }

    public PaymentThrowableCodeMapper() {
        $jacocoInit()[0] = true;
    }

    public int map(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        int errorCode = 6;
        if (!(throwable instanceof IOException)) {
            $jacocoInit[1] = true;
        } else {
            errorCode = 2;
            $jacocoInit[2] = true;
        }
        if (!(throwable instanceof ProductNotFoundException)) {
            $jacocoInit[3] = true;
        } else {
            errorCode = 4;
            $jacocoInit[4] = true;
        }
        if (!(throwable instanceof IllegalArgumentException)) {
            $jacocoInit[5] = true;
        } else {
            errorCode = 5;
            $jacocoInit[6] = true;
        }
        if (!(throwable instanceof PurchaseNotFoundException)) {
            $jacocoInit[7] = true;
        } else {
            errorCode = 8;
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
        return errorCode;
    }

    public Throwable map(int errorCode) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown error code ");
        sb.append(errorCode);
        Throwable throwable = new BillingException(sb.toString());
        if (errorCode != 2) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            throwable = new IOException();
            $jacocoInit[12] = true;
        }
        if (errorCode != 4) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            throwable = new ProductNotFoundException();
            $jacocoInit[15] = true;
        }
        if (errorCode != 5) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            throwable = new IllegalArgumentException();
            $jacocoInit[18] = true;
        }
        if (errorCode != 8) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            throwable = new PurchaseNotFoundException();
            $jacocoInit[21] = true;
        }
        $jacocoInit[22] = true;
        return throwable;
    }
}
