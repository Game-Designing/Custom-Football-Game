package p005cm.aptoide.p006pt.utils.p015q;

import android.content.SharedPreferences;
import java.util.Arrays;
import p005cm.aptoide.p006pt.logger.Logger;

/* renamed from: cm.aptoide.pt.utils.q.GlExtensionsManager */
class GlExtensionsManager {
    private String computedValue;
    private final String[] openGLExtensions = {"GL_OES_compressed_ETC1_RGB8_texture", "GL_OES_compressed_paletted_texture", "GL_AMD_compressed_3DC_texture", "GL_AMD_compressed_ATC_texture", "GL_EXT_texture_compression_latc", "GL_EXT_texture_compression_dxt1", "GL_EXT_texture_compression_s3tc", "GL_ATI_texture_compression_atitc", "GL_IMG_texture_compression_pvrtc"};
    private final SharedPreferences sharedPreferences;
    private String supportedOpenGLExtensions = "";

    /* renamed from: cm.aptoide.pt.utils.q.GlExtensionsManager$Keys */
    class Keys {
        static final String GL_TEXTURES = "glTextures";
        static final String GL_TEXTURES_DEFINED = "glTexturesDefined";

        Keys() {
        }
    }

    GlExtensionsManager(SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }

    private String computeSupportedOpenGLExtensions() {
        String[] split;
        String glExtensions = "";
        boolean extensionAdded = false;
        for (String extension : this.supportedOpenGLExtensions.split(" ")) {
            if (Arrays.asList(this.openGLExtensions).contains(extension)) {
                if (extensionAdded) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(glExtensions);
                    sb.append(",");
                    glExtensions = sb.toString();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(glExtensions);
                sb2.append(extension);
                glExtensions = sb2.toString();
                extensionAdded = true;
            }
        }
        return glExtensions;
    }

    /* access modifiers changed from: 0000 */
    public void setSupportedOpenGLExtensions(String SupportedOpenGLExtensions) {
        this.supportedOpenGLExtensions = SupportedOpenGLExtensions;
        String computeSupportedOpenGLExtensions = computeSupportedOpenGLExtensions();
        this.computedValue = computeSupportedOpenGLExtensions;
        setSetoredSupportedOpenGLExtensions(computeSupportedOpenGLExtensions);
    }

    /* access modifiers changed from: 0000 */
    public String getSupportedExtensions() {
        if (isGLTextutesStored()) {
            this.computedValue = getStoredGlTextures();
        }
        String str = this.computedValue;
        String str2 = "";
        if (str == null || str2.equals(str)) {
            Logger.getInstance().mo2148w("ContentValues", "Supported OpenGL Extensions is empty!");
        }
        String str3 = this.computedValue;
        return str3 != null ? str3 : str2;
    }

    /* access modifiers changed from: 0000 */
    public boolean isSupportedExtensionsDefined() {
        return !"".equals(getSupportedExtensions());
    }

    private boolean isGLTextutesStored() {
        return this.sharedPreferences.getBoolean("glTexturesDefined", false);
    }

    private String getStoredGlTextures() {
        return this.sharedPreferences.getString("glTextures", null);
    }

    private void setSetoredSupportedOpenGLExtensions(String glTextures) {
        this.sharedPreferences.edit().putString("glTextures", glTextures).putBoolean("glTexturesDefined", true).apply();
    }
}
