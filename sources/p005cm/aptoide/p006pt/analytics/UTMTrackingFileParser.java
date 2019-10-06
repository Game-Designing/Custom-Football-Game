package p005cm.aptoide.p006pt.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.analytics.UTMTrackingFileParser */
public class UTMTrackingFileParser {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private BufferedReader bufferedReader;
    private String utm_line;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1532802133145279911L, "cm/aptoide/pt/analytics/UTMTrackingFileParser", 12);
        $jacocoData = probes;
        return probes;
    }

    public UTMTrackingFileParser(InputStream inputStreamToParse) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStreamToParse));
        try {
            $jacocoInit[1] = true;
            this.utm_line = this.bufferedReader.readLine();
            $jacocoInit[2] = true;
        } catch (IOException e) {
            $jacocoInit[3] = true;
            e.printStackTrace();
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
    }

    public String valueExtracter(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] utms = this.utm_line.split("&");
        int length = utms.length;
        $jacocoInit[6] = true;
        int i = 0;
        while (i < length) {
            String utm = utms[i];
            $jacocoInit[7] = true;
            if (utm.contains(key)) {
                $jacocoInit[8] = true;
                String substring = utm.substring(key.length() + 1);
                $jacocoInit[9] = true;
                return substring;
            }
            i++;
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
        return "unknown";
    }
}
