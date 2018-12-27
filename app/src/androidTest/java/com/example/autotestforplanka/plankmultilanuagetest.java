package com.example.autotestforplanka;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@RunWith(JUnit4.class)
public class plankmultilanuagetest {
    public Instrumentation instrumentation;
    public UiDevice uiDevice;

    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }
    @Test
    public void Test() throws RemoteException, InterruptedException,UiObjectNotFoundException {
        String[] lang = {"en","fr","it","de","es","ru","pt","nl","po","ja","ko","tr","ar","in","cn","tw"};
        uiDevice.pressHome();
        Thread.sleep(300);
        uiDevice.findObject(By.desc("Plank Workout")).click();
        Thread.sleep(6000);
        //截英语
        uiDevice.takeScreenshot(new File("/data/data/com.example.autotestforplanka/"+lang[0]+"_homepage.jpg"));
        Thread.sleep(200);
        //截图 法语，意大利，德语，西班牙语
        for(int i=1;i<5;i++){
        new UiObject(new UiSelector().className("android.widget.ImageButton")).click();
        Thread.sleep(200);
        new UiObject(new UiSelector().className("android.widget.CheckedTextView").instance(5)).click();
        Thread.sleep(200);
        new UiObject(new UiSelector().className("android.widget.CheckedTextView").instance(1)).click();
        Thread.sleep(6000);
        uiDevice.takeScreenshot(new File("/data/data/com.example.autotestforplanka/"+lang[i]+"_homepage.jpg"));
        Thread.sleep(200);}
        //截剩余的语言
        for(int i=5;i<16;i++){
            new UiObject(new UiSelector().className("android.widget.ImageButton")).click();
            Thread.sleep(200);
            new UiObject(new UiSelector().className("android.widget.CheckedTextView").instance(5)).click();
            Thread.sleep(200);
            new UiObject(new UiSelector().className("android.widget.CheckedTextView").instance(i-2)).click();
            Thread.sleep(6000);
            uiDevice.takeScreenshot(new File("/data/data/com.example.autotestforplanka/"+lang[i]+"_homepage.jpg"));}
            Thread.sleep(200);
    }
}
