package com.netcosports.ntlm;

import java.io.IOException;
import java.util.List;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public class NTLMAuthenticator implements Authenticator {
    private final NTLMEngineImpl engine = new NTLMEngineImpl();
    private final String domain;
    private final String username;
    private final String password;
    private final String ntlmMsg1;

    public NTLMAuthenticator(String username, String password, String domain) {
        this.domain = domain;
        this.username = username;
        this.password = password;
        String localNtlmMsg1 = null;
        try {
            localNtlmMsg1 = engine.generateType1Msg(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ntlmMsg1 = localNtlmMsg1;
    }


    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        final List<String> wwwAuthenticate = response.headers().values("WWW-Authenticate");
        if (wwwAuthenticate.contains("NTLM")) {
            return response.request().newBuilder().header("Authorization", "NTLM " + ntlmMsg1).build();
        }
        String ntlmMsg3 = null;
        try {
            ntlmMsg3 = engine.generateType3Msg(username, password, domain, "android-device", wwwAuthenticate.get(0).substring(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.request().newBuilder().header("Authorization", "NTLM " + ntlmMsg3).build();
    }
}