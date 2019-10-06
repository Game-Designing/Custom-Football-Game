package p005cm.aptoide.p006pt.promotions;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.PromotionMeta */
/* compiled from: PromotionMeta.kt */
public final class PromotionMeta {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String background;
    private final String promotionId;
    private final String title;
    private final String type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2978956050300292188L, "cm/aptoide/pt/promotions/PromotionMeta", 50);
        $jacocoData = probes;
        return probes;
    }

    public PromotionMeta() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null, null, null, null, 15, null);
        $jacocoInit[16] = true;
    }

    public static /* synthetic */ PromotionMeta copy$default(PromotionMeta promotionMeta, String str, String str2, String str3, String str4, int i, Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[22] = true;
        } else {
            str = promotionMeta.title;
            $jacocoInit[23] = true;
        }
        if ((i & 2) == 0) {
            $jacocoInit[24] = true;
        } else {
            str2 = promotionMeta.promotionId;
            $jacocoInit[25] = true;
        }
        if ((i & 4) == 0) {
            $jacocoInit[26] = true;
        } else {
            str3 = promotionMeta.type;
            $jacocoInit[27] = true;
        }
        if ((i & 8) == 0) {
            $jacocoInit[28] = true;
        } else {
            str4 = promotionMeta.background;
            $jacocoInit[29] = true;
        }
        PromotionMeta copy = promotionMeta.copy(str, str2, str3, str4);
        $jacocoInit[30] = true;
        return copy;
    }

    public final String component1() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[17] = true;
        return str;
    }

    public final String component2() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.promotionId;
        $jacocoInit[18] = true;
        return str;
    }

    public final String component3() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[19] = true;
        return str;
    }

    public final String component4() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.background;
        $jacocoInit[20] = true;
        return str;
    }

    public final PromotionMeta copy(String str, String str2, String str3, String str4) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(str, "title");
        C14281f.m45916b(str2, "promotionId");
        C14281f.m45916b(str3, "type");
        C14281f.m45916b(str4, "background");
        PromotionMeta promotionMeta = new PromotionMeta(str, str2, str3, str4);
        $jacocoInit[21] = true;
        return promotionMeta;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[41] = true;
        } else {
            if (!(obj instanceof PromotionMeta)) {
                $jacocoInit[42] = true;
            } else {
                PromotionMeta promotionMeta = (PromotionMeta) obj;
                if (!C14281f.m45915a((Object) this.title, (Object) promotionMeta.title)) {
                    $jacocoInit[43] = true;
                } else if (!C14281f.m45915a((Object) this.promotionId, (Object) promotionMeta.promotionId)) {
                    $jacocoInit[44] = true;
                } else if (!C14281f.m45915a((Object) this.type, (Object) promotionMeta.type)) {
                    $jacocoInit[45] = true;
                } else if (!C14281f.m45915a((Object) this.background, (Object) promotionMeta.background)) {
                    $jacocoInit[46] = true;
                } else {
                    $jacocoInit[47] = true;
                }
            }
            $jacocoInit[49] = true;
            return false;
        }
        $jacocoInit[48] = true;
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            i = 0;
        }
        int i5 = i * 31;
        String str2 = this.promotionId;
        if (str2 != null) {
            i2 = str2.hashCode();
            $jacocoInit[34] = true;
        } else {
            $jacocoInit[35] = true;
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        String str3 = this.type;
        if (str3 != null) {
            i3 = str3.hashCode();
            $jacocoInit[36] = true;
        } else {
            $jacocoInit[37] = true;
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        String str4 = this.background;
        if (str4 != null) {
            i4 = str4.hashCode();
            $jacocoInit[38] = true;
        } else {
            $jacocoInit[39] = true;
        }
        int i8 = i7 + i4;
        $jacocoInit[40] = true;
        return i8;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("PromotionMeta(title=");
        sb.append(this.title);
        sb.append(", promotionId=");
        sb.append(this.promotionId);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", background=");
        sb.append(this.background);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[31] = true;
        return sb2;
    }

    public PromotionMeta(String title2, String promotionId2, String type2, String background2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(title2, "title");
        C14281f.m45916b(promotionId2, "promotionId");
        C14281f.m45916b(type2, "type");
        C14281f.m45916b(background2, "background");
        $jacocoInit[4] = true;
        this.title = title2;
        this.promotionId = promotionId2;
        this.type = type2;
        this.background = background2;
        $jacocoInit[5] = true;
    }

    public /* synthetic */ PromotionMeta(String str, String str2, String str3, String str4, int i, C14280e eVar) {
        boolean[] $jacocoInit = $jacocoInit();
        String str5 = "";
        if ((i & 1) == 0) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            str = str5;
        }
        if ((i & 2) == 0) {
            $jacocoInit[8] = true;
        } else {
            $jacocoInit[9] = true;
            str2 = str5;
        }
        if ((i & 4) == 0) {
            $jacocoInit[10] = true;
        } else {
            $jacocoInit[11] = true;
            str3 = str5;
        }
        if ((i & 8) == 0) {
            $jacocoInit[12] = true;
        } else {
            $jacocoInit[13] = true;
            $jacocoInit[14] = true;
            str4 = str5;
        }
        this(str, str2, str3, str4);
        $jacocoInit[15] = true;
    }

    public final String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[0] = true;
        return str;
    }

    public final String getPromotionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.promotionId;
        $jacocoInit[1] = true;
        return str;
    }

    public final String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[2] = true;
        return str;
    }

    public final String getBackground() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.background;
        $jacocoInit[3] = true;
        return str;
    }
}
