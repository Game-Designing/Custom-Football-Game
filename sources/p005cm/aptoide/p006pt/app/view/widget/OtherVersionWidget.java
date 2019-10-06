package p005cm.aptoide.p006pt.app.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Date;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.displayable.OtherVersionDisplayable;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.DateTimeU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.app.view.widget.OtherVersionWidget */
public class OtherVersionWidget extends Widget<OtherVersionDisplayable> implements OnClickListener {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final Locale DEFAULT_LOCALE = Locale.getDefault();
    private static final String TAG = OtherVersionWidget.class.getSimpleName();
    private long appId;
    private TextView date;
    private OtherVersionDisplayable displayable;
    private TextView downloads;
    private TextView followers;
    private String packageName;
    private ImageView storeIcon;
    private String storeName;
    private TextView storeNameView;
    private ImageView trustedBadge;
    private TextView version;

    /* renamed from: cm.aptoide.pt.app.view.widget.OtherVersionWidget$1 */
    static /* synthetic */ class C22471 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank = new int[Rank.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4375499475727422228L, "cm/aptoide/pt/app/view/widget/OtherVersionWidget$1", 10);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.TRUSTED.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.WARNING.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.CRITICAL.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Rank.UNKNOWN.ordinal()] = 4;
            $jacocoInit[7] = true;
            $jacocoInit[9] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5077308541511982054L, "cm/aptoide/pt/app/view/widget/OtherVersionWidget", 76);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable2, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((OtherVersionDisplayable) displayable2, i);
        $jacocoInit[73] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[74] = true;
        $jacocoInit[75] = true;
    }

    public OtherVersionWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.version = (TextView) itemView.findViewById(C1375R.C1376id.version_name);
        $jacocoInit[1] = true;
        this.trustedBadge = (ImageView) itemView.findViewById(C1375R.C1376id.badge_icon);
        $jacocoInit[2] = true;
        this.date = (TextView) itemView.findViewById(C1375R.C1376id.version_date);
        $jacocoInit[3] = true;
        this.downloads = (TextView) itemView.findViewById(C1375R.C1376id.downloads);
        $jacocoInit[4] = true;
        this.storeIcon = (ImageView) itemView.findViewById(C1375R.C1376id.store_icon);
        $jacocoInit[5] = true;
        this.storeNameView = (TextView) itemView.findViewById(C1375R.C1376id.store_name);
        $jacocoInit[6] = true;
        this.followers = (TextView) itemView.findViewById(C1375R.C1376id.store_followers);
        $jacocoInit[7] = true;
        itemView.setOnClickListener(this);
        $jacocoInit[8] = true;
    }

    public void bindView(OtherVersionDisplayable displayable2, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        setItemBackgroundColor(this.itemView);
        try {
            $jacocoInit[9] = true;
            this.displayable = displayable2;
            $jacocoInit[10] = true;
            App app = (App) displayable2.getPojo();
            $jacocoInit[11] = true;
            this.appId = app.getId();
            $jacocoInit[12] = true;
            Store store = app.getStore();
            $jacocoInit[13] = true;
            this.storeName = store.getName();
            $jacocoInit[14] = true;
            this.packageName = app.getPackageName();
            $jacocoInit[15] = true;
            TextView textView = this.version;
            File file = app.getFile();
            $jacocoInit[16] = true;
            String vername = file.getVername();
            $jacocoInit[17] = true;
            textView.setText(vername);
            $jacocoInit[18] = true;
            setBadge(app);
            $jacocoInit[19] = true;
            TextView textView2 = this.date;
            DateTimeU instance = DateTimeU.getInstance(getContext());
            $jacocoInit[20] = true;
            C0014p context = getContext();
            Date modified = app.getModified();
            $jacocoInit[21] = true;
            long time = modified.getTime();
            Resources resources = getContext().getResources();
            $jacocoInit[22] = true;
            String timeDiffString = instance.getTimeDiffString((Context) context, time, resources);
            $jacocoInit[23] = true;
            textView2.setText(timeDiffString);
            TextView textView3 = this.downloads;
            Locale locale = DEFAULT_LOCALE;
            $jacocoInit[24] = true;
            String string = getContext().getString(C1375R.string.other_versions_downloads_count_text);
            $jacocoInit[25] = true;
            Stats stats = app.getStats();
            $jacocoInit[26] = true;
            long downloads2 = (long) stats.getDownloads();
            $jacocoInit[27] = true;
            Object[] objArr = {StringU.withSuffix(downloads2)};
            $jacocoInit[28] = true;
            textView3.setText(String.format(locale, string, objArr));
            $jacocoInit[29] = true;
            ImageLoader with = ImageLoader.with(getContext());
            $jacocoInit[30] = true;
            Store store2 = app.getStore();
            $jacocoInit[31] = true;
            String avatar = store2.getAvatar();
            ImageView imageView = this.storeIcon;
            $jacocoInit[32] = true;
            with.load(avatar, imageView);
            $jacocoInit[33] = true;
            TextView textView4 = this.storeNameView;
            Store store3 = app.getStore();
            $jacocoInit[34] = true;
            String name = store3.getName();
            $jacocoInit[35] = true;
            textView4.setText(name);
            TextView textView5 = this.followers;
            Locale locale2 = DEFAULT_LOCALE;
            $jacocoInit[36] = true;
            String string2 = getContext().getString(C1375R.string.appview_followers_count_text);
            Store store4 = app.getStore();
            $jacocoInit[37] = true;
            Store.Stats stats2 = store4.getStats();
            $jacocoInit[38] = true;
            int subscribers = stats2.getSubscribers();
            $jacocoInit[39] = true;
            Object[] objArr2 = {Integer.valueOf(subscribers)};
            $jacocoInit[40] = true;
            textView5.setText(String.format(locale2, string2, objArr2));
            $jacocoInit[41] = true;
        } catch (NullPointerException e) {
            $jacocoInit[42] = true;
            CrashReport instance2 = CrashReport.getInstance();
            $jacocoInit[43] = true;
            instance2.log(e);
            $jacocoInit[44] = true;
        }
        $jacocoInit[45] = true;
    }

    private void setItemBackgroundColor(View itemView) {
        int color;
        boolean[] $jacocoInit = $jacocoInit();
        Context context = itemView.getContext();
        $jacocoInit[46] = true;
        Theme theme = context.getTheme();
        $jacocoInit[47] = true;
        Resources res = itemView.getResources();
        $jacocoInit[48] = true;
        if (getLayoutPosition() % 2 == 0) {
            if (VERSION.SDK_INT >= 23) {
                $jacocoInit[49] = true;
                color = res.getColor(C1375R.color.light_custom_gray, theme);
                $jacocoInit[50] = true;
            } else {
                color = res.getColor(C1375R.color.light_custom_gray);
                $jacocoInit[51] = true;
            }
        } else if (VERSION.SDK_INT >= 23) {
            $jacocoInit[52] = true;
            color = res.getColor(C1375R.color.white, theme);
            $jacocoInit[53] = true;
        } else {
            color = res.getColor(C1375R.color.white);
            $jacocoInit[54] = true;
        }
        itemView.setBackgroundColor(color);
        $jacocoInit[55] = true;
    }

    private void setBadge(App app) {
        Rank rank;
        int badgeResId;
        boolean[] $jacocoInit = $jacocoInit();
        File file = app.getFile();
        $jacocoInit[56] = true;
        Malware malware = file.getMalware();
        $jacocoInit[57] = true;
        if (malware.getRank() == null) {
            rank = Rank.UNKNOWN;
            $jacocoInit[58] = true;
        } else {
            File file2 = app.getFile();
            $jacocoInit[59] = true;
            Malware malware2 = file2.getMalware();
            $jacocoInit[60] = true;
            rank = malware2.getRank();
            $jacocoInit[61] = true;
        }
        $jacocoInit[62] = true;
        int i = C22471.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[rank.ordinal()];
        if (i == 1) {
            badgeResId = C1375R.drawable.ic_badge_trusted;
            $jacocoInit[63] = true;
        } else if (i == 2) {
            badgeResId = C1375R.drawable.ic_badge_warning;
            $jacocoInit[64] = true;
        } else if (i != 3) {
            badgeResId = 0;
            $jacocoInit[66] = true;
        } else {
            badgeResId = C1375R.drawable.ic_badge_critical;
            $jacocoInit[65] = true;
        }
        this.trustedBadge.setImageResource(badgeResId);
        $jacocoInit[67] = true;
    }

    public void onClick(View v) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("showing other version for app with id = ");
        sb.append(this.appId);
        String sb2 = sb.toString();
        $jacocoInit[68] = true;
        instance.mo2136d(str, sb2);
        $jacocoInit[69] = true;
        FragmentNavigator fragmentNavigator = getFragmentNavigator();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        long j = this.appId;
        String str2 = this.packageName;
        String str3 = this.storeName;
        $jacocoInit[70] = true;
        Fragment newAppViewFragment = fragmentProvider.newAppViewFragment(j, str2, null, str3, "");
        $jacocoInit[71] = true;
        fragmentNavigator.navigateTo(newAppViewFragment, true);
        $jacocoInit[72] = true;
    }
}
