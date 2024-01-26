package br.com.ada.projetofinal_pooii.controller;

import br.com.ada.projetofinal_pooii.domain.BaseTask;
import br.com.ada.projetofinal_pooii.domain.PersonalTask;
import br.com.ada.projetofinal_pooii.service.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Controller {

    //private Service service;
    //public Controller(Service service){
        //this.service = service;

    //}

    //private Scanner scanner;

    private Scanner scanner;
    private Service service;
    public Controller(){
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao gerenciador de tarefas Ada Task!");

        while(true){
            System.out.println("Digite o número desejado conforme a tarefa que pretende realizar:");
            System.out.println("1. Adicionar uma tarefa");
            System.out.println("2. Remover uma tarefa");
            System.out.println("3. Atualizar uma tarefa");
            System.out.println("4. Listar todas as tarefas");
            System.out.println("5. Sair do programa");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    System.out.println("O programa será encerrado.");
                default:
                    System.out.println("Operação inválida. Digite um número válido para acessar suas tarefas.");
            }
        }
    }


    private void addTask() {
        System.out.println("Informe o título da sua tarefa: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println("Informe a descrição da sua tarefa: ");
        String description = scanner.nextLine();

        System.out.println("Informe a data para realizar a sua tarefa: ");
        String deadlineStr = scanner.nextLine(); //

        Date deadline = new Date();
        try {
            deadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadlineStr);
        } catch (ParseException e) {
            System.out.println("O formato da data é inválido!");
            return;
        }

        BaseTask task = new PersonalTask(title, description, deadline);
        service.addTask(task);

        System.out.println("A tarefa foi adicionada com sucesso!");
    }

    private void removeTask(){
        System.out.println("Informe o título da tarefa que deseja remover da lista: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        List<BaseTask> tasks = service.getTasksByTitle(title);
        if(tasks.isEmpty()){
            System.out.println("A tarefa não pode ser encontrada");
            return;
        }

        service.removeTask(tasks.get(0));
        System.out.println("A tarefa foi removida!");
    }

    private void updateTask(){
        System.out.println("Informe o título da tarefa a ser atualizada: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        List<BaseTask> tasks = service.getTasksByTitle(title);
        if(tasks.isEmpty()) {
            System.out.println("A tarefa não pode ser encontrada");
            return;
        }

        System.out.println("Informe o título da nova tarefa a ser incluída: ");
        String newTitle = scanner.nextLine();

        System.out.println("Informe a descrição da nova tarefa a ser incluída: ");
        String newDescription = scanner.nextLine();

        System.out.println("Informe a data para realização da nova tarefa a ser incluída: ");
        String newDeadlineStr = scanner.nextLine();

        Date newDeadline =  new Date();
        try{
            newDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(newDeadlineStr);
        } catch (ParseException e){
            System.out.println("A data digitada é inválida");
            return;
        }

        tasks.get(0).setTitle(newTitle);
        tasks.get(0).setDescription(newDescription);
        tasks.get(0).setDeadline(newDeadline);

        service.updateTask(tasks.get(0));
        System.out.println("A tarefa foi removida");
    }

    private void listTasks() {
        List<BaseTask> tasks = service.getTasks();

        if(tasks.isEmpty()){
            System.out.println("A lista de tarefas está vazia");
            return;
        }

        System.out.println("Lista de tarefas por ordem: ");
        for (BaseTask task : tasks){
            System.out.println("Título da tarefa: " + task.getTitle());
            System.out.println("Descrição da tarefa: " + task.getDescription());
            System.out.println("Data para conclusão da tarefa (dd/MM/aaaa): " + task.getDeadline());
        }
    }
}
