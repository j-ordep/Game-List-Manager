## Modelo de domínio

![GameList](https://github.com/user-attachments/assets/51a0ba03-04f9-4e7b-8319-06f163bd9f08)

## Apresentação

O Game List Manager é um sistema CRUD desenvolvido para gerenciar listas personalizadas de jogos (ou qualquer outro tipo de relação entre objetos e grupos). O projeto permite organizar jogos em listas específicas, facilitando a categorização e a personalização. Cada jogo pode ser descrito por informações detalhadas, como título, gênero, ano de lançamento, plataformas, pontuação, imagens e descrições.

## Tecnologias utilizadas

- Java (Spring Boot)

- Spring Data JPA

- JPA(Java Persistence API)

- Hibernate(ORM)

- PostgreSQL

- Docker

- Postman

## Camadas estruturadas:

## Estrutura do Domínio / Observações 

- APIs RESTful para criar, consultar e atualizar jogos e listas.

- Organização de jogos em listas personalizadas, com a capacidade de definir posições específicas dentro de cada lista.

- O relacionamento entre jogos e listas é gerenciado por uma tabela intermediária chamada Belonging, onde tive que criar uma classe BelongingPK que encapsula os dois IDs, atributos que juntos formam a chave primária da entidade Belonging:

    - gameId (o ID do jogo)

    - listId (o ID da lista)
 
- Arquitetura limpa com entidadescom separação clara de responsabilidades:
  - *Controller*: Exposição das APIs REST.
  - *Service*: Contém a lógica de negócios.
  - *Repository*: Comunicação com o banco de dados.
  - *DTOs*: Transferência de dados otimizada para evitar exposição direta de entidades.
