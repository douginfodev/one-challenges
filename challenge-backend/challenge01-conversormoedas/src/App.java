import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
// import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class App {
    public static void main(String[] args) throws Exception , InterruptedException{
    
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        RenderScreen renderscreen = new RenderScreen();
        char novaConversao = 'S';
        String json = "";
        //double currency = 0.0;
        // double value = 0.0;
        // String json = "{base_code:USD,conversion_rates:{USD:5.50,AED:3.6725,AFN:71.9438}}";
        // System.out.println(String.valueOf(extractJson(json))); 
        // System.out.println(String.valueOf(convertCurrency('/',5.50,extractJson(json)))); 
        while (novaConversao == 'S') {
            novaConversao = 'N';
            renderscreen.generateMenu();
            int opcaoSelecionada = scanner.nextInt();
            
            if (opcaoSelecionada > 0 && opcaoSelecionada < 3) {
                System.out.println("DIGITE O VALOR A CONVERTER");
                double value = scanner.nextDouble();

                 //  Buscar Cotação
                try{
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create("https://v6.exchangerate-api.com/v6/24be77b499ee270705b19218/latest/USD"))
                // .timeout(Duration.ofMinutes(2))
                // .header("Content-Type", "application/json")
                // .POST(BodyPublishers.ofFile(Paths.get("file.json")))
                 .build();
              
                 HttpResponse<String> response = client
                  .send(request,HttpResponse.BodyHandlers.ofString());
                
                 json = response.body(); 
                //  System.out.println(json);
                } catch (Exception e) {
                    System.out.println("Cotação indisponível :"+ e.getMessage());
                }

                double currency = convertCurrency(1,value,extractJson(json)); 
                System.out.println("Externo= "+ currency);
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
        
        System.out.println("DIGITADO = "+ value1);
        System.out.println("JSON = "+ value2);
        
        return valueConverted;
    }

    public static double extractJson(String json) throws Exception {
        double value = 0.0;
     try{
        String[] listaValores = json.split("rates");
        String[] currency = listaValores[1].split(",");
        int auxStrLength = currency[20].length();
        String auxStr = currency[20].substring(9,auxStrLength);
        value = Double.parseDouble(auxStr);
        return value;
    } catch (Exception e) {
        System.out.println("Erro na Cotação"+ e.getMessage());
    }
       return value;
    }
}

