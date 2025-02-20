/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.validation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ValidationDto
 */
@JsonbPropertyOrder({
  ValidationDto.JSON_PROPERTY_NAME,
  ValidationDto.JSON_PROPERTY_INT_VALUE,
  ValidationDto.JSON_PROPERTY_PATTERN,
  ValidationDto.JSON_PROPERTY_VALID_OBJECTS,
  ValidationDto.JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class ValidationDto   {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true)
  private String name;

  public static final String JSON_PROPERTY_INT_VALUE = "intValue";
  @JsonbProperty(JSON_PROPERTY_INT_VALUE)
  private Integer intValue;

  public static final String JSON_PROPERTY_PATTERN = "pattern";
  @JsonbProperty(JSON_PROPERTY_PATTERN)
  private String pattern;

  public static final String JSON_PROPERTY_VALID_OBJECTS = "validObjects";
  @JsonbProperty(JSON_PROPERTY_VALID_OBJECTS)
  private List<Simple> validObjects = null;

  public static final String JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE = "primitivesShouldNotHaveValidate";
  @JsonbProperty(JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE)
  private List<Boolean> primitivesShouldNotHaveValidate = null;

  public ValidationDto name(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @NotNull @Size(min = 1, max = 50)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
  }

  public ValidationDto intValue(Integer intValue) {
    this.intValue = intValue;
    return this;
  }

  /**
   * Get intValue
   * minimum: 10
   * maximum: 20
   * @return intValue
   **/
  @Min(10) @Max(20)
  public Integer getIntValue() {
    return intValue;
  }

  public void setIntValue(Integer intValue) {
    this.intValue = intValue;
  }

  public ValidationDto pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  /**
   * Get pattern
   * @return pattern
   **/
  @Pattern(regexp = "^[a-zA-Z]{0,3}$")
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public ValidationDto validObjects(List<Simple> validObjects) {
    this.validObjects = validObjects;
    return this;
  }

  public ValidationDto addValidObjectsItem(Simple validObjectsItem) {
    if (this.validObjects == null) {
      this.validObjects = new ArrayList<>();
    }
    this.validObjects.add(validObjectsItem);
    return this;
  }

  /**
   * Get validObjects
   * @return validObjects
   **/
  @Valid
  public List<Simple> getValidObjects() {
    return validObjects;
  }

  public void setValidObjects(List<Simple> validObjects) {
    this.validObjects = validObjects;
  }

  public ValidationDto primitivesShouldNotHaveValidate(List<Boolean> primitivesShouldNotHaveValidate) {
    this.primitivesShouldNotHaveValidate = primitivesShouldNotHaveValidate;
    return this;
  }

  public ValidationDto addPrimitivesShouldNotHaveValidateItem(boolean primitivesShouldNotHaveValidateItem) {
    if (this.primitivesShouldNotHaveValidate == null) {
      this.primitivesShouldNotHaveValidate = new ArrayList<>();
    }
    this.primitivesShouldNotHaveValidate.add(primitivesShouldNotHaveValidateItem);
    return this;
  }

  /**
   * Get primitivesShouldNotHaveValidate
   * @return primitivesShouldNotHaveValidate
   **/
  public List<Boolean> getPrimitivesShouldNotHaveValidate() {
    return primitivesShouldNotHaveValidate;
  }

  public void setPrimitivesShouldNotHaveValidate(List<Boolean> primitivesShouldNotHaveValidate) {
    this.primitivesShouldNotHaveValidate = primitivesShouldNotHaveValidate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidationDto other = (ValidationDto) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.intValue, other.intValue) &&
        Objects.equals(this.pattern, other.pattern) &&
        Objects.equals(this.validObjects, other.validObjects) &&
        Objects.equals(this.primitivesShouldNotHaveValidate, other.primitivesShouldNotHaveValidate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, intValue, pattern, validObjects, primitivesShouldNotHaveValidate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationDto {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    intValue: ").append(toIndentedString(intValue));
    sb.append("\n    pattern: ").append(toIndentedString(pattern));
    sb.append("\n    validObjects: ").append(toIndentedString(validObjects));
    sb.append("\n    primitivesShouldNotHaveValidate: ").append(toIndentedString(primitivesShouldNotHaveValidate));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
