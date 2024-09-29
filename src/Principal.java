import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Menu menu = new Menu();
            String[] pairConversion = new String[2];
            while (true) {
                int flag = 0;
                while (flag == 0) {
                    int option = 0;
                    System.out.print(menu.getShow());
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            pairConversion = new String[] { "USD", "ARS" };
                            flag++;
                            break;
                        case 2:
                            pairConversion = new String[] { "ARS", "USD" };
                            flag++;
                            break;
                        case 3:
                            pairConversion = new String[] { "USD", "BRL" };
                            flag++;
                            break;
                        case 4:
                            pairConversion = new String[] { "BRL", "USD" };
                            flag++;
                            break;
                        case 5:
                            pairConversion = new String[] { "USD", "COP" };
                            flag++;
                            break;
                        case 6:
                            pairConversion = new String[] { "COP", "USD" };
                            flag++;
                            break;
                        case 7:
                            System.out.println("Saliendo del programa, gracias por utilizar nuestro servicio.");
                            return;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                }
                System.out.println("Ingrese el valor que desee convertir:");
                float amount = input.nextFloat();
                Conversor conversor = new Conversor(pairConversion, amount);
                conversor.obtenerDivisa();
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Valor inválido, reinicie el programa.");
        }
    }
}