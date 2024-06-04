package edu.badpals.repository;

import java.util.Optional;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Wizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class Repositorio {
    @Inject
    RepoItem repoItem;
    @Inject
    RepoWizard repoWizard;
    @Inject
    RepoOrder repoOrder;

    public Optional<Wizard> loadWizard(String name) {
        return this.repoWizard.findByIdOptional(name);
    }
    public Optional<MagicalItem> loadItem(String name){
        return this.repoItem.find("name",name).firstResultOptional();
    }
    public Optional<MagicalItem> loadItem(MagicalItem item){
        return this.loadItem(item.getName()).stream().filter(it -> it.getName()==item.getName()&& it.getQuality()==item.getQuality() && it.getType()==item.getType()).findFirst();
    }
}
