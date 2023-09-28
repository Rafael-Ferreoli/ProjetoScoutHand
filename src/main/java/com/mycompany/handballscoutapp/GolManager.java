package com.mycompany.handballscoutapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class GolManager {

    private final List<String> informacoesGols = new ArrayList<>();
    private String tipoChuteSelecionado;
    private final String timeFinal;
    private final String quadranteChuteFinal;
    private boolean acaoExecutada = false;
    private final String nomeArquivo;
    private String nomeTimeA = "";
    private String nomeTimeB = "";
    private int totalChutesA = 0;
    private int totalChutesB = 0;
    private int totalDefesasA = 0;
    private int totalDefesasB = 0;
    private int totalChutesForaA = 0;
    private int totalChutesForaB = 0;
    private int totalGolsA = 0;
    private int totalGolsB = 0;
    private int Q1ADefesa, Q2ADefesa, Q3ADefesa, Q4ADefesa, Q5ADefesa, Q6ADefesa, Q7ADefesa, Q8ADefesa, Q9ADefesa;
    private int Q1BDefesa, Q2BDefesa, Q3BDefesa, Q4BDefesa, Q5BDefesa, Q6BDefesa, Q7BDefesa, Q8BDefesa, Q9BDefesa;
    private int Q1AGol, Q2AGol, Q3AGol, Q4AGol, Q5AGol, Q6AGol, Q7AGol, Q8AGol, Q9AGol;
    private int Q1BGol, Q2BGol, Q3BGol, Q4BGol, Q5BGol, Q6BGol, Q7BGol, Q8BGol, Q9BGol;
    List<String> paresVariaveisA = new ArrayList<>();
    List<String> paresVariaveisB = new ArrayList<>();

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
        String informacao = "HORA: " + horaAtual + " - TIME: " + timeFinal + " - TIPO CHUTE: ";

        if (getTipoChuteSelecionado().equals("GOL") || getTipoChuteSelecionado().equals("DEFESA")) {
            informacao += getTipoChuteSelecionado() + " -> " + quadranteChuteFinal + " -> " + quadranteGol;
        } else if (getTipoChuteSelecionado().equals("FORA")) {
            informacao += "FORA -> " + quadranteChuteFinal;
        }

        return informacao;
    }

    private void criarInformacaoGol(String quadranteGol) {
        //contador(getTipoChuteSelecionado());
        String mensagemConfirmacao = "CONFIRME A INFORMAÇÃO:\nTIPO CHUTE: " + getTipoChuteSelecionado() + "\nQUADRANTE CHUTE: " + quadranteChuteFinal;

        if (getTipoChuteSelecionado().equals("GOL") || getTipoChuteSelecionado().equals("DEFESA")) {
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
        //contador(getTipoChuteSelecionado());
        String informacao = formatarInformacaoGol(quadranteChute);
        informacoesGols.add(informacao);
        escreverInformacoesEmArquivo(nomeArquivo);
    }

    public void escreverInformacoesEmArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (String informacao : informacoesGols) {
                writer.write(informacao + "\n");
            }
            System.out.println("INFORMAÇÃO DE CHUTE SALVA EM: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void verificarQuadranteMatriz(String tipo, String nome, int quadrante) {
        if ("DEFESA".equals(tipo)) {
            if ("A".equals(nome)) {
                if (quadrante == 1) {
                    Q1ADefesa++;
                } else if (quadrante == 2) {
                    Q2ADefesa++;
                } else if (quadrante == 3) {
                    Q3ADefesa++;
                } else if (quadrante == 4) {
                    Q4ADefesa++;
                } else if (quadrante == 5) {
                    Q5ADefesa++;
                } else if (quadrante == 6) {
                    Q6ADefesa++;
                } else if (quadrante == 7) {
                    Q7ADefesa++;
                } else if (quadrante == 8) {
                    Q8ADefesa++;
                } else if (quadrante == 9) {
                    Q9ADefesa++;
                }
            } else if ("B".equals(nome)) {
                if (quadrante == 1) {
                    Q1BDefesa++;
                } else if (quadrante == 2) {
                    Q2BDefesa++;
                } else if (quadrante == 3) {
                    Q3BDefesa++;
                } else if (quadrante == 4) {
                    Q4BDefesa++;
                } else if (quadrante == 5) {
                    Q5BDefesa++;
                } else if (quadrante == 6) {
                    Q6BDefesa++;
                } else if (quadrante == 7) {
                    Q7BDefesa++;
                } else if (quadrante == 8) {
                    Q8BDefesa++;
                } else if (quadrante == 9) {
                    Q9BDefesa++;
                }
            }
        } else if ("GOL".equals(tipo)) {
            if ("A".equals(nome)) {
                if (quadrante == 1) {
                    Q1AGol++;
                } else if (quadrante == 2) {
                    Q2AGol++;
                } else if (quadrante == 3) {
                    Q3AGol++;
                } else if (quadrante == 4) {
                    Q4AGol++;
                } else if (quadrante == 5) {
                    Q5AGol++;
                } else if (quadrante == 6) {
                    Q6AGol++;
                } else if (quadrante == 7) {
                    Q7AGol++;
                } else if (quadrante == 8) {
                    Q8AGol++;
                } else if (quadrante == 9) {
                    Q9AGol++;
                }
            } else if ("B".equals(nome)) {
                if (quadrante == 1) {
                    Q1BGol++;
                } else if (quadrante == 2) {
                    Q2BGol++;
                } else if (quadrante == 3) {
                    Q3BGol++;
                } else if (quadrante == 4) {
                    Q4BGol++;
                } else if (quadrante == 5) {
                    Q5BGol++;
                } else if (quadrante == 6) {
                    Q6BGol++;
                } else if (quadrante == 7) {
                    Q7BGol++;
                } else if (quadrante == 8) {
                    Q8BGol++;
                } else if (quadrante == 9) {
                    Q9BGol++;
                }
            }
        }
    }

    public void lerEscreverEstatisticasDoArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo)); BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            // Define um padrão de expressão regular para encontrar "Q? GOL" e o número ao lado
            Pattern pattern = Pattern.compile("Q(\\d+)\\s+GOL");
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (line.startsWith("TIME A:")) {
                    nomeTimeA = line.substring(8).trim();
                } else if (line.startsWith("TIME B:")) {
                    nomeTimeB = line.substring(8).trim();
                } else if (line.contains("TIPO CHUTE:")) {
                    // Aqui vamos lidar com as estatísticas das ações de chute
                    if (line.contains("DEFESA")) {
                        String tipo = "DEFESA";
                        if (line.contains(nomeTimeA)) {
                            totalDefesasA++;
                            while (matcher.find()) {
                                String numeroQGol = matcher.group(1);
                                int numero = Integer.parseInt(numeroQGol);
                                verificarQuadranteMatriz(tipo, "A", numero);
                            }
                        } else if (line.contains(nomeTimeB)) {
                            totalDefesasB++;
                            while (matcher.find()) {
                                String numeroQGol = matcher.group(1);
                                int numero = Integer.parseInt(numeroQGol);
                                verificarQuadranteMatriz(tipo, "B", numero);
                            }
                        }
                    } else if (line.contains("GOL")) {
                        String tipo = "GOL";
                        if (line.contains(nomeTimeA)) {
                            totalGolsA++;
                            while (matcher.find()) {
                                String numeroQGol = matcher.group(1);
                                int numero = Integer.parseInt(numeroQGol);
                                verificarQuadranteMatriz(tipo, "A", numero);
                            }
                        } else if (line.contains(nomeTimeB)) {
                            totalGolsB++;
                            while (matcher.find()) {
                                String numeroQGol = matcher.group(1);
                                int numero = Integer.parseInt(numeroQGol);
                                verificarQuadranteMatriz(tipo, "B", numero);
                            }
                        }
                    } else if (line.contains("FORA")) {
                        if (line.contains(nomeTimeA)) {
                            totalChutesForaA++;
                        } else if (line.contains(nomeTimeB)) {
                            totalChutesForaB++;
                        }
                    }
                }
            }

            String parA1 = Q1AGol + "/" + (Q1ADefesa + Q2AGol);
            paresVariaveisA.add(parA1);
            String parA2 = Q2AGol + "/" + (Q2ADefesa + Q2AGol);
            paresVariaveisA.add(parA2);
            String parA3 = Q3AGol + "/" + (Q3ADefesa + Q3AGol);
            paresVariaveisA.add(parA3);
            String parA4 = Q4AGol + "/" + (Q4ADefesa + Q4AGol);
            paresVariaveisA.add(parA4);
            String parA5 = Q5AGol + "/" + (Q5ADefesa + Q5AGol);
            paresVariaveisA.add(parA5);
            String parA6 = Q6AGol + "/" + (Q6ADefesa + Q6AGol);
            paresVariaveisA.add(parA6);
            String parA7 = Q7AGol + "/" + (Q7ADefesa + Q7AGol);
            paresVariaveisA.add(parA7);
            String parA8 = Q8AGol + "/" + (Q8ADefesa + Q8AGol);
            paresVariaveisA.add(parA8);
            String parA9 = Q9AGol + "/" + (Q9ADefesa + Q9AGol);
            paresVariaveisA.add(parA9);

            String parB1 = Q1BGol + "/" + (Q1BDefesa + Q1BGol);
            paresVariaveisB.add(parB1);
            String parB2 = Q2BGol + "/" + (Q2BDefesa + Q2BGol);
            paresVariaveisB.add(parB2);
            String parB3 = Q3BGol + "/" + (Q3BDefesa + Q3BGol);
            paresVariaveisB.add(parB3);
            String parB4 = Q4BGol + "/" + (Q4BDefesa + Q4BGol);
            paresVariaveisB.add(parB4);
            String parB5 = Q5BGol + "/" + (Q5BDefesa + Q5BGol);
            paresVariaveisB.add(parB5);
            String parB6 = Q6BGol + "/" + (Q6BDefesa + Q6BGol);
            paresVariaveisB.add(parB6);
            String parB7 = Q7BGol + "/" + (Q7BDefesa + Q7BGol);
            paresVariaveisB.add(parB7);
            String parB8 = Q8BGol + "/" + (Q8BDefesa + Q8BGol);
            paresVariaveisB.add(parB8);
            String parB9 = Q9BGol + "/" + (Q9BDefesa + Q9BGol);
            paresVariaveisB.add(parB9);

            totalChutesA = totalChutesForaA + totalDefesasA + totalGolsA;
            totalChutesB = totalChutesForaB + totalDefesasB + totalGolsB;
            // Escreva as estatísticas no final do arquivo
            StringBuilder data = new StringBuilder();

            data.append("\n" + "ESTATÍSTICAS DA PARTIDA:" + "\n" + "\n"
                    + "TIME: " + nomeTimeA + "\n" + "\n"
                    + "TOTAL CHUTES " + nomeTimeA + ": " + totalChutesA + "\n"
                    + "TOTAL DEFESAS " + nomeTimeA + ": " + totalDefesasA + "\n"
                    + "TOTAL CHUTES FORA " + nomeTimeA + ": " + totalChutesForaA + "\n"
                    + "TOTAL GOLS " + nomeTimeA + ": " + totalGolsA + "\n" + "\n"
                    + "TIME: " + nomeTimeB + "\n" + "\n"
                    + "TOTAL CHUTES " + nomeTimeB + ": " + totalChutesB + "\n"
                    + "TOTAL DEFESAS " + nomeTimeB + ": " + totalDefesasB + "\n"
                    + "TOTAL CHUTES FORA " + nomeTimeB + ": " + totalChutesForaB + "\n"
                    + "TOTAL GOLS " + nomeTimeB + ": " + totalGolsB + "\n" + "\n"
                    + "APROVEITAMENTO GOL/CHUTES DO TIME: " + nomeTimeA + "\n" + "\n"
            );

            int[][] matrizIndicesA = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
            };

            for (int i = 0; i < 3; i++) {
                data.append("|   ");
                for (int j = 0; j < 3; j++) {
                    int indice = matrizIndicesA[i][j];
                    String par = paresVariaveisA.get(indice);
                    data.append(par + "   |   ");
                }
                data.append("\n");
            }

            data.append("\n");
            data.append("APROVEITAMENTO GOL/CHUTES DO TIME: " + nomeTimeB + "\n");
            data.append("\n");

            int[][] matrizIndicesB = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
            };

            for (int i = 0; i < 3; i++) {
                data.append("|   ");
                for (int j = 0; j < 3; j++) {
                    int indice = matrizIndicesB[i][j];
                    String par = paresVariaveisB.get(indice);
                    data.append(par + "   |   ");
                }
                data.append("\n");
            }

            writer.write(data.toString());

            // Feche o writer quando terminar.
            writer.close();
            System.out.println("ESTATÍSTICAS GERADAS COM SUCESSO");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getTipoChuteSelecionado() {
        return tipoChuteSelecionado;
    }

}
