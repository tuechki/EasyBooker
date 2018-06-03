package com.elsys.easybooker.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String HEADER_STRING_ADDITIONAL_HEADERS = "access-control-expose-headers";
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_METHODS_VALUE = "GET, POST, PATCH, PUT, DELETE, OPTIONS";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS_VALUE = "Origin, Content-Type, X-Auth-Token";
}
