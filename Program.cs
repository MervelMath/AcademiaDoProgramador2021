using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;



namespace Calculadora.ConsoleApp
{
    using System;

    class Program
    {

        #region Req1[OK]
        //1) Calculadora deve somar.
        #endregion
        #region Req2[OK]
        //2) Deve poder fazer várias operações de soma.
        #endregion
        #region Req3[OK]
        //3) Deve poder fazer soma e subtração (2 tipos de operação).
        #endregion
        #region Req4[OK]
        // 4) Deve fazer as 4 operações matemáti básicas.
        #endregion
        #region Req5[OK]
        // 5) Caso não seja uma das opções, deve pedir novamente uma opção válida.
        #endregion
        #region BUG1[OK]
        // 6) Bug da divisão por 0.
        #endregion
        #region Req6[OK]
        /*
         7)Deve mostrar as operações já realizadas.
            Requisitos:
                deve aparecer assim: 2 + 1 = 3
                avisar caso o vetor esteja vazio (nenhuma operação tenha sido realizada).
        */
        #endregion

        static void Main(string[] args)
        {

            string option = "";
            double secondnumber = 0;
            string[] opsDone = new string[100];
            int cont = 0;

            while (true)
            {
                MostraMenu();

                option = Console.ReadLine();

                if (IsInvalidOption(option))
                {
                    //ABC = Uper Case.
                    //Math Lopes = pascal case.
                    //math = lower case.
                    string msg1 = "Opção inválida, tente novamente...";
                    ShowInvalidMsg(msg1);

                    continue; //Contrário do "break", volta proinício do "while".
                }

                if (OptionVisualization(option))
                {
                    if (opsDone[0] == null)
                    {
                        InvalidVizualizationMsg("Visualização inválida, tente novamente...");

                        continue;
                    }

                    else
                    {
                        for (int i = 0; i < opsDone.Length; i++)
                        {

                            if (opsDone[i] != null)
                            {
                                Console.WriteLine(opsDone[i]);
                            }

                        };

                        continue;
                    }
                }

                if (ExtitApp(option))
                {
                    break;
                }
                double primeironmr = ReadFirstNumber("Digite um número: ");

                do
                {
                    secondnumber = ReadSecondNumber("Digite o segundo número: ");

                    if (ZeroDivisionCorrection(option, secondnumber))
                    {
                        ZeroDivisioMsg("Não se pode fazer uma divisão por 0, tente novamente...");
                    }
                } while (RepeatZeroDivisio(option, secondnumber));


                double result = 0;
                string simbol = "";

                SwitcAndCases(option, secondnumber, primeironmr, ref result, ref simbol);

                cont = ReadOperationsDone(secondnumber, opsDone, cont, primeironmr, simbol);

                Console.WriteLine(result);


                Console.ReadLine();

            }

        }

        private static int ReadOperationsDone(double segundoonmr, string[] opsrealizadas, int cont, double primeironmr, string simbol)
        {
            string opRealizada =
                                $"{primeironmr} {simbol} {segundoonmr}";
        
                opsrealizadas[cont] = opRealizada;

            cont++;
            return cont;
        }

        private static void SwitcAndCases(string option, double segundoonmr, double primeironmr, ref double result, ref string simbol)
        {
            switch (option)
            {
                case "1":
                    result = primeironmr + segundoonmr;
                    simbol = "+";
                    break;
                case "2":
                    result = primeironmr - segundoonmr;
                    simbol = "-";
                    break;
                case "3":
                    result = primeironmr * segundoonmr;
                    simbol = "*";
                    break;
                case "4":
                    result = primeironmr / segundoonmr;
                    simbol = "/";
                    break;


                default:
                    break;
            }
        }

        private static double ReadSecondNumber(string msg)
        {
            double segundoonmr;
            Console.Write(msg);
            segundoonmr = Convert.ToDouble(Console.ReadLine());
            return segundoonmr;
        }

        private static bool RepeatZeroDivisio(string option, double segundoonmr)
        {
            return segundoonmr == 0 && option == "4";
        }

        private static double ReadFirstNumber(string msg)
        {
            Console.Write(msg);

            double firstnumber = Convert.ToDouble(Console.ReadLine());
            return firstnumber;
        }

        private static bool ExtitApp(string option)
        {
            return option.Equals("s", StringComparison.OrdinalIgnoreCase);
        }

        private static void ZeroDivisioMsg(string msg)
        {
            Console.ForegroundColor = ConsoleColor.Red;

            Console.WriteLine(msg);

            Console.ResetColor();

            Console.ReadLine(); //para limpar o console, antes temos que ler um comando

            Console.Clear();
        }

        private static bool ZeroDivisionCorrection(string option, double segundoonmr)
        {
            return segundoonmr == 0 && option == "4";
        }

        private static void InvalidVizualizationMsg(string msg)
        {
            Console.ForegroundColor = ConsoleColor.Red;

            Console.WriteLine(msg);

            Console.ResetColor();

            Console.ReadLine();

            Console.Clear();
        }

        private static bool OptionVisualization(string option)
        {
            return option == "5";
        }

        private static void ShowInvalidMsg(string msg1)
        {
            Console.ForegroundColor = ConsoleColor.Red;

            Console.WriteLine(msg1);

            Console.ResetColor();

            Console.ReadLine(); //para limpar o console, antes temos que ler um comando

            Console.Clear();
        }

        private static bool IsInvalidOption(string option)
        {
            return option != "1" && option != "2" && option != "3"
                                && option != "4" && option != "5" && !option.Equals("S", StringComparison.OrdinalIgnoreCase);
        }

        private static void MostraMenu()
        {
            Console.WriteLine("Calc 1.6");

            Console.Write("Deseja fazer uma nova soma (1), uma subratção (2), ");
            Console.Write("uma multiplicação (3), uma divisão (4), ver tudo (5) ou sair (S)? ");
        }
    }
}
