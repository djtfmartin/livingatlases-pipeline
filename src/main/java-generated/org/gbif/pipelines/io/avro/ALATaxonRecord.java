/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.gbif.pipelines.io.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
/** An ALA Name Match */
@org.apache.avro.specific.AvroGenerated
public class ALATaxonRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1491284141578755851L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ALATaxonRecord\",\"namespace\":\"org.gbif.pipelines.io.avro\",\"doc\":\"An ALA Name Match\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lsid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"cleanName\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"acceptedLsid\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"left\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"right\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"rank\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"matchType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"synonymType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ALATaxonRecord> ENCODER =
      new BinaryMessageEncoder<ALATaxonRecord>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ALATaxonRecord> DECODER =
      new BinaryMessageDecoder<ALATaxonRecord>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<ALATaxonRecord> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<ALATaxonRecord> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ALATaxonRecord>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this ALATaxonRecord to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a ALATaxonRecord from a ByteBuffer. */
  public static ALATaxonRecord fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String id;
  @Deprecated public java.lang.String lsid;
  @Deprecated public java.lang.String cleanName;
  @Deprecated public java.lang.String acceptedLsid;
  @Deprecated public java.lang.String left;
  @Deprecated public java.lang.String right;
  @Deprecated public java.lang.String rank;
  @Deprecated public java.lang.String matchType;
  @Deprecated public java.lang.String synonymType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ALATaxonRecord() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param lsid The new value for lsid
   * @param cleanName The new value for cleanName
   * @param acceptedLsid The new value for acceptedLsid
   * @param left The new value for left
   * @param right The new value for right
   * @param rank The new value for rank
   * @param matchType The new value for matchType
   * @param synonymType The new value for synonymType
   */
  public ALATaxonRecord(java.lang.String id, java.lang.String lsid, java.lang.String cleanName, java.lang.String acceptedLsid, java.lang.String left, java.lang.String right, java.lang.String rank, java.lang.String matchType, java.lang.String synonymType) {
    this.id = id;
    this.lsid = lsid;
    this.cleanName = cleanName;
    this.acceptedLsid = acceptedLsid;
    this.left = left;
    this.right = right;
    this.rank = rank;
    this.matchType = matchType;
    this.synonymType = synonymType;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return lsid;
    case 2: return cleanName;
    case 3: return acceptedLsid;
    case 4: return left;
    case 5: return right;
    case 6: return rank;
    case 7: return matchType;
    case 8: return synonymType;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.String)value$; break;
    case 1: lsid = (java.lang.String)value$; break;
    case 2: cleanName = (java.lang.String)value$; break;
    case 3: acceptedLsid = (java.lang.String)value$; break;
    case 4: left = (java.lang.String)value$; break;
    case 5: right = (java.lang.String)value$; break;
    case 6: rank = (java.lang.String)value$; break;
    case 7: matchType = (java.lang.String)value$; break;
    case 8: synonymType = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'lsid' field.
   * @return The value of the 'lsid' field.
   */
  public java.lang.String getLsid() {
    return lsid;
  }

  /**
   * Sets the value of the 'lsid' field.
   * @param value the value to set.
   */
  public void setLsid(java.lang.String value) {
    this.lsid = value;
  }

  /**
   * Gets the value of the 'cleanName' field.
   * @return The value of the 'cleanName' field.
   */
  public java.lang.String getCleanName() {
    return cleanName;
  }

  /**
   * Sets the value of the 'cleanName' field.
   * @param value the value to set.
   */
  public void setCleanName(java.lang.String value) {
    this.cleanName = value;
  }

  /**
   * Gets the value of the 'acceptedLsid' field.
   * @return The value of the 'acceptedLsid' field.
   */
  public java.lang.String getAcceptedLsid() {
    return acceptedLsid;
  }

  /**
   * Sets the value of the 'acceptedLsid' field.
   * @param value the value to set.
   */
  public void setAcceptedLsid(java.lang.String value) {
    this.acceptedLsid = value;
  }

  /**
   * Gets the value of the 'left' field.
   * @return The value of the 'left' field.
   */
  public java.lang.String getLeft() {
    return left;
  }

  /**
   * Sets the value of the 'left' field.
   * @param value the value to set.
   */
  public void setLeft(java.lang.String value) {
    this.left = value;
  }

  /**
   * Gets the value of the 'right' field.
   * @return The value of the 'right' field.
   */
  public java.lang.String getRight() {
    return right;
  }

  /**
   * Sets the value of the 'right' field.
   * @param value the value to set.
   */
  public void setRight(java.lang.String value) {
    this.right = value;
  }

  /**
   * Gets the value of the 'rank' field.
   * @return The value of the 'rank' field.
   */
  public java.lang.String getRank() {
    return rank;
  }

  /**
   * Sets the value of the 'rank' field.
   * @param value the value to set.
   */
  public void setRank(java.lang.String value) {
    this.rank = value;
  }

  /**
   * Gets the value of the 'matchType' field.
   * @return The value of the 'matchType' field.
   */
  public java.lang.String getMatchType() {
    return matchType;
  }

  /**
   * Sets the value of the 'matchType' field.
   * @param value the value to set.
   */
  public void setMatchType(java.lang.String value) {
    this.matchType = value;
  }

  /**
   * Gets the value of the 'synonymType' field.
   * @return The value of the 'synonymType' field.
   */
  public java.lang.String getSynonymType() {
    return synonymType;
  }

  /**
   * Sets the value of the 'synonymType' field.
   * @param value the value to set.
   */
  public void setSynonymType(java.lang.String value) {
    this.synonymType = value;
  }

  /**
   * Creates a new ALATaxonRecord RecordBuilder.
   * @return A new ALATaxonRecord RecordBuilder
   */
  public static org.gbif.pipelines.io.avro.ALATaxonRecord.Builder newBuilder() {
    return new org.gbif.pipelines.io.avro.ALATaxonRecord.Builder();
  }

  /**
   * Creates a new ALATaxonRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ALATaxonRecord RecordBuilder
   */
  public static org.gbif.pipelines.io.avro.ALATaxonRecord.Builder newBuilder(org.gbif.pipelines.io.avro.ALATaxonRecord.Builder other) {
    return new org.gbif.pipelines.io.avro.ALATaxonRecord.Builder(other);
  }

  /**
   * Creates a new ALATaxonRecord RecordBuilder by copying an existing ALATaxonRecord instance.
   * @param other The existing instance to copy.
   * @return A new ALATaxonRecord RecordBuilder
   */
  public static org.gbif.pipelines.io.avro.ALATaxonRecord.Builder newBuilder(org.gbif.pipelines.io.avro.ALATaxonRecord other) {
    return new org.gbif.pipelines.io.avro.ALATaxonRecord.Builder(other);
  }

  /**
   * RecordBuilder for ALATaxonRecord instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ALATaxonRecord>
    implements org.apache.avro.data.RecordBuilder<ALATaxonRecord> {

    private java.lang.String id;
    private java.lang.String lsid;
    private java.lang.String cleanName;
    private java.lang.String acceptedLsid;
    private java.lang.String left;
    private java.lang.String right;
    private java.lang.String rank;
    private java.lang.String matchType;
    private java.lang.String synonymType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.gbif.pipelines.io.avro.ALATaxonRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lsid)) {
        this.lsid = data().deepCopy(fields()[1].schema(), other.lsid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.cleanName)) {
        this.cleanName = data().deepCopy(fields()[2].schema(), other.cleanName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.acceptedLsid)) {
        this.acceptedLsid = data().deepCopy(fields()[3].schema(), other.acceptedLsid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.left)) {
        this.left = data().deepCopy(fields()[4].schema(), other.left);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.right)) {
        this.right = data().deepCopy(fields()[5].schema(), other.right);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.rank)) {
        this.rank = data().deepCopy(fields()[6].schema(), other.rank);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.matchType)) {
        this.matchType = data().deepCopy(fields()[7].schema(), other.matchType);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.synonymType)) {
        this.synonymType = data().deepCopy(fields()[8].schema(), other.synonymType);
        fieldSetFlags()[8] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ALATaxonRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(org.gbif.pipelines.io.avro.ALATaxonRecord other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lsid)) {
        this.lsid = data().deepCopy(fields()[1].schema(), other.lsid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.cleanName)) {
        this.cleanName = data().deepCopy(fields()[2].schema(), other.cleanName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.acceptedLsid)) {
        this.acceptedLsid = data().deepCopy(fields()[3].schema(), other.acceptedLsid);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.left)) {
        this.left = data().deepCopy(fields()[4].schema(), other.left);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.right)) {
        this.right = data().deepCopy(fields()[5].schema(), other.right);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.rank)) {
        this.rank = data().deepCopy(fields()[6].schema(), other.rank);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.matchType)) {
        this.matchType = data().deepCopy(fields()[7].schema(), other.matchType);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.synonymType)) {
        this.synonymType = data().deepCopy(fields()[8].schema(), other.synonymType);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'lsid' field.
      * @return The value.
      */
    public java.lang.String getLsid() {
      return lsid;
    }

    /**
      * Sets the value of the 'lsid' field.
      * @param value The value of 'lsid'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setLsid(java.lang.String value) {
      validate(fields()[1], value);
      this.lsid = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'lsid' field has been set.
      * @return True if the 'lsid' field has been set, false otherwise.
      */
    public boolean hasLsid() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'lsid' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearLsid() {
      lsid = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'cleanName' field.
      * @return The value.
      */
    public java.lang.String getCleanName() {
      return cleanName;
    }

    /**
      * Sets the value of the 'cleanName' field.
      * @param value The value of 'cleanName'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setCleanName(java.lang.String value) {
      validate(fields()[2], value);
      this.cleanName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'cleanName' field has been set.
      * @return True if the 'cleanName' field has been set, false otherwise.
      */
    public boolean hasCleanName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'cleanName' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearCleanName() {
      cleanName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'acceptedLsid' field.
      * @return The value.
      */
    public java.lang.String getAcceptedLsid() {
      return acceptedLsid;
    }

    /**
      * Sets the value of the 'acceptedLsid' field.
      * @param value The value of 'acceptedLsid'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setAcceptedLsid(java.lang.String value) {
      validate(fields()[3], value);
      this.acceptedLsid = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'acceptedLsid' field has been set.
      * @return True if the 'acceptedLsid' field has been set, false otherwise.
      */
    public boolean hasAcceptedLsid() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'acceptedLsid' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearAcceptedLsid() {
      acceptedLsid = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'left' field.
      * @return The value.
      */
    public java.lang.String getLeft() {
      return left;
    }

    /**
      * Sets the value of the 'left' field.
      * @param value The value of 'left'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setLeft(java.lang.String value) {
      validate(fields()[4], value);
      this.left = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'left' field has been set.
      * @return True if the 'left' field has been set, false otherwise.
      */
    public boolean hasLeft() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'left' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearLeft() {
      left = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'right' field.
      * @return The value.
      */
    public java.lang.String getRight() {
      return right;
    }

    /**
      * Sets the value of the 'right' field.
      * @param value The value of 'right'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setRight(java.lang.String value) {
      validate(fields()[5], value);
      this.right = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'right' field has been set.
      * @return True if the 'right' field has been set, false otherwise.
      */
    public boolean hasRight() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'right' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearRight() {
      right = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'rank' field.
      * @return The value.
      */
    public java.lang.String getRank() {
      return rank;
    }

    /**
      * Sets the value of the 'rank' field.
      * @param value The value of 'rank'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setRank(java.lang.String value) {
      validate(fields()[6], value);
      this.rank = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'rank' field has been set.
      * @return True if the 'rank' field has been set, false otherwise.
      */
    public boolean hasRank() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'rank' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearRank() {
      rank = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'matchType' field.
      * @return The value.
      */
    public java.lang.String getMatchType() {
      return matchType;
    }

    /**
      * Sets the value of the 'matchType' field.
      * @param value The value of 'matchType'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setMatchType(java.lang.String value) {
      validate(fields()[7], value);
      this.matchType = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'matchType' field has been set.
      * @return True if the 'matchType' field has been set, false otherwise.
      */
    public boolean hasMatchType() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'matchType' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearMatchType() {
      matchType = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'synonymType' field.
      * @return The value.
      */
    public java.lang.String getSynonymType() {
      return synonymType;
    }

    /**
      * Sets the value of the 'synonymType' field.
      * @param value The value of 'synonymType'.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder setSynonymType(java.lang.String value) {
      validate(fields()[8], value);
      this.synonymType = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'synonymType' field has been set.
      * @return True if the 'synonymType' field has been set, false otherwise.
      */
    public boolean hasSynonymType() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'synonymType' field.
      * @return This builder.
      */
    public org.gbif.pipelines.io.avro.ALATaxonRecord.Builder clearSynonymType() {
      synonymType = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ALATaxonRecord build() {
      try {
        ALATaxonRecord record = new ALATaxonRecord();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.lsid = fieldSetFlags()[1] ? this.lsid : (java.lang.String) defaultValue(fields()[1]);
        record.cleanName = fieldSetFlags()[2] ? this.cleanName : (java.lang.String) defaultValue(fields()[2]);
        record.acceptedLsid = fieldSetFlags()[3] ? this.acceptedLsid : (java.lang.String) defaultValue(fields()[3]);
        record.left = fieldSetFlags()[4] ? this.left : (java.lang.String) defaultValue(fields()[4]);
        record.right = fieldSetFlags()[5] ? this.right : (java.lang.String) defaultValue(fields()[5]);
        record.rank = fieldSetFlags()[6] ? this.rank : (java.lang.String) defaultValue(fields()[6]);
        record.matchType = fieldSetFlags()[7] ? this.matchType : (java.lang.String) defaultValue(fields()[7]);
        record.synonymType = fieldSetFlags()[8] ? this.synonymType : (java.lang.String) defaultValue(fields()[8]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ALATaxonRecord>
    WRITER$ = (org.apache.avro.io.DatumWriter<ALATaxonRecord>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ALATaxonRecord>
    READER$ = (org.apache.avro.io.DatumReader<ALATaxonRecord>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
