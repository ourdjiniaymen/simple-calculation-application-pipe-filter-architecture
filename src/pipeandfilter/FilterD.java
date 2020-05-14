package pipeandfilter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pipeandfilter.file.File;
import pipeandfilter.view.Cmpg;
import pipeandfilter.view.Trace;

public class FilterD extends Filter {

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;

    public FilterD(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }

    public String getData() {
        return _dataINPipe.dataOUT();
    }

    public void sendData(String tempData) {
        _dataOUTPipe.dataIN(tempData);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        execute();
    }

    @Override
    synchronized void execute() {
        while (true) {
            File file = new File("trace.txt");
            String operand1 = _dataINPipe.dataOUT();
            String operand2 = _dataINPipe.dataOUT();
            String operation = _dataINPipe.dataOUT();
            String resultat = _dataINPipe.dataOUT();
            String trace = "opérand1 = " + operand1 + ", opérand2 = " + operand2 + ", opération = " + operation + ", résultat = " + resultat;
            file.writeLine(trace);
            Cmpg.trace_btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Trace.trace.setText(file.readFile());
                    Cmpg.showTrace();
                }
            });
        }
    }
}
 