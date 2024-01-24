Projeto Final de POO II referente ao curso de Java do programa Devas da Ada + B3. 
Aqui será explicado como foram montadas as Camadas do projeto.

Camadas:
* Domain:(vai definir estruturas e regras de negócios das tarefas)
-  Classe BaseTask:
-    BaseTask é a class que faz a representação de dados (Domínio = tarefa: título, descrição e prazo)
-	Classe PersonalTask:
-    extends BaseTask
-	Classe StudyTask:
-    extends BaseTask
-	Classe WorkTask:
-    extends BaseTask
- 
*	Repository:
-	Classe TaskRepository:
-    com métdo Generics do tipo "T" que extends (herda) de BaseTask atributos e métodos.
  
*	Service:
- Classe Main
  
* Controller:
- Classe TaskController:
-    NÃO herda de BaseTask, pois TaskRepository é a class de lógica dos negócios
-    classe private com Generics : AQUI DIZER PORQUE
