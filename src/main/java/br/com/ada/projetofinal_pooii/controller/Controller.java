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

    public void run(){
        System.out.println("Bem-vindo ao gerenciador de tarefas Ada Task!");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Digite o número desejado conforme a tarefa que pretende realizar:");
            System.out.println("1. Adicionar uma tarefa");
            System.out.println("2. Remover uma tarefa");
            System.out.println("3. Atualizar uma tarefa");
            System.out.println("4. Listar todas as tarefas");
            System.out.println("5. Sair do programa");

            int option = scanner.nextInt();

            if(option < 1 || option > 5){
                System.out.println("Opção inválida. Digite um número de 1 a 5");
                continue;
            }

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

        private void addTask(){

            System.out.println("Informe o título da sua tarefa: ");
            //Scanner scanner = new Scanner(System.in);
            String title = this.scanner.nextLine();

            System.out.println("Informe a descrição da sua tarefa: ");
            String description = this.scanner.nextLine();

            System.out.println("Informe a data para realizar a sua tarefa: ");
            String deadlineStr = this.scanner.nextLine(); //

            LocalDate deadline;

            try{
                deadline = LocalDate.parse(deadlineStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("O formato da data é inválido!");
                return;
            }
            //ver aq
            //Date deadline = new Date();
            BaseTask task = new PersonalTask(title, description, Date.from(deadline.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            //service.addTask(task);
            this.service.addTask(task);

            System.out.println("A tarefa foi adicionada com sucesso!");
        }

        private void removeTask(){

            System.out.println("Informe o título da tarefa que deseja remover da lista: ");
            //Scanner scanner = new Scanner(System.in);
            String title = this.scanner.nextLine();

            if(title.isEmpty()){
                System.out.println("Digite um título para a sua tarefa");
                return;
            }
            //Task task = new Task("","", null);
            //task.setTitle(title);


            List<BaseTask> tasks = this.service.getTasksByTitle(title);
            if (tasks.isEmpty()) {
                System.out.println("A tarefa não pode ser encontrada");
                return;
            }

            //service.removeTask(tasks.get(0));
            for(BaseTask task : tasks) {
                this.service.removeTask(task);
            }
            System.out.println("A tarefa foi removida!");
        }

        private void updateTask(){

            System.out.println("Informe o título da tarefa a ser atualizada: ");
            //Scanner scanner = new Scanner(System.in);
            String title = this.scanner.nextLine();

            List<BaseTask> tasks = service.getTasksByTitle(title);
            if (tasks.isEmpty()) {
                System.out.println("A tarefa não pode ser encontrada");
                return;
            }

            System.out.println("Informe o título da nova tarefa a ser incluída: ");
            String newTitle = scanner.nextLine();

            System.out.println("Informe a descrição da nova tarefa a ser incluída: ");
            String newDescription = scanner.nextLine();

            System.out.println("Informe a data para realização da nova tarefa a ser incluída: ");
            String deadlineStr = scanner.nextLine();

            //Date newDeadline = new Date();
            LocalDate deadline = null; //variável declarada

            try {
                deadline = LocalDate.parse(deadlineStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("A data digitada é inválida");
                return;
            }

            //Date newDeadlineDate = Date.from(newDeadline.atStartOfDay(ZoneId.systemDefault()).toInstant());

            tasks.get(0).setTitle(newTitle);
            tasks.get(0).setDescription(newDescription);
            tasks.get(0).setDeadline(Date.from(deadline.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            service.updateTask(tasks.get(0));
            System.out.println("A tarefa foi removida");
        }

        private void listTasks(){

            this.scanner = new Scanner(System.in);

            List<BaseTask> tasks = this.service.getTasks();

            if(tasks.isEmpty()){
                System.out.println("A lista de tarefas está vazia");
                return;
            }

            System.out.println("Lista de tarefas por ordem: ");
            for(BaseTask task : tasks){
                System.out.println("Título da tarefa: " + task.getTitle());
                System.out.println("Descrição da tarefa: " + task.getDescription());
                System.out.println("Data para conclusão da tarefa (dd/MM/aaaa): " + task.getDeadline());
            }
        }
    }


