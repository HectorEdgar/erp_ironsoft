package erp_ironsoft

class Dependencia {

    String nombre
    String descripcion
    String acronimo
    String imagen

    static belongsTo = [pertenece: Dependencia]
    static hasMany = [comentario : Comentario]

    static constraints = {
      nombre nullable: false
      descripcion nullable : false
      acronimo nullable: false
      imagen nullable: true
      pertenece nullable: true
      comentario nullable: true
    }

    public String toString() {
      return nombre
    }
}
