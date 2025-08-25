package pe.edu.upeu.encapsulamiento.claseInterface;

public class ClaseGeneral {
    public static void main(String[] args) {
        Animal a,b;
        a = new Loro();
        a.emitirSonido();
        a.dormir();

        b = new Perro();
        b.emitirSonido();
        b.dormir();
    }
}
