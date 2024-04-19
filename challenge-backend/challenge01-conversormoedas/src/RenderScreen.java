public class RenderScreen {
    private int opcoes; 

    //CONSTRUCTOR
    public RenderScreen(int opcoes){
       this.opcoes = opcoes; 
    }

    public int getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(int opcoes) {
        this.opcoes = opcoes;
    }

    public void generateMenu(){
        int totalOpcoes = getOpcoes();

        System.out.println("===============================");
        System.out.println("      CONVERSOR DE MOEDAS      ");
        System.out.println("===============================");
        System.out.println(" SELECIONE UMA OPÇÃO");
        for(int numopcoes = 1; numopcoes <= totalOpcoes; numopcoes++){
            System.out.println("1 = REAL -> DOLAR");
            System.out.println("2 = REAL -> EURO");
        }
    }
}
