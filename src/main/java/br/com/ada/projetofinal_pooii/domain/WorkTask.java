package br.com.ada.projetofinal_pooii.domain;

import java.util.Date;

public class WorkTask extends BaseTask{
    private String workNote;

    //Construtor, getters e setters:

    public WorkTask(String title, String description, Date deadline, String workNote) {
        super(title, description, deadline);
        this.workNote = workNote;
    }

    public String getWorkNote() {
        return workNote;
    }

    public void setWorkNote(String workNote) {
        this.workNote = workNote;
    }
}
