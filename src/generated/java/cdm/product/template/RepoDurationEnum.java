package cdm.product.template;


/**
 * A duration code for a Repo (or Securities Lending) transaction. There are many business and market rules that are derived from the duration of the transaction.
 * @version ${project.version}
 */
public enum RepoDurationEnum {
    

	/**
	 * Indicates that a contract is classified as overnight, meaning that there is one business day difference between the start and end date of the contract. Business rule: When the repo is overnight, the number of business days between the spot and forward value dates must be one. Forward leg must be specified.
	 */
	OVERNIGHT,
	    

	/**
	 * Indicates that a contract is a regular term contract, with a start date and an end date. Business rule: When the repo is &#39;Term&#39;, both spot and forward legs must be specified.
	 */
	TERM    
	;

	private final String displayName;
	
	RepoDurationEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
