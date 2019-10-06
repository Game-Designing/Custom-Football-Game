package p005cm.aptoide.p006pt.download;

import android.text.TextUtils;
import java.io.File;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;

/* renamed from: cm.aptoide.pt.download.Md5Comparator */
public class Md5Comparator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String generalFolderPath;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(449467952368294017L, "cm/aptoide/pt/download/Md5Comparator", 4);
        $jacocoData = probes;
        return probes;
    }

    public Md5Comparator(String generalFolderPath2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.generalFolderPath = generalFolderPath2;
        $jacocoInit[0] = true;
    }

    public boolean compareMd5(String md5, String fileName) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append(this.generalFolderPath);
        sb.append(fileName);
        File file = new File(sb.toString());
        $jacocoInit[1] = true;
        String computeMd5 = AlgorithmU.computeMd5(file);
        $jacocoInit[2] = true;
        boolean equals = TextUtils.equals(computeMd5, md5);
        $jacocoInit[3] = true;
        return equals;
    }
}
