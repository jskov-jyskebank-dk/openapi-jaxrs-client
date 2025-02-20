/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jsonb.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * NumberEnum
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.enums.jsonb.dto.NumberEnum.NumberEnumAdapter.class)
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public enum NumberEnum {
  NUMBER_1(1),
  NUMBER_2(2);

  private final int value;

  NumberEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class NumberEnumAdapter implements JsonbAdapter<NumberEnum, JsonString> {
      @Override
      public JsonString adaptToJson(NumberEnum e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public NumberEnum adaptFromJson(JsonString value) throws Exception {
          for (NumberEnum b : NumberEnum.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type NumberEnum");
      }
  }
}
