import java.util.Scanner;
public class Ex8
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um valor inteiro entre 1 e 7, correspondente ao dia da semana: ");
        int dia = in.nextInt();/*
        if(dia<1||dia>7)System.out.println("ERRO: valor inválido");
        else if(dia==1)System.out.println("Domingo");
        else if(dia==2)System.out.println("Segunda");
        else if(dia==3)System.out.println("Terça");
        else if(dia==4)System.out.println("Quarta");
        else if(dia==5)System.out.println("Quinta");
        else if(dia==6)System.out.println("Sexta");
        else System.out.println("Sábado");*/
        switch(dia)
        {
            case 1: System.out.println("Domingo"); break;
            case 2: System.out.println("Segunda"); break;
            case 3: System.out.println("Terça"); break;
            case 4: System.out.println("Quarta"); break;
            case 5: System.out.println("Quinta"); break;
            case 6: System.out.println("Sexta"); break;
            case 7: System.out.println("Sábado"); break;
            default: System.out.println("ERRO: valor inválido");
        }
    }
}