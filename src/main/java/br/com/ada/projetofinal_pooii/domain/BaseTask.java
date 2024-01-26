package br.com.ada.projetofinal_pooii.domain;

import java.util.Date;

public abstract class BaseTask {
    private String title;
    private String description;
    private Date deadline;

    public BaseTask(){

    }

    public BaseTask(String title, String description, Date deadline){
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    //getters e setters:
    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline(){
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
