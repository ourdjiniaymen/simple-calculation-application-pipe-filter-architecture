package pipeandfilter.view;

public class LaunchCmpg extends Thread {
    @Override
    public void run() {
       javafx.application.Application.launch(Cmpg.class);
    }
}
