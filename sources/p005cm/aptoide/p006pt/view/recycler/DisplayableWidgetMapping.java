package p005cm.aptoide.p006pt.view.recycler;

import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.LoginDisplayable;
import p005cm.aptoide.p006pt.account.view.user.CreateStoreDisplayable;
import p005cm.aptoide.p006pt.app.view.GridAppDisplayable;
import p005cm.aptoide.p006pt.app.view.GridAppListDisplayable;
import p005cm.aptoide.p006pt.app.view.GridAppListWidget;
import p005cm.aptoide.p006pt.app.view.GridAppWidget;
import p005cm.aptoide.p006pt.app.view.OfficialAppDisplayable;
import p005cm.aptoide.p006pt.app.view.OfficialAppWidget;
import p005cm.aptoide.p006pt.app.view.displayable.OtherVersionDisplayable;
import p005cm.aptoide.p006pt.app.view.widget.OtherVersionWidget;
import p005cm.aptoide.p006pt.comments.view.CommentDisplayable;
import p005cm.aptoide.p006pt.comments.view.CommentWidget;
import p005cm.aptoide.p006pt.comments.view.CommentsReadMoreDisplayable;
import p005cm.aptoide.p006pt.comments.view.CommentsReadMoreWidget;
import p005cm.aptoide.p006pt.comments.view.RateAndReviewCommentDisplayable;
import p005cm.aptoide.p006pt.comments.view.RateAndReviewCommentWidget;
import p005cm.aptoide.p006pt.comments.view.StoreAddCommentWidget;
import p005cm.aptoide.p006pt.comments.view.StoreLatestCommentsWidget;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.GridAppCoinsRewardAppsDisplayable;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.reviews.ReviewsLanguageFilterDisplayable;
import p005cm.aptoide.p006pt.reviews.ReviewsLanguageFilterWidget;
import p005cm.aptoide.p006pt.reviews.ReviewsRatingDisplayable;
import p005cm.aptoide.p006pt.reviews.ReviewsRatingWidget;
import p005cm.aptoide.p006pt.reviews.RowReviewDisplayable;
import p005cm.aptoide.p006pt.store.view.CreateStoreWidget;
import p005cm.aptoide.p006pt.store.view.GridDisplayDisplayable;
import p005cm.aptoide.p006pt.store.view.GridStoreDisplayable;
import p005cm.aptoide.p006pt.store.view.GridStoreMetaDisplayable;
import p005cm.aptoide.p006pt.store.view.GridStoreMetaWidget;
import p005cm.aptoide.p006pt.store.view.GridStoreWidget;
import p005cm.aptoide.p006pt.store.view.LoginWidget;
import p005cm.aptoide.p006pt.store.view.StoreAddCommentDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreGridHeaderDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreGridHeaderWidget;
import p005cm.aptoide.p006pt.store.view.StoreLatestCommentsDisplayable;
import p005cm.aptoide.p006pt.store.view.featured.AppBrickDisplayable;
import p005cm.aptoide.p006pt.store.view.featured.AppBrickListDisplayable;
import p005cm.aptoide.p006pt.store.view.featured.AppBrickListWidget;
import p005cm.aptoide.p006pt.store.view.featured.AppBrickWidget;
import p005cm.aptoide.p006pt.store.view.home.AdultRowDisplayable;
import p005cm.aptoide.p006pt.store.view.home.AdultRowWidget;
import p005cm.aptoide.p006pt.store.view.p079my.StoreDisplayable;
import p005cm.aptoide.p006pt.store.view.p079my.StoreWidget;
import p005cm.aptoide.p006pt.store.view.recommended.RecommendedStoreDisplayable;
import p005cm.aptoide.p006pt.store.view.recommended.RecommendedStoreWidget;
import p005cm.aptoide.p006pt.store.view.top.TopAppListDisplayable;
import p005cm.aptoide.p006pt.store.view.top.TopAppListWidget;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowStoreDisplayable;
import p005cm.aptoide.p006pt.timeline.view.displayable.FollowUserDisplayable;
import p005cm.aptoide.p006pt.timeline.view.follow.FollowStoreWidget;
import p005cm.aptoide.p006pt.timeline.view.follow.FollowUserWidget;
import p005cm.aptoide.p006pt.updates.view.excluded.ExcludedUpdateDisplayable;
import p005cm.aptoide.p006pt.updates.view.excluded.ExcludedUpdateWidget;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.EmptyDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.FooterRowDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.GridAdDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.MessageWhiteBgDisplayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.ProgressBarDisplayable;
import p005cm.aptoide.p006pt.view.recycler.widget.EmptyWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.FooterRowWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.GridAdWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.GridAppCoinsRewardAppsWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.GridDisplayWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.MessageWhiteBgWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.ProgressBarWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.RowReviewWidget;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.view.recycler.DisplayableWidgetMapping */
public class DisplayableWidgetMapping {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = DisplayableWidgetMapping.class.getName();
    private static final DisplayableWidgetMapping instance = new DisplayableWidgetMapping();
    private List<Displayable> cachedDisplayables;
    private Class<? extends Displayable> displayableClass;
    private Map<Integer, DisplayableWidgetMapping> viewTypeMapping = new HashMap();
    private Class<? extends Widget> widgetClass;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(307529772372274624L, "cm/aptoide/pt/view/recycler/DisplayableWidgetMapping", 77);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[75] = true;
        $jacocoInit[76] = true;
    }

    protected DisplayableWidgetMapping() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        parseMappings(createMapping());
        $jacocoInit[2] = true;
    }

    public DisplayableWidgetMapping(Class<? extends Widget> widgetClass2, Class<? extends Displayable> displayableClass2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
        this.displayableClass = displayableClass2;
        this.widgetClass = widgetClass2;
        $jacocoInit[4] = true;
    }

    public static DisplayableWidgetMapping getInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayableWidgetMapping displayableWidgetMapping = instance;
        $jacocoInit[5] = true;
        return displayableWidgetMapping;
    }

    /* access modifiers changed from: protected */
    public void parseMappings(List<DisplayableWidgetMapping> mapping) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[6] = true;
        for (DisplayableWidgetMapping displayableWidgetMapping : mapping) {
            $jacocoInit[7] = true;
            Map<Integer, DisplayableWidgetMapping> map = this.viewTypeMapping;
            Displayable newDisplayable = displayableWidgetMapping.newDisplayable();
            $jacocoInit[8] = true;
            int viewLayout = newDisplayable.getViewLayout();
            $jacocoInit[9] = true;
            map.put(Integer.valueOf(viewLayout), displayableWidgetMapping);
            $jacocoInit[10] = true;
        }
        $jacocoInit[11] = true;
    }

    /* access modifiers changed from: protected */
    public List<DisplayableWidgetMapping> createMapping() {
        boolean[] $jacocoInit = $jacocoInit();
        LinkedList<DisplayableWidgetMapping> displayableWidgetMappings = new LinkedList<>();
        $jacocoInit[12] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(EmptyWidget.class, EmptyDisplayable.class));
        $jacocoInit[13] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(AppBrickWidget.class, AppBrickDisplayable.class));
        $jacocoInit[14] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridAppWidget.class, GridAppDisplayable.class));
        $jacocoInit[15] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridDisplayWidget.class, GridDisplayDisplayable.class));
        $jacocoInit[16] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(StoreGridHeaderWidget.class, StoreGridHeaderDisplayable.class));
        $jacocoInit[17] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(FooterRowWidget.class, FooterRowDisplayable.class));
        $jacocoInit[18] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridStoreWidget.class, GridStoreDisplayable.class));
        $jacocoInit[19] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridStoreMetaWidget.class, GridStoreMetaDisplayable.class));
        $jacocoInit[20] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridAdWidget.class, GridAdDisplayable.class));
        $jacocoInit[21] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridAppCoinsRewardAppsWidget.class, GridAppCoinsRewardAppsDisplayable.class));
        $jacocoInit[22] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(GridAppListWidget.class, GridAppListDisplayable.class));
        $jacocoInit[23] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(AppBrickListWidget.class, AppBrickListDisplayable.class));
        $jacocoInit[24] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(TopAppListWidget.class, TopAppListDisplayable.class));
        $jacocoInit[25] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(ExcludedUpdateWidget.class, ExcludedUpdateDisplayable.class));
        $jacocoInit[26] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(AdultRowWidget.class, AdultRowDisplayable.class));
        $jacocoInit[27] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(ProgressBarWidget.class, ProgressBarDisplayable.class));
        $jacocoInit[28] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(OtherVersionWidget.class, OtherVersionDisplayable.class));
        $jacocoInit[29] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(RowReviewWidget.class, RowReviewDisplayable.class));
        $jacocoInit[30] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(RateAndReviewCommentWidget.class, RateAndReviewCommentDisplayable.class));
        $jacocoInit[31] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(CommentWidget.class, CommentDisplayable.class));
        $jacocoInit[32] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(CommentsReadMoreWidget.class, CommentsReadMoreDisplayable.class));
        $jacocoInit[33] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(StoreLatestCommentsWidget.class, StoreLatestCommentsDisplayable.class));
        $jacocoInit[34] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(StoreAddCommentWidget.class, StoreAddCommentDisplayable.class));
        $jacocoInit[35] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(CreateStoreWidget.class, CreateStoreDisplayable.class));
        $jacocoInit[36] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(StoreWidget.class, StoreDisplayable.class));
        $jacocoInit[37] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(RecommendedStoreWidget.class, RecommendedStoreDisplayable.class));
        $jacocoInit[38] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(OfficialAppWidget.class, OfficialAppDisplayable.class));
        $jacocoInit[39] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(FollowUserWidget.class, FollowUserDisplayable.class));
        $jacocoInit[40] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(MessageWhiteBgWidget.class, MessageWhiteBgDisplayable.class));
        $jacocoInit[41] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(FollowStoreWidget.class, FollowStoreDisplayable.class));
        $jacocoInit[42] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(ReviewsLanguageFilterWidget.class, ReviewsLanguageFilterDisplayable.class));
        $jacocoInit[43] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(ReviewsRatingWidget.class, ReviewsRatingDisplayable.class));
        $jacocoInit[44] = true;
        displayableWidgetMappings.add(new DisplayableWidgetMapping(LoginWidget.class, LoginDisplayable.class));
        $jacocoInit[45] = true;
        return displayableWidgetMappings;
    }

    public Displayable newDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            Displayable displayable = (Displayable) this.displayableClass.newInstance();
            $jacocoInit[46] = true;
            return displayable;
        } catch (Exception e) {
            $jacocoInit[47] = true;
            CrashReport instance2 = CrashReport.getInstance();
            $jacocoInit[48] = true;
            instance2.log(e);
            Class<? extends Displayable> cls = this.displayableClass;
            $jacocoInit[49] = true;
            String errMsg = String.format("Error instantiating displayable '%s'", new Object[]{cls.getName()});
            $jacocoInit[50] = true;
            Logger instance3 = Logger.getInstance();
            String str = TAG;
            $jacocoInit[51] = true;
            instance3.mo2141e(str, errMsg, e);
            $jacocoInit[52] = true;
            RuntimeException runtimeException = new RuntimeException(errMsg);
            $jacocoInit[53] = true;
            throw runtimeException;
        }
    }

    public Widget newWidget(View view, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        DisplayableWidgetMapping displayableWidgetMapping = (DisplayableWidgetMapping) this.viewTypeMapping.get(Integer.valueOf(viewType));
        if (displayableWidgetMapping != null) {
            $jacocoInit[54] = true;
            Widget newWidget = displayableWidgetMapping.newWidget(view);
            $jacocoInit[55] = true;
            return newWidget;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("There's no widget for '%s' viewType", new Object[]{Integer.valueOf(viewType)}));
        sb.append("\nDid you forget to add the mapping to DisplayableWidgetMapping enum??");
        IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
        $jacocoInit[56] = true;
        throw illegalStateException;
    }

    private Widget newWidget(View view) {
        boolean[] $jacocoInit = $jacocoInit();
        Class[] cArg = {View.class};
        try {
            $jacocoInit[57] = true;
            Constructor declaredConstructor = this.widgetClass.getDeclaredConstructor(cArg);
            Object[] objArr = {view};
            $jacocoInit[58] = true;
            Widget widget = (Widget) declaredConstructor.newInstance(objArr);
            $jacocoInit[59] = true;
            return widget;
        } catch (Exception e) {
            $jacocoInit[60] = true;
            CrashReport instance2 = CrashReport.getInstance();
            $jacocoInit[61] = true;
            instance2.log(e);
            $jacocoInit[62] = true;
            String errMsg = String.format("Error instantiating widget '%s'", new Object[]{this.widgetClass.getName()});
            $jacocoInit[63] = true;
            Logger instance3 = Logger.getInstance();
            String str = TAG;
            $jacocoInit[64] = true;
            instance3.mo2141e(str, errMsg, e);
            $jacocoInit[65] = true;
            RuntimeException runtimeException = new RuntimeException(errMsg);
            $jacocoInit[66] = true;
            throw runtimeException;
        }
    }

    public List<Displayable> getCachedDisplayables() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.cachedDisplayables != null) {
            $jacocoInit[67] = true;
        } else {
            $jacocoInit[68] = true;
            List<Displayable> tmp = new LinkedList<>();
            $jacocoInit[69] = true;
            $jacocoInit[70] = true;
            for (DisplayableWidgetMapping displayableWidgetMapping : this.viewTypeMapping.values()) {
                $jacocoInit[71] = true;
                tmp.add(displayableWidgetMapping.newDisplayable());
                $jacocoInit[72] = true;
            }
            this.cachedDisplayables = Collections.unmodifiableList(tmp);
            $jacocoInit[73] = true;
        }
        List<Displayable> tmp2 = this.cachedDisplayables;
        $jacocoInit[74] = true;
        return tmp2;
    }
}
