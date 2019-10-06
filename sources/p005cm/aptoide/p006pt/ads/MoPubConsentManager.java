package p005cm.aptoide.p006pt.ads;

import com.mopub.common.MoPub;
import com.mopub.common.privacy.ConsentDialogListener;
import com.mopub.common.privacy.PersonalInfoManager;
import com.mopub.mobileads.MoPubErrorCode;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.ads.MoPubConsentManager */
public class MoPubConsentManager implements MoPubConsentDialogManager, MoPubConsentDialogView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean wasMoPubConsentDialogShown;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2945676703590233945L, "cm/aptoide/pt/ads/MoPubConsentManager", 7);
        $jacocoData = probes;
        return probes;
    }

    static /* synthetic */ boolean access$000(MoPubConsentManager x0) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = x0.wasMoPubConsentDialogShown;
        $jacocoInit[5] = true;
        return z;
    }

    static /* synthetic */ boolean access$002(MoPubConsentManager x0, boolean x1) {
        boolean[] $jacocoInit = $jacocoInit();
        x0.wasMoPubConsentDialogShown = x1;
        $jacocoInit[6] = true;
        return x1;
    }

    public MoPubConsentManager() {
        $jacocoInit()[0] = true;
    }

    public void showConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        final PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        $jacocoInit[1] = true;
        personalInfoManager.loadConsentDialog(new ConsentDialogListener(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            final /* synthetic */ MoPubConsentManager this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-3780158509629765626L, "cm/aptoide/pt/ads/MoPubConsentManager$1", 13);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public void onConsentDialogLoaded() {
                boolean[] $jacocoInit = $jacocoInit();
                PersonalInfoManager personalInfoManager = personalInfoManager;
                if (personalInfoManager == null) {
                    $jacocoInit[1] = true;
                } else {
                    $jacocoInit[2] = true;
                    if (!personalInfoManager.isConsentDialogReady()) {
                        $jacocoInit[3] = true;
                    } else {
                        MoPubConsentManager moPubConsentManager = this.this$0;
                        $jacocoInit[4] = true;
                        if (MoPubConsentManager.access$000(moPubConsentManager)) {
                            $jacocoInit[5] = true;
                        } else {
                            $jacocoInit[6] = true;
                            MoPubConsentManager.access$002(this.this$0, true);
                            $jacocoInit[7] = true;
                            personalInfoManager.showConsentDialog();
                            $jacocoInit[8] = true;
                        }
                    }
                }
                $jacocoInit[9] = true;
            }

            public void onConsentDialogLoadFailed(MoPubErrorCode moPubErrorCode) {
                boolean[] $jacocoInit = $jacocoInit();
                Logger instance = Logger.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("MoPub Consent dialog failed to load due to ");
                $jacocoInit[10] = true;
                sb.append(moPubErrorCode.toString());
                String sb2 = sb.toString();
                $jacocoInit[11] = true;
                instance.mo2136d("MoPubConsent", sb2);
                $jacocoInit[12] = true;
            }
        });
        $jacocoInit[2] = true;
    }

    public Single<Boolean> shouldShowConsentDialog() {
        boolean[] $jacocoInit = $jacocoInit();
        PersonalInfoManager personalInfoManager = MoPub.getPersonalInformationManager();
        $jacocoInit[3] = true;
        Single<Boolean> a = Single.m734a(Boolean.valueOf(personalInfoManager.shouldShowConsentDialog()));
        $jacocoInit[4] = true;
        return a;
    }
}
