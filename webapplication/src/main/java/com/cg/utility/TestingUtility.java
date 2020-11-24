package com.cg.utility;


public class TestingUtility {
	@Before
    public void prepare() {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT); 
        setBaseUrl("http://localhost:8181/PLP_29Feb_final");
    }
 
    @Test
    public void testLoginPage() {
        beginAt("index.jsp"); 
        assertTitleEquals("Login");
        //assertLinkPresent("home");
        //clickLink("home");
        //assertTitleEquals("Home");
    }
     
   /* @Test
    public void testHomePage() {
        beginAt("home.jsp"); 
        assertTitleEquals("Home");
        assertLinkPresent("login");
        clickLink("login");
        assertTitleEquals("Login");
    }*/
}
