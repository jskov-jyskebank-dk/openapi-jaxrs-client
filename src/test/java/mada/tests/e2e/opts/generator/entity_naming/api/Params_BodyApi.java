/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.entity_naming.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.opts.generator.entity_naming.dto.Simple;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/body")
public interface Params_BodyApi {

  /**
   * apiParamsBodyBooleanPrimitiveGet
   *
   * @param boolean_  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-primitive")
  @APIResponseSchema(String.class)
  String apiParamsBodyBooleanPrimitiveGet(boolean boolean_);

  /**
   * apiParamsBodyBooleanWrapperGet
   *
   * @param boolean_  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/boolean-wrapper")
  @APIResponseSchema(String.class)
  String apiParamsBodyBooleanWrapperGet(boolean boolean_);

  /**
   * apiParamsBodyDateGet
   *
   * @param localDate  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/date")
  @APIResponseSchema(String.class)
  String apiParamsBodyDateGet(LocalDate localDate);

  /**
   * apiParamsBodyDateTimeGet
   *
   * @param offsetDateTime  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/date-time")
  @APIResponseSchema(String.class)
  String apiParamsBodyDateTimeGet(OffsetDateTime offsetDateTime);

  /**
   * apiParamsBodyListGet
   *
   * @param list_String_  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/list")
  @APIResponseSchema(String.class)
  String apiParamsBodyListGet(List<String> list_String_);

  /**
   * apiParamsBodyListSimpleGet
   *
   * @param list_Simple_  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/list-simple")
  @APIResponseSchema(String.class)
  String apiParamsBodyListSimpleGet(List<Simple> list_Simple_);

  /**
   * apiParamsBodyMixedInPathGet
   *
   * @param inPath  (required)
   * @param query  (optional)
   * @param item  (optional)
   * @param simple  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/mixed/{in-path}")
  @APIResponseSchema(String.class)
  String apiParamsBodyMixedInPathGet(@PathParam("in-path") String inPath, @QueryParam("query") String query, @HeaderParam("item") List<String> item, Simple simple);

  /**
   * apiParamsBodySimpleGet
   *
   * @param simple  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/simple")
  @APIResponseSchema(String.class)
  String apiParamsBodySimpleGet(Simple simple);

  /**
   * apiParamsBodyTimeGet
   *
   * @param localTime  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/time")
  @APIResponseSchema(String.class)
  String apiParamsBodyTimeGet(LocalTime localTime);
}
