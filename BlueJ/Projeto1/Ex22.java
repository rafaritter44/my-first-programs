import java.util.Scanner;
public class Ex22
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double nota, notaA, notaB, j1, j2, j3, j4, j5, j6, maior, menor;
        System.out.print("\fInforme a nota da banca A: ");
        notaA = in.nextDouble();
        System.out.print("Informe a nota do juíz 1: ");
        j1 = in.nextDouble();
        System.out.print("Informe a nota do juíz 2: ");
        j2 = in.nextDouble();
        System.out.print("Informe a nota do juíz 3: ");
        j3 = in.nextDouble();
        System.out.print("Informe a nota do juíz 4: ");
        j4 = in.nextDouble();
        System.out.print("Informe a nota do juíz 5: ");
        j5 = in.nextDouble();
        System.out.print("Informe a nota do juíz 6: ");
        j6 = in.nextDouble();
        maior = (((j1+j2+Math.abs(j1-j2))/2+(j3+j4+Math.abs(j3-j4))/2+Math.abs((j1+j2+Math.abs(j1-j2))/2-(j3+j4+Math.abs(j3-j4))/2))/2+(j5+j6+Math.abs(j5-j6))/2+Math.abs(((j1+j2+Math.abs(j1-j2))/2+(j3+j4+Math.abs(j3-j4))/2+Math.abs((j1+j2+Math.abs(j1-j2))/2-(j3+j4+Math.abs(j3-j4))/2))/2-(j5+j6+Math.abs(j5-j6))/2))/2;
        menor = (((j1+j2-Math.abs(j1-j2))/2+(j3+j4-Math.abs(j3-j4))/2-Math.abs((j1+j2-Math.abs(j1-j2))/2-(j3+j4-Math.abs(j3-j4))/2))/2+(j5+j6-Math.abs(j5-j6))/2-Math.abs(((j1+j2-Math.abs(j1-j2))/2+(j3+j4-Math.abs(j3-j4))/2-Math.abs((j1+j2-Math.abs(j1-j2))/2-(j3+j4-Math.abs(j3-j4))/2))/2-(j5+j6-Math.abs(j5-j6))/2))/2;
        notaB = (j1+j2+j3+j4+j5+j6-maior-menor)/4;
        nota = notaA + notaB;
        System.out.println("Nota da banca B: " + notaB);
        System.out.print("Nota final: " + nota);
    }
}
        