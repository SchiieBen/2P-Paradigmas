import java.util.Random;
import java.util.Scanner;


public class PedraPapelTesoura
{
    private Scanner scanner;
    private Random rand;

    int playerChoice; //Escolha do Player
    int computerChoice; // Escolha do Computador
    String computerChoicestring; // Versão string para a saida, facilita a leitura do usuário
    int loop;
    
    
    public static void main(String[] args)
    {
        PedraPapelTesoura jogo = new PedraPapelTesoura(); //Fazendo um constructor, pra diferenciar POO e estruturada :)

        while (true) //Estava no constructor, MAS não deve ser boa prática deixar o while true dentrode um.
        {
            jogo.instrucoes();
            jogo.background();
            jogo.resultado();
        }
    }

    public PedraPapelTesoura() // Esse é o constructor
    {
        scanner = new Scanner(System.in);
        rand = new Random();
        loop = 1;
    }

    private void instrucoes() //Evita repetição
    {
        if (loop == 1)
        {
            System.out.println(("Jogo: Pedra, Papel e Tesoura"));
            System.out.println(("Para jogar digite APENAS o nome da ação. E.g: Pedra"));
        }
        else
        {
            System.out.println(("Para jogar novamente, apenas digitar o nome da ação de novo!"));
        }
        loop +=1; //Aumenta o loop, coloquei pra contagem e evitar repetição das instruções
    }

    private void background()
    {
        String playerChoicestring = scanner.nextLine(); // Lê a Escolha do Player

        //Transforma as Strings das ações para Ints, achei que seria mais interessante, fazer normal seria sem graça
    
        if (playerChoicestring.equalsIgnoreCase("Pedra"))
        {
            playerChoice = 0;
        }
        else if (playerChoicestring.equalsIgnoreCase("Papel")) 
        {
            playerChoice = 1;
        } 
        else if (playerChoicestring.equalsIgnoreCase("Tesoura")) 
        {
            playerChoice = 2;
        } 
        else 
        {
            System.out.println("Escolha inválida.");
            background();
        }
    }  

    private void resultado()
    {
            computerChoice = rand.nextInt(3); //Número aleatório entre [0,1,2]
            if (computerChoice == 0) // Transforma Ints em Strings para o usuário ler e entender
            {
                computerChoicestring = "Pedra";
            }
            else if (computerChoice == 1)
            {
                computerChoicestring = "Papel";
            }
            else
            {
                computerChoicestring = "Tesoura";
            }

            if (playerChoice == computerChoice) 
            {
                System.out.println("Empate!");
            } 
            else if ( 
                (playerChoice == 0 && computerChoice == 2) || 
                (playerChoice == 1 && computerChoice == 0) ||
                (playerChoice == 2 && computerChoice == 1)
            ) 
            {
                System.out.println("O PC escolheu: " + computerChoicestring);
                System.out.println("Você ganhou!");
            }
            else 
            {
                System.out.println("O PC escolheu: " + computerChoicestring);
                System.out.println("Você perdeu ):");
            }
    }
}
