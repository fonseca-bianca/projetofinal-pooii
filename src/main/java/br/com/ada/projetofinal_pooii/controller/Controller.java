package br.com.ada.projetofinal_pooii.controller;

import br.com.ada.projetofinal_pooii.domain.BaseTask;
import br.com.ada.projetofinal_pooii.domain.PersonalTask;
import br.com.ada.projetofinal_pooii.service.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class Controller {

    private Service service;
    private Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
        this.service = new Service(scanner);
    }

    public void run() {
        System.out.println("Bem-vindo ao gerenciador de tarefas Ada Task!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite o número desejado conforme a tarefa que pretende realizar:");
            System.out.println("1. Adicionar uma tarefa");
            System.out.println("2. Remover uma tarefa");
            System.out.println("3. Atualizar uma tarefa");
            System.out.println("4. Listar todas as tarefas");
            System.out.println("5. Sair do programa");

            int option = scanner.nextInt();

            if (option < 1 || option > 5) {
                System.out.println("Opção inválida. Digite um número de 1 a 5");
                continue;
            }

            switch (option) {
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
        //Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println("Informe a descrição da sua tarefa: ");
        String description = scanner.nextLine();

        System.out.println("Informe a data para realizar a sua tarefa: ");
        String deadlineStr = scanner.nextLine(); //

        LocalDate deadline;

        try {
            deadline = LocalDate.parse(deadlineStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("O formato da data é inválido!");
            return;
        }
        //ver aq
        //Date deadline = new Date();
        BaseTask task = new PersonalTask(title, description, Date.from(deadline.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        //service.addTask(task);

        //service.addTask(task);
        //service.saveTask(task);

        List<BaseTask> tasks = service.saveTask(task);

        System.out.println("A tarefa foi adicionada com sucesso!");
    }

    private void removeTask() {

        System.out.println("Informe o título da tarefa que deseja remover da lista: ");
        //Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        //if(title.isEmpty()){
        //System.out.println("Digite o novo título para a sua tarefa");
        //return;

        //}
        //Task task = new Task("","", null);
        //task.setTitle(title);


        //List<BaseTask> tasks = service.getTasksByTitle(title);
        BaseTask taskToRemove = service.getTasksByTitle(title);
        if (taskToRemove == null) {
            System.out.println("A tarefa não pode ser encontrada, pois a lista está vazia");
            //return;
        } else {
            //BaseTask taskToRemove = tasks.get(0);
            service.removeTask(taskToRemove);
            service.removeTask(taskToRemove);
            System.out.println("A tarefa foi removida!");
        }
    }

    private void updateTask() {
        System.out.println("Informe o título da tarefa a ser atualizada: ");
        //Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        // 1. Verifica se a tarefa existe
        BaseTask taskToUpdate = service.getTasksByTitle(title);

        // Se a tarefa não existir, imprime uma mensagem de erro e retorna
        if (taskToUpdate == null) {
            System.out.println("A tarefa não pode ser atualizada, pois a lista está vazia");
            return;
        }

        // 2. Verifica se a nova descrição da tarefa é diferente da anterior
        System.out.println("Digite a nova descrição da tarefa: ");
        String newDescription = scanner.nextLine();

        // Se a nova descrição for vazia, imprime uma mensagem de erro e retorna
        if (newDescription.isEmpty()) {
            System.out.println("A nova descrição não pode ser vazia.");
            return;
        }

        // Se a nova descrição é diferente da anterior, imprime uma mensagem de sucesso
        if (!newDescription.equals(taskToUpdate.getDescription())) {
            System.out.println("A tarefa foi atualizada com sucesso!");
        } else {
            // Se a nova descrição é igual à anterior, imprime uma mensagem de aviso
            System.out.println("A nova descrição é a mesma da descrição anterior.");
        }

        // Atualiza a descrição da tarefa
        taskToUpdate.setDescription(newDescription);
        service.updateTask(taskToUpdate);
    }



        //List<BaseTask> tasks = service.getTasksByTitle(title);
        //BaseTask taskToUpdate = service.getTasksByTitle(title);
        //if (taskToUpdate == null) {
          //  System.out.println("A tarefa não pode ser atualizada, pois a lista está vazia");
          //  return;
        //}

        //BaseTask taskToUpdate = tasks.get(0);
       // System.out.println("Digite o novo título para a sua tarefa");
       // String newTitle = scanner.nextLine();

       // if(newTitle.isEmpty()){
           // System.out.println("O título não pode ser vazio");
       // } else {
       // boolean isSameTitle = taskToUpdate.getTitle().equals(newTitle);


      //  if (isSameTitle) {
        //    System.out.println("Você está tentando atualizar um título com o mesmo nome do título que já está armazenado");
       // } else {
           // taskToUpdate.setTitle(newTitle);
        //    service.updateTask(taskToUpdate);
         //   System.out.println("A tarefa foi atualiza com sucesso");
      //  }
  //  }


        //taskToUpdate.setTitle(newTitle);
        //service.updateTask(taskToUpdate);
       // System.out.println("A tarefa foi atualizada com sucesso!");
    //if(tasks.isEmpty()){
    // System.out.println("A tarefa não foi encontrada");
    // } else{
    // this.service.updateTask(taskToUpdate);
    // System.out.println("A tarefa foi atualizada com sucesso!");

    // List<BaseTask> tasks = this.service.getTasksByTitle(title);
    //if (tasks.isEmpty()) {
    // System.out.println("A tarefa não pode ser encontrada");
    //return;
    // } else {

    //  this.service.updateTask(title);
    //  System.out.println("A tarefa foi atualizada com sucesso!");
    //  }

    //System.out.println("Informe o título da nova tarefa a ser incluída: ");
    // String newTitle = scanner.nextLine();

    // System.out.println("Informe a descrição da nova tarefa a ser incluída: ");
    // String newDescription = scanner.nextLine();

    //  System.out.println("Informe a data para realização da nova tarefa a ser incluída: ");
    //  String deadlineStr = scanner.nextLine();

    //  Date newDeadline = new Date();
    //  LocalDate deadline; //variável declarada

    //  try {
    //   deadline = LocalDate.parse(deadlineStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    //  } catch (DateTimeParseException e) {
    //     System.out.println("A data digitada é inválida");
    //return;
    //  }

    //Date newDeadlineDate = Date.from(newDeadline.atStartOfDay(ZoneId.systemDefault()).toInstant());

    // tasks.get(0).setTitle(newTitle);
    //  tasks.get(0).setDescription(newDescription);
    // tasks.get(0).setDeadline(Date.from(deadline.atStartOfDay(ZoneId.systemDefault()).toInstant()));

    //  service.updateTask(tasks.get(0));
    //  System.out.println("A tarefa foi removida");
    //   }

    private List<BaseTask> listTasks() {

        //this.scanner = new Scanner(System.in);

        List<BaseTask> tasks = service.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("A lista de tarefas está vazia");
        } else {
            System.out.println("Lista de tarefas por ordem: ");
            for (BaseTask task : tasks) {
                System.out.println("Título da tarefa: " + task.getTitle());
                System.out.println("Descrição da tarefa: " + task.getDescription());
                System.out.println("Data para conclusão da tarefa (dd/MM/aaaa): " + task.getDeadline());
            }
        }
        return tasks;
    }
}

