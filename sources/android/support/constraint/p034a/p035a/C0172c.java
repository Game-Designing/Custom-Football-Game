package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0198e;

/* renamed from: android.support.constraint.a.a.c */
/* compiled from: Chain */
class C0172c {
    /* renamed from: a */
    static void m933a(C0182i constraintWidgetContainer, C0198e system, int orientation) {
        C0173d[] chainsArray;
        int chainsSize;
        int offset;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.f461Da;
            chainsArray = constraintWidgetContainer.f464Ga;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.f462Ea;
            chainsArray = constraintWidgetContainer.f463Fa;
        }
        for (int i = 0; i < chainsSize; i++) {
            C0173d first = chainsArray[i];
            first.mo3835a();
            if (!constraintWidgetContainer.mo3834t(4)) {
                m934a(constraintWidgetContainer, system, orientation, offset, first);
            } else if (!C0187n.m1084a(constraintWidgetContainer, system, orientation, offset, first)) {
                m934a(constraintWidgetContainer, system, orientation, offset, first);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x049a  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x05a3  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0610 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0622  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0625  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x062c  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x062f  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0632  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0644  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0652  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0655 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m934a(android.support.constraint.p034a.p035a.C0182i r44, android.support.constraint.p034a.C0198e r45, int r46, int r47, android.support.constraint.p034a.p035a.C0173d r48) {
        /*
            r0 = r44
            r10 = r45
            r11 = r48
            android.support.constraint.a.a.h r12 = r11.f333a
            android.support.constraint.a.a.h r13 = r11.f335c
            android.support.constraint.a.a.h r14 = r11.f334b
            android.support.constraint.a.a.h r15 = r11.f336d
            android.support.constraint.a.a.h r9 = r11.f337e
            r1 = r12
            r2 = 0
            r3 = 0
            float r4 = r11.f343k
            android.support.constraint.a.a.h r8 = r11.f338f
            android.support.constraint.a.a.h r7 = r11.f339g
            android.support.constraint.a.a.h$a[] r5 = r0.f386F
            r5 = r5[r46]
            android.support.constraint.a.a.h$a r6 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            r16 = r1
            if (r5 != r6) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            r18 = r5
            r5 = 0
            r6 = 0
            r19 = 0
            if (r46 != 0) goto L_0x0052
            int r1 = r9.f431ma
            if (r1 != 0) goto L_0x0034
            r1 = 1
            goto L_0x0035
        L_0x0034:
            r1 = 0
        L_0x0035:
            int r5 = r9.f431ma
            r22 = r1
            r1 = 1
            if (r5 != r1) goto L_0x003e
            r1 = 1
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            int r5 = r9.f431ma
            r6 = 2
            if (r5 != r6) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            r21 = r1
            r23 = r2
            r19 = r5
            r6 = r16
            r16 = r3
            goto L_0x0075
        L_0x0052:
            int r1 = r9.f433na
            if (r1 != 0) goto L_0x0058
            r1 = 1
            goto L_0x0059
        L_0x0058:
            r1 = 0
        L_0x0059:
            int r5 = r9.f433na
            r22 = r1
            r1 = 1
            if (r5 != r1) goto L_0x0062
            r1 = 1
            goto L_0x0063
        L_0x0062:
            r1 = 0
        L_0x0063:
            int r5 = r9.f433na
            r6 = 2
            if (r5 != r6) goto L_0x006a
            r5 = 1
            goto L_0x006b
        L_0x006a:
            r5 = 0
        L_0x006b:
            r21 = r1
            r23 = r2
            r19 = r5
            r6 = r16
            r16 = r3
        L_0x0075:
            r3 = 5
            if (r16 != 0) goto L_0x014f
            android.support.constraint.a.a.f[] r2 = r6.f384D
            r2 = r2[r47]
            r24 = 4
            if (r18 != 0) goto L_0x0082
            if (r19 == 0) goto L_0x0084
        L_0x0082:
            r24 = 1
        L_0x0084:
            int r25 = r2.mo3841b()
            android.support.constraint.a.a.f r5 = r2.f354d
            if (r5 == 0) goto L_0x0097
            if (r6 == r12) goto L_0x0097
            int r5 = r5.mo3841b()
            int r25 = r25 + r5
            r5 = r25
            goto L_0x0099
        L_0x0097:
            r5 = r25
        L_0x0099:
            if (r19 == 0) goto L_0x00a4
            if (r6 == r12) goto L_0x00a4
            if (r6 == r14) goto L_0x00a4
            r24 = 6
            r27 = r24
            goto L_0x00af
        L_0x00a4:
            if (r22 == 0) goto L_0x00ad
            if (r18 == 0) goto L_0x00ad
            r24 = 4
            r27 = r24
            goto L_0x00af
        L_0x00ad:
            r27 = r24
        L_0x00af:
            android.support.constraint.a.a.f r1 = r2.f354d
            if (r1 == 0) goto L_0x00d5
            if (r6 != r14) goto L_0x00bf
            r25 = r4
            android.support.constraint.a.i r4 = r2.f360j
            android.support.constraint.a.i r1 = r1.f360j
            r10.mo4024b(r4, r1, r5, r3)
            goto L_0x00c9
        L_0x00bf:
            r25 = r4
            android.support.constraint.a.i r4 = r2.f360j
            android.support.constraint.a.i r1 = r1.f360j
            r3 = 6
            r10.mo4024b(r4, r1, r5, r3)
        L_0x00c9:
            android.support.constraint.a.i r1 = r2.f360j
            android.support.constraint.a.a.f r3 = r2.f354d
            android.support.constraint.a.i r3 = r3.f360j
            r4 = r27
            r10.mo4010a(r1, r3, r5, r4)
            goto L_0x00d9
        L_0x00d5:
            r25 = r4
            r4 = r27
        L_0x00d9:
            if (r18 == 0) goto L_0x0117
            int r1 = r6.mo3918r()
            r3 = 8
            if (r1 == r3) goto L_0x0101
            android.support.constraint.a.a.h$a[] r1 = r6.f386F
            r1 = r1[r46]
            android.support.constraint.a.a.h$a r3 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r1 != r3) goto L_0x0101
            android.support.constraint.a.a.f[] r1 = r6.f384D
            int r3 = r47 + 1
            r3 = r1[r3]
            android.support.constraint.a.i r3 = r3.f360j
            r1 = r1[r47]
            android.support.constraint.a.i r1 = r1.f360j
            r26 = r2
            r27 = r4
            r2 = 5
            r4 = 0
            r10.mo4024b(r3, r1, r4, r2)
            goto L_0x0105
        L_0x0101:
            r26 = r2
            r27 = r4
        L_0x0105:
            android.support.constraint.a.a.f[] r1 = r6.f384D
            r1 = r1[r47]
            android.support.constraint.a.i r1 = r1.f360j
            android.support.constraint.a.a.f[] r2 = r0.f384D
            r2 = r2[r47]
            android.support.constraint.a.i r2 = r2.f360j
            r3 = 6
            r4 = 0
            r10.mo4024b(r1, r2, r4, r3)
            goto L_0x011b
        L_0x0117:
            r26 = r2
            r27 = r4
        L_0x011b:
            android.support.constraint.a.a.f[] r1 = r6.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            android.support.constraint.a.a.f r1 = r1.f354d
            if (r1 == 0) goto L_0x013f
            android.support.constraint.a.a.h r2 = r1.f352b
            android.support.constraint.a.a.f[] r3 = r2.f384D
            r4 = r3[r47]
            android.support.constraint.a.a.f r4 = r4.f354d
            if (r4 == 0) goto L_0x013b
            r3 = r3[r47]
            android.support.constraint.a.a.f r3 = r3.f354d
            android.support.constraint.a.a.h r3 = r3.f352b
            if (r3 == r6) goto L_0x0138
            goto L_0x013b
        L_0x0138:
            r23 = r2
            goto L_0x0142
        L_0x013b:
            r2 = 0
            r23 = r2
            goto L_0x0142
        L_0x013f:
            r2 = 0
            r23 = r2
        L_0x0142:
            if (r23 == 0) goto L_0x0148
            r2 = r23
            r6 = r2
            goto L_0x014b
        L_0x0148:
            r2 = 1
            r16 = r2
        L_0x014b:
            r4 = r25
            goto L_0x0075
        L_0x014f:
            r25 = r4
            if (r15 == 0) goto L_0x0177
            android.support.constraint.a.a.f[] r1 = r13.f384D
            int r2 = r47 + 1
            r2 = r1[r2]
            android.support.constraint.a.a.f r2 = r2.f354d
            if (r2 == 0) goto L_0x0177
            android.support.constraint.a.a.f[] r2 = r15.f384D
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.a.i r3 = r2.f360j
            int r4 = r47 + 1
            r1 = r1[r4]
            android.support.constraint.a.a.f r1 = r1.f354d
            android.support.constraint.a.i r1 = r1.f360j
            int r4 = r2.mo3841b()
            int r4 = -r4
            r5 = 5
            r10.mo4027c(r3, r1, r4, r5)
            goto L_0x0178
        L_0x0177:
            r5 = 5
        L_0x0178:
            if (r18 == 0) goto L_0x0196
            android.support.constraint.a.a.f[] r1 = r0.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            android.support.constraint.a.i r1 = r1.f360j
            android.support.constraint.a.a.f[] r2 = r13.f384D
            int r3 = r47 + 1
            r3 = r2[r3]
            android.support.constraint.a.i r3 = r3.f360j
            int r4 = r47 + 1
            r2 = r2[r4]
            int r2 = r2.mo3841b()
            r4 = 6
            r10.mo4024b(r1, r3, r2, r4)
        L_0x0196:
            java.util.ArrayList<android.support.constraint.a.a.h> r4 = r11.f340h
            if (r4 == 0) goto L_0x0287
            int r1 = r4.size()
            r2 = 1
            if (r1 <= r2) goto L_0x027c
            r3 = 0
            r20 = 0
            boolean r2 = r11.f346n
            if (r2 == 0) goto L_0x01b0
            boolean r2 = r11.f348p
            if (r2 != 0) goto L_0x01b0
            int r2 = r11.f342j
            float r2 = (float) r2
            goto L_0x01b2
        L_0x01b0:
            r2 = r25
        L_0x01b2:
            r25 = 0
            r5 = r3
            r3 = r25
            r25 = r20
        L_0x01b9:
            if (r3 >= r1) goto L_0x026d
            java.lang.Object r28 = r4.get(r3)
            r0 = r28
            android.support.constraint.a.a.h r0 = (android.support.constraint.p034a.p035a.C0180h) r0
            r36 = r1
            float[] r1 = r0.f439qa
            r1 = r1[r46]
            r28 = 0
            int r29 = (r1 > r28 ? 1 : (r1 == r28 ? 0 : -1))
            if (r29 >= 0) goto L_0x01fb
            r29 = r1
            boolean r1 = r11.f348p
            if (r1 == 0) goto L_0x01f2
            android.support.constraint.a.a.f[] r1 = r0.f384D
            int r28 = r47 + 1
            r37 = r4
            r4 = r1[r28]
            android.support.constraint.a.i r4 = r4.f360j
            r1 = r1[r47]
            android.support.constraint.a.i r1 = r1.f360j
            r38 = r6
            r6 = 4
            r39 = r7
            r7 = 0
            r10.mo4010a(r4, r1, r7, r6)
            r17 = r8
            r7 = 6
            r8 = 0
            goto L_0x025d
        L_0x01f2:
            r37 = r4
            r38 = r6
            r39 = r7
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0203
        L_0x01fb:
            r29 = r1
            r37 = r4
            r38 = r6
            r39 = r7
        L_0x0203:
            int r4 = (r1 > r28 ? 1 : (r1 == r28 ? 0 : -1))
            if (r4 != 0) goto L_0x021b
            android.support.constraint.a.a.f[] r4 = r0.f384D
            int r6 = r47 + 1
            r6 = r4[r6]
            android.support.constraint.a.i r6 = r6.f360j
            r4 = r4[r47]
            android.support.constraint.a.i r4 = r4.f360j
            r17 = r8
            r7 = 6
            r8 = 0
            r10.mo4010a(r6, r4, r8, r7)
            goto L_0x025d
        L_0x021b:
            r17 = r8
            r7 = 6
            r8 = 0
            if (r5 == 0) goto L_0x0256
            android.support.constraint.a.a.f[] r4 = r5.f384D
            r6 = r4[r47]
            android.support.constraint.a.i r6 = r6.f360j
            int r24 = r47 + 1
            r4 = r4[r24]
            android.support.constraint.a.i r4 = r4.f360j
            android.support.constraint.a.a.f[] r7 = r0.f384D
            r8 = r7[r47]
            android.support.constraint.a.i r8 = r8.f360j
            int r28 = r47 + 1
            r7 = r7[r28]
            android.support.constraint.a.i r7 = r7.f360j
            r41 = r5
            android.support.constraint.a.b r5 = r45.mo4023b()
            r28 = r5
            r29 = r25
            r30 = r2
            r31 = r1
            r32 = r6
            r33 = r4
            r34 = r8
            r35 = r7
            r28.mo3983a(r29, r30, r31, r32, r33, r34, r35)
            r10.mo4015a(r5)
            goto L_0x0258
        L_0x0256:
            r41 = r5
        L_0x0258:
            r4 = r0
            r5 = r1
            r25 = r5
            r5 = r4
        L_0x025d:
            int r3 = r3 + 1
            r0 = r44
            r8 = r17
            r1 = r36
            r4 = r37
            r6 = r38
            r7 = r39
            goto L_0x01b9
        L_0x026d:
            r36 = r1
            r37 = r4
            r41 = r5
            r38 = r6
            r39 = r7
            r17 = r8
            r25 = r2
            goto L_0x028f
        L_0x027c:
            r36 = r1
            r37 = r4
            r38 = r6
            r39 = r7
            r17 = r8
            goto L_0x028f
        L_0x0287:
            r37 = r4
            r38 = r6
            r39 = r7
            r17 = r8
        L_0x028f:
            if (r14 == 0) goto L_0x032e
            if (r14 == r15) goto L_0x02a0
            if (r19 == 0) goto L_0x0296
            goto L_0x02a0
        L_0x0296:
            r35 = r9
            r30 = r37
            r31 = r38
            r33 = r39
            goto L_0x0336
        L_0x02a0:
            android.support.constraint.a.a.f[] r1 = r12.f384D
            r2 = r1[r47]
            android.support.constraint.a.a.f[] r3 = r13.f384D
            int r4 = r47 + 1
            r3 = r3[r4]
            r4 = r1[r47]
            android.support.constraint.a.a.f r4 = r4.f354d
            if (r4 == 0) goto L_0x02b7
            r1 = r1[r47]
            android.support.constraint.a.a.f r1 = r1.f354d
            android.support.constraint.a.i r1 = r1.f360j
            goto L_0x02b8
        L_0x02b7:
            r1 = 0
        L_0x02b8:
            r20 = r1
            android.support.constraint.a.a.f[] r1 = r13.f384D
            int r4 = r47 + 1
            r4 = r1[r4]
            android.support.constraint.a.a.f r4 = r4.f354d
            if (r4 == 0) goto L_0x02cd
            int r4 = r47 + 1
            r1 = r1[r4]
            android.support.constraint.a.a.f r1 = r1.f354d
            android.support.constraint.a.i r1 = r1.f360j
            goto L_0x02ce
        L_0x02cd:
            r1 = 0
        L_0x02ce:
            r24 = r1
            if (r14 != r15) goto L_0x02dd
            android.support.constraint.a.a.f[] r1 = r14.f384D
            r2 = r1[r47]
            int r4 = r47 + 1
            r3 = r1[r4]
            r8 = r2
            r7 = r3
            goto L_0x02df
        L_0x02dd:
            r8 = r2
            r7 = r3
        L_0x02df:
            if (r20 == 0) goto L_0x0320
            if (r24 == 0) goto L_0x0320
            r1 = 1056964608(0x3f000000, float:0.5)
            if (r46 != 0) goto L_0x02ec
            float r1 = r9.f407aa
            r26 = r1
            goto L_0x02f0
        L_0x02ec:
            float r1 = r9.f409ba
            r26 = r1
        L_0x02f0:
            int r27 = r8.mo3841b()
            int r28 = r7.mo3841b()
            android.support.constraint.a.i r2 = r8.f360j
            android.support.constraint.a.i r6 = r7.f360j
            r29 = 5
            r1 = r45
            r3 = r20
            r30 = r37
            r4 = r27
            r5 = r26
            r32 = r6
            r31 = r38
            r6 = r24
            r34 = r7
            r33 = r39
            r7 = r32
            r32 = r8
            r8 = r28
            r35 = r9
            r9 = r29
            r1.mo4019a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x032c
        L_0x0320:
            r34 = r7
            r32 = r8
            r35 = r9
            r30 = r37
            r31 = r38
            r33 = r39
        L_0x032c:
            goto L_0x060e
        L_0x032e:
            r35 = r9
            r30 = r37
            r31 = r38
            r33 = r39
        L_0x0336:
            if (r22 == 0) goto L_0x047f
            if (r14 == 0) goto L_0x047f
            r1 = r14
            r2 = r14
            int r3 = r11.f342j
            if (r3 <= 0) goto L_0x0347
            int r4 = r11.f341i
            if (r4 != r3) goto L_0x0347
            r27 = 1
            goto L_0x0349
        L_0x0347:
            r27 = 0
        L_0x0349:
            r20 = r27
            r9 = r1
            r8 = r2
        L_0x034d:
            if (r9 == 0) goto L_0x0477
            android.support.constraint.a.a.h[] r1 = r9.f443sa
            r1 = r1[r46]
            r7 = r1
        L_0x0354:
            if (r7 == 0) goto L_0x0363
            int r1 = r7.mo3918r()
            r5 = 8
            if (r1 != r5) goto L_0x0365
            android.support.constraint.a.a.h[] r1 = r7.f443sa
            r7 = r1[r46]
            goto L_0x0354
        L_0x0363:
            r5 = 8
        L_0x0365:
            if (r7 != 0) goto L_0x0374
            if (r9 != r15) goto L_0x036a
            goto L_0x0374
        L_0x036a:
            r39 = r7
            r40 = r8
            r41 = r9
            r0 = 8
            goto L_0x0465
        L_0x0374:
            android.support.constraint.a.a.f[] r1 = r9.f384D
            r6 = r1[r47]
            android.support.constraint.a.i r4 = r6.f360j
            android.support.constraint.a.a.f r1 = r6.f354d
            if (r1 == 0) goto L_0x0381
            android.support.constraint.a.i r1 = r1.f360j
            goto L_0x0382
        L_0x0381:
            r1 = 0
        L_0x0382:
            if (r8 == r9) goto L_0x038f
            android.support.constraint.a.a.f[] r2 = r8.f384D
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.a.i r1 = r2.f360j
            r23 = r1
            goto L_0x03a9
        L_0x038f:
            if (r9 != r14) goto L_0x03a7
            if (r8 != r9) goto L_0x03a7
            android.support.constraint.a.a.f[] r2 = r12.f384D
            r3 = r2[r47]
            android.support.constraint.a.a.f r3 = r3.f354d
            if (r3 == 0) goto L_0x03a2
            r2 = r2[r47]
            android.support.constraint.a.a.f r2 = r2.f354d
            android.support.constraint.a.i r2 = r2.f360j
            goto L_0x03a3
        L_0x03a2:
            r2 = 0
        L_0x03a3:
            r1 = r2
            r23 = r1
            goto L_0x03a9
        L_0x03a7:
            r23 = r1
        L_0x03a9:
            r1 = 0
            r2 = 0
            r3 = 0
            int r24 = r6.mo3841b()
            android.support.constraint.a.a.f[] r0 = r9.f384D
            int r27 = r47 + 1
            r0 = r0[r27]
            int r0 = r0.mo3841b()
            if (r7 == 0) goto L_0x03d1
            android.support.constraint.a.a.f[] r5 = r7.f384D
            r1 = r5[r47]
            android.support.constraint.a.i r2 = r1.f360j
            android.support.constraint.a.a.f[] r5 = r9.f384D
            int r28 = r47 + 1
            r5 = r5[r28]
            android.support.constraint.a.i r3 = r5.f360j
            r28 = r1
            r29 = r2
            r31 = r3
            goto L_0x03eb
        L_0x03d1:
            android.support.constraint.a.a.f[] r5 = r13.f384D
            int r28 = r47 + 1
            r5 = r5[r28]
            android.support.constraint.a.a.f r1 = r5.f354d
            if (r1 == 0) goto L_0x03dd
            android.support.constraint.a.i r2 = r1.f360j
        L_0x03dd:
            android.support.constraint.a.a.f[] r5 = r9.f384D
            int r28 = r47 + 1
            r5 = r5[r28]
            android.support.constraint.a.i r3 = r5.f360j
            r28 = r1
            r29 = r2
            r31 = r3
        L_0x03eb:
            if (r28 == 0) goto L_0x03f2
            int r1 = r28.mo3841b()
            int r0 = r0 + r1
        L_0x03f2:
            if (r8 == 0) goto L_0x0400
            android.support.constraint.a.a.f[] r1 = r8.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            int r1 = r1.mo3841b()
            int r24 = r24 + r1
        L_0x0400:
            if (r4 == 0) goto L_0x0457
            if (r23 == 0) goto L_0x0457
            if (r29 == 0) goto L_0x0457
            if (r31 == 0) goto L_0x0457
            r1 = r24
            if (r9 != r14) goto L_0x0417
            android.support.constraint.a.a.f[] r2 = r14.f384D
            r2 = r2[r47]
            int r1 = r2.mo3841b()
            r32 = r1
            goto L_0x0419
        L_0x0417:
            r32 = r1
        L_0x0419:
            r1 = r0
            if (r9 != r15) goto L_0x0429
            android.support.constraint.a.a.f[] r2 = r15.f384D
            int r3 = r47 + 1
            r2 = r2[r3]
            int r1 = r2.mo3841b()
            r34 = r1
            goto L_0x042b
        L_0x0429:
            r34 = r1
        L_0x042b:
            r1 = 4
            if (r20 == 0) goto L_0x0432
            r1 = 6
            r36 = r1
            goto L_0x0434
        L_0x0432:
            r36 = r1
        L_0x0434:
            r5 = 1056964608(0x3f000000, float:0.5)
            r1 = r45
            r2 = r4
            r3 = r23
            r37 = r4
            r4 = r32
            r38 = r0
            r0 = 8
            r27 = r6
            r6 = r29
            r39 = r7
            r7 = r31
            r40 = r8
            r8 = r34
            r41 = r9
            r9 = r36
            r1.mo4019a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0465
        L_0x0457:
            r38 = r0
            r37 = r4
            r27 = r6
            r39 = r7
            r40 = r8
            r41 = r9
            r0 = 8
        L_0x0465:
            int r1 = r41.mo3918r()
            if (r1 == r0) goto L_0x046f
            r1 = r41
            r8 = r1
            goto L_0x0471
        L_0x046f:
            r8 = r40
        L_0x0471:
            r9 = r39
            r23 = r39
            goto L_0x034d
        L_0x0477:
            r40 = r8
            r41 = r9
            r31 = r41
            goto L_0x060e
        L_0x047f:
            r0 = 8
            if (r21 == 0) goto L_0x060e
            if (r14 == 0) goto L_0x060e
            r1 = r14
            r2 = r14
            int r3 = r11.f342j
            if (r3 <= 0) goto L_0x0492
            int r4 = r11.f341i
            if (r4 != r3) goto L_0x0492
            r27 = 1
            goto L_0x0494
        L_0x0492:
            r27 = 0
        L_0x0494:
            r24 = r27
            r9 = r1
            r8 = r2
        L_0x0498:
            if (r9 == 0) goto L_0x0585
            android.support.constraint.a.a.h[] r1 = r9.f443sa
            r1 = r1[r46]
        L_0x049e:
            if (r1 == 0) goto L_0x04ab
            int r2 = r1.mo3918r()
            if (r2 != r0) goto L_0x04ab
            android.support.constraint.a.a.h[] r2 = r1.f443sa
            r1 = r2[r46]
            goto L_0x049e
        L_0x04ab:
            if (r9 == r14) goto L_0x056b
            if (r9 == r15) goto L_0x056b
            if (r1 == 0) goto L_0x056b
            if (r1 != r15) goto L_0x04b6
            r1 = 0
            r7 = r1
            goto L_0x04b7
        L_0x04b6:
            r7 = r1
        L_0x04b7:
            android.support.constraint.a.a.f[] r1 = r9.f384D
            r6 = r1[r47]
            android.support.constraint.a.i r5 = r6.f360j
            android.support.constraint.a.a.f r1 = r6.f354d
            if (r1 == 0) goto L_0x04c4
            android.support.constraint.a.i r1 = r1.f360j
            goto L_0x04c5
        L_0x04c4:
            r1 = 0
        L_0x04c5:
            android.support.constraint.a.a.f[] r2 = r8.f384D
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.a.i r4 = r2.f360j
            r1 = 0
            r2 = 0
            r3 = 0
            int r23 = r6.mo3841b()
            android.support.constraint.a.a.f[] r0 = r9.f384D
            int r28 = r47 + 1
            r0 = r0[r28]
            int r0 = r0.mo3841b()
            if (r7 == 0) goto L_0x04f9
            r28 = r1
            android.support.constraint.a.a.f[] r1 = r7.f384D
            r1 = r1[r47]
            android.support.constraint.a.i r2 = r1.f360j
            r28 = r2
            android.support.constraint.a.a.f r2 = r1.f354d
            if (r2 == 0) goto L_0x04f1
            android.support.constraint.a.i r2 = r2.f360j
            goto L_0x04f2
        L_0x04f1:
            r2 = 0
        L_0x04f2:
            r31 = r2
            r29 = r28
            r28 = r1
            goto L_0x0515
        L_0x04f9:
            r28 = r1
            android.support.constraint.a.a.f[] r1 = r9.f384D
            int r29 = r47 + 1
            r1 = r1[r29]
            android.support.constraint.a.a.f r1 = r1.f354d
            if (r1 == 0) goto L_0x0507
            android.support.constraint.a.i r2 = r1.f360j
        L_0x0507:
            r28 = r1
            android.support.constraint.a.a.f[] r1 = r9.f384D
            int r29 = r47 + 1
            r1 = r1[r29]
            android.support.constraint.a.i r1 = r1.f360j
            r31 = r1
            r29 = r2
        L_0x0515:
            if (r28 == 0) goto L_0x051c
            int r1 = r28.mo3841b()
            int r0 = r0 + r1
        L_0x051c:
            if (r8 == 0) goto L_0x052a
            android.support.constraint.a.a.f[] r1 = r8.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            int r1 = r1.mo3841b()
            int r23 = r23 + r1
        L_0x052a:
            r1 = 4
            if (r24 == 0) goto L_0x0531
            r1 = 6
            r32 = r1
            goto L_0x0533
        L_0x0531:
            r32 = r1
        L_0x0533:
            if (r5 == 0) goto L_0x055c
            if (r4 == 0) goto L_0x055c
            if (r29 == 0) goto L_0x055c
            if (r31 == 0) goto L_0x055c
            r34 = 1056964608(0x3f000000, float:0.5)
            r1 = r45
            r2 = r5
            r3 = r4
            r20 = r4
            r4 = r23
            r36 = r5
            r5 = r34
            r34 = r6
            r6 = r29
            r37 = r7
            r7 = r31
            r38 = r8
            r8 = r0
            r39 = r9
            r9 = r32
            r1.mo4019a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0568
        L_0x055c:
            r20 = r4
            r36 = r5
            r34 = r6
            r37 = r7
            r38 = r8
            r39 = r9
        L_0x0568:
            r23 = r37
            goto L_0x0571
        L_0x056b:
            r38 = r8
            r39 = r9
            r23 = r1
        L_0x0571:
            int r0 = r39.mo3918r()
            r1 = 8
            if (r0 == r1) goto L_0x057d
            r0 = r39
            r8 = r0
            goto L_0x057f
        L_0x057d:
            r8 = r38
        L_0x057f:
            r9 = r23
            r0 = 8
            goto L_0x0498
        L_0x0585:
            r38 = r8
            r39 = r9
            android.support.constraint.a.a.f[] r0 = r14.f384D
            r0 = r0[r47]
            android.support.constraint.a.a.f[] r1 = r12.f384D
            r1 = r1[r47]
            android.support.constraint.a.a.f r9 = r1.f354d
            android.support.constraint.a.a.f[] r1 = r15.f384D
            int r2 = r47 + 1
            r8 = r1[r2]
            android.support.constraint.a.a.f[] r1 = r13.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            android.support.constraint.a.a.f r7 = r1.f354d
            if (r9 == 0) goto L_0x05ee
            if (r14 == r15) goto L_0x05b8
            android.support.constraint.a.i r1 = r0.f360j
            android.support.constraint.a.i r2 = r9.f360j
            int r3 = r0.mo3841b()
            r6 = 5
            r10.mo4010a(r1, r2, r3, r6)
            r42 = r7
            r43 = r8
            r20 = r9
            goto L_0x05f4
        L_0x05b8:
            r6 = 5
            if (r7 == 0) goto L_0x05e7
            android.support.constraint.a.i r2 = r0.f360j
            android.support.constraint.a.i r3 = r9.f360j
            int r4 = r0.mo3841b()
            android.support.constraint.a.i r1 = r8.f360j
            android.support.constraint.a.i r5 = r7.f360j
            int r27 = r8.mo3841b()
            r28 = 5
            r29 = r1
            r1 = r45
            r20 = r5
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = r29
            r42 = r7
            r7 = r20
            r43 = r8
            r8 = r27
            r20 = r9
            r9 = r28
            r1.mo4019a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x05f4
        L_0x05e7:
            r42 = r7
            r43 = r8
            r20 = r9
            goto L_0x05f4
        L_0x05ee:
            r42 = r7
            r43 = r8
            r20 = r9
        L_0x05f4:
            r1 = r42
            if (r1 == 0) goto L_0x060a
            if (r14 == r15) goto L_0x060a
            r2 = r43
            android.support.constraint.a.i r3 = r2.f360j
            android.support.constraint.a.i r4 = r1.f360j
            int r5 = r2.mo3841b()
            int r5 = -r5
            r6 = 5
            r10.mo4010a(r3, r4, r5, r6)
            goto L_0x060c
        L_0x060a:
            r2 = r43
        L_0x060c:
            r31 = r39
        L_0x060e:
            if (r22 != 0) goto L_0x0612
            if (r21 == 0) goto L_0x0687
        L_0x0612:
            if (r14 == 0) goto L_0x0687
            android.support.constraint.a.a.f[] r0 = r14.f384D
            r0 = r0[r47]
            android.support.constraint.a.a.f[] r1 = r15.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            android.support.constraint.a.a.f r2 = r0.f354d
            if (r2 == 0) goto L_0x0625
            android.support.constraint.a.i r2 = r2.f360j
            goto L_0x0626
        L_0x0625:
            r2 = 0
        L_0x0626:
            r20 = r2
            android.support.constraint.a.a.f r2 = r1.f354d
            if (r2 == 0) goto L_0x062f
            android.support.constraint.a.i r2 = r2.f360j
            goto L_0x0630
        L_0x062f:
            r2 = 0
        L_0x0630:
            if (r13 == r15) goto L_0x0644
            android.support.constraint.a.a.f[] r3 = r13.f384D
            int r4 = r47 + 1
            r3 = r3[r4]
            android.support.constraint.a.a.f r4 = r3.f354d
            if (r4 == 0) goto L_0x063f
            android.support.constraint.a.i r4 = r4.f360j
            goto L_0x0640
        L_0x063f:
            r4 = 0
        L_0x0640:
            r2 = r4
            r24 = r2
            goto L_0x0646
        L_0x0644:
            r24 = r2
        L_0x0646:
            if (r14 != r15) goto L_0x0652
            android.support.constraint.a.a.f[] r2 = r14.f384D
            r0 = r2[r47]
            int r3 = r47 + 1
            r1 = r2[r3]
            r9 = r1
            goto L_0x0653
        L_0x0652:
            r9 = r1
        L_0x0653:
            if (r20 == 0) goto L_0x0685
            if (r24 == 0) goto L_0x0685
            r26 = 1056964608(0x3f000000, float:0.5)
            int r27 = r0.mo3841b()
            if (r15 != 0) goto L_0x0661
            r1 = r13
            r15 = r1
        L_0x0661:
            android.support.constraint.a.a.f[] r1 = r15.f384D
            int r2 = r47 + 1
            r1 = r1[r2]
            int r28 = r1.mo3841b()
            android.support.constraint.a.i r2 = r0.f360j
            android.support.constraint.a.i r7 = r9.f360j
            r29 = 5
            r1 = r45
            r3 = r20
            r4 = r27
            r5 = r26
            r6 = r24
            r8 = r28
            r32 = r9
            r9 = r29
            r1.mo4019a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0687
        L_0x0685:
            r32 = r9
        L_0x0687:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.p034a.p035a.C0172c.m934a(android.support.constraint.a.a.i, android.support.constraint.a.e, int, int, android.support.constraint.a.a.d):void");
    }
}
