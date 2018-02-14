package com.netcosports.ntlm;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;


public class EncodingUtils {

    public static final Charset ASCII = Charset.forName("US-ASCII");

    public static byte[] getBytes(final String data, final String charset) {

        try {
            return data.getBytes(charset);
        } catch (final UnsupportedEncodingException e) {
            return data.getBytes();
        }
    }

    public static String getAsciiString(final byte[] data) {
        return getAsciiString(data, 0, data.length);
    }

    public static String getAsciiString(final byte[] data, final int offset, final int length) {

        return new String(data, offset, length, ASCII);
    }
}
