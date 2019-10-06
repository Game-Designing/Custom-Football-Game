package com.facebook;

public class FacebookSdkNotInitializedException extends FacebookException {
    public FacebookSdkNotInitializedException() {
    }

    public FacebookSdkNotInitializedException(String message) {
        super(message);
    }
}
