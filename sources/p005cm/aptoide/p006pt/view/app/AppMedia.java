package p005cm.aptoide.p006pt.view.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppMedia */
public class AppMedia {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<AppScreenshot> appScreenshots;
    private final List<AppVideo> appVideos;
    private final String description;
    private final List<String> keywords;
    private final String news;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3094593210535515727L, "cm/aptoide/pt/view/app/AppMedia", 6);
        $jacocoData = probes;
        return probes;
    }

    public AppMedia(String description2, List<String> keywords2, String news2, List<AppScreenshot> screenshots, List<AppVideo> videos) {
        boolean[] $jacocoInit = $jacocoInit();
        this.description = description2;
        this.keywords = keywords2;
        this.news = news2;
        this.appScreenshots = screenshots;
        this.appVideos = videos;
        $jacocoInit[0] = true;
    }

    public List<AppVideo> getVideos() {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppVideo> list = this.appVideos;
        $jacocoInit[1] = true;
        return list;
    }

    public List<AppScreenshot> getScreenshots() {
        boolean[] $jacocoInit = $jacocoInit();
        List<AppScreenshot> list = this.appScreenshots;
        $jacocoInit[2] = true;
        return list;
    }

    public String getNews() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.news;
        $jacocoInit[3] = true;
        return str;
    }

    public List<String> getKeywords() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.keywords;
        $jacocoInit[4] = true;
        return list;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[5] = true;
        return str;
    }
}
