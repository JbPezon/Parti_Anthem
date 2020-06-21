import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        reseau monReseau = new reseau();
        monReseau.creerReseau();

        son monDo = new son("sample/do 16 bits.wav");
        son monDo2 = new son("sample/do2 16 bits.wav");
        son monDod2 = new son("sample/dod2 16 bits.wav");
        son monDod = new son("sample/dod 16 bits.wav");
        son monFa2 = new son("sample/fa2 16 bits.wav");
        son monFa = new son("sample/fa 16 bits.wav");
        son monLa = new son("sample/la 16 bits.wav");
        son monLad = new son("sample/lad 16 bits.wav");
        son monMi = new son("sample/mi 16 bits.wav");
        son monMid = new son("sample/mid 16 bits.wav");
        son monRe = new son("sample/re 16 bits.wav");
        son monRed = new son("sample/red 16 bits.wav");
        son monSid = new son("sample/sad 16 bits.wav");
        son monSi = new son("sample/si 16 bits.wav");
        son monSol = new son("sample/sol 16 bits.wav");
        son monSold = new son("sample/sold 16 bits.wav");

        ArrayList<entrer> batch1 = new ArrayList<>();
        batch1.add(new entrer(0,monDo));
        batch1.add(new entrer(1,monDod));
        batch1.add(new entrer(9,monLa));
        batch1.add(new entrer(13,monMid));
        batch1.add(new entrer(12,monSid));

        ArrayList<entrer> batch2 = new ArrayList<>();
        batch2.add(new entrer(0,monDo2));
        batch2.add(new entrer(5,monFa2));
        batch2.add(new entrer(10,monLad));
        batch2.add(new entrer(2,monRe));
        batch2.add(new entrer(11,monSi));

        ArrayList<entrer> batch3 = new ArrayList<>();
        batch3.add(new entrer(1,monDod2));
        batch3.add(new entrer(5,monFa));
        batch3.add(new entrer(4,monMi));
        batch3.add(new entrer(3,monRed));
        batch3.add(new entrer(7,monSol));
        batch3.add(new entrer(8,monSold));


        System.out.println("\n\n");


        int cpt = 0;
        for (int j = 0; j < 3; j++) {


            for (int i = 0; i < 2000; i++) {
                for (entrer e : batch1) {
                    if (cpt == 1000) {
                        System.out.println(monReseau.apprentissage(e));
                        cpt = 0;
                    } else
                        monReseau.apprentissage(e);
                    cpt++;
                }
            }

            for (int i = 0; i < 2000; i++) {
                for (entrer e : batch2) {
                    if (cpt == 1000) {
                        System.out.println(monReseau.apprentissage(e));
                        cpt = 0;
                    } else
                        monReseau.apprentissage(e);
                    cpt++;
                }
            }

            for (int i = 0; i < 2000; i++) {
                for (entrer e : batch3) {
                    if (cpt == 1000) {
                        System.out.println(monReseau.apprentissage(e));
                        cpt = 0;
                    } else
                        monReseau.apprentissage(e);
                    cpt++;
                }
            }
        }

        int cptResult = 0;
        for (int i = 0; i < 10; i++) {


            for (entrer e : batch1) {
                cptResult += monReseau.testReseau(e);
            }
            for (entrer e : batch2) {
                cptResult += monReseau.testReseau(e);
            }
            for (entrer e : batch3) {
                cptResult += monReseau.testReseau(e);
            }
        }

        System.out.println("Le reseau a trouvé : " + cptResult + "/160");

    }//Fin de la méthode main
}

/*
0 : do
1 : do#
2 : re
3 : re#
4 : mi
5 : fa
6 : fa#
7 : sol
8 : sol#
9 : la
10 : la#
11 : si
12 : sid
13 : mid
 */
