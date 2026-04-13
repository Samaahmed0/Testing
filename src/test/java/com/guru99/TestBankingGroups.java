package com.guru99;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestBankingGroups {

    // ── Lifecycle hooks that run around each GROUP ──────────────────────

    // Runs once just before the first test in the "Smoke" group executes
    @BeforeGroups("Smoke")
    public void beforeSmoke() {
        System.out.println("===== Starting SMOKE group =====");
    }

    // Runs once after the last test in the "Smoke" group finishes
    @AfterGroups("Smoke")
    public void afterSmoke() {
        System.out.println("===== SMOKE group finished =====");
    }

    @BeforeGroups("Regression")
    public void beforeRegression() {
        System.out.println("===== Starting REGRESSION group =====");
    }

    @AfterGroups("Regression")
    public void afterRegression() {
        System.out.println("===== REGRESSION group finished =====");
    }

    // ── SMOKE group — quick health-check tests ──────────────────────────

    @Test(groups = {"Smoke"})
    public void testHomepageLoads() {
        System.out.println("[Smoke] Homepage loads OK");
    }

    @Test(groups = {"Smoke"})
    public void testLoginPageVisible() {
        System.out.println("[Smoke] Login page is visible");
    }

    @Test(groups = {"Smoke"})
    public void testFooterLinks() {
        System.out.println("[Smoke] Footer links are present");
    }

    // ── REGRESSION group — deeper functional tests ──────────────────────

    @Test(groups = {"Regression"})
    public void testLoginValidCreds() {
        System.out.println("[Regression] Login with valid credentials passed");
    }

    @Test(groups = {"Regression"})
    public void testLoginInvalidCreds() {
        System.out.println("[Regression] Login with invalid credentials correctly rejected");
    }

    @Test(groups = {"Regression"})
    public void testPasswordReset() {
        System.out.println("[Regression] Password reset flow passed");
    }

    @Test(groups = {"Regression"})
    public void testAccountBalance() {
        System.out.println("[Regression] Account balance displayed correctly");
    }
}