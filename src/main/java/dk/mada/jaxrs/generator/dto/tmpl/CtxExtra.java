package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.SortedSet;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling an extra template.
 */
@Immutable
public interface CtxExtra {
    /** {@return a builder for this type} */
    static ImmutableCtxExtra.Builder builder() {
        return ImmutableCtxExtra.builder();
    }

    String appName();
    String version();
    @Nullable
    String appDescription();
    @Nullable
    String infoEmail();

    SortedSet<String> getImports();
    default boolean hasImports() {
        return !getImports().isEmpty();
    }

    String packageName();

    boolean jacksonCodehaus();
    boolean jacksonFasterxml();
    boolean jsonb();

    String generatorClass();
    @Nullable
    String generatedDate();

    default boolean hideGenerationTimestamp() {
        return generatedDate() == null;
    }

    @Nullable
    String cannedLocalDateSerializerDTF();
}
