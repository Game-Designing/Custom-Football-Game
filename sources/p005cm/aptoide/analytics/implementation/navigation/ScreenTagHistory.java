package p005cm.aptoide.analytics.implementation.navigation;

/* renamed from: cm.aptoide.analytics.implementation.navigation.ScreenTagHistory */
public class ScreenTagHistory {
    private static final String NO_HISTORY = "NO_HISTORY";
    private String fragment;
    private String store;
    private String tag;

    /* renamed from: cm.aptoide.analytics.implementation.navigation.ScreenTagHistory$Builder */
    public static class Builder {
        public static final String APTOIDE_MAIN_HISTORY_STORE = "aptoide_main";

        private Builder() {
        }

        public static ScreenTagHistory build(String fragment) {
            return build(fragment, "");
        }

        public static ScreenTagHistory build(String fragment, String tag) {
            return build(fragment, tag, "home");
        }

        public static ScreenTagHistory build(String fragment, String tag, String storeContext) {
            String store;
            if (storeContext == null) {
                store = "";
            } else if (storeContext.equals("home")) {
                store = APTOIDE_MAIN_HISTORY_STORE;
            } else {
                store = storeContext;
            }
            return new ScreenTagHistory(fragment, tag, store);
        }
    }

    public ScreenTagHistory() {
        String str = NO_HISTORY;
        this(str, str, str);
    }

    private ScreenTagHistory(String fragment2, String tag2, String store2) {
        this.fragment = fragment2;
        this.tag = tag2;
        this.store = store2;
    }

    public String getStore() {
        String str = this.store;
        return str != null ? str : "";
    }

    public String getFragment() {
        String str = this.fragment;
        return str != null ? str : "";
    }

    public void setFragment(String fragment2) {
        this.fragment = fragment2;
    }

    public String getTag() {
        String str = this.tag;
        return str != null ? str : "";
    }

    public void setTag(String tag2) {
        this.tag = tag2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScreenTagHistory{fragment='");
        sb.append(this.fragment);
        sb.append('\'');
        sb.append(", tag='");
        sb.append(this.tag);
        sb.append('\'');
        sb.append(", store='");
        sb.append(this.store);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
