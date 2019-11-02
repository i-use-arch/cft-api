package xyz.niflheim.cft_api.db.util;

import java.util.UUID;

public class Snowflake {
    public static long get() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
