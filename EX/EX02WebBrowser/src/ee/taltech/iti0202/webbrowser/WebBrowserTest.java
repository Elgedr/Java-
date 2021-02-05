package ee.taltech.iti0202.webbrowser;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WebBrowserTest {
    public static final int THIRTY = 30;
    WebBrowser webBrowser = new WebBrowser();
    /**Test1*/
    @org.junit.Test
    public void homePage() {

    }


    /**Test2*/
    @org.junit.Test
    public void back() {


    }
    /**Test3*/
    @org.junit.Test
    public void forward() {
    }


    /**Test4*/
    @org.junit.Test
    public void goTo() {
    }


    /**Test5*/
    @org.junit.Test
    public void addAsBookmark() {
    }


    /**Test6*/
    @org.junit.Test
    public void removeBookmark() {
    }


    /**Test7*/
    @Test
    public void getBookmarks() {

        webBrowser.setHomePage("neti.ee");
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("google.com");
        webBrowser.back();
        webBrowser.addAsBookmark();
        webBrowser.forward();
        webBrowser.homePage();
        webBrowser.addAsBookmark();
        List<String> actual = webBrowser.getBookmarks();
        List<String> expectedd = new ArrayList<>(Arrays.asList("facebook.com", "neti.ee"));
        Assert.assertArrayEquals(new List[]{expectedd}, new List[]{actual});
    }


    /**Test8*/
    @org.junit.Test
    public void setHomePage() {
//        webBrowser.setHomePage("neti.ee");
//        String expectedAnswer = "neti.ee" + "\n";
//        String actualResult = webBrowser.homePage();
    }


    /**Test9*/
    @org.junit.Test
    public void getTop3VisitedPages() {
        String expectedAnswer = "google.com - 1 visit" + "\n";
        String actualResult = webBrowser.getTop3VisitedPages();
        Assert.assertEquals(expectedAnswer, actualResult);
    }


    /**Test10*/
    @org.junit.Test
    public void getHistory() {
        webBrowser.setHomePage("neti.ee");
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("google.com");
        webBrowser.back();
        webBrowser.addAsBookmark();
        webBrowser.forward();
        webBrowser.homePage();
        webBrowser.addAsBookmark();
        List<String> actual = webBrowser.getHistory();
        List<String> expectedd = new ArrayList<>(Arrays.asList("google.com", "facebook.com", "google.com",
                "facebook.com", "google.com", "neti.ee"));
        Assert.assertArrayEquals(new List[]{expectedd}, new List[]{actual});
    }


    /**Test11*/
    @org.junit.Test
    public void getCurrentUrl() {
        String expectedAnswer = "page41";

        for (int i = 1; i <= 100; i++) {
            webBrowser.goTo("page" + i);
        }

        for (int i = 0; i < THIRTY; i++) {
            webBrowser.back();
        }

        webBrowser.homePage(); // google.com

        for (int i = 0; i < THIRTY; i++) {
            webBrowser.back();
        }

        String actualResult = webBrowser.getCurrentUrl(); // page41
        Assert.assertEquals(expectedAnswer, actualResult);
    }
}
