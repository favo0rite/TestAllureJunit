package basetestsclass;

import appline.managers.InitManager;
import appline.managers.ManagerPages;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static appline.managers.DriverManager.getDriver;
import static appline.managers.InitManager.props;
import static appline.utils.PropConst.APP_URL;

public class BaseTestClass {
    protected ManagerPages app = ManagerPages.getManagerPages();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        getDriver().get(props.getProperty(APP_URL));
    }


    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
