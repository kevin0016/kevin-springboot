package com.itkevin.springcloud.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;

import java.io.File;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

public class OpenSSLUtils {

    public static KeyPair readKeyPair(File pemFile, char[] password) throws Exception {
        PEMParser pemParser = new PEMParser(new FileReader(pemFile));
        Object object = pemParser.readObject();
        pemParser.close();
        PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        //获得密钥对
        KeyPair kp = null;
        if(object instanceof PEMEncryptedKeyPair) {
            kp = converter.getKeyPair(((PEMEncryptedKeyPair)object).decryptKeyPair(decProv));
        } else {
            kp = converter.getKeyPair((PEMKeyPair)object);
        }
        return kp;
    }

    public PublicKey initKeyPair(String pemFilePath, String password) {
        byte[] data = "PEM".getBytes();
        Security.addProvider(new BouncyCastleProvider());
        KeyPair kp;
        try{
            kp = (KeyPair)readKeyPair(new File(pemFilePath), password.toCharArray());
            PublicKey publicKey = kp.getPublic();
            PrivateKey privateKey = kp.getPrivate();

            return publicKey;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
