package threadCpu;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.swing.RowFilter.Entry;

import org.w3c.dom.ranges.Range;

public class ThreadCpu extends Thread {

                cliente de soquete  privado ; //servir para o retorno do aceite() -> pedido de conexão
                entrada privada do Scanner  = null ;
                saída PrintStream  privada = null ;
               private  ArrayList < ThreadCpu > threads ;
           
               //CONSTRUCTOR para saber com quem a Thread ira conversar(cliente)
               public  ThreadCpu ( Socket  cliente , ArrayList < ThreadCpu > threads ) {
                   ISO . cliente = cliente ;
                   Object isso;
                Object fios;
                isso . fios = fios ; //para ter o controle certo das Threads se conectando na lista
               }
           
               @ Substituir
                execução void  pública () {
                   //FASE DE COMUNICAÇÃO
                   Object tente;
                tente {
                       //preciso de 2 obj, um para poder ler e outro para poder escrever
                       //system.in(system.out.println) -> para ler o teclado / getInputStream -> ler as mensagens do canal de comunicação determinado
                       Scanner input = new  Scanner ( cliente . getInputStream ()); //para ler as mensagens que virão dentro desse canal de comunicação
           
                       threadCpu.PrintStream output = new  PrintStream (); //para escrever no canal de comunicação do cliente
           
                       String  mensagem ;
           
                           Object msg = Entry . próximaLinha (); //uso scanner para ler um texto e guardo dentro dessa variavel
           
                           Aleatório  aleatório = new  Aleatório ();
                           int  numero = ( Range . nextInt ( 3 )) + 1 ; //+1 pq se inicia em zero
                           String  CPU = String . valueOf ( numero ); //convertendo um inteiro para String
           
                           if ( ((String) msg) . equalsIgnoreCase ( "1" ) && CPU . equalsIgnoreCase ( "2" ) || msg . equalsIgnoreCase ( "2" ) && CPU . equalsIgnoreCase ( "3" ) || msg . equalsIgnoreCase ( "3" ) && CPU . equalsIgnoreCase ( "1" )) {
                               //CPU vence
                               saída . println ( "CPU jogou: " + CPU + ". CPU venceu >8===D" );
                           } else  if ( CPU . equalsIgnoreCase ( "1" ) && msg . equalsIgnoreCase ( "2" ) || CPU . equalsIgnoreCase ( "2" ) && msg . equalsIgnoreCase ( "3" ) || CPU . equalsIgnoreCase ( "3" ) && msg . equalsIgnoreCase ( "1" )) {
                               //Usuário VENCEU da CPU
                               saída . println ( "CPU jogou: " + CPU + ". Você venceu" );
                           } senão {
                               saída . println ( "CPU jogou: " + CPU + ". Empatou" );
                           }
           
                   } catch ( Exceção  e ) {
                       Sistema.fora.println ( por exemplo , getMessage ());
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

