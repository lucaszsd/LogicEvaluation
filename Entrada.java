import java.util.Arrays;
import java.util.Scanner;

public class Entrada {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		String expressao = "(P v ~P v (~S > ~Q) v ~R) & (~R v ~Q) & (~P v (Q > ~R))";//in.nextLine();
		char[] _expr = expressao.toCharArray();
		int[] _subExpress = new int[_expr.length];
		int qtdeVariaveis = 0;
		
		_subExpress = bracketsEval(_expr);
		
		boolean[] variaveisUsadas = new boolean[4]; 
		variaveisUsadas = variaveisUsadas(_expr);
		//------------------------------------------------
		for(int i = 0; i < _expr.length; ++i) {
			System.out.printf("%c ",(char)_expr[i]);
		}
		
		System.out.println();
		
		for(int i = 0; i < _expr.length; ++i) {
			System.out.printf("%d ", _subExpress[i]);
		}
		
		qtdeVariaveis = qtdeVariaveisUsadas(variaveisUsadas);
		
		generateTable(qtdeVariaveis, variaveisUsadas);
		
		popSubexpressions(_expr, _subExpress);
		
		in.close();

	}
	
	//Conta quantos "niveis" de subexpressões
	public static int[] bracketsEval(char[] _expr) {
		int aux = 0;
		int[] _aux = new int[_expr.length];
		for(int i = 0; i < _expr.length; ++i) {
			if(_expr[i] == '(') {
				_aux[i] = aux;
				aux ++;
			}else if(_expr[i] == ')') {
				aux--;
				_aux[i] = aux;
			}else {
				_aux[i] = aux - 1;
			}
		}
		return _aux;
	}
	
	//Indica quais variaves são usadas na expressão
	public static boolean[] variaveisUsadas(char[] _expr){
		boolean[] variavesUsadas = new boolean[4];
		for(int i = 0; i < _expr.length; ++i) {
			if(_expr[i] == 'P') {
				variavesUsadas[0] = true;
			}else if(_expr[i] == 'Q') {
				variavesUsadas[1] = true;
			}else if(_expr[i] == 'R') {
				variavesUsadas[2] = true;
			}else if(_expr[i] == 'S') {
				variavesUsadas[0] = true;
			}
		}
		return variavesUsadas;
	}
	
	//Calcula quantidade de variaves na expressão
	public static int qtdeVariaveisUsadas(boolean[] variaveisUsadas) {
		int qtde = 0;
		for(int i = 0; i < variaveisUsadas.length; ++i) {
			if(variaveisUsadas[i]) {
				qtde++;
			}
		}
		return qtde;
	}
	
	public static int[] pop(char[] _expr, int[] _subExpr, int max) {
		
		String aux = "";
		for(int i = 0; i < _expr.length; ++i) {
			if(_subExpr[i] == max) {
				aux += _expr[i];
				_subExpr[i] --;
			}else {
				if(aux.length() > 0) {
					System.out.println(aux);
					aux = "";					
				}
			}
		}
		
		System.out.println(aux);
		
//		
//		for(int i = 0; i < _subExpr.length; ++i) {
//			System.out.printf(" %d ", _subExpr[i]);
//		}
//		System.out.println();
		
		return _subExpr;
	}
	
	public static void popSubexpressions(char[] _expr, int[] _subExpr) {
		int[] _aux_subExpr = _subExpr; 
	
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < _expr.length; ++i) {
			if(min > _subExpr[i]) {
				min = _subExpr[i];
			}
			
			if(max <  _subExpr[i]) {
				max = _subExpr[i];
			}
		}
		

		System.out.println(min + " " + max);
		
		for(int i = max; i >= min; --i) {
			_subExpr = pop(_expr, _subExpr, i);			
		}
		
		
		
		
		
//		pop(_expr, _subExpr, 1);
//		pop(_expr, _subExpr, 0);
//		pop(_expr, _subExpr, -1);
		
		
	}
	

	public static void generateTable(int qtdeVariaveis, boolean[] variaveisUsadas) {
		
		System.out.println();
		
		int[][] truthTable = new int[(int) Math.pow(2, qtdeVariaveis)][qtdeVariaveis];

		//Variaveis
		if(variaveisUsadas[0]) {
			System.out.print("P ");
		}
		if(variaveisUsadas[1]) {
			System.out.print("Q ");
		}
		if(variaveisUsadas[2]) {
			System.out.print("R ");
		}
		if(variaveisUsadas[3]) {
			System.out.print("S ");
		} 
		
		
		System.out.println("|");
		
		//Numeros
		for(int i = 0; i < (int) Math.pow(2, qtdeVariaveis); ++i) {
			for(int j = qtdeVariaveis - 1; j >= 0; --j) {
				if( i / (int) Math.pow(2, j) % 2 == 1){
					truthTable[i][j] = i / (int) Math.pow(2, j) % 2 ;
				}
				System.out.printf("%d ", truthTable[i][j]);
			}
			System.out.println("|");
		}
		
	}
	
	
	
}
