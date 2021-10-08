# Clone do Reddit (Spring + Angular)
Projeto focado em criar um clone da aplicação Reddit utilizando Springboot + Angular para aperfeicoar as habilidades de desenvolvimento fullstack.
Para o desenvolvimento do projeto será utilizado a metotologia de GitFlow para organização das atividades e implemetações.

## Tecnologias

- Spring Boot
- Spring MVC
- Spring Security com JWT
- Spring Data JPA com MySQL
- Angular 8

## Modelo do Banco de Dados

![DB-Schema](https://user-images.githubusercontent.com/43246064/135918585-5301262b-cf27-4fef-a648-46cc4f052d41.png)

## Fluxo de autenticação

### Fluxo do JWT

![Login-Flow](https://user-images.githubusercontent.com/43246064/136584398-94827bd5-0cf8-483b-8099-4559d179c40e.png)

1. Começa com o Cliente mandando uma solicitação de login ao servidor.
2. O servidor verifica as credenciais vindas do usuário, se as credenciais estiverem corretas é criado um JSON Web Token (JWT).
3. Ele responde com uma mensagem de sucesso (HTTP Status 200) e o JWT.
4. O cliente usa esse JWT em todas as solicitações subsequentes, fornecendo esse JWT como um cabeçalho de autorização.
5. Quando o servidor recebe uma solicitação em um endpoint seguro, ele verifica o JWT e valida se o token foi gerado e asssinado pelo servidor
6. Se a validação der certo, o servidor responde de acordo com o que foi requisitado pelo cliente.

### Fluxo de autenticação do Spring Security

![Spring-Login-Flow](https://user-images.githubusercontent.com/43246064/136586049-dc62b611-dd9a-46d6-a42c-fa567f5bd173.png)

- A solicitação de login é recebida pelo AuthenticationController e passada para a classe AuthService.
- Esta classe cria um objeto do tipo UserNamePassowordAuthenticationToken que encapsula o username e o password fornecido pelo usuário como parte da solicitação de login.
- Em seguida isso é passado para o AuthenticationManager que cuida da parte da autenticação usando Spring Security. Ele implementa muitas funcionalidades em segundo plano e fornece um boa API que podemos usar.
- O AuthenticationManager interage com uma interface chamada UserDetailsService, essa interface como o nome sugere vai lidar com os dados do usuário. Existem diversas implementações que podem usadas, tudo vai depender do tipo de autenticação que iremos utilizar. Alguns exemplos de autenticações suportadas são: autenticação na memória, autenticação de banco de daods ou autenticação baseada em LDAP.
- Utilizaremos a autenticação por banco de dados nesse projeto então é ela que será implementada, passando o UserDetails para o AuthenticationManager.
- O AuthenticationManager verifica as credenciais, se eles corresponderem, é criado um objeto do tipo Authentication e retorna para a classe AuthService.
- Em seguida criamos o JWT e respondemos ao usuário.



