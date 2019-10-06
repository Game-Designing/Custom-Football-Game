package p005cm.aptoide.p006pt.app.view;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Stats.Rating;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.repository.RepositoryFactory;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.Translator;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0129b;
import p026rx.p029i.C0136c;
import p026rx.p398d.C14906b;

/* renamed from: cm.aptoide.pt.app.view.OfficialAppWidget */
public class OfficialAppWidget extends Widget<OfficialAppDisplayable> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = OfficialAppWidget.class.getName();
    private TextView appDownloads;
    private ImageView appImage;
    private TextView appName;
    private RatingBar appRating;
    private TextView appSize;
    private TextView appVersion;
    private Button installButton;
    private TextView installMessage;
    private View verticalSeparator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1245969587914257757L, "cm/aptoide/pt/app/view/OfficialAppWidget", 92);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void bindView(Displayable displayable, int i) {
        boolean[] $jacocoInit = $jacocoInit();
        bindView((OfficialAppDisplayable) displayable, i);
        $jacocoInit[80] = true;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[91] = true;
    }

    public OfficialAppWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void assignViews(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appImage = (ImageView) itemView.findViewById(C1375R.C1376id.app_image);
        $jacocoInit[1] = true;
        this.installButton = (Button) itemView.findViewById(C1375R.C1376id.app_install_button);
        $jacocoInit[2] = true;
        this.installMessage = (TextView) itemView.findViewById(C1375R.C1376id.install_message);
        $jacocoInit[3] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[4] = true;
        this.verticalSeparator = itemView.findViewById(C1375R.C1376id.vertical_separator);
        $jacocoInit[5] = true;
        this.appRating = (RatingBar) itemView.findViewById(C1375R.C1376id.app_rating);
        $jacocoInit[6] = true;
        this.appDownloads = (TextView) itemView.findViewById(C1375R.C1376id.app_downloads);
        $jacocoInit[7] = true;
        this.appVersion = (TextView) itemView.findViewById(C1375R.C1376id.app_version);
        $jacocoInit[8] = true;
        this.appSize = (TextView) itemView.findViewById(C1375R.C1376id.app_size);
        $jacocoInit[9] = true;
    }

    public void bindView(OfficialAppDisplayable displayable, int position) {
        int color;
        int i;
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        C0014p context = getContext();
        $jacocoInit[10] = true;
        Pair<String, GetAppMeta> appMeta = displayable.getMessageGetApp();
        $jacocoInit[11] = true;
        App data = ((GetAppMeta) appMeta.second).getData();
        $jacocoInit[12] = true;
        String packageName = data.getPackageName();
        $jacocoInit[13] = true;
        boolean isAppInstalled = isAppInstalled(packageName);
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[14] = true;
            Resources resources = context.getResources();
            $jacocoInit[15] = true;
            StoreTheme storeTheme = displayable.getStoreTheme();
            $jacocoInit[16] = true;
            int primaryColor = storeTheme.getPrimaryColor();
            Theme theme = context.getTheme();
            $jacocoInit[17] = true;
            color = resources.getColor(primaryColor, theme);
            $jacocoInit[18] = true;
        } else {
            Resources resources2 = context.getResources();
            $jacocoInit[19] = true;
            StoreTheme storeTheme2 = displayable.getStoreTheme();
            $jacocoInit[20] = true;
            int primaryColor2 = storeTheme2.getPrimaryColor();
            $jacocoInit[21] = true;
            color = resources2.getColor(primaryColor2);
            $jacocoInit[22] = true;
        }
        App appData = ((GetAppMeta) appMeta.second).getData();
        $jacocoInit[23] = true;
        String appName2 = appData.getName();
        $jacocoInit[24] = true;
        if (!TextUtils.isEmpty((CharSequence) appMeta.first)) {
            String str2 = (String) appMeta.first;
            $jacocoInit[25] = true;
            String[] parts = Translator.translateToMultiple(str2, getContext().getApplicationContext());
            if (parts == null) {
                $jacocoInit[26] = true;
            } else if (parts.length != 4) {
                $jacocoInit[27] = true;
            } else {
                if (isAppInstalled) {
                    str = parts[3];
                    $jacocoInit[28] = true;
                } else {
                    str = parts[2];
                    $jacocoInit[29] = true;
                }
                Object[] objArr = {appName2};
                $jacocoInit[30] = true;
                SpannableString middle = new SpannableString(String.format(str, objArr));
                $jacocoInit[31] = true;
                middle.setSpan(new ForegroundColorSpan(color), 0, middle.length(), 17);
                $jacocoInit[32] = true;
                SpannableStringBuilder text = new SpannableStringBuilder();
                $jacocoInit[33] = true;
                text.append(parts[0]);
                $jacocoInit[34] = true;
                text.append(middle);
                $jacocoInit[35] = true;
                text.append(parts[1]);
                $jacocoInit[36] = true;
                this.installMessage.setText(text);
                $jacocoInit[37] = true;
                $jacocoInit[39] = true;
            }
            this.installMessage.setText((CharSequence) appMeta.first);
            $jacocoInit[38] = true;
            $jacocoInit[39] = true;
        } else {
            hideOfficialAppMessage();
            $jacocoInit[40] = true;
        }
        RatingBar ratingBar = this.appRating;
        Stats stats = appData.getStats();
        $jacocoInit[41] = true;
        Rating rating = stats.getRating();
        $jacocoInit[42] = true;
        float avg = rating.getAvg();
        $jacocoInit[43] = true;
        ratingBar.setRating(avg);
        $jacocoInit[44] = true;
        this.appName.setText(appName2);
        $jacocoInit[45] = true;
        TextView textView = this.appDownloads;
        String string = context.getString(C1375R.string.downloads_count);
        $jacocoInit[46] = true;
        Stats stats2 = appData.getStats();
        $jacocoInit[47] = true;
        long downloads = (long) stats2.getDownloads();
        $jacocoInit[48] = true;
        Object[] objArr2 = {StringU.withSuffix(downloads)};
        $jacocoInit[49] = true;
        textView.setText(String.format(string, objArr2));
        $jacocoInit[50] = true;
        TextView textView2 = this.appVersion;
        String string2 = context.getString(C1375R.string.version_number);
        $jacocoInit[51] = true;
        GetAppMetaFile file = appData.getFile();
        $jacocoInit[52] = true;
        Object[] objArr3 = {file.getVername()};
        $jacocoInit[53] = true;
        textView2.setText(String.format(string2, objArr3));
        $jacocoInit[54] = true;
        TextView textView3 = this.appSize;
        String string3 = context.getString(C1375R.string.app_size);
        $jacocoInit[55] = true;
        GetAppMetaFile file2 = appData.getFile();
        $jacocoInit[56] = true;
        long filesize = file2.getFilesize();
        $jacocoInit[57] = true;
        Object[] objArr4 = {StringU.formatBytes(filesize, false)};
        $jacocoInit[58] = true;
        textView3.setText(String.format(string3, objArr4));
        $jacocoInit[59] = true;
        ImageLoader with = ImageLoader.with(context);
        $jacocoInit[60] = true;
        with.load(appData.getIcon(), this.appImage);
        $jacocoInit[61] = true;
        Button button = this.installButton;
        Resources resources3 = getContext().getResources();
        $jacocoInit[62] = true;
        StoreTheme storeTheme3 = displayable.getStoreTheme();
        $jacocoInit[63] = true;
        int raisedButtonDrawable = storeTheme3.getRaisedButtonDrawable();
        $jacocoInit[64] = true;
        Drawable drawable = resources3.getDrawable(raisedButtonDrawable);
        $jacocoInit[65] = true;
        button.setBackgroundDrawable(drawable);
        $jacocoInit[66] = true;
        Button button2 = this.installButton;
        if (isAppInstalled) {
            i = C1375R.string.open;
            $jacocoInit[67] = true;
        } else {
            i = C1375R.string.install;
            $jacocoInit[68] = true;
        }
        button2.setText(context.getString(i));
        $jacocoInit[69] = true;
        C0136c cVar = this.compositeSubscription;
        C0120S a = C13034a.m42490a(this.installButton);
        C2120ji jiVar = new C2120ji(this, isAppInstalled, appData);
        C2110ii iiVar = C2110ii.f5171a;
        $jacocoInit[70] = true;
        C0137ja a2 = a.mo3626a((C0129b<? super T>) jiVar, (C0129b<Throwable>) iiVar);
        $jacocoInit[71] = true;
        cVar.mo3713a(a2);
        $jacocoInit[72] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo10848a(boolean isAppInstalled, App appData, Void a) {
        boolean[] $jacocoInit = $jacocoInit();
        if (isAppInstalled) {
            $jacocoInit[83] = true;
            String packageName = appData.getPackageName();
            PackageManager packageManager = getContext().getPackageManager();
            $jacocoInit[84] = true;
            C0014p context = getContext();
            $jacocoInit[85] = true;
            SystemU.openApp(packageName, packageManager, context);
            $jacocoInit[86] = true;
        } else {
            FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
            $jacocoInit[87] = true;
            Fragment appView = fragmentProvider.newAppViewFragment(appData.getPackageName(), OpenType.OPEN_AND_INSTALL);
            $jacocoInit[88] = true;
            getFragmentNavigator().navigateTo(appView, true);
            $jacocoInit[89] = true;
        }
        $jacocoInit[90] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6958a(Throwable err) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[81] = true;
        instance.log(err);
        $jacocoInit[82] = true;
    }

    private boolean isAppInstalled(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[73] = true;
        InstalledRepository installedRepo = RepositoryFactory.getInstalledRepository(getContext().getApplicationContext());
        $jacocoInit[74] = true;
        C0120S isInstalled = installedRepo.isInstalled(packageName);
        $jacocoInit[75] = true;
        C14906b k = isInstalled.mo3672k();
        $jacocoInit[76] = true;
        boolean booleanValue = ((Boolean) k.mo46110a()).booleanValue();
        $jacocoInit[77] = true;
        return booleanValue;
    }

    private void hideOfficialAppMessage() {
        boolean[] $jacocoInit = $jacocoInit();
        this.installMessage.setVisibility(8);
        $jacocoInit[78] = true;
        this.verticalSeparator.setVisibility(8);
        $jacocoInit[79] = true;
    }
}
