package p002b.p003c.p062h.p064b.p065a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p053g.p054a.C1199a;

/* renamed from: b.c.h.b.a.a */
/* compiled from: AppCompatColorStateListInflater */
final class C1281a {
    /* renamed from: a */
    public static ColorStateList m5993a(Resources r, XmlPullParser parser, Theme theme) throws XmlPullParserException, IOException {
        int type;
        AttributeSet attrs = Xml.asAttributeSet(parser);
        do {
            int next = parser.next();
            type = next;
            if (next == 2) {
                break;
            }
        } while (type != 1);
        if (type == 2) {
            return m5994a(r, parser, attrs, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: a */
    private static ColorStateList m5994a(Resources r, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        String name = parser.getName();
        if (name.equals("selector")) {
            return m5996b(r, parser, attrs, theme);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parser.getPositionDescription());
        sb.append(": invalid color state list tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }

    /* renamed from: b */
    private static ColorStateList m5996b(Resources r, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        AttributeSet attributeSet = attrs;
        int i = 1;
        int innerDepth = parser.getDepth() + 1;
        int defaultColor = -65536;
        int[][] stateSpecList = new int[20][];
        int[] colorList = new int[stateSpecList.length];
        int listSize = 0;
        while (true) {
            int next = parser.next();
            int type = next;
            if (next == i) {
                Resources resources = r;
                Theme theme2 = theme;
                int i2 = innerDepth;
                int i3 = defaultColor;
                break;
            }
            int depth = parser.getDepth();
            int depth2 = depth;
            if (depth < innerDepth && type == 3) {
                Resources resources2 = r;
                Theme theme3 = theme;
                int i4 = innerDepth;
                int i5 = defaultColor;
                break;
            } else if (type != 2 || depth2 > innerDepth || !parser.getName().equals("item")) {
                Resources resources3 = r;
                Theme theme4 = theme;
                innerDepth = innerDepth;
                defaultColor = defaultColor;
                i = 1;
            } else {
                TypedArray a = m5995a(r, theme, attributeSet, C0793R.styleable.ColorStateListItem);
                int baseColor = a.getColor(C0793R.styleable.ColorStateListItem_android_color, -65281);
                float alphaMod = 1.0f;
                if (a.hasValue(C0793R.styleable.ColorStateListItem_android_alpha)) {
                    alphaMod = a.getFloat(C0793R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (a.hasValue(C0793R.styleable.ColorStateListItem_alpha)) {
                    alphaMod = a.getFloat(C0793R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                a.recycle();
                int numAttrs = attrs.getAttributeCount();
                int[] stateSpec = new int[numAttrs];
                int innerDepth2 = innerDepth;
                int j = 0;
                int i6 = 0;
                while (i6 < numAttrs) {
                    int numAttrs2 = numAttrs;
                    int numAttrs3 = attributeSet.getAttributeNameResource(i6);
                    int defaultColor2 = defaultColor;
                    if (!(numAttrs3 == 16843173 || numAttrs3 == 16843551 || numAttrs3 == C0793R.attr.alpha)) {
                        int j2 = j + 1;
                        stateSpec[j] = attributeSet.getAttributeBooleanValue(i6, false) ? numAttrs3 : -numAttrs3;
                        j = j2;
                    }
                    i6++;
                    numAttrs = numAttrs2;
                    defaultColor = defaultColor2;
                }
                int defaultColor3 = defaultColor;
                int[] stateSpec2 = StateSet.trimStateSet(stateSpec, j);
                int color = m5992a(baseColor, alphaMod);
                if (listSize == 0 || stateSpec2.length == 0) {
                    defaultColor3 = color;
                }
                colorList = C1284c.m6005a(colorList, listSize, color);
                stateSpecList = (int[][]) C1284c.m6006a((T[]) stateSpecList, listSize, stateSpec2);
                listSize++;
                innerDepth = innerDepth2;
                defaultColor = defaultColor3;
                i = 1;
            }
        }
        int[] colors = new int[listSize];
        int[][] stateSpecs = new int[listSize][];
        System.arraycopy(colorList, 0, colors, 0, listSize);
        System.arraycopy(stateSpecList, 0, stateSpecs, 0, listSize);
        return new ColorStateList(stateSpecs, colors);
    }

    /* renamed from: a */
    private static TypedArray m5995a(Resources res, Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    /* renamed from: a */
    private static int m5992a(int color, float alphaMod) {
        return C1199a.m5722b(color, Math.round(((float) Color.alpha(color)) * alphaMod));
    }
}
