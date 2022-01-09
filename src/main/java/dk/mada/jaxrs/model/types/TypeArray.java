package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.Stream;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

@Immutable
public interface TypeArray extends Type {
	public static TypeArray of(Types types, Type innerType) {
		return ImmutableTypeArray.builder().types(types).innerType(innerType).build();
	}
	
	Type innerType();
	Types types();
	
	@Override
	default TypeName typeName() {
		String innerName = mappedInnerType().wrapperTypeName().name();
		return TypeNames.of("List<" + innerName + ">");
	}

	@Override
	default Set<String> neededImports() {
		return Stream.concat(
				mappedInnerType().neededImports().stream(),
				Stream.of("java.util.List", "java.util.ArrayList"))
			.collect(toSet());
	}

	default Type mappedInnerType() {
		return types().map(innerType());
	}
}
