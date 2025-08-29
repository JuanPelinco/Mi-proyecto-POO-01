package pe.edu.upeu.abspolimorfismo;

public class Loro extends Animal {

    private String tipo="Ave";

    @Override
    public void emitirSonido(){
        System.out.println("Galletas, Galletas!!!");
    }

    @Override
    public void dormir(){
        super.dormir();
        System.out.println(super.tipo);
        System.out.println(this.tipo);
        System.out.println("No moleste p, TAZUUU!!!");
    }
}
