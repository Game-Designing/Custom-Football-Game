package android.support.p001v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.widget.Ma */
/* compiled from: ResourcesWrapper */
class C0959Ma extends Resources {

    /* renamed from: a */
    private final Resources f3049a;

    public C0959Ma(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f3049a = resources;
    }

    public CharSequence getText(int id) throws NotFoundException {
        return this.f3049a.getText(id);
    }

    public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
        return this.f3049a.getQuantityText(id, quantity);
    }

    public String getString(int id) throws NotFoundException {
        return this.f3049a.getString(id);
    }

    public String getString(int id, Object... formatArgs) throws NotFoundException {
        return this.f3049a.getString(id, formatArgs);
    }

    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        return this.f3049a.getQuantityString(id, quantity, formatArgs);
    }

    public String getQuantityString(int id, int quantity) throws NotFoundException {
        return this.f3049a.getQuantityString(id, quantity);
    }

    public CharSequence getText(int id, CharSequence def) {
        return this.f3049a.getText(id, def);
    }

    public CharSequence[] getTextArray(int id) throws NotFoundException {
        return this.f3049a.getTextArray(id);
    }

    public String[] getStringArray(int id) throws NotFoundException {
        return this.f3049a.getStringArray(id);
    }

    public int[] getIntArray(int id) throws NotFoundException {
        return this.f3049a.getIntArray(id);
    }

    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        return this.f3049a.obtainTypedArray(id);
    }

    public float getDimension(int id) throws NotFoundException {
        return this.f3049a.getDimension(id);
    }

    public int getDimensionPixelOffset(int id) throws NotFoundException {
        return this.f3049a.getDimensionPixelOffset(id);
    }

    public int getDimensionPixelSize(int id) throws NotFoundException {
        return this.f3049a.getDimensionPixelSize(id);
    }

    public float getFraction(int id, int base, int pbase) {
        return this.f3049a.getFraction(id, base, pbase);
    }

    public Drawable getDrawable(int id) throws NotFoundException {
        return this.f3049a.getDrawable(id);
    }

    public Drawable getDrawable(int id, Theme theme) throws NotFoundException {
        return this.f3049a.getDrawable(id, theme);
    }

    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        return this.f3049a.getDrawableForDensity(id, density);
    }

    public Drawable getDrawableForDensity(int id, int density, Theme theme) {
        return this.f3049a.getDrawableForDensity(id, density, theme);
    }

    public Movie getMovie(int id) throws NotFoundException {
        return this.f3049a.getMovie(id);
    }

    public int getColor(int id) throws NotFoundException {
        return this.f3049a.getColor(id);
    }

    public ColorStateList getColorStateList(int id) throws NotFoundException {
        return this.f3049a.getColorStateList(id);
    }

    public boolean getBoolean(int id) throws NotFoundException {
        return this.f3049a.getBoolean(id);
    }

    public int getInteger(int id) throws NotFoundException {
        return this.f3049a.getInteger(id);
    }

    public XmlResourceParser getLayout(int id) throws NotFoundException {
        return this.f3049a.getLayout(id);
    }

    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        return this.f3049a.getAnimation(id);
    }

    public XmlResourceParser getXml(int id) throws NotFoundException {
        return this.f3049a.getXml(id);
    }

    public InputStream openRawResource(int id) throws NotFoundException {
        return this.f3049a.openRawResource(id);
    }

    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        return this.f3049a.openRawResource(id, value);
    }

    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        return this.f3049a.openRawResourceFd(id);
    }

    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        this.f3049a.getValue(id, outValue, resolveRefs);
    }

    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        this.f3049a.getValueForDensity(id, density, outValue, resolveRefs);
    }

    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        this.f3049a.getValue(name, outValue, resolveRefs);
    }

    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        return this.f3049a.obtainAttributes(set, attrs);
    }

    public void updateConfiguration(Configuration config, DisplayMetrics metrics) {
        super.updateConfiguration(config, metrics);
        Resources resources = this.f3049a;
        if (resources != null) {
            resources.updateConfiguration(config, metrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f3049a.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f3049a.getConfiguration();
    }

    public int getIdentifier(String name, String defType, String defPackage) {
        return this.f3049a.getIdentifier(name, defType, defPackage);
    }

    public String getResourceName(int resid) throws NotFoundException {
        return this.f3049a.getResourceName(resid);
    }

    public String getResourcePackageName(int resid) throws NotFoundException {
        return this.f3049a.getResourcePackageName(resid);
    }

    public String getResourceTypeName(int resid) throws NotFoundException {
        return this.f3049a.getResourceTypeName(resid);
    }

    public String getResourceEntryName(int resid) throws NotFoundException {
        return this.f3049a.getResourceEntryName(resid);
    }

    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        this.f3049a.parseBundleExtras(parser, outBundle);
    }

    public void parseBundleExtra(String tagName, AttributeSet attrs, Bundle outBundle) throws XmlPullParserException {
        this.f3049a.parseBundleExtra(tagName, attrs, outBundle);
    }
}
