package br.com.ada.projetofinal_pooii.controller;

import br.com.ada.projetofinal_pooii.domain.BaseTask;

import java.time.LocalDate;
import java.util.Date;

public class Task extends BaseTask {
    public Task(String title, String description, Date deadline) {
        super(title, description, deadline);
    }
}
