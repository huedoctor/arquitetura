/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 * @author eddie.mssantos
 */
public class EmpresaDAO {
    
    private EntityManagerFactory conn;
    private EntityManager manager;
    
    public void conectar() {
        conn = Persistence.createEntityManagerFactory("WebSitePU");
        manager = conn.createEntityManager();
        
    }
    
    public Acesso validarLogin(String u, String s) {
        conectar();
        try {
            TypedQuery<Acesso> query = manager.createNamedQuery("Acesso.findByEmailSenhaFuncionario", Acesso.class);
            query.setParameter("senhaFuncionario", s);
            query.setParameter("emailFuncionario", u);
            Acesso acesso = query.getSingleResult();
            return acesso;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public int salvarDepartamento(Departamento dep) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(dep);
            manager.getTransaction().commit();
            return 1;
        } catch (RollbackException ex) {
            return 2;
        } catch (Exception ex) {
            return 3;
        }
    }
    
    public List<Departamento> listarDepartamentos() {
        conectar();
        try {
            TypedQuery<Departamento> query = manager.createNamedQuery("Departamento.findAll", Departamento.class);
            List<Departamento> dep = query.getResultList();
            return dep;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Departamento> consultarDepartamentos(String n) {
        conectar();
        try {
            TypedQuery<Departamento> query = manager.createNamedQuery("Departamento.findByNomeDepartamento", Departamento.class);
            query.setParameter("nomeDepartamento", "%" + n + "%");
            List<Departamento> departamentos = query.getResultList();
            return departamentos;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public int excluirDepartamento(String id) {
        conectar();
        
        try {
            Departamento dep = manager.find(Departamento.class, id);
            if (dep == null) {
                return 2;
            } else {
                
                manager.getTransaction().begin();
                manager.remove(dep);
                manager.getTransaction().commit();
                return 1; // Deu certo
            }
        } catch (Exception ex) {
            return 0; //Deu qualquer outro erro
        }
        
    }
    
    public int alterarDepartamento(String id, String nome, String fone) {
        conectar();
        
        try {
            Departamento dep = manager.find(Departamento.class, id);
            dep.setFoneDepartamento(fone);
            dep.setNomeDepartamento(nome);
            manager.getTransaction().begin();
            manager.merge(dep);
            manager.getTransaction().commit();
            return 1; // Deu certo
        } catch (Exception ex) {
            return 0;
        }
    }
    
}
