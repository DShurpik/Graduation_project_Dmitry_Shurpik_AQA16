package testNgUtils;

import propertyReader.PropertyReader;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        String propertyName = context.getSuite()
                .getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config");
        new PropertyReader(propertyName);
    }
}
