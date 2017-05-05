
public class Expression {

	public String addr;
	public String code;

	
	public Expression(String addr) {
		this.addr = addr;
		this.code = "";
	}
	
	//	Combining two different expressions.
	public Expression(String e1Addrss, String e2addr, String opeation, int counter) {
		this.addr = "t" + counter;
		this.code = this.addr + " = " + e1Addrss + " " + opeation + " " + e2addr;
	}


	public Expression(Expression e1, Expression e2, String operator,int counter) {
		this.addr = "t" + counter;
		//System.err.println("combining two expressions");
		if (e1.code.length() > 0 && e2.code.length() > 0) {
			this.code = e1.code + "\n" + e2.code + "\n" + this.addr + " = " + e1.addr + " " + operator + " "
					+ e2.addr;
			//System.out.println("1###");
			
		} else {
			if (e2.code.length() > 0) {
				this.code = e2.code + "\n" + this.addr + " = " + e1.addr + " " + operator + " "
						+ e2.addr;
				//System.out.println("2###");
			} else {
				if (e1.code.length() > 0) {
					this.code = e1.code + "\n" + this.addr + " = " + e1.addr + " " + operator + " "
							+ e2.addr + " ";
					//System.out.println("3###");
				} else {
					//	Delimiter is used to handle cases were an expression contained in bracket is held.
					this.code = "$$" + this.addr + " = " + e1.addr + " " + operator + " " + e2.addr ;
					//System.out.println("4###");
				}
			}
		}
	}
	
	public String toString() {
		return this.addr + "\n" + this.code;
	}

}
