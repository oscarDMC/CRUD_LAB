/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ddav_
 */
@Entity
@Table(name = "MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByCodigoCurso", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Matricula.findByCodigoEstudiantes", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.codigoEstudiantes = :codigoEstudiantes"),
    @NamedQuery(name = "Matricula.findByMatPrecio", query = "SELECT m FROM Matricula m WHERE m.matPrecio = :matPrecio")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaPK matriculaPK;
    @Column(name = "MAT_PRECIO")
    private Integer matPrecio;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "COD_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "CODIGO_ESTUDIANTES", referencedColumnName = "COD_ESTUDIANTES", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;

    public Matricula() {
    }

    public Matricula(int codigoCurso, int codigoEstudiante, int matPrecio) {
        this.matriculaPK = new MatriculaPK(codigoCurso, codigoEstudiante);
        this.matPrecio = matPrecio;
    }
    
    public Matricula(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Matricula(String codigoCurso, String codigoEstudiantes) {
        this.matriculaPK = new MatriculaPK(codigoCurso, codigoEstudiantes);
    }

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Integer getMatPrecio() {
        return matPrecio;
    }

    public void setMatPrecio(Integer matPrecio) {
        this.matPrecio = matPrecio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaPK != null ? matriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaPK == null && other.matriculaPK != null) || (this.matriculaPK != null && !this.matriculaPK.equals(other.matriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CRUD_LAB.entity.Matricula[ matriculaPK=" + matriculaPK + " ]";
    }
    
}
