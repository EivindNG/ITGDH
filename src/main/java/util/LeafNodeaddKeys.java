package util;

import crypto.Constants;
import tgdh.crypto.TgdhKeySpec;
import tgdh.crypto.TgdhPrivateKey;
import tgdh.crypto.TgdhPublicKey;
import tgdh.tree.LeafNode;

import java.io.NotSerializableException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;

public class LeafNodeaddKeys {


    public static LeafNode addKeys(LeafNode leafNode, TgdhKeySpec keyParams) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NotSerializableException {

        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("DSA");
        DSAParameterSpec paramSp = new DSAParameterSpec(keyParams.getP(),keyParams.getQ(),keyParams.getG());
        pairgen.initialize(paramSp);
        KeyPair keyPair = pairgen.generateKeyPair();

        DSAPrivateKey priKey = (DSAPrivateKey) keyPair.getPrivate();
        DSAPublicKey pubKey = (DSAPublicKey) keyPair.getPublic();

        leafNode.setKeys(new TgdhPrivateKey(Constants.KEY_PARAMS,priKey.getX()),
                new TgdhPublicKey(Constants.KEY_PARAMS,pubKey.getY()));
        return leafNode;
    }
}
