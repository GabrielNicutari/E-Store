package com.example.demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SysRequirementTest {

    SysRequirement sysRequirementTest = new SysRequirement(1, "cpuTest", "gpuTest",
            "memoryTest", "storageTest", "osTest");
    @Test
    void getId() {
        assertEquals(1, sysRequirementTest.getId());
    }

    @Test
    void setId() {
        sysRequirementTest.setId(2);
        assertEquals(2, sysRequirementTest.getId());
    }

    @Test
    void getCpu() {
        assert("cpuTest").equals(sysRequirementTest.getCpu());
    }

    @Test
    void setCpu() {
        sysRequirementTest.setCpu("cpuTest2");
        assert("cpuTest2").equals(sysRequirementTest.getCpu());
    }

    @Test
    void getGpu() {
        assert("gpuTest").equals(sysRequirementTest.getGpu());
    }

    @Test
    void setGpu() {
        sysRequirementTest.setGpu("gpuTest2");
        assert("gpuTest2").equals(sysRequirementTest.getGpu());
    }

    @Test
    void getMemory() {
        assert("memoryTest").equals(sysRequirementTest.getMemory());
    }

    @Test
    void setMemory() {
        sysRequirementTest.setMemory("memoryTest2");
        assert("memoryTest2").equals(sysRequirementTest.getMemory());
    }

    @Test
    void getStorage() {
        assert("storageTest").equals(sysRequirementTest.getStorage());
    }

    @Test
    void setStorage() {
        sysRequirementTest.setStorage("storageTest2");
        assert("storageTest2").equals(sysRequirementTest.getStorage());
    }

    @Test
    void getOs() {
        assert("osTest").equals(sysRequirementTest.getOs());
    }

    @Test
    void setOs() {
        sysRequirementTest.setOs("storageTest2");
        assert("storageTest2").equals(sysRequirementTest.getOs());
    }

    @Test
    void testEquals() {
        SysRequirement sysRequirement = new SysRequirement(1, "cpuTest", "gpuTest",
                "memoryTest", "storageTest", "osTest");
        assertTrue(sysRequirementTest.equals(sysRequirement));
    }
}