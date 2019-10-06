package p005cm.aptoide.p006pt.view.recycler.widget;

import android.content.res.Resources;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.FullReview;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.FullReview.AppData;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Review.User;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.reviews.RowReviewDisplayable;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.view.recycler.widget.RowReviewWidget */
public class RowReviewWidget extends Widget<RowReviewDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public ImageView appIcon;
    public TextView appName;
    private ImageView avatar;
    public TextView rating;
    private TextView reviewBody;
    private TextView reviewer;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5769063539283207462L, "cm/aptoide/pt/view/recycler/widget/RowReviewWidget", 48);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((RowReviewDisplayable) displayable, i);
        $jacocoInit[33] = true;
    }

    public RowReviewWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[1] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating);
        $jacocoInit[2] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[3] = true;
        this.avatar = (ImageView) itemView.findViewById(C1375R.C1376id.avatar);
        $jacocoInit[4] = true;
        this.reviewer = (TextView) itemView.findViewById(C1375R.C1376id.reviewer);
        $jacocoInit[5] = true;
        this.reviewBody = (TextView) itemView.findViewById(C1375R.C1376id.description);
        $jacocoInit[6] = true;
    }

    public void bindView(RowReviewDisplayable displayable, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        $jacocoInit[7] = true;
        FullReview review = (FullReview) displayable.getPojo();
        $jacocoInit[8] = true;
        AppData data = review.getData();
        $jacocoInit[9] = true;
        App app = data.getApp();
        if (app != null) {
            $jacocoInit[10] = true;
            this.appName.setText(app.getName());
            $jacocoInit[11] = true;
            ImageLoader with = ImageLoader.with(context);
            $jacocoInit[12] = true;
            with.load(app.getIcon(), this.appIcon);
            $jacocoInit[13] = true;
        } else {
            this.appName.setVisibility(4);
            $jacocoInit[14] = true;
            this.appIcon.setVisibility(4);
            $jacocoInit[15] = true;
        }
        this.reviewBody.setText(review.getBody());
        TextView textView = this.reviewer;
        $jacocoInit[16] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[17] = true;
        User user = review.getUser();
        $jacocoInit[18] = true;
        Object[] objArr = {user.getName()};
        $jacocoInit[19] = true;
        String formattedString = StringU.getFormattedString(C1375R.string.reviewed_by, resources, objArr);
        $jacocoInit[20] = true;
        textView.setText(formattedString);
        $jacocoInit[21] = true;
        TextView textView2 = this.rating;
        Locale locale = Locale.getDefault();
        Stats stats = review.getStats();
        $jacocoInit[22] = true;
        long rating2 = (long) stats.getRating();
        $jacocoInit[23] = true;
        textView2.setText(String.format(locale, "%d", new Object[]{Long.valueOf(rating2)}));
        $jacocoInit[24] = true;
        ImageLoader with2 = ImageLoader.with(context);
        $jacocoInit[25] = true;
        User user2 = review.getUser();
        $jacocoInit[26] = true;
        String avatar2 = user2.getAvatar();
        ImageView imageView = this.avatar;
        $jacocoInit[27] = true;
        with2.loadWithCircleTransformAndPlaceHolderAvatarSize(avatar2, imageView, C1375R.drawable.layer_1);
        $jacocoInit[28] = true;
        FragmentNavigator navigator = getFragmentNavigator();
        $jacocoInit[29] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.itemView);
        C5382g gVar = new C5382g(displayable, navigator, app, review);
        $jacocoInit[30] = true;
        C0137ja c = a.mo3646c((C0129b<? super T>) gVar);
        $jacocoInit[31] = true;
        cVar.mo3713a(c);
        $jacocoInit[32] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m9642a(RowReviewDisplayable displayable, FragmentNavigator navigator, App app, FullReview review, Void aVoid) {
        boolean[] $jacocoInit = $jacocoInit();
        if (displayable.getStoreAnalytics() == null) {
            $jacocoInit[34] = true;
        } else {
            $jacocoInit[35] = true;
            StoreAnalytics storeAnalytics = displayable.getStoreAnalytics();
            $jacocoInit[36] = true;
            FullReview fullReview = (FullReview) displayable.getPojo();
            $jacocoInit[37] = true;
            AppData data = fullReview.getData();
            $jacocoInit[38] = true;
            App app2 = data.getApp();
            $jacocoInit[39] = true;
            Store store = app2.getStore();
            $jacocoInit[40] = true;
            String name = store.getName();
            $jacocoInit[41] = true;
            storeAnalytics.sendStoreInteractEvent("View Review", "Latest Reviews", name);
            $jacocoInit[42] = true;
        }
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[43] = true;
        long id = app.getId();
        String name2 = app.getName();
        Store store2 = app.getStore();
        $jacocoInit[44] = true;
        String name3 = store2.getName();
        String packageName = app.getPackageName();
        long id2 = review.getId();
        $jacocoInit[45] = true;
        Fragment newRateAndReviewsFragment = fragmentProvider.newRateAndReviewsFragment(id, name2, name3, packageName, id2);
        $jacocoInit[46] = true;
        navigator.navigateTo(newRateAndReviewsFragment, true);
        $jacocoInit[47] = true;
    }
}
