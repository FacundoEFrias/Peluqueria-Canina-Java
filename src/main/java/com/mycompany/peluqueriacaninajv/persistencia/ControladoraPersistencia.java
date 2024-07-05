
package com.mycompany.peluqueriacaninajv.persistencia;

import com.mycompany.peluqueriacaninajv.logica.Dueño;
import com.mycompany.peluqueriacaninajv.logica.Mascota;
import com.mycompany.peluqueriacaninajv.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    DueñoJpaController duenioJpa = new DueñoJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();

    public void guardar(Dueño duenio, Mascota masco) {
        //Crear en la BD duenio
       duenioJpa.create(duenio);
       //Crear en la BD Mascota
       mascoJpa.create(masco);
       
    }

    public List<Mascota> traerMascotas() {
      return mascoJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Dueño traerDuenio(int id_duenio) {
       return duenioJpa.findDueño(id_duenio);
    }

    public void modificarDuenio(Dueño duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
