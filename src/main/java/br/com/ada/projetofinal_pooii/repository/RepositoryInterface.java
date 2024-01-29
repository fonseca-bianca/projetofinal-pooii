package br.com.ada.projetofinal_pooii.repository;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.time.LocalDate;
import java.util.List;

//Interface Generics
public interface RepositoryInterface<T extends BaseTask> {
    void addTask(T task);

    void removeTask(T task);

    void updateTask(T task);

    List<T> getTasks();
}
