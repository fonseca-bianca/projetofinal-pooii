package br.com.ada.projetofinal_pooii.controller;

import br.com.ada.projetofinal_pooii.controller.Controller;
import br.com.ada.projetofinal_pooii.repository.Repository;
import br.com.ada.projetofinal_pooii.service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Service service = new Service(repository);
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(scanner);
        controller.run();
    }
}
