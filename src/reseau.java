import java.util.ArrayList;

public class reseau {

    private ArrayList<layer> mesLayer;

    public reseau(){
        this.mesLayer = new ArrayList<layer>();
    }

    public void creerReseau(int nbLayer){ // TODO faire en sorte que ce soit l'utilisateur qui rentre les valeurs
        this.mesLayer.add(new layer(1000));
        this.mesLayer.add(new layer(10));
        this.mesLayer.add(new layer(12));

        for (layer value: this.mesLayer) {
            //TODO appeler layer.remplieLayer()
        }
    }

    public ArrayList<layer> getMesLayer() {
        return mesLayer;
    }

    public void setMesLayer(ArrayList<layer> mesLayer) {
        this.mesLayer = mesLayer;
    }
}
