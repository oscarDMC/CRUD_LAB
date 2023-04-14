/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ddav_
 */
@Entity
@Table(name = "ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByCodEstudiantes", query = "SELECT e FROM Estudiantes e WHERE e.codEstudiantes = :codEstudiantes"),
    @NamedQuery(name = "Estudiantes.findByNombreEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.nombreEstudiante = :nombreEstudiante"),
    @NamedQuery(name = "Estudiantes.findByApellidoEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.apellidoEstudiante = :apellidoEstudiante"),
    @NamedQuery(name = "Estudiantes.findBySemestreEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.semestreEstudiante = :semestreEstudiante")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTUDIANTES")
    private Integer codEstudiantes;
    @Size(max = 50)
    @Column(name = "NOMBRE_ESTUDIANTE")
    private String nombreEstudiante;
    @Size(max = 50)
    @Column(name = "APELLIDO_ESTUDIANTE")
    private String apellidoEstudiante;
    @Column(name = "SEMESTRE_ESTUDIANTE")
    private Integer semestreEstudiante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<Matricula> matriculaCollection;

    public Estudiantes() {
    }

    public Estudiantes(Integer codEstudiantes, String nombreEstudiante, String apellidoEstudiante, Integer semestreEstudiante) {
        this.codEstudiantes = codEstudiantes;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.semestreEstudiante = semestreEstudiante;
    }

    public Estudiantes(Integer codEstudiantes) {
        this.codEstudiantes = codEstudiantes;
    }

 
    public Integer getCodEstudiantes() {
        return codEstudiantes;
    }

    public void setCodEstudiantes(Integer codEstudiantes) {
        this.codEstudiantes = codEstudiantes;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public Integer getSemestreEstudiante() {
        return semestreEstudiante;
    }

    public void setSemestreEstudiante(Integer semestreEstudiante) {
        this.semestreEstudiante = semestreEstudiante;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstudiantes != null ? codEstudiantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.codEstudiantes == null && other.codEstudiantes != null) || (this.codEstudiantes != null && !this.codEstudiantes.equals(other.codEstudiantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CRUD_LAB.entity.Estudiantes[ codEstudiantes=" + codEstudiantes + " ]";
    }
    
}
