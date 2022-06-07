package com.br.bayer.main;

import com.br.bayer.BO.Pessoa;
import com.br.bayer.BO.PessoaDoenca;
import com.br.bayer.BO.Doenca;
import java.text.ParseException;
import java.util.Scanner;

import com.br.bayer.BO.Regiao;



public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Controller();
		

	}
	
	public static String InsertPessoa(String data, String nome, int regiao, int doenca) {
		Pessoa p = new Pessoa();
		
		p.setDt_nascimento(data);
		p.setNm_pessoa(nome);
		Regiao r = new Regiao();
		p.setRegiao(r.SelecionaRegiao(regiao));
		System.out.println("Registros afetados: " + p.AdicionaPessoa());
		PessoaDoenca pd = new PessoaDoenca();
		Doenca d = new Doenca();
		pd.setDoenca(d.SelecionaDoenca(doenca));
		System.out.println("Registros afetados: " + pd.AdicionaPessoaDoenca());
		
		
		return "Pessoa cadasrada com sucesso";
	}
	
	public static void TestaDelete(int id) {
		Pessoa p = new Pessoa();
		PessoaDoenca pd = new PessoaDoenca();
		if (pd.RemovePessoaDoemca(id) > 0 && p.RemovePessoa(id) > 0) {
			System.out.println("Pessoa removida!");
		} else {
			System.out.println("Nenhum registro foi excluído");
		}
	}
	
	
	public static void TestaSelectAll() {
		PessoaDoenca pd = new PessoaDoenca();
		for (PessoaDoenca us : pd.VisualizaPessoaDoencaTudo()) {
			System.out.println(us);
		}
	}
	
	public static void TestaSelectById(int id) {
		Pessoa p = new Pessoa();
		System.out.println(p.SelecionaPessoa(id));
	}
	
	public static void Controller() {
		
		String dt_nascimento;
		String nm_pessoa;
		int idRegiao;
		int idDoenca;
		int idDelete;
		
		int controla;
		
		boolean controlaWhile = true;
		Scanner sn = new Scanner(System.in);
		while(controlaWhile){
			  Mensagens();
			  int numero = sn.nextInt();
			  
			  if (numero == 1) {
				  System.out.println("Comando Adicionar");
				  System.out.println(" ");
				  System.out.println("Digite o nome: ");
				  nm_pessoa = sn.next();
				  System.out.println("Digite a Data de Nascimento: (dd/mm/yyyy)");
				  dt_nascimento = sn.next();
				  do{
					  System.out.println("Escolha uma regiao (1 -Norte / 2 -Nordeste / 3 -Centro-Oeste / 4 -Sudeste / 5 -Sul): ");
					  idRegiao = sn.nextInt();
				  }while(!(idRegiao >= 1 && idRegiao <= 5));
				  do{
					  System.out.println("Escolha uma doença (1 -Zika / 2 -Malária / 3 -Dengue): ");
					  idDoenca = sn.nextInt();
				  }while(!(idDoenca >= 1 && idDoenca <= 3));
				  System.out.println(InsertPessoa(dt_nascimento, nm_pessoa, idRegiao, idDoenca));
				  
				  System.out.println("Deseja continuar ? ('0' para encerrar)");
				  controla = sn.nextInt();
				  if (controla == 0) {
					  controlaWhile = false;
				  }
			  } else if(numero == 2) {
				  System.out.println("Comando Adicionar");
				  System.out.println(" ");
				  System.out.println("Qual Id gostaria de Deletar ?");
				  idDelete = sn.nextInt();
				  TestaDelete(idDelete);
				  
				  System.out.println("Deseja continuar ? ('0' para encerrar)");
				  controla = sn.nextInt();
				  if (controla == 0) {
					  controlaWhile = false;
				  }
			  } else if(numero == 3) {
				  System.out.println("Comando Relatorio");
				  System.out.println(" ");
				  TestaSelectAll();
				  
			  } else {
				  
			  }
			  
			}
		sn.close();
	}
	
	public static void Mensagens() {
		  System.out.println("======Console======");
		  System.out.println(" ");
		  System.out.println("Escolha uma operação");
		  System.out.println("1 Adicionar / 2 Deletar / 3 Relatorio");
	}
	

}
