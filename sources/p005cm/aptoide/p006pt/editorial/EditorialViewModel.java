package p005cm.aptoide.p006pt.editorial;

import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.editorial.EditorialViewModel */
public class EditorialViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String appName;
    private final String background;
    private final String caption;
    private final String captionColor;
    private final String cardId;
    private final List<EditorialContent> contentList;
    private final Error error;
    private final String groupId;
    private final String icon;

    /* renamed from: id */
    private final long f6412id;
    private final boolean loading;
    private final String md5sum;
    private final Obb obb;
    private final String packageName;
    private final String path;
    private final String pathAlt;
    private final List<EditorialContent> placeHolderContent;
    private final List<Integer> placeHolderPositions;
    private final boolean shouldHaveAnimation;
    private final long size;
    private final String title;
    private final int versionCode;
    private final String versionName;

    /* renamed from: cm.aptoide.pt.editorial.EditorialViewModel$Error */
    public enum Error {
        NETWORK,
        GENERIC;

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
        boolean[] probes = Offline.getProbes(4433503365670322572L, "cm/aptoide/pt/editorial/EditorialViewModel", 45);
        $jacocoData = probes;
        return probes;
    }

    public EditorialViewModel(List<EditorialContent> editorialContentList, String title2, String caption2, String background2, List<Integer> placeHolderPositions2, List<EditorialContent> placeHolderContent2, boolean shouldHaveAnimation2, String cardId2, String groupId2, String captionColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.contentList = editorialContentList;
        this.title = title2;
        this.caption = caption2;
        this.background = background2;
        this.placeHolderPositions = placeHolderPositions2;
        this.placeHolderContent = placeHolderContent2;
        this.shouldHaveAnimation = shouldHaveAnimation2;
        this.cardId = cardId2;
        this.groupId = groupId2;
        this.captionColor = captionColor2;
        String str = "";
        this.appName = str;
        this.icon = null;
        this.f6412id = -1;
        this.packageName = str;
        this.md5sum = str;
        this.versionCode = -1;
        this.size = 0;
        this.versionName = str;
        this.path = str;
        this.pathAlt = str;
        this.obb = null;
        this.loading = false;
        this.error = null;
        $jacocoInit[0] = true;
    }

    public EditorialViewModel(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = loading2;
        String str = "";
        this.title = str;
        this.caption = str;
        this.background = str;
        $jacocoInit[1] = true;
        this.placeHolderPositions = Collections.emptyList();
        $jacocoInit[2] = true;
        this.contentList = Collections.emptyList();
        $jacocoInit[3] = true;
        this.placeHolderContent = Collections.emptyList();
        this.appName = str;
        this.icon = null;
        this.f6412id = -1;
        this.groupId = str;
        this.packageName = str;
        this.md5sum = str;
        this.versionCode = -1;
        this.size = 0;
        this.versionName = str;
        this.path = str;
        this.pathAlt = str;
        this.obb = null;
        this.cardId = str;
        this.shouldHaveAnimation = false;
        this.error = null;
        this.captionColor = str;
        $jacocoInit[4] = true;
    }

    public EditorialViewModel(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.error = error2;
        this.loading = false;
        $jacocoInit[5] = true;
        this.contentList = Collections.emptyList();
        String str = "";
        this.title = str;
        this.caption = str;
        this.background = str;
        $jacocoInit[6] = true;
        this.placeHolderPositions = Collections.emptyList();
        $jacocoInit[7] = true;
        this.placeHolderContent = Collections.emptyList();
        this.appName = str;
        this.icon = null;
        this.f6412id = -1;
        this.groupId = str;
        this.packageName = str;
        this.md5sum = str;
        this.versionCode = -1;
        this.size = 0;
        this.versionName = str;
        this.path = str;
        this.pathAlt = str;
        this.cardId = str;
        this.obb = null;
        this.shouldHaveAnimation = false;
        this.captionColor = str;
        $jacocoInit[8] = true;
    }

    public EditorialViewModel(List<EditorialContent> editorialContentList, String title2, String caption2, String background2, List<Integer> placeHolderPositions2, List<EditorialContent> placeHolderContent2, String appName2, String icon2, long id, String packageName2, String md5sum2, int versionCode2, String versionName2, String path2, String pathAlt2, Obb obb2, boolean shouldHaveAnimation2, String cardId2, String groupId2, long size2, String captionColor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.contentList = editorialContentList;
        this.title = title2;
        this.caption = caption2;
        this.background = background2;
        this.placeHolderPositions = placeHolderPositions2;
        this.placeHolderContent = placeHolderContent2;
        this.appName = appName2;
        this.icon = icon2;
        this.f6412id = id;
        this.packageName = packageName2;
        this.md5sum = md5sum2;
        this.versionCode = versionCode2;
        this.versionName = versionName2;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.size = size2;
        this.obb = obb2;
        this.shouldHaveAnimation = shouldHaveAnimation2;
        this.cardId = cardId2;
        this.groupId = groupId2;
        this.captionColor = captionColor2;
        this.error = null;
        this.loading = false;
        $jacocoInit[9] = true;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasContent() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialContent> list = this.contentList;
        if (list == null) {
            $jacocoInit[10] = true;
        } else if (list.isEmpty()) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            z = true;
            $jacocoInit[14] = true;
            return z;
        }
        z = false;
        $jacocoInit[13] = true;
        $jacocoInit[14] = true;
        return z;
    }

    public EditorialContent getContent(int position) {
        EditorialContent editorialContent = (EditorialContent) this.contentList.get(position);
        $jacocoInit()[15] = true;
        return editorialContent;
    }

    /* access modifiers changed from: 0000 */
    public List<EditorialContent> getContentList() {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialContent> list = this.contentList;
        $jacocoInit[16] = true;
        return list;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[17] = true;
        return z;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[18] = true;
        return error2;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[19] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[20] = true;
        }
        $jacocoInit[21] = true;
        return z;
    }

    /* access modifiers changed from: 0000 */
    public String getCaption() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.caption;
        $jacocoInit[22] = true;
        return str;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[23] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public List<Integer> getPlaceHolderPositions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Integer> list = this.placeHolderPositions;
        $jacocoInit[24] = true;
        return list;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[25] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[26] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public long getBottomCardAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f6412id;
        $jacocoInit[27] = true;
        return j;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[28] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5sum;
        $jacocoInit[29] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public int getBottomCardVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[30] = true;
        return i;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[31] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[32] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public String getBottomCardPathAlt() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[33] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public Obb getBottomCardObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[34] = true;
        return obb2;
    }

    /* access modifiers changed from: 0000 */
    public String getBackgroundImage() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.background;
        $jacocoInit[35] = true;
        return str;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasBackgroundImage() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.background.equals("")) {
            $jacocoInit[36] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[37] = true;
        }
        $jacocoInit[38] = true;
        return z;
    }

    /* access modifiers changed from: 0000 */
    public List<EditorialContent> getPlaceHolderContent() {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialContent> list = this.placeHolderContent;
        $jacocoInit[39] = true;
        return list;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldHaveAnimation() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.shouldHaveAnimation;
        $jacocoInit[40] = true;
        return z;
    }

    public String getCardId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cardId;
        $jacocoInit[41] = true;
        return str;
    }

    public String getGroupId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.groupId;
        $jacocoInit[42] = true;
        return str;
    }

    public long getBottomCardSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[43] = true;
        return j;
    }

    public String getCaptionColor() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.captionColor;
        $jacocoInit[44] = true;
        return str;
    }
}
