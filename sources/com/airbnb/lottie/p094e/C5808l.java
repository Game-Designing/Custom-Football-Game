package com.airbnb.lottie.p094e;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.p089c.p091b.C5737c;
import com.airbnb.lottie.p095f.C5828e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.e.l */
/* compiled from: GradientColorParser */
public class C5808l implements C5796K<C5737c> {

    /* renamed from: a */
    private int f10085a;

    public C5808l(int colorPoints) {
        this.f10085a = colorPoints;
    }

    /* renamed from: a */
    public C5737c m10458a(JsonReader reader, float scale) throws IOException {
        List<Float> array = new ArrayList<>();
        boolean isArray = reader.peek() == JsonToken.BEGIN_ARRAY;
        if (isArray) {
            reader.beginArray();
        }
        while (reader.hasNext()) {
            array.add(Float.valueOf((float) reader.nextDouble()));
        }
        if (isArray) {
            reader.endArray();
        }
        if (this.f10085a == -1) {
            this.f10085a = array.size() / 4;
        }
        int i = this.f10085a;
        float[] positions = new float[i];
        int[] colors = new int[i];
        int r = 0;
        int g = 0;
        for (int i2 = 0; i2 < this.f10085a * 4; i2++) {
            int colorIndex = i2 / 4;
            double value = (double) ((Float) array.get(i2)).floatValue();
            int i3 = i2 % 4;
            if (i3 == 0) {
                positions[colorIndex] = (float) value;
            } else if (i3 == 1) {
                Double.isNaN(value);
                r = (int) (255.0d * value);
            } else if (i3 == 2) {
                Double.isNaN(value);
                g = (int) (255.0d * value);
            } else if (i3 == 3) {
                Double.isNaN(value);
                colors[colorIndex] = Color.argb(255, r, g, (int) (255.0d * value));
            }
        }
        C5737c gradientColor = new C5737c(positions, colors);
        m10456a(gradientColor, array);
        return gradientColor;
    }

    /* renamed from: a */
    private void m10456a(C5737c gradientColor, List<Float> array) {
        int startIndex = this.f10085a * 4;
        if (array.size() > startIndex) {
            int opacityStops = (array.size() - startIndex) / 2;
            double[] positions = new double[opacityStops];
            double[] opacities = new double[opacityStops];
            int j = 0;
            for (int i = startIndex; i < array.size(); i++) {
                if (i % 2 == 0) {
                    positions[j] = (double) ((Float) array.get(i)).floatValue();
                } else {
                    opacities[j] = (double) ((Float) array.get(i)).floatValue();
                    j++;
                }
            }
            for (int i2 = 0; i2 < gradientColor.mo18003c(); i2++) {
                int color = gradientColor.mo18001a()[i2];
                gradientColor.mo18001a()[i2] = Color.argb(m10455a((double) gradientColor.mo18002b()[i2], positions, opacities), Color.red(color), Color.green(color), Color.blue(color));
            }
        }
    }

    /* renamed from: a */
    private int m10455a(double position, double[] positions, double[] opacities) {
        double[] dArr = positions;
        double[] dArr2 = opacities;
        for (int i = 1; i < dArr.length; i++) {
            double lastPosition = dArr[i - 1];
            double thisPosition = dArr[i];
            if (dArr[i] >= position) {
                return (int) (C5828e.m10522a(dArr2[i - 1], dArr2[i], (position - lastPosition) / (thisPosition - lastPosition)) * 255.0d);
            }
        }
        return (int) (dArr2[dArr2.length - 1] * 255.0d);
    }
}
