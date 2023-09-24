import java.util.*;
/**
*Descrição
Neste desafio, você deve criar um programa em Java para realizar o monitoramento e análise de logs gerados na infraestrutura da AWS (Amazon Web Services). O programa receberá informações de eventos de diferentes serviços da AWS e realizará uma análise simples desses logs.

Entrada
Linha 1: A quantidade de logs a serem analisados;
Linhas Seguintes: Cada linha terá as informações de log de um determinado serviço AWS, no seguinte:
yyyy-MM-dd HH:mm:ss,{Nome do Serviço AWS},{Log do Evento Registrado Neste Serviço AWS}
Saída
O programa exibirá os resultados da análise, apresentando:

A quantidade de eventos específicos para cada log de serviço AWS lido na Entrada (em ordem de leitura):
Eventos por servico:
{Nome do 1º Serviço AWS}:{Quantidade de Logs do 1º Serviço AWS}
{Nome do 2º Serviço AWS}:{Quantidade de Logs do 2º Serviço AWS}
{Nome do Nº Serviço AWS}:{Quantidade de Logs do Nº Serviço AWS}
O serviço AWS que teve a maior* quantidade de eventos registrados:
Maior:{Nome do Serviço AWS}
O serviço AWS que teve a menor* quantidade de eventos registrados:
Menor:{Nome do Serviço AWS}
* Tenha como verdade que sempre teremos um serviço com maior incidência e outro com menor, ou seja, nunca teríamos um empate. Veja exemplos abaixo.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
1
2023-07-24 10:15:32,RDS,Database instance db-01a failed to start	Eventos por servico:
RDS:1
Maior:RDS
Menor:RDS
3
2023-07-24 10:15:32,EC2,Instance i-12345 started
2023-07-24 10:17:45,EC2,Instance i-67890 stopped
2023-07-24 10:20:11,S3,Bucket example-bucket created	Eventos por servico:
S3:1
EC2:2
Maior:EC2
Menor:S3
6
2023-07-24 10:15:32,EC2,Instance i-12345 started
2023-07-24 10:17:45,S3,Bucket example-bucket created
2023-07-24 10:20:11,EC2,Instance i-67890 stopped
2023-07-24 10:23:05,Lambda,Function example-function executed successfully
2023-07-24 10:25:39,S3,Object example.txt deleted from bucket example-bucket
2023-07-24 10:28:02,EC2,Instance i-98765 started	Eventos por servico:
S3:2
EC2:3
Lambda:1
Maior:EC2
Menor:Lambda
*/  

public class MonitoramentoLogsAWS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Map<String, Long> eventosPorServico = new HashMap<>();

        for (int i = 0; i < quantidadeLogs; i++) {
            String[] parts = scanner.nextLine().split(",");
            String servico = parts[1];

            // Verifica se o serviço já está no mapa, se não estiver, inicia a contagem em 1
            eventosPorServico.put(servico, eventosPorServico.getOrDefault(servico, 0L) + 1);
        }

        Map.Entry<String, Long> maiorServico = eventosPorServico.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);

        Map.Entry<String, Long> menorServico = eventosPorServico.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Eventos por servico:");
        for (Map.Entry<String, Long> entry : eventosPorServico.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("Maior:" + maiorServico.getKey());
        System.out.println("Menor:" + menorServico.getKey());
    }
}
