package br.com.ada.projetofinal_pooii.repository;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;


public abstract class Repository implements RepositoryInterface {

    //Lista ArrayList<> vai armazenar as tarefas.
    private List<BaseTask> tasks = new ArrayList<>();

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

    @Override
    public List<BaseTask> getTasks(){
        return tasks;
    }
}
