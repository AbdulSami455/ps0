package rules;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {

    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        // Existing test cases
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));

        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));

        assertFalse("Expected false: coursework not cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, false, false));

        assertTrue("Expected true: publicly available code, not implementation required and cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));

        assertFalse("Expected false: publicly available code with implementation required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));

        assertFalse("Expected false: code not available to others and not self-written",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));

        assertTrue("Expected true: self-written code even if not required",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, false));

        // Additional test cases
        assertTrue("Expected true: self-written code with citing",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, true, true));

        assertFalse("Expected false: code written as coursework and not cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, false, false));

        assertFalse("Expected false: available to others but not cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        
        // New test cases for more edge scenarios
        assertTrue("Expected true: self-written code, not available to others, not required",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, false));

        assertFalse("Expected false: not self-written, available, and required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, true));

        assertFalse("Expected false: publicly available code, no citation, not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));

        assertFalse("Expected false: coursework written but not cited and implementation required",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));

        assertTrue("Expected true: code available to others, cited and not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));

        assertTrue("Expected true: coursework cited correctly",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, true, true));

        assertFalse("Expected false: not self-written and coursework not cited",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));

        assertTrue("Expected true: self-written and citing correct",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, false));
    }
}
