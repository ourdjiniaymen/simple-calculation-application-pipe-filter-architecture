package pipeandfilter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pipeandfilter.view.Cmpg;
import pipeandfilter.view.LaunchCmpg;

public class FilterA extends Filter {

    public FilterA(Pipe _dataINPipe, Pipe _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;

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

    void setOperands(String operand1, String operand2, String operation) {
        _dataOUTPipe.dataIN(operand1);
        _dataOUTPipe.dataIN(operand2);
        _dataOUTPipe.dataIN(operation);
    }

    @Override
    synchronized void execute() {

        //lancer l'interface graphique dans un nouveau thread (en parallel)
        LaunchCmpg launchCmpg = new LaunchCmpg();
        launchCmpg.start();
        Cmpg.waitForInterface();

        Cmpg.somme_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int number1 = Integer.parseInt(Cmpg.nombre1.getText());
                    int number2 = Integer.parseInt(Cmpg.nombre2.getText());
                    setOperands(Integer.toString(number1), Integer.toString(number2), "SOMME");
                } catch (NumberFormatException e) {
                    Cmpg.showError("Message d'erreur", "Introduire deux nombres");
                }
            }
        });
        Cmpg.produit_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int number1 = Integer.parseInt(Cmpg.nombre1.getText());
                    int number2 = Integer.parseInt(Cmpg.nombre2.getText());
                    setOperands(Integer.toString(number1), Integer.toString(number2), "PRODUIT");
                } catch (NumberFormatException e) {
                    Cmpg.showError("Message d'erreur", "Introduire deux nombres");
                }
            }
        });
        Cmpg.fact_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int number1 = Integer.parseInt(Cmpg.nombre1.getText());
                    int number2 = Integer.parseInt(Cmpg.nombre2.getText());
                    setOperands(Integer.toString(number1), Integer.toString(number2), "FACT");
                } catch (NumberFormatException e) {
                    Cmpg.showError("Message d'erreur", "Introduire deux nombres");
                }
            }
        });

    }
}
 