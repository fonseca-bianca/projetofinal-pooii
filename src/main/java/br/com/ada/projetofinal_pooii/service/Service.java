package br.com.ada.projetofinal_pooii.service;

import br.com.ada.projetofinal_pooii.domain.BaseTask;
import br.com.ada.projetofinal_pooii.repository.Repository;

import java.util.ArrayList;
import java.util.List;

//classe Service depende da classe Repository pra fazer o CRUD das tarefas
public class Service {
    private final Repository repository;

    public Service(Repository repository){
        this.repository = repository;
    }


    //Métodos da classe Service que chamam os métodos correspondentes na classe Repository
    public void addTask(BaseTask task){
        repository.addTask(task);
    }

    public void removeTask(BaseTask task){
        repository.removeTask(task);
    }

    public void updateTask(BaseTask task){
        repository.updateTask(task);
    }

    public List<BaseTask> getTasks(){
        return repository.getTasks();
    }

    public List<BaseTask> getTasksByTitle(String title){
        List<BaseTask> tasks = new ArrayList<>();
        for(BaseTask task : tasks){
            if(task.getTitle().equals(title)){
                tasks.add(task);
            }
        }
        return tasks;
    }
}
