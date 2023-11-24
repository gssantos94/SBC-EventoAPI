
<strong>Funcionalidades do Sistema.</strong>

O sistema permite que o Administrador cadastre eventos e edições anuais, autorizando usuários como Organizadores. Os Organizadores podem fornecer informações sobre a edição, incluindo chamada de trabalhos, prazos, informações de inscrições e lista de membros da organização.
Os Organizadores também podem cadastrar atividades e espaços para compor a programação do evento. Os usuários podem visualizar essas informações de forma anônima no site do evento.
Os usuários registrados podem favoritar atividades, recebendo notificações diárias sobre as atividades marcadas. O sistema oferece páginas específicas para visualização da programação, chamada de trabalhos, inscrições e organização.

<details>
<summary><strong>Endpoints da API</strong></summary>

### Atividades
- **GET /atividades:** Obter todas as atividades.
- **POST /atividades:** Criar uma nova atividade.
- **GET /atividades/{id}:** Obter detalhes de uma atividade específica.
- **PUT /atividades/{id}:** Atualizar informações de uma atividade.
- **DELETE /atividades/{id}:** Excluir uma atividade.

### Edições
- **GET /edicoes:** Obter todas as edições.
- **POST /edicoes:** Criar uma nova edição.
- **GET /edicoes/{id}:** Obter detalhes de uma edição específica.
- **PUT /edicoes/{id}:** Atualizar informações de uma edição.
- **DELETE /edicoes/{id}:** Excluir uma edição.
- **POST /edicoes/organizador:** Definir um organizador para uma edição.

### Espaços
- **GET /espacos:** Obter todos os espaços disponíveis.
- **POST /espacos:** Criar um novo espaço.
- **GET /espacos/{id}:** Obter detalhes de um espaço específico.
- **PUT /espacos/{id}:** Atualizar informações de um espaço.
- **DELETE /espacos/{id}:** Excluir um espaço.

### Eventos
- **GET /eventos:** Obter todos os eventos.
- **POST /eventos:** Criar um novo evento.
- **GET /eventos/{id}:** Obter detalhes de um evento específico.
- **PUT /eventos/{id}:** Atualizar informações de um evento.
- **DELETE /eventos/{id}:** Excluir um evento.
- **GET /eventos/{path:[a-zA-Z0-9-]*[a-zA-Z][a-zA-Z0-9-]*}:** Obter detalhes de um evento pelo caminho.

### Usuários
- **GET /usuarios:** Obter todos os usuários.
- **POST /usuarios:** Criar um novo usuário.
- **GET /usuarios/{id}:** Obter detalhes de um usuário específico.
- **PUT /usuarios/{id}:** Atualizar informações de um usuário.
- **DELETE /usuarios/{id}:** Excluir um usuário.

</details>
<details>
   
<summary><strong>Como Usar a API</strong></summary>

1. **Obter Todas as Atividades:**
   - Método: GET
   - Endpoint: `/atividades`

2. **Criar Nova Atividade:**
   - Método: POST
   - Endpoint: `/atividades`
   - Payload: JSON com informações da atividade.

3. **Obter Detalhes de uma Atividade Específica:**
   - Método: GET
   - Endpoint: `/atividades/{id}`

4. **Atualizar Informações de uma Atividade:**
   - Método: PUT
   - Endpoint: `/atividades/{id}`
   - Payload: JSON com informações atualizadas.

5. **Excluir uma Atividade:**
   - Método: DELETE
   - Endpoint: `/atividades/{id}`

6. **Obter Todas as Edições:**
   - Método: GET
   - Endpoint: `/edicoes`

7. **Criar Nova Edição:**
   - Método: POST
   - Endpoint: `/edicoes`
   - Payload: JSON com informações da edição.

8. **Obter Detalhes de uma Edição Específica:**
   - Método: GET
   - Endpoint: `/edicoes/{id}`

9. **Atualizar Informações de uma Edição:**
   - Método: PUT
   - Endpoint: `/

edicoes/{id}`
   - Payload: JSON com informações atualizadas.

10. **Excluir uma Edição:**
    - Método: DELETE
    - Endpoint: `/edicoes/{id}`

11. **Definir Organizador para uma Edição:**
    - Método: POST
    - Endpoint: `/edicoes/organizador`
    - Payload: JSON com ID da edição e do organizador.

12. **Obter Todos os Espaços:**
    - Método: GET
    - Endpoint: `/espacos`

13. **Criar Novo Espaço:**
    - Método: POST
    - Endpoint: `/espacos`
    - Payload: JSON com informações do espaço.

14. **Obter Detalhes de um Espaço Específico:**
    - Método: GET
    - Endpoint: `/espacos/{id}`

15. **Atualizar Informações de um Espaço:**
    - Método: PUT
    - Endpoint: `/espacos/{id}`
    - Payload: JSON com informações atualizadas.

16. **Excluir um Espaço:**
    - Método: DELETE
    - Endpoint: `/espacos/{id}`

17. **Obter Todos os Eventos:**
    - Método: GET
    - Endpoint: `/eventos`

18. **Criar Novo Evento:**
    - Método: POST
    - Endpoint: `/eventos`
    - Payload: JSON com informações do evento.

19. **Obter Detalhes de um Evento Específico:**
    - Método: GET
    - Endpoint: `/eventos/{id}`

20. **Atualizar Informações de um Evento:**
    - Método: PUT
    - Endpoint: `/eventos/{id}`
    - Payload: JSON com informações atualizadas.

21. **Excluir um Evento:**
    - Método: DELETE
    - Endpoint: `/eventos/{id}`

22. **Obter Detalhes de um Evento pelo Caminho:**
    - Método: GET
    - Endpoint: `/eventos/{path}`

23. **Obter Todos os Usuários:**
    - Método: GET
    - Endpoint: `/usuarios`

24. **Criar Novo Usuário:**
    - Método: POST
    - Endpoint: `/usuarios`
    - Payload: JSON com informações do usuário.

25. **Obter Detalhes de um Usuário Específico:**
    - Método: GET
    - Endpoint: `/usuarios/{id}`

26. **Atualizar Informações de um Usuário:**
    - Método: PUT
    - Endpoint: `/usuarios/{id}`
    - Payload: JSON com informações atualizadas.

27. **Excluir um Usuário:**
    - Método: DELETE
    - Endpoint: `/usuarios/{id}`

</details>

<details>
<summary><strong>Desenvolvedor</strong></summary>

- Nome: Gustavo da Silva Santos
- E-mail: gssantos@id.uff.br
- Linkedin: [[gs-santos](https://www.linkedin.com/in/gs-santos/)]

</details>
