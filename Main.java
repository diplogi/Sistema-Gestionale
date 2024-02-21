/* ### GESTIONE DI UNO STUDIO COMMERCIALISTICO ### */

/* Chiedere all'utente quale operazione vuole eseguire
- (A)ggiunta di un cliente
- nome, cognome, professione
- (R)imozione di un cliente
- quale cliente vuole rimuovere? Inserisce nome cliente da rimuovere
- (Q)uit
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> listaNomi = new ArrayList<>();
        List<String> listaCognomi = new ArrayList<>();
        List<String> listaProfessioni = new ArrayList<>();
        List<Integer> listaID = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String sceltaMenu = " ";
        int id = 0;
        int idRimosso = 0;

        while (!sceltaMenu.equals("Q")) {
            StampaMenu();
            sceltaMenu = scanner.nextLine().toUpperCase();


    /*AGGIUNTA*/
            if (sceltaMenu.equals("A"))
                id = AggiungiCliente(id, listaNomi, listaCognomi, listaProfessioni, listaID);


    /*STAMPA*/
            else if (sceltaMenu.equals("S"))
                StampaClienti(id, listaNomi, listaCognomi, listaProfessioni, listaID);



    /*RIMOZIONE*/
            else if (sceltaMenu.equals("R")) {
                RimuoviCliente(id, listaNomi, listaCognomi, listaProfessioni, listaID);
            }
                        else if (sceltaMenu.equals("Q")) {
                            System.out.println("Uscita avvenuta con successo.");
                        }

                        else {
                            System.out.println("Scelta non valida");
                        }

        }
    }
    public static void StampaMenu(){
                System.out.println(" ");
                System.out.println("--------------------------");
                System.out.print("(A)ggiungere un cliente \n");
                System.out.println("--------------------------");
                System.out.print("(R)imuovere un cliente \n");
                System.out.println("--------------------------");
                System.out.print("(S)tampare dati inseriti \n");
                System.out.println("--------------------------");
                System.out.print("(Q)uit \n");
                System.out.println("--------------------------");
            }
    public static int AggiungiCliente(int id, List<String> listaNomi, List<String> listaCognomi,
                                              List<String> listaProfessioni, List<Integer> listaID){

                Scanner scanner = new Scanner(System.in);

                System.out.print("Inserire il nome del cliente: ");
                String nome = scanner.nextLine();


                System.out.print("Inserire il cognome del cliente: ");
                String cognome = scanner.nextLine();


                System.out.print("Inserire la professione del cliente: ");
                String professione = scanner.nextLine();
                listaProfessioni.add(professione);
                listaNomi.add(nome);
                listaCognomi.add(cognome);
                listaProfessioni.add(professione);
                listaID.add(id);
                id++;

                return id;
            }

    public static void StampaClienti(int id, List<String> listaNomi, List<String> listaCognomi,
                                     List<String> listaProfessioni, List<Integer> listaID){

                    for (int indice = 0; indice < listaNomi.size(); indice++)
                    System.out.printf("\n %10d | %-20s  %-20s  %-20s \n ", listaID.get(indice),
                    listaCognomi.get(indice), listaNomi.get(indice), listaProfessioni.get(indice));
    }

    public static void RimuoviCliente(int id, List<String> listaNomi, List<String> listaCognomi,
                List<String> listaProfessioni, List<Integer> listaID){
                                    Scanner scanner = new Scanner(System.in);

                                    System.out.print("Inserire l'id del cliente che vuoi rimuovere: ");
                                    int idDaRimuovere = scanner.nextInt();
                                    String garbage = scanner.nextLine();


                                    int posizioneClienteDaRimuovere = 0;
                                    boolean clienteTrovato = false;

                                    for (int indice = 0; indice < listaID.size() && !clienteTrovato; indice++)
                                            if (listaID.get(indice) == idDaRimuovere) {
                                                    posizioneClienteDaRimuovere = indice;
                                                    clienteTrovato = true;
                                            }
                                    if (clienteTrovato)
                                        listaNomi.remove(posizioneClienteDaRimuovere);
                                        listaCognomi.remove(posizioneClienteDaRimuovere);
                                        listaProfessioni.remove(posizioneClienteDaRimuovere);
                                        listaID.remove(posizioneClienteDaRimuovere);
                                             System.out.println("Rimozione avvenuta.");
        }
    }
