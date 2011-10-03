package com.lissenberg.blog.services;

import com.lissenberg.blog.util.Timer;
import junit.framework.TestCase;
import org.junit.Test;

public class SecurityServiceTest extends TestCase {
    @Test
    public void testCreateHash() throws Exception {
        SecurityService securityService = new SecurityService();
        Timer timer = new Timer();
        String hash1 = securityService.createHash("My secret password!");
        System.out.println("Hashing took: " + timer.getDuration() + " millis");
        String hash2 = securityService.createHash("My secret password!");
        String hash3 = securityService.createHash("my secret password!");
        assertEquals(hash1, hash2);
        assertNotSame(hash1, hash3);
    }
}
