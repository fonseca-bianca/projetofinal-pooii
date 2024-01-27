package br.com.ada.projetofinal_pooii.repository;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryConcreta extends Repository{

    public RepositoryConcreta(){

    }
    private List<BaseTask> tasks = new ArrayList<>();

    @Override
    public void addTask(BaseTask task){
        tasks.add(task);
    }
    @Override
    public void removeTask(BaseTask task){
        tasks.remove(task);
    }
    @Override
    public void updateTask(BaseTask task){
        int index = tasks.indexOf(task);
        tasks.set(index, task);
    }
    @Override
    public List<BaseTask> getTasks(){
        return tasks;

    }
}
