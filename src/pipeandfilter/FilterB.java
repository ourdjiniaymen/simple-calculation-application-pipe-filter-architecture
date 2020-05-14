package pipeandfilter;

public class FilterB extends Filter {

    Pipe _dataINPipe;
    Pipe _dataOUTPipe;

    public FilterB(Pipe _dataINPipe, Pipe _dataOUTPipe) {
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
            int number1 = Integer.parseInt(_dataINPipe.dataOUT());
            int number2 = Integer.parseInt(_dataINPipe.dataOUT());
            String operation = _dataINPipe.dataOUT();
            String res = null;
            switch (operation) {
                case "SOMME":
                    res = Integer.toString(number1 + number2);
                    break;
                case "PRODUIT":
                    res = Integer.toString(number1 * number2);
                    break;
                case "FACT":
                    res = Integer.toString(factoriel(number1));
                    break;
                default:
                    System.out.println("erreur");
            }
            _dataOUTPipe.dataIN(Integer.toString(number1));
            _dataOUTPipe.dataIN(Integer.toString(number2));
            _dataOUTPipe.dataIN(operation);
            _dataOUTPipe.dataIN(res);

        }
    }

    private int factoriel(int n) {
        return n > 1 ? n * factoriel(n - 1) : 1;
    }
}
 