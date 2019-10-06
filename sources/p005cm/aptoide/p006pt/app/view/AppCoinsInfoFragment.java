package p005cm.aptoide.p006pt.app.view;

import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.content.C0510b;
import android.support.p001v7.app.C0019n;
import android.support.p001v7.app.C0760a;
import android.support.p001v7.widget.Toolbar;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import javax.inject.Inject;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p005cm.aptoide.p006pt.view.AppCoinsInfoPresenter;
import p005cm.aptoide.p006pt.view.BackButtonFragment;
import p005cm.aptoide.p006pt.view.NotBottomNavigationView;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.app.view.AppCoinsInfoFragment */
public class AppCoinsInfoFragment extends BackButtonFragment implements AppCoinsInfoView, NotBottomNavigationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private View appCardView;
    @Inject
    AppCoinsInfoPresenter appCoinsInfoPresenter;
    private TextView appcMessageAppcoinsSection2a;
    private Button installButton;
    private int spannableColor;
    @Inject
    String theme;
    private Toolbar toolbar;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4961740525291322953L, "cm/aptoide/pt/app/view/AppCoinsInfoFragment", 78);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsInfoFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[1] = true;
        getFragmentComponent(savedInstanceState).inject(this);
        $jacocoInit[2] = true;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onViewCreated(view, savedInstanceState);
        $jacocoInit[3] = true;
        this.toolbar = (Toolbar) view.findViewById(C1375R.C1376id.toolbar);
        $jacocoInit[4] = true;
        StoreTheme storeTheme = StoreTheme.get(this.theme);
        $jacocoInit[5] = true;
        this.spannableColor = storeTheme.getPrimaryColor();
        $jacocoInit[6] = true;
        this.appCardView = view.findViewById(C1375R.C1376id.app_cardview);
        $jacocoInit[7] = true;
        this.installButton = (Button) view.findViewById(C1375R.C1376id.appview_install_button);
        $jacocoInit[8] = true;
        this.appcMessageAppcoinsSection2a = (TextView) view.findViewById(C1375R.C1376id.appc_message_appcoins_section_2a);
        $jacocoInit[9] = true;
        TextView appcMessageAppcoinsSection3 = (TextView) view.findViewById(C1375R.C1376id.appc_message_appcoins_section_3);
        $jacocoInit[10] = true;
        TextView appcMessageAppcoinsSection4 = (TextView) view.findViewById(C1375R.C1376id.appc_message_appcoins_section_4);
        $jacocoInit[11] = true;
        String string = getString(C1375R.string.appc_card_short);
        $jacocoInit[12] = true;
        String string2 = getString(C1375R.string.appc_home_bundle_poa);
        $jacocoInit[13] = true;
        String string3 = getString(C1375R.string.appc_message_appcoins_section_3);
        $jacocoInit[14] = true;
        setupTextViewTwoPlaceholders(string, string2, string3, appcMessageAppcoinsSection3);
        $jacocoInit[15] = true;
        String string4 = getString(C1375R.string.appc_card_short);
        $jacocoInit[16] = true;
        String string5 = getString(C1375R.string.appc_message_appcoins_section_4);
        $jacocoInit[17] = true;
        setupTextView(string4, string5, appcMessageAppcoinsSection4);
        $jacocoInit[18] = true;
        TextView textView = (TextView) this.appCardView.findViewById(C1375R.C1376id.app_title_textview);
        $jacocoInit[19] = true;
        String string6 = getString(C1375R.string.appc_title_settings_appcoins_wallet);
        $jacocoInit[20] = true;
        textView.setText(string6);
        $jacocoInit[21] = true;
        ImageView imageView = (ImageView) this.appCardView.findViewById(C1375R.C1376id.app_icon_imageview);
        $jacocoInit[22] = true;
        Drawable c = C0510b.m2572c(getContext(), C1375R.drawable.appcoins_wallet_icon);
        $jacocoInit[23] = true;
        imageView.setImageDrawable(c);
        $jacocoInit[24] = true;
        setupWalletLink();
        $jacocoInit[25] = true;
        setHasOptionsMenu(true);
        $jacocoInit[26] = true;
        setupToolbar();
        $jacocoInit[27] = true;
        attachPresenter(this.appCoinsInfoPresenter);
        $jacocoInit[28] = true;
    }

    public ScreenTagHistory getHistoryTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        Class cls = getClass();
        $jacocoInit[29] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[30] = true;
        ScreenTagHistory build = Builder.build(simpleName);
        $jacocoInit[31] = true;
        return build;
    }

    public void onDestroyView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar = null;
        this.appCardView = null;
        this.installButton = null;
        this.appcMessageAppcoinsSection2a = null;
        $jacocoInit[32] = true;
        super.onDestroyView();
        $jacocoInit[33] = true;
    }

    private void setupWalletLink() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[34] = true;
        String string = getString(C1375R.string.appc_message_appcoins_section_2a);
        $jacocoInit[35] = true;
        Object[] objArr = {getString(C1375R.string.appc_title_settings_appcoins_wallet)};
        $jacocoInit[36] = true;
        String formattedString = String.format(string, objArr);
        $jacocoInit[37] = true;
        SpannableString spannableString = new SpannableString(formattedString);
        $jacocoInit[38] = true;
        this.appcMessageAppcoinsSection2a.setText(spannableString);
        $jacocoInit[39] = true;
        this.appcMessageAppcoinsSection2a.setMovementMethod(LinkMovementMethod.getInstance());
        $jacocoInit[40] = true;
    }

    private void setupTextView(String appcString, String text, TextView appcMessageAppcoinsSection) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[41] = true;
        Object[] objArr = {Integer.valueOf(C1375R.drawable.spend_get_appc_icon), Integer.valueOf(getResources().getColor(this.spannableColor)), appcString};
        $jacocoInit[42] = true;
        String spendGetAppcoinsLogo = String.format("<img src=\"%1$s\"/> <font color=\"%2$s\"><small>%3$s</small></font>", objArr);
        $jacocoInit[43] = true;
        String formatedText = String.format(text, new Object[]{spendGetAppcoinsLogo});
        $jacocoInit[44] = true;
        appcMessageAppcoinsSection.setText(Html.fromHtml(formatedText, getImageGetter(), null));
        $jacocoInit[45] = true;
    }

    private void setupTextViewTwoPlaceholders(String appcString, String bundle, String text, TextView appcMessageAppcoinsSection) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[46] = true;
        Object[] objArr = {Integer.valueOf(C1375R.drawable.spend_get_appc_icon), Integer.valueOf(getResources().getColor(this.spannableColor)), appcString};
        $jacocoInit[47] = true;
        String spendGetAppcoinsLogo = String.format("<img src=\"%1$s\"/> <font color=\"%2$s\"><small>%3$s</small></font>", objArr);
        $jacocoInit[48] = true;
        StringBuilder sb = new StringBuilder();
        sb.append("<b>");
        sb.append(bundle);
        sb.append("</b> ");
        String boldBundle = sb.toString();
        $jacocoInit[49] = true;
        String formatedText = String.format(text, new Object[]{boldBundle, spendGetAppcoinsLogo});
        $jacocoInit[50] = true;
        appcMessageAppcoinsSection.setText(Html.fromHtml(formatedText, getImageGetter(), null));
        $jacocoInit[51] = true;
    }

    private void setupToolbar() {
        boolean[] $jacocoInit = $jacocoInit();
        this.toolbar.setTitle((int) C1375R.string.appc_title_about_appcoins);
        $jacocoInit[52] = true;
        C0019n activity = (C0019n) getActivity();
        $jacocoInit[53] = true;
        activity.setSupportActionBar(this.toolbar);
        $jacocoInit[54] = true;
        C0760a actionBar = activity.getSupportActionBar();
        if (actionBar == null) {
            $jacocoInit[55] = true;
        } else {
            $jacocoInit[56] = true;
            actionBar.mo6153d(true);
            $jacocoInit[57] = true;
            actionBar.mo6147a(this.toolbar.getTitle());
            $jacocoInit[58] = true;
        }
        $jacocoInit[59] = true;
    }

    private ImageGetter getImageGetter() {
        boolean[] $jacocoInit = $jacocoInit();
        C2018c cVar = new C2018c(this);
        $jacocoInit[60] = true;
        return cVar;
    }

    /* renamed from: a */
    public /* synthetic */ Drawable mo10392a(String source) {
        Drawable drawable;
        NotFoundException e;
        NumberFormatException e2;
        String str = "log_tag";
        boolean[] $jacocoInit = $jacocoInit();
        try {
            $jacocoInit[70] = true;
            drawable = null;
            try {
                drawable = getResources().getDrawable(Integer.parseInt(source));
                $jacocoInit[71] = true;
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                $jacocoInit[72] = true;
            } catch (NotFoundException e3) {
                e = e3;
                $jacocoInit[73] = true;
                Log.e(str, "Image not found. Check the ID.", e);
                $jacocoInit[74] = true;
                $jacocoInit[77] = true;
                return drawable;
            } catch (NumberFormatException e4) {
                e2 = e4;
                $jacocoInit[75] = true;
                Log.e(str, "Source string not a valid resource ID.", e2);
                $jacocoInit[76] = true;
                $jacocoInit[77] = true;
                return drawable;
            }
        } catch (NotFoundException e5) {
            e = e5;
            drawable = null;
            $jacocoInit[73] = true;
            Log.e(str, "Image not found. Check the ID.", e);
            $jacocoInit[74] = true;
            $jacocoInit[77] = true;
            return drawable;
        } catch (NumberFormatException e6) {
            e2 = e6;
            drawable = null;
            $jacocoInit[75] = true;
            Log.e(str, "Source string not a valid resource ID.", e2);
            $jacocoInit[76] = true;
            $jacocoInit[77] = true;
            return drawable;
        }
        $jacocoInit[77] = true;
        return drawable;
    }

    public C0120S<Void> cardViewClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.appCardView);
        $jacocoInit[61] = true;
        return a;
    }

    public C0120S<Void> installButtonClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.installButton);
        $jacocoInit[62] = true;
        return a;
    }

    public C0120S<Void> appCoinsWalletLinkClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a(this.appcMessageAppcoinsSection2a);
        $jacocoInit[63] = true;
        return a;
    }

    public void openApp(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        SystemU.openApp(packageName, getContext().getPackageManager(), getContext());
        $jacocoInit[64] = true;
    }

    public void setButtonText(boolean isInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        String installState = getResources().getString(C1375R.string.appview_button_install);
        if (isInstalled) {
            $jacocoInit[65] = true;
            this.installButton.setText(getResources().getString(C1375R.string.appview_button_open));
            $jacocoInit[66] = true;
        } else {
            this.installButton.setText(installState);
            $jacocoInit[67] = true;
        }
        $jacocoInit[68] = true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        View inflate = inflater.inflate(C1375R.layout.fragment_appcoins_info, container, false);
        $jacocoInit[69] = true;
        return inflate;
    }
}
