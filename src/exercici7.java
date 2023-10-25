import java.util.Scanner;

public class exercici7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tipus d'IVA
        final double iva_superreduit = 0.04;
        final double iva_reduit = 0.08;
        final double iva_general = 0.21;

        // Tipus d'enviaments.
        final double const_enviament1 = 3.00;
        final double const_enviament2 = 20.00;
        final double const_enviament3 = 50.00;

        //Posem les variables aqui a dalt ja que les utilitzarem a més d'un cas
        double preuBase = 0.0;
        int numUnitats = 0;
        int categoria = 0;
        double preuFinal = 0.0;

        System.out.println("Programa del magatzem de l'IOC");


        while (true) {
            //Preguntem a l'usuari quina opció vol amb el número indicat que ha de pulsar.
            System.out.println("Siusplau, escull una de les següents opcions:");
            System.out.println("1- Calcular preu final (amb impostos però sense enviament)");
            System.out.println("2- Mostrar quin IVA s'aplica");
            System.out.println("3- Cost de l'enviament");

            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1: // OPCIÓ 1 - Calcular preu final (amb impostos però sense enviament)
                    System.out.println("Introdueix el preu base del producte:");
                    preuBase = scanner.nextDouble();
                    System.out.println("Introdueix el número d'unitats:");
                    numUnitats = scanner.nextInt();
                    do {
                        System.out.println("Introdueix la categoria: 1 (Medicaments), 2 (Farines), 3 (Medicaments veterinaris), 4 (Aigues), 5 (Cosmètics), 6 (Begudes alcohòliques):");
                        categoria = scanner.nextInt();
                        if (categoria < 1 || categoria > 6) {
                            // Posem un condicional per si l'usuari posa una categoria erronia, dongui avis i torni a preguntar
                            System.out.println("AQUESTA CATEGORIA NO EXISTEIX!");
                        }
                    } while (categoria < 1 || categoria > 6);

                    switch (categoria) {
                        //Per a les categories 1 i 2, s'aplica un IVA superreduït (4%)
                        case 1:
                        case 2:
                            preuFinal = preuBase * numUnitats * (1 + iva_superreduit);
                            break;
                        //Per a les categories 3 i 4, s'aplica un IVA reduït (8%)
                        case 3:
                        case 4:
                            preuFinal = preuBase * numUnitats * (1 + iva_reduit);
                            break;
                        //Per a la resta de categories, s'aplica l'IVA general (21%)
                        case 5:
                        case 6:
                            preuFinal = preuBase * numUnitats * (1 + iva_general);
                            break;
                    }

                    System.out.println("El preu final amb impostos és: " + preuFinal + "€");
                    break;

                case 2: // OPCIÓ 2 - Mostrar quin IVA s'aplica
                    System.out.println("Introdueix la categoria: 1 (Medicaments), 2 (Farines), 3 (Medicaments veterinaris), 4 (Aigues), 5 (Cosmètics), 6 (Begudes alcohòliques):");
                    int categoriaIVA = scanner.nextInt();

                    switch (categoriaIVA) {
                        case 1:
                        case 2:
                            //Per a les categories 1 i 2, s'aplica un IVA superreduït (4%)
                            System.out.println("S'aplica un IVA superreduït (4%)");
                            break;
                        case 3:
                        case 4:
                            //Per a les categories 3 i 4, s'aplica un IVA reduït (8%)
                            System.out.println("S'aplica un IVA reduït (8%)");
                            break;
                        default:
                            //Per a la resta de categories, s'aplica l'IVA general (21%)
                            System.out.println("S'aplica un IVA general (21%)");
                            break;
                    }
                    break;

                case 3: // OPCIÓ 3 - Cost de l'enviament
                    System.out.println("Introdueix el preu base del producte:");
                    preuBase = scanner.nextDouble();
                    System.out.println("Introdueix el número d'unitats:");
                    numUnitats = scanner.nextInt();
                    do {
                        System.out.println("Introdueix la categoria: 1 (Medicaments), 2 (Farines), 3 (Medicaments veterinaris), 4 (Aigues), 5 (Cosmètics), 6 (Begudes alcohòliques):");
                        categoria = scanner.nextInt();
                        if (categoria < 1 || categoria > 6) {
                            // Posem un condicional per si l'usuari posa una categoria erronia, dongui avis i torni a preguntar
                            System.out.println("AQUESTA CATEGORIA NO EXISTEIX!");
                        }
                    } while (categoria < 1 || categoria > 6);

                    switch (categoria) {
                        //Per a les categories 1 i 2, s'aplica un IVA superreduït (4%)
                        case 1:
                        case 2:
                            preuFinal = preuBase * numUnitats * (1 + iva_superreduit);
                            break;
                        //Per a les categories 3 i 4, s'aplica un IVA reduït (8%)
                        case 3:
                        case 4:
                            preuFinal = preuBase * numUnitats * (1 + iva_reduit);
                            break;
                        //Per a la resta de categories, s'aplica l'IVA general (21%)
                        case 5:
                        case 6:
                            preuFinal = preuBase * numUnitats * (1 + iva_general);
                            break;
                    }

                    double costEnviament = 0;

                    if (preuFinal <= 100) { //si es igual o més petit de 100 el cost serà const_enviament1
                        costEnviament = const_enviament1;
                    } else if (preuFinal <= 500) { //si es igual o més petit de 500 el cost serà const_enviament2
                        costEnviament = const_enviament2;
                    } else { // més de 500 el cost serà const_enviament3
                        costEnviament = const_enviament3;
                    }

                    System.out.println("El cost de l'enviament és: " + costEnviament + "€");
                    break;

                default:
                    //si l'usuari per error pulsa un número diferent a 1, 2 o 3 saltarà aquest missatge i tornarà a preguntar
                    System.out.println("Opció no vàlida. Si us plau, trieu una opció vàlida.");
                    break;
            }
        }
    }
}
