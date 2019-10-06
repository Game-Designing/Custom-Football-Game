package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Item */
final class Item {
    int hashCode;
    int index;
    int intVal;
    long longVal;
    Item next;
    String strVal1;
    String strVal2;
    String strVal3;
    int type;

    Item() {
    }

    Item(int index2) {
        this.index = index2;
    }

    Item(int index2, Item i) {
        this.index = index2;
        this.type = i.type;
        this.intVal = i.intVal;
        this.longVal = i.longVal;
        this.strVal1 = i.strVal1;
        this.strVal2 = i.strVal2;
        this.strVal3 = i.strVal3;
        this.hashCode = i.hashCode;
    }

    /* access modifiers changed from: 0000 */
    public void set(int intVal2) {
        this.type = 3;
        this.intVal = intVal2;
        this.hashCode = (this.type + intVal2) & MoPubClientPositioning.NO_REPEAT;
    }

    /* access modifiers changed from: 0000 */
    public void set(long longVal2) {
        this.type = 5;
        this.longVal = longVal2;
        this.hashCode = (this.type + ((int) longVal2)) & MoPubClientPositioning.NO_REPEAT;
    }

    /* access modifiers changed from: 0000 */
    public void set(float floatVal) {
        this.type = 4;
        this.intVal = Float.floatToRawIntBits(floatVal);
        this.hashCode = (this.type + ((int) floatVal)) & MoPubClientPositioning.NO_REPEAT;
    }

    /* access modifiers changed from: 0000 */
    public void set(double doubleVal) {
        this.type = 6;
        this.longVal = Double.doubleToRawLongBits(doubleVal);
        this.hashCode = (this.type + ((int) doubleVal)) & MoPubClientPositioning.NO_REPEAT;
    }

    /* access modifiers changed from: 0000 */
    public void set(int type2, String strVal12, String strVal22, String strVal32) {
        this.type = type2;
        this.strVal1 = strVal12;
        this.strVal2 = strVal22;
        this.strVal3 = strVal32;
        if (type2 != 1) {
            if (type2 == 12) {
                this.hashCode = ((strVal12.hashCode() * strVal22.hashCode()) + type2) & MoPubClientPositioning.NO_REPEAT;
                return;
            } else if (!(type2 == 16 || type2 == 30)) {
                if (type2 == 7) {
                    this.intVal = 0;
                } else if (type2 != 8) {
                    this.hashCode = ((strVal12.hashCode() * strVal22.hashCode() * strVal32.hashCode()) + type2) & MoPubClientPositioning.NO_REPEAT;
                    return;
                }
            }
        }
        this.hashCode = (strVal12.hashCode() + type2) & MoPubClientPositioning.NO_REPEAT;
    }

    /* access modifiers changed from: 0000 */
    public void set(String name, String desc, int bsmIndex) {
        this.type = 18;
        this.longVal = (long) bsmIndex;
        this.strVal1 = name;
        this.strVal2 = desc;
        this.hashCode = Integer.MAX_VALUE & ((this.strVal1.hashCode() * bsmIndex * this.strVal2.hashCode()) + 18);
    }

    /* access modifiers changed from: 0000 */
    public void set(int position, int hashCode2) {
        this.type = 33;
        this.intVal = position;
        this.hashCode = hashCode2;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r9.longVal != r8.longVal) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEqualTo(org.jacoco.agent.p025rt.internal_8ff85ea.asm.Item r9) {
        /*
            r8 = this;
            int r0 = r8.type
            r1 = 1
            if (r0 == r1) goto L_0x0096
            r2 = 12
            r3 = 0
            if (r0 == r2) goto L_0x007f
            r2 = 16
            if (r0 == r2) goto L_0x0096
            r2 = 18
            if (r0 == r2) goto L_0x0060
            switch(r0) {
                case 3: goto L_0x0057;
                case 4: goto L_0x0057;
                case 5: goto L_0x004c;
                case 6: goto L_0x004c;
                case 7: goto L_0x0096;
                case 8: goto L_0x0096;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r0) {
                case 30: goto L_0x0096;
                case 31: goto L_0x0039;
                case 32: goto L_0x004c;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r9.strVal2
            java.lang.String r2 = r8.strVal2
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r9.strVal3
            java.lang.String r2 = r8.strVal3
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            return r1
        L_0x0039:
            int r0 = r9.intVal
            int r2 = r8.intVal
            if (r0 != r2) goto L_0x004a
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            return r1
        L_0x004c:
            long r4 = r9.longVal
            long r6 = r8.longVal
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            return r1
        L_0x0057:
            int r0 = r9.intVal
            int r2 = r8.intVal
            if (r0 != r2) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            return r1
        L_0x0060:
            long r4 = r9.longVal
            long r6 = r8.longVal
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x007d
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = r9.strVal2
            java.lang.String r2 = r8.strVal2
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r1 = 0
        L_0x007e:
            return r1
        L_0x007f:
            java.lang.String r0 = r9.strVal1
            java.lang.String r2 = r8.strVal1
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = r9.strVal2
            java.lang.String r2 = r8.strVal2
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            return r1
        L_0x0096:
            java.lang.String r0 = r9.strVal1
            java.lang.String r1 = r8.strVal1
            boolean r0 = r0.equals(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p025rt.internal_8ff85ea.asm.Item.isEqualTo(org.jacoco.agent.rt.internal_8ff85ea.asm.Item):boolean");
    }
}
