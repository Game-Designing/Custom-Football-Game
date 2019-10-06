package p005cm.aptoide.p006pt.view.entry;

import android.content.Intent;
import android.os.Bundle;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.view.ActivityView;

/* renamed from: cm.aptoide.pt.view.entry.EntryActivity */
public class EntryActivity extends ActivityView {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8764624284658634738L, "cm/aptoide/pt/view/entry/EntryActivity", 6);
        $jacocoData = probes;
        return probes;
    }

    public EntryActivity() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        EntryPointChooser entryPointChooser = ((AptoideApplication) getApplicationContext()).getEntryPointChooser();
        $jacocoInit[2] = true;
        Intent intent = new Intent(this, entryPointChooser.getEntryPoint());
        $jacocoInit[3] = true;
        startActivity(intent);
        $jacocoInit[4] = true;
        finish();
        $jacocoInit[5] = true;
    }
}
