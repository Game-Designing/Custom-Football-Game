package p005cm.aptoide.p006pt.promotions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.promotions.PromotionAppViewHolder */
public class PromotionAppViewHolder extends C1000w {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private TextView appDescription;
    private ImageView appIcon;
    private TextView appName;
    private TextView appSize;
    private int appState;
    private final DecimalFormat decimalFormat;
    private TextView numberOfDownloads;
    private Button promotionAction;
    private final C14963c<PromotionAppClick> promotionAppClick;
    private TextView rating;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6454369926918962906L, "cm/aptoide/pt/promotions/PromotionAppViewHolder", 71);
        $jacocoData = probes;
        return probes;
    }

    public PromotionAppViewHolder(View itemView, int appState2, C14963c<PromotionAppClick> promotionAppClick2, DecimalFormat decimalFormat2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        this.appState = appState2;
        $jacocoInit[0] = true;
        this.appIcon = (ImageView) itemView.findViewById(C1375R.C1376id.app_icon);
        $jacocoInit[1] = true;
        this.appName = (TextView) itemView.findViewById(C1375R.C1376id.app_name);
        $jacocoInit[2] = true;
        this.appDescription = (TextView) itemView.findViewById(C1375R.C1376id.app_description);
        $jacocoInit[3] = true;
        this.numberOfDownloads = (TextView) itemView.findViewById(C1375R.C1376id.number_of_downloads);
        $jacocoInit[4] = true;
        this.appSize = (TextView) itemView.findViewById(C1375R.C1376id.app_size);
        $jacocoInit[5] = true;
        this.rating = (TextView) itemView.findViewById(C1375R.C1376id.rating);
        $jacocoInit[6] = true;
        this.promotionAction = (Button) itemView.findViewById(C1375R.C1376id.promotion_app_action_button);
        this.promotionAppClick = promotionAppClick2;
        this.decimalFormat = decimalFormat2;
        $jacocoInit[7] = true;
    }

    public void setApp(PromotionViewApp app, boolean isWalletInstalled) {
        boolean[] $jacocoInit = $jacocoInit();
        setAppCardHeader(app);
        $jacocoInit[8] = true;
        Button button = this.promotionAction;
        Context context = this.itemView.getContext();
        int i = this.appState;
        $jacocoInit[9] = true;
        String string = context.getString(getButtonMessage(i), new Object[]{Float.valueOf(app.getAppcValue())});
        $jacocoInit[10] = true;
        button.setText(string);
        if (!isWalletInstalled) {
            $jacocoInit[11] = true;
            lockInstallButton(true);
            $jacocoInit[12] = true;
        } else {
            int i2 = this.appState;
            if (i2 == 5) {
                $jacocoInit[13] = true;
                lockInstallButton(true);
                $jacocoInit[14] = true;
            } else if (i2 == 4) {
                $jacocoInit[15] = true;
                this.promotionAction.setEnabled(true);
                $jacocoInit[16] = true;
                Button button2 = this.promotionAction;
                Context context2 = this.itemView.getContext();
                $jacocoInit[17] = true;
                Resources resources = context2.getResources();
                $jacocoInit[18] = true;
                Drawable drawable = resources.getDrawable(C1375R.drawable.card_border_rounded_green);
                $jacocoInit[19] = true;
                button2.setBackgroundDrawable(drawable);
                $jacocoInit[20] = true;
                this.promotionAction.setOnClickListener(new C4544ja(this, app));
                $jacocoInit[21] = true;
            } else {
                lockInstallButton(false);
                $jacocoInit[22] = true;
                this.promotionAction.setOnClickListener(new C4548ka(this, app));
                $jacocoInit[23] = true;
            }
        }
        $jacocoInit[24] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15621a(PromotionViewApp app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(app, getClickType(this.appState)));
        $jacocoInit[70] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15622b(PromotionViewApp app, View __) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick.onNext(new PromotionAppClick(app, getClickType(this.appState)));
        $jacocoInit[69] = true;
    }

    private void lockInstallButton(boolean lock) {
        boolean[] $jacocoInit = $jacocoInit();
        if (lock) {
            $jacocoInit[25] = true;
            this.promotionAction.setEnabled(false);
            $jacocoInit[26] = true;
            Button button = this.promotionAction;
            Context context = this.itemView.getContext();
            $jacocoInit[27] = true;
            Resources resources = context.getResources();
            $jacocoInit[28] = true;
            Drawable drawable = resources.getDrawable(C1375R.drawable.card_border_fog_grey_normal);
            $jacocoInit[29] = true;
            button.setBackgroundDrawable(drawable);
            $jacocoInit[30] = true;
            Button button2 = this.promotionAction;
            Context context2 = this.itemView.getContext();
            $jacocoInit[31] = true;
            Resources resources2 = context2.getResources();
            $jacocoInit[32] = true;
            int color = resources2.getColor(C1375R.color.grey_fog_light);
            $jacocoInit[33] = true;
            button2.setTextColor(color);
            $jacocoInit[34] = true;
        } else {
            TypedValue resultValue = new TypedValue();
            $jacocoInit[35] = true;
            Context context3 = this.itemView.getContext();
            $jacocoInit[36] = true;
            Theme theme = context3.getTheme();
            $jacocoInit[37] = true;
            theme.resolveAttribute(C1375R.attr.installButtonBackground, resultValue, true);
            $jacocoInit[38] = true;
            this.promotionAction.setTextColor(-1);
            $jacocoInit[39] = true;
            this.promotionAction.setEnabled(true);
            int i = resultValue.resourceId;
            if (i != 0) {
                $jacocoInit[40] = true;
                this.promotionAction.setBackgroundResource(i);
                $jacocoInit[41] = true;
            } else {
                Button button3 = this.promotionAction;
                Context context4 = this.itemView.getContext();
                $jacocoInit[42] = true;
                Resources resources3 = context4.getResources();
                $jacocoInit[43] = true;
                Drawable drawable2 = resources3.getDrawable(C1375R.drawable.card_border_rounded_orange);
                $jacocoInit[44] = true;
                button3.setBackgroundDrawable(drawable2);
                $jacocoInit[45] = true;
            }
        }
        $jacocoInit[46] = true;
    }

    private ClickType getClickType(int appState2) {
        ClickType clickType;
        boolean[] $jacocoInit = $jacocoInit();
        if (appState2 == 0) {
            clickType = ClickType.UPDATE;
            $jacocoInit[48] = true;
        } else if (appState2 == 1) {
            clickType = ClickType.DOWNLOAD;
            $jacocoInit[49] = true;
        } else if (appState2 == 3) {
            clickType = ClickType.INSTALL_APP;
            $jacocoInit[50] = true;
        } else if (appState2 == 4) {
            clickType = ClickType.CLAIM;
            $jacocoInit[51] = true;
        } else if (appState2 == 6) {
            clickType = ClickType.DOWNGRADE;
            $jacocoInit[47] = true;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong view type of promotion app");
            $jacocoInit[52] = true;
            throw illegalArgumentException;
        }
        $jacocoInit[53] = true;
        return clickType;
    }

    private int getButtonMessage(int appState2) {
        int message;
        boolean[] $jacocoInit = $jacocoInit();
        if (appState2 != 0) {
            if (!(appState2 == 1 || appState2 == 3)) {
                if (appState2 == 4) {
                    message = C1375R.string.holidayspromotion_button_claim;
                    $jacocoInit[56] = true;
                } else if (appState2 == 5) {
                    message = C1375R.string.holidayspromotion_button_claimed;
                    $jacocoInit[57] = true;
                } else if (appState2 != 6) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong view type of promotion app");
                    $jacocoInit[58] = true;
                    throw illegalArgumentException;
                }
            }
            message = C1375R.string.holidayspromotion_button_install;
            $jacocoInit[55] = true;
        } else {
            message = C1375R.string.holidayspromotion_button_update;
            $jacocoInit[54] = true;
        }
        $jacocoInit[59] = true;
        return message;
    }

    private void setAppCardHeader(PromotionViewApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageLoader with = ImageLoader.with(this.itemView.getContext());
        $jacocoInit[60] = true;
        with.load(app.getAppIcon(), this.appIcon);
        $jacocoInit[61] = true;
        this.appName.setText(app.getName());
        $jacocoInit[62] = true;
        this.appDescription.setText(app.getDescription());
        $jacocoInit[63] = true;
        this.appSize.setText(StringU.formatBytes(app.getSize(), false));
        $jacocoInit[64] = true;
        if (app.getRating() == 0.0f) {
            $jacocoInit[65] = true;
            this.rating.setText(C1375R.string.appcardview_title_no_stars);
            $jacocoInit[66] = true;
        } else {
            this.rating.setText(this.decimalFormat.format((double) app.getRating()));
            $jacocoInit[67] = true;
        }
        this.numberOfDownloads.setText(String.valueOf(app.getNumberOfDownloads()));
        $jacocoInit[68] = true;
    }
}
