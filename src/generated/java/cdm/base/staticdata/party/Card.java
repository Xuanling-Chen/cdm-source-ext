package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.CardMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaBank;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaBank.ReferenceWithMetaBankBuilder;
import cdm.observable.asset.Money;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Card extends RosettaModelObject, GlobalKey {
	Card build();
	Card.CardBuilder toBuilder();
	
	/**
	 */
	Money getBalance();
	/**
	 */
	ReferenceWithMetaBank getBankGlobalRef();
	/**
	 */
	String getCardNumber();
	/**
	 */
	String getCurrency();
	/**
	 */
	Boolean getIsDefaultCard();
	/**
	 */
	MetaFields getMeta();
	final static CardMeta metaData = new CardMeta();
	
	@Override
	default RosettaMetaData<? extends Card> metaData() {
		return metaData;
	} 
			
	static Card.CardBuilder builder() {
		return new Card.CardBuilderImpl();
	}
	
	default Class<? extends Card> getType() {
		return Card.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cardNumber"), String.class, getCardNumber(), this);
		processor.processBasic(path.newSubPath("currency"), String.class, getCurrency(), this);
		processor.processBasic(path.newSubPath("isDefaultCard"), Boolean.class, getIsDefaultCard(), this);
		
		processRosetta(path.newSubPath("balance"), processor, Money.class, getBalance());
		processRosetta(path.newSubPath("bankGlobalRef"), processor, ReferenceWithMetaBank.class, getBankGlobalRef());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface CardBuilder extends Card, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateBalance();
		Money.MoneyBuilder getBalance();
		ReferenceWithMetaBankBuilder getOrCreateBankGlobalRef();
		ReferenceWithMetaBankBuilder getBankGlobalRef();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Card.CardBuilder setBalance(Money balance);
		Card.CardBuilder setBankGlobalRef(ReferenceWithMetaBank bankGlobalRef);
		Card.CardBuilder setBankGlobalRefValue(Bank bankGlobalRef);
		Card.CardBuilder setCardNumber(String cardNumber);
		Card.CardBuilder setCurrency(String currency);
		Card.CardBuilder setIsDefaultCard(Boolean isDefaultCard);
		Card.CardBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("cardNumber"), String.class, getCardNumber(), this);
			processor.processBasic(path.newSubPath("currency"), String.class, getCurrency(), this);
			processor.processBasic(path.newSubPath("isDefaultCard"), Boolean.class, getIsDefaultCard(), this);
			
			processRosetta(path.newSubPath("balance"), processor, Money.MoneyBuilder.class, getBalance());
			processRosetta(path.newSubPath("bankGlobalRef"), processor, ReferenceWithMetaBankBuilder.class, getBankGlobalRef());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Card.CardImpl
	class CardImpl implements Card {
		private final Money balance;
		private final ReferenceWithMetaBank bankGlobalRef;
		private final String cardNumber;
		private final String currency;
		private final Boolean isDefaultCard;
		private final MetaFields meta;
		
		protected CardImpl(Card.CardBuilder builder) {
			this.balance = ofNullable(builder.getBalance()).map(f->f.build()).orElse(null);
			this.bankGlobalRef = ofNullable(builder.getBankGlobalRef()).map(f->f.build()).orElse(null);
			this.cardNumber = builder.getCardNumber();
			this.currency = builder.getCurrency();
			this.isDefaultCard = builder.getIsDefaultCard();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getBalance() {
			return balance;
		}
		
		@Override
		public ReferenceWithMetaBank getBankGlobalRef() {
			return bankGlobalRef;
		}
		
		@Override
		public String getCardNumber() {
			return cardNumber;
		}
		
		@Override
		public String getCurrency() {
			return currency;
		}
		
		@Override
		public Boolean getIsDefaultCard() {
			return isDefaultCard;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Card build() {
			return this;
		}
		
		@Override
		public Card.CardBuilder toBuilder() {
			Card.CardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Card.CardBuilder builder) {
			ofNullable(getBalance()).ifPresent(builder::setBalance);
			ofNullable(getBankGlobalRef()).ifPresent(builder::setBankGlobalRef);
			ofNullable(getCardNumber()).ifPresent(builder::setCardNumber);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getIsDefaultCard()).ifPresent(builder::setIsDefaultCard);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Card _that = getType().cast(o);
		
			if (!Objects.equals(balance, _that.getBalance())) return false;
			if (!Objects.equals(bankGlobalRef, _that.getBankGlobalRef())) return false;
			if (!Objects.equals(cardNumber, _that.getCardNumber())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(isDefaultCard, _that.getIsDefaultCard())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (balance != null ? balance.hashCode() : 0);
			_result = 31 * _result + (bankGlobalRef != null ? bankGlobalRef.hashCode() : 0);
			_result = 31 * _result + (cardNumber != null ? cardNumber.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (isDefaultCard != null ? isDefaultCard.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Card {" +
				"balance=" + this.balance + ", " +
				"bankGlobalRef=" + this.bankGlobalRef + ", " +
				"cardNumber=" + this.cardNumber + ", " +
				"currency=" + this.currency + ", " +
				"isDefaultCard=" + this.isDefaultCard + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//Card.CardBuilderImpl
	class CardBuilderImpl implements Card.CardBuilder, GlobalKeyBuilder {
	
		protected Money.MoneyBuilder balance;
		protected ReferenceWithMetaBankBuilder bankGlobalRef;
		protected String cardNumber;
		protected String currency;
		protected Boolean isDefaultCard;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public CardBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getBalance() {
			return balance;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateBalance() {
			Money.MoneyBuilder result;
			if (balance!=null) {
				result = balance;
			}
			else {
				result = balance = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public ReferenceWithMetaBankBuilder getBankGlobalRef() {
			return bankGlobalRef;
		}
		
		@Override
		public ReferenceWithMetaBankBuilder getOrCreateBankGlobalRef() {
			ReferenceWithMetaBankBuilder result;
			if (bankGlobalRef!=null) {
				result = bankGlobalRef;
			}
			else {
				result = bankGlobalRef = ReferenceWithMetaBank.builder();
			}
			
			return result;
		}
		
		@Override
		public String getCardNumber() {
			return cardNumber;
		}
		
		@Override
		public String getCurrency() {
			return currency;
		}
		
		@Override
		public Boolean getIsDefaultCard() {
			return isDefaultCard;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Card.CardBuilder setBalance(Money balance) {
			this.balance = balance==null?null:balance.toBuilder();
			return this;
		}
		@Override
		public Card.CardBuilder setBankGlobalRef(ReferenceWithMetaBank bankGlobalRef) {
			this.bankGlobalRef = bankGlobalRef==null?null:bankGlobalRef.toBuilder();
			return this;
		}
		
		@Override
		public Card.CardBuilder setBankGlobalRefValue(Bank bankGlobalRef) {
			this.getOrCreateBankGlobalRef().setValue(bankGlobalRef);
			return this;
		}
		@Override
		public Card.CardBuilder setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber==null?null:cardNumber;
			return this;
		}
		@Override
		public Card.CardBuilder setCurrency(String currency) {
			this.currency = currency==null?null:currency;
			return this;
		}
		@Override
		public Card.CardBuilder setIsDefaultCard(Boolean isDefaultCard) {
			this.isDefaultCard = isDefaultCard==null?null:isDefaultCard;
			return this;
		}
		@Override
		public Card.CardBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public Card build() {
			return new Card.CardImpl(this);
		}
		
		@Override
		public Card.CardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Card.CardBuilder prune() {
			if (balance!=null && !balance.prune().hasData()) balance = null;
			if (bankGlobalRef!=null && !bankGlobalRef.prune().hasData()) bankGlobalRef = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBalance()!=null && getBalance().hasData()) return true;
			if (getBankGlobalRef()!=null && getBankGlobalRef().hasData()) return true;
			if (getCardNumber()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getIsDefaultCard()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Card.CardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Card.CardBuilder o = (Card.CardBuilder) other;
			
			merger.mergeRosetta(getBalance(), o.getBalance(), this::setBalance);
			merger.mergeRosetta(getBankGlobalRef(), o.getBankGlobalRef(), this::setBankGlobalRef);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getCardNumber(), o.getCardNumber(), this::setCardNumber);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeBasic(getIsDefaultCard(), o.getIsDefaultCard(), this::setIsDefaultCard);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Card _that = getType().cast(o);
		
			if (!Objects.equals(balance, _that.getBalance())) return false;
			if (!Objects.equals(bankGlobalRef, _that.getBankGlobalRef())) return false;
			if (!Objects.equals(cardNumber, _that.getCardNumber())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(isDefaultCard, _that.getIsDefaultCard())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (balance != null ? balance.hashCode() : 0);
			_result = 31 * _result + (bankGlobalRef != null ? bankGlobalRef.hashCode() : 0);
			_result = 31 * _result + (cardNumber != null ? cardNumber.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (isDefaultCard != null ? isDefaultCard.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CardBuilder {" +
				"balance=" + this.balance + ", " +
				"bankGlobalRef=" + this.bankGlobalRef + ", " +
				"cardNumber=" + this.cardNumber + ", " +
				"currency=" + this.currency + ", " +
				"isDefaultCard=" + this.isDefaultCard + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
