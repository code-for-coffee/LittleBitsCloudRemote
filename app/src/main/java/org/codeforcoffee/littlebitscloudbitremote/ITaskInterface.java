package org.codeforcoffee.littlebitscloudbitremote;

/**
 * Created by codeforcoffee on 8/8/16.
 */
public interface ITaskInterface {

    void onTaskComplete(Object obj);
    void onError(Object obj);

}