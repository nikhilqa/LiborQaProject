package Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogSetting {
    private static boolean root = false;

    public static Logger getLogger(Class cls) {
        if (root) {
            return Logger.getLogger(cls);
        }
        PropertyConfigurator.configure("ConfigFiles/log4j.properties");
        root = true;
        return Logger.getLogger(cls);
    }
}
