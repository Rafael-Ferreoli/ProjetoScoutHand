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
    private final String nomeArquivo;
    private int totalChutes = 0;
    private int totalDefesas = 0;
    private int totalChutesFora = 0;
    private int totalGols = 0;


    public GolManager(String time, String quadranteChute, String nomeArquivo) {
        this.timeFinal = time;
        this.quadranteChuteFinal = quadranteChute;
        this.nomeArquivo = nomeArquivo;
    }

    public void setTipoChute(String tipoChute) {
        this.tipoChuteSelecionado = tipoChute;
    }
    
    public String getQuadranteChuteFinal() {
    return quadranteChuteFinal;
}
    
    public void verificarEExecutarAcao(String quadrante) {
    if (!acaoExecutada) {
        criarInformacaoGol(quadrante);
        acaoExecutada = true;
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
            escreverInformacoesEmArquivo(nomeArquivo);
            acaoExecutada = true;
        }
    }

    public void salvarQuadranteChute(String quadranteChute) {
        totalChutesFora++;
        String informacao = formatarInformacaoGol(quadranteChute);
        informacoesGols.add(informacao);
        escreverInformacoesEmArquivo(nomeArquivo);
    }

    public void escreverInformacoesEmArquivo(String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
        for (String informacao : informacoesGols) {
            writer.write(informacao);
            writer.newLine();
        }
        System.out.println("Informações gravadas em: " + nomeArquivo);
    } catch (IOException e) {
        System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
}
    
    public void escreverEstatisticasEmArquivo() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
        writer.newLine();
        totalChutes = totalChutes + totalChutesFora;
        writer.write("Estatísticas da partida:");
        writer.newLine();
        writer.write("Total de Chutes: " + totalChutes);
        writer.newLine();
        writer.write("Total de Defesas: " + totalDefesas);
        writer.newLine();
        writer.write("Total de Chutes Fora: " + totalChutesFora);
        writer.newLine();
        writer.write("Total de Gols: " + totalGols);
        writer.newLine();
        writer.newLine(); // Adicione uma linha em branco para separar das informações de gols anteriores
        System.out.println("Estatísticas gravadas em: " + nomeArquivo);
    } catch (IOException e) {
        System.out.println("Erro ao escrever estatísticas no arquivo: " + e.getMessage());
    }
}

}

