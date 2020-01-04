import java.util.Scanner;
public class AppAluno
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe o nome: ");
        String nome = in.nextLine();
        System.out.print("Informe a matrícula: ");
        String matricula = in.nextLine();
        System.out.print("Informe a frequência: ");
        double frequencia = in.nextDouble();
        System.out.print("Informe a nota da P1: ");
        double p1 = in.nextDouble();
        System.out.print("Informe a nota da P2: ");
        double p2 = in.nextDouble();
        System.out.print("Informe a nota da P3: ");
        double p3 = in.nextDouble();
        System.out.print("Informe a média dos exercícios: ");
        double mediaExercicios = in.nextDouble();
        
        Aluno aluno1 = new Aluno(nome, matricula);
        aluno1.setP1(p1);
        aluno1.setP2(p2);
        aluno1.setP3(p3);
        aluno1.setMediaExercicios(mediaExercicios);
        aluno1.setFrequencia(frequencia);
        System.out.println(aluno1);
        if(aluno1.aprovado())System.out.println("Aprovado!");
        else System.out.println("Reprovado!");
    }
}