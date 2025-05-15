public class Main {

    public static void main(String[] args) {
        Printer basicPrinter = new PrinterImpl();
        basicPrinter.print();

        System.out.println();

        MultifunctionalPrinter multifunctionalPrinter = new MultifunctionalPrinterImpl();
        multifunctionalPrinter.print();
        multifunctionalPrinter.scan();
        multifunctionalPrinter.fax();
    }
}
