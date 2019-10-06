package com.fyber.inneractive.sdk.external;

public enum InneractiveErrorCode {
    NO_FILL("No Ad Found."),
    SERVER_INTERNAL_ERROR("Server Internal Error."),
    SERVER_INVALID_RESPONSE("Failed Due To Invalid Server Response."),
    SDK_INTERNAL_ERROR("SDK Internal Error."),
    CANCELLED("Ad Request Was Cancelled."),
    CONNECTION_TIMEOUT("Connection Timed Out."),
    CONNECTION_ERROR("Network Connection Error."),
    LOAD_TIMEOUT("Failed Due To load timeout"),
    UNKNOWN_APP_ID("Unknown App ID."),
    INVALID_INPUT("User Entered Invalid Input."),
    ERROR_CODE_NATIVE_VIDEO_NOT_SUPPORTED("Native Video Not Supported"),
    NATIVE_ADS_NOT_SUPPORTED_FOR_OS("Native ads not supported for this Android version"),
    ERROR_CONFIGURATION_MISMATCH("Internal Configuration Error"),
    SPOT_DISABLED("Selected spot is not active"),
    NON_SECURE_CONTENT_DETECTED("Non secure content detected"),
    UNSPECIFIED("Unspecified Error.");
    

    /* renamed from: a */
    private final String f15403a;

    private InneractiveErrorCode(String str) {
        this.f15403a = str;
    }

    public final String toString() {
        return this.f15403a;
    }
}
