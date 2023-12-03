package br.mil.fab.pagl.controller;

import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.service.VeiculoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VeiculoController implements VeiculoService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connect-jpa");
    EntityManager em = emf.createEntityManager();
    @Override
    public void create(Veiculo veiculo) {

    }

    @Override
    public void update(Veiculo veiculo) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void findById(Integer id) {

    }

    @Override
    public List<Veiculo> findAll() {
        return null;
    }
}
