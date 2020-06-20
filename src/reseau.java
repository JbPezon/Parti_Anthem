import java.util.ArrayList;

public class reseau {

    private ArrayList<layer> mesLayer;

    public reseau(){
        this.mesLayer = new ArrayList<layer>();
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

        float poid = mesLayer.get(3).calculPoid(0);
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

        return poid;
    }

    public ArrayList<layer> getMesLayer() {
        return mesLayer;
    }

    public void setMesLayer(ArrayList<layer> mesLayer) {
        this.mesLayer = mesLayer;
    }
}
