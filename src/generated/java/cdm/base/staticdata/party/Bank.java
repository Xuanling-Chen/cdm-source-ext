package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.BankMeta;
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

public interface Bank extends RosettaModelObject, GlobalKey {
	Bank build();
	Bank.BankBuilder toBuilder();
	
	/**
	 */
	String getBankId();
	/**
	 */
	String getBankName();
	/**
	 */
	MetaFields getMeta();
	final static BankMeta metaData = new BankMeta();
	
	@Override
	default RosettaMetaData<? extends Bank> metaData() {
		return metaData;
	} 
			
	static Bank.BankBuilder builder() {
		return new Bank.BankBuilderImpl();
	}
	
	default Class<? extends Bank> getType() {
		return Bank.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bankId"), String.class, getBankId(), this);
		processor.processBasic(path.newSubPath("bankName"), String.class, getBankName(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface BankBuilder extends Bank, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Bank.BankBuilder setBankId(String bankId);
		Bank.BankBuilder setBankName(String bankName);
		Bank.BankBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bankId"), String.class, getBankId(), this);
			processor.processBasic(path.newSubPath("bankName"), String.class, getBankName(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//Bank.BankImpl
	class BankImpl implements Bank {
		private final String bankId;
		private final String bankName;
		private final MetaFields meta;
		
		protected BankImpl(Bank.BankBuilder builder) {
			this.bankId = builder.getBankId();
			this.bankName = builder.getBankName();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getBankId() {
			return bankId;
		}
		
		@Override
		public String getBankName() {
			return bankName;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Bank build() {
			return this;
		}
		
		@Override
		public Bank.BankBuilder toBuilder() {
			Bank.BankBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Bank.BankBuilder builder) {
			ofNullable(getBankId()).ifPresent(builder::setBankId);
			ofNullable(getBankName()).ifPresent(builder::setBankName);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Bank _that = getType().cast(o);
		
			if (!Objects.equals(bankId, _that.getBankId())) return false;
			if (!Objects.equals(bankName, _that.getBankName())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bankId != null ? bankId.hashCode() : 0);
			_result = 31 * _result + (bankName != null ? bankName.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Bank {" +
				"bankId=" + this.bankId + ", " +
				"bankName=" + this.bankName + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//Bank.BankBuilderImpl
	class BankBuilderImpl implements Bank.BankBuilder, GlobalKeyBuilder {
	
		protected String bankId;
		protected String bankName;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public BankBuilderImpl() {
		}
	
		@Override
		public String getBankId() {
			return bankId;
		}
		
		@Override
		public String getBankName() {
			return bankName;
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
		public Bank.BankBuilder setBankId(String bankId) {
			this.bankId = bankId==null?null:bankId;
			return this;
		}
		@Override
		public Bank.BankBuilder setBankName(String bankName) {
			this.bankName = bankName==null?null:bankName;
			return this;
		}
		@Override
		public Bank.BankBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public Bank build() {
			return new Bank.BankImpl(this);
		}
		
		@Override
		public Bank.BankBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bank.BankBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBankId()!=null) return true;
			if (getBankName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bank.BankBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Bank.BankBuilder o = (Bank.BankBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getBankId(), o.getBankId(), this::setBankId);
			merger.mergeBasic(getBankName(), o.getBankName(), this::setBankName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Bank _that = getType().cast(o);
		
			if (!Objects.equals(bankId, _that.getBankId())) return false;
			if (!Objects.equals(bankName, _that.getBankName())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bankId != null ? bankId.hashCode() : 0);
			_result = 31 * _result + (bankName != null ? bankName.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BankBuilder {" +
				"bankId=" + this.bankId + ", " +
				"bankName=" + this.bankName + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
