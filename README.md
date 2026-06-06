# ProjetoC06-A
Repositorio para armazenar o projeto realizado para materia C06-A. O projeto foi criar uma linha de producao de uma empresa de equipamentos biomedicos.
Nomes:
Felipe Lamy Rosa Renno - 507  
Flávia Lima - 217 - GEP
Petros Silveira Paradello - 2192 - GEC
Eduardo Filhagosa Guimaraes - 755 - GEB
--------------------------------------------------------------------------------------------------
Utilizamos IA no projeto. As IAs que foram utilizadas, foram Codex Versao 5.5, ChatGPT Versao 5.5 e Gemini Versao 3.5.
Com chatGPT, pedimos para gerar um codigo a ser utilizado no PlantUML para criar um Diagrama do projeto. 
O Gemini foi utilizado para sugerir os equipamentos e exemplos de casos de testes e calibrações.
  Exemplo de Promt utilizado no Gemini: 
    prompt:
me de 4 equipamentos biomedicos(O projeto ja havia sido descrito antes)
Resposta:
  "Para o escopo do seu projeto de Engenharia de Produção aplicado à Engenharia Biomédica, aqui estão 4 excelentes exemplos de equipamentos   médicos. Eles são ótimos para o sistema porque possuem parâmetros de calibração, testes físicos e processos de esterilização muito bem      definidos e fáceis de simular no código:

  1. Ventilador Pulmonar (Respirador)
    O que faz: Substitui ou auxilia a respiração espontânea do paciente, injetando oxigênio nos pulmões.
    Foco Biomédico (Testes): Precisa testar e calibrar transdutores de fluxo e sensores de pressão barométrica (para não lesionar o pulmão      do paciente com excesso de pressão).
Foco de Produção: Equipamento de altíssima complexidade e prioridade máxima na linha de montagem (suporte à vida).
  2. Bomba de Infusão
    O que faz: Administra fluidos (como medicamentos, nutrientes ou quimioterápicos) de forma controlada e precisa na veia do paciente.
    Foco Biomédico (Testes): Validar o sensor de detecção de bolhas de ar na tubulação (essencial para evitar embolia gasosa) e a precisão      da vazão volumétrica em mL/h.
Foco de Produção: Exige protocolos rígidos de esterilização das partes que entram em contato com os insumos médicos.
  3. Monitor Multiparamétrico
    O que faz: Monitora continuamente os sinais vitais do paciente em tempo real na UTI (frequência cardíaca, saturação de oxigênio,            pressão arterial, temperatura).
Foco Biomédico (Testes): Testar o processamento de sinal dos módulos eletrônicos usando simuladores de ECG (Eletrocardiograma) e SpO2
(Oximetria).
Foco de Produção: Envolve uma linha de produção voltada para montagem de placas eletrônicas (hardware), calibração de telas e instalação de software/firmware.

  4. Desfibrilador Externo Automático (DEA / Cardioversor)
    O que faz: Aplica uma descarga elétrica (choque) controlada no coração do paciente para reverter uma parada cardíaca por fibrilação.
Foco Biomédico (Testes): Testar a descarga de energia dos capacitores (medida em Joules) e o tempo de carregamento da bateria interna de emergência.
Foco de Produção: Controle rigoroso de qualidade do lote de baterias e dos circuitos de alta tensão (segurança elétrica do operador e do paciente).
  💡 Dica para o seu código:
    Como você já tem o VentiladorPulmonar e a BombaInfusao estruturados com as interfaces Calibravel e Esterilizavel, se você quiser            adicionar mais um ao pedido no seu arquivo .txt, o Monitor Multiparamétrico se encaixaria perfeitamente na interface Calibravel,            enquanto o Desfibrilador poderia usar uma nova interface ou passar por testes rigorosos de segurança elétrica!"
Prompt: Me de exemplos de coisas que se testem em um ventilador pulmonar

Reposta:
  "Em um ambiente de Engenharia Biomédica e de Controle de Qualidade na Engenharia de Produção, os testes em um Ventilador Pulmonar são        extremamente rigorosos, pois qualquer falha pode ser fatal para o paciente (suporte à vida).
  Esses testes geralmente utilizam um equipamento chamado Analisador de Ventilador Pulmonar (ou "pulmão artificial de teste"), que simula a   complacência e a resistência de um pulmão humano real.
