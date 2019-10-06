package com.facebook;

public class FacebookAuthorizationException extends FacebookException {
    public FacebookAuthorizationException() {
    }

    public FacebookAuthorizationException(String message) {
        super(message);
    }
}
