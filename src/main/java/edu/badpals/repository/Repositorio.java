package edu.badpals.repository;

import java.util.Optional;


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
}
