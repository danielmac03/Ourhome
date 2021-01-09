package com.ourhome.security;

public class Constants {
	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";
	
	public static final String ISSUER_INFO = "OURHOME";
	public static final String SUPER_SECRET_KEY = "admin";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000;	
}
