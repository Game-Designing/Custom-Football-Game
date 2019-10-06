package p005cm.aptoide.p006pt.view.entry;

import android.app.Activity;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.MainActivity;
import p005cm.aptoide.p006pt.view.OpenGLES20Activity;

/* renamed from: cm.aptoide.pt.view.entry.EntryPointChooser */
public class EntryPointChooser {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final SupportedExtensions supportedExtensions;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3374999381015846910L, "cm/aptoide/pt/view/entry/EntryPointChooser", 3);
        $jacocoData = probes;
        return probes;
    }

    public EntryPointChooser(SupportedExtensions supportedExtensions2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.supportedExtensions = supportedExtensions2;
        $jacocoInit[0] = true;
    }

    public Class<? extends Activity> getEntryPoint() {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.supportedExtensions.isDefined()) {
            Class<OpenGLES20Activity> cls = OpenGLES20Activity.class;
            $jacocoInit[1] = true;
            return cls;
        }
        Class<MainActivity> cls2 = MainActivity.class;
        $jacocoInit[2] = true;
        return cls2;
    }
}
