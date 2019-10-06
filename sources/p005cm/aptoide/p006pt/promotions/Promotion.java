package p005cm.aptoide.p006pt.promotions;

import java.util.List;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.Promotion */
/* compiled from: Promotion.kt */
public final class Promotion {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final float appc;
    private List<? extends ClaimAction> claimActions;
    private boolean isClaimed;
    private final String packageName;
    private final String promotionId;

    /* renamed from: cm.aptoide.pt.promotions.Promotion$ClaimAction */
    /* compiled from: Promotion.kt */
    public enum ClaimAction {
        INSTALL,
        MIGRATE;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[0] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6201592678186229167L, "cm/aptoide/pt/promotions/Promotion", 71);
        $jacocoData = probes;
        return probes;
    }

    public Promotion() {
        boolean[] $jacocoInit = $jacocoInit();
        this(false, 0.0f, null, null, null, 31, null);
        $jacocoInit[31] = true;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<? extends cm.aptoide.pt.promotions.Promotion$ClaimAction>, for r13v0, types: [java.util.List] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ p005cm.aptoide.p006pt.promotions.Promotion copy$default(p005cm.aptoide.p006pt.promotions.Promotion r8, boolean r9, float r10, java.lang.String r11, java.lang.String r12, java.util.List<? extends p005cm.aptoide.p006pt.promotions.Promotion.ClaimAction> r13, int r14, java.lang.Object r15) {
        /*
            boolean[] r15 = $jacocoInit()
            r0 = r14 & 1
            r1 = 1
            if (r0 != 0) goto L_0x000e
            r0 = 38
            r15[r0] = r1
            goto L_0x0014
        L_0x000e:
            boolean r9 = r8.isClaimed
            r0 = 39
            r15[r0] = r1
        L_0x0014:
            r3 = r9
            r9 = r14 & 2
            if (r9 != 0) goto L_0x001e
            r9 = 40
            r15[r9] = r1
            goto L_0x0024
        L_0x001e:
            float r10 = r8.appc
            r9 = 41
            r15[r9] = r1
        L_0x0024:
            r4 = r10
            r9 = r14 & 4
            if (r9 != 0) goto L_0x002e
            r9 = 42
            r15[r9] = r1
            goto L_0x0034
        L_0x002e:
            java.lang.String r11 = r8.packageName
            r9 = 43
            r15[r9] = r1
        L_0x0034:
            r5 = r11
            r9 = r14 & 8
            if (r9 != 0) goto L_0x003e
            r9 = 44
            r15[r9] = r1
            goto L_0x0044
        L_0x003e:
            java.lang.String r12 = r8.promotionId
            r9 = 45
            r15[r9] = r1
        L_0x0044:
            r6 = r12
            r9 = r14 & 16
            if (r9 != 0) goto L_0x004e
            r9 = 46
            r15[r9] = r1
            goto L_0x0054
        L_0x004e:
            java.util.List<? extends cm.aptoide.pt.promotions.Promotion$ClaimAction> r13 = r8.claimActions
            r9 = 47
            r15[r9] = r1
        L_0x0054:
            r7 = r13
            r2 = r8
            cm.aptoide.pt.promotions.Promotion r8 = r2.copy(r3, r4, r5, r6, r7)
            r9 = 48
            r15[r9] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.promotions.Promotion.copy$default(cm.aptoide.pt.promotions.Promotion, boolean, float, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):cm.aptoide.pt.promotions.Promotion");
    }

    public final boolean component1() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isClaimed;
        $jacocoInit[32] = true;
        return z;
    }

    public final float component2() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.appc;
        $jacocoInit[33] = true;
        return f;
    }

    public final String component3() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[34] = true;
        return str;
    }

    public final String component4() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.promotionId;
        $jacocoInit[35] = true;
        return str;
    }

    public final List<ClaimAction> component5() {
        boolean[] $jacocoInit = $jacocoInit();
        List<? extends ClaimAction> list = this.claimActions;
        $jacocoInit[36] = true;
        return list;
    }

    public final Promotion copy(boolean z, float f, String str, String str2, List<? extends ClaimAction> list) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(str, "packageName");
        C14281f.m45916b(str2, "promotionId");
        C14281f.m45916b(list, "claimActions");
        Promotion promotion = new Promotion(z, f, str, str2, list);
        $jacocoInit[37] = true;
        return promotion;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this == obj) {
            $jacocoInit[59] = true;
        } else {
            if (!(obj instanceof Promotion)) {
                $jacocoInit[60] = true;
            } else {
                Promotion promotion = (Promotion) obj;
                if (this.isClaimed == promotion.isClaimed) {
                    $jacocoInit[61] = true;
                    z = true;
                } else {
                    $jacocoInit[62] = true;
                    z = false;
                }
                if (!z) {
                    $jacocoInit[63] = true;
                } else if (Float.compare(this.appc, promotion.appc) != 0) {
                    $jacocoInit[64] = true;
                } else if (!C14281f.m45915a((Object) this.packageName, (Object) promotion.packageName)) {
                    $jacocoInit[65] = true;
                } else if (!C14281f.m45915a((Object) this.promotionId, (Object) promotion.promotionId)) {
                    $jacocoInit[66] = true;
                } else if (!C14281f.m45915a((Object) this.claimActions, (Object) promotion.claimActions)) {
                    $jacocoInit[67] = true;
                } else {
                    $jacocoInit[68] = true;
                }
            }
            $jacocoInit[70] = true;
            return false;
        }
        $jacocoInit[69] = true;
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isClaimed;
        if (!z) {
            $jacocoInit[50] = true;
        } else {
            $jacocoInit[51] = true;
            z = true;
        }
        int floatToIntBits = (((z ? 1 : 0) * true) + Float.floatToIntBits(this.appc)) * 31;
        String str = this.packageName;
        int i3 = 0;
        if (str != null) {
            i = str.hashCode();
            $jacocoInit[52] = true;
        } else {
            $jacocoInit[53] = true;
            i = 0;
        }
        int i4 = (floatToIntBits + i) * 31;
        String str2 = this.promotionId;
        if (str2 != null) {
            i2 = str2.hashCode();
            $jacocoInit[54] = true;
        } else {
            $jacocoInit[55] = true;
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        List<? extends ClaimAction> list = this.claimActions;
        if (list != null) {
            i3 = list.hashCode();
            $jacocoInit[56] = true;
        } else {
            $jacocoInit[57] = true;
        }
        int i6 = i5 + i3;
        $jacocoInit[58] = true;
        return i6;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("Promotion(isClaimed=");
        sb.append(this.isClaimed);
        sb.append(", appc=");
        sb.append(this.appc);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", promotionId=");
        sb.append(this.promotionId);
        sb.append(", claimActions=");
        sb.append(this.claimActions);
        sb.append(")");
        String sb2 = sb.toString();
        $jacocoInit[49] = true;
        return sb2;
    }

    public Promotion(boolean isClaimed2, float appc2, String packageName2, String promotionId2, List<? extends ClaimAction> claimActions2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(packageName2, "packageName");
        C14281f.m45916b(promotionId2, "promotionId");
        C14281f.m45916b(claimActions2, "claimActions");
        $jacocoInit[17] = true;
        this.isClaimed = isClaimed2;
        this.appc = appc2;
        this.packageName = packageName2;
        this.promotionId = promotionId2;
        this.claimActions = claimActions2;
        $jacocoInit[18] = true;
    }

    public /* synthetic */ Promotion(boolean z, float f, String str, String str2, List list, int i, C14280e eVar) {
        boolean z2;
        float f2;
        String str3;
        String str4;
        List list2;
        boolean[] $jacocoInit = $jacocoInit();
        if ((i & 1) == 0) {
            $jacocoInit[19] = true;
            z2 = z;
        } else {
            $jacocoInit[20] = true;
            z2 = false;
        }
        if ((i & 2) == 0) {
            $jacocoInit[21] = true;
            f2 = f;
        } else {
            $jacocoInit[22] = true;
            f2 = -1.0f;
        }
        String str5 = "";
        if ((i & 4) == 0) {
            $jacocoInit[23] = true;
            str3 = str;
        } else {
            $jacocoInit[24] = true;
            str3 = str5;
        }
        if ((i & 8) == 0) {
            $jacocoInit[25] = true;
            str4 = str2;
        } else {
            $jacocoInit[26] = true;
            str4 = str5;
        }
        if ((i & 16) == 0) {
            $jacocoInit[27] = true;
            list2 = list;
        } else {
            $jacocoInit[28] = true;
            List a = C14256c.m45895a();
            $jacocoInit[29] = true;
            list2 = a;
        }
        this(z2, f2, str3, str4, list2);
        $jacocoInit[30] = true;
    }

    public final boolean isClaimed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isClaimed;
        $jacocoInit[10] = true;
        return z;
    }

    public final void setClaimed(boolean z) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isClaimed = z;
        $jacocoInit[11] = true;
    }

    public final float getAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.appc;
        $jacocoInit[12] = true;
        return f;
    }

    public final String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[13] = true;
        return str;
    }

    public final String getPromotionId() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.promotionId;
        $jacocoInit[14] = true;
        return str;
    }

    public final List<ClaimAction> getClaimActions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<? extends ClaimAction> list = this.claimActions;
        $jacocoInit[15] = true;
        return list;
    }

    public final void setClaimActions(List<? extends ClaimAction> list) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(list, "<set-?>");
        this.claimActions = list;
        $jacocoInit[16] = true;
    }

    public final boolean exists() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        boolean z2 = false;
        if (this.promotionId.length() == 0) {
            $jacocoInit[0] = true;
            z = true;
        } else {
            $jacocoInit[1] = true;
            z = false;
        }
        if (!z) {
            $jacocoInit[2] = true;
            z2 = true;
        } else {
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
        return z2;
    }

    public final boolean isClaimable() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!exists()) {
            $jacocoInit[5] = true;
        } else if (this.isClaimed) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            z = true;
            $jacocoInit[9] = true;
            return z;
        }
        z = false;
        $jacocoInit[8] = true;
        $jacocoInit[9] = true;
        return z;
    }
}
