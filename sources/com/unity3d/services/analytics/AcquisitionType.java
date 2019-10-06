package com.unity3d.services.analytics;

public enum AcquisitionType {
    SOFT,
    PREMIUM;

    /* renamed from: com.unity3d.services.analytics.AcquisitionType$1 */
    static /* synthetic */ class C125991 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$analytics$AcquisitionType = null;

        static {
            $SwitchMap$com$unity3d$services$analytics$AcquisitionType = new int[AcquisitionType.values().length];
            try {
                $SwitchMap$com$unity3d$services$analytics$AcquisitionType[AcquisitionType.SOFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$unity3d$services$analytics$AcquisitionType[AcquisitionType.PREMIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public String toString() {
        int i = C125991.$SwitchMap$com$unity3d$services$analytics$AcquisitionType[ordinal()];
        if (i == 1) {
            return "soft";
        }
        if (i != 2) {
            return "";
        }
        return "premium";
    }
}
