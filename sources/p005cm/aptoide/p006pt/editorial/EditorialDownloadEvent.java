package p005cm.aptoide.p006pt.editorial;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.editorial.EditorialEvent.Type;

/* renamed from: cm.aptoide.pt.editorial.EditorialDownloadEvent */
public class EditorialDownloadEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Action action;
    private final long appId;
    private final String appName;
    private final Type button;
    private final String icon;
    private final String md5sum;
    private final Obb obb;
    private final String packageName;
    private final String path;
    private final String pathAlt;
    private final long size;
    private final int verCode;
    private final String verName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-21406714556879772L, "cm/aptoide/pt/editorial/EditorialDownloadEvent", 28);
        $jacocoData = probes;
        return probes;
    }

    public EditorialDownloadEvent(Type button2, String appName2, String packageName2, String md5sum2, String icon2, String verName2, int verCode2, String path2, String pathAlt2, Obb obb2, long size2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.button = button2;
        this.appName = appName2;
        this.packageName = packageName2;
        this.md5sum = md5sum2;
        this.icon = icon2;
        this.verName = verName2;
        this.verCode = verCode2;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.obb = obb2;
        this.appId = -1;
        this.action = null;
        this.size = size2;
        $jacocoInit[0] = true;
    }

    public EditorialDownloadEvent(EditorialViewModel editorialViewModel, Action action2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.button = null;
        $jacocoInit[1] = true;
        this.appName = editorialViewModel.getBottomCardAppName();
        $jacocoInit[2] = true;
        this.packageName = editorialViewModel.getBottomCardPackageName();
        $jacocoInit[3] = true;
        this.md5sum = editorialViewModel.getBottomCardMd5();
        $jacocoInit[4] = true;
        this.icon = editorialViewModel.getBottomCardIcon();
        $jacocoInit[5] = true;
        this.verName = editorialViewModel.getBottomCardVersionName();
        $jacocoInit[6] = true;
        this.verCode = editorialViewModel.getBottomCardVersionCode();
        $jacocoInit[7] = true;
        this.path = editorialViewModel.getBottomCardPath();
        $jacocoInit[8] = true;
        this.pathAlt = editorialViewModel.getBottomCardPathAlt();
        $jacocoInit[9] = true;
        this.obb = editorialViewModel.getBottomCardObb();
        $jacocoInit[10] = true;
        this.appId = editorialViewModel.getBottomCardAppId();
        $jacocoInit[11] = true;
        this.size = editorialViewModel.getBottomCardSize();
        this.action = action2;
        $jacocoInit[12] = true;
    }

    public EditorialDownloadEvent(Type button2, String packageName2, String md5, int verCode2, long appId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.button = button2;
        String str = "";
        this.appName = str;
        this.packageName = packageName2;
        this.md5sum = md5;
        this.icon = str;
        this.verName = str;
        this.size = 0;
        this.verCode = verCode2;
        this.path = str;
        this.pathAlt = str;
        this.obb = null;
        this.appId = appId2;
        this.action = null;
        $jacocoInit[13] = true;
    }

    public EditorialDownloadEvent(Type button2, String appName2, String packageName2, String md5sum2, String icon2, String verName2, int verCode2, String path2, String pathAlt2, Obb obb2, Action action2, long size2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.button = button2;
        this.appName = appName2;
        this.packageName = packageName2;
        this.md5sum = md5sum2;
        this.icon = icon2;
        this.verName = verName2;
        this.verCode = verCode2;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.obb = obb2;
        this.appId = -1;
        this.action = action2;
        this.size = size2;
        $jacocoInit[14] = true;
    }

    public Type getClickType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = this.button;
        $jacocoInit[15] = true;
        return type;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[16] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[17] = true;
        return str;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5sum;
        $jacocoInit[18] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[19] = true;
        return str;
    }

    public String getVerName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.verName;
        $jacocoInit[20] = true;
        return str;
    }

    public int getVerCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.verCode;
        $jacocoInit[21] = true;
        return i;
    }

    public String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[22] = true;
        return str;
    }

    public String getPathAlt() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[23] = true;
        return str;
    }

    public Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[24] = true;
        return obb2;
    }

    public Action getAction() {
        boolean[] $jacocoInit = $jacocoInit();
        Action action2 = this.action;
        $jacocoInit[25] = true;
        return action2;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[26] = true;
        return j;
    }

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[27] = true;
        return j;
    }
}
