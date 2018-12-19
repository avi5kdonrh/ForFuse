package org.mypackage;

public class TaskImplementation implements TaskInterface{

    @Override
    public void activate() {
        Thread thread = new Thread(new HttpTask());
        thread.start();
    }

}