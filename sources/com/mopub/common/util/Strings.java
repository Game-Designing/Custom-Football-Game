package com.mopub.common.util;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class Strings {

    /* renamed from: a */
    private static Pattern f34606a = Pattern.compile("((\\d{1,2})|(100))%");

    /* renamed from: b */
    private static Pattern f34607b = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");

    public static String fromStream(InputStream inputStream) throws IOException {
        int numberBytesRead = 0;
        StringBuilder out = new StringBuilder();
        byte[] bytes = new byte[Opcodes.ACC_SYNTHETIC];
        while (numberBytesRead != -1) {
            out.append(new String(bytes, 0, numberBytesRead));
            numberBytesRead = inputStream.read(bytes);
        }
        inputStream.close();
        return out.toString();
    }

    public static boolean isPercentageTracker(String progressValue) {
        return !TextUtils.isEmpty(progressValue) && f34606a.matcher(progressValue).matches();
    }

    public static boolean isAbsoluteTracker(String progressValue) {
        return !TextUtils.isEmpty(progressValue) && f34607b.matcher(progressValue).matches();
    }

    public static String getDelimitedString(Object object, String delimiter) {
        String str = "";
        if (!(object instanceof List)) {
            return str;
        }
        List<Object> list = (List) object;
        if (list.isEmpty()) {
            return str;
        }
        return TextUtils.join(delimiter != null ? delimiter : ", ", list);
    }

    public static Integer parseAbsoluteOffset(String progressValue) {
        if (progressValue == null) {
            return null;
        }
        String[] split = progressValue.split(":");
        if (split.length != 3) {
            return null;
        }
        return Integer.valueOf((Integer.parseInt(split[0]) * 60 * 60 * 1000) + (Integer.parseInt(split[1]) * 60 * 1000) + ((int) (Float.parseFloat(split[2]) * 1000.0f)));
    }
}
