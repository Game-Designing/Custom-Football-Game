package p005cm.aptoide.p006pt.wallet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.Group;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.C14268b;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.DownloadState;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.promotions.WalletApp;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.view.ActivityView;
import p019d.p022i.p296a.p305c.C13034a;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.wallet.WalletInstallActivity */
/* compiled from: WalletInstallActivity.kt */
public final class WalletInstallActivity extends ActivityView implements WalletInstallView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private HashMap _$_findViewCache;
    @Inject
    public WalletInstallPresenter presenter;

    /* renamed from: cm.aptoide.pt.wallet.WalletInstallActivity$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[DownloadState.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4579557290795786169L, "cm/aptoide/pt/wallet/WalletInstallActivity$WhenMappings", 1);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            $EnumSwitchMapping$0[DownloadState.ACTIVE.ordinal()] = 1;
            $EnumSwitchMapping$0[DownloadState.PAUSE.ordinal()] = 2;
            $EnumSwitchMapping$0[DownloadState.INDETERMINATE.ordinal()] = 3;
            $EnumSwitchMapping$0[DownloadState.INSTALLING.ordinal()] = 4;
            $EnumSwitchMapping$0[DownloadState.COMPLETE.ordinal()] = 5;
            $EnumSwitchMapping$0[DownloadState.ERROR.ordinal()] = 6;
            $EnumSwitchMapping$0[DownloadState.NOT_ENOUGH_STORAGE_ERROR.ordinal()] = 7;
            $jacocoInit[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2413645545355447207L, "cm/aptoide/pt/wallet/WalletInstallActivity", Opcodes.ISHL);
        $jacocoData = probes;
        return probes;
    }

    public void _$_clearFindViewByIdCache() {
        boolean[] $jacocoInit = $jacocoInit();
        HashMap hashMap = this._$_findViewCache;
        if (hashMap == null) {
            $jacocoInit[117] = true;
        } else {
            hashMap.clear();
            $jacocoInit[118] = true;
        }
        $jacocoInit[119] = true;
    }

    public View _$_findCachedViewById(int i) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this._$_findViewCache != null) {
            $jacocoInit[112] = true;
        } else {
            this._$_findViewCache = new HashMap();
            $jacocoInit[113] = true;
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            $jacocoInit[114] = true;
        } else {
            view = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
            $jacocoInit[115] = true;
        }
        $jacocoInit[116] = true;
        return view;
    }

    public WalletInstallActivity() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[110] = true;
        $jacocoInit[111] = true;
    }

    public final WalletInstallPresenter getPresenter() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletInstallPresenter walletInstallPresenter = this.presenter;
        if (walletInstallPresenter != null) {
            $jacocoInit[0] = true;
            $jacocoInit[2] = true;
            return walletInstallPresenter;
        }
        C14281f.m45917b("presenter");
        throw null;
    }

    public final void setPresenter(WalletInstallPresenter walletInstallPresenter) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletInstallPresenter, "<set-?>");
        this.presenter = walletInstallPresenter;
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate(savedInstanceState);
        $jacocoInit[4] = true;
        getActivityComponent().inject(this);
        $jacocoInit[5] = true;
        setContentView((int) C1375R.layout.wallet_install_activity);
        $jacocoInit[6] = true;
        initStyling();
        $jacocoInit[7] = true;
        WalletInstallPresenter walletInstallPresenter = this.presenter;
        if (walletInstallPresenter != null) {
            $jacocoInit[8] = true;
            attachPresenter(walletInstallPresenter);
            $jacocoInit[10] = true;
            return;
        }
        C14281f.m45917b("presenter");
        throw null;
    }

    private final void initStyling() {
        boolean[] $jacocoInit = $jacocoInit();
        String walletAppName = getString(C1375R.string.wallet_install_appcoins_wallet);
        $jacocoInit[11] = true;
        String message = getString(C1375R.string.wallet_install_request_message_body, new Object[]{walletAppName});
        $jacocoInit[12] = true;
        TextView textView = (TextView) _$_findCachedViewById(C1375R.C1376id.message_textview);
        String str = "message_textview";
        C14281f.m45913a((Object) textView, str);
        textView.setText(message);
        $jacocoInit[13] = true;
        TextView textView2 = (TextView) _$_findCachedViewById(C1375R.C1376id.message_textview);
        C14281f.m45913a((Object) textView2, str);
        setSubstringTypeface(textView2, new C14268b(walletAppName, Integer.valueOf(1)));
        $jacocoInit[14] = true;
    }

    public void showWalletInstallationView(String appIcon, WalletApp walletApp) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(walletApp, "walletApp");
        $jacocoInit[15] = true;
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C1375R.C1376id.progress_view);
        String str = "progress_view";
        C14281f.m45913a((Object) progressBar, str);
        progressBar.setVisibility(8);
        $jacocoInit[16] = true;
        Group group = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_success_view_group);
        C14281f.m45913a((Object) group, "wallet_install_success_view_group");
        group.setVisibility(8);
        $jacocoInit[17] = true;
        Button button = (Button) _$_findCachedViewById(C1375R.C1376id.close_button);
        C14281f.m45913a((Object) button, "close_button");
        button.setVisibility(8);
        if (appIcon != null) {
            String str2 = appIcon;
            $jacocoInit[18] = true;
            ImageLoader.with(this).load(appIcon, (ImageView) _$_findCachedViewById(C1375R.C1376id.app_icon_imageview));
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
        }
        DownloadModel downloadModel = walletApp.getDownloadModel();
        if (downloadModel != null) {
            $jacocoInit[21] = true;
            Logger instance = Logger.getInstance();
            $jacocoInit[22] = true;
            StringBuilder sb = new StringBuilder();
            sb.append("download state is ");
            sb.append(downloadModel.getDownloadState());
            instance.mo2136d("WalletInstallActivity", sb.toString());
            $jacocoInit[23] = true;
            if (downloadModel.isDownloading()) {
                $jacocoInit[24] = true;
                setDownloadProgress(downloadModel);
                $jacocoInit[25] = true;
            } else {
                View _$_findCachedViewById = _$_findCachedViewById(C1375R.C1376id.wallet_install_download_view);
                C14281f.m45913a((Object) _$_findCachedViewById, "wallet_install_download_view");
                _$_findCachedViewById.setVisibility(8);
                $jacocoInit[26] = true;
                ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C1375R.C1376id.progress_view);
                C14281f.m45913a((Object) progressBar2, str);
                progressBar2.setVisibility(8);
                $jacocoInit[27] = true;
                Group group2 = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_view_group);
                C14281f.m45913a((Object) group2, "wallet_install_view_group");
                group2.setVisibility(0);
                $jacocoInit[28] = true;
            }
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0191, code lost:
        r0[58] = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0196, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setDownloadProgress(p005cm.aptoide.p006pt.app.DownloadModel r9) {
        /*
            r8 = this;
            boolean[] r0 = $jacocoInit()
            int r1 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_install_download_view
            android.view.View r1 = r8._$_findCachedViewById(r1)
            java.lang.String r2 = "wallet_install_download_view"
            kotlin.p376c.p378b.C14281f.m45913a(r1, r2)
            r2 = 0
            r1.setVisibility(r2)
            r1 = 1
            r3 = 32
            r0[r3] = r1
            cm.aptoide.pt.app.DownloadModel$DownloadState r3 = r9.getDownloadState()
            if (r3 == 0) goto L_0x0197
            int[] r4 = p005cm.aptoide.p006pt.wallet.WalletInstallActivity.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            java.lang.String r4 = "wallet_download_progress_number"
            java.lang.String r5 = "wallet_download_cancel_button"
            java.lang.String r6 = "wallet_install_view_group"
            java.lang.String r7 = "wallet_download_progress_bar"
            switch(r3) {
                case 1: goto L_0x00f6;
                case 2: goto L_0x00f6;
                case 3: goto L_0x00be;
                case 4: goto L_0x0071;
                case 5: goto L_0x0071;
                case 6: goto L_0x0054;
                case 7: goto L_0x0037;
                default: goto L_0x0031;
            }
        L_0x0031:
            r2 = 34
            r0[r2] = r1
            goto L_0x019b
        L_0x0037:
            r2 = 54
            r0[r2] = r1
            r2 = 2131690228(0x7f0f02f4, float:1.9009494E38)
            java.lang.String r2 = r8.getString(r2)
            java.lang.String r3 = "getString(R.string.out_of_space_dialog_title)"
            kotlin.p376c.p378b.C14281f.m45913a(r2, r3)
            r3 = 55
            r0[r3] = r1
            r8.showErrorMessage(r2)
            r2 = 56
            r0[r2] = r1
            goto L_0x0191
        L_0x0054:
            r2 = 51
            r0[r2] = r1
            r2 = 2131689964(0x7f0f01ec, float:1.9008958E38)
            java.lang.String r2 = r8.getString(r2)
            java.lang.String r3 = "getString(R.string.error_occured)"
            kotlin.p376c.p378b.C14281f.m45913a(r2, r3)
            r3 = 52
            r0[r3] = r1
            r8.showErrorMessage(r2)
            r2 = 53
            r0[r2] = r1
            goto L_0x0191
        L_0x0071:
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_bar
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r7)
            r3.setIndeterminate(r1)
            r3 = 47
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_number
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r4)
            r4 = 8
            r3.setVisibility(r4)
            r3 = 48
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_install_view_group
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.support.constraint.Group r3 = (android.support.constraint.Group) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r6)
            r3.setVisibility(r2)
            r2 = 49
            r0[r2] = r1
            int r2 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_cancel_button
            android.view.View r2 = r8._$_findCachedViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            kotlin.p376c.p378b.C14281f.m45913a(r2, r5)
            r3 = 4
            r2.setVisibility(r3)
            r2 = 50
            r0[r2] = r1
            goto L_0x0191
        L_0x00be:
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_bar
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r7)
            r3.setIndeterminate(r1)
            r3 = 44
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_install_view_group
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.support.constraint.Group r3 = (android.support.constraint.Group) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r6)
            r3.setVisibility(r2)
            r3 = 45
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_cancel_button
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r5)
            r3.setVisibility(r2)
            r2 = 46
            r0[r2] = r1
            goto L_0x0191
        L_0x00f6:
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_install_view_group
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.support.constraint.Group r3 = (android.support.constraint.Group) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r6)
            r3.setVisibility(r2)
            r3 = 35
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_cancel_button
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r5)
            r3.setVisibility(r2)
            r3 = 36
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_bar
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r7)
            r3.setIndeterminate(r2)
            r3 = 37
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_bar
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r7)
            int r5 = r9.getProgress()
            r3.setProgress(r5)
            r3 = 38
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_number
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r4)
            r5 = 39
            r0[r5] = r1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 40
            r0[r6] = r1
            int r6 = r9.getProgress()
            r7 = 41
            r0[r7] = r1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r5.append(r6)
            java.lang.String r6 = "%"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.setText(r5)
            r3 = 42
            r0[r3] = r1
            int r3 = p005cm.aptoide.p006pt.C1375R.C1376id.wallet_download_progress_number
            android.view.View r3 = r8._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.p376c.p378b.C14281f.m45913a(r3, r4)
            r3.setVisibility(r2)
            r2 = 43
            r0[r2] = r1
        L_0x0191:
            r2 = 58
            r0[r2] = r1
            return
        L_0x0197:
            r2 = 33
            r0[r2] = r1
        L_0x019b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid download state"
            r3.append(r4)
            cm.aptoide.pt.app.DownloadModel$DownloadState r4 = r9.getDownloadState()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r3 = 57
            r0[r3] = r1
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.wallet.WalletInstallActivity.setDownloadProgress(cm.aptoide.pt.app.DownloadModel):void");
    }

    private final void showErrorMessage(String errorMessage) {
        boolean[] $jacocoInit = $jacocoInit();
        TextView textView = (TextView) _$_findCachedViewById(C1375R.C1376id.wallet_download_download_state);
        C14281f.m45913a((Object) textView, "wallet_download_download_state");
        textView.setText(errorMessage);
        $jacocoInit[59] = true;
    }

    public void showInstallationSuccessView() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getString(C1375R.string.wallet_install_complete_title);
        C14281f.m45913a((Object) string, "getString(R.string.wallet_install_complete_title)");
        $jacocoInit[60] = true;
        String string2 = getString(C1375R.string.wallet_install_complete_body);
        C14281f.m45913a((Object) string2, "getString(R.string.wallet_install_complete_body)");
        $jacocoInit[61] = true;
        showSuccessView(string, string2);
        $jacocoInit[62] = true;
    }

    public void showWalletInstalledAlreadyView() {
        boolean[] $jacocoInit = $jacocoInit();
        String string = getString(C1375R.string.wallet_install_request_already_installed_title);
        C14281f.m45913a((Object) string, "getString(R.string.walle…_already_installed_title)");
        $jacocoInit[63] = true;
        String string2 = getString(C1375R.string.wallet_install_request_already_installed_body);
        C14281f.m45913a((Object) string2, "getString(R.string.walle…t_already_installed_body)");
        $jacocoInit[64] = true;
        showSuccessView(string, string2);
        $jacocoInit[65] = true;
    }

    private final void showSuccessView(String title, String body) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageView imageView = (ImageView) _$_findCachedViewById(C1375R.C1376id.app_icon_imageview);
        $jacocoInit[66] = true;
        Drawable drawable = getResources().getDrawable(C1375R.drawable.ic_check_orange_gradient_start);
        $jacocoInit[67] = true;
        imageView.setImageDrawable(drawable);
        $jacocoInit[68] = true;
        TextView textView = (TextView) _$_findCachedViewById(C1375R.C1376id.message_textview);
        String str = "message_textview";
        C14281f.m45913a((Object) textView, str);
        textView.setText(title);
        $jacocoInit[69] = true;
        TextView textView2 = (TextView) _$_findCachedViewById(C1375R.C1376id.message_textview);
        C14281f.m45913a((Object) textView2, str);
        setSubstringTypeface(textView2, new C14268b(title, Integer.valueOf(1)));
        $jacocoInit[70] = true;
        TextView textView3 = (TextView) _$_findCachedViewById(C1375R.C1376id.install_complete_message);
        C14281f.m45913a((Object) textView3, "install_complete_message");
        textView3.setText(body);
        $jacocoInit[71] = true;
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C1375R.C1376id.progress_view);
        C14281f.m45913a((Object) progressBar, "progress_view");
        progressBar.setVisibility(8);
        $jacocoInit[72] = true;
        Group group = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_success_view_group);
        C14281f.m45913a((Object) group, "wallet_install_success_view_group");
        group.setVisibility(0);
        $jacocoInit[73] = true;
        Button button = (Button) _$_findCachedViewById(C1375R.C1376id.close_button);
        C14281f.m45913a((Object) button, "close_button");
        button.setVisibility(0);
        $jacocoInit[74] = true;
        Group group2 = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_view_group);
        C14281f.m45913a((Object) group2, "wallet_install_view_group");
        group2.setVisibility(0);
        $jacocoInit[75] = true;
        View _$_findCachedViewById = _$_findCachedViewById(C1375R.C1376id.wallet_install_download_view);
        C14281f.m45913a((Object) _$_findCachedViewById, "wallet_install_download_view");
        _$_findCachedViewById.setVisibility(8);
        $jacocoInit[76] = true;
    }

    public C0120S<Void> closeButtonClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a((Button) _$_findCachedViewById(C1375R.C1376id.close_button));
        C14281f.m45913a((Object) a, "RxView.clicks(close_button)");
        $jacocoInit[77] = true;
        return a;
    }

    public void dismissDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        finish();
        $jacocoInit[78] = true;
    }

    public void showSdkErrorView() {
        boolean[] $jacocoInit = $jacocoInit();
        Group group = (Group) _$_findCachedViewById(C1375R.C1376id.sdk_error_view_group);
        C14281f.m45913a((Object) group, "sdk_error_view_group");
        group.setVisibility(0);
        $jacocoInit[79] = true;
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C1375R.C1376id.progress_view);
        C14281f.m45913a((Object) progressBar, "progress_view");
        progressBar.setVisibility(8);
        $jacocoInit[80] = true;
        Button button = (Button) _$_findCachedViewById(C1375R.C1376id.close_button);
        C14281f.m45913a((Object) button, "close_button");
        button.setVisibility(0);
        $jacocoInit[81] = true;
        Group group2 = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_success_view_group);
        C14281f.m45913a((Object) group2, "wallet_install_success_view_group");
        group2.setVisibility(8);
        $jacocoInit[82] = true;
        Group group3 = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_view_group);
        C14281f.m45913a((Object) group3, "wallet_install_view_group");
        group3.setVisibility(4);
        $jacocoInit[83] = true;
    }

    public C0120S<Boolean> showRootInstallWarningPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        Context applicationContext = getApplicationContext();
        $jacocoInit[84] = true;
        String string = getResources().getString(C1375R.string.root_access_dialog);
        $jacocoInit[85] = true;
        C0120S createGenericYesNoCancelMessage = GenericDialogs.createGenericYesNoCancelMessage(applicationContext, null, string);
        $jacocoInit[86] = true;
        C0120S<Boolean> j = createGenericYesNoCancelMessage.mo3669j(WalletInstallActivity$showRootInstallWarningPopup$1.INSTANCE);
        C14281f.m45913a((Object) j, "GenericDialogs.createGen…cDialogs.EResponse.YES) }");
        $jacocoInit[87] = true;
        return j;
    }

    public final void setSubstringTypeface(TextView $this$setSubstringTypeface, C14268b<String, Integer>... textsToStyle) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b($this$setSubstringTypeface, "$this$setSubstringTypeface");
        C14281f.m45916b(textsToStyle, "textsToStyle");
        $jacocoInit[88] = true;
        SpannableString spannableString = new SpannableString($this$setSubstringTypeface.getText());
        int length = textsToStyle.length;
        $jacocoInit[89] = true;
        int i = 0;
        while (i < length) {
            C14268b textToStyle = textsToStyle[i];
            $jacocoInit[90] = true;
            int startIndex = C14325l.m45938a((CharSequence) $this$setSubstringTypeface.getText().toString(), (String) textToStyle.mo44425a(), 0, false, 6, (Object) null);
            $jacocoInit[91] = true;
            int endIndex = ((String) textToStyle.mo44425a()).length() + startIndex;
            if (startIndex < 0) {
                $jacocoInit[92] = true;
            } else {
                $jacocoInit[93] = true;
                StyleSpan styleSpan = new StyleSpan(((Number) textToStyle.mo44426b()).intValue());
                $jacocoInit[94] = true;
                spannableString.setSpan(styleSpan, startIndex, endIndex, 33);
                $jacocoInit[95] = true;
            }
            i++;
            $jacocoInit[96] = true;
        }
        $this$setSubstringTypeface.setText(spannableString, BufferType.SPANNABLE);
        $jacocoInit[97] = true;
    }

    public void showIndeterminateDownload() {
        boolean[] $jacocoInit = $jacocoInit();
        View _$_findCachedViewById = _$_findCachedViewById(C1375R.C1376id.wallet_install_download_view);
        C14281f.m45913a((Object) _$_findCachedViewById, "wallet_install_download_view");
        _$_findCachedViewById.setVisibility(0);
        $jacocoInit[98] = true;
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C1375R.C1376id.wallet_download_progress_bar);
        C14281f.m45913a((Object) progressBar, "wallet_download_progress_bar");
        progressBar.setIndeterminate(true);
        $jacocoInit[99] = true;
        Group group = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_view_group);
        C14281f.m45913a((Object) group, "wallet_install_view_group");
        group.setVisibility(0);
        $jacocoInit[100] = true;
    }

    public C0120S<Void> cancelDownloadButtonClicked() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Void> a = C13034a.m42490a((ImageView) _$_findCachedViewById(C1375R.C1376id.wallet_download_cancel_button));
        C14281f.m45913a((Object) a, "RxView.clicks(wallet_download_cancel_button)");
        $jacocoInit[101] = true;
        return a;
    }

    public void showDownloadState(DownloadModel downloadModel) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(downloadModel, "downloadModel");
        $jacocoInit[102] = true;
        String str = "wallet_install_download_view";
        if (downloadModel.isDownloadingOrInstalling()) {
            $jacocoInit[103] = true;
            View _$_findCachedViewById = _$_findCachedViewById(C1375R.C1376id.wallet_install_download_view);
            C14281f.m45913a((Object) _$_findCachedViewById, str);
            _$_findCachedViewById.setVisibility(0);
            $jacocoInit[104] = true;
            setDownloadProgress(downloadModel);
            $jacocoInit[105] = true;
        } else {
            View _$_findCachedViewById2 = _$_findCachedViewById(C1375R.C1376id.wallet_install_download_view);
            C14281f.m45913a((Object) _$_findCachedViewById2, str);
            _$_findCachedViewById2.setVisibility(8);
            $jacocoInit[106] = true;
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C1375R.C1376id.progress_view);
            C14281f.m45913a((Object) progressBar, "progress_view");
            progressBar.setVisibility(8);
            $jacocoInit[107] = true;
            Group group = (Group) _$_findCachedViewById(C1375R.C1376id.wallet_install_view_group);
            C14281f.m45913a((Object) group, "wallet_install_view_group");
            group.setVisibility(0);
            $jacocoInit[108] = true;
        }
        $jacocoInit[109] = true;
    }
}
