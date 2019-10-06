package p005cm.aptoide.p006pt.timeline.view;

import android.os.Bundle;
import android.support.p001v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.fragment.BaseLoaderToolbarFragment;

/* renamed from: cm.aptoide.pt.timeline.view.SocialFragment */
public class SocialFragment extends BaseLoaderToolbarFragment {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String PAGE_TITLE = "Social Page Title";
    public static final String SOCIAL_URL = "Social URL";
    private String pageTitle;
    private String socialUrl;
    private WebView socialWebview;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7010850215189472478L, "cm/aptoide/pt/timeline/view/SocialFragment", 29);
        $jacocoData = probes;
        return probes;
    }

    public SocialFragment() {
        $jacocoInit()[0] = true;
    }

    static /* synthetic */ void access$000(SocialFragment x0) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.finishLoading();
        $jacocoInit[28] = true;
    }

    public static SocialFragment newInstance(String socialUrl2, String pageTitle2) {
        boolean[] $jacocoInit = $jacocoInit();
        SocialFragment socialFragment = new SocialFragment();
        $jacocoInit[1] = true;
        Bundle extras = new Bundle();
        $jacocoInit[2] = true;
        extras.putString(SOCIAL_URL, socialUrl2);
        $jacocoInit[3] = true;
        extras.putString(PAGE_TITLE, pageTitle2);
        $jacocoInit[4] = true;
        socialFragment.setArguments(extras);
        $jacocoInit[5] = true;
        return socialFragment;
    }

    public int getContentViewId() {
        $jacocoInit()[6] = true;
        return C1375R.layout.social_fragment_layout;
    }

    /* access modifiers changed from: protected */
    public int[] getViewsToShowAfterLoadingId() {
        int[] iArr = new int[0];
        $jacocoInit()[7] = true;
        return iArr;
    }

    /* access modifiers changed from: protected */
    public int getViewToShowAfterLoadingId() {
        $jacocoInit()[8] = true;
        return C1375R.C1376id.social_fragment_layout;
    }

    public void load(boolean create, boolean refresh, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        this.socialWebview.loadUrl(this.socialUrl);
        $jacocoInit[9] = true;
    }

    public void setupViews() {
        boolean[] $jacocoInit = $jacocoInit();
        super.setupViews();
        $jacocoInit[10] = true;
        this.socialWebview.setWebChromeClient(new WebChromeClient(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SocialFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-2668020469223014084L, "cm/aptoide/pt/timeline/view/SocialFragment$1", 1);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }
        });
        $jacocoInit[11] = true;
        this.socialWebview.setWebViewClient(new WebViewClient(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ SocialFragment this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(7894526439780044439L, "cm/aptoide/pt/timeline/view/SocialFragment$2", 2);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onPageFinished(WebView view, String url) {
                boolean[] $jacocoInit = $jacocoInit();
                SocialFragment.access$000(this.this$0);
                $jacocoInit[1] = true;
            }
        });
        $jacocoInit[12] = true;
        WebSettings settings = this.socialWebview.getSettings();
        $jacocoInit[13] = true;
        settings.setJavaScriptEnabled(true);
        $jacocoInit[14] = true;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeUpAsEnabled() {
        $jacocoInit()[15] = true;
        return true;
    }

    public void setupToolbarDetails(Toolbar toolbar) {
        boolean[] $jacocoInit = $jacocoInit();
        toolbar.setTitle((CharSequence) this.pageTitle);
        $jacocoInit[16] = true;
    }

    public void bindViews(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        super.bindViews(view);
        $jacocoInit[17] = true;
        this.socialWebview = (WebView) view.findViewById(C1375R.C1376id.social_fragment_layout);
        $jacocoInit[18] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[19] = true;
        setHasOptionsMenu(true);
        $jacocoInit[20] = true;
    }

    public void loadExtras(Bundle args) {
        boolean[] $jacocoInit = $jacocoInit();
        this.socialUrl = args.getString(SOCIAL_URL);
        $jacocoInit[21] = true;
        this.pageTitle = args.getString(PAGE_TITLE);
        $jacocoInit[22] = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreateOptionsMenu(menu, inflater);
        $jacocoInit[23] = true;
        inflater.inflate(C1375R.C1377menu.menu_empty, menu);
        $jacocoInit[24] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[25] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[26] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[27] = true;
        return build;
    }
}
