package erp_ironsoft

class BootStrap {

    def init = { servletContext ->

      def dependenciaPrueba = new Dependencia(nombre: 'Secretaria de gobierno',
      descripcion: 'Secretaria principal que atiende asuntos federales e internacionales',
      acronimo : 'SEGOB',
      imagen: null,
      pertenece: null,
      comentario: null).save(flush:true)

      def RoleSuperAdmin = new Rol(authority: 'ROLE_SUPERADMIN').save()
      def RoleAdmin = new Rol(authority: 'ROLE_ADMIN').save()
      def RoleUsuario = new Rol(authority: 'ROLE_USUARIO').save()

      def usuarioSuperAdmin = new Usuario(
                username: 'superadmin',
                password: 'superadmin',
                nombre: "superadmin",
                apellidoPaterno: "superadmin",
                apellidoMaterno: "superadmin"
        ).save()

        def usuarioAdmin = new Usuario(
                username: 'admin',
                password: 'admin',
                nombre: "admin",
                apellidoPaterno: "admin",
                apellidoMaterno: "admin"
        ).save()

        def usuarioPrueba = new Usuario(
            username: 'MRHE',
            password: 'MRHE',
            nombre: "Héctor Edgar",
            apellidoPaterno: "Matías",
            apellidoMaterno: "Rodríguez",
        ).save()

        def usuarioPrueba2 = new Usuario(
                username: 'YBMZ',
                password: 'YBMZ',
                nombre: "YBMZ YBMZ",
                apellidoPaterno: "YBMZ",
                apellidoMaterno: "YBMZ",
        ).save()


        UsuarioRol.create usuarioSuperAdmin, RoleSuperAdmin
        UsuarioRol.create usuarioAdmin, RoleAdmin
        UsuarioRol.create usuarioPrueba, RoleUsuario
        UsuarioRol.create usuarioPrueba2, RoleUsuario

    }
    def destroy = {
    }
}
