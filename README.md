Projeto Final de POO II referente ao curso de Java do programa Devas da Ada + B3. 
Aqui será explicado como foram montadas as Camadas do projeto.
OBS.: o projeto não trabalha com BD, por isso o uso de um console interface.

# Camadas 
# Domain: 
  Vai definir estruturas e regras de negócios das tarefas.Nela deverá conter as Classes BaseTask, PersonalTask, WorkTask e StudyTask, essas classes representam as tarefas e o tipo de cada tarefa.
  
->  Classe BaseTask:
-    BaseTask é a class que faz a representação de dados (Domínio = tarefa: título, descrição e prazo);
-    é Abstract, pois é usada como base para a criação das subclasses PersonalTask, StudyTask e WorkTask, que representam diferentes tipos de tarefas;
-    P. da Substituição de Liskov: suas Subclasses podem ser usadas de forma independente em Métodos que esperam a 
Classe BaseTask.

->	 Classe PersonalTask:
-    extends BaseTask;
-    herda todos os atributos e métodos da classe BaseTask.
    
->	Classe StudyTask:
-    extends BaseTask;
-    herda todos os atributos e métodos da classe BaseTask.
     
->	Classe WorkTask:
-    extends BaseTask;
-    herda todos os atributos e métodos da classe BaseTask.
  
# Repository: 
  Em respeito ao SOLID (no que tange ao Princípio da Responsabilidade Única), a Camada Repository irá se comunicar com a Camada Service que irá se comunicar com a Camada Controller. Fornece a interface pra armazenamento e recuperação das tarefas.

->	Classe Repository:
-    oferece os seguintes métodos: adicionar, remover, atualizar e buscar as tarefas;
-    gerencia a persistência das tarefas na memória do programa (já que não há interação com Banco de Dados);
-    P. Responsabilidade Única: responsabilidade bem definida, pois persiste os dados.
     
->  Classe RepositoryConcreta:
-    fornece uma implementação concreta da interface RepositoryInterface. É responsável por armazenar e gerenciar as tarefas do sistema;
-    implementa as operações básicas de CRUD para as tarefas. Fornece uma forma concreta de armazenar e gerenciar as tarefas no sistema e é essencial para a persistência de dados, porque permite que as tarefas sejam salvas e recuperadas posteriormente.

->  Interface RepositoryInterface:
-    P. da Segregação de Interfaces: na Interface há a separação do contrato de persistência das tarefas de sua implementação;
-    É Genérica: permite: Reutilização: a mesma interface pode ser usada para diferentes tipos de repositórios; Flexibilidade: o código usa a interface pode trabalhar com diferentes tipos de tarefas sem a necessidade de alterações em cada uma; Manutenibilidade: o código fica mais fácil de manter, pois mudanças nos tipos e nas tarefas podem ser feitas sem afetar a interface.

# Service: 
  Implementa a lógica e interage com o pacote Repository para que haja a persistência dos dados.
  
-> Classe Service:
-   interage com o package Repository pra realizar as operações CRUD em tarefas (opções de 1 a 5);
-   implementa a lógica adicional das tarefas (ex.: pesquisar as tarefas por título);
-   P. Responsabilidade Única: responsabilidade bem definida, pois faz a lógica do negócio;
-   P. da Inversão de Dependência: essa classe depende da interface RepositoryInterface, porém não da implementação concreta dela, mas permite a flexibilidade no armazenamento dos dados inseridos pelo usuário.
  
# Controller: 
  Responsável por gerenciar a interação do usuário com o sistema via console. Coloca as perguntas na tela pro usuário responder e, mediante as respostas, vai chamar a camada Repository com o método da tarefa que o usuário chamar. Nessa camada, serão processados os comandos do usuário e utilizará a camada Service pra executar a tarefa.
  
-> Classe Controller:
-   interage com o usuário e solicita as ações desejadas com base nas opções de 1 a 5;
-   delega o gerenciamento das tarefas à Classe Service;
-   P. Responsabilidade Única: responsabilidade bem definida, pois interage com o usuário.
  
-> Classe Main: 
-   inicia o aplicativo e cria um objeto controller.
   
-> Classe Task:
-   representa uma tarefa genérica;
-   essa Classe herda todos os atributos e métodos da classe BaseTask;
-   ela possui os atributos e métodos básicos necessários para definir uma tarefa.

# Obs.:
-> P. do Open-Closed:
- novos tipos de tarefas podem ser adicionados sem modificar o código existente, em razão da estrutura de herança presente no código.
