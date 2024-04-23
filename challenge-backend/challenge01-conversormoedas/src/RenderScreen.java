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
        System.out.println("===============================");
        System.out.println("      CONVERSOR DE MOEDAS      ");
        System.out.println("===============================");
        System.out.println("            MENU               ");
        System.out.println("1 = REAL  -> DOLAR");
        System.out.println("2 = REAL  -> EURO");
        System.out.println("3 = DOLAR -> EURO");
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
                this.currencyConverted = "EURO (E$)";
                break;
            case 3:
                this.currency = "DOLAR (US$)"; 
                this.currencyConverted = "EURO (E$)";
                break;    
        }
    }

    public void printConversion(double value1, double value2) {
        System.out.println("===============================");
        System.out.println("      VALOR = "+value1);
        System.out.println("-------------------------------");
        System.out.println("      VALOR CONVERTIDO         ");
        System.out.print(this.currency + value1 + " --> ");
        System.out.println(this.currencyConverted + value2);
        System.out.println("===============================");
    }
}
