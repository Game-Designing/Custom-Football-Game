package p005cm.aptoide.p006pt.view.recycler.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event.Name;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays.EventImage;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.store.view.GridDisplayDisplayable;
import p005cm.aptoide.p006pt.store.view.StoreTabFragmentChooser;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;
import rx.functions.Action1;

/* renamed from: cm.aptoide.pt.view.recycler.widget.GridDisplayWidget */
public class GridDisplayWidget extends Widget<GridDisplayDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private ImageView imageView;

    /* renamed from: cm.aptoide.pt.view.recycler.widget.GridDisplayWidget$1 */
    static /* synthetic */ class C53751 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name = new int[Name.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3336112107697113843L, "cm/aptoide/pt/view/recycler/widget/GridDisplayWidget$1", 8);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Name.facebook.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        $jacocoInit[6] = true;
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Name.twitch.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[Name.youtube.ordinal()] = 3;
            $jacocoInit[5] = true;
            $jacocoInit[7] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5898093377832331532L, "cm/aptoide/pt/view/recycler/widget/GridDisplayWidget", 30);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((GridDisplayDisplayable) displayable, i);
        $jacocoInit[17] = true;
    }

    public GridDisplayWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.imageView = (ImageView) itemView.findViewById(C1375R.C1376id.image_category);
        $jacocoInit[1] = true;
    }

    public void bindView(GridDisplayDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        EventImage pojo = (EventImage) displayable.getPojo();
        $jacocoInit[2] = true;
        C0014p context = getContext();
        $jacocoInit[3] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[4] = true;
        with.load(pojo.getGraphic(), this.imageView);
        $jacocoInit[5] = true;
        Action1<Void> imageClickHandler = new C5381f<>(this, pojo, displayable);
        $jacocoInit[6] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.imageView);
        C5380e eVar = C5380e.f9196a;
        $jacocoInit[7] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) imageClickHandler, (C0129b<Throwable>) eVar);
        $jacocoInit[8] = true;
        cVar.mo3713a(a2);
        $jacocoInit[9] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo17346a(EventImage pojo, GridDisplayDisplayable displayable, Void v) {
        boolean[] $jacocoInit = $jacocoInit();
        Event event = pojo.getEvent();
        $jacocoInit[20] = true;
        Name name = event.getName();
        $jacocoInit[21] = true;
        if (StoreTabFragmentChooser.validateAcceptedName(name)) {
            $jacocoInit[22] = true;
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            $jacocoInit[23] = true;
            String label = pojo.getLabel();
            $jacocoInit[24] = true;
            String storeTheme = displayable.getStoreTheme();
            String tag = displayable.getTag();
            StoreContext storeContext = displayable.getStoreContext();
            $jacocoInit[25] = true;
            Fragment newInstance = StoreTabGridRecyclerFragment.newInstance(event, label, storeTheme, tag, storeContext);
            $jacocoInit[26] = true;
            fragmentNavigator.navigateTo(newInstance, true);
            $jacocoInit[27] = true;
        } else {
            int i = C53751.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Event$Name[name.ordinal()];
            sendActionEvent(event.getAction());
            $jacocoInit[28] = true;
        }
        $jacocoInit[29] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9640a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[18] = true;
        instance.log(throwable);
        $jacocoInit[19] = true;
    }

    private void sendActionEvent(String eventActionUrl) {
        boolean[] $jacocoInit = $jacocoInit();
        if (eventActionUrl == null) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            Intent i = new Intent("android.intent.action.VIEW");
            $jacocoInit[12] = true;
            i.setData(Uri.parse(eventActionUrl));
            $jacocoInit[13] = true;
            Context context = this.itemView.getContext();
            $jacocoInit[14] = true;
            context.startActivity(i);
            $jacocoInit[15] = true;
        }
        $jacocoInit[16] = true;
    }
}
