package pe.edu.upeu.encapsulamiento.claseInterface;

public class Loro implements Animal {
    @Override
    public void emitirSonido() {
        System.out.println("HOLA MANITO, APRENDE PUES!");
    }

    @Override
    public void dormir() {
        System.out.println("Zzz....Zzz..");
    }
}
