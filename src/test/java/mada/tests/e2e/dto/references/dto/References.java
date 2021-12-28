/*
 * openapi-examples API
 * 
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 * 
 *
 * This class was auto generated by openapi-jaxrs-client (https://github.com/jskov/openapi-jaxrs-client).
 * Do not edit the class manually.
 */

package mada.tests.e2e.dto.references.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * References
 */
public class References   {
  private Simple simple;

  public References simple(Simple simple) {
    this.simple = simple;
    return this;
  }

  /**
   * Get simple
   * @return simple
   **/
  @ApiModelProperty(value = "")
  
  public Simple getSimple() {
    return simple;
  }

  public void setSimple(Simple simple) {
    this.simple = simple;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    References other = (References) o;
    return Objects.equals(this.simple, other.simple);
  }

  @Override
  public int hashCode() {
    return Objects.hash(simple);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class References {\n");
    
    sb.append("    simple: ").append(toIndentedString(simple)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

