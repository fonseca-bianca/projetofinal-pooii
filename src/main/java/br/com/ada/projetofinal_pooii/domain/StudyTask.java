package br.com.ada.projetofinal_pooii.domain;

import java.util.Date;

public class StudyTask extends BaseTask{
    public StudyTask(){

    }

    public StudyTask(String title, String description, Date deadline){
        super(title, description, deadline);
    }
}
