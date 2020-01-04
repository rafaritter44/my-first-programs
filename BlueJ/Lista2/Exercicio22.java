import java.util.Scanner;
public class Exercicio22
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um valor em reais [1;9999]: ");
        int valor = in.nextInt();
        if(valor<1||valor>9999)System.out.println("ERRO: valor fora do intervalo.");
        else
        {
            int milhar = valor/1000;
            String extenso = "";
            switch(milhar)
            {
                case 1: extenso = "mil"; break;
                case 2: extenso = "dois mil"; break;
                case 3: extenso = "três mil"; break;
                case 4: extenso = "quatro mil"; break;
                case 5: extenso = "cinco mil"; break;
                case 6: extenso = "seis mil"; break;
                case 7: extenso = "sete mil"; break;
                case 8: extenso = "oito mil"; break;
                case 9: extenso = "nove mil"; break;
            }
            int centena = valor%1000/100;
            if(valor>=1000&&valor%1000!=0&&centena!=0)extenso = extenso + " e ";
            switch(centena)
            {
                case 1: if(valor%1000%100==0) extenso = extenso + "cem";
                else extenso = extenso + "cento"; break;
                case 2: extenso = extenso + "duzentos"; break;
                case 3: extenso = extenso + "trezentos"; break;
                case 4: extenso = extenso + "quatrocentos"; break;
                case 5: extenso = extenso + "quinhentos"; break;
                case 6: extenso = extenso + "seiscentos"; break;
                case 7: extenso = extenso + "setecentos"; break;
                case 8: extenso = extenso + "oitocentos"; break;
                case 9: extenso = extenso + "novecentos"; break;                
            }
            int dezena = valor%100/10;
            if(valor>=100&&valor%100!=0&&dezena!=0)extenso = extenso + " e ";
            switch(dezena)
            {
                case 2: extenso = extenso + "vinte"; break;
                case 3: extenso = extenso + "trinta"; break;
                case 4: extenso = extenso + "quarenta"; break;
                case 5: extenso = extenso + "cinquenta"; break;
                case 6: extenso = extenso + "sessenta"; break;
                case 7: extenso = extenso + "setenta"; break;
                case 8: extenso = extenso + "oitenta"; break;
                case 9: extenso = extenso + "noventa";
            }
            int unidade = valor%10;
            if(dezena==1)
            {
                switch(unidade)
                {
                    case 0: extenso = extenso + "dez"; break;
                    case 1: extenso = extenso + "onze"; break;
                    case 2: extenso = extenso + "doze"; break;
                    case 3: extenso = extenso + "treze"; break;
                    case 4: extenso = extenso + "quatorze"; break;
                    case 5: extenso = extenso + "quinze"; break;
                    case 6: extenso = extenso + "dezesseis"; break;
                    case 7: extenso = extenso + "dezessete"; break;
                    case 8: extenso = extenso + "dezoito"; break;
                    case 9: extenso = extenso + "dezenove";
                }
            }
            else
            {
            if(valor>=20&&valor%10!=0)extenso = extenso + " e ";
            switch(unidade)
            {
                case 1: extenso = extenso + "um"; break;
                case 2: extenso = extenso + "dois"; break;
                case 3: extenso = extenso + "três"; break;
                case 4: extenso = extenso + "quatro"; break;
                case 5: extenso = extenso + "cinco"; break;
                case 6: extenso = extenso + "seis"; break;
                case 7: extenso = extenso + "sete"; break;
                case 8: extenso = extenso + "oito"; break;
                case 9: extenso = extenso + "nove";
            }
            }
            if(valor==1)System.out.println("Por extenso: " + extenso + " real.");
            else System.out.println("Por extenso: " + extenso + " reais.");
        }
    }
}