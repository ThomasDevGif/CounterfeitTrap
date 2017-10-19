package com.example.thomastournoux.counterfeittrap.application;

import android.app.Application;

import com.example.thomastournoux.counterfeittrap.object.Rolex;
import com.example.thomastournoux.counterfeittrap.object.Trade;

public class UserApplication extends Application {

    private static Rolex selectedRolex;
    private static Trade selectedTrade;

    public static Rolex getSelectedRolex() {
        return selectedRolex;
    }

    public static void setSelectedRolex(Rolex selectedRolex) {
        UserApplication.selectedRolex = selectedRolex;
    }

    public static Trade getSelectedTrade() {
        return selectedTrade;
    }

    public static void setSelectedTrade(Trade selectedTrade) {
        UserApplication.selectedTrade = selectedTrade;
    }
}
