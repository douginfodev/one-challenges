public class RenderScreen {
    private String currency;
    private String currencyConverted;

    public String getCurrencyConverted() {
        return currencyConverted;
    }

    public void setCurrencyConverted(String currencyConverted) {
        this.currencyConverted = currencyConverted;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void generateMenu() {
        System.out.println("===========================");
        System.out.println("    CONVERSOR DE MOEDAS    ");
        System.out.println("===========================");
        System.out.println("         MENU              ");
        System.out.println("1 = REAL  -> DOLAR");
        System.out.println("2 = REAL  -> EURO");
        System.out.println("3 = DOLAR -> REAL");
        System.out.println("4 = DOLAR -> EURO");
        System.out.println("5 = EURO  -> REAL");
        System.out.println("6 = EURO  -> DOLAR");
        System.out.println("SELECIONE UMA OPÇÃO");
    }

    public void selectConversion(int option) {
        switch (option) {
            case 1:
                this.currency = "REAL (R$)";
                this.currencyConverted = "DOLAR (US$)";
                break;
            case 2:
                this.currency = "REAL (R$)";
                this.currencyConverted = "EURO (€$)";
                break;
            case 3:
                this.currency = "DOLAR (US$)";
                this.currencyConverted = "REAL (R$)";
                break;
            case 4:
                this.currency = "DOLAR (US$)";
                this.currencyConverted = "EURO (€$)";
                break;
            case 5:
                this.currency = "EURO (€$)";
                this.currencyConverted = "REAL (R$)";
                break;
            case 6:
                this.currency = "EURO (€$)";
                this.currencyConverted = "DOLAR (US$)";
                break;
        }
    }

    public void printConversion(double value1, double value2) {
        System.out.println("========================");
        System.out.println("      VALOR = " + value1);
        System.out.println("------------------------");
        System.out.println("    VALOR CONVERTIDO    ");
        System.out.print(this.currency + " = ");
        System.out.printf("%.2f %n", value1);
        System.out.println(" || ");
        System.out.print(this.currencyConverted + " = ");
        System.out.printf("%.2f %n", value2);
        System.out.println("========================");
    }
}
