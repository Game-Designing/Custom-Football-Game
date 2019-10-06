package com.mopub.common.util;

import android.graphics.Bitmap;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class ImageUtils {
    public static Bitmap applyFastGaussianBlurToBitmap(Bitmap mutableBitmap, int radius) {
        int w = mutableBitmap.getWidth();
        int h = mutableBitmap.getHeight();
        int[] pixels = new int[(w * h)];
        mutableBitmap.getPixels(pixels, 0, w, 0, 0, w, h);
        for (int r = radius; r >= 1; r /= 2) {
            for (int i = r; i < h - r; i++) {
                int j = r;
                while (j < w - r) {
                    int tl = pixels[(((i - r) * w) + j) - r];
                    int tr = pixels[((i - r) * w) + j + r];
                    int tc = pixels[((i - r) * w) + j];
                    int bl = pixels[(((i + r) * w) + j) - r];
                    int br = pixels[((i + r) * w) + j + r];
                    int bc = pixels[((i + r) * w) + j];
                    int cl = pixels[((i * w) + j) - r];
                    int cr = pixels[(i * w) + j + r];
                    int h2 = h;
                    pixels[(i * w) + j] = ((((((((((tl & 255) + (tr & 255)) + (tc & 255)) + (bl & 255)) + (br & 255)) + (bc & 255)) + (cl & 255)) + (cr & 255)) >> 3) & 255) | CtaButton.BACKGROUND_COLOR | ((((((((((tl & 65280) + (tr & 65280)) + (tc & 65280)) + (bl & 65280)) + (br & 65280)) + (bc & 65280)) + (cl & 65280)) + (cr & 65280)) >> 3) & 65280) | ((((((((((tl & 16711680) + (tr & 16711680)) + (tc & 16711680)) + (bl & 16711680)) + (br & 16711680)) + (bc & 16711680)) + (cl & 16711680)) + (cr & 16711680)) >> 3) & 16711680);
                    j++;
                    h = h2;
                }
            }
        }
        mutableBitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return mutableBitmap;
    }
}
