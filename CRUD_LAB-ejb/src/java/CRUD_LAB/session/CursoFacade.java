/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB.session;

import CRUD_LAB.entity.Curso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ddav_
 */
@Stateless
public class CursoFacade extends AbstractFacade<Curso> implements CursoFacadeLocal {

  @PersistenceContext(unitName = "CRUD_ejbPU")
  private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }
    //solo esta se le agrega
  @Override
    public Curso getCourse(int codCurso) {
        return em.find(Curso.class, codCurso);
    }
    
}
