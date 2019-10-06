package p005cm.aptoide.p006pt.social.data;

import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.social.data.AdResponse */
public class AdResponse {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Status status;
    private final View view;

    /* renamed from: cm.aptoide.pt.social.data.AdResponse$Status */
    public enum Status {
        error,
        ok;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-201986362213236244L, "cm/aptoide/pt/social/data/AdResponse", 3);
        $jacocoData = probes;
        return probes;
    }

    public AdResponse(View view2, Status status2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.status = status2;
        $jacocoInit[0] = true;
    }

    public View getView() {
        boolean[] $jacocoInit = $jacocoInit();
        View view2 = this.view;
        $jacocoInit[1] = true;
        return view2;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status2 = this.status;
        $jacocoInit[2] = true;
        return status2;
    }
}
