package com.lypgod.fbs.Common.Util;

import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class JWTUtilsTest {
    @Test(expected = ExpiredJwtException.class)
    public void JwtUtilsTest() {
//        System.out.println(JWTUtils.createJWT("id", "issuer", "subject", -1));
//        JWTUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJpZCIsImlhdCI6MTQ5MDE0OTU2Niwic3ViIjoic3ViamVjdCIsImlzcyI6Imlzc3VlciIsImV4cCI6MTQ5MDE0OTU2Nn0.RkXWL-Rgq3HHyoyLTx6VtoCZZBdFKEPFPxOU1TQXh9Q");
//        JWTUtils.parseJWT(JWTUtils.createJWT("id", "issuer", "subject", -1));
    }
} 
