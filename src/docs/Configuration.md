# Configuration

The code generation is configured via options that are provided via a properties file.

By default, the properties for an input file `some/path/openapi.yaml` are read from `some/path/openapi.properties`.

The options are grouped into three sections:

 * [Parser options](#parser-options)       - control how the OpenApi model is "parsed" into the local data model.
 * [Generator options](#generator-options) - control how the output source code is rendered.
 * [Naming options](#naming-options)       - allows (some) control of how things in the output are named.

*Note that the example references are missing/wrong*

## Parser options


**parser-fixup-void-200-to-204**

>This option allows changing a 200-response that has no declared return type to a 204-response.

>
    default value: false

**parser-localdate-is-jse**

>This option allows parsing of the component schema `LocalDate` to be treated by the generator as Java SE `java.time.LocalDate`.

>It can be disabled if your remote connection uses the type name `LocalDate` for something bespoke.

>
    default value: true

**parser-localdatetime-is-jse**

>This option allows parsing of the component schema `LocalDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

>It can be disabled if your remote connection uses the type name `LocalDateTime` for something bespoke.

>
    default value: true

**parser-offsetdatetime-is-jse**

>This option allows parsing of the component schema `OffsetDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

>It can be disabled if your remote connection uses the type name `OffsetDateTime` for something bespoke.

>
    default value: true

**parser-uuid-is-jse**

>This option allows parsing of the component schema `UUID` to be treated by the generator as Java SE `java.util.UUID`.

>It can be disabled if your remote connection uses the type name `UUID` for something bespoke.

>
    default value: true

**parser-zoneddatetime-is-jse**

>This option allows parsing of the component schema `ZonedDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

>It can be disabled if your remote connection uses the type name `ZonedDateTime` for something bespoke.

>
    default value: true


**parser-localtime-is-jse**

>While there is no local-time definition in the [OpenApi spec](https://swagger.io/specification/#data-types),
>the Quarkus open-api extension will output LocalTime types like this:

>
    LocalTime:
      format: local-time
      type: string
      externalDocs:
        description: As defined by 'partial-time' in RFC3339
        url: https://xml2rfc.ietf.org/public/rfc/html/rfc3339.html#anchor14
      example: 13:45.30.123456789

>This option allows parsing of the component schema `LocalTime` to be treated by the generator as Java SE `java.time.LocalTime`.

>It can be disabled if your remote connection uses the type name `LocalTime` for something bespoke.
    
>
    default value: true


## Generator options


**generator-api-package**

>Name of package to generate API classes in.

>Required option, but can be set via the CLI argument `--api-package`.

**generator-dto-package**

>Name of package to generate DTO classes in.

>Required option, but can be set via the CLI argument `--dto-package`.

**generator-jackson-codehaus**

>Use jackson (codehaus) annotations in generated classes.
>
    default value: false

**generator-jackson-fasterxml**

>Use jackson (fasterxml) annotations in generated classes.
>
    default value: false

**generator-jackson-json-serialize-options**

>Allows you to add (jackson) json serialize options to the DTOs.

>These are also appended to custom date serializer annotations (to prevent
>them from being disabled).

>See [example](./src/test/java/mada/tests/e2e/opts/generator/jackson)
>
    default value:

**generator-jackson-localdate-deserializer**

>Allows you specify a custom LocalDate deserializer class (use a fully qualified class name).

>The default value will also cause generation of a generic LocalDate deserializer that uses `generator-jackson-localdate-wire-format`.

>
    default value: _LocalDateJacksonDeserializer

**generator-jackson-localdate-serializer**

>Allows you specify a custom LocalDate serializer class (use a fully qualified class name).

>The default value will also cause generation of a generic LocalDate serializer that uses `generator-jackson-localdate-wire-format`.

>
    default value: _LocalDateJacksonSerializer

**generator-jackson-localdate-wire-format**

>Allows you specify a LocalDate wire format that is used with a standard de/serializer.

>The specified value is used as a constant/factory method on DateTimeFormatter in the de/serializer classes.

>See [example](./src/test/java/mada/tests/e2e/opts/generator/localdate)
>
    default value: ISO_LOCAL_DATE

**generator-jsonb**

>Use jsonb annotations in generated classes.
>
    default value: false


**generator-map-external-types**

>Allows you to map types in the OpenApi document to other packages, suppressing generation of DTOs for these types.

>This can be useful for referencing common types that are distributes by other means.

>Format:
>  packageA:[typeA, typeB,...]; packageB:[typeC, typeD, ...]


>
    default value:

**generator-mp-api-register-rest-client**

>Allows you to add @RegisterRestClient to each API resource class. The provided value is used for the `configKey`.

>
    default value:


**generator-use-api-wrapped-primitives**

>Allows you to use primitive wrapped as API parameters instead of primitives.

>This can be required to determine if a parameter is present.

>
    default value: false

**generator-use-bean-validation**

>Allows you to disable the rendering of bean validation annotations.

>
    default value: true

**generator-use-bigdecimal-for-double**

>Allows you to replace double-type properties with `java.math.BigDecimal`.

>The normal getter and setter (getFoo/setFoo) are replaced with BigDecimal-typed variants which are ignored by the serializer.
>Additional double-typed getter and setter methods are added (getFooDouble/setFooDouble).

>See [example](./src/test/java/mada/tests/e2e/opts/generator/bigdecimal_double)

>
    default value: false

**generator-use-boolean-get-prefix**

>Boolean getters are prefixed by 'is' by default. Enable this option to use 'get' instead.

>
    default value: false


**generator-use-empty-collections**

>Allows you to replace properties with (potential) null collections with empty collections.

>The normal getter (getFoo) are will instantiate an empty collection if the property is null.
>An additional getter (getFooNullable) is added which returns the property unaltered.

>See [example](./src/test/java/mada/tests/e2e/opts/generator/collections_empty)

>
    default value: false


**generator-use-localdatetime**

>date-time types are deserialized to OffsetDateTime by default, which matches the information
provided by the [spec](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html).
   
>But your remote connection may not provide the offset information, and/or your software runs
in the same time zone.

>By enabling this option, the generated DTOs will have LocalDateTime for properties
instead of OffsetDateTime.

>
    default value: false

**generator-use-zoneddatetime**

>date-time types are deserialized to OffsetDateTime by default, which matches the information
provided by the [spec](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html).
>	
>But your remote connection may provide additional zone info which allows deserialization to
ZonedDateTime (depending on the deserializer implementation).
>	
>For example, `io.quarkus:quarkus-resteasy-jsonb` will serialize ZonedDateTime to:
>	
    `"2022-01-02T12:28:36.639812723+01:00[Europe/Copenhagen]"`
>	
>By enabling this option, the generated DTOs will have ZonedDateTime for properties
instead of OffsetDateTime.

>
    default value: false

**generator-use-generated-timestamp**

>Allows you to include a timestamp in the @Generated-annotation in all generated classes.

>
    default value: false

## Naming options

The naming of types, properties and enumeration entries can be (partly) controlled via some operators.

`TYPENAME` and `PROPERTYNAME` are based on the [Java spec for identifiers](https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8). They will convert any non-identifier character to '_'. A hyphen ('-') will be removed and the next character upper-cased.

The `-EDGE` variants will downcase all letters, except on edges between upper/down-case.
For example (for properties): `fooBAR -> fooBar`, `FOOBar -> fooBar`, and `FOOBAR -> foobar`.

    UPCASE: Converts the input to upper case.
    DOWNCASE: Converts the input to lower case.
    LITERAL/value/: Returns the provided value.
    TYPENAME: Converts the input to a valid java identifier (first letter upper case)
    TYPENAME-EDGE: Converts the input to a valid java identifier (first letter upper case, downcase on edges)
    PARAMETERNAME: Converts the input to a valid java identifier (first letter lower case)
    PARAMETERNAME-EDGE: Converts the input to a valid java identifier (first letter lower case, downcase on edges)
    PROPERTYNAME: (alias for PARAMETERNAME)
    PROPERTYNAME-EDGE: (alias for PARAMETERNAME-EDGE)
    REGEXP/pattern/replacement/: Will match input against pattern and substitute all matches with replacement.

You can specify a number of operators, separated by ';'. They will be applied left-to-right.

**naming-enum-prefix-number**

>Allows you to replace the prefix used in enum naming of numbers.
>This one overrules naming-rules-enum

>
    default value: NUMBER_


**naming-rules-enum-constant**

>Allows you to control the naming of enumeration constants using the operators described above.

>The type name is given as input.

>
    default value: TYPENAME; UPCASE

**naming-rules-entity**

>Allows you to control the naming of the entity parameter in APIs using the operators described above.

>The type name is given as input.

>
    default value: LITERAL/dto/

**naming-rules-parameter**

>Allows you to control the naming of parameters using the operators described above.

>The parameter name is given as input.

>
    default value: PARAMETERNAME

**naming-rules-property**

>Allows you to control the naming of properties using the operators described above.

>The property name is given as input.

>
    default value: PROPERTYNAME

**naming-rules-type**

>Allows you to control the naming of types using the operators described above.

>The type name is given as input.

>
    default value: TYPENAME

