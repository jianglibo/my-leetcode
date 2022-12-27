/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package my.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LibraryTest {
    @Test
    void someLibraryMethodReturnsTrue() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }

    @Test
    void isJdk17() {
        assertTrue(System.getProperty("java.version").contains("17"),
                System.getProperty("java.version") + " should contains 17.");
    }
}
