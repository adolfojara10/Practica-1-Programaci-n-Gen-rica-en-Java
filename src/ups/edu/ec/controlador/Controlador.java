/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.*;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author Adolfo
 * @param <T>
 */
public class Controlador<T> {

    private List<T> listaGenerica;

    public Controlador() {
        listaGenerica = new ArrayList<>();
    }

    public void create(T objeto) {
        listaGenerica.add(objeto);
        System.out.println(listaGenerica);
    }

    public Optional<T> read(T objeto) {
        return (Optional<T>) listaGenerica.stream().filter(obj -> obj.equals(objeto)).findFirst().get();
    }

    public void update(T objeto) {
        int index = listaGenerica.indexOf(objeto);
        listaGenerica.remove(index);
        listaGenerica.add(index, objeto);
    }

    public void delete(T objeto) {
        listaGenerica.remove(objeto);
    }

    public List<T> findAll() {
        return listaGenerica;
    }

    public Usuario iniciarSesion(String correo, String password) {

        List<Usuario> copiaListaUsuario;
        copiaListaUsuario = (List<Usuario>) List.copyOf(listaGenerica);
               
        return copiaListaUsuario.stream().filter(usu -> usu.getCorreo().equals(correo) && usu.getPassword().equals(password)).findFirst().get();

        //return (Usuario) listaGenerica.stream().filter(usu -> usu.getCorreo().equals(correo) && usu.getPassword().equals(password)).findFirst().get();  
        
    }

    public int cargarCodigo() {
        var copiaListaTelefonos = (List<Telefono>) List.copyOf(listaGenerica);
        return (copiaListaTelefonos.size() + 1);
    }

    /*
    private List<Usuario> listaUsuarios;
    private List<Telefono> listaTelefonos;

    public Controlador() {
        listaUsuarios = new ArrayList<>();
        listaTelefonos = new ArrayList<>();
    }

    public void createUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Usuario readUsuario(String apellido) {
        return listaUsuarios.stream().filter(usuario -> usuario.getApellido().equals(apellido)).findFirst().get();
    }

    public void updateUsuario(Usuario usuario) {
        var usuarioUpdate = listaUsuarios.stream().filter(u -> u.getCedula().equals(usuario.getCedula())).findFirst().get();
        int index = listaUsuarios.indexOf(usuarioUpdate);
        listaUsuarios.add(index, usuario);
    }

    public void deleteUsuario(String cedula) {
        var usuarioDelete = listaUsuarios.stream().filter(usu -> usu.getCedula().equals(cedula)).findFirst().get();
        listaUsuarios.remove(usuarioDelete);
    }

    public Usuario iniciarSesion(String correo, String password) {
        return listaUsuarios.stream().filter(u -> u.getCorreo().equals(correo) && u.getPassword().equals(password)).findFirst().get();
    }

  //
    
    public void createTelefono(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    public Telefono readTelefono(String numero) {
        return listaTelefonos.stream().filter(tele -> tele.getNumero().equals(numero)).findFirst().get();
    }

    public void updateTelefono(Telefono telefono) {
        var telefonoUpdate = listaTelefonos.stream().filter(tele -> tele.getCodigo() == telefono.getCodigo()).findFirst().get();
        int index = listaTelefonos.indexOf(telefonoUpdate);
        listaTelefonos.add(index, telefono);
    }

    public void deleteTelefono(int codigo) {
        var telefonoDelete = listaTelefonos.stream().filter(tele -> tele.getCodigo() == codigo).findFirst().get();
        listaTelefonos.remove(telefonoDelete);
    }

    public List<Telefono> findAll(){
        return listaTelefonos;
    }
     */
}
