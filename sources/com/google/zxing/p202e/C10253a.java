package com.google.zxing.p202e;

import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.C10275g;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import com.google.zxing.p202e.p203a.C10256c;
import com.google.zxing.p202e.p203a.C10257d;
import com.google.zxing.p202e.p203a.C10258e;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* renamed from: com.google.zxing.e.a */
/* compiled from: PDF417Writer */
public final class C10253a implements C10275g {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) throws WriterException {
        int margin;
        int errorCorrectionLevel;
        if (format == C10197a.PDF_417) {
            C10258e encoder = new C10258e();
            int margin2 = 30;
            int errorCorrectionLevel2 = 2;
            if (hints != null) {
                if (hints.containsKey(C10211c.PDF417_COMPACT)) {
                    encoder.mo33614a(Boolean.valueOf(hints.get(C10211c.PDF417_COMPACT).toString()).booleanValue());
                }
                if (hints.containsKey(C10211c.PDF417_COMPACTION)) {
                    encoder.mo33611a(C10256c.valueOf(hints.get(C10211c.PDF417_COMPACTION).toString()));
                }
                if (hints.containsKey(C10211c.PDF417_DIMENSIONS)) {
                    C10257d dimensions = (C10257d) hints.get(C10211c.PDF417_DIMENSIONS);
                    encoder.mo33610a(dimensions.mo33605a(), dimensions.mo33607c(), dimensions.mo33606b(), dimensions.mo33608d());
                }
                if (hints.containsKey(C10211c.MARGIN)) {
                    margin2 = Integer.parseInt(hints.get(C10211c.MARGIN).toString());
                }
                if (hints.containsKey(C10211c.ERROR_CORRECTION)) {
                    errorCorrectionLevel2 = Integer.parseInt(hints.get(C10211c.ERROR_CORRECTION).toString());
                }
                if (hints.containsKey(C10211c.CHARACTER_SET)) {
                    encoder.mo33613a(Charset.forName(hints.get(C10211c.CHARACTER_SET).toString()));
                }
                margin = margin2;
                errorCorrectionLevel = errorCorrectionLevel2;
            } else {
                margin = 30;
                errorCorrectionLevel = 2;
            }
            return m33395a(encoder, contents, errorCorrectionLevel, width, height, margin);
        }
        StringBuilder sb = new StringBuilder("Can only encode PDF_417, but got ");
        sb.append(format);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private static C10209b m33395a(C10258e encoder, String contents, int errorCorrectionLevel, int width, int height, int margin) throws WriterException {
        int scale;
        encoder.mo33612a(contents, errorCorrectionLevel);
        byte[][] originalScale = encoder.mo33609a().mo33601a(1, 4);
        boolean rotated = false;
        if ((height > width) ^ (originalScale[0].length < originalScale.length)) {
            originalScale = m33397a(originalScale);
            rotated = true;
        }
        int scaleX = width / originalScale[0].length;
        int scaleY = height / originalScale.length;
        if (scaleX < scaleY) {
            scale = scaleX;
        } else {
            scale = scaleY;
        }
        if (scale <= 1) {
            return m33396a(originalScale, margin);
        }
        byte[][] scaledMatrix = encoder.mo33609a().mo33601a(scale, scale << 2);
        if (rotated) {
            scaledMatrix = m33397a(scaledMatrix);
        }
        return m33396a(scaledMatrix, margin);
    }

    /* renamed from: a */
    private static C10209b m33396a(byte[][] input, int margin) {
        C10209b bVar = new C10209b(input[0].length + (margin * 2), input.length + (margin * 2));
        C10209b output = bVar;
        bVar.mo33532a();
        int y = 0;
        int yOutput = (output.mo33535b() - margin) - 1;
        while (y < input.length) {
            for (int x = 0; x < input[0].length; x++) {
                if (input[y][x] == 1) {
                    output.mo33536b(x + margin, yOutput);
                }
            }
            y++;
            yOutput--;
        }
        return output;
    }

    /* renamed from: a */
    private static byte[][] m33397a(byte[][] bitarray) {
        byte[][] temp = (byte[][]) Array.newInstance(byte.class, new int[]{bitarray[0].length, bitarray.length});
        for (int ii = 0; ii < bitarray.length; ii++) {
            int inverseii = (bitarray.length - ii) - 1;
            for (int jj = 0; jj < bitarray[0].length; jj++) {
                temp[jj][inverseii] = bitarray[ii][jj];
            }
        }
        return temp;
    }
}
