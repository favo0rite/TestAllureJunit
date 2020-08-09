package appline.managers;

import appline.pages.ContributionsPage;
import appline.pages.StartPage;

public class ManagerPages {
    private static ManagerPages managerPages;
    StartPage startPage;
    ContributionsPage contributionsPage;



    private ManagerPages() {

    }

    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public ContributionsPage getContributionsPage() {
        if (contributionsPage == null) {
            contributionsPage = new ContributionsPage();
        }
        return contributionsPage;
    }









}
