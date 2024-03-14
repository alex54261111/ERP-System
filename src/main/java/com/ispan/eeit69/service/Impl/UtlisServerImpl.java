package com.ispan.eeit69.service.Impl;

import com.ispan.eeit69.service.UtilsServer;
import com.ispan.eeit69.utils.BCrypt;

public class UtlisServerImpl implements UtilsServer {
    @Override
    public String encryptionByStr(String encryptionStr) {
        return BCrypt.hashpw(encryptionStr,BCrypt.gensalt());
    }

    @Override
    public boolean DecryptByStr(String Str, String encryptionStr) {
        return BCrypt.checkpw(Str, encryptionStr);
    }
}
