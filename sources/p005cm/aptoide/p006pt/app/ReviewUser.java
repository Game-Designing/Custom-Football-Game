package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.ReviewUser */
public class ReviewUser {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String avatar;

    /* renamed from: id */
    private final long f4673id;
    private final String name;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(406611724604958350L, "cm/aptoide/pt/app/ReviewUser", 4);
        $jacocoData = probes;
        return probes;
    }

    public ReviewUser(long id, String avatar2, String name2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f4673id = id;
        this.avatar = avatar2;
        this.name = name2;
        $jacocoInit[0] = true;
    }

    public long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f4673id;
        $jacocoInit[1] = true;
        return j;
    }

    public String getAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.avatar;
        $jacocoInit[2] = true;
        return str;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[3] = true;
        return str;
    }
}
