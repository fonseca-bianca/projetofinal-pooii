package br.com.ada.projetofinal_pooii.repository;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    //Lista ArrayList<> vai armazenar as tarefas.
    private List<BaseTask> tasks = new ArrayList<>();

    //Métodos que vão implementar as tarefas CRUD:
    public void addTask(BaseTask task){
        tasks.add(task);
    }

    public void removeTask(BaseTask task){
        tasks.remove(task);
    }

    public void updateTask(BaseTask task){
        int index = tasks.indexOf(task);
        tasks.set(index, task);
    }

    public List<BaseTask> getTasks(){
        return tasks;
    }
}
