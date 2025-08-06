package core;

import com.aventstack.extentreports.ExtentReports;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestHandler;

import java.lang.reflect.ParameterizedType;

@ExtendWith(TestHandler.class)
public class CucumberTestBase<T> {

    protected T controller;
    protected static ExtentReports extent;

    protected T createControllerInstance() {
        try {
            return ((Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create controller instance", e);
        }
    }
}
