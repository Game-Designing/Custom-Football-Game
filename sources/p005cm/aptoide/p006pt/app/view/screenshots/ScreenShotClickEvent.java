package p005cm.aptoide.p006pt.app.view.screenshots;

import android.net.Uri;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent */
public class ScreenShotClickEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final ArrayList<String> imagesUris;
    private final int index;
    private final Uri uri;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9157498220236195210L, "cm/aptoide/pt/app/view/screenshots/ScreenShotClickEvent", 9);
        $jacocoData = probes;
        return probes;
    }

    public ScreenShotClickEvent(ArrayList<String> imagesUris2, int index2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.imagesUris = imagesUris2;
        this.index = index2;
        this.uri = Uri.EMPTY;
        $jacocoInit[0] = true;
    }

    public ScreenShotClickEvent(Uri uri2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        this.imagesUris = new ArrayList<>();
        this.index = -1;
        this.uri = uri2;
        $jacocoInit[2] = true;
    }

    public ArrayList<String> getImagesUris() {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<String> arrayList = this.imagesUris;
        $jacocoInit[3] = true;
        return arrayList;
    }

    public int getImagesIndex() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.index;
        $jacocoInit[4] = true;
        return i;
    }

    public Uri getUri() {
        boolean[] $jacocoInit = $jacocoInit();
        Uri uri2 = this.uri;
        $jacocoInit[5] = true;
        return uri2;
    }

    public boolean isVideo() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.uri != Uri.EMPTY) {
            $jacocoInit[6] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return z;
    }
}
