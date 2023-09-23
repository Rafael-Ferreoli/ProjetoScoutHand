package com.mycompany.handballscoutapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GolManager {

    private final List<String> informacoesGols = new ArrayList<>();
    private String tipoChuteSelecionado;
    private final String timeFinal;
    private final String quadranteChuteFinal;
    private boolean acaoExecutada = false;

    public GolManager(String time, String quadranteChute) {
        timeFinal = time;
        quadranteChuteFinal = quadranteChute;
    }

    public void setTipoChute(String tipoChute) {
        this.tipoChuteSelecionado = tipoChute;
    }
    
    public String getQuadranteChuteFinal() {
    return quadranteChuteFinal;
}


    public void verificarEExecutarAcao(String quadrante) {
        if (tipoChuteSelecionado == null) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, SELECIONE UM TIPO DE CHUTE (GOL, FORA ou DEFESA) ANTES DE MARCAR O QUADRANTE!");
        }

        if (tipoChuteSelecionado.equals("FORA")) {
            salvarQuadranteChute(quadranteChuteFinal);

        }

        if (!acaoExecutada) {
            criarInformacaoGol(quadrante);
        }
    }

    private String obterHoraAtual() {
        LocalTime agora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return agora.format(formato);
    }

    private String formatarInformacaoGol(String quadranteGol) {
        String horaAtual = obterHoraAtual();
        String informacao = "HORA: " + horaAtual + " - " + timeFinal + " - ";

        if (tipoChuteSelecionado.equals("GOL") || tipoChuteSelecionado.equals("DEFESA")) {
            informacao += tipoChuteSelecionado + ": " + quadranteChuteFinal + " -> " + quadranteGol;
        } else if (tipoChuteSelecionado.equals("FORA")) {
            informacao += "FORA: " + quadranteChuteFinal;
        }

        return informacao;
    }

    private void criarInformacaoGol(String quadranteGol) {
        String mensagemConfirmacao = "CONFIRME A INFORMAÇÃO:\nTIPO CHUTE: " + tipoChuteSelecionado + "\nQUADRANTE CHUTE: " + quadranteChuteFinal;

        if (tipoChuteSelecionado.equals("GOL") || tipoChuteSelecionado.equals("DEFESA")) {
            mensagemConfirmacao += "\nQUADRANTE GOL: " + quadranteGol;
        }

        int resposta = JOptionPane.showConfirmDialog(null, mensagemConfirmacao, "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            String informacaoGol = formatarInformacaoGol(quadranteGol);
            informacoesGols.add(informacaoGol);
            escreverInformacoesEmArquivo("informacoes_de_gols.txt");
            acaoExecutada = true;
        }
    }

    public void salvarQuadranteChute(String quadranteChute) {
        String informacao = formatarInformacaoGol(quadranteChute);
        informacoesGols.add(informacao);
        escreverInformacoesEmArquivo("informacoes_de_gols.txt");
    }

    public void escreverInformacoesEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (String informacao : informacoesGols) {
                writer.write(informacao);
                writer.newLine();
            }
            System.out.println("Informações gravadas em:" + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
    
    public void gerarEstatisticas(String nomeArquivo) throws IOException {
    int totalChutes = informacoesGols.size();
    int totalGols = 0;

    int[] golsPorQuadrante = new int[9];
    int[] chutesPorQuadrante = new int[9];

    for (String informacao : informacoesGols) {
        if (informacao.contains("GOL")) {
            totalGols++;
            String[] partes = informacao.split("->");
            String quadranteGol = partes[1].trim();
            int indiceQuadrante = Integer.parseInt(quadranteGol.substring(1)) - 1;
            golsPorQuadrante[indiceQuadrante]++;
        } else if (informacao.contains("FORA")) {
            String quadranteChute = informacao.split(":")[1].trim();
            int indiceQuadrante = Integer.parseInt(quadranteChute.substring(1)) - 1;
            chutesPorQuadrante[indiceQuadrante]++;
        }
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
        writer.write("Estatísticas da Partida");
        writer.newLine();
        writer.write("Total de Chutes: " + totalChutes);
        writer.newLine();
        writer.write("Total de Gols: " + totalGols);
        writer.newLine();
        writer.newLine();
        writer.write("Estatísticas por Quadrante de Gol:");
        writer.newLine();

        for (int i = 0; i < 9; i++) {
            int numeroQuadrante = i + 1;
            writer.write("Q" + numeroQuadrante + ": " + golsPorQuadrante[i] + "/" + chutesPorQuadrante[i] + " gols");
        }
    }
    }
}

