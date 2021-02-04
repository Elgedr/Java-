package ee.taltech.iti0202.webbrowser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WebBrowser {

    private String homePage;
    private String currentPage = "google.com";
    private String lastPage = "nothing";
    private String forwarded;

    private List<String> bookMarkedSites = new ArrayList<>();
    private List<String> visitedSites = new ArrayList<>(Arrays.asList("google.com"));
    private Map<String, Integer> visitings = new HashMap<>();

    private Boolean back = false;

    /**
     * Goes to homepage.
     */
    public void homePage() {
        currentPage = homePage;
        if (!currentPage.equals(lastPage)) {
            visitedSites.add(homePage);
        }
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (!lastPage.equals("nothing")) {
            back = true;
            visitedSites.add(lastPage);
            forwarded = currentPage;
            currentPage = lastPage;
        }

    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (back) {
            lastPage = currentPage;
            currentPage = forwarded;
            visitedSites.add(forwarded);
            back = false;
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        if (!currentPage.equals(url)) {
            lastPage = currentPage;
            currentPage = url;
            visitedSites.add(url);
        }
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        bookMarkedSites.add(currentPage);
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        bookMarkedSites.remove(bookmark);
    }

    /**
     *
     * @return List of book marked sites.
     */
    public List<String> getBookmarks() {
        return bookMarkedSites;
    }

    /**
     *
     * @param homePage homepage name to set.
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        Map<String, Integer> resulting = new LinkedHashMap<>();
        for (String site: visitedSites) {
            if (!visitings.containsKey(site)) {
                visitings.put(site, 1);
            } else {
                visitings.put(site, visitings.get(site) + 1);
            }
        }
        for (int i = 0; i < 3; i++) {
            int max = 0;
            String siteName = "";
            for (String key: visitings.keySet()) {
                if (visitings.get(key) > max) {
                    siteName = key;
                    max = visitings.get(key);
                }
            }
            resulting.put(siteName, max);
            visitings.remove(siteName);
        }
        System.out.println(visitedSites);
        System.out.println(resulting);
        List<String> finalSites = new ArrayList<>();
        for (String sites: resulting.keySet()) {
            finalSites.add(sites);
        }
        return finalSites.get(0) + " - " + resulting.get(finalSites.get(0)) + " visits" + "\n"
                + finalSites.get(1) + " - " + resulting.get(finalSites.get(1)) + " visits" + "\n" + finalSites.get(2)
                + " - " + resulting.get(finalSites.get(2)) + " visits" + "\n";
    }

    /**
     * Returns a list of all visited pages.
     *
     * Not to be confused with pages in your back-history.
     *
     * For example, if you visit "facebook.com" and hit back(),
     * then the whole history would be: ["google.com", "facebook.com", "google.com"]
     * @return list of all visited pages
     */
    public List<String> getHistory() {
        return visitedSites;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        return currentPage;
    }

    /**
     * Run tests.
     * @param args args
     */
    public static void main(String[] args) {
        WebBrowser site = new WebBrowser();
//        System.out.println(site.getCurrentUrl());
//        site.setHomePage("neti.ee");
//        site.goTo("facebook.com");
//        System.out.println(site.getCurrentUrl());
//        site.goTo("google.com");
//        System.out.println(site.currentPage);
//        site.back();
//        System.out.println(site.getCurrentUrl());
//        site.addAsBookmark();
//        site.forward();
//        System.out.println(site.getCurrentUrl());
//        site.homePage();
//        System.out.println(site.getCurrentUrl());
//        site.addAsBookmark();
//        System.out.println(site.getBookmarks());
//        System.out.println(site.getHistory());

//        site.setHomePage("neti.ee");
//        site.goTo("facebook.com");
//        site.forward();
//        site.forward();
//        System.out.println(site.getHistory());

//        site.getCurrentUrl();
//        site.setHomePage("neti.ee");
//        site.goTo("facebook.com");
//        site.back();
//        site.back();
//        System.out.println(site.getHistory());

        site.goTo("neti.ee");
        site.goTo("facebook.com");
        site.back();
        site.forward();
        System.out.println(site.getHistory());
        System.out.println(site.getTop3VisitedPages());
    }

}
