package br.com.ada.projetofinal_pooii.service;

import br.com.ada.projetofinal_pooii.domain.BaseTask;
import br.com.ada.projetofinal_pooii.repository.Repository;
import br.com.ada.projetofinal_pooii.repository.RepositoryConcreta;
import br.com.ada.projetofinal_pooii.repository.RepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//classe Service depende da classe Repository pra fazer o CRUD das tarefas
public class Service {

    private final List<BaseTask> tasks = new ArrayList<>(); //lista q irá armazenar as tarefas
    private final RepositoryInterface repository;

    public Service(Scanner scanner){

        this.repository = new RepositoryConcreta();
    }


    //Métodos da classe Service que chamam os métodos correspondentes na classe Repository
    public void addTask(BaseTask task){
        repository.addTask(task);
        tasks.add(task);
    }

    public void removeTask(BaseTask task){
        repository.removeTask(task);
        tasks.remove(task);
    }

    public void updateTask(BaseTask task){
        repository.updateTask(task);
    }

    public List<BaseTask> getTasks(){
        return tasks;
        //return repository.getTasks();
    }

    public BaseTask getTasksByTitle(String title){
        //List<BaseTask> tasks = new ArrayList<>();
        for(BaseTask task : tasks) {
            if (task.getTitle().equals(title)) {
                //tasks.add(task);
                return task;
            }
        }
            return null;
        }
        //return tasks;

    public List<BaseTask> saveTask(BaseTask task) {
        tasks.add(task);
        return tasks;

    }
}
