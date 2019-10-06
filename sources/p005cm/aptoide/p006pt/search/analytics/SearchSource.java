package p005cm.aptoide.p006pt.search.analytics;

/* renamed from: cm.aptoide.pt.search.analytics.SearchSource */
public enum SearchSource {
    WIDGET("widget"),
    SHORTCUT("shortcut"),
    DEEP_LINK("deep_link"),
    SEARCH_ICON(r5),
    SEARCH_TOOLBAR(r5),
    BOTTOM_NAVIGATION("vanilla_bottom_nav");
    
    private final String identifier;

    static {
        boolean[] $jacocoInit;
        $jacocoInit[5] = true;
    }

    private SearchSource(String identifier2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.identifier = identifier2;
        $jacocoInit[2] = true;
    }

    public String getIdentifier() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.identifier;
        $jacocoInit[3] = true;
        return str;
    }
}
