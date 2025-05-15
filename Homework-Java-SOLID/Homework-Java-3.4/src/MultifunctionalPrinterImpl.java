public class MultifunctionalPrinterImpl implements MultifunctionalPrinter {

    @Override
    public void fax() {
        System.out.println("Faxing...");
    }

    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}
