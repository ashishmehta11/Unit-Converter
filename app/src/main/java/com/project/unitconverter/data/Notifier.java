package com.project.unitconverter.data;

import java.util.Observable;

public class Notifier extends Observable {
    public void notifyCursor() {
        notifyObservers();
    }
}
