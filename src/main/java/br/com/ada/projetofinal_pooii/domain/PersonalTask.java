package br.com.ada.projetofinal_pooii.domain;

import java.util.Date;

public class PersonalTask extends BaseTask{
    public PersonalTask(){

    }

    public PersonalTask(String title, String description, Date deadline){
        super(title, description, deadline);
    }
}
