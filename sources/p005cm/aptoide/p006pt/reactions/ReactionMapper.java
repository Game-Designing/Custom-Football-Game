package p005cm.aptoide.p006pt.reactions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.reactions.data.ReactionType;

/* renamed from: cm.aptoide.pt.reactions.ReactionMapper */
public class ReactionMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: cm.aptoide.pt.reactions.ReactionMapper$1 */
    static /* synthetic */ class C46111 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType = new int[ReactionType.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(526067911006387549L, "cm/aptoide/pt/reactions/ReactionMapper$1", 6);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[ReactionType.LIKE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    $jacocoInit[4] = true;
                }
            }
            $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[ReactionType.DOWN.ordinal()] = 2;
            $jacocoInit[3] = true;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5569572817868585230L, "cm/aptoide/pt/reactions/ReactionMapper", 24);
        $jacocoData = probes;
        return probes;
    }

    public ReactionMapper() {
        $jacocoInit()[0] = true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int mapReaction(java.lang.String r7) {
        /*
            boolean[] r0 = $jacocoInit()
            r1 = -1
            r2 = 1
            r0[r2] = r2
            int r3 = r7.hashCode()
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r3) {
                case -1117280700: goto L_0x005c;
                case 3327858: goto L_0x004a;
                case 3559430: goto L_0x0037;
                case 102745729: goto L_0x0024;
                case 1330679997: goto L_0x0015;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0[r6] = r2
            goto L_0x006d
        L_0x0015:
            java.lang.String r3 = "thumbs_up"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0020
            r0[r5] = r2
            goto L_0x006d
        L_0x0020:
            r3 = 0
            r0[r4] = r2
            goto L_0x006e
        L_0x0024:
            java.lang.String r3 = "laugh"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0031
            r3 = 11
            r0[r3] = r2
            goto L_0x006d
        L_0x0031:
            r3 = 12
            r0[r3] = r2
            r3 = 4
            goto L_0x006e
        L_0x0037:
            java.lang.String r3 = "thug"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0044
            r3 = 9
            r0[r3] = r2
            goto L_0x006d
        L_0x0044:
            r3 = 10
            r0[r3] = r2
            r3 = 3
            goto L_0x006e
        L_0x004a:
            java.lang.String r3 = "love"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0056
            r3 = 7
            r0[r3] = r2
            goto L_0x006d
        L_0x0056:
            r3 = 8
            r0[r3] = r2
            r3 = 2
            goto L_0x006e
        L_0x005c:
            java.lang.String r3 = "thumbs_down"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L_0x0068
            r3 = 5
            r0[r3] = r2
            goto L_0x006d
        L_0x0068:
            r3 = 6
            r0[r3] = r2
            r3 = 1
            goto L_0x006e
        L_0x006d:
            r3 = -1
        L_0x006e:
            if (r3 == 0) goto L_0x009d
            if (r3 == r2) goto L_0x0095
            if (r3 == r6) goto L_0x008d
            if (r3 == r5) goto L_0x0085
            if (r3 == r4) goto L_0x007d
            r3 = 13
            r0[r3] = r2
            goto L_0x00a4
        L_0x007d:
            r1 = 2131231279(0x7f08022f, float:1.8078635E38)
            r3 = 18
            r0[r3] = r2
            goto L_0x00a4
        L_0x0085:
            r1 = 2131231282(0x7f080232, float:1.807864E38)
            r3 = 17
            r0[r3] = r2
            goto L_0x00a4
        L_0x008d:
            r1 = 2131231280(0x7f080230, float:1.8078637E38)
            r3 = 16
            r0[r3] = r2
            goto L_0x00a4
        L_0x0095:
            r1 = 2131231283(0x7f080233, float:1.8078643E38)
            r3 = 15
            r0[r3] = r2
            goto L_0x00a4
        L_0x009d:
            r1 = 2131231284(0x7f080234, float:1.8078645E38)
            r3 = 14
            r0[r3] = r2
        L_0x00a4:
            r3 = 19
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.reactions.ReactionMapper.mapReaction(java.lang.String):int");
    }

    public static String mapUserReaction(ReactionType type) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = C46111.$SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[type.ordinal()];
        if (i == 1) {
            $jacocoInit[20] = true;
            return "thumbs_up";
        } else if (i != 2) {
            String str = type.toString();
            $jacocoInit[22] = true;
            String lowerCase = str.toLowerCase();
            $jacocoInit[23] = true;
            return lowerCase;
        } else {
            $jacocoInit[21] = true;
            return "thumbs_down";
        }
    }
}
