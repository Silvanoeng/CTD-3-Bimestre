package util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {
    public static Timestamp dateToTimestamp(Date data) {
        return new Timestamp(data.getTime());
    }
}
