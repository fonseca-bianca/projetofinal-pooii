package br.com.ada.projetofinal_pooii.controller;
import br.com.ada.pooii_bianca.projetoPOOII.domain.BaseTask;
import br.com.ada.pooii_bianca.projetoPOOII.domain.PersonalTask;
import br.com.ada.pooii_bianca.projetoPOOII.domain.StudyTask;
import br.com.ada.pooii_bianca.projetoPOOII.domain.WorkTask;
import br.com.ada.pooii_bianca.projetoPOOII.repository.TaskRepository;
import br.com.ada.pooii_bianca.projetoPOOII.service.TaskService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//NÃO herda de BaseTask, pois TaskRepository é a class de lógica dos negócios
public class TaskController {
    private TaskService<BaseTask> service;

    public TaskController(){
        this.service = new TaskService<>();
    }

    //Criando método que irá processar a entrada do usuário:
    //método 'processInput': vai dividir em partes a entrada do usuário
    //parte 1: comando do usuário
    //parte 2: argumentos do comando
    public void processInput(String input){
        String[] parts = input.split("");
        String command = parts[0];

        //Switch case:
        //com base no comando dado pelo usuário, irá chamar o Método condizente lá na Camada de Serviço pra promover o comando
        switch (command.toLowerCase()){
            //adiciona uma tarefa
            case "adicionar":
                BaseTask task = createTask(parts);
                if(task != null){
                    service.addTask(task);
                    System.out.println("A tarefa foi adicionada com sucesso!");
                }
                break;

            //remove uma tarefa
            case "remover":
                int indexToRemove = Integer.parseInt(parts[1]);
                service.removeTask(service.getTask(indexToRemove));
                System.out.println("A tarefa foi removida!");
                break;

            //atualiza uma tarefa
            case "atualizar":
                int indexToUpdate = Integer.parseInt(parts[2]);
                BaseTask updatedTask(service.createTask(parts));
                if(updatedTask != null){
                    service.updateTask(indexToUpdate, updatedTask);
                    System.out.println("Tarefa atualizada com sucesso!");
                }
                break;

            //busca uma tarefa
            case "buscar":
                int indexToGet = Integer.parseInt(parts[3]);
                BaseTask retrievedTask = service.getTask(indexToGet);
                System.out.println("A tarefa foi buscada" + retrievedTask.toString()); //'retriedvedTask...' é chamado pra mostrar os detalhes da tarefa que foi buscada
                break;

            default:
                System.out.println("Comando inválido para os parâmetros do programa.");
        }
    }

    //Criando método pra criar uma tarefa com base nos dados de entrada do usuário com base no scanner:
    private BaseTask createTask(String[] parts) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título da tarefa que deseja realizar: ");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa que deseja realizar: ");
        String description = scanner.nextLine();

        System.out.println("Digite o prazo para criar a tarefa no formato (dd/MM/yyyy): ");
        String deadlineStr = scanner.nextLine();
        Date deadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadlineStr);


        //Criando uma tarefa com base no Tipo:
        BaseTask task;
        switch (parts[1].toLowerCase()){
            case "pessoal":
                System.out.println("Digite uma tarefa pessoal: ");
                String personalNote = scanner.nextLine();
                task = new PersonalTask(title, description, deadline, personalkNote);
                break;

            case "trabalho":
                System.out.println("Digite uma tarefa profissional: ");
                String workNote = scanner.nextLine();
                task = new WorkTask(title, description, deadline, workNote);
                break;

            case "estudo":
                System.out.println("Digite uma tarefa de estudo: ");
                String studyNote = scanner.nextLine();
                task = new StudyTask(title, description, deadline, studyNote);
                break;

            default:
                System.out.println("O tipo de tarefa digitada é inválido!");
                task = null;
        }
        return task; //retorne a tarefa
    }
}