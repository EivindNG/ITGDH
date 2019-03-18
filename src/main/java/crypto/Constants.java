package crypto;

import tgdh.crypto.TgdhKeySpec;

import java.math.BigInteger;
import java.util.Random;

public class Constants {
    public static final TgdhKeySpec KEY_PARAMS = new TgdhKeySpec(new BigInteger(2048, 99, new Random()),
            new BigInteger(256, 99, new Random()),new BigInteger(128, new Random()));
}
