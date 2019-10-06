package com.fyber.inneractive.sdk.util;

import android.graphics.Bitmap;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.reflect.Array;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.util.a */
public final class C7985a {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap m18027a(android.content.Context r8, android.graphics.Bitmap r9, com.fyber.inneractive.sdk.util.C7995b r10) {
        /*
            int r0 = r10.f16320a
            int r1 = r10.f16323d
            int r0 = r0 / r1
            int r2 = r10.f16321b
            int r2 = r2 / r1
            r1 = 2
            int[] r3 = new int[r1]
            r4 = 0
            r3[r4] = r0
            r5 = 1
            r3[r5] = r2
            r6 = 0
        L_0x0012:
            if (r6 >= r1) goto L_0x001d
            r7 = r3[r6]
            if (r7 != 0) goto L_0x001a
            r4 = 1
            goto L_0x001e
        L_0x001a:
            int r6 = r6 + 1
            goto L_0x0012
        L_0x001d:
        L_0x001e:
            if (r4 == 0) goto L_0x0022
            r8 = 0
            return r8
        L_0x0022:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r1)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            int r2 = r10.f16323d
            float r3 = (float) r2
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
            float r2 = (float) r2
            float r4 = r4 / r2
            r1.scale(r3, r4)
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r3 = 3
            r2.setFlags(r3)
            android.graphics.PorterDuffColorFilter r3 = new android.graphics.PorterDuffColorFilter
            int r4 = r10.f16324e
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r3.<init>(r4, r6)
            r2.setColorFilter(r3)
            r3 = 0
            r1.drawBitmap(r9, r3, r3, r2)
            int r9 = android.os.Build.VERSION.SDK_INT
            r1 = 18
            if (r9 < r1) goto L_0x005f
            int r9 = r10.f16322c     // Catch:{ RSRuntimeException -> 0x005e }
            m18026a(r8, r0, r9)     // Catch:{ RSRuntimeException -> 0x005e }
            goto L_0x0065
        L_0x005e:
            r8 = move-exception
        L_0x005f:
            int r8 = r10.f16322c
            android.graphics.Bitmap r0 = m18028a(r0, r8)
        L_0x0065:
            int r8 = r10.f16323d
            if (r8 != r5) goto L_0x006a
            return r0
        L_0x006a:
            int r8 = r10.f16320a
            int r9 = r10.f16321b
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createScaledBitmap(r0, r8, r9, r5)
            r0.recycle()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C7985a.m18027a(android.content.Context, android.graphics.Bitmap, com.fyber.inneractive.sdk.util.b):android.graphics.Bitmap");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v0, types: [android.renderscript.Allocation] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.renderscript.Allocation] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Unknown variable types count: 4 */
    @android.annotation.TargetApi(18)
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m18026a(android.content.Context r4, android.graphics.Bitmap r5, int r6) throws android.renderscript.RSRuntimeException {
        /*
            r0 = 0
            android.renderscript.RenderScript r4 = android.renderscript.RenderScript.create(r4)     // Catch:{ all -> 0x0054 }
            android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            r4.setMessageHandler(r1)     // Catch:{ all -> 0x0051 }
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0051 }
            r2 = 1
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r4, r5, r1, r2)     // Catch:{ all -> 0x0051 }
            android.renderscript.Type r2 = r1.getType()     // Catch:{ all -> 0x004e }
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r4, r2)     // Catch:{ all -> 0x004e }
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r4)     // Catch:{ all -> 0x004a }
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r4, r3)     // Catch:{ all -> 0x004a }
            r0.setInput(r1)     // Catch:{ all -> 0x004a }
            float r6 = (float) r6     // Catch:{ all -> 0x004a }
            r0.setRadius(r6)     // Catch:{ all -> 0x004a }
            r0.forEach(r2)     // Catch:{ all -> 0x004a }
            r2.copyTo(r5)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x003a
            r4.destroy()
        L_0x003a:
            if (r1 == 0) goto L_0x003f
            r1.destroy()
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.destroy()
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.destroy()
        L_0x0049:
            return r5
        L_0x004a:
            r5 = move-exception
            r6 = r0
            r0 = r2
            goto L_0x0058
        L_0x004e:
            r5 = move-exception
            r6 = r0
            goto L_0x0058
        L_0x0051:
            r5 = move-exception
            r6 = r0
            goto L_0x0057
        L_0x0054:
            r5 = move-exception
            r4 = r0
            r6 = r4
        L_0x0057:
            r1 = r6
        L_0x0058:
            if (r4 == 0) goto L_0x005d
            r4.destroy()
        L_0x005d:
            if (r1 == 0) goto L_0x0062
            r1.destroy()
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.destroy()
        L_0x0067:
            if (r6 == 0) goto L_0x006c
            r6.destroy()
        L_0x006c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C7985a.m18026a(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static Bitmap m18028a(Bitmap bitmap, int i) {
        int[] iArr;
        int i2;
        int[] iArr2;
        int i3 = i;
        if (i3 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = width * height;
        int[] iArr3 = new int[i4];
        bitmap.getPixels(iArr3, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[i4];
        int[] iArr7 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * Opcodes.ACC_NATIVE;
        int[] iArr8 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr8[i11] = i11 / i9;
        }
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, new int[]{i7, 3});
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            int i16 = -i3;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i16 <= i3) {
                int i26 = i6;
                int i27 = height;
                int i28 = iArr3[i14 + Math.min(i5, Math.max(i16, 0))];
                int[] iArr10 = iArr9[i16 + i3];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & 65280) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i12 - Math.abs(i16);
                i17 += iArr10[0] * abs;
                i18 += iArr10[1] * abs;
                i19 += iArr10[2] * abs;
                if (i16 > 0) {
                    i23 += iArr10[0];
                    i24 += iArr10[1];
                    i25 += iArr10[2];
                } else {
                    i20 += iArr10[0];
                    i21 += iArr10[1];
                    i22 += iArr10[2];
                }
                i16++;
                height = i27;
                i6 = i26;
            }
            int i29 = i6;
            int i30 = height;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr4[i14] = iArr8[i17];
                iArr5[i14] = iArr8[i18];
                iArr6[i14] = iArr8[i19];
                int i33 = i17 - i20;
                int i34 = i18 - i21;
                int i35 = i19 - i22;
                int[] iArr11 = iArr9[((i31 - i3) + i7) % i7];
                int i36 = i20 - iArr11[0];
                int i37 = i21 - iArr11[1];
                int i38 = i22 - iArr11[2];
                if (i13 == 0) {
                    iArr2 = iArr8;
                    iArr7[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr2 = iArr8;
                }
                int i39 = iArr3[i15 + iArr7[i32]];
                iArr11[0] = (i39 & 16711680) >> 16;
                iArr11[1] = (i39 & 65280) >> 8;
                iArr11[2] = i39 & 255;
                int i40 = i23 + iArr11[0];
                int i41 = i24 + iArr11[1];
                int i42 = i25 + iArr11[2];
                i17 = i33 + i40;
                i18 = i34 + i41;
                i19 = i35 + i42;
                i31 = (i31 + 1) % i7;
                int[] iArr12 = iArr9[i31 % i7];
                i20 = i36 + iArr12[0];
                i21 = i37 + iArr12[1];
                i22 = i38 + iArr12[2];
                i23 = i40 - iArr12[0];
                i24 = i41 - iArr12[1];
                i25 = i42 - iArr12[2];
                i14++;
                i32++;
                iArr8 = iArr2;
            }
            int[] iArr13 = iArr8;
            i15 += width;
            i13++;
            height = i30;
            i6 = i29;
        }
        int i43 = i6;
        int i44 = height;
        int[] iArr14 = iArr8;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i46 * width;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            while (i46 <= i3) {
                int[] iArr15 = iArr7;
                int max = Math.max(0, i47) + i45;
                int[] iArr16 = iArr9[i46 + i3];
                iArr16[0] = iArr4[max];
                iArr16[1] = iArr5[max];
                iArr16[2] = iArr6[max];
                int abs2 = i12 - Math.abs(i46);
                i48 += iArr4[max] * abs2;
                i49 += iArr5[max] * abs2;
                i50 += iArr6[max] * abs2;
                if (i46 > 0) {
                    i54 += iArr16[0];
                    i55 += iArr16[1];
                    i56 += iArr16[2];
                } else {
                    i51 += iArr16[0];
                    i52 += iArr16[1];
                    i53 += iArr16[2];
                }
                int i57 = i43;
                if (i46 < i57) {
                    i47 += width;
                }
                i46++;
                i43 = i57;
                iArr7 = iArr15;
            }
            int[] iArr17 = iArr7;
            int i58 = i43;
            int i59 = i45;
            int i60 = i56;
            int i61 = 0;
            int i62 = i55;
            int i63 = i54;
            int i64 = i3;
            while (true) {
                iArr = iArr6;
                i2 = i44;
                if (i61 >= i2) {
                    break;
                }
                iArr3[i59] = (iArr3[i59] & CtaButton.BACKGROUND_COLOR) | (iArr14[i48] << 16) | (iArr14[i49] << 8) | iArr14[i50];
                int i65 = i48 - i51;
                int i66 = i49 - i52;
                int i67 = i50 - i53;
                int[] iArr18 = iArr9[((i64 - i3) + i7) % i7];
                int i68 = i51 - iArr18[0];
                int i69 = i52 - iArr18[1];
                int i70 = i53 - iArr18[2];
                if (i45 == 0) {
                    iArr17[i61] = Math.min(i61 + i12, i58) * width;
                }
                int i71 = iArr17[i61] + i45;
                iArr18[0] = iArr4[i71];
                iArr18[1] = iArr5[i71];
                iArr18[2] = iArr[i71];
                int i72 = i63 + iArr18[0];
                int i73 = i62 + iArr18[1];
                int i74 = i60 + iArr18[2];
                i48 = i65 + i72;
                i49 = i66 + i73;
                i50 = i67 + i74;
                i64 = (i64 + 1) % i7;
                int[] iArr19 = iArr9[i64];
                i51 = i68 + iArr19[0];
                i52 = i69 + iArr19[1];
                i53 = i70 + iArr19[2];
                i63 = i72 - iArr19[0];
                i62 = i73 - iArr19[1];
                i60 = i74 - iArr19[2];
                i59 += width;
                i61++;
                i3 = i;
                i44 = i2;
                iArr6 = iArr;
            }
            i45++;
            i3 = i;
            i44 = i2;
            i43 = i58;
            iArr7 = iArr17;
            iArr6 = iArr;
        }
        bitmap.setPixels(iArr3, 0, width, 0, 0, width, i44);
        return bitmap;
    }
}
