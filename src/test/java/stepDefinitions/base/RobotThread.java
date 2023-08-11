package stepDefinitions.base;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.halcom.properties.Properties.getPropertyValue;
import static stepDefinitions.base.Hooks.smeClientPropertyFile;

public class RobotThread extends Thread {

    private Robot robot = null;

    public RobotThread() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        start();
    }

    @Override
    public void run() {

        //while (!isUrlLoaded){
        try {
            System.out.println("ROBOTTT1");
            Thread.sleep(Long.parseLong(getPropertyValue("WAIT_TIME_FOR_CERT_TO_SHOW", smeClientPropertyFile)));
            System.out.println("ROBOTTT2");
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //}
    }

    public static void robotEnterPin(Robot robot, String certPin) throws Exception {
        Thread.sleep(8000);//give some time for activation input field (where we type PIN)

        String certPIN= certPin;
        for (char c : certPIN.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
    public static void robotPressEnter(Robot robot) throws Exception  {
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public static void robotPressLeftOK(Robot robot) throws Exception  {
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robotPressEnter(robot);
    }

    public static void robotPressTabTabOK(Robot robot) throws Exception  {
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robotPressEnter(robot);
    }
    public static void robotPressEsc(Robot robot) throws Exception  {
        Thread.sleep(10000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
    public static void robotPressDownEnter(Robot robot) throws Exception  {
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robotPressEnter(robot);
    }

    public static void robotPressUpEnter(Robot robot) throws Exception  {
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
        robotPressEnter(robot);
    }
}
