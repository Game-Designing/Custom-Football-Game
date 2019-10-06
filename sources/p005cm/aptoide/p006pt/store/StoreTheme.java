package p005cm.aptoide.p006pt.store;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;

/* renamed from: cm.aptoide.pt.store.StoreTheme */
public enum StoreTheme {
    DEFAULT(C1375R.style.AptoideThemeDefault, C1375R.color.default_orange_gradient_start, C1375R.color.default_orange_gradient_end, C1375R.drawable.button_border_orange, C1375R.drawable.create_store_theme_shape_default, C1375R.drawable.main_orange_gradient, C1375R.color.default_text, C1375R.drawable.default_search_button_background, C1375R.drawable.aptoide_gradient_rounded, C1375R.style.DefaultDatePickerDialog, 8),
    GREEN(C1375R.style.AptoideThemeDefaultGreen, C1375R.color.green, C1375R.color.green_gradient_end, C1375R.drawable.button_border_green, C1375R.drawable.create_store_theme_shape_green, C1375R.drawable.green_gradient, C1375R.color.green_text, C1375R.drawable.green_search_button_background, C1375R.drawable.green_gradient_rounded, C1375R.style.GreenDatePickerDialog, 8),
    TEAL(C1375R.style.AptoideThemeDefaultTeal, C1375R.color.teal, C1375R.color.teal_gradient_end, C1375R.drawable.button_border_teal, C1375R.drawable.create_store_theme_shape_teal, C1375R.drawable.teal_gradient, C1375R.color.teal_text, C1375R.drawable.teal_search_button_background, C1375R.drawable.teal_gradient_rounded, C1375R.style.TealDatePickerDialog, 8),
    RED(C1375R.style.AptoideThemeDefaultRed, C1375R.color.red, C1375R.color.red_gradient_end, C1375R.drawable.button_border_red, C1375R.drawable.create_store_theme_shape_red, C1375R.drawable.red_gradient, C1375R.color.red_text, C1375R.drawable.red_search_button_background, C1375R.drawable.red_gradient_rounded, C1375R.style.RedDatePickerDialog, 8),
    INDIGO(C1375R.style.AptoideThemeDefaultIndigo, C1375R.color.indigo, C1375R.color.indigo_gradient_end, C1375R.drawable.button_border_indigo, C1375R.drawable.create_store_theme_shape_indigo, C1375R.drawable.indigo_gradient, C1375R.color.indigo_text, C1375R.drawable.indigo_search_button_background, C1375R.drawable.indigo_gradient_rounded, C1375R.style.IndigoDatePickerDialog, 8),
    PINK(C1375R.style.AptoideThemeDefaultPink, C1375R.color.pink, C1375R.color.pink_gradient_end, C1375R.drawable.button_border_pink, C1375R.drawable.create_store_theme_shape_pink, C1375R.drawable.pink_gradient, C1375R.color.pink_text, C1375R.drawable.pink_search_button_background, C1375R.drawable.pink_gradient_rounded, C1375R.style.PinkDatePickerDialog, 8),
    ORANGE(C1375R.style.AptoideThemeDefaultOrange, C1375R.color.orange, C1375R.color.orange_gradient_end, C1375R.drawable.button_border_orange, C1375R.drawable.create_store_theme_shape_orange, C1375R.drawable.orange_gradient, C1375R.color.orange_text, C1375R.drawable.orange_search_button_background, C1375R.drawable.orange_gradient_rounded, C1375R.style.OrangeDatePickerDialog, 8),
    BROWN(C1375R.style.AptoideThemeDefaultBrown, C1375R.color.brown, C1375R.color.brown_gradient_end, C1375R.drawable.button_border_brown, C1375R.drawable.create_store_theme_shape_brown, C1375R.drawable.brown_gradient, C1375R.color.brown_text, C1375R.drawable.brown_search_button_background, C1375R.drawable.brown_gradient_rounded, C1375R.style.BrownDatePickerDialog, 8),
    BLUE_GREY(C1375R.style.AptoideThemeDefaultBluegrey, C1375R.color.blue_grey, C1375R.color.blue_grey_gradient_end, C1375R.drawable.button_border_bluegrey, C1375R.drawable.create_store_theme_shape_blue_grey, C1375R.drawable.blue_grey_gradient, C1375R.color.blue_grey_text, C1375R.drawable.blue_grey_search_button_background, C1375R.drawable.blue_grey_gradient_rounded, C1375R.style.BlueGreyDatePickerDialog, 8),
    GREY(C1375R.style.AptoideThemeDefaultGrey, C1375R.color.grey, C1375R.color.grey_gradient_end, C1375R.drawable.button_border_grey, C1375R.drawable.create_store_theme_shape_grey, C1375R.drawable.grey_gradient, C1375R.color.grey_text, C1375R.drawable.grey_search_button_background, C1375R.drawable.grey_gradient_rounded, C1375R.style.GreyDatePickerDialog, 8),
    BLACK(C1375R.style.AptoideThemeDefaultBlack, C1375R.color.black, C1375R.color.grey, C1375R.drawable.button_border_black, C1375R.drawable.create_store_theme_shape_black, C1375R.drawable.black_gradient, C1375R.color.black_text, C1375R.drawable.black_search_button_background, C1375R.drawable.black_gradient_rounded, C1375R.style.BlackDatePickerDialog, 8),
    DEEP_PURPLE(C1375R.style.AptoideThemeDefaultDeepPurple, C1375R.color.deep_purple, C1375R.color.deep_purple_gradient_end, C1375R.drawable.button_border_deeppurple, C1375R.drawable.create_store_theme_shape_deep_purple, C1375R.drawable.deep_purple_gradient, C1375R.color.deep_purple_text, C1375R.drawable.deep_purple_search_button_background, C1375R.drawable.deep_purple_gradient_rounded, C1375R.style.DeepPurpleDatePickerDialog, 8),
    AMBER(C1375R.style.AptoideThemeDefaultAmber, C1375R.color.amber, C1375R.color.amber_gradient_end, C1375R.drawable.button_border_amber, C1375R.drawable.create_store_theme_shape_amber, C1375R.drawable.amber_gradient, C1375R.color.amber_text, C1375R.drawable.amber_search_button_background, C1375R.drawable.amber_gradient_rounded, C1375R.style.AmberDatePickerDialog, 8),
    LIGHT_GREEN(C1375R.style.AptoideThemeDefaultLightgreen, C1375R.color.light_green, C1375R.color.light_green_gradient_end, C1375R.drawable.button_border_lightgreen, C1375R.drawable.create_store_theme_shape_light_green, C1375R.drawable.light_green_gradient, C1375R.color.light_green_text, C1375R.drawable.light_green_search_button_background, C1375R.drawable.light_green_gradient_rounded, C1375R.style.LightGreenDatePickerDialog, 8),
    LIME(C1375R.style.AptoideThemeDefaultLime, C1375R.color.lime, C1375R.color.lime_gradient_end, C1375R.drawable.button_border_lime, C1375R.drawable.create_store_theme_shape_lime, C1375R.drawable.lime_gradient, C1375R.color.lime_text, C1375R.drawable.lime_search_button_background, C1375R.drawable.lime_gradient_rounded, C1375R.style.LimeDatePickerDialog, 8),
    LIGHT_BLUE(C1375R.style.AptoideThemeDefaultLightblue, C1375R.color.light_blue, C1375R.color.light_blue_gradient_end, C1375R.drawable.button_border_lightblue, C1375R.drawable.create_store_theme_shape_lightblue, C1375R.drawable.light_blue_gradient, C1375R.color.light_blue_text, C1375R.drawable.light_blue_search_button_background, C1375R.drawable.light_blue_gradient_rounded, C1375R.style.LightBlueDatePickerDialog, 8),
    SEA_GREEN(C1375R.style.AptoideThemeDefaultGreen, C1375R.color.green, C1375R.color.green_gradient_end, C1375R.drawable.button_border_green, C1375R.drawable.create_store_theme_shape_green, C1375R.drawable.light_green_gradient, C1375R.color.light_green_text, C1375R.drawable.green_search_button_background, C1375R.drawable.light_green_gradient_rounded, C1375R.style.GreenDatePickerDialog, 7),
    SLATE_GRAY(C1375R.style.AptoideThemeDefaultTeal, C1375R.color.teal, C1375R.color.teal_gradient_end, C1375R.drawable.button_border_teal, C1375R.drawable.create_store_theme_shape_teal, C1375R.drawable.teal_gradient, C1375R.color.teal_text, C1375R.drawable.teal_search_button_background, C1375R.drawable.teal_gradient_rounded, C1375R.style.TealDatePickerDialog, 7),
    BLUE(C1375R.style.AptoideThemeDefaultIndigo, C1375R.color.indigo, C1375R.color.indigo_gradient_end, C1375R.drawable.button_border_indigo, C1375R.drawable.create_store_theme_shape_indigo, C1375R.drawable.indigo_gradient, C1375R.color.blue_grey_text, C1375R.drawable.indigo_search_button_background, C1375R.drawable.indigo_gradient_rounded, C1375R.style.IndigoDatePickerDialog, 7),
    MAROON(C1375R.style.AptoideThemeDefaultBrown, C1375R.color.brown, C1375R.color.brown_gradient_end, C1375R.drawable.button_border_brown, C1375R.drawable.create_store_theme_shape_brown, C1375R.drawable.brown_gradient, C1375R.color.brown_text, C1375R.drawable.brown_search_button_background, C1375R.drawable.brown_gradient_rounded, C1375R.style.BrownDatePickerDialog, 7),
    MIDNIGHT(C1375R.style.AptoideThemeDefaultBluegrey, C1375R.color.blue_grey, C1375R.color.blue_grey_gradient_end, C1375R.drawable.button_border_bluegrey, C1375R.drawable.create_store_theme_shape_blue_grey, C1375R.drawable.blue_grey_gradient, C1375R.color.blue_grey_text, C1375R.drawable.grey_search_button_background, C1375R.drawable.blue_grey_gradient_rounded, C1375R.style.BlueGreyDatePickerDialog, 7),
    BLUE_GRAY(C1375R.style.AptoideThemeDefaultBluegrey, C1375R.color.blue_grey, C1375R.color.blue_grey_gradient_end, C1375R.drawable.button_border_bluegrey, C1375R.drawable.create_store_theme_shape_blue_grey, C1375R.drawable.blue_grey_gradient, C1375R.color.blue_grey_text, C1375R.drawable.blue_grey_search_button_background, C1375R.drawable.blue_grey_gradient_rounded, C1375R.style.BlueGreyDatePickerDialog, 7),
    SILVER(C1375R.style.AptoideThemeDefaultGrey, C1375R.color.grey, C1375R.color.grey_gradient_end, C1375R.drawable.button_border_grey, C1375R.drawable.create_store_theme_shape_grey, C1375R.drawable.grey_gradient, C1375R.color.grey_text, C1375R.drawable.grey_search_button_background, C1375R.drawable.grey_gradient_rounded, C1375R.style.GreyDatePickerDialog, 7),
    DIM_GRAY(C1375R.style.AptoideThemeDefaultGrey, C1375R.color.grey, C1375R.color.grey_gradient_end, C1375R.drawable.button_border_grey, C1375R.drawable.create_store_theme_shape_grey, C1375R.drawable.grey_gradient, C1375R.color.grey_text, C1375R.drawable.grey_search_button_background, C1375R.drawable.grey_gradient_rounded, C1375R.style.GreyDatePickerDialog, 7),
    MAGENTA(C1375R.style.AptoideThemeDefaultDeepPurple, C1375R.color.deep_purple, C1375R.color.deep_purple_gradient_end, C1375R.drawable.button_border_deeppurple, C1375R.drawable.create_store_theme_shape_deep_purple, C1375R.drawable.deep_purple_gradient, C1375R.color.deep_purple_text, C1375R.drawable.deep_purple_search_button_background, C1375R.drawable.deep_purple_gradient_rounded, C1375R.style.DeepPurpleDatePickerDialog, 7),
    YELLOW(C1375R.style.AptoideThemeDefaultAmber, C1375R.color.amber, C1375R.color.amber_gradient_end, C1375R.drawable.button_border_amber, C1375R.drawable.create_store_theme_shape_amber, C1375R.drawable.amber_gradient, C1375R.color.amber_text, C1375R.drawable.amber_search_button_background, C1375R.drawable.amber_gradient_rounded, C1375R.style.AmberDatePickerDialog, 7),
    GOLD(C1375R.style.AptoideThemeDefaultAmber, C1375R.color.amber, C1375R.color.amber_gradient_end, C1375R.drawable.button_border_amber, C1375R.drawable.create_store_theme_shape_amber, C1375R.drawable.amber_gradient, C1375R.color.amber_text, C1375R.drawable.amber_search_button_background, C1375R.drawable.amber_gradient_rounded, C1375R.style.AmberDatePickerDialog, 7),
    SPRING_GREEN(C1375R.style.AptoideThemeDefaultLightgreen, C1375R.color.light_green, C1375R.color.light_green_gradient_end, C1375R.drawable.button_border_lightgreen, C1375R.drawable.create_store_theme_shape_light_green, C1375R.drawable.light_green_gradient, C1375R.color.light_green_text, C1375R.drawable.light_green_search_button_background, C1375R.drawable.light_green_gradient_rounded, C1375R.style.LightGreenDatePickerDialog, 7),
    GREEN_APPLE(C1375R.style.AptoideThemeDefaultLime, C1375R.color.lime, C1375R.color.lime_gradient_end, C1375R.drawable.button_border_lime, C1375R.drawable.create_store_theme_shape_lime, C1375R.drawable.lime_gradient, C1375R.color.lime_text, C1375R.drawable.lime_search_button_background, C1375R.drawable.lime_gradient_rounded, C1375R.style.LimeDatePickerDialog, 7),
    LIGHT_SKY(C1375R.style.AptoideThemeDefaultLightblue, C1375R.color.light_blue, C1375R.color.light_blue_gradient_end, C1375R.drawable.button_border_lightblue, C1375R.drawable.create_store_theme_shape_lightblue, C1375R.drawable.light_blue_gradient, C1375R.color.light_blue_text, C1375R.drawable.light_blue_search_button_background, C1375R.drawable.light_blue_gradient_rounded, C1375R.style.LightBlueDatePickerDialog, 7),
    HAPPY_BLUE(C1375R.style.AptoideThemeDefaultLightblue, C1375R.color.light_blue, C1375R.color.light_blue_gradient_end, C1375R.drawable.button_border_lightblue, C1375R.drawable.create_store_theme_shape_lightblue, C1375R.drawable.light_blue_gradient, C1375R.color.light_blue_text, C1375R.drawable.light_blue_search_button_background, C1375R.drawable.light_blue_gradient_rounded, C1375R.style.LightBlueDatePickerDialog, 7);
    
