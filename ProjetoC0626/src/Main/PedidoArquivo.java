package Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PedidoArquivo {

    private static final Path PASTA_PEDIDOS = Paths.get("pedidos");
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    public Path salvarPedido(List<String> equipamentos)
            throws IOException {

        if (equipamentos == null || equipamentos.isEmpty()) {
            throw new IOException("Nao e possivel salvar um pedido vazio.");
        }

        Files.createDirectories(PASTA_PEDIDOS);

        Path arquivo = criarArquivoUnico();

        try (BufferedWriter writer = Files.newBufferedWriter(arquivo)) {

            for (String equipamento : equipamentos) {
                writer.write(equipamento);
                writer.newLine();
            }
        }

        return arquivo;
    }

    public List<String> lerPedido(Path arquivo)
            throws IOException {

        if (arquivo == null || !Files.exists(arquivo)) {
            throw new IOException("Arquivo de pedido nao encontrado.");
        }

        return Files.readAllLines(arquivo);
    }

    private Path criarArquivoUnico()
            throws IOException {

        String dataAtual =
                LocalDateTime.now().format(FORMATO_DATA);

        for (int tentativa = 1; tentativa <= 999; tentativa++) {

            String sufixo =
                    tentativa == 1 ? "" : "_" + tentativa;

            Path arquivo =
                    PASTA_PEDIDOS.resolve(
                            "pedido_" + dataAtual + sufixo + ".txt"
                    );

            try {
                return Files.createFile(arquivo);
            }
            catch (FileAlreadyExistsException e) {
                // Tenta outro nome caso o arquivo ja exista.
            }
        }

        throw new IOException(
                "Nao foi possivel criar um nome unico para o pedido."
        );
    }
}
