package pe.edu.upeu.herencia;

public class Carro extends Vehiculo{
    String modelo="TOYOTA";
    String placa="PE-123456";
    String color="ROJO PA QUE NO SE VEA SU SANGRE";

    void caracteristicas(){
        System.out.println("Las caracteristicas de este carro son");
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Placa: "+placa);
        System.out.println("Color: "+color);
    }

    public void main(String[] args){
        Carro carro = new Carro();
        carro.caracteristicas();
        carro.sonido();
    }
}