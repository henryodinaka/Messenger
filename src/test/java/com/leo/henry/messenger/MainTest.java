package com.leo.henry.messenger;


import com.leo.henry.messenger.lecture.junit.Main;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)//This creates the class instance once
public class MainTest {

    Main main ;

    @BeforeEach
    void init(){
        System.out.println("this is init");
         main = new Main();
    }

    @Test
    @DisplayName("Testing add method")
    void testAdd(){
        int expected  = 2;

       int  actual =  main.add(1,1);
        assertEquals(expected,actual,"The add method should add two numbers ");
    }

    @Test
    @Disabled // This disables this test
    void skipped(){
        System.out.println("This is not suppose to run");
    }
    @Test
    void assumption(){
        assumeTrue(false);//this is used to check for a condition before a test is ran
        System.out.println("This condition avoid is true");
    }

    @Test
    void assertAllTest(){
        assertAll(
                ()->assertEquals(0,main.divide(0,2)),
                ()->assertEquals(2,main.add(1,1))
        );
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class,() ->main.divide(1,0),"Divide by zero should throw");

    }
    @Test
    void testArea(){
        assertEquals(314.1592653589793,main.circleArea(10),"Should return the circle area");

    }
}
