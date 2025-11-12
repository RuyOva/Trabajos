import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class pagos {


    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {

// En este primer apartado irá el menú de inicio, para el que se tendrá que responder obligatoriamente con un número del 1 al 4


        while (true) {
            System.out.println("===============================");
            System.out.println("SISTEMA DE PAGO RESTAURANTE");
            System.out.println("===============================");
            System.out.println("1. Pago en efectivo");
            System.out.println("2. Pago con tarjeta");
            System.out.println("3. Pago por transferencia");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = sc.nextLine();
//Aquí se decide que dirección toma el programa
            switch (opcion) {
                case "1":
                    efectivo();
                    break;
                case "2":
                    tarjeta();
                    break;
                case "3":
                    efectivo();
                    break;
                case "4":
                    fin();
                    break;
                default:
                    System.out.println("Introduce un número del 1 al 4");
                    continue;
            }
            Codigo();

            System.out.println("¿Quieres seguir usando el programa?");
            System.out.println("1. Si");
            System.out.println("2. No");

            sc.nextLine();
            String repetir = sc.nextLine();
            
            switch (repetir) {
                case "1":
                    main(args);
                    break;
                case "2":
                    fin();
                    break;
                default:
                    System.out.println("Introduce una opción válida (1 o 2)");
            }
        }
    }
//A partir de aquí, están todas las funciones que se salen del guión principal del programa


// Método de pago en Efectivo.
    private static void efectivo() throws InterruptedException{

        System.out.println("has seleccionado pago en efectivo...");
        Thread.sleep(1000);
        
        double importe = 0;
        double entrega = 0;
        System.out.println("Introduce el importe a pagar:");
        importe = sc.nextDouble();
        
        while (true) { 
            
            System.out.println("Has seleccionado EFECTIVO");
            Thread.sleep(1500);


            System.out.println("Introduce la cantidad entregada en efectivo: ");
            entrega = sc.nextDouble();

            if(importe == entrega){
                System.out.println("Cantidad entregada correctamente, no hay cambio");
            }
            else if(importe > entrega){
                System.out.println("Cantidad insuficiente, introduzca la cantidad necesaria");
                continue;
            }
            else{
                System.out.println("Has introducido una cantidad superior al importe, se te devolverá el cambio...");
                Thread.sleep(500);
                System.out.println("Procesando...");
                Thread.sleep(1000);

                double resto = entrega - importe;

                // Billetes de 100€
                int B100 = 0;
                while (resto >= 100) {
                    resto -= 100;
                    B100++;
                }
                if (B100 > 0) System.out.println(B100 + " billete(s) de 100€");

                // Billetes de 50€
                int B50 = 0;
                while (resto >= 50) {
                    resto -= 50;
                    B50++;
                }
                if (B50 > 0) System.out.println(B50 + " billete(s) de 50€");

                // Billetes de 20€
                int B20 = 0;
                while (resto >= 20) {
                    resto -= 20;
                    B20++;
                }
                if (B20 > 0) System.out.println(B20 + " billete(s) de 20€");

                // Billetes de 10€
                int B10 = 0;
                while (resto >= 10) {
                    resto -= 10;
                    B10++;
                }
                if (B10 > 0) System.out.println(B10 + " billete(s) de 10€");

                // Billetes de 5€
                int B5 = 0;
                while (resto >= 5) {
                    resto -= 5;
                    B5++;
                }
                if (B5 > 0) System.out.println(B5 + " billete(s) de 5€");

                // Monedas de 1€
                int M1 = 0;
                while (resto >= 1) {
                    resto -= 1;
                    M1++;
                }
                if (M1 > 0) System.out.println(M1 + " moneda(s) de 1€");

                // Monedas de 0.50€
                int M50 = 0;
                while (resto >= 0.5) {
                    resto -= 0.5;
                    M50++;
                }
                if (M50 > 0) System.out.println(M50 + " moneda(s) de 0,50€");

                // Monedas de 0.20€
                int M20 = 0;
                while (resto >= 0.2) {
                    resto -= 0.2;
                    M20++;
                }
                if (M20 > 0) System.out.println(M20 + " moneda(s) de 0,20€");

                // Monedas de 0.10€
                int M10 = 0;
                while (resto >= 0.1) {
                    resto -= 0.1;
                    M10++;
                }
                if (M10 > 0) System.out.println(M10 + " moneda(s) de 0,10€");

                // Monedas de 0.05€
                int M05 = 0;
                while (resto >= 0.05) {
                    resto -= 0.05;
                    M05++;
                }
                if (M05 > 0) System.out.println(M05 + " moneda(s) de 0,05€");

                // Monedas de 0.02€
                int M02 = 0;
                while (resto >= 0.02) {
                    resto -= 0.02;
                    M02++;
                }
                if (M02 > 0) System.out.println(M02 + " moneda(s) de 0,02€");

                // Monedas de 0.01€
                int M01 = 0;
                while (resto >= 0.009) { // margen para errores de coma flotante (lo vi en google)
                    resto -= 0.01;
                    M01++;
                }
                if (M01 > 0) System.out.println(M01 + " moneda(s) de 0,01€");
            }
            break;
        }   
    }
// Método de pago por Tarjeta.
    private static void tarjeta() throws InterruptedException{
        System.out.print("Has seleccionado pago en tarjeta");
        Thread.sleep(1500);

        while (true) { 

            System.out.print("Introduce tu número de tarjeta: \n\n");

            String a = sc.nextLine();
            String numero = a.trim();

            try {
                Integer.parseInt(numero);
                break;
            } catch (NumberFormatException e) {
                fallo();
            }
            
            int tarjeta = numero.length();

        char PN = numero.charAt(0);
        String PNT = Integer.toString(PN);
        System.out.print(PNT);

        String tipo = "";

        switch (tarjeta) {
            case 15:
                tipo = "American Express";
                break;
            //case 16:
            //    if(PN = 4){
            //        tipo = "Visa";
            //    }
            //    else if (PN = 5") {
            //        
            //    }
            //    break;

            default:
                fallo();
        }
    }
}

// Función de fallo
    private static void fallo() throws InterruptedException  {
        System.out.println("Número no válido.");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(500);
        tarjeta();
    }

// Esta función generará un código aleatorio cada vez que la llame.
    private static void Codigo(){
        int longitud = 8; // número de caracteres del código
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < longitud; i++) {
            int indice = rnd.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }
        System.out.println("Código de operación: " + codigo);
        String fecha = LocalDateTime.now().format(dtf);
        System.out.println("Fecha y hora: " + fecha);
    }


//Esta función escribe el mensasje de finalización y finaliza el programa.    
    private static void fin(){
        System.out.println("Operación finalizada");
        System.exit(0);
    }
}   
    