Os principais parâmetros e componentes testados se dividem em quatro categorias essenciais:
  1. Testes de Fluxo e Volume
    Garantem que a quantidade de ar/oxigênio enviada ao paciente seja exatamente a configurada no painel.
    Volume Corrente (V t): Mede o volume de gás entregue em cada respiração (geralmente calculado em mililitros, mL). É crucial para evitar     que o pulmão sofra sub-ventilação ou super-ventilação.
  Fluxo Inspiratório e Expiratório: Valida a velocidade com que o gás entra e sai, medida em litros por minuto (L/min).
    Fração Inspirada de Oxigênio (FiO 2): Testa o misturador de gases (blender) para garantir que a proporção de Oxigênio (O 2) e Ar            Comprimido esteja exata (por exemplo, se o médico configurar 40% de O 2, o equipamento não pode entregar 35%).
  2. Testes de Pressão (Mecânica Respiratória)
    Evitam o barotrauma (lesão nos alvéolos pulmonares por excesso de pressão).
    Pressão de Pico Inspiratório (PIP): A pressão máxima atingida nas vias aéreas durante a inspiração. Os sensores de corte de segurança       devem interromper o fluxo se a pressão subir além do limite seguro.
    PEEP (Pressão Positiva ao Fim da Expiração): Testa se o ventilador consegue manter uma pequena pressão residual nos pulmões ao final da     expiração para evitar que os alvéolos colapsem (fechem).
  Válvula de Alívio Mecânico (Pop-off): Um teste físico para garantir que, caso o software trave, uma válvula mecânica se abra fisicamente      para liberar o excesso de pressão.
  3. Testes de Sensores, Alarmes e Ciclagem
    Os alarmes são a voz do equipamento em uma UTI; eles precisam disparar imediatamente se algo der errado.
    Alarme de Desconexão do Circuito: Simula-se a desconexão do tubo do paciente para checar se o equipamento percebe a queda brusca de         pressão e dispara o alarme visual e sonoro em poucos segundos.
  Alarme de Apneia: Se o equipamento estiver no modo assistido (onde ele espera o paciente tentar respirar para ajudá-lo) e o paciente          parar de respirar, o alarme deve soar e o ventilador deve entrar automaticamente em modo de emergência (controlado).
  Alarme de Alta/Baixa Pressão: Simula-se uma obstrução no tubo (dobra ou secreção) para verificar o disparo do alerta.
  4. Testes de Hardware e Segurança Elétrica
    Lógica pura de engenharia e montagem de produção.
    Corrente de Fuga e Aterramento: Garante que nenhuma corrente elétrica residual passe do equipamento para o paciente através dos             sensores ou do tubo umidificado.
  Autonomia da Bateria Interna: Testa se a bateria de emergência segura o equipamento funcionando por tempo suficiente caso o hospital          sofra uma queda de energia, além de validar o tempo de recarga.
  Estanqueidade (Teste de Vazamento): O circuito interno de mangueiras e válvulas do ventilador é pressurizado para garantir que não            existam microfuros ou vazamentos nas juntas de montagem.
  💡 Como aplicar isso no código do seu projeto?
    No método testarParametrosBiomedicos() da sua classe VentiladorPulmonar, você pode colocar prints simulando alguns desses testes            rápidos, por exemplo:
  Java
  @Override
    public void testarParametrosBiomedicos() {
        System.out.println("🩺 [Teste] Iniciando verificação do misturador de gases...");
        System.out.println("📊 [Métrica] FiO2 alvo: 40% | FiO2 medido: 40.2% -> DENTRO DO PADRÃO.");
        System.out.println("🩺 [Teste] Validando alarme de desconexão de circuito...");
        System.out.println("🚨 [Resultado] Alarme sonoro e visual disparado em 1.8 segundos -> APROVADO.");
  }"
Prompt: Como usar essas informoecoes no codigo?
Reposta:
  "Veja este exemplo prático que faz uma contagem progressiva no console de segundo em segundo:
Java
public class LinhaProducao extends Thread {    
    @Override
    public void run() {
        System.out.println("⚙️ Iniciando a montagem do Ventilador Pulmonar...");
        // Simula um processo de 3 segundos
        for (int i = 1; i <= 3; i++) {
            try {
                // Pausa a execução por 1000 milissegundos (1 segundo)
                Thread.sleep(1000); 
                // Exibe o progresso na consola para o utilizador observar a linha
                System.out.println("   [Observando a linha...] " + i + "s passados.");
            } catch (InterruptedException e) {
                System.out.println("⚠️ Erro crítico: A esteira de produção parou!");
                return; // Encerra a thread caso ocorra uma falha
            }
        }

        System.out.println("✅ Equipamento produzido com sucesso!");
    }
}
💡 Como ficaria o código para o Motor Cirúrgico?
Caso queira uma terceira opção que use a esterilização por calor (Autoclave), a classe MotorCirurgico seria modelada assim:
Java
public class MotorCirurgico extends EquipamentoMedico implements Esterilizavel, Testavel {
    public MotorCirurgico() {
        // Nome do equipamento e 3 segundos de simulação na linha de produção
        super("Motor Cirúrgico Ortopédico", 3);
    }
    // Implementação da interface Esterilizavel
    @Override
    public void esterilizarComponentes() {
        System.out.println("🧪 [Esterilização] Submetendo o Motor Blindado e as Brocas à Autoclave de Vapor Saturado a 134°C.");
        System.out.println("📦 [Logística] Verificando integridade do invólucro de esterilização para o lote " + getNumeroSerie());
    }
    // Implementação da interface Testavel
    @Override
    public void testarParametrosBiomedicos() {
        System.out.println("🩺 [Teste Biomédico] Medindo o torque mecânico e a rotação por minuto (RPM) máxima...");
        System.out.println("⚡ [Segurança] Validando a vedação contra entrada de líquidos (IPX7) e corrente de fuga -> APROVADO.");
    }
}"
Utilizamos o codex para fazer o código de escrita e leitura de arquivo e a main.
Resultado eh a propia main, menos o metodo "salvarPedido", que foi feito sem ia.


Acreditamos que o resultado do uso da IA foi muito benefico, nos ajudou bastante a entender como realizar o projeto e na producao do codigo tambem. 
