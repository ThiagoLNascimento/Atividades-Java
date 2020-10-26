/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.tutorialOOCont.ThiagoLopes;

/**
 *
 * @author Thiago
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.NoSuchElementException;

abstract class SistemaAcademico {
    
    public static Aluno[] alunos = new Aluno[2];
    public static Disciplina[] disciplinas = new Disciplina[2];
    public static Inscricoes[] inscricao = new Inscricoes[2];
    public static Turma[] turma = new Turma[2];
    
    static void carregarAlunos(String arq) throws Exception {
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        for (int i = 0; i < alunos.length; i ++){
            try{
           
                alunos[i] = new Aluno();
                alunos[i].inscricoes = new Inscricoes[5];
                for (int j = 0; j < 5; j ++)
                    alunos[i].inscricoes[j] = new Inscricoes();
                alunos[i].cpf = in.next();
                alunos[i].matricula = in.next();
                alunos[i].unidade = in.next();
                alunos[i].nome = in.nextLine();
                
                
            }catch(NoSuchElementException e){
                
                break;
                
            }                       
        }        
    }
    
    static void carregarDisciplinas(String arq) throws Exception {
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        
        for (int i = 0; i < disciplinas.length; i ++){
            try{
                
                disciplinas[i] = new Disciplina();
                disciplinas[i].codigo = in.next();
                disciplinas[i].sigla = in.next();
                disciplinas[i].nome = in.nextLine();
                
            }catch(NoSuchElementException e){
                
                break;
            }
        }
    }
    
    static void carregarTurmas(String arq) throws Exception {
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        
        for (int i = 0; i < turma.length; i ++){
            try{
                
                turma[i] = new Turma();
                turma[i].codigo = in.next();
                turma[i].disciplina.codigo= in.next();
                turma[i].semestre = in.nextInt();
                turma[i].horario = in.nextLine();
                
            }catch(NoSuchElementException e){
                
                break;
            }
        }
    }
    
    static void carregarInscricoes(String arq) throws Exception {
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        
        for (int i = 0; i < inscricao.length; i ++){
            try{
                
                inscricao[i] = new Inscricoes();
                inscricao[i].turma.disciplina.codigo = in.next();
                inscricao[i].turma.codigo = in.next();
                inscricao[i].aluno.matricula = in.next();
                inscricao[i].data_matricula = in.next();
                
                for (int j = 0; j < turma.length; j ++){
                    try{
                        if (inscricao[i].turma.disciplina.codigo.equals(turma[j].disciplina.codigo) && inscricao[i].turma.codigo.equals(turma[j].codigo))
                            inscricao[i].turma = turma[j];
                    }catch(ArrayIndexOutOfBoundsException e){
                        break;
                    }
                }
                
            }catch(NoSuchElementException e){
                break;
            }
            
            for (Aluno aluno : alunos) {
                try {
                    if (inscricao[i].aluno.matricula.equals(aluno.matricula)) {
                        aluno.inscricoes[aluno.quant_mat] = inscricao[i];
                        aluno.quant_mat++;
                        break;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    
                    break;
              
                }
            }
        }
    }
    
    public static void informarNotasDeAlunos(){
        
        Scanner in = new Scanner (System.in);
        String mat, dis;
        boolean codigo_aluno, codigo_disciplina;
        while(true){
            
            System.out.println("Digite a matrícula do aluno para colocar a sua nota ou digite 0 para parar de informar as notas: ");
            mat = in.next();
            if (mat.equals("0"))
                break;
            if (mat.length() != 8)
                System.out.println("Tente novamente com um número de matrícula válido.");
            if (mat.length() == 8){
                codigo_aluno = false;
                for (Aluno aluno : alunos){
                    try {
                        if (mat.equals(aluno.matricula)){
                            codigo_aluno = true;
                            System.out.println("Digite o codigo da disciplina do aluno para colocar a nota: ");
                            dis = in.next();
                            codigo_disciplina = false;
                            for (Inscricoes inscricoes : aluno.inscricoes){
                                try {
                                    if (dis.equals(inscricoes.turma.disciplina.codigo)){
                                        codigo_disciplina = true;
                                        if (inscricoes.quant_notas == inscricoes.notas.length){
                                            System.out.println("Quantidade máxima de notas ja informada para essa disciplina.");
                                            break;
                                        }else{
                                            System.out.println("Digite a nota do aluno:");
                                            inscricoes.notas[inscricoes.quant_notas] = in.nextFloat();
                                            inscricoes.quant_notas ++;
                                            break;
                                        }
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    break;
                                }    
                            }
                            if (codigo_disciplina == false)
                                System.out.println("Aluno nao inscrito na materia!");
                        }
                    }catch(ArrayIndexOutOfBoundsException e){
                        break;
                    }
                }
                if (codigo_aluno == false)
                    System.out.println("Nao existe aluno com a matricula digitada!");
            } 
        } 
    }
    
    public static void calcularMedias(){
       
        Scanner in = new Scanner (System.in);
        String mat, dis;
        boolean codigo_aluno, codigo_disciplina;
        while(true){
            
            System.out.println("Digite a matrícula do aluno que deseja saber a sua media ou digite 0 para parar sair: ");
            mat = in.next();
            if (mat.equals("0"))
                break;
            if (mat.length() != 8)
                System.out.println("Tente novamente com um número de matrícula válido.");
            if (mat.length() == 8){
                codigo_aluno = false;
                for (Aluno aluno : alunos){
                    try {
                        if (mat.equals(aluno.matricula)){
                            codigo_aluno = true;
                            System.out.println("Digite o codigo da disciplina do aluno para saber a media: ");
                            dis = in.next();
                            codigo_disciplina = false;
                            for (Inscricoes inscricoes : aluno.inscricoes){
                                try {
                                    if (dis.equals(inscricoes.turma.disciplina.codigo)){
                                        codigo_disciplina = true;
                                        float media = 0.0f;
                                        if (inscricoes.quant_notas == 0){
                                            System.out.println("Nenhuma nota informada para essa materia.");
                                            break;
                                        }
                                        for (int i = 0; i < inscricoes.quant_notas; i ++)
                                            media += inscricoes.notas[i];
                                        System.out.println("A media do aluno e: " + (media/inscricoes.quant_notas));
                                    }
                                }catch(ArrayIndexOutOfBoundsException e){
                                    break;
                                }    
                            }
                            if (codigo_disciplina == false)
                                System.out.println("Aluno nao inscrito na materia!");
                        }
                    }catch(ArrayIndexOutOfBoundsException e){
                        break;
                    }
                }
                if (codigo_aluno == false)
                    System.out.println("Nao existe aluno com a matricula digitada!");
            } 
        } 
    }
    
    
    public static void main(String[] args) throws Exception{
        
        carregarAlunos("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/exercicios/tutorialOOCont/ThiagoLopes/lista_alunos.txt");
        carregarDisciplinas("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/exercicios/tutorialOOCont/ThiagoLopes/lista_disciplinas.txt");
        carregarTurmas("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/exercicios/tutorialOOCont/ThiagoLopes/lista_turmas.txt");
        carregarInscricoes("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/exercicios/tutorialOOCont/ThiagoLopes/lista_inscricao.txt");
        informarNotasDeAlunos();
        calcularMedias();
        
    }   
}
