
package com.mycompany.peluqueriacaninajv.logica;

import com.mycompany.peluqueriacaninajv.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    public void guardar(String nombreMaco, String razaMaco, String colorMaco, String observaciones, String alergico, String atesp, String nombreDuenio, String celDuenio) {
       //Creamos el duenio y asignamos sus valores
        Dueño duenio = new Dueño();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        //Creamos la mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMaco);
        masco.setRaza(razaMaco);
        masco.setColor(colorMaco);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atesp);
        masco.setUnDuenio(duenio);
        
        
        controlPersi.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
        return controlPersi.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersi.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
      return controlPersi.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMaco, String razaMaco, String colorMaco, String observaciones, String alergico, String atesp, String nombreDuenio, String celDuenio) {
       masco.setNombre(nombreMaco);
       masco.setRaza(razaMaco);
       masco.setColor(colorMaco);
       masco.setObservaciones(observaciones);
       masco.setAtencion_especial(atesp);
       masco.setAlergico(alergico);
       
       //Modifico mascota
       controlPersi.modificarMascota(masco);
       
       //seteo los valores del duenio
       Dueño duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
       duenio.setNombre(nombreDuenio);
       duenio.setCelDuenio(celDuenio);
       
       //llamar al modificar duenio
       this.modificarDuenio(duenio);
    }

    private Dueño buscarDuenio(int id_duenio) {
       return  controlPersi.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Dueño duenio) {
        controlPersi.modificarDuenio(duenio);
    }
       
}
