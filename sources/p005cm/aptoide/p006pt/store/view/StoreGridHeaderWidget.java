package p005cm.aptoide.p006pt.store.view;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget.Action;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.dataprovider.util.CommentType;
import p005cm.aptoide.p006pt.store.view.StoreGridHeaderDisplayable.Model;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.store.view.StoreGridHeaderWidget */
public class StoreGridHeaderWidget extends Widget<StoreGridHeaderDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Button more;
    private TextView title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3578180129534980722L, "cm/aptoide/pt/store/view/StoreGridHeaderWidget", 43);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((StoreGridHeaderDisplayable) displayable, i);
        $jacocoInit[25] = true;
    }

    public StoreGridHeaderWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = (TextView) itemView.findViewById(C1375R.C1376id.title);
        $jacocoInit[1] = true;
        this.more = (Button) itemView.findViewById(C1375R.C1376id.more);
        $jacocoInit[2] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(p005cm.aptoide.p006pt.store.view.StoreGridHeaderDisplayable r14, int r15) {
        /*
            r13 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets$WSWidget r1 = r14.getWsWidget()
            r2 = 1
            r3 = 3
            r0[r3] = r2
            boolean r3 = r1.hasActions()
            r4 = 4
            r0[r4] = r2
            android.support.v4.app.p r4 = r13.getContext()
            android.content.Context r4 = r4.getApplicationContext()
            cm.aptoide.pt.AptoideApplication r4 = (p005cm.aptoide.p006pt.AptoideApplication) r4
            r5 = 5
            r0[r5] = r2
            java.lang.String r5 = r14.getMarketName()
            r6 = 6
            r0[r6] = r2
            android.content.SharedPreferences r6 = r4.getDefaultSharedPreferences()
            r7 = 7
            r0[r7] = r2
            android.widget.TextView r7 = r13.title
            java.lang.String r8 = r1.getTitle()
            android.support.v4.app.p r9 = r13.getContext()
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r8 = p005cm.aptoide.p006pt.view.Translator.translate(r8, r9, r5)
            r7.setText(r8)
            r7 = 8
            r0[r7] = r2
            cm.aptoide.pt.store.view.StoreGridHeaderDisplayable$Model r8 = r14.getModel()
            r9 = 9
            r0[r9] = r2
            android.widget.Button r9 = r13.more
            android.support.v4.app.p r10 = r13.getContext()
            android.content.res.Resources r10 = r10.getResources()
            r11 = 10
            r0[r11] = r2
            java.lang.String r11 = r8.getStoreTheme()
            cm.aptoide.pt.store.StoreTheme r11 = p005cm.aptoide.p006pt.store.StoreTheme.get(r11)
            r12 = 11
            r0[r12] = r2
            int r11 = r11.getColorLetters()
            r12 = 12
            r0[r12] = r2
            int r10 = r10.getColor(r11)
            r11 = 13
            r0[r11] = r2
            r9.setTextColor(r10)
            r9 = 14
            r0[r9] = r2
            android.widget.Button r9 = r13.more
            if (r3 != 0) goto L_0x0089
            r10 = 15
            r0[r10] = r2
            goto L_0x0093
        L_0x0089:
            boolean r10 = r8.isMoreVisible()
            if (r10 != 0) goto L_0x0098
            r10 = 16
            r0[r10] = r2
        L_0x0093:
            r10 = 18
            r0[r10] = r2
            goto L_0x009d
        L_0x0098:
            r7 = 0
            r10 = 17
            r0[r10] = r2
        L_0x009d:
            r9.setVisibility(r7)
            if (r3 != 0) goto L_0x00a7
            r7 = 19
            r0[r7] = r2
            goto L_0x00cb
        L_0x00a7:
            r7 = 20
            r0[r7] = r2
            rx.i.c r7 = r13.compositeSubscription
            android.widget.Button r9 = r13.more
            rx.S r9 = p019d.p022i.p296a.p305c.C13034a.m42490a(r9)
            cm.aptoide.pt.store.view.ya r10 = new cm.aptoide.pt.store.view.ya
            r10.<init>(r1, r8, r6, r14)
            r11 = 21
            r0[r11] = r2
            rx.ja r9 = r9.mo3646c(r10)
            r10 = 22
            r0[r10] = r2
            r7.mo3713a(r9)
            r7 = 23
            r0[r7] = r2
        L_0x00cb:
            r7 = 24
            r0[r7] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.view.StoreGridHeaderWidget.bindView(cm.aptoide.pt.store.view.StoreGridHeaderDisplayable, int):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m9345a(WSWidget wsWidget, Model model, SharedPreferences sharedPreferences, StoreGridHeaderDisplayable displayable, Void a) {
        String url;
        boolean[] $jacocoInit = $jacocoInit();
        List actions = wsWidget.getActions();
        $jacocoInit[26] = true;
        Action action = (Action) actions.get(0);
        $jacocoInit[27] = true;
        Event event = action.getEvent();
        $jacocoInit[28] = true;
        String storeTheme = model.getStoreTheme();
        $jacocoInit[29] = true;
        String tag = model.getTag();
        $jacocoInit[30] = true;
        StoreContext storeContext = model.getStoreContext();
        $jacocoInit[31] = true;
        String title2 = wsWidget.getTitle();
        $jacocoInit[32] = true;
        if (event.getName() == Name.listComments) {
            $jacocoInit[33] = true;
            String action2 = event.getAction();
            if (action2 != null) {
                $jacocoInit[34] = true;
                url = action2.replace(C0044V7.getHost(sharedPreferences), "");
                $jacocoInit[35] = true;
            } else {
                url = null;
                $jacocoInit[36] = true;
            }
            $jacocoInit[37] = true;
            StoreTabNavigator storeTabNavigator = displayable.getStoreTabNavigator();
            CommentType commentType = CommentType.STORE;
            $jacocoInit[38] = true;
            storeTabNavigator.navigateToCommentGridRecyclerView(commentType, url, "View Comments", storeContext);
            $jacocoInit[39] = true;
        } else {
            StoreTabNavigator storeTabNavigator2 = displayable.getStoreTabNavigator();
            $jacocoInit[40] = true;
            storeTabNavigator2.navigateToStoreTabGridRecyclerView(event, title2, storeTheme, tag, storeContext);
            $jacocoInit[41] = true;
        }
        $jacocoInit[42] = true;
    }
}
