package com.automation.parallel;

import java.io.File;

/**
 * Created by Eswaran M
 */
public class OsType {

    private static String DRIVERS = "drivers";

    private static String CHROME  = "chrome";
    private static String FIREFOX  = "firefox";

    private static String WINDOWS = "windows";
    private static String MAC = "mac";
    private static String LINUX = "linux";

    private static String CHROME_DRIVER = "chromedriver";
    private static String FIREFOX_DRIVER = "geckodriver";


    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void main(String a[]){
        System.out.print(getChromeOsType());
    }
    public static String getChromeOsType() {
        String absolutePath  = new File("").getAbsolutePath();
        if (isWindows()) {
            return absolutePath + File.separator + DRIVERS + File.separator+ WINDOWS
                    +File.separator+ CHROME + File.separator +CHROME_DRIVER+".exe";

        } else if (isMac()) {
            return absolutePath + File.separator + DRIVERS + File.separator + MAC
                    + File.separator + CHROME + File.separator + CHROME_DRIVER;
        } else {
            return absolutePath + File.separator + DRIVERS + File.separator + LINUX
                    + File.separator + CHROME + File.separator + CHROME_DRIVER;
        }
    }
    public static String getFirefoxOsType() {
        String absolutePath  = new File("").getAbsolutePath();
        if (isWindows()) {
            return absolutePath + File.separator + DRIVERS + File.separator+ WINDOWS
                    +File.separator+ FIREFOX + File.separator +FIREFOX_DRIVER+".exe";

        } else if (isMac()) {
            return absolutePath + File.separator + DRIVERS + File.separator + MAC
                    + File.separator + FIREFOX + File.separator + FIREFOX_DRIVER;
        } else {
            return absolutePath + File.separator + DRIVERS + File.separator + LINUX
                    + File.separator + FIREFOX + File.separator + FIREFOX_DRIVER;
        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

}
