import java.util.*;

class returnsOnInvestments {
	class Return{
		String symbol;
		int amount;
		public Return(String s, int a){
			symbol = s;
			amount = a;
		}
	}

	public static void main(String[] args){
		returnsOnInvestments intance = new returnsOnInvestments();
		String holdings = "10 aapl $1000\n30 msft $100\n100 amzn $1000";
		String tradings = "bought aapl 5 $500\nbought msft 10 $50\nbought amzn 100 $100\nsold msft 100 $100";
		System.out.println(intance.calReturns(holdings, tradings));
	}

	public String calReturns(String holdings, String tradings){
		String[] holding_list = holdings.split("\n");
		HashMap<String, Integer> holdings_map = new HashMap<>();
		for(String holding: holding_list){
			String[] holding_info = holding.split(" ");
			String symbol = holding_info[1];
			int amount = Integer.parseInt(holding_info[0]) * Integer.parseInt(holding_info[2].split("\\$")[1]);
			holdings_map.put(symbol, amount);
		}
		String[] trading_list = tradings.split("\n");
		for(String trading: trading_list){
			String[] trading_info = trading.split(" ");
			String action = trading_info[0];
			String symbol = trading_info[1];
			int amount = Integer.parseInt(trading_info[2]) * Integer.parseInt(trading_info[3].split("\\$")[1]);
			if(action.equals("bought")){
				holdings_map.put(symbol, holdings_map.get(symbol) - amount);
			}
			else if(action.equals("sold")){
				holdings_map.put(symbol, holdings_map.get(symbol) + amount);
			}
		}
		PriorityQueue<Return> returns = new PriorityQueue<>(new Comparator<Return>(){
			public int compare(Return r1, Return r2){
				if(r1.amount > r2.amount) return -1;
				else return 1;
			}
		});

		for(String symbol: holdings_map.keySet()){
			returns.offer(new Return(symbol, holdings_map.get(symbol)));
		}
		String res = "";
		while(!returns.isEmpty()){
			if(!res.isEmpty()) res += "\n";
			Return cur_return = returns.poll();
			res += cur_return.symbol + " ";
			if(cur_return.amount >= 0) res += "$" + cur_return.amount;
			else res += "-$" + cur_return.amount;
		}
		return res;
	}
}