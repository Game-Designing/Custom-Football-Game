package com.unity3d.services.p265ar.view;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.google.ar.core.Frame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.unity3d.services.ar.view.BackgroundRenderer */
public class BackgroundRenderer {
    private static final int COORDS_PER_VERTEX = 3;
    private static final int FLOAT_SIZE = 4;
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}";
    private static final float[] QUAD_COORDS = {-1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] QUAD_TEXCOORDS = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final int TEXCOORDS_PER_VERTEX = 2;
    private static final String VERTEX_SHADER = "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}";
    private int quadPositionParam;
    private int quadProgram;
    private FloatBuffer quadTexCoord;
    private int quadTexCoordParam;
    private FloatBuffer quadTexCoordTransformed;
    private FloatBuffer quadVertices;
    private int textureId = -1;

    BackgroundRenderer() {
    }

    /* access modifiers changed from: 0000 */
    public int getTextureId() {
        return this.textureId;
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(15)
    public void createOnGlThread() {
        int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        this.textureId = textures[0];
        GLES20.glBindTexture(36197, this.textureId);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9728);
        float[] fArr = QUAD_COORDS;
        if (4 == fArr.length / 3) {
            ByteBuffer bbVertices = ByteBuffer.allocateDirect(fArr.length * 4);
            bbVertices.order(ByteOrder.nativeOrder());
            this.quadVertices = bbVertices.asFloatBuffer();
            this.quadVertices.put(QUAD_COORDS);
            this.quadVertices.position(0);
            ByteBuffer bbTexCoords = ByteBuffer.allocateDirect(4 * 2 * 4);
            bbTexCoords.order(ByteOrder.nativeOrder());
            this.quadTexCoord = bbTexCoords.asFloatBuffer();
            this.quadTexCoord.put(QUAD_TEXCOORDS);
            this.quadTexCoord.position(0);
            ByteBuffer bbTexCoordsTransformed = ByteBuffer.allocateDirect(4 * 2 * 4);
            bbTexCoordsTransformed.order(ByteOrder.nativeOrder());
            this.quadTexCoordTransformed = bbTexCoordsTransformed.asFloatBuffer();
            int vertexShader = ShaderLoader.load(VERTEX_SHADER, 35633);
            int fragmentShader = ShaderLoader.load(FRAGMENT_SHADER, 35632);
            this.quadProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.quadProgram, vertexShader);
            GLES20.glAttachShader(this.quadProgram, fragmentShader);
            GLES20.glLinkProgram(this.quadProgram);
            GLES20.glUseProgram(this.quadProgram);
            ShaderLoader.checkGLError("Program creation");
            this.quadPositionParam = GLES20.glGetAttribLocation(this.quadProgram, "a_Position");
            this.quadTexCoordParam = GLES20.glGetAttribLocation(this.quadProgram, "a_TexCoord");
            ShaderLoader.checkGLError("Program parameters");
            return;
        }
        throw new RuntimeException("Unexpected number of vertices in BackgroundRenderer.");
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(15)
    public void draw(Frame frame) {
        if (frame.hasDisplayGeometryChanged()) {
            frame.transformDisplayUvCoords(this.quadTexCoord, this.quadTexCoordTransformed);
        } else {
            Frame frame2 = frame;
        }
        GLES20.glDisable(2929);
        GLES20.glDepthMask(false);
        GLES20.glBindTexture(36197, this.textureId);
        GLES20.glUseProgram(this.quadProgram);
        GLES20.glVertexAttribPointer(this.quadPositionParam, 3, 5126, false, 0, this.quadVertices);
        GLES20.glVertexAttribPointer(this.quadTexCoordParam, 2, 5126, false, 0, this.quadTexCoordTransformed);
        GLES20.glEnableVertexAttribArray(this.quadPositionParam);
        GLES20.glEnableVertexAttribArray(this.quadTexCoordParam);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.quadPositionParam);
        GLES20.glDisableVertexAttribArray(this.quadTexCoordParam);
        GLES20.glDepthMask(true);
        GLES20.glEnable(2929);
    }
}
