package org.example;

import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.converter.ArgumentConversionException;

import java.lang.reflect.Parameter;
import java.util.*;
public class Homework2 {

    private static boolean ThereAreNumbersInString=false;
    private static boolean ThereisNumber0=false;
    private static boolean ThereisNumberThatexceedlimit=false;
    private static boolean notint=false;
    private static boolean StringNull=false;
    private static boolean ThereisNumberOffpoint=false;
    private static boolean StringOne;
    private static boolean NumberNegative;

    public static void main(String[] args) throws RuntimeException {
        // Parte 1: Gestione dell'input dell'utente
        int n = 5;
        int m = 5;
        String[] nomi = {"Piero","Fabio","Giuseppe","Messia","Francesco"};
        int[] numeri = {2,4,5,6,2};
        // Parte 2: Esecuzione delle operazioni
        effettuaOperazioni(n, m, nomi, numeri);
    }
    public static void effettuaOperazioni(int n, int m, String[] nomi, int[] numeri) throws RuntimeException {

        if (n != m) {
            System.out.println ("Il numero di numeri e nomi inseriti non corrisponde!");
        }

        else {
            if (n==0) {
                System.out.println ("Non e' possibile creare array di dimensione 0");
            }
            else {
                StringNull=false;
                ThereAreNumbersInString = false;
                ThereisNumber0=false;
                ThereisNumberThatexceedlimit=false;
                ThereisNumberOffpoint=false;
                StringOne=true;

                for (int i = 0; i <= n; i++)
                {
                    if (numeri[i] < 0)
                    {
                        NumberNegative=true;
                    } else if (numeri[i] > 99 )
                    {
                        ThereisNumberOffpoint=true;
                    }
                    else if (numeri[i] == 0)
                    {
                        ThereisNumber0=true;
                    }

                    if ((numeri[i] % 2) == 0)
                    {
                        if (numeri[i] >= 10)
                        {
                            ThereisNumberThatexceedlimit = true;
                        }
                    } else
                    {
                        if (numeri[i] >= 7)
                        {
                            ThereisNumberThatexceedlimit = true;
                        }
                    }
                    if (nomi[i].length() != 1 )
                    {
                        StringOne = false;
                    }

                    if (Objects.equals(nomi[i], ""))
                    {
                        StringNull=true;
                    }
                    if (nomi[i].matches(".*\\d.*"))
                    {
                        ThereAreNumbersInString = true;
                    }
                }

                try
                {
                    if(StringNull==true)
                    {
                        throw new NullNameException("Il nome non puo' essere nullo");
                    }
                } catch (NullNameException e)
                {
                    System.err.println(e.getMessage());
                }

                try {
                    if(NumberNegative==true)
                    {
                        throw new NegativeNumberException("Il numero deve essere positivo");
                    }
                } catch (NegativeNumberException e)
                {
                    System.err.println(e.getMessage());
                }

                try {
                    if(ThereisNumberOffpoint==true)
                    {
                        throw new OffPointException("Numero troppo grande, offPoint");
                    }
                } catch (OffPointException e)
                {
                    System.err.println(e.getMessage());
                }
            }

            // Calcola il quadrato dei numeri pari e il cubo dei numeri dispari
            List<Integer> quadrati = new ArrayList<>();
            List<Integer> cubi = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (numeri[i] % 2 == 0) {
                    int quadrato = numeri[i] * numeri[i];
                    if (quadrato < 100) {
                        quadrati.add(quadrato);
                    }
                } else {
                    int cubo = numeri[i] * numeri[i] * numeri[i];
                    if (cubo < 200) {
                        cubi.add(cubo);
                    }
                }
            }

            // Unisci i quadrati e i cubi in un unico array e ordina il tutto
            List<Integer> numeriOrdinati = new ArrayList<>();
            numeriOrdinati.addAll(quadrati);
            numeriOrdinati.addAll(cubi);
            Collections.sort(numeriOrdinati);


            Arrays.sort(nomi);

            // Stampa i numeri e i nomi ordinati
            for (int i = 0; i <= m; i++) {
                System.out.println(nomi[i]);
            }
            //System.out.println("Nomi ordinati:");
            for (int i = 0; i <= n; i++) {
                System.out.println(numeri[i]);
            }
        }
    }

    public static boolean getThereAreNumbersInString() {
        return ThereAreNumbersInString;
    }
    public static boolean getNegativeNumber()
    {
        return NumberNegative;
    }
    public static boolean getStringOne()
    {
        return StringOne;
    }
    public static boolean getStringNull()
    {
        return StringNull;
    }

    public static boolean getThereisNumber0() {
        return ThereisNumber0;
    }
    public static boolean getThereisNumberThatexceedlimit() {
        return ThereisNumberThatexceedlimit;
    }

    public static boolean getThereisNumberOffpoint() {
        return ThereisNumberOffpoint;
    }
}
