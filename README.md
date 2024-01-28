Projeto Final de POO II referente ao curso de Java do programa Devas da Ada + B3. 
Aqui será explicado como foram montadas as Camadas do projeto.

Camadas:
* Domain: vai definir estruturas e regras de negócios das tarefas.Nela deverá conter as Classes BaseTask, PersonalTask, WorkTask e StudyTask.
-  Classe BaseTask:
-    BaseTask é a class que faz a representação de dados (Domínio = tarefa: título, descrição e prazo);
-	Classe PersonalTask:
-    extends BaseTask
-	Classe StudyTask:
-    extends BaseTask
-	Classe WorkTask:
-    extends BaseTask
- 
*	Repository:
-	Classe TaskRepository:
-    responsavel pela "persistência" dos dados na lista. Essa camada vai oferecer os métodos para: adicionar, remover, atualizar e buscar as tarefas. Nela poderá constar a Interface.
camada service (serviço): será resposável pela lógica da aplicação (ex.: operações de manipulação das tarefas). Essa camada irá interagir com a camada Repository pra realizar as operações de dados. Ela irá buscar a tarefa por horário.
  
*	Service:
- Classe Main
  
* Controller: responsável por gerenciar a interação do usuário com o sistema via console. Coloca as perguntas na tela pro usuário responder e, mediante as respostas, vai chamar a camada Repository com o método da tarefa que o usuário chamar. Nessa camada, serão processados os comandos do usuário e utilizará a camada Service pra executar a tarefa.
- Classe TaskController:
-    NÃO herda de BaseTask, pois TaskRepository é a class de lógica dos negócios

* Console Interface:
-    interface simples de linha de comando pra ter interação do programa com o usuário.
