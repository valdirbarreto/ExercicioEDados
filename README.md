# ExercicioEDados
Sistema Pangeia de gerenciamento de locadoras
Informações sobre o Sistema
•	O sistema foi desenvolvido a partir do anterior que só atendia uma loja. Foi criada uma camada superior e a classe Loja que descreve cada uma das lojas.
  o	Não há diferença entre filiais e matriz do ponto de vista de processamento.
  o	Não existem totalizações gerais de todas as lojas, só individuais.
•	O que identifica um cliente é seu número de telefone com DDD.
•	O que identifica um carro é sua placa. No aluguel o cliente escolhe o modelo (HB20, Civic, Corolla, etc).
•	Ao alugar um carro, mesmo que não seja o desejado, o cliente é retirado da fila de espera (se estiver nela, é claro).
•	Na devolução de um carro, se houver alguém na fila de espera pelo mesmo modelo, é impressa mensagem ao operador.
•	O log só é gravado na devolução do carro. Para que se tenha a informação de data e hora de entrada e saída juntas, sem precisar fazer uma busca nele.
•	Se um cliente vai alugar um carro e não está cadastrado (checagem pelo número de telefone com DDD) passa-se automaticamente para tela de cadastro.
•	Há 3 menus:
  o	O relativo a lojas (atual menu principal)
    	Listagem das lojas 
    	Seleção de loja para trabalhar (vai para o menu abaixo)
  o	O antigo menu principal (da aplicação anterior, de uma só loja)
    	Cadastramento e remoção de carros
    	Cadastramento de clientes
    	Aluguel e devolução de carros
    	Tornar carro indisponível ou disponível para aluguel (situação indisponível pode ser quando está alugado, em pane ou em revisão – não há diferenciação no programa)
    	Relatórios
  o	O menu de relatórios
    	Carros disponíveis (passíveis de serem alugados)
    	Carros disponíveis organizados por preço
    	Lista de espera de clientes
    	Carros alugados
    	Relatório de Movimentação (alugados já devolvidos)
    	Valor total das diárias dos alugados
    	Total de Carros e total de carros alugados e disponíveis

