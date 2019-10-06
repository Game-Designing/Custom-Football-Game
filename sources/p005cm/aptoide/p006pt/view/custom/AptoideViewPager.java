package p005cm.aptoide.p006pt.view.custom;

import android.content.Context;
import android.support.p000v4.view.ViewPager;
import android.support.p000v4.view.ViewPager.C0600i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.NavigationTrackerPagerAdapterHelper;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;

@Deprecated
/* renamed from: cm.aptoide.pt.view.custom.AptoideViewPager */
public class AptoideViewPager extends ViewPager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean enabled = true;
    private boolean trackingEnabled = true;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8991195403440272912L, "cm/aptoide/pt/view/custom/AptoideViewPager", 13);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ boolean access$000(AptoideViewPager x0) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = x0.trackingEnabled;
        $jacocoInit[12] = true;
        return z;
    }

    public AptoideViewPager(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
    }

    public AptoideViewPager(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onAttachedToWindow();
        $jacocoInit[2] = true;
        addOnPageChangeListener(new C0600i(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ AptoideViewPager this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(963277638998905008L, "cm/aptoide/pt/view/custom/AptoideViewPager$1", 18);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onPageSelected(int position) {
                boolean[] $jacocoInit = $jacocoInit();
                super.onPageSelected(position);
                $jacocoInit[1] = true;
                if (!AptoideViewPager.access$000(this.this$0)) {
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                    if (!(this.this$0.getAdapter() instanceof NavigationTrackerPagerAdapterHelper)) {
                        $jacocoInit[4] = true;
                        StringBuilder sb = new StringBuilder();
                        Class cls = this.this$0.getAdapter().getClass();
                        $jacocoInit[5] = true;
                        sb.append(cls.getSimpleName());
                        sb.append(" has to implement ");
                        $jacocoInit[6] = true;
                        sb.append(NavigationTrackerPagerAdapterHelper.class.getSimpleName());
                        RuntimeException runtimeException = new RuntimeException(sb.toString());
                        $jacocoInit[7] = true;
                        throw runtimeException;
                    } else if (position == 0) {
                        $jacocoInit[8] = true;
                    } else {
                        AptoideViewPager aptoideViewPager = this.this$0;
                        $jacocoInit[9] = true;
                        NavigationTrackerPagerAdapterHelper adapter = (NavigationTrackerPagerAdapterHelper) aptoideViewPager.getAdapter();
                        $jacocoInit[10] = true;
                        String currentView = adapter.getItemName(position);
                        $jacocoInit[11] = true;
                        String tag = adapter.getItemTag(position);
                        $jacocoInit[12] = true;
                        StoreContext storeContext = adapter.getItemStore();
                        $jacocoInit[13] = true;
                        NavigationTracker navigationTracker = ((AptoideApplication) this.this$0.getContext().getApplicationContext()).getNavigationTracker();
                        $jacocoInit[14] = true;
                        ScreenTagHistory build = Builder.build(currentView, tag, storeContext.name());
                        $jacocoInit[15] = true;
                        navigationTracker.registerScreen(build);
                        $jacocoInit[16] = true;
                    }
                }
                $jacocoInit[17] = true;
            }
        });
        $jacocoInit[3] = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.enabled) {
            $jacocoInit[4] = true;
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(event);
            $jacocoInit[5] = true;
            return onInterceptTouchEvent;
        }
        $jacocoInit[6] = true;
        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.enabled) {
            $jacocoInit[7] = true;
            boolean onTouchEvent = super.onTouchEvent(event);
            $jacocoInit[8] = true;
            return onTouchEvent;
        }
        $jacocoInit[9] = true;
        return false;
    }

    public void setPagingEnabled(boolean enabled2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.enabled = enabled2;
        $jacocoInit[10] = true;
    }

    public void setTrackingEnabled(boolean trackingEnabled2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.trackingEnabled = trackingEnabled2;
        $jacocoInit[11] = true;
    }
}
