package erp_ironsoft

class Ubicacion {

    String latitud
    String longitud

    static belongsTo = [direccion: Direccion]

    static constraints = {
    }
}
