package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.WalletMeta;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Wallet extends RosettaModelObject, GlobalKey {
	Wallet build();
	Wallet.WalletBuilder toBuilder();
	
	/**
	 */
	ReferenceWithMetaAccount getAccountGlobalRef();
	/**
	 */
	List<? extends Card> getCards();
	/**
	 */
	MetaFields getMeta();
	final static WalletMeta metaData = new WalletMeta();
	
	@Override
	default RosettaMetaData<? extends Wallet> metaData() {
		return metaData;
	} 
			
	static Wallet.WalletBuilder builder() {
		return new Wallet.WalletBuilderImpl();
	}
	
	default Class<? extends Wallet> getType() {
		return Wallet.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("accountGlobalRef"), processor, ReferenceWithMetaAccount.class, getAccountGlobalRef());
		processRosetta(path.newSubPath("cards"), processor, Card.class, getCards());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface WalletBuilder extends Wallet, RosettaModelObjectBuilder {
		ReferenceWithMetaAccountBuilder getOrCreateAccountGlobalRef();
		ReferenceWithMetaAccountBuilder getAccountGlobalRef();
		Card.CardBuilder getOrCreateCards(int _index);
		List<? extends Card.CardBuilder> getCards();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Wallet.WalletBuilder setAccountGlobalRef(ReferenceWithMetaAccount accountGlobalRef);
		Wallet.WalletBuilder setAccountGlobalRefValue(Account accountGlobalRef);
		Wallet.WalletBuilder addCards(Card cards);
		Wallet.WalletBuilder addCards(Card cards, int _idx);
		Wallet.WalletBuilder addCards(List<? extends Card> cards);
		Wallet.WalletBuilder setCards(List<? extends Card> cards);
		Wallet.WalletBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("accountGlobalRef"), processor, ReferenceWithMetaAccountBuilder.class, getAccountGlobalRef());
			processRosetta(path.newSubPath("cards"), processor, Card.CardBuilder.class, getCards());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Wallet.WalletImpl
	class WalletImpl implements Wallet {
		private final ReferenceWithMetaAccount accountGlobalRef;
		private final List<? extends Card> cards;
		private final MetaFields meta;
		
		protected WalletImpl(Wallet.WalletBuilder builder) {
			this.accountGlobalRef = ofNullable(builder.getAccountGlobalRef()).map(f->f.build()).orElse(null);
			this.cards = ofNullable(builder.getCards()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ReferenceWithMetaAccount getAccountGlobalRef() {
			return accountGlobalRef;
		}
		
		@Override
		public List<? extends Card> getCards() {
			return cards;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Wallet build() {
			return this;
		}
		
		@Override
		public Wallet.WalletBuilder toBuilder() {
			Wallet.WalletBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Wallet.WalletBuilder builder) {
			ofNullable(getAccountGlobalRef()).ifPresent(builder::setAccountGlobalRef);
			ofNullable(getCards()).ifPresent(builder::setCards);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Wallet _that = getType().cast(o);
		
			if (!Objects.equals(accountGlobalRef, _that.getAccountGlobalRef())) return false;
			if (!ListEquals.listEquals(cards, _that.getCards())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountGlobalRef != null ? accountGlobalRef.hashCode() : 0);
			_result = 31 * _result + (cards != null ? cards.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Wallet {" +
				"accountGlobalRef=" + this.accountGlobalRef + ", " +
				"cards=" + this.cards + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//Wallet.WalletBuilderImpl
	class WalletBuilderImpl implements Wallet.WalletBuilder, GlobalKeyBuilder {
	
		protected ReferenceWithMetaAccountBuilder accountGlobalRef;
		protected List<Card.CardBuilder> cards = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
	
		public WalletBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaAccountBuilder getAccountGlobalRef() {
			return accountGlobalRef;
		}
		
		@Override
		public ReferenceWithMetaAccountBuilder getOrCreateAccountGlobalRef() {
			ReferenceWithMetaAccountBuilder result;
			if (accountGlobalRef!=null) {
				result = accountGlobalRef;
			}
			else {
				result = accountGlobalRef = ReferenceWithMetaAccount.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Card.CardBuilder> getCards() {
			return cards;
		}
		
		public Card.CardBuilder getOrCreateCards(int _index) {
		
			if (cards==null) {
				this.cards = new ArrayList<>();
			}
			Card.CardBuilder result;
			return getIndex(cards, _index, () -> {
						Card.CardBuilder newCards = Card.builder();
						return newCards;
					});
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
		public Wallet.WalletBuilder setAccountGlobalRef(ReferenceWithMetaAccount accountGlobalRef) {
			this.accountGlobalRef = accountGlobalRef==null?null:accountGlobalRef.toBuilder();
			return this;
		}
		
		@Override
		public Wallet.WalletBuilder setAccountGlobalRefValue(Account accountGlobalRef) {
			this.getOrCreateAccountGlobalRef().setValue(accountGlobalRef);
			return this;
		}
		@Override
		public Wallet.WalletBuilder addCards(Card cards) {
			if (cards!=null) this.cards.add(cards.toBuilder());
			return this;
		}
		
		@Override
		public Wallet.WalletBuilder addCards(Card cards, int _idx) {
			getIndex(this.cards, _idx, () -> cards.toBuilder());
			return this;
		}
		@Override 
		public Wallet.WalletBuilder addCards(List<? extends Card> cardss) {
			if (cardss != null) {
				for (Card toAdd : cardss) {
					this.cards.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Wallet.WalletBuilder setCards(List<? extends Card> cardss) {
			if (cardss == null)  {
				this.cards = new ArrayList<>();
			}
			else {
				this.cards = cardss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Wallet.WalletBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public Wallet build() {
			return new Wallet.WalletImpl(this);
		}
		
		@Override
		public Wallet.WalletBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Wallet.WalletBuilder prune() {
			if (accountGlobalRef!=null && !accountGlobalRef.prune().hasData()) accountGlobalRef = null;
			cards = cards.stream().filter(b->b!=null).<Card.CardBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountGlobalRef()!=null && getAccountGlobalRef().hasData()) return true;
			if (getCards()!=null && getCards().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Wallet.WalletBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Wallet.WalletBuilder o = (Wallet.WalletBuilder) other;
			
			merger.mergeRosetta(getAccountGlobalRef(), o.getAccountGlobalRef(), this::setAccountGlobalRef);
			merger.mergeRosetta(getCards(), o.getCards(), this::getOrCreateCards);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Wallet _that = getType().cast(o);
		
			if (!Objects.equals(accountGlobalRef, _that.getAccountGlobalRef())) return false;
			if (!ListEquals.listEquals(cards, _that.getCards())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountGlobalRef != null ? accountGlobalRef.hashCode() : 0);
			_result = 31 * _result + (cards != null ? cards.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WalletBuilder {" +
				"accountGlobalRef=" + this.accountGlobalRef + ", " +
				"cards=" + this.cards + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
