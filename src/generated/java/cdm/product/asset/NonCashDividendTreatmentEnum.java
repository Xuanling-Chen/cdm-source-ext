package cdm.product.asset;


/**
 * The enumerated values to specify the treatment of Non-Cash Dividends.
 * @version ${project.version}
 */
public enum NonCashDividendTreatmentEnum {
    

	/**
	 * The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions.
	 */
	POTENTIAL_ADJUSTMENT_EVENT,
	    

	/**
	 * Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend.
	 */
	CASH_EQUIVALENT    
	;

	private final String displayName;
	
	NonCashDividendTreatmentEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
