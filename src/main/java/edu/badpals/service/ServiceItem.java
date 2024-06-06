package edu.badpals.service;

import java.util.List;
import java.util.Optional;

import edu.badpals.domain.MagicalItem;
import edu.badpals.repository.Repositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ServiceItem implements Servicio {
    @Inject
    Repositorio repo;

    @Override
    public Optional<MagicalItem> cargaItem(String name) {
        return repo.loadItem(name);
    }

    @Override
    public Optional<MagicalItem> cargaItem(MagicalItem item) {
        return repo.loadItem(item);
    }
    @Override
    public List<MagicalItem> cargaItems(String name) {
        return repo.loadItems(name);
    }

    @Override
    public Optional<MagicalItem> creaItem(MagicalItem item) {

        repo.createItem(item.getName(), item.getQuality(), item.getType());

        return repo.loadItem(item);
    }

    @Override
    public void eliminaItem(MagicalItem item) {
        repo.deleteItem(item);
    }    
}
