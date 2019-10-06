package p005cm.aptoide.p006pt.editorial;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.editorial.EditorialContent */
public class EditorialContent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String actionTitle;
    private final float avg;
    private final String graphic;
    private final String icon;

    /* renamed from: id */
    private final long f6410id;
    private final boolean isPlaceHolder;
    private final String md5sum;
    private final List<EditorialMedia> media;
    private final String message;
    private final String name;
    private final Obb obb;
    private final String packageName;
    private final String path;
    private final String pathAlt;
    private final int position;
    private final long size;
    private final long storeId;
    private final String storeName;
    private final String title;
    private final String type;
    private final String url;
    private final int verCode;
    private final String verName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3368479051579808765L, "cm/aptoide/pt/editorial/EditorialContent", 55);
        $jacocoData = probes;
        return probes;
    }

    public EditorialContent(String title2, List<EditorialMedia> media2, String message2, String type2, long id, String name2, String icon2, float avg2, String packageName2, long size2, String graphic2, Obb obb2, long storeId2, String storeName2, String verName2, int verCode2, String path2, String pathAlt2, String md5sum2, String actionTitle2, String url2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.media = media2;
        this.message = message2;
        this.type = type2;
        this.f6410id = id;
        this.name = name2;
        this.icon = icon2;
        this.avg = avg2;
        this.packageName = packageName2;
        this.size = size2;
        this.graphic = graphic2;
        this.obb = obb2;
        this.storeId = storeId2;
        this.storeName = storeName2;
        this.verName = verName2;
        this.verCode = verCode2;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.md5sum = md5sum2;
        this.actionTitle = actionTitle2;
        this.url = url2;
        this.position = position2;
        this.isPlaceHolder = true;
        $jacocoInit[0] = true;
    }

    public EditorialContent(String title2, List<EditorialMedia> media2, String message2, String type2, String actionTitle2, String url2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.media = media2;
        this.message = message2;
        this.type = type2;
        this.actionTitle = actionTitle2;
        this.url = url2;
        this.position = position2;
        this.isPlaceHolder = false;
        this.f6410id = -1;
        String str = "";
        this.name = str;
        this.icon = null;
        this.avg = 0.0f;
        this.packageName = str;
        this.size = 0;
        this.graphic = str;
        this.obb = null;
        this.storeId = -1;
        this.storeName = str;
        this.verName = str;
        this.verCode = -1;
        this.path = str;
        this.pathAlt = str;
        this.md5sum = str;
        $jacocoInit[1] = true;
    }

    public EditorialContent(String title2, List<EditorialMedia> media2, String message2, String type2, long id, String name2, String icon2, float avg2, String packageName2, long size2, String graphic2, Obb obb2, long storeId2, String storeName2, String verName2, int verCode2, String path2, String pathAlt2, String md5sum2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.media = media2;
        this.message = message2;
        this.type = type2;
        this.f6410id = id;
        this.name = name2;
        this.icon = icon2;
        this.avg = avg2;
        this.packageName = packageName2;
        this.size = size2;
        this.graphic = graphic2;
        this.obb = obb2;
        this.storeId = storeId2;
        this.storeName = storeName2;
        this.verName = verName2;
        this.verCode = verCode2;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.md5sum = md5sum2;
        this.position = position2;
        this.isPlaceHolder = true;
        String str = "";
        this.actionTitle = str;
        this.url = str;
        $jacocoInit[2] = true;
    }

    public EditorialContent(String title2, List<EditorialMedia> media2, String message2, String type2, int position2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.media = media2;
        this.message = message2;
        this.type = type2;
        this.position = position2;
        this.isPlaceHolder = false;
        this.f6410id = -1;
        String str = "";
        this.name = str;
        this.icon = null;
        this.avg = 0.0f;
        this.packageName = str;
        this.size = 0;
        this.graphic = str;
        this.obb = null;
        this.storeId = -1;
        this.storeName = str;
        this.verName = str;
        this.verCode = -1;
        this.path = str;
        this.pathAlt = str;
        this.md5sum = str;
        this.actionTitle = str;
        this.url = str;
        $jacocoInit[3] = true;
    }

    public String getMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.message;
        $jacocoInit[4] = true;
        return str;
    }

    public boolean hasMessage() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.message;
        if (str == null) {
            $jacocoInit[5] = true;
        } else if (str.equals("")) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            z = true;
            $jacocoInit[9] = true;
            return z;
        }
        z = false;
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        return z;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[10] = true;
        return str;
    }

    public boolean isPlaceHolderType() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isPlaceHolder;
        $jacocoInit[11] = true;
        return z;
    }

    public List<EditorialMedia> getMedia() {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialMedia> list = this.media;
        $jacocoInit[12] = true;
        return list;
    }

    public boolean hasMedia() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialMedia> list = this.media;
        if (list == null) {
            $jacocoInit[13] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            z = true;
            $jacocoInit[17] = true;
            return z;
        }
        z = false;
        $jacocoInit[16] = true;
        $jacocoInit[17] = true;
        return z;
    }

    public boolean hasListOfMedia() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasMedia()) {
            $jacocoInit[18] = true;
        } else if (this.media.size() <= 1) {
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

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[23] = true;
        return str;
    }

    public boolean hasTitle() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
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

    public boolean hasAnyMediaDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[29] = true;
        for (EditorialMedia editorialMedia : this.media) {
            $jacocoInit[30] = true;
            if (editorialMedia.hasDescription()) {
                $jacocoInit[31] = true;
                return true;
            }
            $jacocoInit[32] = true;
        }
        $jacocoInit[33] = true;
        return false;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[34] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[35] = true;
        return str;
    }

    public long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f6410id;
        $jacocoInit[36] = true;
        return j;
    }

    public float getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.avg;
        $jacocoInit[37] = true;
        return f;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[38] = true;
        return str;
    }

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[39] = true;
        return j;
    }

    public String getGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.graphic;
        $jacocoInit[40] = true;
        return str;
    }

    public Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[41] = true;
        return obb2;
    }

    public long getStoreId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.storeId;
        $jacocoInit[42] = true;
        return j;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[43] = true;
        return str;
    }

    public String getVerName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.verName;
        $jacocoInit[44] = true;
        return str;
    }

    public int getVerCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.verCode;
        $jacocoInit[45] = true;
        return i;
    }

    public String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[46] = true;
        return str;
    }

    public String getPathAlt() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[47] = true;
        return str;
    }

    public String getMd5sum() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5sum;
        $jacocoInit[48] = true;
        return str;
    }

    public String getActionTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.actionTitle;
        $jacocoInit[49] = true;
        return str;
    }

    public String getActionUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[50] = true;
        return str;
    }

    public boolean hasAction() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.actionTitle.equals("")) {
            $jacocoInit[51] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[52] = true;
        }
        $jacocoInit[53] = true;
        return z;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[54] = true;
        return i;
    }
}
