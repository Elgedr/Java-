package ee.taltech.iti0202.webbrowser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WebBrowser {

    private String homePage = "google.com";
    private String currentPage = "google.com";
    private int size = 0;
    private String lastPage;

    private List<String> bookMarkedSites = new ArrayList<>();
    private List<String> visitedSites = new ArrayList<>(Arrays.asList("google.com"));
    private Map<String, Integer> visitings = new LinkedHashMap<>();


    /**
     * Goes to homepage.
     */
    public void homePage() {
        if (!currentPage.equals(homePage)) {
            currentPage = homePage;
            visitedSites.add(homePage);
            size++;
        }
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if (size - 1 >= 0) {
            size -= 1;
            lastPage = currentPage;
            currentPage = visitedSites.get(size);
            visitedSites.add(currentPage);
        }

    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if (size + 1 < visitedSites.size()) {
            lastPage = currentPage;
            size += 1;
            currentPage = visitedSites.get(size);
            visitedSites.add(currentPage);
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
            size = visitedSites.size() - 1;
        }
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        if (!bookMarkedSites.contains(currentPage)) {
            bookMarkedSites.add(currentPage);
        }
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
        Map<String, Integer> resulting = new LinkedHashMap<>(); /* ???????????? ??????????????, ?? ???????????? ???????????????? ?????????? ???????????????????? ??
         ?????????? ???? ??????????????, ?????? ?? ?????? ????????????????????????*/
        for (String site: visitedSites) { /*?????????????????? ???? ?????????????? ???????????????????? ????????????*/
            if (!visitings.containsKey(site)) { /*???????? ???????????? ?????????? ?????? ?????? ?? ?????????????? ?? ?????????????? ?? ???? ??????????????????????
            ???? ???????????????? ???? ?????????????????? 1*/
                visitings.put(site, 1);
            } else {
                visitings.put(site, visitings.get(site) + 1); //???????? ?????????? ???????? ?????? ????????, ???? ?????????????????? ?? ?????????????????? +1*/
            }
        }
        for (int i = 0; i < 3; i++) { /* ???? ?????? ???????? ???????????????? ??????3, ???????????????? ?? ???????????? 0,3 */
            int max = 0; /* ???????? ???????????? ???????? ???????????????????? ?????????????????? ?????????????????????????? ?????????? */
            String siteName = "null"; /*???????? ???????????? ???????????????? ?????????? ?? ?????????? ???????????????????????? ??????-?????? ?????????????????? */
            for (String key: visitings.keySet()) { /*???????????????? ?????????? ?????????????? ?? ?????????????? ?? ???? ?????????????????????? */
                if (visitings.get(key) > max) {
                    siteName = key;
                    max = visitings.get(key);
                }
            }
            resulting.put(siteName, max); /* ???????????? ???????? ?? ?????????? ?????????????? ?????????????????????? */
            visitings.remove(siteName); /*???????????? ???? ?????????????? ???????? ????????, ?????????? ?????????? ?????????????????? ?? ???????????????????????? ??????????????????????.
             ???????? ???? ??????????????, ???? ?????????????????? ???????????? ?????? ?? ???????????? ???????????????? */
        }
        resulting.remove("null"); /* ?????? ?????? ?? ?????? ?????????? ???????? ???????????????? ?????????? 1 ?????? 2 ??????????, ?? ???????????????? 2 ????????,
         ???? ???????????? ???????? ?? ?????????????? ?????????? "null"=0. ???? ???????????? ???????????? ???????????? */
        /* ?? ?????? ???????????? ?? ?????????? ???????????? ?? ?????????????? ?????????? ???????????? 1 ???????? "null"=0. ???? ?? ?????????? ?????????????????? .put ???? ????????????????
         ???????????????? ?? ?????????? ???? ?????????? */
//        List<String> finalSites = new ArrayList<>(); //
//        finalSites.addAll(resulting.keySet()); // ?????????????????? ?? ?????????????????? ???????????? ?????????? ?????? ?????????? ???? ?????????????? ?? 3????
//        ???????????? ?????????????????????? ??????????????
        String res = "";
        for (String finalSite : resulting.keySet()) {
            String visitsOrVisit = " visit";
            if (resulting.get(finalSite) > 1) { /* ???????? ???????? ?????????????????? ???????????? 1?????? ????????, ???? ???????????????????? visits. ????????
             ???????????? 1 ??????, ???? visit */
                visitsOrVisit = " visits";
            }
            res += finalSite + " - " + resulting.get(finalSite) + visitsOrVisit + "\n";
        }
        return res;
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
        System.out.println(site.getHistory());
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

//        site.goTo("neti.ee");
//        site.goTo("facebook.com");
//        site.back();
//        site.forward();
//        System.out.println(site.getHistory());
//        System.out.println(site.getTop3VisitedPages());


//        WebBrowser b = new WebBrowser();
//        b.goTo("neti.ee");
//        b.goTo("facebook.com");
//        b.goTo("neti.ee");
//        b.goTo("facebook.com");
//        b.goTo("google.com");
//        b.goTo("delfi.ee");
//        System.out.println(b.getTop3VisitedPages());

//        WebBrowser webBrowser = new WebBrowser();
//
//        webBrowser.back();
//        webBrowser.back();
//        webBrowser.goTo("neti.ee");
//        webBrowser.forward();
//
//        System.out.println(webBrowser.getCurrentUrl());
//

//        webBrowser.goTo("facebook.com"); // facebook
//        webBrowser.setHomePage("facebook.com");
//        webBrowser.goTo("page3.com"); // page 3
//        webBrowser.goTo("page4.com"); // page 4
//        webBrowser.goTo("page5.com"); // page 5
//        webBrowser.goTo("page6.com"); // page 6
//        webBrowser.homePage(); // facebook
//        webBrowser.back(); // page 6
//        webBrowser.back(); // page 5
//        webBrowser.homePage(); // facebook
//        webBrowser.back(); // page 5
//        webBrowser.back(); // page 4
//        webBrowser.back(); // page 3
//        webBrowser.forward(); // page 4
//        webBrowser.forward(); // page 5
//        webBrowser.forward(); // facebook   ???????????????? ?????????????????? ???????????? ???????? facebook
//        System.out.println(webBrowser.currentPage);

//        WebBrowser webBrowser = new WebBrowser();
//
//        for (int i = 1; i <= 100; i++) {
//            webBrowser.goTo("page" + i);
//        }
//        System.out.println(webBrowser.getHistory());
//        for (int i = 0; i < 30; i++) {
//            webBrowser.back();
//        }
//        System.out.println(webBrowser.getHistory());
//        for (int i = 1; i <= 5; i++) {
//            webBrowser.goTo("page" + i);
//        }
//
//        System.out.println(webBrowser.getHistory());
//        for (int i = 0; i < 30; i++) {
//            webBrowser.back();
//        }
//        System.out.println(webBrowser.getCurrentUrl());
    }

}
