package p005cm.aptoide.p006pt.store.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannel;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.widget.Widget;

/* renamed from: cm.aptoide.pt.store.view.MetaStoresBaseWidget */
public abstract class MetaStoresBaseWidget<T extends Displayable> extends Widget<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.store.view.MetaStoresBaseWidget$1 */
    static /* synthetic */ class C49591 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$SocialChannelType */
        static final /* synthetic */ int[] f8614xeddf8529 = new int[SocialChannelType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-5784478819943376034L, "cm/aptoide/pt/store/view/MetaStoresBaseWidget$1", 10);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f8614xeddf8529[SocialChannelType.FACEBOOK.ordinal()] = 1;
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
            f8614xeddf8529[SocialChannelType.TWITTER.ordinal()] = 2;
            $jacocoInit[3] = true;
            f8614xeddf8529[SocialChannelType.YOUTUBE.ordinal()] = 3;
            $jacocoInit[5] = true;
            f8614xeddf8529[SocialChannelType.TWITCH.ordinal()] = 4;
            $jacocoInit[7] = true;
            $jacocoInit[9] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-533868906100739028L, "cm/aptoide/pt/store/view/MetaStoresBaseWidget", 43);
        $jacocoData = probes;
        return probes;
    }

    protected MetaStoresBaseWidget(View itemView) {
        boolean[] $jacocoInit = $jacocoInit();
        super(itemView);
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: protected */
    public void setupSocialLinks(List<SocialChannel> socialChannels, LinearLayout socialChannelsLayout) {
        boolean[] $jacocoInit = $jacocoInit();
        socialChannelsLayout.removeAllViews();
        $jacocoInit[1] = true;
        LayoutInflater layoutInflater = getContext().getLayoutInflater();
        $jacocoInit[2] = true;
        int i = 0;
        $jacocoInit[3] = true;
        while (i < socialChannels.size()) {
            $jacocoInit[4] = true;
            SocialChannel socialChannel = (SocialChannel) socialChannels.get(i);
            $jacocoInit[5] = true;
            if (socialChannel.getType() == null) {
                $jacocoInit[6] = true;
            } else {
                SocialChannelType type = socialChannel.getType();
                SocialChannelType socialChannelType = SocialChannelType.BLOG;
                $jacocoInit[7] = true;
                if (type.equals(socialChannelType)) {
                    $jacocoInit[8] = true;
                } else {
                    $jacocoInit[9] = true;
                    layoutInflater.inflate(C1375R.layout.social_button_layout, socialChannelsLayout);
                    $jacocoInit[10] = true;
                    int childCount = socialChannelsLayout.getChildCount() - 1;
                    $jacocoInit[11] = true;
                    ImageButton imageButton = (ImageButton) socialChannelsLayout.getChildAt(childCount);
                    $jacocoInit[12] = true;
                    int i2 = C49591.f8614xeddf8529[socialChannel.getType().ordinal()];
                    if (i2 == 1) {
                        imageButton.setImageDrawable(getDrawable(C1375R.drawable.logo_facebook_large));
                        $jacocoInit[14] = true;
                    } else if (i2 == 2) {
                        imageButton.setImageDrawable(getDrawable(C1375R.drawable.logo_twitter_large));
                        $jacocoInit[15] = true;
                    } else if (i2 == 3) {
                        imageButton.setImageDrawable(getDrawable(C1375R.drawable.logo_youtube_large));
                        $jacocoInit[16] = true;
                    } else if (i2 != 4) {
                        $jacocoInit[13] = true;
                    } else {
                        imageButton.setImageDrawable(getDrawable(C1375R.drawable.logo_twitch_large));
                        $jacocoInit[17] = true;
                    }
                    $jacocoInit[18] = true;
                    MarginLayoutParams layoutParams = (MarginLayoutParams) imageButton.getLayoutParams();
                    if (i == 0) {
                        $jacocoInit[19] = true;
                        int pixelsForDip = ScreenU.getPixelsForDip(4, getContext().getResources());
                        $jacocoInit[20] = true;
                        layoutParams.setMargins(0, 0, pixelsForDip, 0);
                        $jacocoInit[21] = true;
                    } else if (i == socialChannels.size() - 1) {
                        $jacocoInit[22] = true;
                        int pixelsForDip2 = ScreenU.getPixelsForDip(4, getContext().getResources());
                        $jacocoInit[23] = true;
                        layoutParams.setMargins(pixelsForDip2, 0, 0, 0);
                        $jacocoInit[24] = true;
                    } else {
                        $jacocoInit[25] = true;
                        int pixelsForDip3 = ScreenU.getPixelsForDip(4, getContext().getResources());
                        $jacocoInit[26] = true;
                        int pixelsForDip4 = ScreenU.getPixelsForDip(4, getContext().getResources());
                        $jacocoInit[27] = true;
                        layoutParams.setMargins(pixelsForDip3, 0, pixelsForDip4, 0);
                        $jacocoInit[28] = true;
                    }
                    imageButton.setOnClickListener(new C5022ia(this, socialChannel));
                    $jacocoInit[29] = true;
                }
            }
            i++;
            $jacocoInit[30] = true;
        }
        $jacocoInit[31] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16566a(SocialChannel socialChannel, View view) {
        boolean[] $jacocoInit = $jacocoInit();
        sendEvent(socialChannel.getUrl());
        $jacocoInit[42] = true;
    }

    private Drawable getDrawable(int drawable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 21) {
            $jacocoInit[32] = true;
            Drawable drawable2 = getContext().getDrawable(drawable);
            $jacocoInit[33] = true;
            return drawable2;
        }
        Resources resources = getContext().getResources();
        $jacocoInit[34] = true;
        Drawable drawable3 = resources.getDrawable(drawable);
        $jacocoInit[35] = true;
        return drawable3;
    }

    public void sendEvent(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(url)) {
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            Intent intent = new Intent("android.intent.action.VIEW");
            $jacocoInit[38] = true;
            intent.setData(Uri.parse(url));
            $jacocoInit[39] = true;
            getContext().startActivity(intent);
            $jacocoInit[40] = true;
        }
        $jacocoInit[41] = true;
    }
}
