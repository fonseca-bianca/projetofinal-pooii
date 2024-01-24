package br.com.ada.projetofinal_pooii.domain;
//Camada Domain: vai definir estruturas e regras de negócios das tarefas

import java.util.Date;

//BaseTask é a class que faz a representação de dados (Domínio = tarefa: título, descrição e prazo)
//classe SUPER:
public class BaseTask {
    private String title;
    private String description;
    private Date deadline;

    //Construtor, getters e setters:

    public BaseTask(String title, String description, Date deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
