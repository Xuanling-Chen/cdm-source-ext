package cdm.product.asset;


/**
 * The enumerated values to specify how the composition of Dividends is to be determined.
 * @version ${project.version}
 */
public enum DividendCompositionEnum {
    

	/**
	 * The Equity Amount Receiver determines the composition of dividends (subject to conditions).
	 */
	EQUITY_AMOUNT_RECEIVER_ELECTION,
	    

	/**
	 * The Calculation Agent determines the composition of dividends (subject to conditions).
	 */
	CALCULATION_AGENT_ELECTION    
	;

	private final String displayName;
	
	DividendCompositionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
