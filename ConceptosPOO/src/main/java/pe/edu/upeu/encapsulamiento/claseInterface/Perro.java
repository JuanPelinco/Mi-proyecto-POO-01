package pe.edu.upeu.encapsulamiento.claseInterface;

public class Perro implements Animal {
    @Override
    public void emitirSonido() {
        System.out.println("GUAU....GUAU");
    }

    @Override
    public void dormir() {
        System.out.println("Zzz....Zzz..");
    }
}
