package com.unity3d.services.core.misc;

import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;

public class Utilities {
    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0);
    }

    public static void runOnUiThread(Runnable runnable, long delay) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (delay > 0) {
            handler.postDelayed(runnable, delay);
        } else {
            handler.post(runnable);
        }
    }

    public static String Sha256(String input) {
        return Sha256(input.getBytes());
    }

    public static String Sha256(byte[] input) {
        if (input == null) {
            return null;
        }
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            m.update(input, 0, input.length);
            return toHexString(m.digest());
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String Sha256(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[Opcodes.ACC_SYNTHETIC];
            while (true) {
                int read = inputStream.read(buffer);
                int read2 = read;
                if (read == -1) {
                    return toHexString(m.digest());
                }
                m.update(buffer, 0, read2);
            }
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String toHexString(byte[] array) {
        String output = "";
        for (byte rawByte : array) {
            int b = rawByte & 255;
            if (b <= 15) {
                StringBuilder sb = new StringBuilder();
                sb.append(output);
                sb.append(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
                output = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(output);
            sb2.append(Integer.toHexString(b));
            output = sb2.toString();
        }
        return output;
    }

    public static boolean writeFile(File fileToWrite, String content) {
        String str = "Error closing FileOutputStream";
        if (fileToWrite == null) {
            return false;
        }
        boolean fos = null;
        boolean fos2 = true;
        try {
            fos = new FileOutputStream(fileToWrite);
            fos.write(content.getBytes());
            fos.flush();
            try {
                fos.close();
            } catch (Exception e) {
                DeviceLog.exception(str, e);
            }
        } catch (Exception e2) {
            fos2 = false;
            DeviceLog.exception("Could not write file", e2);
            if (fos != null) {
                fos.close();
            }
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e3) {
                    DeviceLog.exception(str, e3);
                }
            }
        }
        if (fos) {
            StringBuilder sb = new StringBuilder();
            sb.append("Wrote file: ");
            sb.append(fileToWrite.getAbsolutePath());
            DeviceLog.debug(sb.toString());
        }
        return fos;
    }

    public static byte[] readFileBytes(File file) throws IOException {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[((int) file.length())];
        int offset = 0;
        int readAmount = file.length() < ((long) Opcodes.ACC_SYNTHETIC) ? (int) file.length() : 4096;
        while (true) {
            int read = fileInputStream.read(buffer, offset, readAmount);
            int read2 = read;
            if (read > 0) {
                offset += read2;
                if (file.length() - ((long) offset) < ((long) Opcodes.ACC_SYNTHETIC)) {
                    readAmount = ((int) file.length()) - offset;
                }
            } else {
                fileInputStream.close();
                return buffer;
            }
        }
    }

    public static JSONObject mergeJsonObjects(JSONObject primary, JSONObject secondary) throws JSONException {
        if (primary == null) {
            return secondary;
        }
        if (secondary == null) {
            return primary;
        }
        JSONObject newJsonObject = new JSONObject();
        Iterator<String> keys = secondary.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            newJsonObject.put(key, secondary.get(key));
        }
        Iterator<String> keys2 = primary.keys();
        while (keys2.hasNext()) {
            String key2 = (String) keys2.next();
            if (!newJsonObject.has(key2) || !(newJsonObject.get(key2) instanceof JSONObject) || !(primary.get(key2) instanceof JSONObject)) {
                newJsonObject.put(key2, primary.get(key2));
            } else {
                newJsonObject.put(key2, mergeJsonObjects(primary.getJSONObject(key2), newJsonObject.getJSONObject(key2)));
            }
        }
        return newJsonObject;
    }
}
