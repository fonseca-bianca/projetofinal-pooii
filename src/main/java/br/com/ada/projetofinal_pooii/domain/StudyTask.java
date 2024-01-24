package br.com.ada.projetofinal_pooii.domain;

import java.util.Date;

public class StudyTask extends BaseTask{
    private String studyNote;

    //Construtor, getters e setters:


    public StudyTask(String title, String description, Date deadline, String studyNote) {
        super(title, description, deadline);
        this.studyNote = studyNote;
    }

    public String getStudyNote() {
        return studyNote;
    }

    public void setStudyNote(String studyNote) {
        this.studyNote = studyNote;
    }
}
