import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class App {
    public static void main(String[] args) throws Exception , InterruptedException{
    
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        RenderScreen renderscreen = new RenderScreen();
        char novaConversao = 'S';
        String json = "";
        int[] actualCurrency = {0,146,42,20,42,20,146}; 
       
        while (novaConversao == 'S') {
            novaConversao = 'N';
            renderscreen.generateMenu();
            int opcaoSelecionada = scanner.nextInt();
            
            if (opcaoSelecionada > 0 && opcaoSelecionada < 7) {
                System.out.println("DIGITE O VALOR A CONVERTER");
                double value = scanner.nextDouble();

                 //  Buscar Cotação
                try{
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create("https://v6.exchangerate-api.com/v6/24be77b499ee270705b19218/latest/"+currentCurrency(opcaoSelecionada)))
                 .build();
              
                 HttpResponse<String> response = client
                  .send(request,HttpResponse.BodyHandlers.ofString());
                
                 json = response.body(); 
                } catch (Exception e) {
                    System.out.println("Cotação indisponível :"+ e.getMessage());
                }

                double currency = convertCurrency(0,value,extractJson(json,actualCurrency[opcaoSelecionada])); 
                renderscreen.selectConversion(opcaoSelecionada);
                renderscreen.printConversion(value, currency);

            } else {
                System.out.println("ERROR: OPÇÃO INCORRETA");
            }

            System.out.println("DESEJA FAZER OUTRA CONVERSÃO?");
            String op = scanner.next();
            char aux = op.charAt(0);
            novaConversao = Character.toUpperCase(aux);
        }

        System.out.println("*******************************************");
        System.out.println("OBRIGADO POR UTILIZAR O CONVERSOR DE MOEDAS");
        System.out.println("*******************************************");
    }

    public static double convertCurrency(int operation, double value1, double value2){
        double valueConverted = 0;
        
        if(operation == 0){
           valueConverted = (value1 * value2);
        }
        else
        {
           valueConverted = (value1 / value2);
        }  
     

        System.out.println("Value 2 ="+value2);
        return valueConverted;
    }

    public static double extractJson(String json,int posicao) throws Exception {
        double value = 0.0;
     try{
        String[] listaValores = json.split("rates");
        String[] currency = listaValores[1].split(",");
        int auxStrLength = currency[posicao].length();
        String auxStr = currency[posicao].substring(9,auxStrLength);
        value = Double.parseDouble(auxStr);
        return value;
    } catch (Exception e) {
        System.out.println("Erro na Cotação"+ e.getMessage());
    }
       return value;
    }

    public static String currentCurrency(int option){
        String currency = "";

        switch (option) {
            case 1:
            case 2:
                currency = "BRL";
                break;
            case 3:
            case 4:
                currency = "USD";     
                break;
           case  5:
           case  6:
                currency = "EUR";     
                break;
           default:
                break;
        }

        return currency;
    }
}

