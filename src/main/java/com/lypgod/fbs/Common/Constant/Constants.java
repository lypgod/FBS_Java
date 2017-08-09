package com.lypgod.fbs.Common.Constant;

public class Constants {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    /**
     * JWT
     */
    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "weeho_jwt";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond

    private Constants() {
    }
}
