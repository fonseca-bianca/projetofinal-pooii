package br.com.ada.projetofinal_pooii.domain;

import java.util.Date;

public class WorkTask extends BaseTask{
    public WorkTask(){

    }

    public WorkTask(String title, String description, Date deadline){
        super(title, description, deadline);
    }
}
