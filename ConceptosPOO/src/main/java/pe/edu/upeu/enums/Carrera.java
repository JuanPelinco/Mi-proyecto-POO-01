package pe.edu.upeu.enums;

enum FACULTAD{
    FIA,
    FCE,
    FACIHED,
    FCS
}

public enum Carrera {
    Sistemas(FACULTAD.FIA),
    Civil(FACULTAD.FIA),
    Ambiental(FACULTAD.FIA),
    Aquitectural(FACULTAD.FIA),

    Administracion(FACULTAD.FCE),
    Contabilidad(FACULTAD.FCS),

    Educacion(FACULTAD.FACIHED),
    ;


    FACULTAD facultad;
    Carrera(FACULTAD facultad) {
        this.facultad = facultad;
    }
}
