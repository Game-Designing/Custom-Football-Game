package p005cm.aptoide.p006pt.util;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.xmlpull.v1.XmlPullParserException;
import p005cm.aptoide.p006pt.database.realm.Notification;

/* renamed from: cm.aptoide.pt.util.PreferencesXmlParser */
public class PreferencesXmlParser {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String DEFAULT_VALUE = "defaultValue";
    private final String KEY = Notification.KEY;
    private final String NAMESPACE = "http://schemas.android.com/apk/res/android";
    private int eventType = -1;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1876300134341036055L, "cm/aptoide/pt/util/PreferencesXmlParser", 10);
        $jacocoData = probes;
        return probes;
    }

    public PreferencesXmlParser() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public List<String[]> parse(XmlResourceParser parser) throws IOException, XmlPullParserException {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList<String[]> data = new ArrayList<>();
        $jacocoInit[1] = true;
        while (true) {
            int i = this.eventType;
            if (i != 1) {
                if (i != 2) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    String str = "http://schemas.android.com/apk/res/android";
                    String defaultValue = parser.getAttributeValue(str, "defaultValue");
                    $jacocoInit[4] = true;
                    String key = parser.getAttributeValue(str, Notification.KEY);
                    if (defaultValue == null) {
                        $jacocoInit[5] = true;
                    } else {
                        String[] keyValue = {key, defaultValue};
                        $jacocoInit[6] = true;
                        data.add(keyValue);
                        $jacocoInit[7] = true;
                    }
                }
                this.eventType = parser.next();
                $jacocoInit[8] = true;
            } else {
                $jacocoInit[9] = true;
                return data;
            }
        }
    }
}
