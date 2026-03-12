# Verbum Api

Vebum é uma plataforma de publicação de artigos inspirada em aplicações como o Medium. O objetivo da aplicação é permitir que pessoas compartilhem conhecimento, publiquem conteúdos e interajam com outros autores por meio de comentários, curtidas e seguidores.

A plataforma foi construída como uma API backend em Java utilizando Spring Boot, com foco em organização de código, separação de responsabilidades e aplicação de boas práticas de arquitetura de software.

# Sobre o projeto

O Vebum foi desenvolvido como um projeto de estudo e prática de arquitetura de software, simulando o funcionamento de uma plataforma moderna de conteúdo. Dentro da plataforma, usuários podem publicar artigos, acompanhar outros autores e interagir com conteúdos da comunidade. A proposta é criar um ambiente simples e direto para leitura e produção de conteúdo, onde cada usuário possui seu próprio perfil e pode construir sua rede de pessoas seguidas. A aplicação também implementa interações comuns em plataformas sociais de conteúdo, como salvar artigos para leitura posterior, curtir publicações e comentar em discussões.

---

# Principais funcionalidades
## Publicação de artigos
Usuários podem criar e publicar artigos na plataforma. Cada publicação fica associada ao autor e pode ser visualizada por outros usuários.




## Sistema de seguidores
Usuários podem seguir outros autores para acompanhar seus conteúdos e atualizações.




## Interações com artigos
A plataforma permite diversas formas de interação com o conteúdo:
- Curtir artigos
- Salvar artigos para leitura posterior
- Comentar em publicações




## Feed de conteúdo
Os usuários podem visualizar artigos publicados na plataforma e acompanhar conteúdo de autores que seguem.

---

# Arquitetura
A aplicação foi construída seguindo os princípios da Clean Architecture, com o objetivo de manter o domínio da aplicação desacoplado de frameworks e detalhes de infraestrutura.
Essa abordagem permite que as regras de negócio permaneçam isoladas das camadas externas, facilitando manutenção, testes e evolução do sistema.
A estrutura do projeto é organizada em camadas responsáveis por diferentes responsabilidades da aplicação, separando domínio, casos de uso, infraestrutura e entrada da API.

---




# Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- JWT Authentication
- OAuth - Google
- PostgreSQL
- RabbitMQ
- Docker


# Modelagem do banco 

