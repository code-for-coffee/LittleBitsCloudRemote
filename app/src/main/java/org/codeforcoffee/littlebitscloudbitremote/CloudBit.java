package org.codeforcoffee.littlebitscloudbitremote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codeforcoffee on 8/8/16.
 */
public class CloudBit {

    public CloudBit() {
    }

    public String label;
    public String deviceId;
    public List<Subscriber> subscribers = new ArrayList<>();
    public int userId;
    public boolean isConnected;
    public int inputIntervalMs;

    public CloudBit(String label, String id, int userId, boolean isConnected, int inputIntervalMs) {
        this.label = label;
        this.deviceId = id;
        this.userId = userId;
        this.isConnected = isConnected;
        this.inputIntervalMs = inputIntervalMs;
    }
}
