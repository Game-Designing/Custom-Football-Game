package p005cm.aptoide.p006pt.store.view;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.p000v4.app.C0014p;
import android.text.ParcelableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreFragment;
import p005cm.aptoide.p006pt.account.view.store.ManageStoreViewModel;
import p005cm.aptoide.p006pt.account.view.user.CreateStoreDisplayable;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p005cm.aptoide.p006pt.view.spannable.SpannableFactory;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.store.view.CreateStoreWidget */
public class CreateStoreWidget extends Widget<CreateStoreDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Button button;
    private final CrashReport crashReport = CrashReport.getInstance();
    private TextView followers;
    private TextView following;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2034326394749219578L, "cm/aptoide/pt/store/view/CreateStoreWidget", 37);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((CreateStoreDisplayable) displayable, i);
        $jacocoInit[29] = true;
    }

    public CreateStoreWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.button = (Button) itemView.findViewById(C1375R.C1376id.create_store_action);
        $jacocoInit[2] = true;
        this.followers = (TextView) itemView.findViewById(C1375R.C1376id.followers);
        $jacocoInit[3] = true;
        this.following = (TextView) itemView.findViewById(C1375R.C1376id.following);
        $jacocoInit[4] = true;
    }

    public void bindView(CreateStoreDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        SpannableFactory spannableFactory = new SpannableFactory();
        $jacocoInit[5] = true;
        String string = getContext().getString(C1375R.string.storetab_short_followers);
        $jacocoInit[6] = true;
        Object[] objArr = {String.valueOf(displayable.getFollowers())};
        $jacocoInit[7] = true;
        String followersText = String.format(string, objArr);
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        ParcelableSpan[] textStyle = {new StyleSpan(1), new ForegroundColorSpan(getTextColor())};
        TextView textView = this.followers;
        $jacocoInit[10] = true;
        String[] strArr = {String.valueOf(displayable.getFollowers())};
        $jacocoInit[11] = true;
        textView.setText(spannableFactory.createMultiSpan(followersText, textStyle, strArr));
        $jacocoInit[12] = true;
        String string2 = getContext().getString(C1375R.string.storetab_short_followings);
        $jacocoInit[13] = true;
        Object[] objArr2 = {String.valueOf(displayable.getFollowings())};
        $jacocoInit[14] = true;
        String followingText = String.format(string2, objArr2);
        TextView textView2 = this.following;
        $jacocoInit[15] = true;
        String[] strArr2 = {String.valueOf(displayable.getFollowings())};
        $jacocoInit[16] = true;
        textView2.setText(spannableFactory.createMultiSpan(followingText, textStyle, strArr2));
        $jacocoInit[17] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.button);
        $jacocoInit[18] = true;
        C0120S a2 = a.mo3616a(C14522a.m46170a());
        C5100z zVar = new C5100z(this);
        $jacocoInit[19] = true;
        C0120S b = a2.mo3636b((C0129b<? super T>) zVar);
        C5098y yVar = new C5098y(displayable);
        $jacocoInit[20] = true;
        C0120S b2 = b.mo3636b((C0129b<? super T>) yVar);
        C4943B b3 = C4943B.f8593a;
        C4939A a3 = new C4939A(this);
        $jacocoInit[21] = true;
        C0137ja a4 = b2.mo3626a((C0129b<? super T>) b3, (C0129b<Throwable>) a3);
        $jacocoInit[22] = true;
        cVar.mo3713a(a4);
        $jacocoInit[23] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16481a(Void click) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        ManageStoreViewModel manageStoreViewModel = new ManageStoreViewModel();
        $jacocoInit[34] = true;
        ManageStoreFragment newInstance = ManageStoreFragment.newInstance(manageStoreViewModel, false);
        $jacocoInit[35] = true;
        fragmentNavigator.navigateTo(newInstance, true);
        $jacocoInit[36] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9294a(CreateStoreDisplayable displayable, Void __) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics = displayable.getStoreAnalytics();
        $jacocoInit[32] = true;
        storeAnalytics.sendStoreTabInteractEvent("Login", false);
        $jacocoInit[33] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m9295b(Void __) {
        $jacocoInit()[31] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16480a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(err);
        $jacocoInit[30] = true;
    }

    private int getTextColor() {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[24] = true;
            Resources resources = context.getResources();
            $jacocoInit[25] = true;
            int color = resources.getColor(C1375R.color.default_color, context.getTheme());
            $jacocoInit[26] = true;
            return color;
        }
        Resources resources2 = context.getResources();
        $jacocoInit[27] = true;
        int color2 = resources2.getColor(C1375R.color.default_color);
        $jacocoInit[28] = true;
        return color2;
    }
}
