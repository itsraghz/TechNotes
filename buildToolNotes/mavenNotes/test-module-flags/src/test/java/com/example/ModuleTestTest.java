package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModuleTestTest {
    @Test
    void testInternalApiAccess() {
        assertDoesNotThrow(() -> {
            ModuleTest.demonstrateInternalApiAccess();
        }, "Should be able to access internal APIs with module flags");
    }
    
    @Test
    void testReflection() {
        assertDoesNotThrow(() -> {
            ModuleTest.demonstrateReflection();
        }, "Should be able to use reflection with module flags");
    }
}

