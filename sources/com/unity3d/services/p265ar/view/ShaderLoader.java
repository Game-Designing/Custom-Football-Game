package com.unity3d.services.p265ar.view;

import android.opengl.GLES20;
import com.unity3d.services.core.log.DeviceLog;

/* renamed from: com.unity3d.services.ar.view.ShaderLoader */
public class ShaderLoader {
    public static int load(String code, int type) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, code);
        GLES20.glCompileShader(shader);
        int[] status = new int[1];
        GLES20.glGetShaderiv(shader, 35713, status, 0);
        if (status[0] == 1) {
            return shader;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error compiling shader: ");
        sb.append(GLES20.glGetShaderInfoLog(shader));
        DeviceLog.error(sb.toString());
        GLES20.glDeleteShader(shader);
        return 0;
    }

    public static boolean checkGLError(String label) {
        int lastError = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            int error = glGetError;
            if (glGetError == 0) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(label);
            sb.append(": glError ");
            sb.append(error);
            DeviceLog.error(sb.toString());
            lastError = error;
        }
        return lastError != 0;
    }
}
