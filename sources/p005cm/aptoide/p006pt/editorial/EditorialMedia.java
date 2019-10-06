package p005cm.aptoide.p006pt.editorial;

import com.vungle.warren.model.Advertisement;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorial.EditorialMedia */
class EditorialMedia {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String description;
    private final String thumbnail;
    private final String type;
    private final String url;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2859295536040323472L, "cm/aptoide/pt/editorial/EditorialMedia", 30);
        $jacocoData = probes;
        return probes;
    }

    public EditorialMedia(String type2, String description2, String thumbnail2, String url2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.type = type2;
        this.description = description2;
        this.thumbnail = thumbnail2;
        this.url = url2;
        $jacocoInit[0] = true;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[1] = true;
        return str;
    }

    public boolean hasType() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        if (str == null) {
            $jacocoInit[2] = true;
        } else if (str.equals("")) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            z = true;
            $jacocoInit[6] = true;
            return z;
        }
        z = false;
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        return z;
    }

    public boolean isImage() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasType()) {
            $jacocoInit[7] = true;
        } else if (!this.type.equals("image")) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            z = true;
            $jacocoInit[11] = true;
            return z;
        }
        z = false;
        $jacocoInit[10] = true;
        $jacocoInit[11] = true;
        return z;
    }

    public boolean isVideo() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasType()) {
            $jacocoInit[12] = true;
        } else if (!this.type.equals(Advertisement.KEY_VIDEO)) {
            $jacocoInit[13] = true;
        } else {
            $jacocoInit[14] = true;
            z = true;
            $jacocoInit[16] = true;
            return z;
        }
        z = false;
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
        return z;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[17] = true;
        return str;
    }

    public boolean hasDescription() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        if (str == null) {
            $jacocoInit[18] = true;
        } else if (str.equals("")) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            z = true;
            $jacocoInit[22] = true;
            return z;
        }
        z = false;
        $jacocoInit[21] = true;
        $jacocoInit[22] = true;
        return z;
    }

    public String getUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[23] = true;
        return str;
    }

    public boolean hasUrl() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        if (str == null) {
            $jacocoInit[24] = true;
        } else if (str.equals("")) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            z = true;
            $jacocoInit[28] = true;
            return z;
        }
        z = false;
        $jacocoInit[27] = true;
        $jacocoInit[28] = true;
        return z;
    }

    public String getThumbnail() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.thumbnail;
        $jacocoInit[29] = true;
        return str;
    }
}
