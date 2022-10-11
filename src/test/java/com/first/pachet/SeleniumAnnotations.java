package com.first.pachet;

import org.testng.annotations.*;

import java.sql.SQLOutput;

public class SeleniumAnnotations {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }


    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        System.out.println("beforeTest");
    }


    @BeforeGroups(groups  = {"Grupul 1"})
    public void beforeGroups(){
        System.out.println("beforeGroups");
    }


    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @BeforeClass(groups = {"Grupul 1"})
    public void beforeGroupClass(){
        System.out.println("beforeCroupClass");
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Test(groups  = {"Grupul 1"})
    public void test1(){
        System.out.println("test1");
    }

    @Test(groups  = {"Grupul 2"})
    public void test2(){
        System.out.println("test2");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("afterMethod");
    }


    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("afterClass");
    }


    @AfterGroups(groups  = {"Grupul 1"})
    public void afterGroups(){
        System.out.println("afterGroups");
    }



    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("afterTest");
    }


    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("afterSuite");
    }


}
