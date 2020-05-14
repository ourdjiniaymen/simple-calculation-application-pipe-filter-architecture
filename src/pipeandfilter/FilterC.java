package pipeandfilter;

import pipeandfilter.view.Cmpg;

public class FilterC extends Filter {

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;

    public FilterC(Pipe _dataINPipe, Pipe _dataOUTPipe) {
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
			String number1 = _dataINPipe.dataOUT();
			String number2 = _dataINPipe.dataOUT();
			String operation = _dataINPipe.dataOUT();
        	String resultat = _dataINPipe.dataOUT();
        	Cmpg.resultat.setText(resultat);
        	_dataOUTPipe.dataIN(number1);
            _dataOUTPipe.dataIN(number2);
            _dataOUTPipe.dataIN(operation);
            _dataOUTPipe.dataIN(resultat);

        }

    }
}
 