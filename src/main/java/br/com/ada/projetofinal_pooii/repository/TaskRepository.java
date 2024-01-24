package br.com.ada.projetofinal_pooii.repository;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T extends BaseTask> {
    private List<T> tasks; //CRIAR COMO VARIÁVEL FINAL?

    public TaskRepository(){
        this.tasks = new ArrayList<>();
    }

    //Criando método pra adicionar uma tarefa:
    public void addTask(T task){
        tasks.add(task);
    }

    //Criando método pra remover uma tarefa:
    public void removeTask(T task){
        tasks.remove(task);
    }

    //Criando método pra atualizar tarefa:
    public void updateTask(int index, T task){
        tasks.set(index, task);
    }

    //Criando método pra buscar tarefa:

    //getTask irá retornar a tarefa do tipo "T", ao invés de 'void' q nada retornaria
    public T getTask(int index){
        return repository.getTask(index);
    }
}
