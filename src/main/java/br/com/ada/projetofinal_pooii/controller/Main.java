package br.com.ada.projetofinal_pooii.controller;

import br.com.ada.projetofinal_pooii.controller.Controller;
import br.com.ada.projetofinal_pooii.repository.Repository;
import br.com.ada.projetofinal_pooii.service.Service;

public class Main {
    public static void main(String[] args) {

        //Service service = new Service(repository);

        Controller controller = new Controller();
        controller.run();
    }
}
