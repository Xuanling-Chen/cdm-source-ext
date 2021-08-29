package cdm.legalagreement.csa;

import cdm.base.datetime.CustomisableOffset;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.PledgeeRepresentativeRiderMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The terms of the Rider for the ISDA Euroclear 2019 Collateral Transfer Agreement with respect to the use of a Pledgee Representative attached to this Agreement
 * @version ${project.version}
 */
@RosettaClass

public interface PledgeeRepresentativeRider extends RosettaModelObject {
	PledgeeRepresentativeRider build();
	PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder toBuilder();
	
	/**
	 * Identification of whether the representative CTA provisions are applicable (True) or not applicable (False)
	 */
	Boolean getIsApplicable();
	/**
	 * Identification of the represented party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The definition of representative end date in relation to a representative event.
	 */
	CustomisableOffset getRepresentativeEndDate();
	/**
	 * The specification of whether the representative event terms are applicable
	 */
	ExceptionEnum getRepresentativeEvent();
	/**
	 * The specific representative event terms applicable when specified.
	 */
	String getRepresentativeEventTerms();
	/**
	 * The specific representative terms applicable when specified.
	 */
	String getRepresentativeTerms();
	final static PledgeeRepresentativeRiderMeta metaData = new PledgeeRepresentativeRiderMeta();
	
	@Override
	default RosettaMetaData<? extends PledgeeRepresentativeRider> metaData() {
		return metaData;
	} 
			
	static PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder() {
		return new PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilderImpl();
	}
	
	default Class<? extends PledgeeRepresentativeRider> getType() {
		return PledgeeRepresentativeRider.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("representativeEvent"), ExceptionEnum.class, getRepresentativeEvent(), this);
		processor.processBasic(path.newSubPath("representativeEventTerms"), String.class, getRepresentativeEventTerms(), this);
		processor.processBasic(path.newSubPath("representativeTerms"), String.class, getRepresentativeTerms(), this);
		
