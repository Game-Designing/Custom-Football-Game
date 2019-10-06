package p005cm.aptoide.p006pt.editorial;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorial.EditorialEvent */
public class EditorialEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Type clickType;
    private final int firstVisibleItemPosition;

    /* renamed from: id */
    private final long f6411id;
    private final int lastVisibleItemPosition;
    private final List<EditorialMedia> media;
    private final String packageName;
    private final int position;
    private final String url;

    /* renamed from: cm.aptoide.pt.editorial.EditorialEvent$Type */
    public enum Type {
        ACTION,
        APPCARD,
        BUTTON,
        CANCEL,
        PAUSE,
        RESUME,
        MEDIA,
        MEDIA_LIST;

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
        boolean[] probes = Offline.getProbes(3443692821700515016L, "cm/aptoide/pt/editorial/EditorialEvent", 11);
        $jacocoData = probes;
        return probes;
    }

    public EditorialEvent(Type clickType2, String url2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clickType = clickType2;
        this.url = url2;
        this.firstVisibleItemPosition = -1;
        this.lastVisibleItemPosition = -1;
        this.media = null;
        this.f6411id = -1;
        this.packageName = "";
        this.position = -1;
        $jacocoInit[0] = true;
    }

    public EditorialEvent(Type clickType2, long id, String packageName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clickType = clickType2;
        this.f6411id = id;
        this.packageName = packageName2;
        this.url = "";
        this.firstVisibleItemPosition = -1;
        this.lastVisibleItemPosition = -1;
        this.media = null;
        this.position = -1;
        $jacocoInit[1] = true;
    }

    public EditorialEvent(Type clickType2, int firstVisibleItemPosition2, int lastVisibleItemPosition2, int position2, List<EditorialMedia> media2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.clickType = clickType2;
        this.firstVisibleItemPosition = firstVisibleItemPosition2;
        this.lastVisibleItemPosition = lastVisibleItemPosition2;
        this.position = position2;
        this.media = media2;
        String str = "";
        this.url = str;
        this.f6411id = -1;
        this.packageName = str;
        $jacocoInit[2] = true;
    }

    public Type getClickType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = this.clickType;
        $jacocoInit[3] = true;
        return type;
    }

    public String getUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[4] = true;
        return str;
    }

    public int getFirstVisiblePosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.firstVisibleItemPosition;
        $jacocoInit[5] = true;
        return i;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[6] = true;
        return i;
    }

    public int getLastVisibleItemPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.lastVisibleItemPosition;
        $jacocoInit[7] = true;
        return i;
    }

    public List<EditorialMedia> getMedia() {
        boolean[] $jacocoInit = $jacocoInit();
        List<EditorialMedia> list = this.media;
        $jacocoInit[8] = true;
        return list;
    }

    public long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f6411id;
        $jacocoInit[9] = true;
        return j;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[10] = true;
        return str;
    }
}
