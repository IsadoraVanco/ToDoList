package br.com.isadora.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.isadora.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * Será a classe responsável pelo filtro
 * de autenticação das tarefas. Toda requisição irá
 * passar pelo filtro antes de ser adicionada no banco.
 */
@Component //Definimos que o Spring deve gerenciar. OBS: restcontroller->controller->component (classe mais "genérica")
public class FilterTaskAuth extends OncePerRequestFilter{

    @Autowired
    private IUserRepository userRepository;

    @Override
    /*
    * Aqui criamos o filtro. Request = o que estamos recebendo e ainda passará pela controller,
    * response = o que estamos enviando e vai para o usuário
    */
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        //Recebe o path (URL)
        var servletPath = request.getServletPath(); 
        
        //Faz a autenticação apenas se a URL for a de tarefas
        if(servletPath.equals("/tasks/")){
            //Autenticando (recebe usuário e senha digitados)
    
            //Recebe a autorização inteira do request 
            var authorization = request.getHeader("Authorization");
            //Retira a validação "Basic" e o espaço (trim()). Sobra apenas o código retornado na autenticação
            var authEncoded = authorization.substring("Basic".length()).trim();
            //Decodifica o código de autenticação, na base 64
            byte[] authDecoded = Base64.getDecoder().decode(authEncoded);
            //Converte o código de bytes em String
            var authString = new String(authDecoded);
            //Separa a string que por padrão é no formato usuario:senha
            String[] credentials = authString.split(":");
            //Informações separadas
            var username = credentials[0];
            var password = credentials[1];
            
            System.out.println("***** AUTENTICAÇÃO *****");
            System.out.printf("Autorização total: %s %nCódigo: %s %nDecodificado: %s %n", authorization, authEncoded, authDecoded);
            System.out.printf("Convertido em string: %s %nUsername: %s %nSenha: %s %n", authString, username, password);
            System.out.println("*************************");
    
            //Validando o usuário 
            
            //Procura no banco de dados o username passado
            var user = this.userRepository.findByUsername(username);
            
            if(user == null){ //Não existe no banco
                System.out.println("=> Conta não encontrada");
                response.sendError(401); //401 = UNAUTHORIZED (o usuário não tem autorização)
            }else{
                //Validando a senha
    
                //Compara a senha descriptografada com a criptografada do banco
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
    
                if(passwordVerify.verified){ //Se a senha for correta
                    //O atributo idUser receberá o id que está cadastrado no banco
                    request.setAttribute("idUser", user.getId());
                    System.out.println("=> Senha correta. A autenticação passou pelo filtro");
                    filterChain.doFilter(request, response);
                }else{
                    System.out.println("=> Senha incorreta");
                    response.sendError(401); //401 = UNAUTHORIZED (o usuário não tem autorização)
                }
            }
        }else{ //Vida que segue ;)
            filterChain.doFilter(request, response);
        }
    }
}
