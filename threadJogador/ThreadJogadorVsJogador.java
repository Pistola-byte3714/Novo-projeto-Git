package threadJogador;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import threadCpu.Substituir;
import threadCpu.cliente;
import threadCpu.entrada;
import threadCpu.saída;

public class ThreadJogadorVsJogador extends Thread {
    
    cliente de soquete  privado ; //servir para o retorno do aceite() -> pedido de conexão
    entrada privada do Scanner  = null ;
    saída PrintStream  privada = null ;
   private  ArrayList < ThreadJogadorVsJogador > threads ;

   //CONSTRUCTOR para saber com quem a Thread ira conversar(cliente)
   public  ThreadJogadorVsJogador ( Socket  client , ArrayList < ThreadJogadorVsJogador > threads ) {
       isso . cliente = cliente ;
       isso . fios = fios ; //para ter o controle certo das Threads se conectando na lista
   }

   @ Substituir
    execução void  pública () {
       //FASE DE COMUNICAÇÃO
       Object tente;
    tente {
           //preciso de 2 obj, um para poder ler e outro para poder escrever
           //system.in(system.out.println) -> para ler o teclado / getInputStream -> ler as mensagens do canal de comunicação determinado
           input = new  Scanner ( cliente . getInputStream ()); //para ler as mensagens que virão dentro desse canal de comunicação

           threadCpu.PrintStream output = new  threadCpu.PrintStream ( cliente . getOutputStream ()); //para escrever no canal de comunicação do cliente

           String  msg1 ;
           String  nome1 ;
           String  msg2 ;
           String  nome2 ;

               msg1 = entrada . próximaLinha (); //uso scanner para ler um texto e guardo dentro dessa variavel
               nome1 = entrada . próximaLinha ();

               msg2 = entrada . próximaLinha ();
               nome2 = entrada . próximaLinha ();

               if ( msg1 . equalsIgnoreCase ( "1" ) && msg2 . equalsIgnoreCase ( "2" ) || msg1 . equalsIgnoreCase ( "2" ) && msg2 . equalsIgnoreCase ( "3" ) || msg1 . equalsIgnoreCase ( "3" ) && msg2 . equalsIgnoreCase ( "1" )) {
                   //CPU vence
                   saída . println ( "Jogador" + nome2 + "venceu!" );
               } else  if ( msg2 . equalsIgnoreCase ( "1" ) && msg1 . equalsIgnoreCase ( "2" ) || msg2 . equalsIgnoreCase ( "2" ) && msg1 . equalsIgnoreCase ( "3" ) || msg2 . equalsIgnoreCase ( "3" ) && msg1 . equalsIgnoreCase ( "1" )) {
                   //Usuário VENCEU da CPU
                   saída . println ( "Jogador" + nome1 + "venceu!" );
               } senão {
                   saída . println ( "Empatou" );
               }



       } catch ( Exceção  e ) {
           Sistema . fora . println ( por exemplo , getMessage ());
       }

       //FASE DE ENCERRAMENTO DA CONEXÃO
       tente {
           entrada . fechar ();
           cliente . fechar ();
       } catch ( Exceção  e ) {
           Sistema . fora . println ( por exemplo , getMessage ());
       }
       //quando o construtor cria um thread, ele ira passar como param um Socket
   }

}
