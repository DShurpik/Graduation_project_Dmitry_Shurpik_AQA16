package driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverFactory {

    public static DriverManager getManager(DriverManagerType driverManagerType) {
        DriverManager driverManager = null;
        switch (driverManagerType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
        }
        return driverManager;
    }


}
