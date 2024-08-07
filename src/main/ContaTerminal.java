package main;

import java.util.Scanner;

import conta.Conta;

public class ContaTerminal {

	public static void main(String[] args) {
		int numConta = 0;
		String agencia = "", nome = "";
		double saldo = 0;
		
		Conta conta = new Conta();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, digite o número da Agência: (caso deseje sair digite 0)");
		numConta = sc.nextInt();
		
		while(numConta !=0) {
		if(numConta != conta.getNumero()) {
			sc.skip("\\R?");
			System.out.println("Conta não encontrada, gostaria de criar uma nova conta? (S/N)");
			String resposta = sc.nextLine();
			
			if(resposta.toLowerCase().contentEquals("s") ) {
				System.out.print("Digite o numero da Agencia:");
				agencia = sc.nextLine();
				System.out.print("Digite o numero da conta:");
				numConta = sc.nextInt();
				System.out.print("Digite o nome do cliente:");
				sc.skip("\\R?");
				nome = sc.nextLine();
				System.out.print("Digite o valor de deposito inicial:");
				saldo = sc.nextDouble();
				Conta conta1 = new Conta(numConta, agencia, nome, saldo);
				System.out.println("conta Criada com sucesso.");
				System.out.println("Bem vindo! Sr(a) " + conta1.getNomeCliente());
				conta = conta1;
				numConta = conta.getNumero();
			}else {
				numConta = 0;
			}
			
			}else {
				System.out.println("Olá "+ conta.getNomeCliente()+", obrigado por criar uma conta em nosso banco, sua agência é " +conta.getAgencia() +", conta "+ conta.getNumero()+" e seu saldo R&" +conta.getSaldo() + " já está disponível para saque");
				numConta = 0;
			}
		}
		
		System.out.println("Obrigado por utilizar nosso banco");
		
		sc.close();
	}
}