    private final int buttonDrawable;
    private final int colorLetters;
    private final int darkerColor;
    private final int datePickerStyle;
    private int gradientDrawable;
    private int primaryColor;
    private final int raisedButtonDrawable;
    private final int roundDrawable;
    private int roundGradientButtonDrawable;
    private int storeStyle;
    private int version;

    static {
        boolean[] $jacocoInit;
        $jacocoInit[86] = true;
    }

    private StoreTheme(int storeStyle2, int primaryColor2, int darkerColor2, int buttonDrawable2, int roundDrawable2, int gradientDrawable2, int colorLetters2, int roundGradientButtonDrawable2, int raisedButtonDrawable2, int datePickerStyle2, int version2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeStyle = storeStyle2;
        this.primaryColor = primaryColor2;
        this.darkerColor = darkerColor2;
        this.buttonDrawable = buttonDrawable2;
        this.roundDrawable = roundDrawable2;
        this.gradientDrawable = gradientDrawable2;
        this.colorLetters = colorLetters2;
        this.roundGradientButtonDrawable = roundGradientButtonDrawable2;
        this.raisedButtonDrawable = raisedButtonDrawable2;
        this.datePickerStyle = datePickerStyle2;
        this.version = version2;
        $jacocoInit[2] = true;
    }

    public static List<StoreTheme> getThemesFromVersion(int version2) {
        boolean[] $jacocoInit = $jacocoInit();
        List<StoreTheme> themes = new LinkedList<>();
        $jacocoInit[3] = true;
        StoreTheme[] values = values();
        int length = values.length;
        $jacocoInit[4] = true;
        int i = 0;
        while (i < length) {
            StoreTheme theme = values[i];
            $jacocoInit[5] = true;
            if (theme.getVersion() != version2) {
                $jacocoInit[6] = true;
            } else {
                $jacocoInit[7] = true;
                themes.add(theme);
                $jacocoInit[8] = true;
            }
            i++;
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
        return themes;
    }

    public static StoreTheme get(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        Appearance appearance = store.getAppearance();
        $jacocoInit[11] = true;
        String theme = appearance.getTheme();
        $jacocoInit[12] = true;
        StoreTheme storeTheme = get(theme);
        $jacocoInit[13] = true;
        return storeTheme;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p005cm.aptoide.p006pt.store.StoreTheme get(java.lang.String r5) {
        /*
            boolean[] r0 = $jacocoInit()
            r1 = 14
            r2 = 1
            r3 = 0
            r0[r1] = r2     // Catch:{ IllegalArgumentException -> 0x003a }
            r1 = r3
            if (r5 != 0) goto L_0x0012
            r3 = 15
            r0[r3] = r2     // Catch:{ IllegalArgumentException -> 0x0038 }
            goto L_0x0033
        L_0x0012:
            r3 = 16
            r0[r3] = r2     // Catch:{ IllegalArgumentException -> 0x0038 }
            java.lang.String r3 = "-"
            java.lang.String r4 = "_"
            java.lang.String r3 = r5.replace(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0038 }
            r4 = 17
            r0[r4] = r2     // Catch:{ IllegalArgumentException -> 0x0038 }
            java.lang.String r3 = r3.toUpperCase()     // Catch:{ IllegalArgumentException -> 0x0038 }
            r4 = 18
            r0[r4] = r2     // Catch:{ IllegalArgumentException -> 0x0038 }
            cm.aptoide.pt.store.StoreTheme r3 = valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0038 }
            r1 = r3
            r3 = 19
            r0[r3] = r2     // Catch:{ IllegalArgumentException -> 0x0038 }
        L_0x0033:
            r3 = 20
            r0[r3] = r2
            goto L_0x0040
        L_0x0038:
            r3 = move-exception
            goto L_0x003c
        L_0x003a:
            r1 = move-exception
            r1 = r3
        L_0x003c:
            r3 = 21
            r0[r3] = r2
        L_0x0040:
            if (r1 == 0) goto L_0x0047
            r3 = 22
            r0[r3] = r2
            goto L_0x004d
        L_0x0047:
            cm.aptoide.pt.store.StoreTheme r1 = DEFAULT
            r3 = 23
            r0[r3] = r2
        L_0x004d:
            r3 = 24
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.StoreTheme.get(java.lang.String):cm.aptoide.pt.store.StoreTheme");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p005cm.aptoide.p006pt.store.StoreTheme get(int r4) {
        /*
            boolean[] r0 = $jacocoInit()
            r1 = 25
            r2 = 1
            r3 = 0
            r0[r1] = r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0019 }
            r1 = r3
            cm.aptoide.pt.store.StoreTheme[] r3 = values()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017 }
            r3 = r3[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0017 }
            r1 = r3
            r3 = 26
            r0[r3] = r2
            goto L_0x001f
        L_0x0017:
            r3 = move-exception
            goto L_0x001b
        L_0x0019:
            r1 = move-exception
            r1 = r3
        L_0x001b:
            r3 = 27
            r0[r3] = r2
        L_0x001f:
            if (r1 == 0) goto L_0x0026
            r3 = 28
            r0[r3] = r2
            goto L_0x002c
        L_0x0026:
            cm.aptoide.pt.store.StoreTheme r1 = DEFAULT
            r3 = 29
            r0[r3] = r2
        L_0x002c:
            r3 = 30
            r0[r3] = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.store.StoreTheme.get(int):cm.aptoide.pt.store.StoreTheme");
    }

    public static StoreTheme fromName(String themeName) {
        boolean[] $jacocoInit = $jacocoInit();
        String storeThemeName = themeName.toLowerCase();
        $jacocoInit[31] = true;
        StoreTheme[] values = values();
        int length = values.length;
        $jacocoInit[32] = true;
        int i = 0;
        while (i < length) {
            StoreTheme theme = values[i];
            $jacocoInit[33] = true;
            if (TextUtils.equals(theme.getThemeName(), storeThemeName)) {
                $jacocoInit[34] = true;
                return theme;
            }
            i++;
            $jacocoInit[35] = true;
        }
        StoreTheme storeTheme = DEFAULT;
        $jacocoInit[36] = true;
        return storeTheme;
    }

    public int getVersion() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.version;
        $jacocoInit[37] = true;
        return i;
    }

    public int getRoundDrawable() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.roundDrawable;
        $jacocoInit[38] = true;
        return i;
    }

    public int getStoreHeaderColorResource(Resources resources, Theme theme) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[39] = true;
            int color = resources.getColor(getPrimaryColor(), theme);
            $jacocoInit[40] = true;
            return color;
        }
        int color2 = resources.getColor(getPrimaryColor());
        $jacocoInit[41] = true;
        return color2;
    }

    public int getPrimaryColor() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.primaryColor;
        $jacocoInit[42] = true;
        return i;
    }

    public int getThemeResource() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.storeStyle;
        $jacocoInit[43] = true;
        return i;
    }

    @TargetApi(21)
    public int getDarkerColor() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.darkerColor;
        $jacocoInit[44] = true;
        return i;
    }

    public Drawable getButtonLayoutDrawable(Resources resources, Theme theme) {
        boolean[] $jacocoInit = $jacocoInit();
        if (VERSION.SDK_INT >= 23) {
            $jacocoInit[45] = true;
            Drawable drawable = resources.getDrawable(getButtonDrawable(), theme);
            $jacocoInit[46] = true;
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(getButtonDrawable());
        $jacocoInit[47] = true;
        return drawable2;
    }

    public int getButtonDrawable() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.buttonDrawable;
        $jacocoInit[48] = true;
        return i;
    }

    public String getThemeName() {
        boolean[] $jacocoInit = $jacocoInit();
        String lowerCase = name().toLowerCase();
        $jacocoInit[49] = true;
        String replace = lowerCase.replace('_', '-');
        $jacocoInit[50] = true;
        return replace;
    }

    public int getGradientDrawable() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.gradientDrawable;
        $jacocoInit[51] = true;
        return i;
    }

    public int getColorLetters() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.colorLetters;
        $jacocoInit[52] = true;
        return i;
    }

    public int getRoundGradientButtonDrawable() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.roundGradientButtonDrawable;
        $jacocoInit[53] = true;
        return i;
    }

    public int getRaisedButtonDrawable() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.raisedButtonDrawable;
        $jacocoInit[54] = true;
        return i;
    }

    public int getDatePickerStyle() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.datePickerStyle;
        $jacocoInit[55] = true;
        return i;
    }
}
