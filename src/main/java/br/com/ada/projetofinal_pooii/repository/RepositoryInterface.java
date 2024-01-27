package br.com.ada.projetofinal_pooii.repository;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.time.LocalDate;
import java.util.List;

public interface RepositoryInterface {
    void addTask(BaseTask task);

    void removeTask(BaseTask task);

    void updateTask(BaseTask task);

    List<BaseTask> getTasks();

}
