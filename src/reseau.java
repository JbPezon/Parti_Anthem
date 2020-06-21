import java.util.ArrayList;

public class reseau {

    private ArrayList<layer> mesLayer;

    public reseau(){
        this.mesLayer = new ArrayList<layer>();
    }

    public int testReseau(entrer e){
        for (int i = 0; i < 1000; i++) {
            mesLayer.get(0).getMyNeurone().get(i).setData(e.getNotes().get(i));
        }
        mesLayer.get(1).communique();
        //mesLayer.get(1).afficheData();
        //System.out.println("\n");
        mesLayer.get(2).communique();
        //mesLayer.get(2).afficheData();
        //System.out.println("\n");
        mesLayer.get(3).communique();


        int result = trouvePlusHautPoid();
        if (result == e.getNote()) {
            System.out.println("Reussi");
            return 1;
        }
        else {
            System.out.println("Rate, trouve "+ result + "au lieu de" +e.getNote() );
            return 0;
        }

    }

    public int trouvePlusHautPoid(){
        float plusHaut = 0;
        int idPlusHautPoid = 0;
        for (int i = 0; i < 13 ; i++) {
            if (this.getMesLayer().get(3).getMyNeurone().get(i).getData() > plusHaut){
                idPlusHautPoid = i;
                plusHaut = this.getMesLayer().get(3).getMyNeurone().get(i).getData();
            }
        }
        return idPlusHautPoid;
    }

    public void creerReseau(){ // TODO faire en sorte que ce soit l'utilisateur qui rentre les valeurs
        this.mesLayer.add(new layer(1000));
        this.mesLayer.add(new layer(20));
        this.mesLayer.add(new layer(20));
        this.mesLayer.add(new layer(14));

        for (layer l: this.mesLayer) {
            l.remplieLayer();
        }

        this.mesLayer.get(0).creerConnection(this.mesLayer.get(1));
        this.mesLayer.get(1).creerConnection(this.mesLayer.get(2));
        this.mesLayer.get(2).creerConnection(this.mesLayer.get(3));

    }

    public float apprentissage(entrer monEntrer){
        for (int i = 0; i < 1000; i++) {
            mesLayer.get(0).getMyNeurone().get(i).setData(monEntrer.getNotes().get(i));
        }
        mesLayer.get(1).communique();
        //mesLayer.get(1).afficheData();
        //System.out.println("\n");
        mesLayer.get(2).communique();
        //mesLayer.get(2).afficheData();
        //System.out.println("\n");
        mesLayer.get(3).communique();
        //mesLayer.get(3).afficheData();
        //System.out.println("\n");
        //System.out.println("a trouver : " + trouvePlusHautPoid() + " et devais trouver : " + monEntrer.getNote());

        //System.out.println(this);
        float poid = mesLayer.get(3).calculPoid(monEntrer.getNote());

        int cpt = 0;
        for (neurone n: mesLayer.get(3).getMyNeurone() ){
            //TODO verifier si cest la bonen neurone
            if (cpt == monEntrer.getNote())
                n.backPropagation(true, poid);
            else
                n.backPropagation(false, poid);
            cpt++;
        }
        for (neurone n: mesLayer.get(2).getMyNeurone() ){
            //TODO verifier si cest la bonen neurone
            n.backPropagation(false, poid);
        }
        for (neurone n: mesLayer.get(1).getMyNeurone() ){
            //TODO verifier si cest la bonen neurone
            n.backPropagation(false, poid);
        }

        System.out.println("--------------------------------");
        for (neurone n : mesLayer.get(3).getMyNeurone()) {
            System.out.println(n);
        }


        return poid;
    }

    public ArrayList<layer> getMesLayer() {
        return mesLayer;
    }

    public void setMesLayer(ArrayList<layer> mesLayer) {
        this.mesLayer = mesLayer;
    }

    @Override
    public String toString() {

        String result = "Premiere layer :\n";
        for (neurone n: this.mesLayer.get(0).getMyNeurone()) {
            result += n.getData() + " bias :  " + n.getBias() + ",  " ;
        }
        result += "\n Deuxieme layer :\n";
        for (neurone n: this.mesLayer.get(1).getMyNeurone()) {
            result += n.getData() + " bias :  " + n.getBias() + ",  " ;
        }
        result += "\n 3eme layer :\n";
        for (neurone n: this.mesLayer.get(2).getMyNeurone()) {
            result += n.getData() + " bias :  " + n.getBias() + ",  " ;
        }
        result += "\n 4eme layer :\n";
        for (neurone n: this.mesLayer.get(3).getMyNeurone()) {
            result += n.getData() + " bias :  " + n.getBias() + ",  " ;
        }

        return result;
    }
}
