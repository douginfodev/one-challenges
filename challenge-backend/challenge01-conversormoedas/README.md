## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


public class ExemploGson {
  public static void main(String[] args) {
    String json = """
          {
            "nome" : "João",
            "idade" : 30,
            "email" : "joao@email.com"
          }
        """;

    Gson gson = new Gson();
    Pessoa pessoa = gson.fromJson(json, Pessoa.class);
    System.out.println(pessoa.getIdade());
  }
}

File file = new File("C:\2024\ONE\projetos\one-challenges\challenge-backend\challenge01-conversormoedas");
FileReader reader = new FileReader(file);

int data = reader.read();
while (data != -1) {
    System.out.print((char) data);
    data = reader.read();
}
reader.close();

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDeArquivo {
    public static void main(String[] args) {
        try {
            File arquivo = new File("arquivo.json");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }
}
