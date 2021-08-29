package cdm.product.common.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.functions.Qualify_AssetClass_InterestRate_Swap;
import cdm.product.common.settlement.PrincipalExchanges;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_BaseProduct_CrossCurrency.Qualify_BaseProduct_CrossCurrencyDefault.class)
public abstract class Qualify_BaseProduct_CrossCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_InterestRate_Swap qualify_AssetClass_InterestRate_Swap;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		
		Boolean is_productHolder = doEvaluate(economicTerms);
		Boolean is_product = assignOutput(is_productHolder, economicTerms);
		
		return is_product;
	}
	
	private Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
		is_product = areEqual(MapperS.of(qualify_AssetClass_InterestRate_Swap.evaluate(MapperS.of(economicTerms).get())), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PrincipalExchanges>map("getPrincipalExchanges", _interestRatePayout -> _interestRatePayout.getPrincipalExchanges()))).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	public static final class Qualify_BaseProduct_CrossCurrencyDefault extends Qualify_BaseProduct_CrossCurrency {
		@Override
		protected  Boolean doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
}
