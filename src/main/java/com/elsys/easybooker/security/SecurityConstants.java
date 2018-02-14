package com.elsys.easybooker.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String HEADER_STRING_ADDITIONAL_HEADERS = "access-control-expose-headers";
    public static final int NOT_RELATED = 0;
    public static final int EMPLOYEE = 1;
    public static final int ADMIN = 2;
    public static final int ADMIN_AND_EMPLOYEE = 3;
}
