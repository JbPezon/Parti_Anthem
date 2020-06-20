import java.util.ArrayList;

public class reseau {

    private ArrayList<layer> mesLayer;

    public reseau(){
        this.mesLayer = new ArrayList<layer>();
    }

    public void creerReseau(){ // TODO faire en sorte que ce soit l'utilisateur qui rentre les valeurs
        this.mesLayer.add(new layer(1000));
        this.mesLayer.add(new layer(15 ));
        this.mesLayer.add(new layer(15));
        this.mesLayer.add(new layer(12));

        for (layer l: this.mesLayer) {
            l.remplieLayer();
        }

        this.mesLayer.get(0).creerConnection(this.mesLayer.get(1));
        this.mesLayer.get(1).creerConnection(this.mesLayer.get(2));
        this.mesLayer.get(2).creerConnection(this.mesLayer.get(3));

    }

    public ArrayList<layer> getMesLayer() {
        return mesLayer;
    }

    public void setMesLayer(ArrayList<layer> mesLayer) {
        this.mesLayer = mesLayer;
    }
}