		processRosetta(path.newSubPath("representativeEndDate"), processor, CustomisableOffset.class, getRepresentativeEndDate());
	}
	
	
	interface PledgeeRepresentativeRiderBuilder extends PledgeeRepresentativeRider, RosettaModelObjectBuilder {
		CustomisableOffset.CustomisableOffsetBuilder getOrCreateRepresentativeEndDate();
		CustomisableOffset.CustomisableOffsetBuilder getRepresentativeEndDate();
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setIsApplicable(Boolean isApplicable);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setParty(CounterpartyRoleEnum party);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEndDate(CustomisableOffset representativeEndDate);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEvent(ExceptionEnum representativeEvent);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEventTerms(String representativeEventTerms);
		PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeTerms(String representativeTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("representativeEvent"), ExceptionEnum.class, getRepresentativeEvent(), this);
			processor.processBasic(path.newSubPath("representativeEventTerms"), String.class, getRepresentativeEventTerms(), this);
			processor.processBasic(path.newSubPath("representativeTerms"), String.class, getRepresentativeTerms(), this);
			
			processRosetta(path.newSubPath("representativeEndDate"), processor, CustomisableOffset.CustomisableOffsetBuilder.class, getRepresentativeEndDate());
		}
		
	}
	
	//PledgeeRepresentativeRider.PledgeeRepresentativeRiderImpl
	class PledgeeRepresentativeRiderImpl implements PledgeeRepresentativeRider {
		private final Boolean isApplicable;
		private final CounterpartyRoleEnum party;
		private final CustomisableOffset representativeEndDate;
		private final ExceptionEnum representativeEvent;
		private final String representativeEventTerms;
		private final String representativeTerms;
		
		protected PledgeeRepresentativeRiderImpl(PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.party = builder.getParty();
			this.representativeEndDate = ofNullable(builder.getRepresentativeEndDate()).map(f->f.build()).orElse(null);
			this.representativeEvent = builder.getRepresentativeEvent();
			this.representativeEventTerms = builder.getRepresentativeEventTerms();
			this.representativeTerms = builder.getRepresentativeTerms();
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public CustomisableOffset getRepresentativeEndDate() {
			return representativeEndDate;
		}
		
		@Override
		public ExceptionEnum getRepresentativeEvent() {
			return representativeEvent;
		}
		
		@Override
		public String getRepresentativeEventTerms() {
			return representativeEventTerms;
		}
		
		@Override
		public String getRepresentativeTerms() {
			return representativeTerms;
		}
		
		@Override
		public PledgeeRepresentativeRider build() {
			return this;
		}
		
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder toBuilder() {
			PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRepresentativeEndDate()).ifPresent(builder::setRepresentativeEndDate);
			ofNullable(getRepresentativeEvent()).ifPresent(builder::setRepresentativeEvent);
			ofNullable(getRepresentativeEventTerms()).ifPresent(builder::setRepresentativeEventTerms);
			ofNullable(getRepresentativeTerms()).ifPresent(builder::setRepresentativeTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PledgeeRepresentativeRider _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(representativeEndDate, _that.getRepresentativeEndDate())) return false;
			if (!Objects.equals(representativeEvent, _that.getRepresentativeEvent())) return false;
			if (!Objects.equals(representativeEventTerms, _that.getRepresentativeEventTerms())) return false;
			if (!Objects.equals(representativeTerms, _that.getRepresentativeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeEndDate != null ? representativeEndDate.hashCode() : 0);
			_result = 31 * _result + (representativeEvent != null ? representativeEvent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeEventTerms != null ? representativeEventTerms.hashCode() : 0);
			_result = 31 * _result + (representativeTerms != null ? representativeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PledgeeRepresentativeRider {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"representativeEndDate=" + this.representativeEndDate + ", " +
				"representativeEvent=" + this.representativeEvent + ", " +
				"representativeEventTerms=" + this.representativeEventTerms + ", " +
				"representativeTerms=" + this.representativeTerms +
			'}';
		}
	}
	
	//PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilderImpl
	class PledgeeRepresentativeRiderBuilderImpl implements PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder {
	
		protected Boolean isApplicable;
		protected CounterpartyRoleEnum party;
		protected CustomisableOffset.CustomisableOffsetBuilder representativeEndDate;
		protected ExceptionEnum representativeEvent;
		protected String representativeEventTerms;
		protected String representativeTerms;
	
		public PledgeeRepresentativeRiderBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getRepresentativeEndDate() {
			return representativeEndDate;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder getOrCreateRepresentativeEndDate() {
			CustomisableOffset.CustomisableOffsetBuilder result;
			if (representativeEndDate!=null) {
				result = representativeEndDate;
			}
			else {
				result = representativeEndDate = CustomisableOffset.builder();
			}
			
			return result;
		}
		
		@Override
		public ExceptionEnum getRepresentativeEvent() {
			return representativeEvent;
		}
		
		@Override
		public String getRepresentativeEventTerms() {
			return representativeEventTerms;
		}
		
		@Override
		public String getRepresentativeTerms() {
			return representativeTerms;
		}
		
	
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEndDate(CustomisableOffset representativeEndDate) {
			this.representativeEndDate = representativeEndDate==null?null:representativeEndDate.toBuilder();
			return this;
		}
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEvent(ExceptionEnum representativeEvent) {
			this.representativeEvent = representativeEvent==null?null:representativeEvent;
			return this;
		}
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeEventTerms(String representativeEventTerms) {
			this.representativeEventTerms = representativeEventTerms==null?null:representativeEventTerms;
			return this;
		}
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder setRepresentativeTerms(String representativeTerms) {
			this.representativeTerms = representativeTerms==null?null:representativeTerms;
			return this;
		}
		
		@Override
		public PledgeeRepresentativeRider build() {
			return new PledgeeRepresentativeRider.PledgeeRepresentativeRiderImpl(this);
		}
		
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder prune() {
			if (representativeEndDate!=null && !representativeEndDate.prune().hasData()) representativeEndDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getParty()!=null) return true;
			if (getRepresentativeEndDate()!=null && getRepresentativeEndDate().hasData()) return true;
			if (getRepresentativeEvent()!=null) return true;
			if (getRepresentativeEventTerms()!=null) return true;
			if (getRepresentativeTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder o = (PledgeeRepresentativeRider.PledgeeRepresentativeRiderBuilder) other;
			
			merger.mergeRosetta(getRepresentativeEndDate(), o.getRepresentativeEndDate(), this::setRepresentativeEndDate);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRepresentativeEvent(), o.getRepresentativeEvent(), this::setRepresentativeEvent);
			merger.mergeBasic(getRepresentativeEventTerms(), o.getRepresentativeEventTerms(), this::setRepresentativeEventTerms);
			merger.mergeBasic(getRepresentativeTerms(), o.getRepresentativeTerms(), this::setRepresentativeTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PledgeeRepresentativeRider _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(representativeEndDate, _that.getRepresentativeEndDate())) return false;
			if (!Objects.equals(representativeEvent, _that.getRepresentativeEvent())) return false;
			if (!Objects.equals(representativeEventTerms, _that.getRepresentativeEventTerms())) return false;
			if (!Objects.equals(representativeTerms, _that.getRepresentativeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeEndDate != null ? representativeEndDate.hashCode() : 0);
			_result = 31 * _result + (representativeEvent != null ? representativeEvent.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (representativeEventTerms != null ? representativeEventTerms.hashCode() : 0);
			_result = 31 * _result + (representativeTerms != null ? representativeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PledgeeRepresentativeRiderBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"party=" + this.party + ", " +
				"representativeEndDate=" + this.representativeEndDate + ", " +
				"representativeEvent=" + this.representativeEvent + ", " +
				"representativeEventTerms=" + this.representativeEventTerms + ", " +
				"representativeTerms=" + this.representativeTerms +
			'}';
		}
	}
}
